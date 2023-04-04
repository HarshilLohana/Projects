<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">  
  <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="assets/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css"> 
 <link rel="stylesheet" href="assets/plugins/jqvmap/jqvmap.min.css">
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">  
  <link rel="stylesheet" href="assets/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <link rel="stylesheet" href="assets/plugins/daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="assets/plugins/summernote/summernote-bs4.min.css">
<title>Insert title here</title>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<aside class="main-sidebar sidebar-dark-primary elevation-4">
 
        <a href="index3.html" class="brand-link">
          <img src="assets/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
          <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>
    
        <!-- Sidebar -->
        <div class="sidebar os-host os-theme-light os-host-overflow os-host-overflow-y os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-transition"><div class="os-resize-observer-host observed"><div class="os-resize-observer" style="left: 0px; right: auto;"></div></div><div class="os-size-auto-observer observed" style="height: calc(100% + 1px); float: left;"><div class="os-resize-observer"></div></div><div class="os-content-glue" style="margin: 0px -8px; width: 249px; height: 742px;"></div><div class="os-padding"><div class="os-viewport os-viewport-native-scrollbars-invisible os-viewport-native-scrollbars-overlaid" style="overflow-y: scroll;"><div class="os-content" style="padding: 0px 8px; height: 100%; width: 100%;">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
              <img src="assets/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
              <a href="ShowMyInfoServlet" class="d-block">${firstName }</a>
            </div>
          </div>
    
          <!-- SidebarSearch Form -->
          <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
              <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="btn btn-sidebar" fdprocessedid="445k6d">
                  <i class="fas fa-search fa-fw"></i>
                </button>
              </div>
            </div><div class="sidebar-search-results"><div class="list-group"><a href="#" class="list-group-item"><div class="search-title"><strong class="text-light"></strong>N<strong class="text-light"></strong>o<strong class="text-light"></strong> <strong class="text-light"></strong>e<strong class="text-light"></strong>l<strong class="text-light"></strong>e<strong class="text-light"></strong>m<strong class="text-light"></strong>e<strong class="text-light"></strong>n<strong class="text-light"></strong>t<strong class="text-light"></strong> <strong class="text-light"></strong>f<strong class="text-light"></strong>o<strong class="text-light"></strong>u<strong class="text-light"></strong>n<strong class="text-light"></strong>d<strong class="text-light"></strong>!<strong class="text-light"></strong></div><div class="search-path"></div></a></div></div>
          </div>
    
          <!-- Sidebar Menu -->
          
          <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
              <!-- Add icons to the links using the .nav-icon class
                   with font-awesome or any other icon font library -->
               <li class="nav-item">
            		<a href="StudentDashboardServlet" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Dashboard</p>
            		</a>
          		</li>
               	<li class="nav-item">
            		<a href="ApplyForPass.jsp" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Request for Pass</p>
            		</a>
          		</li>
              	<li class="nav-item">
            		<a href="GetMyRequestServlet" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Get All Requests</p>
            		</a>
          		</li>
          		<li class="nav-item">
            		<a href="EmailForChangeDetail.jsp" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Change Password</p>
            		</a>
          		</li>
          		<li class="nav-item">
            		<a href="EmailForPhoneNumber.jsp" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Change Phone Number</p>
            		</a>
          		</li>
          		<li class="nav-item">
            		<a href="EmailForChangeDetail.jsp" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Change Profile</p>
            		</a>
          		</li>
          		<li class="nav-item">
            		<a href="Login.jsp" class="nav-link">
              			<i class="nav-icon far fa-circle text-danger"></i>
              			<p class="text">Logout</p>
            		</a>
          		</li>
            	
            </ul>      
          </nav>
          <!-- /.sidebar-menu -->
        </div></div></div><div class="os-scrollbar os-scrollbar-horizontal os-scrollbar-unusable os-scrollbar-auto-hidden"><div class="os-scrollbar-track"><div class="os-scrollbar-handle" style="width: 100%; transform: translate(0px, 0px);"></div></div></div><div class="os-scrollbar os-scrollbar-vertical os-scrollbar-auto-hidden"><div class="os-scrollbar-track"><div class="os-scrollbar-handle" style="height: 54.6726%; transform: translate(0px, 0px);"></div></div></div><div class="os-scrollbar-corner"></div></div>
    </aside>
  

<script src="assets/plugins/jquery/jquery.min.js"></script>
<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>

<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/plugins/chart.js/Chart.min.js"></script>
<script src="assets/plugins/sparklines/sparkline.js"></script>
<script src="assets/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="assets/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<script src="assets/plugins/jquery-knob/jquery.knob.min.js"></script>
<script src="assets/plugins/moment/moment.min.js"></script>
<script src="assets/plugins/daterangepicker/daterangepicker.js"></script>
<script src="assets/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<script src="assets/plugins/summernote/summernote-bs4.min.js"></script>
<script src="assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<script src="assets/dist/js/adminlte.js"></script>
<script src="assets/dist/js/demo.js"></script>
<script src="assets/dist/js/pages/dashboard.js">
</script>

</body>
</html>