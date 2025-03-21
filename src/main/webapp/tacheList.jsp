<%@ page import="com.example.gestion_construction.model.Tache" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: khadija
  Date: 19/03/2025
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,600,700&display=swap" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" />
    <title>Title</title>
</head>
<body class="sub_page">
<div class="hero_area">
    <jsp:include page="header.jsp"/>
</div>

<h2>Liste des Taches</h2>
<a href="tache-servlet?action=ajouter-tache" class="btn btn-primary">Ajouter</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Description</th>
        <th>Date de Début</th>
        <th>Date de Fin</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the list of projets from the request attribute
        List<Tache> taches = (List<Tache>) request.getAttribute("listTaches");
        if (taches != null) {
            for (Tache tache : taches) {
    %>
    <tr>
        <td><%= tache.getIdT() %></td>
        <td><%= tache.getNomT() %></td>
        <td><%= tache.getDescriptionT() %></td>
        <td><%= tache.getDateDebutT() %></td>
        <td><%= tache.getDateFinT() %></td>
        <td>
            <a href="tache-servlet?action=delete-tache&idT=<%= tache.getIdT() %>" class="btn btn-danger">Supprimer</a>
            <a href="tache-servlet?action=edit-tache&idT=<%= tache.getIdT()%>" class="btn btn-dark">Modifier</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="7">Aucune tache trouvé.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
