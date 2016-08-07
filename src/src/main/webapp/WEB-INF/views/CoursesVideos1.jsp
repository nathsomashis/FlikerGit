<%@page
	import="org.springframework.web.servlet.ModelAndView,java.util.*,com.fliker.Repository.Courses,com.mongodb.DBObject,org.bson.types.ObjectId"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Jobs</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- #CSS Links -->
<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/bootstrap.min.css" />'>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/font-awesome.min.css" />'>

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/smartadmin-production-plugins.min.css" />'>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/smartadmin-production.min.css" />'>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/smartadmin-skins.min.css" />'>

<!-- SmartAdmin RTL Support -->
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/smartadmin-rtl.min.css" />'>

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css"> -->

<!-- #FAVICONS -->
<link rel="shortcut icon"
	href='<c:url value="/resources/assets/img/favicon/favicon.ico" />'
	type="image/x-icon">
<link rel="icon"
	href='<c:url value="/resources/assets/img/favicon/favicon.ico" />'
	type="image/x-icon">

<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/normalize.css" />'>

<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/assets/css/videoStyle.css" />'>

<!-- #GOOGLE FONT -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

<!-- #APP SCREEN / ICONS -->
<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon"
	href='<c:url value="/resources/assets/img/splash/sptouch-icon-iphone.png" />'>
<link rel="apple-touch-icon" sizes="76x76"
	href='<c:url value="/resources/assets/img/splash/touch-icon-ipad.png" />'>
<link rel="apple-touch-icon" sizes="120x120"
	href='<c:url value="/resources/assets/img/splash/touch-icon-iphone-retina.png" />'>
<link rel="apple-touch-icon" sizes="152x152"
	href='<c:url value="/resources/assets/img/splash/touch-icon-ipad-retina.png" />'>

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image"
	href='<c:url value="/resources/assets/img/splash/ipad-landscape.png" />'
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<link rel="apple-touch-startup-image"
	href='<c:url value="/resources/assets/img/splash/ipad-portrait.png" />'
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href='<c:url value="/resources/assets/img/splash/iphone.png" />'
	media="screen and (max-device-width: 320px)">

