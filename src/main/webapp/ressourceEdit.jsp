<%@ page import="com.example.gestion_construction.model.Ressource" %>
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
    Ressource ressource = (Ressource) request.getAttribute("ressource");
%>

<h2>Modifier Ressource</h2>
<form action="ressource-servlet?action=update-ressource" method="post">
    <input type="hidden" name="idR" value="<%= ressource.getIdR() %>">
    <div class="form-group">
        <label for="nomR">Nom du ressource</label>
        <input type="text" class="form-control" id="nomR" name="nomR" value="<%= ressource.getNomR()%>">
    </div>
    <div class="form-group">
        <label for="type">Type</label>
        <input type="text" class="form-control" id="type" name="type" value="<%= ressource.getType()%>">
    </div>
    <div class="form-group">
        <label for="quantite">Quantite</label>
        <input type="number" class="form-control" id="quantite" name="quantite" value="<%= ressource.getQuantite()%>">
    </div>

    <button type="submit" class="btn btn-primary">Mettre à jour</button>
</form>

<jsp:include page="footer.jsp"/>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
