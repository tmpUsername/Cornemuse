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
        <title>JSP Page</title>
        <c:import url="_HEAD.jsp"/>
    </head>
    <body>
        <menu class="menu">
            <c:import url="_MENU.jsp"/>
        </menu>
        <div class="titre">
            titre
        </div>
        <section>
             <form method="POST">
                <label>Titre:</label>
                <input name="titre" type="text" value="${maSerie.titre}"/>
                <br/>
                <label>Synopsis:</label>
                <textarea name="synopsis">${maSerie.synopsis}</textarea>
                <br/>
                <input type="hidden" value="${maSerie.id}" name="id"/>
                <input type="submit" value="Modifier"/>
            </form>
        </section>
        <footer>
            <c:import url="_PIED.jsp"/>
        </footer>
    </body>
</html>