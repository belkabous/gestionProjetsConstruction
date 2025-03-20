<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gestion_construction.model.Projet" %>

<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

  <title> Brincht </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,600,700&display=swap" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body class="sub_page">
<div class="hero_area">
  <jsp:include page="header.jsp"/>
</div>

<h2>Liste des Projets</h2>
<a href="ProjetServlet?action=ajouter-projet" class="btn btn-primary">Ajouter</a>
<table class="table">
  <thead>
  <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Description</th>
    <th>Date de Début</th>
    <th>Date de Fin</th>
    <th>Budget</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <%
    // Retrieve the list of projets from the request attribute
    List<Projet> projets = (List<Projet>) request.getAttribute("listProjets");
    if (projets != null) {
      for (Projet projet : projets) {
  %>
  <tr>
    <td><%= projet.getIdP() %></td>
    <td><%= projet.getNomP() %></td>
    <td><%= projet.getDescriptionP() %></td>
    <td><%= projet.getDateDebutP() %></td>
    <td><%= projet.getDateFinP() %></td>
    <td><%= projet.getBudget() %></td>
    <td>
      <a href="ProjetServlet?action=delete-projet&idP=<%= projet.getIdP() %>" class="btn btn-danger">Supprimer</a>
      <a href="ProjetServlet?action=edit-projet&idP=<%= projet.getIdP()%>" class="btn btn-dark">Modifier</a>
    </td>
  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td colspan="7">Aucun projet trouvé.</td>
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