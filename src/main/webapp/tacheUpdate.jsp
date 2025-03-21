<%@ page import="com.example.gestion_construction.model.Tache" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,600,700&display=swap" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/responsive.css" rel="stylesheet" />
    <title>Title</title>
</head>
<body class="sub_page">
<div class="hero_area">
    <jsp:include page="header.jsp"/>
</div>
<%
    Tache tache = (Tache) request.getAttribute("tache");
%>

<h2>Modifier Tache</h2>
<form action="tache-servlet" method="post">
    <input type="hidden" name="idT" value="<%= tache.getIdT() %>">
    <div class="form-group">
        <label for="nomT">Nom du Tache</label>
        <input type="text" class="form-control" id="nomT" name="nomT" value="<%= tache.getNomT() %>">
    </div>
    <div class="form-group">
        <label for="descriptionT">Description</label>
        <textarea class="form-control" id="descriptionT" name="descriptionT"><%= tache.getDescriptionT() %></textarea>
    </div>
    <div class="form-group">
        <label for="dateDebutT">Date de Début</label>
        <input type="date" class="form-control" id="dateDebutT" name="dateDebutT" value="<%= tache.getDateDebutT() %>">
    </div>
    <div class="form-group">
        <label for="dateFinT">Date de Fin</label>
        <input type="date" class="form-control" id="dateFinT" name="dateFinT" value="<%= tache.getDateFinT() %>">
    </div>
    <input type="hidden" name="action" value="update-tache">
    <button type="submit" class="btn btn-primary">Mettre à jour</button>
</form>

<jsp:include page="footer.jsp"/>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
