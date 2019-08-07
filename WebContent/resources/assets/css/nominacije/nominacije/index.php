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
          <h2>Tabela nominacija</h2>
          <p>pretrazite nominovanog glumca</p>
          <input type="text" class="form-control" id="search" placeholder="Unesite ime ili prezime glumca">
        </br>
          <button id="filter" class="btn btn-lg btn-danger" onclick="vratiTabeluNominacija()" >Filtriraj</button>
        </br>
        <div id="nominacije"></div>
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
  function vratiTabeluNominacija(){
    var search = $("#search").val();
    $.ajax({
      url: 'pretragaNominacija.php',
      data: "search="+search,
      success: function(podaci){
        $("#nominacije").html(podaci);
      }
    });
  }
  </script>
<script>;
vratiTabeluNominacija()
</script>
</body>

</html>
