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
            <h1>Ajouter films</h1>
        </div>
        <section>
            <form method="POST">
                <label>Titre:</label>
                <input name="titre" type="text" />
                <br/>
                <label>Genre:</label>
                <select name="genreID">
                    <c:forEach items="${listeGenres}" var="genreAct">
                        <option value="${genreAct.id}">${genreAct.nom}</option>
                    </c:forEach>
                </select>
                <br/>
                <label>Synopsis:</label>
                <textarea name="synopsis"></textarea>
                <br/>
                <label>Année de production:</label>
                <input name="anneeProd" type="text"/>
                <br/>
                <label>Durée: (en Minutes)</label>
                <input name="duree" type="text"/>
                <br/>
                <input type="submit" value="Ajouter"/>
            </form>
        </section>
        <footer>
            <c:import url="_PIED.jsp"/>
        </footer>
    </body>
</html>