<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Apply For Pass</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="assets/plugins/daterangepicker/daterangepicker.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
    <link rel="stylesheet" href="assets/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
    <!-- Bootstrap4 Duallistbox -->
    <link rel="stylesheet" href="assets/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
    <!-- BS Stepper -->
    <link rel="stylesheet" href="assets/plugins/bs-stepper/css/bs-stepper.min.css">
    <!-- dropzonejs -->
    <link rel="stylesheet" href="assets/plugins/dropzone/min/dropzone.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
	<%
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String today = df.format(d);
	%>
<div class="wrapper">
		<jsp:include page="StudentHeader.jsp"></jsp:include>
		<jsp:include page="StudentSideBar.jsp"></jsp:include>
	<div class="content-wrapper">
	
	<section class="content-header">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-2">
            <h1>Pass Request</h1>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
    <section class="content">
    	<div class="container-fluid">
    		<div class="row">
    			<div class="col-6">
   	
 
    
        
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">Apply For Pass</h3>
                </div>
                <div class="card-body">
                    <!-- Date -->
                    <form action="ApplyForPassServlet" method="post">
                    	<div class="form-group">
                        	<label>Enrollment Number:</label>
                        	<div class="input-group">
                            	<input type="text" class="form-control" readonly="readonly" value="<%=today%>"/>
                            		<div class="input-group-append" data-target="#reservationdate" data-toggle="datetimepicker">
                                		<div class="input-group-text"><i class="fa fa-calendar"></i></div>
                            		</div>
                        	</div>
                    	</div>
                    	<div class="form-group">
                        	<label>Date:</label>
                        	<div class="input-group">
                            	<input type="text" class="form-control" required readonly="readonly" value="<%=today%>"/>
                            		<div class="input-group-append" data-target="#reservationdate" data-toggle="datetimepicker">
                                		<div class="input-group-text"><i class="fa fa-calendar"></i></div>
                            		</div>
                        	</div>
                    	</div>
                    	<label>Time:</label>
                   		<div class="input-group date" id="timepicker"  data-target-input="nearest">
                        	<input type="text" class="form-control"  name="outtime"  data-target="#timepicker" required/>
                        		<div class="input-group-append" data-target="#timepicker" data-toggle="datetimepicker">
                            		<div class="input-group-text"><i class="far fa-clock"></i></div>
                        		</div>
                    	</div>
                    	<label>Reason:</label>
                    	<div class="input-group">
                        	<input type="text" name="reason"  class="form-control" required/>
                    	</div>
                    	<div class="card-footer">
                    		<button type="submit" class="btn btn-primary">Submit</button>
                		</div>
                    </form>
                </div>
                
              </div>
             </div>
    	</div>
    	</div>
        </section>
    </div>
  
 </div>


<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="assets/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="assets/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="assets/plugins/moment/moment.min.js"></script>
<script src="assets/plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- date-range-picker -->
<script src="assets/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap Switch -->
<script src="assets/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- BS-Stepper -->
<script src="assets/plugins/bs-stepper/js/bs-stepper.min.js"></script>
<!-- dropzonejs -->
<script src="assets/plugins/dropzone/min/dropzone.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="assets/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
    $(function () {
        //Initialize Select2 Elements
        $('.select2').select2()

        //Initialize Select2 Elements
        $('.select2bs4').select2({
            theme: 'bootstrap4'
        })
    
        //Date and time picker
        $('#reservationdatetime').datetimepicker({ icons: { time: 'far fa-clock' } });

        $('#reservationtime').daterangepicker({
            timePicker: true,
            timePickerIncrement: 30,
            locale: {
                format: 'MM/DD/YYYY hh:mm A'
            }
        })
        //Timepicker
        $('#timepicker').datetimepicker({
            format: 'LT'
        })
    })
</script>
</body>

</html>