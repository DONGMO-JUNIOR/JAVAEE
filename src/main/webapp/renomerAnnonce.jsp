<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Renommer Annonces</title>
    <link rel="stylesheet" href="vendors/styles/core.css" />
    <link rel="stylesheet" href="vendors/styles/icon-font.min.css" />
    <link rel="stylesheet" href="vendors/styles/style.css" />
    <link rel="stylesheet" href="assets/css/style.css"/>
    <style>
        .input-group {
            position: relative;
        }

        .invalid-message {
            color: red;
            font-size: 12px;
            position: absolute;
            bottom: -15px;
            left: 0;
            display: none;
        }

        .invalid {
            border: 1px solid red;
        }
    </style>
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
                            <h2 class="text-center text-primary">RENOMMER UNE ANNONCE</h2>
                        </div>
                        <form action="AnnonceServlet" method="post">
                            <input type="hidden" name="id" value="${annonce.id}" />
                            <input type="hidden" name="operation" value="${empty annonce.id ? 'add' : 'edit'}" />
                            <div class="input-group custom">
                                <input type="text" name="titre" class="form-control form-control-lg" placeholder="Titre de l'annonce" value="${annonce.titre}" required />
                            </div>
                            <div class="input-group custom">
                                <input type="text" name="categorie" class="form-control form-control-lg" placeholder="Categorie de l'annonce" value="${annonce.categorie}" required />
                            </div>
                            <div class="input-group custom">
                                <textarea name="contenu" class="form-control form-control-lg" placeholder="Entrez votre annonce" rows="4" required>${annonce.contenu}</textarea>
                            </div>
                            <div class="input-group custom">
                                <input type="date" name="startDate" class="form-control form-control-lg" placeholder="Date de début" value="${annonce.startDate}" required />
                            </div>
                            <div class="input-group custom">
                                <input type="date" name="endDate" class="form-control form-control-lg" placeholder="Date de fin" value="${annonce.endDate}" required />
                                <span class="invalid-message">La date de fin doit être postérieure à la date de début.</span>
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
    <script>
        function validateDates() {
            var startDateInput = document.querySelector('input[name="startDate"]');
            var endDateInput = document.querySelector('input[name="endDate"]');
            var startDate = new Date(startDateInput.value);
            var endDate = new Date(endDateInput.value);

            if (endDate <= startDate) {
                endDateInput.classList.add('invalid');
                endDateInput.nextElementSibling.style.display = 'block';
                return false;
            } else {
                endDateInput.classList.remove('invalid');
                endDateInput.nextElementSibling.style.display = 'none';
                return true;
            }
        }

        var form = document.querySelector('form');
        form.addEventListener('submit', function(event) {
            if (!validateDates()) {
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
