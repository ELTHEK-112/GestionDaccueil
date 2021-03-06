<%@page import="javax.print.attribute.standard.Severity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.sql.*"
	import="models.*" import="modelsDbUtil.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title>Form Visit | Creative - MedAli_Karim</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link href="css/bootstrap-datepicker.css" rel="stylesheet" />
<link href="css/daterangepicker.css" rel="stylesheet" />
<!--external css-->
<!-- font icon -->
<link href="css/elegant-icons-style.css" rel="stylesheet" />
<link href="css/font-awesome.min.css" rel="stylesheet" />
<!-- Custom styles -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->

<!-- =======================================================
      Theme Name: NiceAdmin
      Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
      Author: BootstrapMade
      Author URL: https://bootstrapmade.com
    ======================================================= -->
</head>

<body>
	<!-- container section start -->
	<section id="container" class="">
		<!--header start-->
		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips"
					data-original-title="Toggle Navigation" data-placement="bottom">
					<i class="icon_menu"></i>
				</div>
			</div>

			<!--logo start-->
			<a href="indexAccuei.jsp" class="logo">Nice <span class="lite">Admin</span></a>
			<!--logo end-->

			<div class="nav search-row" id="top_menu">
				<!--  search form start -->
				<ul class="nav top-menu">
					<li>
						<form class="navbar-form">
							<input class="form-control" placeholder="Search" type="text">
						</form>
					</li>
				</ul>
				<!--  search form end -->
			</div>

			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">

					<!-- task notificatoin start -->

					
						  <%   
						  Responsible rsp = (Responsible)  session.getAttribute("rspo"); 
						  Division srv = (Division) session.getAttribute("divs");
          
          %>
					<!-- alert notification end-->
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <span class="username">
								<%
									out.print(rsp.getNom() + " " + rsp.getPrenom() + "[" + srv.getNom() + "]");
								%>
						</span> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">


							<li><a href="login.jsp?id=<%=rsp.getID() %>"><i class="icon_key_alt"></i> Log
									Out</a></li>

						</ul></li>
					<!-- user login dropdown end -->
				</ul>
				<!-- notificatoin dropdown end-->
			</div>
		</header>
		<!--header end-->

		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu">
					<li class="active"><a class="" href="indexAccuei.jsp"> <i
							class="icon_house_alt"></i> <span>Dashboard</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_document_alt"></i> <span>Forms Getion</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">

							<li><a class="" href="form_visit.jsp">Form Visite</a></li>
							<li><a class="" href="form_visitor.jsp">Form Visitor</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_table"></i> <span>Tables Getion</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="basic_visits.jsp">Les Visites</a></li>
							<li><a class="" href="basic_Visitor.jsp">Les Visitor</a></li>
						</ul></li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-files-o"></i> Form Visite
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="indexAccuei.jsp">Home</a></li>
							<li><i class="icon_document_alt"></i>Forms Getion</li>
							<li><i class="fa fa-files-o"></i>Form Visite</li>
						</ol>
					</div>
				</div>
				<!-- Form validations -->
				<header class="panel-heading"> Ajouter une Visite : </header>
				<div class="panel-body">
					<div class="form">
						<form class="form-validate form-horizontal " id="register_form"
							method="get" action="visitControler">
							<input type="hidden" value="2" name="command">
							<div class="form-group ">
								<label for="Etat" class="control-label col-lg-2">Etat :
									<span class="required">*</span>
								</label>
								<div class="col-lg-10">
									<input class="form-control" id="etat" name="etat" type="text" />
								</div>
							</div>
							<div class="form-group">
								<label for="DateVisit" class="control-label col-lg-2">Date
									Visit : <span class="required">*</span>
								</label>
								<div class="col-lg-10">
									<input id="DateVisi" name="DateVisi" type="date" size="16"
										class="form-control">
								</div>
							</div>
							<div class="form-group ">
								<label for="" class="control-label col-lg-2">Visite
									ID: <span class="required">*</span>
								</label>
								<%
                       try{
                    	   ResultSet re = SingleConnection.readQury("select MAX(ID) from responsible");
                             while(re.next()){
                                         
                                              int id =1+re.getInt(1);
                      
                      %>
								<div class="col-lg-10">
									<input  name="idvsit" type="text" readonly class="form-control" value="<%=id %>"/>
										<% 
                             }
                             }catch(SQLException ex){}
                        
                        
                        %>
								</div>
							</div>
							
							<div class="form-group ">
								<label for="Visitor" class="control-label col-lg-2">
									Division : <span class="required">*</span>
								</label>
								<div class="col-lg-10">
									<select class="form-control m-bot15" name="division">
										<%
											ArrayList<Division> divisions = DivisionDbUtil.getAll();
											for (Division division : divisions) {
												if(division.getID() != srv.getID() && division.getID() != 1){
										%>
										<option value="<%out.print(division.getID());%>">
											<%
												out.print(division.getNom());
											%>
										</option>
										<%
											}}
										%>
									</select>
								</div>
							</div>

							<div class="form-group ">
								<label for="Visitor" class="control-label col-lg-2">Visitor
									: <span class="required">*</span>
								</label>
								<div class="col-lg-10">
									<select class="form-control m-bot15" name="visitor">
										<%
											ArrayList<Visitor> visitor = VisitorDbUtil.getAll();
											for (Visitor vstor : visitor) {
										%>
										<option value="<%out.print(vstor.getID());%>">
											<%
												out.print(vstor.getNom() + " " + vstor.getPrenom());
											%>
										</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<button class="btn btn-primary" type="submit">Save</button>
									<button class="btn btn-default" type="button">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>

			<!-- page end-->
		</section>
	</section>
	<!--main content end-->
	<div class="text-right">
		<div class="credits">
			<!--
            All the links in the footer should remain intact.
            You can delete the links only if you purchased the pro version.
            Licensing information: https://bootstrapmade.com/license/
            Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin
          -->
			Designed by <a href="https://bootstrapmade.com/">Creative-MedAli_Karim</a>
		</div>
	</div>

	<!-- container section end -->

	<!-- javascripts -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<!-- jquery validate js -->
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script src="js/daterangepicker.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<!-- custom form validation script for this page-->
	<script src="js/form-validation-script.js"></script>
	<!--custome script for all page-->
	<script src="js/scripts.js"></script>


</body>

</html>