</head>
<body class="">

	<!-- #HEADER -->
	<header id="header"> </header>




	<!-- END HEADER -->

	<!-- #NAVIGATION -->
	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->

	<!-- END NAVIGATION -->

	<!-- MAIN PANEL -->
	<div id="main" role="main" style="height: 80%;">

		<!-- RIBBON -->
		<%-- <div id="ribbon">

				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Course</li><li>Skills</li><li>Certification</li>
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability -->

				<!-- Example below: -->

				<!-- <span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

			</div> --%>
		<!-- END RIBBON -->



		<!-- MAIN CONTENT -->
		<div id="content"
			style="padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding: 0px 0px; height: 1000px;">

			<!-- row -->
			<div class="row">

				<!-- col -->
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
					<h1 class="page-title txt-color-blueDark">

						<!-- PAGE HEADER -->
						<i class="fa-fw fa fa-home"></i> E-commerce <span>>
							Products View </span>
					</h1>
				</div>
				<!-- end col -->

				<!-- right side of the page with the sparkline graphs -->
				<!-- col -->
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8 text-right">

					<!-- <a href="javascript:void(0);" class="btn btn-default shop-btn">
							<i class="fa fa-3x fa-shopping-cart"></i>
							<span class="air air-top-right label-danger txt-color-white padding-5">10</span>
						</a>
						<a href="javascript:void(0);" class="btn btn-default">
							<i class="fa fa-3x fa-print"></i>
						</a> -->

				</div>
				<!-- end col -->

			</div>
			<!-- end row -->

			<%-- <div id="ribbon">

					<span class="ribbon-button-alignment"> 
						<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
							<i class="fa fa-refresh"></i>
						</span> 
					</span>
	
					<!-- breadcrumb -->
					<ol class="breadcrumb">
						<li>Course</li><li>Skills</li><li>Certification</li>
					</ol>
					<!-- end breadcrumb -->
	
					<!-- You can also add more buttons to the
					ribbon for further usability -->
	
					<!-- Example below: -->
	
					<!-- <span class="ribbon-button-alignment pull-right">
					<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
					<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
					<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
					</span> -->
					
					
	
				</div> --%>

			<div id="main" role="main" style="margin-left: 0px; height: 200%">

				<!-- RIBBON -->
				<div id="ribbon">

					<span class="ribbon-button-alignment"> <span id="refresh"
						class="btn btn-ribbon" data-action="resetWidgets"
						data-title="refresh" rel="tooltip" data-placement="bottom"
						data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings."
						data-html="true"> <i class="fa fa-refresh"></i>
					</span>
					</span>

					<!-- breadcrumb -->
					<ol class="breadcrumb">
						<li>Home</li>
						<li>E-commerce</li>
						<li>Product Detail</li>
					</ol>
					<!-- end breadcrumb -->

					<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

				</div>
				<!-- END RIBBON -->
				<section id="widget-grid" style="height: 90%"> <article
					class="col-sm-12 col-md-12" style="height: 100%"> <!-- Widget ID (each widget will need unique ID)-->
				<div class="jarviswidget well" style="height: 100%" id="wid-id-3"
					data-widget-colorbutton="false" data-widget-editbutton="false"
					data-widget-togglebutton="false" data-widget-deletebutton="false"
					data-widget-fullscreenbutton="false"
					data-widget-custombutton="false" data-widget-sortable="false">
					<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
					<header> <span class="widget-icon"> <i
						class="fa fa-comments"></i>
					</span>
					<h2>Default Tabs with border</h2>

					</header>

					<!-- widget div-->
					<div style="height: 100%">

						<!-- widget edit box -->
						<div class="jarviswidget-editbox">
							<!-- This area used as dropdown edit box -->

						</div>
						<!-- end widget edit box -->

						<!-- widget content -->
						<div class="widget-body" style="height: 100%;">

							<p>
								Tabs inside
								<code> .jarviswidget .well </code>
								(Bordered Tabs)
							</p>
							<hr class="simple">
							<ul id="myTab1" class="nav nav-tabs bordered">
								<li class="active"><a href="#s1" data-toggle="tab">Left
										Tab <span class="badge bg-color-blue txt-color-white">12</span>
								</a></li>
								<li><a href="#s2" data-toggle="tab"><i
										class="fa fa-fw fa-lg fa-gear"></i> Tab Item 2</a></li>
								<li class="dropdown"><a href="javascript:void(0);"
									class="dropdown-toggle" data-toggle="dropdown">Dropdown <b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="#s3" data-toggle="tab">@fat</a></li>
										<li><a href="#s4" data-toggle="tab">@mdo</a></li>
									</ul></li>
								<li class="pull-right"><a href="javascript:void(0);">
										<div class="sparkline txt-color-pinkDark text-align-right"
											data-sparkline-height="18px" data-sparkline-width="90px"
											data-sparkline-barwidth="7">5,10,6,7,4,3</div>
								</a></li>
							</ul>

							<div id="myTabContent1" class="tab-content padding-10"
								style="height: 90%; border: 0px;">
								<div class="tab-pane fade in active" id="s1">
									<div class="jarviswidget" id="wid-id-5"
										data-widget-colorbutton="false" data-widget-editbutton="false"
										data-widget-fullscreenbutton="true"
										data-widget-custombutton="false" data-widget-sortable="false">



										<header>
										<h2>Tabs left</h2>
										<div class="widget-toolbar hidden-phone">
											<div class="smart-form">
												<label class="toggle"> <input type="checkbox"
													id="demo-switch-to-pills" name="checkbox-toggle"> <i
													data-swchon-text="TRUE" data-swchoff-text="FALSE"></i>Switch
													Navs / Pills
												</label>
											</div>
										</div>
										</header>


										<div role="content" style="border-style: none;">


											<div class="jarviswidget-editbox"></div>



											<div class="widget-body">

												<div class="tabs-left">
													<ul class="nav nav-tabs tabs-left" id="demo-pill-nav">
														<li class="active"><a href="#tab-r1"
															data-toggle="tab"><span
																class="badge bg-color-blue txt-color-white">12</span>
																Item 1 </a></li>
														<li><a href="#tab-r2" data-toggle="tab"><span
																class="badge bg-color-blueDark txt-color-white">3</span>
																Item 2</a></li>
														<li><a href="#tab-r3" data-toggle="tab"><span
																class="badge bg-color-greenLight txt-color-white">0</span>
																Item 3</a></li>
													</ul>
													<div class="tab-content">
														<div class="tab-pane active" id="tab-r1">
															<div class="row">
																<div class=" .col-xs-12 .col-sm-6 .col-md-8"
																	style="float: left; width: 80%;">
																	<div>
																		<iframe allowfullscreen="true"
																			style="position: relative;" frameborder="0"
																			height="450" mozallowfullscreen="true"
																			src="http://player.vimeo.com/video/87025094"
																			webkitallowfullscreen="" width="85%"></iframe>
																	</div>
																</div>
																<div class=".col-xs-6 .col-md-4"
																	style="float: right; width: 18%;">
																	<div style="background-color: black; height:450px; overflow: auto;">

																		<nav> <!-- 
																			NOTE: Notice the gaps after each icon usage <i></i>..
																			Please note that these links work a bit different than
																			traditional href="" links. See documentation for details.
																			-->

																		<ul>
																			<li class="chat-users top-menu-invisible"><a
																				href="#"><i class="fa fa-lg fa-fw fa-comment-o"><em
																						class="bg-color-pink flash animated">!</em></i> <span
																					class="menu-item-parent">Watching Online</span></a>
																				<ul style="background-color: black;">
																					<li style="background-color: black;">
																						<!-- DISPLAY USERS -->
																						<div style="background-color: black;" class="display-users" >

																							<input class="form-control chat-user-filter"
																								placeholder="Filter" type="text"> <a
																								href="#" class="usr" data-chat-id="cha1"
																								data-chat-fname="Sadi" data-chat-lname="Orlaf"
																								data-chat-status="busy"
																								data-chat-alertmsg="Sadi Orlaf is in a meeting. Please do not disturb!"
																								data-chat-alertshow="true"
																								data-rel="popover-hover" data-placement="right"
																								data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/5.png' alt='Sadi Orlaf'>
																											<div class='usr-card-content'>
																												<h3>Sadi Orlaf</h3>
																												<p>Marketing Executive</p>
																											</div>
																										</div>
																									">
																								<i></i>Sadi Orlaf
																							</a> <a href="#" class="usr" data-chat-id="cha2"
																								data-chat-fname="Jessica"
																								data-chat-lname="Dolof"
																								data-chat-status="online" data-chat-alertmsg=""
																								data-chat-alertshow="false"
																								data-rel="popover-hover" data-placement="right"
																								data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/1.png' alt='Jessica Dolof'>
																											<div class='usr-card-content'>
																												<h3>Jessica Dolof</h3>
																												<p>Sales Administrator</p>
																											</div>
																										</div>
																									">
																								<i></i>Jessica Dolof
																							</a> <a href="#" class="usr" data-chat-id="cha3"
																								data-chat-fname="Zekarburg"
																								data-chat-lname="Almandalie"
																								data-chat-status="online"
																								data-rel="popover-hover" data-placement="right"
																								data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/3.png' alt='Zekarburg Almandalie'>
																											<div class='usr-card-content'>
																												<h3>Zekarburg Almandalie</h3>
																												<p>Sales Admin</p>
																											</div>
																										</div>
																									">
																								<i></i>Zekarburg Almandalie
																							</a> <a href="#" class="usr" data-chat-id="cha4"
																								data-chat-fname="Barley"
																								data-chat-lname="Krazurkth"
																								data-chat-status="away" data-rel="popover-hover"
																								data-placement="right" data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/4.png' alt='Barley Krazurkth'>
																											<div class='usr-card-content'>
																												<h3>Barley Krazurkth</h3>
																												<p>Sales Director</p>
																											</div>
																										</div>
																									">
																								<i></i>Barley Krazurkth
																							</a> <a href="#" class="usr offline"
																								data-chat-id="cha5" data-chat-fname="Farhana"
																								data-chat-lname="Amrin"
																								data-chat-status="incognito"
																								data-rel="popover-hover" data-placement="right"
																								data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/female.png' alt='Farhana Amrin'>
																											<div class='usr-card-content'>
																												<h3>Farhana Amrin</h3>
																												<p>Support Admin <small><i class='fa fa-music'></i> Playing Beethoven Classics</small></p>
																											</div>
																										</div>
																									">
																								<i></i>Farhana Amrin (offline)
																							</a> <a href="#" class="usr offline"
																								data-chat-id="cha6" data-chat-fname="Lezley"
																								data-chat-lname="Jacob"
																								data-chat-status="incognito"
																								data-rel="popover-hover" data-placement="right"
																								data-html="true"
																								data-content="
																										<div class='usr-card'>
																											<img src='img/avatars/male.png' alt='Lezley Jacob'>
																											<div class='usr-card-content'>
																												<h3>Lezley Jacob</h3>
																												<p>Sales Director</p>
																											</div>
																										</div>
																									">
																								<i></i>Lezley Jacob (offline)
																							</a>
																							

																							<!-- <a href="ajax/chat.html" class="btn btn-xs btn-default btn-block sa-chat-learnmore-btn">About the API</a> -->

																						</div> <!-- END DISPLAY USERS -->
																					</li>
																				</ul></li>
																		</ul>
																		</nav>
																	</div>
																</div>
																<div class="col-sm-12 col-md-12 col-lg-6">
				
										<form method="post" class="well padding-bottom-10" onsubmit="return false;">
											<textarea rows="2" class="form-control" placeholder="What are you thinking?"></textarea>
											<div class="margin-top-10">
												<button type="submit" class="btn btn-sm btn-primary pull-right">
													Post
												</button>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Location"><i class="fa fa-location-arrow"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Voice"><i class="fa fa-microphone"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Photo"><i class="fa fa-camera"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add File"><i class="fa fa-file"></i></a>
											</div>
										</form>
				
										<div class="timeline-seperator text-center"> <span>10:30PM January 1st, 2013</span>
											<div class="btn-group pull-right">
												<a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-default btn-xs dropdown-toggle"><span class="caret single"></span></a>
												<ul class="dropdown-menu text-left">
													<li>
														<a href="javascript:void(0);">Hide this post</a>
													</li>
													<li>
														<a href="javascript:void(0);">Hide future posts from this user</a>
													</li>
													<li>
														<a href="javascript:void(0);">Mark as spam</a>
													</li>
												</ul>
											</div> 
										</div>
										<div class="chat-body no-padding profile-message">
											<ul>
												<li class="message">
													<img src="img/avatars/sunny.png" class="online" alt="sunny">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very
														image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Edit</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger">Delete</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
													<input class="form-control input-xs" placeholder="Type and enter" type="text">
												</li>
											</ul>
				
										</div>
				
										<div class="timeline-seperator text-center"> <span>11:30PM November 27th, 2013</span>
											<div class="btn-group pull-right">
												<a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-default btn-xs dropdown-toggle"><span class="caret single"></span></a>
												<ul class="dropdown-menu text-left">
													<li>
														<a href="javascript:void(0);">Hide this post</a>
													</li>
													<li>
														<a href="javascript:void(0);">Hide future posts from this user</a>
													</li>
													<li>
														<a href="javascript:void(0);">Mark as spam</a>
													</li>
												</ul>
											</div> 
										</div>
										<div class="chat-body no-padding profile-message">
											<ul>
												<li class="message">
													<img src="img/avatars/1.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Hide</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li>
													<div class="input-group wall-comment-reply">
														<input id="btn-input" type="text" class="form-control" placeholder="Type your message here...">
														<span class="input-group-btn">
															<button class="btn btn-primary" id="btn-chat">
																<i class="fa fa-reply"></i> Reply
															</button> </span>
													</div>
												</li>
											</ul>
				
										</div>
				
				
									</div>
															</div>
															
														</div>
														<div class="tab-pane" id="tab-r2">
															<p>Etsy mixtape wayfarers, ethical wes anderson tofu
																before they sold out mcsweeney's organic lomo retro
																fanny pack lo-fi farm-to-table readymade. Messenger bag
																gentrify pitchfork tattooed craft beer, iphone
																skateboard locavore carles etsy salvia banksy hoodie
																helvetica. DIY synth PBR banksy irony.</p>
														</div>
														<div class="tab-pane" id="tab-r3">
															<p>Trust fund seitan letterpress, keytar raw denim
																keffiyeh etsy art party before they sold out master
																cleanse gluten-free squid scenester freegan cosby
																sweater. Fanny pack portland seitan DIY, art party
																locavore wolf cliche high life echo park Austin. Cred
																vinyl keffiyeh DIY salvia PBR, banh mi before they sold
																out farm-to-table.</p>
														</div>
													</div>
												</div>

											</div>


										</div>


									</div>
								</div>
								<div class="tab-pane fade" id="s2">
									<p>Food truck fixie locavore, accusamus mcsweeney's marfa
										nulla single-origin coffee squid. Exercitation +1 labore
										velit, blog sartorial PBR leggings next level wes anderson
										artisan four loko farm-to-table craft beer twee.</p>
								</div>
								<div class="tab-pane fade" id="s3">
									<p>Etsy mixtape wayfarers, ethical wes anderson tofu before
										they sold out mcsweeney's organic lomo retro fanny pack lo-fi
										farm-to-table readymade. Messenger bag gentrify pitchfork
										tattooed craft beer, iphone skateboard locavore carles etsy
										salvia banksy hoodie helvetica. DIY synth PBR banksy irony.</p>
								</div>
								<div class="tab-pane fade" id="s4">
									<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
										etsy art party before they sold out master cleanse gluten-free
										squid scenester freegan cosby sweater. Fanny pack portland
										seitan DIY, art party locavore wolf cliche high life echo park
										Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before
										they sold out farm-to-table.</p>
								</div>
							</div>

						</div>
						<!-- end widget content -->

					</div>
					<!-- end widget div -->

				</div>
				<!-- end widget --> <!-- Widget ID (each widget will need unique ID)-->
				<!-- <div class="jarviswidget" id="wid-id-5" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
								widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								
								<header>
									<h2>Tabs left </h2>
									<div class="widget-toolbar hidden-phone">
										<div class="smart-form">
											<label class="toggle">
												<input type="checkbox" id="demo-switch-to-pills" name="checkbox-toggle">
												<i data-swchon-text="TRUE" data-swchoff-text="FALSE"></i>Switch Navs / Pills</label>
										</div>
									</div>
								</header>

								widget div
								<div>

									widget edit box
									<div class="jarviswidget-editbox">
										This area used as dropdown edit box

									</div>
									end widget edit box

									widget content
									<div class="widget-body">

										<div class="tabs-left">
											<ul class="nav nav-tabs tabs-left" id="demo-pill-nav">
												<li class="active">
													<a href="#tab-r1" data-toggle="tab"><span class="badge bg-color-blue txt-color-white">12</span> Item 1 </a>
												</li>
												<li>
													<a href="#tab-r2" data-toggle="tab"><span class="badge bg-color-blueDark txt-color-white">3</span> Item 2</a>
												</li>
												<li>
													<a href="#tab-r3" data-toggle="tab"><span class="badge bg-color-greenLight txt-color-white">0</span> Item 3</a>
												</li>
											</ul>
											<div class="tab-content">
												<div class="tab-pane active" id="tab-r1">
													<p>
														Dear Math, please grow up and solve your own problems, I'm tired of solving them for you.
													</p>

													<p>
														They say that love is more important than money, but have you ever tried to pay your bills with a hug?
													</p>
												</div>
												<div class="tab-pane" id="tab-r2">
													<p>
														Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony.
													</p>
												</div>
												<div class="tab-pane" id="tab-r3">
													<p>
														Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table.
													</p>
												</div>
											</div>
										</div>

									</div>
									end widget content

								</div>
								end widget div

							</div> --> <!-- end widget --> </article> <!-- MAIN CONTENT --> </section>
				<!-- END MAIN CONTENT -->

			</div>
			<!-- END MAIN PANEL -->

			<!-- PAGE FOOTER -->
			<!-- <div class="page-footer">
				<div class="row">
					<div class="col-xs-12 col-sm-6">
						<span class="txt-color-white">SmartAdmin 1.8.2 <span
							class="hidden-xs"> - Web Application Framework</span> © 2014-2015
						</span>
					</div>

					<div class="col-xs-6 col-sm-6 text-right hidden-xs">
						<div class="txt-color-white inline-block">
							<i class="txt-color-blueLight hidden-mobile">Last account
								activity <i class="fa fa-clock-o"></i> <strong>52 mins
									ago &nbsp;</strong>
							</i>
							<div class="btn-group dropup">
								<button
									class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white"
									data-toggle="dropdown">
									<i class="fa fa-link"></i> <span class="caret"></span>
								</button>
								<ul class="dropdown-menu pull-right text-left">
									<li>
										<div class="padding-5">
											<p class="txt-color-darken font-sm no-margin">Download
												Progress</p>
											<div class="progress progress-micro no-margin">
												<div class="progress-bar progress-bar-success"
													style="width: 50%;"></div>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="padding-5">
											<p class="txt-color-darken font-sm no-margin">Server Load</p>
											<div class="progress progress-micro no-margin">
												<div class="progress-bar progress-bar-success"
													style="width: 20%;"></div>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="padding-5">
											<p class="txt-color-darken font-sm no-margin">
												Memory Load <span class="text-danger">*critical*</span>
											</p>
											<div class="progress progress-micro no-margin">
												<div class="progress-bar progress-bar-danger"
													style="width: 70%;"></div>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="padding-5">
											<button class="btn btn-block btn-default">refresh</button>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div> -->
			<!-- END PAGE FOOTER -->

			<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
		Note: These tiles are completely responsive,
		you can add as many as you like
		-->
			<div id="shortcut">
				<ul>
					<li><a href="inbox.html"
						class="jarvismetro-tile big-cubes bg-color-blue"> <span
							class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail
									<span class="label pull-right bg-color-darken">14</span>
							</span>
						</span>
					</a></li>
					<li><a href="calendar.html"
						class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span
							class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span>
						</span>
					</a></li>
					<li><a href="gmap-xml.html"
						class="jarvismetro-tile big-cubes bg-color-purple"> <span
							class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span>
						</span>
					</a></li>
					<li><a href="invoice.html"
						class="jarvismetro-tile big-cubes bg-color-blueDark"> <span
							class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice
									<span class="label pull-right bg-color-darken">99</span>
							</span>
						</span>
					</a></li>
					<li><a href="gallery.html"
						class="jarvismetro-tile big-cubes bg-color-greenLight"> <span
							class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery
							</span>
						</span>
					</a></li>
					<li><a href="profile.html"
						class="jarvismetro-tile big-cubes selected bg-color-pinkDark">
							<span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My
									Profile </span>
						</span>
					</a></li>
				</ul>
			</div>


			<!--================================================== -->

			<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
			<script data-pace-options='{ "restartOnRequestAfter": true }'
				src="js/plugin/pace/pace.min.js"></script>

			<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
			<script
				src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');
			}
		</script>

			<script
				src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
			<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>

			<!-- IMPORTANT: APP CONFIG -->
			<script src="<c:url value='/resources/assets/js/app.config.js' />"></script>

			<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
			<script
				src="<c:url value='/resources/assets/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js' />"></script>

			<!-- BOOTSTRAP JS -->
			<script
				src="<c:url value='/resources/assets/js/bootstrap/bootstrap.min.js' />"></script>

			<!-- CUSTOM NOTIFICATION -->
			<script
				src="<c:url value='/resources/assets/js/notification/SmartNotification.min.js' />"></script>

			<!-- JARVIS WIDGETS -->
			<script
				src="<c:url value='/resources/assets/js/smartwidgets/jarvis.widget.min.js' />"></script>

			<!-- EASY PIE CHARTS -->
			<script
				src="<c:url value='/resources/assets/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js' />"></script>

			<!-- SPARKLINES -->
			<script
				src="<c:url value='/resources/assets/js/plugin/sparkline/jquery.sparkline.min.js' />"></script>

			<!-- JQUERY VALIDATE -->
			<script
				src="<c:url value='/resources/assets/js/plugin/jquery-validate/jquery.validate.min.js' />"></script>

			<!-- JQUERY MASKED INPUT -->
			<script
				src="<c:url value='/resources/assets/js/plugin/masked-input/jquery.maskedinput.min.js' />"></script>

			<!-- JQUERY SELECT2 INPUT -->
			<script
				src="<c:url value='/resources/assets/js/plugin/select2/select2.min.js' />"></script>

			<!-- JQUERY UI + Bootstrap Slider -->
			<script
				src="<c:url value='/resources/assets/js/plugin/bootstrap-slider/bootstrap-slider.min.js' />"></script>

			<!-- browser msie issue fix -->
			<script
				src="<c:url value='/resources/assets/js/plugin/msie-fix/jquery.mb.browser.min.js' />"></script>

			<!-- FastClick: For mobile devices -->
			<script
				src="<c:url value='/resources/assets/js/plugin/fastclick/fastclick.min.js' />"></script>

			<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

			<!-- Demo purpose only -->
			<%-- <script src="<c:url value='/resources/assets/js/demo.min.js' />"></script> --%>

			<!-- MAIN APP JS FILE -->
			<script src="<c:url value='/resources/assets/js/app.min.js' />"></script>

			<script src="<c:url value='/resources/assets/js/videoApp.js' />"></script>

			<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
			<!-- Voice command : plugin -->
			<script
				src="<c:url value='/resources/assets/js/speech/voicecommand.min.js' />"></script>

			<!-- SmartChat UI : plugin -->
			<script
				src="<c:url value='/resources/assets/js/smart-chat-ui/smart.chat.ui.min.js' />"></script>
			<script
				src="<c:url value='/resources/assets/js/smart-chat-ui/smart.chat.manager.min.js' />"></script>

			<!-- PAGE RELATED PLUGIN(S) -->
			<script
				src="<c:url value='/resources/assets/js/plugin/maxlength/bootstrap-maxlength.min.js' />"></script>
			<!-- <script src="js/plugin/maxlength/bootstrap-maxlength.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js' />"></script>
			<!-- <script src="js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/clockpicker/clockpicker.min.js' />"></script>
			<!-- <script src="js/plugin/clockpicker/clockpicker.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/bootstrap-tags/bootstrap-tagsinput.min.js' />"></script>
			<!-- <script src="js/plugin/bootstrap-tags/bootstrap-tagsinput.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/noUiSlider/jquery.nouislider.min.js' />"></script>
			<!-- <script src="js/plugin/noUiSlider/jquery.nouislider.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/ion-slider/ion.rangeSlider.min.js' />"></script>
			<!-- <script src="js/plugin/ion-slider/ion.rangeSlider.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/bootstrap-duallistbox/jquery.bootstrap-duallistbox.min.js' />"></script>
			<!-- <script src="js/plugin/bootstrap-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>	 -->
			<script
				src="<c:url value='/resources/assets/js/plugin/colorpicker/bootstrap-colorpicker.min.js' />"></script>
			<!-- <script src="js/plugin/colorpicker/bootstrap-colorpicker.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/knob/jquery.knob.min.js' />"></script>
			<!-- <script src="js/plugin/knob/jquery.knob.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/x-editable/moment.min.js' />"></script>
			<!-- <script src="js/plugin/x-editable/moment.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/x-editable/jquery.mockjax.min.js' />"></script>
			<!-- <script src="js/plugin/x-editable/jquery.mockjax.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/x-editable/x-editable.min.js' />"></script>
			<!-- <script src="js/plugin/x-editable/x-editable.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/typeahead/typeahead.min.js' />"></script>
			<!-- <script src="js/plugin/typeahead/typeahead.min.js"></script> -->
			<script
				src="<c:url value='/resources/assets/js/plugin/typeahead/typeaheadjs.min.js' />"></script>
			<!-- <script src="js/plugin/typeahead/typeaheadjs.min.js"></script> -->



			<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->


			<!-- <script type="text/javascript">

			$(document).ready(function() {
			 	
				/* DO NOT REMOVE : GLOBAL FUNCTIONS!
				 *
				 * pageSetUp(); WILL CALL THE FOLLOWING FUNCTIONS
				 *
				 * // activate tooltips
				 * $("[rel=tooltip]").tooltip();
				 *
				 * // activate popovers
				 * $("[rel=popover]").popover();
				 *
				 * // activate popovers with hover states
				 * $("[rel=popover-hover]").popover({ trigger: "hover" });
				 *
				 * // activate inline charts
				 * runAllCharts();
				 *
				 * // setup widgets
				 * setup_widgets_desktop();
				 *
				 * // run form elements
				 * runAllForms();
				 *
				 ********************************
				 *
				 * pageSetUp() is needed whenever you load a page.
				 * It initializes and checks for all basic elements of the page
				 * and makes rendering easier.
				 *
				 */
				
				 pageSetUp();
				 
				/*
				 * ALL PAGE RELATED SCRIPTS CAN GO BELOW HERE
				 * eg alert("my home function");
				 * 
				 * var pagefunction = function() {
				 *   ...
				 * }
				 * loadScript("js/plugin/_PLUGIN_NAME_.js", pagefunction);
				 * 
				 * TO LOAD A SCRIPT:
				 * var pagefunction = function (){ 
				 *  loadScript(".../plugin.js", run_after_loaded);	
				 * }
				 * 
				 * OR
				 * 
				 * loadScript(".../plugin.js", run_after_loaded);
				 */
				
			})
		
		</script> -->

			<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!

		var slider1 = document.getElementById('nouislider-1'),
			slider2 = document.getElementById('nouislider-2'),
			slider3 = document.getElementById('nouislider-3'),
			slider4 = document.getElementById('nouislider-4');
		
		$(document).ready(function() {
			
			pageSetUp();
			
			
			
			
			
			 // PAGE RELATED SCRIPTS
		
			 // Spinners
			$("#spinner").spinner();
			$("#spinner-decimal").spinner({
			    step: 0.01,
			    numberFormat: "n"
			});
		
			$("#spinner-currency").spinner({
			    min: 5,
			    max: 2500,
			    step: 25,
			    start: 1000,
			    numberFormat: "C"
			});
		
			 //Maxlength
			
		    $('input[maxlength]').maxlength({
		        warningClass: "label label-success",
		        limitReachedClass: "label label-important",
		    });
		
			
			 // START AND FINISH DATE
			$('#startdate').datepicker({
			    dateFormat: 'dd.mm.yy',
			    prevText: '<i class="fa fa-chevron-left"></i>',
			    nextText: '<i class="fa fa-chevron-right"></i>',
			    onSelect: function (selectedDate) {
			        $('#finishdate').datepicker('option', 'minDate', selectedDate);
			    }
			});
			$('#finishdate').datepicker({
			    dateFormat: 'dd.mm.yy',
			    prevText: '<i class="fa fa-chevron-left"></i>',
			    nextText: '<i class="fa fa-chevron-right"></i>',
			    onSelect: function (selectedDate) {
			        $('#startdate').datepicker('option', 'maxDate', selectedDate);
			    }
			});
		
			 // Date Range Picker
			$("#from").datepicker({
			    defaultDate: "+1w",
			    changeMonth: true,
			    numberOfMonths: 3,
			    prevText: '<i class="fa fa-chevron-left"></i>',
			    nextText: '<i class="fa fa-chevron-right"></i>',
			    onClose: function (selectedDate) {
			        $("#to").datepicker("option", "maxDate", selectedDate);
			    }
		
			});
			$("#to").datepicker({
			    defaultDate: "+1w",
			    changeMonth: true,
			    numberOfMonths: 3,
			    prevText: '<i class="fa fa-chevron-left"></i>',
			    nextText: '<i class="fa fa-chevron-right"></i>',
			    onClose: function (selectedDate) {
			        $("#from").datepicker("option", "minDate", selectedDate);
			    }
			});
		
			/*
			 * TIMEPICKER
			 */
		
			$('#timepicker').timepicker();

			/*
			 * CLOCKPICKER
			 */
			
			$('#clockpicker').clockpicker({
				placement: 'top',
			    donetext: 'Done'
			});
			
			/*
			 * JS SLIDER
			 */
	
		    
		    noUiSlider.create(slider1, {
		        range: {
					'min': 20,
					'max': 100
				},
				behaviour: 'tap',
		        start: 55,
		        connect: 'upper',
		    });


		    noUiSlider.create(slider2, {
		        range: {
					'min': 0,
					'max': 300
				},
		        start: [55, 130],
		        step: 60,
		        connect: true
		    });


			noUiSlider.create(slider3, {
		        range: {
					'min': 0,
					'max': 1000
				},
		        start: [264, 776],
		        step: 1,
		        connect: true
		    });

		    slider3.noUiSlider.on('update', function(values){
		        $(".nouislider-value").text(values[0] + " - " + values[1]);
		    });

		    slider3.noUiSlider.on('slide', function(values){
				//var values = $(this).val();
		        $(".nouislider-value").text(values[0] + " - " + values[1]);
			});

			noUiSlider.create(slider4, {
		        range: {
					'min': 0,
					'max': 100
				},
				behaviour: 'tap',
		        start: 50,
		        connect: 'upper'
		        
		    });

		    slider4.setAttribute('disabled', true);
		
		
			/*
			 * ION SLIDER
			 */
		
		    $("#range-slider-1").ionRangeSlider({
		        min: 0,
		        max: 5000,
		        from: 1000,
		        to: 4000,
		        type: 'double',
		        step: 1,
		        postfix: " &euro;",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
		    });
		
		    $("#range-slider-2").ionRangeSlider({
		    	min: 1000,
		        max: 100000,
		        from: 30000,
		        to: 90000,
		        type: 'double',
		        step: 500,
		        postfix: " &euro;",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
		    });
		
		    $("#range-slider-3").ionRangeSlider({
		        min: 0,
		        from: 2.3,
		        max: 10,
		        type: 'single',
		        step: 0.1,
		        postfix: " mm",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
		    });
		
		    $("#range-slider-4").ionRangeSlider({
		        min: -50,
		        max: 50,
		        from: 5,
		        to: 25,
		        type: 'double',
		        step: 1,
		        postfix: "Â°",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
		    });
		
		    $("#range-slider-5").ionRangeSlider({
		        min: 0,
		        from: 0,
		        max: 10,
		        type: 'single',
		        step: 0.1,
		        postfix: " mm",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
		    });
		
		
			/*
			 * BOOTSTRAP DUALLIST BOX
			 */
					
			var initializeDuallistbox = $('#initializeDuallistbox').bootstrapDualListbox({
	          nonSelectedListLabel: 'Non-selected',
	          selectedListLabel: 'Selected',
	          preserveSelectionOnMove: 'moved',
	          moveOnSelect: false,
	          nonSelectedFilter: 'ion ([7-9]|[1][0-2])'
	        });
			
		
			/*
			 * COLOR PICKER
			 */
		
		    $('#colorpicker-1').colorpicker()
		    $('#colorpicker-2').colorpicker()
		
		
		
			/*
			 * KNOB
			 */
		
		    $('.knob').knob({
                change: function (value) {
                    //console.log("change : " + value);
                },
                release: function (value) {
                    //console.log(this.$.attr('value'));
                    //console.log("release : " + value);
                },
                cancel: function () {
                    //console.log("cancel : ", this);
                }
            });
		
		
			/*
			 * X-Ediable
			 */

		
		    (function (e) {
		        "use strict";
		        var t = function (e) {
		            this.init("address", e, t.defaults)
		        };
		        e.fn.editableutils.inherit(t, e.fn.editabletypes.abstractinput);
		        e.extend(t.prototype, {
		            render: function () {
		                this.$input = this.$tpl.find("input")
		            },
		            value2html: function (t, n) {
		                if (!t) {
		                    e(n).empty();
		                    return
		                }
		                var r = e("<div>").text(t.city).html() + ", " + e("<div>").text(t.street).html() +
		                    " st., bld. " + e("<div>").text(t.building).html();
		                e(n).html(r)
		            },
		            html2value: function (e) {
		                return null
		            },
		            value2str: function (e) {
		                var t = "";
		                if (e)
		                    for (var n in e)
		                        t = t + n + ":" + e[n] + ";";
		                return t
		            },
		            str2value: function (e) {
		                return e
		            },
		            value2input: function (e) {
		                if (!e)
		                    return;
		                this.$input.filter('[name="city"]').val(e.city);
		                this.$input.filter('[name="street"]').val(e.street);
		                this.$input.filter('[name="building"]').val(e.building)
		            },
		            input2value: function () {
		                return {
		                    city: this.$input.filter('[name="city"]').val(),
		                    street: this.$input.filter('[name="street"]').val(),
		                    building: this.$input.filter('[name="building"]').val()
		                }
		            },
		            activate: function () {
		                this.$input.filter('[name="city"]').focus()
		            },
		            autosubmit: function () {
		                this.$input.keydown(function (t) {
		                    t.which === 13 && e(this).closest("form").submit()
		                })
		            }
		        });
		        t.defaults = e.extend({}, e.fn.editabletypes.abstractinput.defaults, {
		            tpl: '<div class="editable-address"><label><span>City: </span><input type="text" name="city" class="input-small"></label></div><div class="editable-address"><label><span>Street: </span><input type="text" name="street" class="input-small"></label></div><div class="editable-address"><label><span>Building: </span><input type="text" name="building" class="input-mini"></label></div>',
		            inputclass: ""
		        });
		        e.fn.editabletypes.address = t
		    })(window.jQuery);
		
		    //ajax mocks
		    $.mockjaxSettings.responseTime = 500;
		
		    $.mockjax({
		        url: '/post',
		        response: function (settings) {
		            log(settings, this);
		        }
		    });
		
		    $.mockjax({
		        url: '/error',
		        status: 400,
		        statusText: 'Bad Request',
		        response: function (settings) {
		            this.responseText = 'Please input correct value';
		            log(settings, this);
		        }
		    });
		
		    $.mockjax({
		        url: '/status',
		        status: 500,
		        response: function (settings) {
		            this.responseText = 'Internal Server Error';
		            log(settings, this);
		        }
		    });
		
		    $.mockjax({
		        url: '/groups',
		        response: function (settings) {
		            this.responseText = [{
		                value: 0,
		                text: 'Guest'
		            }, {
		                value: 1,
		                text: 'Service'
		            }, {
		                value: 2,
		                text: 'Customer'
		            }, {
		                value: 3,
		                text: 'Operator'
		            }, {
		                value: 4,
		                text: 'Support'
		            }, {
		                value: 5,
		                text: 'Admin'
		            }];
		            log(settings, this);
		        }
		    });
		
		    //TODO: add this div to page
		    function log(settings, response) {
		        var s = [],
		            str;
		        s.push(settings.type.toUpperCase() + ' url = "' + settings.url + '"');
		        for (var a in settings.data) {
		            if (settings.data[a] && typeof settings.data[a] === 'object') {
		                str = [];
		                for (var j in settings.data[a]) {
		                    str.push(j + ': "' + settings.data[a][j] + '"');
		                }
		                str = '{ ' + str.join(', ') + ' }';
		            } else {
		                str = '"' + settings.data[a] + '"';
		            }
		            s.push(a + ' = ' + str);
		        }
		        s.push('RESPONSE: status = ' + response.status);
		
		        if (response.responseText) {
		            if ($.isArray(response.responseText)) {
		                s.push('[');
		                $.each(response.responseText, function (i, v) {
		                    s.push('{value: ' + v.value + ', text: "' + v.text + '"}');
		                });
		                s.push(']');
		            } else {
		                s.push($.trim(response.responseText));
		            }
		        }
		        s.push('--------------------------------------\n');
		        $('#console').val(s.join('\n') + $('#console').val());
		    }
		
		    /*
		     * X-EDITABLES
		     */
		
		    $('#inline').on('change', function (e) {
		        if ($(this).prop('checked')) {
		            window.location.href = '?mode=inline#ajax/plugins.html';
		        } else {
		            window.location.href = '?#ajax/plugins.html';
		        }
		    });
		
		    if (window.location.href.indexOf("?mode=inline") > -1) {
		        $('#inline').prop('checked', true);
		        $.fn.editable.defaults.mode = 'inline';
		    } else {
		        $('#inline').prop('checked', false);
		        $.fn.editable.defaults.mode = 'popup';
		    }
		
		    //defaults
		    $.fn.editable.defaults.url = '/post';
		    //$.fn.editable.defaults.mode = 'inline'; use this to edit inline
		
		    //enable / disable
		    $('#enable').click(function () {
		        $('#user .editable').editable('toggleDisabled');
		    });
		
		    //editables
		    $('#username').editable({
		        url: '/post',
		        type: 'text',
		        pk: 1,
		        name: 'username',
		        title: 'Enter username'
		    });
		
		    $('#firstname').editable({
		        validate: function (value) {
		            if ($.trim(value) == '')
		                return 'This field is required';
		        }
		    });
		
		    $('#sex').editable({
		        prepend: "not selected",
		        source: [{
		            value: 1,
		            text: 'Male'
		        }, {
		            value: 2,
		            text: 'Female'
		        }],
		        display: function (value, sourceData) {
		            var colors = {
		                "": "gray",
		                1: "green",
		                2: "blue"
		            }, elem = $.grep(sourceData, function (o) {
		                    return o.value == value;
		                });
		
		            if (elem.length) {
		                $(this).text(elem[0].text).css("color", colors[value]);
		            } else {
		                $(this).empty();
		            }
		        }
		    });
		
		    $('#status').editable();
		
		    $('#group').editable({
		        showbuttons: false
		    });
		
		    $('#vacation').editable({
		        datepicker: {
		            todayBtn: 'linked'
		        }
		    });
		
		    $('#dob').editable();
		
		    $('#event').editable({
		        placement: 'right',
		        combodate: {
		            firstItem: 'name'
		        }
		    });
		
		    $('#meeting_start').editable({
		        format: 'yyyy-mm-dd hh:ii',
		        viewformat: 'dd/mm/yyyy hh:ii',
		        validate: function (v) {
		            if (v && v.getDate() == 10)
		                return 'Day cant be 10!';
		        },
		        datetimepicker: {
		            todayBtn: 'linked',
		            weekStart: 1
		        }
		    });
		
		    $('#comments').editable({
		        showbuttons: 'bottom'
		    });
		
		    $('#note').editable();
		    $('#pencil').click(function (e) {
		        e.stopPropagation();
		        e.preventDefault();
		        $('#note').editable('toggle');
		    });
		
		    $('#state').editable({
		        source: ["Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
		            "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
		            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
		            "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
		            "New Mexico", "New York", "North Dakota", "North Carolina", "Ohio", "Oklahoma", "Oregon",
		            "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
		            "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
		        ]
		    });
		
		    $('#state2').editable({
		        value: 'California',
		        typeahead: {
		            name: 'state',
		            local: ["Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
		                "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
		                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
		                "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
		                "New Jersey", "New Mexico", "New York", "North Dakota", "North Carolina", "Ohio",
		                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
		                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
		                "Wisconsin", "Wyoming"
		            ]
		        }
		    });
		
		    $('#fruits').editable({
		        pk: 1,
		        limit: 3,
		        source: [{
		            value: 1,
		            text: 'banana'
		        }, {
		            value: 2,
		            text: 'peach'
		        }, {
		            value: 3,
		            text: 'apple'
		        }, {
		            value: 4,
		            text: 'watermelon'
		        }, {
		            value: 5,
		            text: 'orange'
		        }]
		    });
		
		    $('#tags').editable({
		        inputclass: 'input-large',
		        select2: {
		            tags: ['html', 'javascript', 'css', 'ajax'],
		            tokenSeparators: [",", " "]
		        }
		    });
		
		    var countries = [];
		    $.each({
		        "BD": "Bangladesh",
		        "BE": "Belgium",
		        "BF": "Burkina Faso",
		        "BG": "Bulgaria",
		        "BA": "Bosnia and Herzegovina",
		        "BB": "Barbados",
		        "WF": "Wallis and Futuna",
		        "BL": "Saint Bartelemey",
		        "BM": "Bermuda",
		        "BN": "Brunei Darussalam",
		        "BO": "Bolivia",
		        "BH": "Bahrain",
		        "BI": "Burundi",
		        "BJ": "Benin",
		        "BT": "Bhutan",
		        "JM": "Jamaica",
		        "BV": "Bouvet Island",
		        "BW": "Botswana",
		        "WS": "Samoa",
		        "BR": "Brazil",
		        "BS": "Bahamas",
		        "JE": "Jersey",
		        "BY": "Belarus",
		        "O1": "Other Country",
		        "LV": "Latvia",
		        "RW": "Rwanda",
		        "RS": "Serbia",
		        "TL": "Timor-Leste",
		        "RE": "Reunion",
		        "LU": "Luxembourg",
		        "TJ": "Tajikistan",
		        "RO": "Romania",
		        "PG": "Papua New Guinea",
		        "GW": "Guinea-Bissau",
		        "GU": "Guam",
		        "GT": "Guatemala",
		        "GS": "South Georgia and the South Sandwich Islands",
		        "GR": "Greece",
		        "GQ": "Equatorial Guinea",
		        "GP": "Guadeloupe",
		        "JP": "Japan",
		        "GY": "Guyana",
		        "GG": "Guernsey",
		        "GF": "French Guiana",
		        "GE": "Georgia",
		        "GD": "Grenada",
		        "GB": "United Kingdom",
		        "GA": "Gabon",
		        "SV": "El Salvador",
		        "GN": "Guinea",
		        "GM": "Gambia",
		        "GL": "Greenland",
		        "GI": "Gibraltar",
		        "GH": "Ghana",
		        "OM": "Oman",
		        "TN": "Tunisia",
		        "JO": "Jordan",
		        "HR": "Croatia",
		        "HT": "Haiti",
		        "HU": "Hungary",
		        "HK": "Hong Kong",
		        "HN": "Honduras",
		        "HM": "Heard Island and McDonald Islands",
		        "VE": "Venezuela",
		        "PR": "Puerto Rico",
		        "PS": "Palestinian Territory",
		        "PW": "Palau",
		        "PT": "Portugal",
		        "SJ": "Svalbard and Jan Mayen",
		        "PY": "Paraguay",
		        "IQ": "Iraq",
		        "PA": "Panama",
		        "PF": "French Polynesia",
		        "BZ": "Belize",
		        "PE": "Peru",
		        "PK": "Pakistan",
		        "PH": "Philippines",
		        "PN": "Pitcairn",
		        "TM": "Turkmenistan",
		        "PL": "Poland",
		        "PM": "Saint Pierre and Miquelon",
		        "ZM": "Zambia",
		        "EH": "Western Sahara",
		        "RU": "Russian Federation",
		        "EE": "Estonia",
		        "EG": "Egypt",
		        "TK": "Tokelau",
		        "ZA": "South Africa",
		        "EC": "Ecuador",
		        "IT": "Italy",
		        "VN": "Vietnam",
		        "SB": "Solomon Islands",
		        "EU": "Europe",
		        "ET": "Ethiopia",
		        "SO": "Somalia",
		        "ZW": "Zimbabwe",
		        "SA": "Saudi Arabia",
		        "ES": "Spain",
		        "ER": "Eritrea",
		        "ME": "Montenegro",
		        "MD": "Moldova, Republic of",
		        "MG": "Madagascar",
		        "MF": "Saint Martin",
		        "MA": "Morocco",
		        "MC": "Monaco",
		        "UZ": "Uzbekistan",
		        "MM": "Myanmar",
		        "ML": "Mali",
		        "MO": "Macao",
		        "MN": "Mongolia",
		        "MH": "Marshall Islands",
		        "MK": "Macedonia",
		        "MU": "Mauritius",
		        "MT": "Malta",
		        "MW": "Malawi",
		        "MV": "Maldives",
		        "MQ": "Martinique",
		        "MP": "Northern Mariana Islands",
		        "MS": "Montserrat",
		        "MR": "Mauritania",
		        "IM": "Isle of Man",
		        "UG": "Uganda",
		        "TZ": "Tanzania, United Republic of",
		        "MY": "Malaysia",
		        "MX": "Mexico",
		        "IL": "Israel",
		        "FR": "France",
		        "IO": "British Indian Ocean Territory",
		        "FX": "France, Metropolitan",
		        "SH": "Saint Helena",
		        "FI": "Finland",
		        "FJ": "Fiji",
		        "FK": "Falkland Islands (Malvinas)",
		        "FM": "Micronesia, Federated States of",
		        "FO": "Faroe Islands",
		        "NI": "Nicaragua",
		        "NL": "Netherlands",
		        "NO": "Norway",
		        "NA": "Namibia",
		        "VU": "Vanuatu",
		        "NC": "New Caledonia",
		        "NE": "Niger",
		        "NF": "Norfolk Island",
		        "NG": "Nigeria",
		        "NZ": "New Zealand",
		        "NP": "Nepal",
		        "NR": "Nauru",
		        "NU": "Niue",
		        "CK": "Cook Islands",
		        "CI": "Cote d'Ivoire",
		        "CH": "Switzerland",
		        "CO": "Colombia",
		        "CN": "China",
		        "CM": "Cameroon",
		        "CL": "Chile",
		        "CC": "Cocos (Keeling) Islands",
		        "CA": "Canada",
		        "CG": "Congo",
		        "CF": "Central African Republic",
		        "CD": "Congo, The Democratic Republic of the",
		        "CZ": "Czech Republic",
		        "CY": "Cyprus",
		        "CX": "Christmas Island",
		        "CR": "Costa Rica",
		        "CV": "Cape Verde",
		        "CU": "Cuba",
		        "SZ": "Swaziland",
		        "SY": "Syrian Arab Republic",
		        "KG": "Kyrgyzstan",
		        "KE": "Kenya",
		        "SR": "Suriname",
		        "KI": "Kiribati",
		        "KH": "Cambodia",
		        "KN": "Saint Kitts and Nevis",
		        "KM": "Comoros",
		        "ST": "Sao Tome and Principe",
		        "SK": "Slovakia",
		        "KR": "Korea, Republic of",
		        "SI": "Slovenia",
		        "KP": "Korea, Democratic People's Republic of",
		        "KW": "Kuwait",
		        "SN": "Senegal",
		        "SM": "San Marino",
		        "SL": "Sierra Leone",
		        "SC": "Seychelles",
		        "KZ": "Kazakhstan",
		        "KY": "Cayman Islands",
		        "SG": "Singapore",
		        "SE": "Sweden",
		        "SD": "Sudan",
		        "DO": "Dominican Republic",
		        "DM": "Dominica",
		        "DJ": "Djibouti",
		        "DK": "Denmark",
		        "VG": "Virgin Islands, British",
		        "DE": "Germany",
		        "YE": "Yemen",
		        "DZ": "Algeria",
		        "US": "United States",
		        "UY": "Uruguay",
		        "YT": "Mayotte",
		        "UM": "United States Minor Outlying Islands",
		        "LB": "Lebanon",
		        "LC": "Saint Lucia",
		        "LA": "Lao People's Democratic Republic",
		        "TV": "Tuvalu",
		        "TW": "Taiwan",
		        "TT": "Trinidad and Tobago",
		        "TR": "Turkey",
		        "LK": "Sri Lanka",
		        "LI": "Liechtenstein",
		        "A1": "Anonymous Proxy",
		        "TO": "Tonga",
		        "LT": "Lithuania",
		        "A2": "Satellite Provider",
		        "LR": "Liberia",
		        "LS": "Lesotho",
		        "TH": "Thailand",
		        "TF": "French Southern Territories",
		        "TG": "Togo",
		        "TD": "Chad",
		        "TC": "Turks and Caicos Islands",
		        "LY": "Libyan Arab Jamahiriya",
		        "VA": "Holy See (Vatican City State)",
		        "VC": "Saint Vincent and the Grenadines",
		        "AE": "United Arab Emirates",
		        "AD": "Andorra",
		        "AG": "Antigua and Barbuda",
		        "AF": "Afghanistan",
		        "AI": "Anguilla",
		        "VI": "Virgin Islands, U.S.",
		        "IS": "Iceland",
		        "IR": "Iran, Islamic Republic of",
		        "AM": "Armenia",
		        "AL": "Albania",
		        "AO": "Angola",
		        "AN": "Netherlands Antilles",
		        "AQ": "Antarctica",
		        "AP": "Asia/Pacific Region",
		        "AS": "American Samoa",
		        "AR": "Argentina",
		        "AU": "Australia",
		        "AT": "Austria",
		        "AW": "Aruba",
		        "IN": "India",
		        "AX": "Aland Islands",
		        "AZ": "Azerbaijan",
		        "IE": "Ireland",
		        "ID": "Indonesia",
		        "UA": "Ukraine",
		        "QA": "Qatar",
		        "MZ": "Mozambique"
		    }, function (k, v) {
		        countries.push({
		            id: k,
		            text: v
		        });
		    });
		
		    $('#country').editable({
		        source: countries,
		        select2: {
		            width: 200
		        }
		    });
		
		    $('#address').editable({
		        url: '/post',
		        value: {
		            city: "Moscow",
		            street: "Lenina",
		            building: "12"
		        },
		        validate: function (value) {
		            if (value.city == '')
		                return 'city is required!';
		        },
		        display: function (value) {
		            if (!value) {
		                $(this).empty();
		                return;
		            }
		            var html = '<b>' + $('<div>').text(value.city).html() + '</b>, ' + $('<div>').text(value.street)
		                .html() + ' st., bld. ' + $('<div>').text(value.building).html();
		            $(this).html(html);
		        }
		    });
		
		    $('#user .editable').on('hidden', function (e, reason) {
		        if (reason === 'save' || reason === 'nochange') {
		            var $next = $(this).closest('tr').next().find('.editable');
		            if ($('#autoopen').is(':checked')) {
		                setTimeout(function () {
		                    $next.editable('show');
		                }, 300);
		            } else {
		                $next.focus();
		            }
		        }
		    });	
		    
		   /*  function callloadMore(){
		    	alert("ajax for load more");
			    alert(lastid);
		    
		    	
				    alert("ajax for load more");
				    alert(lastid);
				    
				    $.ajax({
				    	url: "${home}courseinfo?lastid="+lastid, 
						success : function() {
							//$("#login-form").addClass('submited');
						}
				    	
				    }); 
				   
		    } */
		    
		    
		    
		    
	
		})

		</script>

			<!-- Your GOOGLE ANALYTICS CODE Below -->
			<script type="text/javascript">
			var _gaq = _gaq || [];
				_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
				_gaq.push(['_trackPageview']);
			
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>
</body>
</html>