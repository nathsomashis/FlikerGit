<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.fliker.Repository.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> Guidance Dash </title>
		<meta name="description" content="">
		<meta name="author" content="">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link href='<c:url value="/resources/css/bootstrap.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css"> -->
		<link href='<c:url value="/resources/css/font-awesome.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css"> -->

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link href='<c:url value="/resources/css/smartadmin-production-plugins.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css"> -->
		<link href='<c:url value="/resources/css/smartadmin-production.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css"> -->
		<link href='<c:url value="/resources/css/smartadmin-skins.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css"> -->

		<!-- SmartAdmin RTL Support -->
		<link href='<c:url value="/resources/css/smartadmin-rtl.min.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> --> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css"> -->
		<link href='<c:url value="/resources/css/demo.min.css" />' rel="stylesheet">


		<!-- #FAVICONS -->
		<link href='<c:url value="/resources/img/favicon/favicon.ico" />' rel="shortcut icon" type="image/x-icon">
		<!-- <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->
		<link href='<c:url value="/resources/img/favicon/favicon.ico" />' rel="icon" type="image/x-icon">
		<!-- <link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
			 <link href='<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />' rel="apple-touch-icon">
		<!-- <link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png"> -->
		<link href='<c:url value="/resources/img/splash/touch-icon-ipad.png" />' rel="apple-touch-icon" sizes="76x76">
		<!-- <link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png"> -->
		<link href='<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />' rel="apple-touch-icon" sizes="120x120">
		<!-- <link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png"> -->
		<link href='<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />' rel="apple-touch-icon" sizes="152x152">
		<!-- <link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png"> -->
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link href='<c:url value="/resources/img/splash/ipad-landscape.png" />' rel="apple-touch-startup-image" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)"> -->
		<link href='<c:url value="/resources/img/splash/ipad-portrait.png" />' rel="apple-touch-startup-image" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)"> -->
		<link href='<c:url value="/resources/img/splash/iphone.png" />' rel="apple-touch-startup-image" media="screen and (max-device-width: 320px)">
		<!-- <link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)"> -->

	</head>
	
	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #CSS Links                |  all CSS links and file paths  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #RIGHT PANEL              |  right panel userlist          |
	|  13. #MAIN PANEL               |  main panel                    |
	|  14. #MAIN CONTENT             |  content holder                |
	|  15. #PAGE FOOTER              |  page footer                   |
	|  16. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  17. #PLUGINS                  |  all scripts and plugins       |
	
	===================================================================
	
	-->
	
	<!-- #BODY -->
	<!-- Possible Classes

		* 'smart-style-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'no-menu'			  - Hides the menu completely
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-page-footer' - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<body class="">
	
		<%
			/* String profileimage = (String)request.getAttribute("ProfileImage");
			String gender = (String)request.getAttribute("Gender");
			String profilename = (String)request.getAttribute("FullName");
			Timetable timeline = (Timetable)request.getAttribute("TimeTable");
			GuidanceContentShared guidanceshare = (GuidanceContentShared)request.getAttribute("GuidShared");
			GuidanceContentDashboard guiddash = (GuidanceContentDashboard)request.getAttribute("GuidDashBoard");
			Blog blogs = (Blog)request.getAttribute("GuidBlog");
			String logo = "";
			String guidanceid = (String)request.getAttribute("guidanceid");
			String timetableid = timeline.getTimeableid();
			String guideshareid = guidanceshare.getGuidancesharedid();
			String guidedash = guiddash.getGuidancecontentDashid(); */
			
		
		%>

		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/logo.png" alt="Fliker"> </span>
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown"> <i class="fa fa-user"></i> <b class="badge"> 21 </b> </span>

				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
						<label class="btn btn-default">
							<input type="radio" name="activity" id="offlinechatmessages?">
							Msgs (14) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="notifications?">
							notify (3) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="tasklists?">
							Tasks (4) </label>
					</div>

					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">

						<div class="alert alert-transparent">
							<h4>Click a button to show messages here</h4>
							This blank page message helps protect your privacy, or you can show the first message here automatically.
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>

					</div>
					<!-- end notification content -->

					<!-- footer: refresh area -->
					<span> Last updated on: 12/12/2013 9:43AM
						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right">
							<i class="fa fa-refresh"></i>
						</button> </span>
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- projects dropdown -->
			<div class="project-context hidden-xs" >

				<span class="label">Projects:</span>
				<span class="project-selector dropdown-toggle" data-toggle="dropdown">Recent projects <i class="fa fa-angle-down"></i></span>

				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu" style="border: 1px solid black">
					<h5>Daily Note</h5>
					<li>
						<textarea id="notemessage" class="form-control" name="notemessage" rows="3" style="width: 400px"></textarea>
					</li>
					
					<li class="divider"></li>
					<li>
						<a href="#" id="notedown"><i class="fa fa-edit"></i> Note Down</a>
					</li>
				</ul>
				<!-- end dropdown-menu-->

			</div>
			
			<!-- end projects dropdown -->

			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->
				
				<!-- #MOBILE -->
				<!-- Top menu profile link : this shows only when top menu is active -->
				<ul id="mobile-profile-img" class="header-dropdown-list hidden-xs padding-5">
					<li class="">
						<a href="#" class="dropdown-toggle no-margin userdropdown" data-toggle="dropdown"> 
							<img src="img/avatars/sunny.png" alt="John Doe" class="online" />  
						</a>
						<ul class="dropdown-menu pull-right">
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0"><i class="fa fa-cog"></i> Setting</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="profile.html" class="padding-10 padding-top-0 padding-bottom-0"> <i class="fa fa-user"></i> <u>P</u>rofile</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="toggleShortcut"><i class="fa fa-arrow-down"></i> <u>S</u>hortcut</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i> Full <u>S</u>creen</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="logout?"  class="padding-10 padding-top-5 padding-bottom-5" data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i> <strong><u>L</u>ogout</strong></a>
							</li>
						</ul>
					</li>
				</ul>

				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<span> <a href="logout?" title="Sign Out" data-action="userLogout" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->

				<!-- input: search field -->
				<form action="searchresults?" class="header-search pull-right">
					<input id="search-fld"  type="text" name="param" placeholder="Find reports and more" data-autocomplete='[
					"ActionScript",
					"AppleScript",
					"Asp",
					"BASIC",
					"C",
					"C++",
					"Clojure",
					"COBOL",
					"ColdFusion",
					"Erlang",
					"Fortran",
					"Groovy",
					"Haskell",
					"Java",
					"JavaScript",
					"Lisp",
					"Perl",
					"PHP",
					"Python",
					"Ruby",
					"Scala",
					"Scheme"]'>
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
				</form>
				<!-- end input: search field -->

				<!-- fullscreen button -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->
				
				<!-- #Voice Command: Start Speech -->
				<div id="speech-btn" class="btn-header transparent pull-right hidden-sm hidden-xs">
					<div> 
						<a href="javascript:void(0)" title="Voice Command" data-action="voiceCommand"><i class="fa fa-microphone"></i></a> 
						<div class="popover bottom"><div class="arrow"></div>
							<div class="popover-content">
								<h4 class="vc-title">Voice command activated <br><small>Please speak clearly into the mic</small></h4>
								<h4 class="vc-title-error text-center">
									<i class="fa fa-microphone-slash"></i> Voice command failed
									<br><small class="txt-color-red">Must <strong>"Allow"</strong> Microphone</small>
									<br><small class="txt-color-red">Must have <strong>Internet Connection</strong></small>
								</h4>
								<a href="javascript:void(0);" class="btn btn-success" onclick="commands.help()">See Commands</a> 
								<a href="javascript:void(0);" class="btn bg-color-purple txt-color-white" onclick="$('#speech-btn .popover').fadeOut(50);">Close Popup</a> 
							</div>
						</div>
					</div>
				</div>
				<!-- end voice command -->

				<!-- multiple lang dropdown : find all flags in the flags page -->
				<!-- <ul class="header-dropdown-list hidden-xs">
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/blank.gif" class="flag flag-us" alt="United States"> <span> English (US) </span> <i class="fa fa-angle-down"></i> </a>
						<ul class="dropdown-menu pull-right">
							<li class="active">
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-us" alt="United States"> English (US)</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-fr" alt="France"> FranÃÂ§ais</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-es" alt="Spanish"> EspaÃÂ±ol</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-de" alt="German"> Deutsch</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-jp" alt="Japan"> Ã¦âÂ¥Ã¦ÅÂ¬Ã¨ÂªÅ¾</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-cn" alt="China"> Ã¤Â¸Â­Ã¦ââ¡</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-it" alt="Italy"> Italiano</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-pt" alt="Portugal"> Portugal</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-ru" alt="Russia"> ÃÂ ÃÆÃÂÃÂÃÂºÃÂ¸ÃÂ¹ ÃÂÃÂ·Ãâ¹ÃÂº</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-kr" alt="Korea"> Ã­â¢ÅÃªÂµÂ­Ã¬âÂ´</a>
							</li>						
							
						</ul>
					</li>
				</ul> -->
				<!-- end multiple lang -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<%-- <div class="login-info">
			<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

				<a href="javascript:void(0);" id="show-shortcut"
				data-action="toggleShortcut"> <%if(profileimage == ""){
					if(gender.equalsIgnoreCase("female")){
						%> <img src="<c:url value='/resources/img/avatars/female.png' />"
					alt="me" class="online" /> <%
					}else{
						%> <img src="<c:url value='/resources/img/avatars/male.png' />"
					alt="me" class="online" /> <% 
					}
				}else{%> <img src=<%=logo%> alt="me" class="online" /> <%} %> <span><%=profilename%>
				</span> <i class="fa fa-angle-down"></i>
			</a>

			</span>
		</div> --%>
			<!-- end user info -->

			<nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
		<%-- <li><a href="gotoguidance?guidanceid="<%=guidanceid%>><i
				class="fa fa-lg fa-fw fa-bar-chart-o "></i> <span
				class="menu-item-parent">Guidance Dash</span> </a></li>
		<li ><a href="gotoguidanceshare?guidanceid="<%=guidanceid%>><i
				class="fa fa-lg fa-fw fa-random txt-color-blue	"></i> <span
				class="menu-item-parent">Guidance Share</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>

		<li><a href="gotoguidancecalendar?guidanceid="<%=guidanceid%>><i class="fa fa-lg fa-fw fa-info"></i>
				<span class="menu-item-parent">Guidance Calendar</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		</li> --%>
	</ul>
			</nav>
			

			<span class="minifyme" data-action="minifyMenu"> 
				<i class="fa fa-arrow-circle-left hit"></i> 
			</span>

		</aside>
		<!-- END NAVIGATION -->

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Share within </li>
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

			<!-- MAIN CONTENT -->
			<div id="content">

				<!-- row -->
				
								<div class="row">
									<div class="col-sm-12">
										<div class="well well-sm">
											<div class="row">
												<div class="col-sm-12">
													<div class="form-group">
														<div class="input-group">
															<span class="input-group-addon">Assignment</span> <input
																class="form-control input-lg" placeholder="Course Name"
																type="text" name="assignment" id="assignment" readonly>
					
														</div>
													</div>
					
												</div>
					
												<div class="col-sm-12">
													<div class="form-group">
														<div class="input-group">
															<span class="input-group-addon">Assignment Description</span> <input
																class="form-control input-lg"
																placeholder="Course Description" type="text"
																name="assignmentdescription" id="assignmentdescription" readonly>
					
														</div>
													</div>
					
												</div>
											</div>
										</div>
									</div>
					
								</div>
								<!-- end of above set -->
								
								<!-- start of next set -->
								<div class="row">
									<div class="col-sm-12">
										<div class="well well-sm"
											style="background-color: transparent; border: 0">
					
											<div class="row">
												<div class="well well-sm well-light">
					
													<div class="jarviswidget" id="wid-id-5"
														data-widget-colorbutton="false" data-widget-editbutton="false"
														data-widget-fullscreenbutton="false"
														data-widget-custombutton="false" data-widget-sortable="false">
														<header>
															<h2>Assignment Material</h2>
															<div class="widget-toolbar hidden-phone">
																<div class="smart-form"></div>
															</div>
														</header>
					
														<div>
					
															<!-- widget edit box -->
															<div class="jarviswidget-editbox">
																<!-- This area used as dropdown edit box -->
					
															</div>
															<!-- end widget edit box -->
					
															<!-- widget content -->
															<div class="widget-body">
					
																<div class="tabs-left">
																	<ul class="nav nav-tabs tabs-left" id="demo-pill-nav">
																		<li class="active"><a href="#tab-r1" data-toggle="tab">
																				Question 1 </a></li>
																		<li><a href="#tab-r2" data-toggle="tab">
																				Question 2</a></li>
																		<li><a href="#tab-r3" data-toggle="tab">
																				Question 3</a></li>
																		<li><a href="#tab-r4" data-toggle="tab">
																				Question 4</a></li>
																		<li><a href="#tab-r5" data-toggle="tab">
																				Question 5</a></li>
																		<li><a href="#tab-r6" data-toggle="tab">
																				Question 6</a></li>
																		<li><a href="#tab-r7" data-toggle="tab">
																				Question 7</a></li>
																		<li><a href="#tab-r8" data-toggle="tab">
																				Question 8</a></li>
																		<li><a href="#tab-r9" data-toggle="tab">
																				Question 9</a></li>
																		<li><a href="#tab-r10" data-toggle="tab">
																				Question 10</a></li>
																		<li><a href="#tab-r11" data-toggle="tab">
																				Question 11</a></li>
																		<li><a href="#tab-r12" data-toggle="tab">
																				Question 12</a></li>
																		<li><a href="#tab-r13" data-toggle="tab">
																				Question 13</a></li>
																		<li><a href="#tab-r14" data-toggle="tab">
																				Question 14</a></li>
																		<li><a href="#tab-r15" data-toggle="tab">
																				Question 15</a></li>																						
																	</ul>
																	<div class="tab-content">
																		<div class="tab-pane active" id="tab-r1">
																			<div class="row">
																				<div class="inbox-message">
																				<p>
																					Hey James,
																				</p>
																				<p>
																					Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.
																				</p>	
																				
																				<p>
																					Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit. <i class="fa fa-smile-o"></i> 
																				</p>
																				
																				<br>
																				<br>
																				Thanks,<br> 
																				<strong>Sadi Orlaf</strong>
																				<br>
																				<br>
																				<small>
																					General Manager - Finance Department <br> 
																					231 Ajax Rd, Detroit MI - 48212, USA
																					<br>
																					<i class="fa fa-phone"> (313) 647 6471</i> 
																			
																				</small>
																				<br>	
																				<img src="img/logo-blacknwhite.png" height="20" width="auto" style="margin-top:7px; padding-right:9px; border-right:1px dotted #9B9B9B;" />
																			</div>
																			<div class="inbox-download">
																							2 attachment(s) — <a href="javascript:void(0);"> Download all attachments</a> 
																							
																							<ul class="inbox-download-list">
																								<li>
																									<div class="well well-sm">
																										<span>
																											<img src="img/demo/sample.jpg">
																										</span>
																										<br>
																										<strong>rocketlaunch.jpg</strong> 
																										<br>
																										400 kb 
																										<br> 
																										<a href="javascript:void(0);"> Download</a>  | <a href="javascript:void(0);"> View</a>
																									</div>
																								</li>
																								<li>
																									<div class="well well-sm">
																										<span>
																											<i class="fa fa-file"></i>
																										</span>
																										
																										<br>
																										<strong>timelogs.xsl</strong> 
																										<br>
																										1.3 mb 
																										<br> 
																										<a href="javascript:void(0);"> Download</a> | <a href="javascript:void(0);"> Share</a>
																									</div>
																								</li>
																							</ul>
																						</div>
																			</div>
																			<div class="well well-sm well-light">
																					
																				<!-- end widget -->
					
																				
																				</div>
																				
																				<div class="well well-sm well-light">
																					<div class="jarviswidget jarviswidget-color-blue" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-fullscreenbutton="false" data-widget-sortable="false">
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
																					<header>
																						<span class="widget-icon"> <i class="fa fa-pencil"></i> </span>
																						<h2>Exercise (<span style="font-size: xx-small;">Please follow the proper format shown below for proper submission</span> )</h2>
																	
																					</header>
																	
																					<!-- widget div-->
																					<div>
																	
																						<!-- widget edit box -->
																						<div class="jarviswidget-editbox">
																							<!-- This area used as dropdown edit box -->
																	
																						</div>
																						<!-- end widget edit box -->
																	
																						<!-- widget content -->
																						<div class="widget-body no-padding">
																	
																							<div class="summernote">
																									<p>	  Question :: Write your question ?</p>
																									<p>	  Content :: Any image or pdf or helping doc for supporting question.</p>
																									<p>	  Output :: Write down output.</p>
																							</div>
																							
																							<div class="widget-footer smart-form">
																	
																							<div class="btn-group">
																								
																								<button class="btn btn-sm btn-primary" type="button">
																									<i class="fa fa-times"></i> Cancel
																								</button>	
																											
																							</div>
																							<div class="btn-group">
																								
																								<button class="btn btn-sm btn-success" type="button">
																									<i class="fa fa-check"></i> Save
																								</button>	
																								
																							</div>
																	
																								<label class="checkbox pull-left">
																									<input type="checkbox" checked="checked" name="autosave" id="autosave">
																									<i></i>Auto Save 
																								</label> 
																	
																							</div>
																							
																						</div>
																						<!-- end widget content -->
																	
																					</div>
																					<!-- end widget div -->
																	
																				</div>
																				<!-- end widget -->
					
																				
																				</div>
																			
																		</div>
																		<div class="tab-pane" id="tab-r2">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-1" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone2"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r3">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-3" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone3"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r4">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone4"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r5">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone5"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r6">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone6"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r7">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone7"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r8">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone8"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r9">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone9"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r10">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone10"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r11">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone11"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r12">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone12"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r13">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone13"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r14">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone14"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																		<div class="tab-pane" id="tab-r15">
																			<div class="row">
																				<article class="col-sm-12"
																					style="height: 100%; margin-top: -60%">
																					<div class="jarviswidget jarviswidget-color-blueLight"
																						id="wid-id-4" data-widget-editbutton="false">
																						<header>
																							<span class="widget-icon"> <i
																								class="fa fa-cloud"></i>
																							</span>
																							<h2>Document Set</h2>
					
																						</header>
																						<div style="display: none">
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
																						<div>
					
																							<!-- widget edit box -->
																							<div class="jarviswidget-editbox">
																								<!-- This area used as dropdown edit box -->
					
																							</div>
																							<!-- end widget edit box -->
					
																							<!-- widget content -->
																							<div class="widget-body">
					
																								<form action="upload.php" class="dropzone"
																									id="mydropzone15"></form>
					
																							</div>
																							<!-- end widget content -->
					
																						</div>
					
																					</div>
					
																				</article>
					
																			</div>
																		</div>
																	</div>
																</div>
					
															</div>
															<!-- end widget content -->
					
														</div>
														<!-- end widget div -->
					
					
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
				
							
				<!-- end row -->

			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

		<!-- PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<span class="txt-color-white">SmartAdmin 1.8.2 <span class="hidden-xs"> - Web Application Framework</span> ÃÂÃÂ© 2014-2015</span>
				</div>

				<div class="col-xs-6 col-sm-6 text-right hidden-xs">
					<div class="txt-color-white inline-block">
						<i class="txt-color-blueLight hidden-mobile">Last account activity <i class="fa fa-clock-o"></i> <strong>52 mins ago &nbsp;</strong> </i>
						<div class="btn-group dropup">
							<button class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white" data-toggle="dropdown">
								<i class="fa fa-link"></i> <span class="caret"></span>
							</button>
							<ul class="dropdown-menu pull-right text-left">
								<li>
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">Download Progress</p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-success" style="width: 50%;"></div>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">Server Load</p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-success" style="width: 20%;"></div>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="padding-5">
										<p class="txt-color-darken font-sm no-margin">Memory Load <span class="text-danger">*critical*</span></p>
										<div class="progress progress-micro no-margin">
											<div class="progress-bar progress-bar-danger" style="width: 70%;"></div>
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
		</div>
		<!-- END PAGE FOOTER -->

		<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
		Note: These tiles are completely responsive,
		you can add as many as you like
		-->
		<div id="shortcut">
			<ul>
				<li>
					<a href="inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
				</li>
				<li>
					<a href="calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
				</li>
				<li>
					<a href="gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
				</li>
				<li>
					<a href="invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
				</li>
				<li>
					<a href="gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
				</li>
				<li>
					<a href="profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
				</li>
			</ul>
		</div>
		<!-- END SHORTCUT AREA -->

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');
			}
		</script>

		<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="<c:url value='/resources/js/app.config.js' />"></script>
		<!-- <script src="js/app.config.js"></script> -->

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="<c:url value='/resources/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js' />"></script>
		<!-- <script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>  -->

		<!-- BOOTSTRAP JS -->
		<script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js' />"></script>
		<!-- <script src="js/bootstrap/bootstrap.min.js"></script> -->

		<!-- CUSTOM NOTIFICATION -->
		<script src="<c:url value='/resources/js/notification/SmartNotification.min.js' />"></script>
		<!-- <script src="js/notification/SmartNotification.min.js"></script> -->

		<!-- JARVIS WIDGETS -->
		<script src="<c:url value='/resources/js/smartwidgets/jarvis.widget.min.js' />"></script>
		<!-- <script src="js/smartwidgets/jarvis.widget.min.js"></script> -->

		<!-- EASY PIE CHARTS -->
		<script src="<c:url value='/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js' />"></script>
		<!-- <script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script> -->

		<!-- SPARKLINES -->
		<script src="<c:url value='/resources/js/plugin/sparkline/jquery.sparkline.min.js' />"></script>
		<!-- <script src="js/plugin/sparkline/jquery.sparkline.min.js"></script> -->

		<!-- JQUERY VALIDATE -->
		<script src="<c:url value='/resources/js/plugin/jquery-validate/jquery.validate.min.js' />"></script>
		<!-- <script src="js/plugin/jquery-validate/jquery.validate.min.js"></script> -->

		<!-- JQUERY MASKED INPUT -->
		<script src="<c:url value='/resources/js/plugin/masked-input/jquery.maskedinput.min.js' />"></script>
		<!-- <script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script> -->

		<!-- JQUERY SELECT2 INPUT -->
		<script src="<c:url value='/resources/js/plugin/select2/select2.min.js' />"></script>
		<!-- <script src="js/plugin/select2/select2.min.js"></script> -->

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="<c:url value='/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js' />"></script>
		<!-- <script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script> -->

		<!-- browser msie issue fix -->
		<script src="<c:url value='/resources/js/plugin/msie-fix/jquery.mb.browser.min.js' />"></script>
		<!-- <script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script> -->

		<!-- FastClick: For mobile devices -->
		<script src="<c:url value='/resources/js/plugin/fastclick/fastclick.min.js' />"></script>
		<!-- <script src="js/plugin/fastclick/fastclick.min.js"></script> -->

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

		<!-- Demo purpose only -->
		<!-- <script src="js/demo.min.js"></script> -->
		<script src="<c:url value='/resources/js/demo.min.js' />"></script>

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value='/resources/js/app.min.js' />"></script>
		<!-- <script src="js/app.min.js"></script> -->

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="<c:url value='/resources/js/speech/voicecommand.min.js' />"></script>
		<!-- <script src="js/speech/voicecommand.min.js"></script> -->

		<!-- SmartChat UI : plugin -->
		<script src="<c:url value='/resources/js/smart-chat-ui/smart.chat.ui.min.js' />"></script>
		<!-- <script src="js/smart-chat-ui/smart.chat.ui.min.js"></script> -->
		<script src="<c:url value='/resources/js/smart-chat-ui/smart.chat.manager.min.js' />"></script>
		<!-- <script src="js/smart-chat-ui/smart.chat.manager.min.js"></script> -->
		
		<script
		src="<c:url value='/resources/js/plugin/dropzone/dropzone.min.js' />"></script>
		
		
		<!-- PAGE RELATED PLUGIN(S) -->
		
		<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
		<script src="<c:url value='/resources/js/plugin/flot/jquery.flot.cust.min.js' />"></script>
		<!-- <script src="js/plugin/flot/jquery.flot.cust.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/flot/jquery.flot.resize.min.js' />"></script>
		<!-- <script src="js/plugin/flot/jquery.flot.resize.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/flot/jquery.flot.time.min.js' />"></script>
		<!-- <script src="js/plugin/flot/jquery.flot.time.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/flot/jquery.flot.tooltip.min.js' />"></script>
		<!-- <script src="js/plugin/flot/jquery.flot.tooltip.min.js"></script> -->
		
		<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
		<script src="<c:url value='/resources/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js' />"></script>
		<!-- <script src="js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js' />"></script>
		<!-- <script src="js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script> -->
		
		<!-- Full Calendar -->
		<script src="<c:url value='/resources/js/plugin/moment/moment.min.js' />"></script>
		<!-- <script src="js/plugin/moment/moment.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/fullcalendar/jquery.fullcalendar.min.js' />"></script>
		<!-- <script src="js/plugin/fullcalendar/jquery.fullcalendar.min.js"></script> -->

		<script>
			$(document).ready(function() {

				// DO NOT REMOVE : GLOBAL FUNCTIONS!
				pageSetUp();

				/*
				 * PAGE RELATED SCRIPTS
				 */
				
				 $("#mydropzone1").dropzone(
							{
								url : "assignfileCourseOne?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
			
			//Dropzone.autoDiscover = false;
			$("#mydropzone2").dropzone(
					{
						url : "assignfileCourseTwo?",
						paramName : "file",	
						addRemoveLinks : true,
						maxFilesize : 500,
						dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
						dictResponseError : 'Error uploading file!'
					});
			
			//Dropzone.autoDiscover = false;
			$("#mydropzone3").dropzone(
					{
						url : "assignfileCourseThree?",
						paramName : "file",
						addRemoveLinks : true,
						maxFilesize : 500,
						dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
						dictResponseError : 'Error uploading file!'
					});
			
			//Dropzone.autoDiscover = false;
			$("#mydropzone4").dropzone(
					{
						url : "assignfileCourseFour?",
						paramName : "file",
						addRemoveLinks : true,
						maxFilesize : 500,
						dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
						dictResponseError : 'Error uploading file!'
					});
			
				 
				 $("#mydropzone5").dropzone(
							{
								url : "assignfileCourseFive?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone6").dropzone(
							{
								url : "assignfileCourseSix?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone7").dropzone(
							{
								url : "assignfileCourseSeven?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone8").dropzone(
							{
								url : "assignfileCourseEight?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone9").dropzone(
							{
								url : "assignfileCourseNine?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone10").dropzone(
							{
								url : "assignfileCourseTen?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone11").dropzone(
							{
								url : "assignfileCourseEleven?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone12").dropzone(
							{
								url : "assignfileCourseTwelve?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone13").dropzone(
							{
								url : "assignfileCourseThirteen?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone14").dropzone(
							{
								url : "assignfileCourseFourteen?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
					
					$("#mydropzone15").dropzone(
							{
								url : "assignfileCourseFifteen?",
								paramName : "file",
								addRemoveLinks : true,
								maxFilesize : 500,
								dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
								dictResponseError : 'Error uploading file!',
								removedfile: function(file) {
								    var name = file.name;
								    alert(file);
								    alert(name);
								    $.ajax({
								        url: 'fileCourseOneRemove?',
								        data: "file="+name,
								        dataType: 'html'
								    });
								    var _ref;
								    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;        
								}
								/* ,
								init: function () {
					                var mockFile = { name: "myimage.jpg", size: 12345, type: 'image/jpeg' };
					                this.addFile.call(this, mockFile);
					                this.options.thumbnail.call(this, mockFile, "<c:url value='/resources/img/avatars/female.png' />");
					            } */
							});
				 
				$(".js-status-update a").click(function() {
					var selText = $(this).text();
					var $this = $(this);
					$this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
					$this.parents('.dropdown-menu').find('li').removeClass('active');
					$this.parent().addClass('active');
				});

				/*
				* TODO: add a way to add more todo's to list
				*/

				// initialize sortable
				$(function() {
					$("#sortable1, #sortable2").sortable({
						handle : '.handle',
						connectWith : ".todo",
						update : countTasks
					}).disableSelection();
				});

				// check and uncheck
				$('.todo .checkbox > input[type="checkbox"]').click(function() {
					var $this = $(this).parent().parent().parent();

					if ($(this).prop('checked')) {
						$this.addClass("complete");

						// remove this if you want to undo a check list once checked
						//$(this).attr("disabled", true);
						$(this).parent().hide();

						// once clicked - add class, copy to memory then remove and add to sortable3
						$this.slideUp(500, function() {
							$this.clone().prependTo("#sortable3").effect("highlight", {}, 800);
							$this.remove();
							countTasks();
						});
					} else {
						// insert undo code here...
					}

				})
				// count tasks
				function countTasks() {

					$('.todo-group-title').each(function() {
						var $this = $(this);
						$this.find(".num-of-tasks").text($this.next().find("li").size());
					});

				}

				
				
				
				/*
				* RUN PAGE GRAPHS
				*/

				/* TAB 1: UPDATING CHART */
				// For the demo we use generated data, but normally it would be coming from the server

				var data = [], totalPoints = 200, $UpdatingChartColors = $("#updating-chart").css('color');

				function getRandomData() {
					if (data.length > 0)
						data = data.slice(1);

					// do a random walk
					while (data.length < totalPoints) {
						var prev = data.length > 0 ? data[data.length - 1] : 50;
						var y = prev + Math.random() * 10 - 5;
						if (y < 0)
							y = 0;
						if (y > 100)
							y = 100;
						data.push(y);
					}

					// zip the generated y values with the x values
					var res = [];
					for (var i = 0; i < data.length; ++i)
						res.push([i, data[i]])
					return res;
				}

				// setup control widget
				var updateInterval = 1500;
				$("#updating-chart").val(updateInterval).change(function() {

					var v = $(this).val();
					if (v && !isNaN(+v)) {
						updateInterval = +v;
						$(this).val("" + updateInterval);
					}

				});

				// setup plot
				var options = {
					yaxis : {
						min : 0,
						max : 100
					},
					xaxis : {
						min : 0,
						max : 100
					},
					colors : [$UpdatingChartColors],
					series : {
						lines : {
							lineWidth : 1,
							fill : true,
							fillColor : {
								colors : [{
									opacity : 0.4
								}, {
									opacity : 0
								}]
							},
							steps : false

						}
					}
				};

				var plot = $.plot($("#updating-chart"), [getRandomData()], options);

				/* live switch */
				$('input[type="checkbox"]#start_interval').click(function() {
					if ($(this).prop('checked')) {
						$on = true;
						updateInterval = 1500;
						update();
					} else {
						clearInterval(updateInterval);
						$on = false;
					}
				});

				function update() {
					if ($on == true) {
						plot.setData([getRandomData()]);
						plot.draw();
						setTimeout(update, updateInterval);

					} else {
						clearInterval(updateInterval)
					}

				}

				var $on = false;

				/*end updating chart*/

				/* TAB 2: Social Network  */

				$(function() {
					// jQuery Flot Chart
					var twitter = [[1, 27], [2, 34], [3, 51], [4, 48], [5, 55], [6, 65], [7, 61], [8, 70], [9, 65], [10, 75], [11, 57], [12, 59], [13, 62]], facebook = [[1, 25], [2, 31], [3, 45], [4, 37], [5, 38], [6, 40], [7, 47], [8, 55], [9, 43], [10, 50], [11, 47], [12, 39], [13, 47]], data = [{
						label : "Twitter",
						data : twitter,
						lines : {
							show : true,
							lineWidth : 1,
							fill : true,
							fillColor : {
								colors : [{
									opacity : 0.1
								}, {
									opacity : 0.13
								}]
							}
						},
						points : {
							show : true
						}
					}, {
						label : "Facebook",
						data : facebook,
						lines : {
							show : true,
							lineWidth : 1,
							fill : true,
							fillColor : {
								colors : [{
									opacity : 0.1
								}, {
									opacity : 0.13
								}]
							}
						},
						points : {
							show : true
						}
					}];

					var options = {
						grid : {
							hoverable : true
						},
						colors : ["#568A89", "#3276B1"],
						tooltip : true,
						tooltipOpts : {
							//content : "Value <b>$x</b> Value <span>$y</span>",
							defaultTheme : false
						},
						xaxis : {
							ticks : [[1, "JAN"], [2, "FEB"], [3, "MAR"], [4, "APR"], [5, "MAY"], [6, "JUN"], [7, "JUL"], [8, "AUG"], [9, "SEP"], [10, "OCT"], [11, "NOV"], [12, "DEC"], [13, "JAN+1"]]
						},
						yaxes : {

						}
					};

					var plot3 = $.plot($("#statsChart"), data, options);
				});

				// END TAB 2

				// TAB THREE GRAPH //
				/* TAB 3: Revenew  */

				$(function() {

					var trgt = [[1354586000000, 153], [1364587000000, 658], [1374588000000, 198], [1384589000000, 663], [1394590000000, 801], [1404591000000, 1080], [1414592000000, 353], [1424593000000, 749], [1434594000000, 523], [1444595000000, 258], [1454596000000, 688], [1464597000000, 364]], prft = [[1354586000000, 53], [1364587000000, 65], [1374588000000, 98], [1384589000000, 83], [1394590000000, 980], [1404591000000, 808], [1414592000000, 720], [1424593000000, 674], [1434594000000, 23], [1444595000000, 79], [1454596000000, 88], [1464597000000, 36]], sgnups = [[1354586000000, 647], [1364587000000, 435], [1374588000000, 784], [1384589000000, 346], [1394590000000, 487], [1404591000000, 463], [1414592000000, 479], [1424593000000, 236], [1434594000000, 843], [1444595000000, 657], [1454596000000, 241], [1464597000000, 341]], toggles = $("#rev-toggles"), target = $("#flotcontainer");

					var data = [{
						label : "Target Profit",
						data : trgt,
						bars : {
							show : true,
							align : "center",
							barWidth : 30 * 30 * 60 * 1000 * 80
						}
					}, {
						label : "Actual Profit",
						data : prft,
						color : '#3276B1',
						lines : {
							show : true,
							lineWidth : 3
						},
						points : {
							show : true
						}
					}, {
						label : "Actual Signups",
						data : sgnups,
						color : '#71843F',
						lines : {
							show : true,
							lineWidth : 1
						},
						points : {
							show : true
						}
					}]

					var options = {
						grid : {
							hoverable : true
						},
						tooltip : true,
						tooltipOpts : {
							//content: '%x - %y',
							//dateFormat: '%b %y',
							defaultTheme : false
						},
						xaxis : {
							mode : "time"
						},
						yaxes : {
							tickFormatter : function(val, axis) {
								return "$" + val;
							},
							max : 1200
						}

					};

					plot2 = null;

					function plotNow() {
						var d = [];
						toggles.find(':checkbox').each(function() {
							if ($(this).is(':checked')) {
								d.push(data[$(this).attr("name").substr(4, 1)]);
							}
						});
						if (d.length > 0) {
							if (plot2) {
								plot2.setData(d);
								plot2.draw();
							} else {
								plot2 = $.plot(target, d, options);
							}
						}

					};

					toggles.find(':checkbox').on('change', function() {
						plotNow();
					});
					plotNow()

				});

				/*
				 * VECTOR MAP
				 */

				data_array = {
					"US" : 4977,
					"AU" : 4873,
					"IN" : 3671,
					"BR" : 2476,
					"TR" : 1476,
					"CN" : 146,
					"CA" : 134,
					"BD" : 100
				};

				$('#vector-map').vectorMap({
					map : 'world_mill_en',
					backgroundColor : '#fff',
					regionStyle : {
						initial : {
							fill : '#c4c4c4'
						},
						hover : {
							"fill-opacity" : 1
						}
					},
					series : {
						regions : [{
							values : data_array,
							scale : ['#85a8b6', '#4d7686'],
							normalizeFunction : 'polynomial'
						}]
					},
					onRegionLabelShow : function(e, el, code) {
						if ( typeof data_array[code] == 'undefined') {
							e.preventDefault();
						} else {
							var countrylbl = data_array[code];
							el.html(el.html() + ': ' + countrylbl + ' visits');
						}
					}
				});

				/*
				 * FULL CALENDAR JS
				 */

				if ($("#calendar").length) {
					var date = new Date();
					var d = date.getDate();
					var m = date.getMonth();
					var y = date.getFullYear();

					var calendar = $('#calendar').fullCalendar({

						editable : true,
						draggable : true,
						selectable : false,
						selectHelper : true,
						unselectAuto : false,
						disableResizing : false,
						height: "auto",

						header : {
							left : 'title', //,today
							center : 'prev, next, today',
							right : 'month, agendaWeek, agenDay' //month, agendaDay,
						},

						select : function(start, end, allDay) {
							var title = prompt('Event Title:');
							if (title) {
								calendar.fullCalendar('renderEvent', {
									title : title,
									start : start,
									end : end,
									allDay : allDay
								}, true // make the event "stick"
								);
							}
							calendar.fullCalendar('unselect');
						},

						events : [{
							title : 'All Day Event',
							start : new Date(y, m, 1),
							description : 'long description',
							className : ["event", "bg-color-greenLight"],
							icon : 'fa-check'
						}, {
							title : 'Long Event',
							start : new Date(y, m, d - 5),
							end : new Date(y, m, d - 2),
							className : ["event", "bg-color-red"],
							icon : 'fa-lock'
						}, {
							id : 999,
							title : 'Repeating Event',
							start : new Date(y, m, d - 3, 16, 0),
							allDay : false,
							className : ["event", "bg-color-blue"],
							icon : 'fa-clock-o'
						}, {
							id : 999,
							title : 'Repeating Event',
							start : new Date(y, m, d + 4, 16, 0),
							allDay : false,
							className : ["event", "bg-color-blue"],
							icon : 'fa-clock-o'
						}, {
							title : 'Meeting',
							start : new Date(y, m, d, 10, 30),
							allDay : false,
							className : ["event", "bg-color-darken"]
						}, {
							title : 'Lunch',
							start : new Date(y, m, d, 12, 0),
							end : new Date(y, m, d, 14, 0),
							allDay : false,
							className : ["event", "bg-color-darken"]
						}, {
							title : 'Birthday Party',
							start : new Date(y, m, d + 1, 19, 0),
							end : new Date(y, m, d + 1, 22, 30),
							allDay : false,
							className : ["event", "bg-color-darken"]
						}, {
							title : 'Smartadmin Open Day',
							start : new Date(y, m, 28),
							end : new Date(y, m, 29),
							className : ["event", "bg-color-darken"]
						}],


						eventRender : function(event, element, icon) {
							if (!event.description == "") {
								element.find('.fc-title').append("<br/><span class='ultra-light'>" + event.description + "</span>");
							}
							if (!event.icon == "") {
								element.find('.fc-title').append("<i class='air air-top-right fa " + event.icon + " '></i>");
							}
						}
					});

				};

				/* hide default buttons */
				$('.fc-toolbar .fc-right, .fc-toolbar .fc-center').hide();

				// calendar prev
				$('#calendar-buttons #btn-prev').click(function() {
					$('.fc-prev-button').click();
					return false;
				});

				// calendar next
				$('#calendar-buttons #btn-next').click(function() {
					$('.fc-next-button').click();
					return false;
				});

				// calendar today
				$('#calendar-buttons #btn-today').click(function() {
					$('.fc-button-today').click();
					return false;
				});

				// calendar month
				$('#mt').click(function() {
					$('#calendar').fullCalendar('changeView', 'month');
				});

				// calendar agenda week
				$('#ag').click(function() {
					$('#calendar').fullCalendar('changeView', 'agendaWeek');
				});

				// calendar agenda day
				$('#td').click(function() {
					$('#calendar').fullCalendar('changeView', 'agendaDay');
				});

				/*
				 * CHAT
				 */

				$.filter_input = $('#filter-chat-list');
				$.chat_users_container = $('#chat-container > .chat-list-body')
				$.chat_users = $('#chat-users')
				$.chat_list_btn = $('#chat-container > .chat-list-open-close');
				$.chat_body = $('#chat-body');

				/*
				* LIST FILTER (CHAT)
				*/

				// custom css expression for a case-insensitive contains()
				jQuery.expr[':'].Contains = function(a, i, m) {
					return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
				};

				function listFilter(list) {// header is any element, list is an unordered list
					// create and add the filter form to the header

					$.filter_input.change(function() {
						var filter = $(this).val();
						if (filter) {
							// this finds all links in a list that contain the input,
							// and hide the ones not containing the input while showing the ones that do
							$.chat_users.find("a:not(:Contains(" + filter + "))").parent().slideUp();
							$.chat_users.find("a:Contains(" + filter + ")").parent().slideDown();
						} else {
							$.chat_users.find("li").slideDown();
						}
						return false;
					}).keyup(function() {
						// fire the above change event after every letter
						$(this).change();

					});

				}

				// on dom ready
				listFilter($.chat_users);

				// open chat list
				$.chat_list_btn.click(function() {
					$(this).parent('#chat-container').toggleClass('open');
				})

				$.chat_body.animate({
					scrollTop : $.chat_body[0].scrollHeight
				}, 500);

			});
			
			
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