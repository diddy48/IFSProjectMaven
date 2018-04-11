package com.app.controller;

import com.app.model.Dipendenti;
import com.app.model.NC;
import com.app.service.DipendentiService;
import com.app.service.NCService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.app.service")
public class MainController {

    @Autowired
    DipendentiService serviceDip;

    @Autowired
    NCService serviceNc;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "This is default page!");
        model.addObject("ncAperte",serviceNc.findNCbyFase("A"));
        model.addObject("ncIntermedie",serviceNc.findNCbyFase("I"));
        model.addObject("ncChiuse",serviceNc.findNCbyFase("C"));
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/showNC/{matricola}", method = RequestMethod.GET)
    public String listNC(@PathVariable("matricola") int matricola, ModelMap model) {
        Dipendenti dipendente = serviceDip.findById(matricola);
        model.addAttribute("dipendente", dipendente);
        model.addAttribute("ncLeader", dipendente.getNcLeader());
        model.addAttribute("ncRichiede", dipendente.getNcRichiede());
        model.addAttribute("ncResponsabile", serviceNc.findNCResponsabileById(matricola));
        model.addAttribute("ncMembro", serviceNc.findNCAppartenereById(matricola));
        return "nc";
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        List<Dipendenti> dipendenti = serviceDip.findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.addObject("dipendenti", dipendenti);
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

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
            error = "Invalid username and password!";
        }

        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }
    

}
