
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | General Form Elements</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-6">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Change Your Password</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form action="ChangeMyPasswordServlet">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Password</label>
                                        <input type="password" required class="form-control" name="password" id="exampleInputEmail1"
                                            placeholder="Enter new password">
                                    </div>
                                    <div class="card-body">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">OTP</label>
                                        <input type="text" class="form-control" name="otp" required id="exampleInputEmail1"
                                            placeholder="Enter OTP">
                                    </div>
                                
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                    <p class="mt-3 mb-1">
        								<a href="EmailForChangeDetailsServlet">Resend OTP</a>
     	 							</p>
     	 						</div>
                                </div>
                               </form>
                              </div>
                             </div>
                            </div>
                            </div>
                            </section>
                            </div>
                                <script src="assets/plugins/jquery/jquery.min.js"></script>
                                <!-- Bootstrap 4 -->
                                <script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
                                <!-- bs-custom-file-input -->
                                <script src="assets/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
                                <!-- AdminLTE App -->
                                <script src="assets/dist/js/adminlte.min.js"></script>
                                <!-- AdminLTE for demo purposes -->
                                <script src="assets/dist/js/demo.js"></script>
                                <!-- Page specific script -->
                                <script>
                                    $(function () {
                                        bsCustomFileInput.init();
                                    });
                                </script>
</body>

</html>