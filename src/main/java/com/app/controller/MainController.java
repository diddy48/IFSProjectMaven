package com.app.controller;

import com.app.model.Dipendenti;
import com.app.model.NC;
import com.app.service.DipendentiService;
import com.app.service.NCService;
import com.app.service.UserService;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.app.service")
public class MainController {

    @Autowired
    DipendentiService serviceDip;

    @Autowired
    NCService serviceNc;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public String defaultPage(ModelMap model) {
        model.addAttribute("ncAperte", serviceNc.findNCbyFase("A"));
        model.addAttribute("ncIntermedie", serviceNc.findNCbyFase("I"));
        model.addAttribute("ncChiuse", serviceNc.findNCbyFase("C"));
        return "home";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)   
    public String adminPage(ModelMap model) {
        List<Dipendenti> dipendenti = serviceDip.findAll();
        model.addAttribute("title", "Spring Security + Hibernate Example");
        model.addAttribute("message", "This page is for ROLE_ADMIN only!");
        model.addAttribute("dipendenti", dipendenti);
        return "adminHome";
    }

    @RequestMapping(value = "/showNC", method = RequestMethod.GET)
    //@ResponseBody
    public String listNC(ModelMap model,Principal principal, @RequestParam(value = "matricola", required = false) String matricola) {
        Dipendenti dipendente;
        if (matricola == null) {
            //org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            dipendente = serviceDip.findByUsername(principal.getName());
            model.addAttribute("dip", dipendente);
        } else {
            dipendente = serviceDip.findById(Integer.parseInt(matricola));
        }
        model.addAttribute("dipendente", dipendente);
        model.addAttribute("ncLeader", dipendente.getNcLeader());
        model.addAttribute("ncRichiede", dipendente.getNcRichiede());
        model.addAttribute("ncResponsabile", serviceNc.findNCResponsabileById(dipendente.getMatricola()));
        model.addAttribute("ncMembro", serviceNc.findNCAppartenereById(dipendente.getMatricola()));
        return "nc";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request, ModelMap model) {
        if (error != null) {
            model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "You are not authorized to access!";
        }

        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(ModelMap model) {
        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addAttribute("username", userDetail.getUsername());
        }
        return "403";
    }

}
