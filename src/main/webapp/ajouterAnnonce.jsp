<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter Annonces</title>
    <link rel="stylesheet" href="vendors/styles/core.css" />
    <link rel="stylesheet" href="vendors/styles/icon-font.min.css" />
    <link rel="stylesheet" href="vendors/styles/style.css" />
    <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body class="login-page">
    <div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6 col-lg-7">
                    <img src="vendors/images/login-page-img.png" alt="" />
                </div>
                <div class="col-md-6 col-lg-5">
                    <div class="login-box bg-white box-shadow border-radius-10">
                        <div class="login-title">
                            <h2 class="text-center text-primary">AJOUTER UNE ANNONCE</h2>
                        </div>
                        <form action="AnnonceServlet" method="post">
                            <div class="input-group custom">
                                <input type="text" name="titre" class="form-control form-control-lg" placeholder="Titre de l'annonce" required />
                            </div>
                            <div class="input-group custom form-control-lg">
                                <select name="categorie" class="form-control selectpicker" title="Sélectionner la catégorie" required>
                                    <option value="urgence">Urgence</option>
                                    <option value="option2">Option 2</option>
                                    <option value="option3">Option 3</option>
                                    <option value="autres">Autres</option>
                                </select>
                            </div>
                            <div class="input-group custom">
                                <textarea name="contenu" class="form-control form-control-lg" placeholder="Entrez votre annonce" rows="4" required></textarea>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="input-group mb-0">
                                        <button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="vendors/scripts/core.js"></script>
    <script src="vendors/scripts/script.min.js"></script>
    <script src="vendors/scripts/process.js"></script>
    <script src="vendors/scripts/layout-settings.js"></script>
</body>
</html>
