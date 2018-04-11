<%-- 
    Document   : nc
    Created on : 22-mar-2018, 21.37.45
    Author     : roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestione NC: Nc commissionate</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    </head>


    <body>
        <h2>NC del dipendente ${sessionScope.nome}</h2>  

        <c:if test="${!empty ncLeader}">
            <h3>NC di cui è leader</h3>
            <table border="1" cellspacing ="3">
                <tr>
                    <th>Numero NC</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Data Apertura</th>
                    <th>Data Chiusura</th>
                    <th>Priorità</th>
                    <th>Codice Prodotto</th>

                </tr>
                <c:forEach items="${ncLeader}" var="nc">
                    <tr>
                        <td>${nc.numeroNC}</td>
                        <td>${nc.titolo}</td>
                        <td>${nc.descrizione}</td>
                        <td>${nc.dataA}</td>
                        <td>${nc.dataC==null ? "Non definita" : nc.dataC}</td>
                        <td>${nc.priorita=="B" ? "Bassa" : (nc.priorita=="M" ? "Media" : (nc.priorita=="A" ? "Alta" : ""))}</td>
                        <td>${nc.codiceProdotto}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${!empty ncRichiede}">
            <h3>NC che ha richiesto</h3>
            <table border="1" cellspacing ="3">
                <tr>
                    <th>Numero NC</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Data Apertura</th>
                    <th>Data Chiusura</th>
                    <th>Priorità</th>
                    <th>Codice Prodotto</th>

                </tr>
                <c:forEach items="${ncRichiede}" var="nc">
                    <tr>
                        <td>${nc.numeroNC}</td>
                        <td>${nc.titolo}</td>
                        <td>${nc.descrizione}</td>
                        <td>${nc.dataA}</td>
                        <td>${nc.dataC==null ? "Non definita" : nc.dataC}</td>
                        <td>${nc.priorita=="B" ? "Bassa" : (nc.priorita=="M" ? "Media" : (nc.priorita=="A" ? "Alta" : ""))}</td>
                        <td>${nc.codiceProdotto}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${!empty ncResponsabile}">
            <h3>NC di cui è responsabile</h3>
            <table border="1" cellspacing ="3">
                <tr>
                    <th>Numero NC</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Data Apertura</th>
                    <th>Data Chiusura</th>
                    <th>Priorità</th>
                    <th>Codice Prodotto</th>

                </tr>
                <c:forEach items="${ncResponsabile}" var="nc">
                    <tr>
                        <td>${nc.numeroNC}</td>
                        <td>${nc.titolo}</td>
                        <td>${nc.descrizione}</td>
                        <td>${nc.dataA}</td>
                        <td>${nc.dataC==null ? "Non definita" : nc.dataC}</td>
                        <td>${nc.priorita=="B" ? "Bassa" : (nc.priorita=="M" ? "Media" : (nc.priorita=="A" ? "Alta" : ""))}</td>
                        <td>${nc.codiceProdotto}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${!empty ncMembro}">
            <h3>NC a cui fa parte come mebro del team di lavoro</h3>
            <table border="1" cellspacing ="3">
                <tr>
                    <th>Numero NC</th>
                    <th>Titolo</th>
                    <th>Descrizione</th>
                    <th>Data Apertura</th>
                    <th>Data Chiusura</th>
                    <th>Priorità</th>
                    <th>Codice Prodotto</th>

                </tr>
                <c:forEach items="${ncMembro}" var="nc">
                    <tr>
                        <td>${nc.numeroNC}</td>
                        <td>${nc.titolo}</td>
                        <td>${nc.descrizione}</td>
                        <td>${nc.dataA}</td>
                        <td>${nc.dataC==null ? "Non definita" : nc.dataC}</td>
                        <td>${nc.priorita=="B" ? "Bassa" : (nc.priorita=="M" ? "Media" : (nc.priorita=="A" ? "Alta" : ""))}</td>
                        <td>${nc.codiceProdotto}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <a href="<c:url value="/"/>">Logout</a>
    </body>
</html>
