<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Gestione NC: Nc commissionate</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <h1>Benvenuto nel software di gestione delle Non Conformità</h1>
            <!-- https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html per se authority-->
            <sec:authorize access="isAnonymous()">
                <div class="row">
                    <div class="col-md-8">
                        <br/>
                        <h3><a href="<c:url value="/login"/>">Accedi</a> per visualizzare le NC</h3>
                    </div>
                </div>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <div class="row">
                    <div class="col-md-7">
                        <!-- For login user -->
                        <c:url value="/logout" var="logoutUrl" />
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />
                        </form>
                        <script>
                            function formSubmit() {
                                document.getElementById("logoutForm").submit();
                            }
                        </script>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <h2>
                                Utente : ${pageContext.request.userPrincipal.name} | <a
                                    href="javascript:formSubmit()"> Esci</a>
                            </h2>
                        </c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <h3>Nc Aperte</h3>
                        <div class="table-responsive">
                            <c:choose>
                                <c:when test="${not empty ncAperte}">
                                    <table class="table table-striped table-bordered">
                                        <th>Numero NC</th>
                                        <th>Titolo</th>
                                        <th>Descrizione</th>
                                        <th>Data Apertura</th>
                                        <th>Data Chiusura</th>
                                        <th>Priorità</th>
                                        <th>Codice Prodotto</th>

                                        </tr>
                                        <c:forEach items="${ncAperte}" var="nc">
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
                                </c:when>
                                <c:otherwise>
                                    <h4>Non sono presenti NC aperte</h4>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <h3>Nc Intermedie</h3>                        
                        <div class="table-responsive">
                            <c:choose>
                                <c:when test="${not empty ncIntermedie}">
                                    <table class="table table-striped table-bordered">
                                        <th>Numero NC</th>
                                        <th>Titolo</th>
                                        <th>Descrizione</th>
                                        <th>Data Apertura</th>
                                        <th>Data Chiusura</th>
                                        <th>Priorità</th>
                                        <th>Codice Prodotto</th>

                                        </tr>
                                        <c:forEach items="${ncIntermedie}" var="nc">
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
                                </c:when>
                                <c:otherwise>
                                    <h4>Non sono presenti NC intermedie</h4>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <h3>Nc Chiuse</h3>                        
                        <div class="table-responsive">
                            <c:choose>
                                <c:when test="${not empty ncChiuse}">
                                    <table class="table table-striped table-bordered">
                                        <th>Numero NC</th>
                                        <th>Titolo</th>
                                        <th>Descrizione</th>
                                        <th>Data Apertura</th>
                                        <th>Data Chiusura</th>
                                        <th>Priorità</th>
                                        <th>Codice Prodotto</th>

                                        </tr>
                                        <c:forEach items="${ncChiuse}" var="nc">
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
                                </c:when>
                                <c:otherwise>
                                    <h4>Non sono presenti NC chiuse</h4>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </sec:authorize>
            <sec:authorize access="!hasRole('ROLE_ADMIN') && !isAnonymous()">
                <h2>Clicca <a href="<c:url value="/showNC/${dip.matricola}"/>">qui</a> per vedere le tue Non Conformità</h2>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <br/>
                <h2>Clicca <a href="<c:url value="/admin"/>">qui</a> per vedere i Dipedenti</h2>
            </sec:authorize>
        </div>
    </body>
</html>