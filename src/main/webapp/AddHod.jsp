<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Add a HOD</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="" class="h1"><b>SSIT</b></a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Add a HOD</p>

      <form action="AddHodServlet" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="firstname" required placeholder="Full name">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
          <input type="number" class="form-control" name="enroll" required placeholder="Enrollment">
          <div class="input-group-append">
            
          </div>
        </div>
        
        <div class="input-group mb-3">
	          <input type="email" class="form-control" name="email" placeholder="Email">
	          <div class="input-group-append">
	            
	          </div>
	        </div>
	        
	        <div class="input-group mb-3">
	          <input type="password" class="form-control" name="password" placeholder="Password">
	          <div class="input-group-append">
	            
	          </div>
	        </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Add</button>
          </div>
          <!-- /.col -->
         </form>
       </div>
      
   </div>
    <!-- /.form-box -->
 </div><!-- /.card -->

<!-- /.register-box -->

<!-- jQuery -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
</body>
</html>
