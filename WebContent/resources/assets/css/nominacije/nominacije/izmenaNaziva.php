<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Nominacije za Oskara</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/responsive-slider.css" rel="stylesheet">
  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="css/style.css" rel="stylesheet">

</head>

<body>


<?php include 'header.php'; ?>

  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="contents">
          <h2>Forma za izmenu</h2>
          <p>izmeni naziv filma</p>

        </br>
        <form method="POST" action="update.php">
          <label for="film">Film</label>
          <select id="film" name="film" class="form-control">
          </select>

          <label for="naziv">Novi naziv filma</label>
          <input type="text" name="naziv" class="form-control" placeholder="Unesite novi naziv filma ">
          </label for="dugme"></label>
          <input type="submit" class="btn btn-lg btn-danger" value="Sacuvaj promene">
        </form>
        </div>
      </div>
    </div>
  </div>

<?php include 'footer.php'; ?>

  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/responsive-slider.js"></script>
  <script src="js/wow.min.js"></script>
  <script>
    wow = new WOW({}).init();
  </script>
  <script>
  function popuniKomboFilm(){
    $.ajax({
      url: 'komboFilm.php',
      success: function(podaci){
        $("#film").html(podaci);
      }
    });
  }
  </script>


  <script>
  popuniKomboFilm();
  </script>

</body>

</html>
