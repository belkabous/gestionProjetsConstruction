
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

  <!-- about section -->

  <section class="about_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-6 ">
          <div class="img_container">
            <div class="img-box">
              <img src="images/a1.jpg" class="about_img1" alt="" />
              <img src="images/a2.jpg" class="about_img2" alt="" />
            </div>
          </div>
        </div>
        <div class="col-md-6 ">
          <div class="detail-box">
            <div class="heading_container ">
              <h2>
                Who Are We?
              </h2>
            </div>
            <p>
              Reprehenderit quia placeat odio. Consequuntur sunt quo expedita a. Ipsam nostrum maxime facere porro nemo itaque beatae, ad voluptate iste placeat debitis dolore asperiores fugiat totam eveniet consequatur natus. Aliquam.
            </p>
            <p>
              Sed alias, labore iusto facilis doloribus fugiat totam officia corporis vitae error, voluptates nihil veniam et dicta eveniet deserunt at delectus placeat eligendi ipsum voluptatibus aliquam tempore molestiae veritatis. Aspernatur.
            </p>
            <div class="btn-box">
              <a href="">
                Read More
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end about section -->

  <jsp:include page="footer.jsp"/>

  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/custom.js"></script>
</body>

</html>