<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean data = (UserBean) request.getAttribute("data");
	%>
<div class="wrapper">
	<jsp:include page="StudentHeader.jsp"></jsp:include>
	<jsp:include page="AdminSideBar.jsp"></jsp:include>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Personal Info</h1>
          </div>
          <div class="col-sm-6">
          </div>
        </div>
        <section class="content">
      		<div class="container-fluid">
      			<div class="row">
          <div class="col-md-4">
            <!-- Widget: user widget style 2 -->
            <div class="card card-widget widget-user-2">
              <!-- Add the bg color to the header using any of the bg-* classes -->
              <div class="widget-user-header bg-warning">
                <div class="widget-user-image">
                  <img class="img-circle elevation-2" src="../dist/img/user7-128x128.jpg" alt="User Avatar">
                </div>
                <!-- /.widget-user-image -->
                <h3 class="widget-user-username"><%=data.getFirstName()%></h3>
              </div>
              <div class="card-footer p-0">
                <ul class="nav flex-column">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      EnrollmentNum <span class="float-right badge bg-primary"><%=data.getEnrollmentNum() %></span>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      Email <span class="float-right badge bg-info"><%=data.getEmail() %></span>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      Phone Number <span class="float-right badge bg-success"><%=data.getPhoneNumber() %></span>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          
          -->
        </div>
      		</div>
      	</section>
      	
      </div><!-- /.container-fluid -->
    </section>
 </div>
</div>
	
</body>
</html>