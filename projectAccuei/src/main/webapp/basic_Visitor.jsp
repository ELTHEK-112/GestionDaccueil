<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="models.*"
	import="modelsDbUtil.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%
Responsible rsp = (Responsible)  session.getAttribute("rspo"); 
Division srv = (Division) session.getAttribute("divs");
%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title>Basic Visites | Creative - MedAli_Karime</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css/bootstrap-theme.css" rel="stylesheet">
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
							
						</form>
					</li>
				</ul>
				<!--  search form end -->
			</div>


			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">

					<!-- inbox notificatoin end -->
					<!-- alert notification start-->
				
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

							<li class="eborder-top">
							<li><a href="login.jsp?id=<%=rsp.getID() %>"><i class="icon_key_alt"></i>
									Log Out</a></li>
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
					<li class=""><a class="" href="indexAccuei.jsp"> <i
							class="icon_house_alt"></i> <span>Dashboard</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_document_alt"></i> <span>Forms</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="form_visit.jsp">Form Visit</a></li>
							<li><a class="" href="form_visitor.jsp">Form Visitor</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_table"></i> <span>Tables de Visits</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="active" href="basic_visits.jsp">Les
									Visites</a></li>
							<li><a class="active" href="basic_Visitor.jsp">Les
									Visitor</a></li>
						</ul></li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-table"></i> Table
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="indexAccuei.jsp">Home</a></li>
							<li><i class="fa fa-table"></i>Table</li>
							<li><i class="fa fa-th-list"></i>Basic Table</li>
						</ol>
						
					</div>
				</div>
	       
				<div class="row">
					<div class="col-lg-12">
					
						<section class="panel">
						
							<header class="panel-heading"> Tout les Visitor </header>


							<table class="table table-striped table-advance table-hover">
								<tbody>
									<tr>
										<th><i class="icon_genius"></i> ID</th>
										<th><i class="icon_profile"></i> Nom</th>
										<th><i class="icon_profile"></i> Prenom</th>
										<th><i class="icon_close_alt2"></i> CIN</th>
										<th><i class="icon_cogs"></i> Action  <a href="#serch" data-toggle="modal"><button type="button" class="btn btn-default">Serch</button></a></th>
									</tr>
									<%
										List re;

										if (request.getAttribute("Visitor") == null) {
											re = VisitorDbUtil.getAll();
										} else {
											re = (ArrayList) request.getAttribute("Visitor");
										}

										for (int i = 0; i < re.size(); i++) {

											Visitor resp = (Visitor) re.get(i);
									%>
									<tr>
										<td>
											<%
												out.print(resp.getID());
											%>
										</td>
										<td>
											<%
												out.print(resp.getNom());
											%>
										</td>
										<td>
											<%
												out.print(resp.getPrenom());
											%>
										</td>
										<td>
											<%
												out.print(resp.getCIN());
											%>
										</td>

										<td>
											  <a href="#delete<%=resp.getID() %>" data-toggle="modal">
                            <button type='button' class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash' aria-hidden='true'><i class="icon_close_alt2"></i></span></button>
                                                    </a>
                                                     <a href="#edit<%=resp.getID() %>" data-toggle="modal">
                            <button type='button' class='btn btn-warning btn-sm'><span class='glyphicon glyphicon-edit' aria-hidden='true'><i class="icon_check_alt2"></i></span></button>
                                   </a>
										</td>
									<td>
				 <div id="delete<%=resp.getID() %>" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <form method="get" action="addVisitorControler">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Delete</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="iddeleted" value="<%=resp.getID() %>">
                                        <input type="hidden" name="idsesion" value="<%=rsp.getID() %>">
                                        <input type="hidden" name="command" value="3">
                                        <div class="alert alert-danger">Are you Sure you want Delete <strong>
                                                <%=resp.getNom()  %> ?</strong> </div>
                                        <div class="modal-footer">
                                            <button type="submit" name="delete" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> YES</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> NO</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div id="serch" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <form method="get" action="addVisitorControler">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Delete</h4>
                                    </div>
                                    <div class="modal-body">
                                     <div class="form-group">
                                            <label class="control-label col-sm-2" for="item_name">SerchByCin:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_name" name="cin"  placeholder="CIN" required autofocus>
                                             </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" name="delete" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> YES</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> NO</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    
                      <div id="edit<%=resp.getID() %>" class="modal fade" role="dialog">
                        <form method="get" action="addVisitorControler" class="form-horizontal" role="form">
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Modifer Visitor :</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="modifvistor" value="<%=resp.getID() %>">
                                        <input type="hidden" name="idsesion" value="<%=rsp.getID() %>">
                                        <input type="hidden" name="command" value="4">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="item_name">Nom :</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_name" name="newnom" value="<%=resp.getNom() %>" placeholder="Item Name" required autofocus>
                                             </div>
                                            <label class="control-label col-sm-2" for="item_code">ID:</label>
                                            <div class="col-sm-4">
                                                <input type="text" readonly class="form-control" id="item_code" name="id" value="<%=resp.getID() %>" placeholder="Item Code" required>
                                             </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="item_description">Prenom:</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="item_description" name="newprenom" placeholder="Description" value="<%=resp.getPrenom() %>">
                                                            
                                                        
                                            </div>
                                            <label class="control-label col-sm-2" for="item_category">CIN:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_category" name="newcin" value="<%=resp.getCIN() %>" placeholder="Category" required>
                                             </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" name="update_item"><span class="glyphicon glyphicon-edit"></span> Edit</button>
                                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
									
				 <div id="delete<%=resp.getID() %>" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <form method="get" action="controlerResponsible">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Delete</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="iddeleted" value="<%=resp.getID() %>">
                                        <input type="hidden" name="idsesion" value="<%=rsp.getID() %>">
                                        <input type="hidden" name="command" value="3">
                                        <div class="alert alert-danger">Are you Sure you want Delete <strong>
                                                <%=resp.getNom()  %> ?</strong> </div>
                                        <div class="modal-footer">
                                            <button type="submit" name="delete" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> YES</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> NO</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                      <div id="edit<%=resp.getID() %>" class="modal fade" role="dialog">
                        <form method="get" action="controlerResponsible" class="form-horizontal" role="form">
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Modifer Responsable :</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="modifrespo" value="<%=resp.getID() %>">
                                        <input type="hidden" name="idsesion" value="<%=rsp.getID() %>">
                                        <input type="hidden" name="command" value="4">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="item_name">Nom :</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_name" name="newnom" value="<%=resp.getNom() %>" placeholder="Item Name" required autofocus>
                                             </div>
                                            <label class="control-label col-sm-2" for="item_code">ID:</label>
                                            <div class="col-sm-4">
                                                <input type="text" readonly class="form-control" id="item_code" name="id" value="<%=resp.getID() %>" placeholder="Item Code" required>
                                             </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="item_description">Prenom:</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" id="item_description" name="newprenom" placeholder="Description" value="<%=resp.getPrenom() %>">
                                                            
                                                        
                                            </div>
                                            <label class="control-label col-sm-2" for="item_category">CIN:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_category" name="newcin" value="<%=resp.getCIN() %>" placeholder="Category" required>
                                             </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" name="update_item"><span class="glyphicon glyphicon-edit"></span> Edit</button>
                                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</section>
					</div>
				</div>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->
		<div class="text-right">
			<div class="credits"></div>
		</div>
	</section>
	<!-- container section end -->
	<!-- javascripts -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- nicescroll -->
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--custome script for all page-->
	<script src="js/scripts.js"></script>


</body>

</html>
