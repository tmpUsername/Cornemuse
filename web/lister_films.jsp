<%-- 
    Document   : _TEMPLATE
    Created on : 28 sept. 2016, 16:09:14
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste de films - Cornemuse</title>
        <c:import url="_HEAD.jsp"/>
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="titre">
            <h1>Liste de films</h1>
        </div>
        <section>
            <ul>
                <c:forEach items="${mesFilms}" var="monFilm">
                    <li>
                        ${monFilm.titre}
                    </li>
                </c:forEach>
            </ul>
        </section>
        <footer>
            <c:import url="_PIED.jsp"/>
        </footer>
    </body>
</html>