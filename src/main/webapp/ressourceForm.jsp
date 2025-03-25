<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body class="sub_page">

<div class="hero_area">
    <jsp:include page="header.jsp"/>
</div>

<div class="container mt-5">
    <h2>Ajouter</h2>
    <form action="ressource-servlet?action=insert-ressource" method="post">
        <div class="form-group">
            <label for="nomR">Nom du ressource</label>
            <input type="text" class="form-control" id="nomR" name="nomR" required>
        </div>
        <div class="form-group">
            <label for="type">Type de ressource</label>
            <input type="text" class="form-control" id="type" name="type" required>
        </div>
        <div class="form-group">
            <label for="quantite">Quantite de ressource</label>
            <input type="number" class="form-control" id="quantite" name="quantite" required>
        </div>
        <button type="submit" class="btn btn-primary">Enregistrer</button>

    </form>
    <hr>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<jsp:include page="footer.jsp"/>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
