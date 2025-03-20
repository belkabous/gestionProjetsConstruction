<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.gestion_construction.model.Projet" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Modifier Projet</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,600,700&display=swap" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/responsive.css" rel="stylesheet" />
</head>
<body class="sub_page">
<div class="hero_area">
    <jsp:include page="header.jsp"/>
</div>
<%
    Projet projet = (Projet) request.getAttribute("projet");
%>

<h2>Modifier Projet</h2>
<form action="ProjetServlet?action=update" method="post">
    <input type="hidden" name="idP" value="<%= projet.getIdP() %>">
    <div class="form-group">
        <label for="nomP">Nom du Projet</label>
        <input type="text" class="form-control" id="nomP" name="nomP" value="<%= projet.getNomP() %>">
    </div>
    <div class="form-group">
        <label for="descriptionP">Description</label>
        <textarea class="form-control" id="descriptionP" name="descriptionP"><%= projet.getDescriptionP() %></textarea>
    </div>
    <div class="form-group">
        <label for="dateDebutP">Date de Début</label>
        <input type="date" class="form-control" id="dateDebutP" name="dateDebutP" value="<%= projet.getDateDebutP() %>">
    </div>
    <div class="form-group">
        <label for="dateFinP">Date de Fin</label>
        <input type="date" class="form-control" id="dateFinP" name="dateFinP" value="<%= projet.getDateFinP() %>">
    </div>
    <div class="form-group">
        <label for="budget">Budget</label>
        <input type="number" step="0.01" class="form-control" id="budget" name="budget" value="<%= projet.getBudget() %>">
    </div>
    <button type="submit" class="btn btn-primary">Mettre à jour</button>
</form>

<jsp:include page="footer.jsp"/>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>
</body>
</html>