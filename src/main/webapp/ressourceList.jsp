<%@ page import="com.example.gestion_construction.model.Ressource" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <!-- bootstrap core css -->
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

<h2>Liste des Projets</h2>
<a href="ressource-servlet?action=ajouter-ressource" class="btn btn-primary">Ajouter</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Type</th>
        <th>Quantite</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Ressource> ressources = (List<Ressource>) request.getAttribute("listRessources");
        if (ressources != null) {
            for (Ressource ressource : ressources) {
    %>
    <tr>
        <td><%= ressource.getIdR() %></td>
        <td><%= ressource.getNomR() %></td>
        <td><%= ressource.getType() %></td>
        <td><%= ressource.getQuantite() %></td>
        <td>
            <a href="ressource-servlet?action=delete-ressource&idR=<%= ressource.getIdR() %>" class="btn btn-danger">Supprimer</a>
            <a href="ressource-servlet?action=edit-ressource&idR=<%= ressource.getIdR()%>" class="btn btn-dark">Modifier</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="7">Aucun ressource trouvé.</td>
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
