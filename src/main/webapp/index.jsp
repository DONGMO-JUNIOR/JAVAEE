<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="x-ua-compatible" content="ie=edge" />
  <title>Annonces</title>
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />


  <!-- ====================== CSS here ======================= -->

  <link rel="stylesheet" href="assets/css/bootstrap-5.0.0-beta1.min.css" />
  <link rel="stylesheet" href="assets/css/LineIcons.2.0.css" />
  <link rel="stylesheet" href="assets/css/tiny-slider.css" />
  <link rel="stylesheet" href="assets/css/animate.css" />
  <link rel="stylesheet" href="assets/css/lindy-uikit.css" />
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>

<body>
  <div class="preloader">
    <div class="loader">
      <div class="spinner">
        <div class="spinner-container">
          <div class="spinner-rotator">
            <div class="spinner-left">
              <div class="spinner-circle"></div>
            </div>
            <div class="spinner-right">
              <div class="spinner-circle"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <section id="home" class="hero-section-wrapper-5">
   
   <%@ include file="WEB-INF/header.jsp" %>
   
    <div class="hero-section hero-style-5 img-bg" style="background-image: url('assets/img/hero/hero-5/hero-bg.svg')">
      <div class="container">
        <div class="row ">
          <div class="col-lg-6">
            <div class="hero-content-wrapper">
              <h3 class="mb-30 wow fadeInUp align-self-end">Bienvenue sur la page Des Annonces</h2>
                <p class="mb-30 wow fadeInUp align-self-end">Ici vous pouvez  faire des annonces pour pouvoir booster notre plate forme</p>
                <a href="ajouterAnnonce.jsp" class="button button-sm radius-30 ">Faire une annonce</a>
                <a href="ListeAnnoncesServlet" class="button button-sm radius-30  ">Voir les Annonces</a>
            </div>
          </div>
          <div class="col-lg-6 align-self-end">
            <div class="hero-image wow fadeInUp" data-wow-delay=".5s">
              <img src="assets/img/hero/hero-5/hero-img.svg" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <
      <script src="assets/js/bootstrap-5.0.0-beta1.min.js"></script>
      <script src="assets/js/tiny-slider.js"></script>
      <script src="assets/js/wow.min.js"></script>
      <script src="assets/js/main.js"></script>
</body>

</html>