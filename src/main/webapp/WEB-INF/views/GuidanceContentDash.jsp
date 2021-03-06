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
		<%-- <link href='<c:url value="/resources/css/demo.min.css" />' rel="stylesheet"> --%>


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
			String profileimage = (String)request.getAttribute("ProfileImage");
			String gender = (String)request.getAttribute("Gender");
			String profilename = (String)request.getAttribute("FullName");
			String guidanceid = (String)request.getAttribute("guidanceid");
			String userid = (String)request.getAttribute("userid");
			String logo = "";
		
		%>

		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/logo.png" alt="Medha"> </span>
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown"> <i class="fa fa-user"></i> <b class="badge"> 21 </b> </span>

				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
						<label class="btn btn-default">
							<input type="radio" name="activity" id="notifications?">
							Notification</label>
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
					<%-- <span> Last updated on: 12/12/2013 9:43AM
						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right">
							<i class="fa fa-refresh"></i>
						</button> </span> --%>
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- projects dropdown -->
			<div class="project-context hidden-xs">

				<span class="label">Say:</span> <span
					class="project-selector dropdown-toggle" data-toggle="dropdown">Anything<i class="fa fa-angle-down"></i>
				</span>
	
				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu" style="border: 1px solid black">
					<h5>Daily Note</h5>
					<li><textarea id="notemessage" class="form-control"
							name="notemessage" rows="3" style="width: 400px"></textarea></li>
	
					<li class="divider"></li>
					<li><a href="#" id="notedown"><i class="fa fa-edit"></i>
							Note Down</a></li>
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
				<ul id="mobile-profile-img"
				class="header-dropdown-list hidden-xs padding-5">
				<li class=""><a href="#"
					class="dropdown-toggle no-margin userdropdown"
					data-toggle="dropdown"><img src="/Fliker/imageFromUserid/<%=userid%>" alt="<%=profilename%>" class="online">
				</a>
					<ul class="dropdown-menu pull-right">
						<!-- <li><a href="profile?"
							class="padding-10 padding-top-0 padding-bottom-0"> <i
								class="fa fa-user"></i> <u>P</u>rofile
						</a></li> -->
						<li class="divider"></li>
						<li><a href="javascript:void(0);"
							class="padding-10 padding-top-0 padding-bottom-0"
							data-action="toggleShortcut"><i class="fa fa-arrow-down"></i>
								<u>S</u>hortcut</a></li>
						<li class="divider"></li>
						<li><a href="logout?"
							class="padding-10 padding-top-5 padding-bottom-5"
							data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>
								<strong><u>L</u>ogout</strong></a></li>
					</ul></li>
			</ul>

				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<span> <a href="logout?" title="Sign Out" data-action="userLogout" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
			<div id="search-mobile" class="btn-header transparent pull-right">
				<span> <a href="searchresults?" title="Search"><i
						class="fa fa-search"></i></a>
				</span>
			</div>
			<!-- end search mobile button -->

			<!-- input: search field -->
			<form action="searchresults?" class="header-search pull-right">
				<input id="search-fld" type="text" name="param"
					placeholder="Find reports and more">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
				<a href="javascript:void(0);" id="cancel-search-js"
					title="Cancel Search"><i class="fa fa-times"></i></a>
			</form>
			<!-- end input: search field -->

				<!-- fullscreen button -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->
				
				<div id="article" class="btn-header transparent pull-right">
					<span> <a href="createpost?" title="Article">Article</a>
					</span>
				</div>

				
				<!-- #Voice Command: Start Speech -->
				<!-- <div id="speech-btn" class="btn-header transparent pull-right hidden-sm hidden-xs">
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
				</div> -->
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
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-fr" alt="France"> FranÃ§ais</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-es" alt="Spanish"> EspaÃ±ol</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-de" alt="German"> Deutsch</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-jp" alt="Japan"> æ—¥æœ¬èªž</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-cn" alt="China"> ä¸­æ–‡</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-it" alt="Italy"> Italiano</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-pt" alt="Portugal"> Portugal</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-ru" alt="Russia"> Ð ÑƒÑÑÐºÐ¸Ð¹ ÑÐ·Ñ‹Ðº</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="img/blank.gif" class="flag flag-kr" alt="Korea"> í•œêµ­ì–´</a>
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
			<div class="login-info">
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
		</div>
			<!-- end user info -->

			<nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
		<li ><a href="gotoguidance?guidanceid="<%=guidanceid%>><i	class="fa fa-lg fa-fw fa-puzzle-piece txt-color-blue"></i> <span
				class="menu-item-parent">Guidance Info</span> </a></li>
		<li class="active"><a href="gotoguidancedash?guidanceid="<%=guidanceid%>><i	class="fa fa-lg fa-fw fa-share-square-o"></i> <span
				class="menu-item-parent">Guidance Dashboard</span> </a></li>		
		<li ><a href="gotoguidanceshare?guidanceid="<%=guidanceid%>><i	class="fa fa-lg fa-fw fa-share-square-o"></i> <span
				class="menu-item-parent">Guidance Share</span> </a></li>

		<li><a href="gotoguidancecalendar?guidanceid="<%=guidanceid%>><i class="fa fa-lg fa-fw fa-calendar"></i>
				<span class="menu-item-parent">Guidance Calendar</span> </a></li>
		</li>
		<li><a href="gotoguidanceexcersize?guidanceid="<%=guidanceid%>><i class="fa fa-lg fa-fw fa-qrcode"></i>
				<span class="menu-item-parent">Guidance Excersize</span> </a></li>
		</li>
		<li><a href="gotoguidanceproject?guidanceid="<%=guidanceid%>><i class="fa fa-lg fa-fw fa-sitemap"></i>
				<span class="menu-item-parent">Guidance Project</span> </a></li>
		</li>
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

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>DashBoard</li>
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

				<div class="row">
					<div class="col-sm-9">
						<ul id="myTab1" class="nav nav-tabs bordered">
							<li class="active">
								<a href="#s1" data-toggle="tab">Bird View</a>
							</li>
							<li>
								<a href="#s2" data-toggle="tab">Students</a>
							</li>
						</ul>
						<div id="myTabContent1" class="tab-content bg-color-white padding-10">
							<div class="tab-pane fade in active" id="s1">
								<section id="widget-grid" class="">
									<div class="row">
										<div class="col-sm-12 well"> 
											<div class="col-sm-6">
												<table class="highchart table table-hover table-bordered" data-graph-container=".. .. .highchart-container2" data-graph-type="column">
									              <caption>Column example</caption>
									              <thead>
									                <tr>
									                  <th>Month</th>
									                  <th class="">Sales</th>
									                  <th class="">Benefits</th>
									                  <th class="">Expenses</th>
									                  <th class="">Prediction</th>
									                </tr>
									              </thead>
									              <tbody>
									                <tr>
									                  <td>January</td>
									                  <td class="">8000</td>
									                  <td class="">2000</td>
									                  <td class="">1000</td>
									                  <td class="">9000</td>
									                </tr>
									                <tr>
									                  <td>February</td>
									                  <td class="">12000</td>
									                  <td class="">3000</td>
									                  <td class="">1300</td>
									                  <td class="">10000</td>
									                </tr>
									                <tr>
									                  <td>March</td>
									                  <td class="">18000</td>
									                  <td class="">4000</td>
									                  <td class="">1240</td>
									                  <td class="">11000</td>
									                </tr>
									                <tr>
									                  <td>April</td>
									                  <td class="">2000</td>
									                  <td class="">-1000</td>
									                  <td class="">-150</td>
									                  <td class="">13000</td>
									                </tr>
									                <tr>
									                  <td>May</td>
									                  <td class="">500</td>
									                  <td class="">-2500</td>
									                  <td class="">1000</td>
									                  <td class="">14000</td>
									                </tr>
									                <tr>
									                  <td>June</td>
									                  <td class="">600</td>
									                  <td class="">-500</td>
									                  <td class="">-500</td>
									                  <td class="">15000</td>
									                </tr>
									              </tbody>
									            </table>
											</div>
											<div class="col-sm-6">
												<div class="highchart-container2"></div>
											</div>
										</div>
									</div>
									<div class="row">
				
										<article class="col-sm-12">
				
											<!-- new widget -->
											<div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false">
				
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
													<span class="widget-icon"> <i class="fa fa-map-marker"></i> </span>
													<h2>Birds Eye</h2>
													<div class="widget-toolbar hidden-mobile">
														<span class="onoffswitch-title"><i class="fa fa-location-arrow"></i> Realtime</span>
														<span class="onoffswitch">
															<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" checked="checked" id="myonoffswitch">
															<label class="onoffswitch-label" for="myonoffswitch"> <span class="onoffswitch-inner" data-swchon-text="YES" data-swchoff-text="NO"></span> <span class="onoffswitch-switch"></span> </label> </span>
													</div>
												</header>
				
												<!-- widget div-->
												<div>
													<!-- widget edit box -->
													<div class="jarviswidget-editbox">
														<div>
															<label>Title:</label>
															<input type="text" />
														</div>
													</div>
													<!-- end widget edit box -->
				
													<div class="widget-body no-padding">
														<!-- content goes here -->
				
														<div id="vector-map" class="vector-map"></div>
														<div id="heat-fill">
															<span class="fill-a">0</span>
				
															<span class="fill-b">5,000</span>
														</div>
				
														<table class="table table-striped table-hover table-condensed">
															<thead>
																<tr>
																	<th>Country</th>
																	<th>Students</th>
																	<th class="text-align-center">Scores</th>
																	<th class="text-align-center hidden-xs">Online</th>
																	<th class="text-align-center">Demographic</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td id="usa"><a href="#" onclick="loadUSMap(event)">USA</a></td>
																	<td>4,977</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-blue text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		2700, 3631, 2471, 1300, 1877, 2500, 2577, 2700, 3631, 2471, 2000, 2100, 3000
																	</div></td>
																	<td class="text-align-center hidden-xs">143</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		17,83
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
																<tr>
																	<td><a href="javascript:void(0);">Australia</a></td>
																	<td>4,873</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-blue text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		1000, 1100, 3030, 1300, -1877, -2500, -2577, -2700, 3631, 2471, 4700, 1631, 2471
																	</div></td>
																	<td class="text-align-center hidden-xs">247</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		22,88
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
																<tr>
																	<td><a href="javascript:void(0);">India</a></td>
																	<td>3,671</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-blue text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		3631, 1471, 2400, 3631, 471, 1300, 1177, 2500, 2577, 3000, 4100, 3000, 7700
																	</div></td>
																	<td class="text-align-center hidden-xs">373</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		10,90
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
																<tr>
																	<td><a href="javascript:void(0);">Brazil</a></td>
																	<td>2,476</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-blue text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		2700, 1877, 2500, 2577, 2000, 3631, 2471, -2700, -3631, 2471, 1300, 2100, 3000,
																	</div></td>
																	<td class="text-align-center hidden-xs ">741</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		34,66
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
																<tr>
																	<td><a href="javascript:void(0);">Turkey</a></td>
																	<td>1,476</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-blue text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		1300, 1877, 2500, 2577, 2000, 2100, 3000, -2471, -2700, -3631, -2471, 2700, 3631
																	</div></td>
																	<td class="text-align-center hidden-xs">123</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		75,25
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
																<tr>
																	<td><a href="javascript:void(0);">Canada</a></td>
																	<td>146</td>
																	<td class="text-align-center">
																	<div class="sparkline txt-color-orange text-align-center" data-sparkline-height="22px" data-sparkline-width="90px" data-sparkline-barwidth="2">
																		5, 34, 10, 1, 4, 6, -9, -1, 0, 0, 5, 6, 7
																	</div></td>
																	<td class="text-align-center hidden-xs">23</td>
																	<td class="text-align-center">
																	<div class="sparkline display-inline" data-sparkline-type='pie' data-sparkline-piecolor='["#E979BB", "#57889C"]' data-sparkline-offset="90" data-sparkline-piesize="23px">
																		50,50
																	</div>
																	<div class="btn-group display-inline pull-right text-align-left hidden-tablet">
																		<button class="btn btn-xs btn-default dropdown-toggle" data-toggle="dropdown">
																			<i class="fa fa-cog fa-lg"></i>
																		</button>
																		<ul class="dropdown-menu dropdown-menu-xs pull-right">
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i> <u>P</u>DF</a>
																			</li>
																			<li>
																				<a href="javascript:void(0);"><i class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																			</li>
																			<li class="divider"></li>
																			<li class="text-align-center">
																				<a href="javascript:void(0);">Cancel</a>
																			</li>
																		</ul>
																	</div></td>
																</tr>
															</tbody>
															<tfoot>
																<tr>
																	<td colspan=5>
																	<ul class="pagination pagination-xs no-margin">
																		<li class="prev disabled">
																			<a href="javascript:void(0);">Previous</a>
																		</li>
																		<li class="active">
																			<a href="javascript:void(0);">1</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">2</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">3</a>
																		</li>
																		<li class="next">
																			<a href="javascript:void(0);">Next</a>
																		</li>
																	</ul></td>
																</tr>
															</tfoot>
														</table>
				
														<!-- end content -->
				
													</div>
													<div id="india-map" class="vector-map"></div>
												</div>
												<!-- end widget div -->
											</div>
											<!-- end widget -->
				
											
										</article>
				
									</div>
				
									<!-- end row -->
				
								</section>
								
								
							</div>
							<div class="tab-pane fade" id="s2">
								<section id="widget-grid" class="">
									<div class="row">
								<article class="col-sm-12 col-md-12 col-lg-12">
				
									<!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-10" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-deletebutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
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
											<span class="widget-icon"> <i class="fa fa-list-alt"></i> </span>
											<h2>Students Dash</h2>
						
											<div class="widget-toolbar hidden-phone">
												<div class="smart-form">
													<label class="checkbox">
														<input type="checkbox" name="checkbox">
														<i></i>Add Unregistered Students</label>
												</div>
											</div>
						
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
						
												<div class="panel-group smart-accordion-default" id="accordion-2">
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseOne-1"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i>Profile Name</a></h4>
														</div>
														<div id="collapseOne-1" class="panel-collapse collapse in">
															<div class="panel-body">
																<div class="row">
																	<div class="col-md-8">
																		<!-- <img src="img/superbox/superbox-full-15.jpg" class="img-responsive" alt="img"> -->
																		<!-- <div class="col-xs-12 col-sm-6 col-md-12 col-lg-3"> -->
																			<div class="col-sm-12 well"> 
																				<div class="col-sm-6">
																					<table class="highchart table table-hover table-bordered" data-graph-container=".. .. .highchart-container" data-graph-type="line">
																		              <caption>Line example</caption>
																		              <thead>
																		                <tr>
																		                  <th>Month</th>
																		                  <th>Sales</th>
																		                  <th>Benefits</th>
																		                  <th>Incentives</th>
																		                </tr>
																		              </thead>
																		              <tbody>
																		                <tr>
																		                  <td>January</td>
																		                  <td>8000</td>
																		                  <td>2000</td>
																		                  <td>1000</td>
																		                </tr>
																		                <tr>
																		                  <td>February</td>
																		                  <td>12000</td>
																		                  <td>3000</td>
																		                  <td>2000</td>
																		                </tr>
																		                <tr>
																		                  <td>March</td>
																		                  <td>18000</td>
																		                  <td>4000</td>
																		                  <td>3000</td>
																		                </tr>
																		                <tr>
																		                  <td>April</td>
																		                  <td>2000</td>
																		                  <td>-1000</td>
																		                  <td>1000</td>
																		                </tr>
																		                <tr>
																		                  <td>May</td>
																		                  <td>500</td>
																		                  <td>-2500</td>
																		                  <td>1000</td>
																		                </tr>
																		              </tbody>
																		            </table>
																				</div>
																				<div class="col-sm-6">
																					<div class="highchart-container"></div>
																				</div>
																			</div>
																		<!-- </div> -->
																		<ul class="list-inline padding-10">
																			<li>
																				<i class="fa fa-calendar"></i>
																				<a href="javascript:void(0);"> March 12, 2015 </a>
																			</li>
																			<li>
																				<i class="fa fa-comments"></i>
																				<a href="javascript:void(0);"> 38 Comments </a>
																			</li>
																		</ul>
																	</div>
																	<div class="col-md-4 padding-left-0">
																		<ul id="myTab" class="nav nav-pills">
																			<li class="active"><a href="#more-information" data-toggle="tab" class="no-margin">Submission</a></li>
																			<li class=""><a href="#specifications" data-toggle="tab">Specification</a></li>
																		</ul>
																		<div id="myTabContent" class="tab-content">
																			<div class="tab-pane fade active in" id="more-information">
																				<br>
																				<strong>Assignment or Quiz or Project Name</strong><a href="javascript:void(0);" class="btn btn-primary btn-sm">Verify</a>
																				
																			</div>
																			<div class="tab-pane fade" id="specifications">
																				<br>
																				<blockquote>
																				  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
																				  <small>Someone famous in <cite title="Source Title"><a href="">Change</a></cite></small>
																				</blockquote>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseTwo-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #2 </a></h4>
														</div>
														<div id="collapseTwo-1" class="panel-collapse collapse">
															<div class="panel-body">
																	
															</div>
														</div>
													</div>
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseThree-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #3 </a></h4>
														</div>
														<div id="collapseThree-1" class="panel-collapse collapse">
															<div class="panel-body">
																Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.
															</div>
														</div>
													</div>
												</div>
						
											</div>
											<!-- end widget content -->
											
										</div>
										<!-- end widget div -->
						
									</div>
									<!-- end widget -->
									
								</article>	
								</div>
									
								</section>
								
								
							</div>
							
							
						</div>	
					</div>
				</div>

			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

		<!-- PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<!-- <span class="txt-color-white">SmartAdmin 1.8.2 <span class="hidden-xs"></span> -->
				</div>

				<!-- <div class="col-xs-6 col-sm-6 text-right hidden-xs">
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
				</div> -->
			</div>
		</div>
		<!-- END PAGE FOOTER -->

		<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
		Note: These tiles are completely responsive,
		you can add as many as you like
		-->
		<div id="shortcut">
		<ul>
			<li><a href="calendar.html"
				class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span
					class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span>
				</span>
			</a></li>
			<li><a href="profile?"
				class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span
					class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My
							Profile </span>
				</span>
			</a></li>
			<li><a href="timeline?"
				class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span
					class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>TimeLine </span>
				</span>
			</a></li>
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
		<%-- <script src="<c:url value='/resources/js/demo.min.js' />"></script> --%>

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
		<script src="<c:url value='/resources/js/plugin/highChartCore/highcharts-custom.min.js' />"></script>
		<!-- <script src="js/plugin/highChartCore/highcharts-custom.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/highchartTable/jquery.highchartTable.min.js' />"></script>
		<!-- <script src="js/plugin/highchartTable/jquery.highchartTable.min.js"></script> -->
		<script type="text/javascript" src="http://jvectormap.com/js/jquery-jvectormap-in-mill.js"></script>

		<script>
			$(document).ready(function() {

				// DO NOT REMOVE : GLOBAL FUNCTIONS!
				pageSetUp();

				

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
							var countrymap = 'in_mill_en';
							el.html(el.html() + ': ' + countrylbl + ' visits'+ ':' + '<a href="#" onclick="callCountry()">click</a>');
						}
					},
					onRegionClick: function (event, code) {
					    var countrymap = code+'_mill_en';
					    switchMap(countrymap);
					},
				});
				
				$('#india-map').vectorMap({
					map : 'in_mill',
					backgroundColor : '#000',
					/* regionStyle : {
						initial : {
							fill : '#c4c4c4'
						},
						hover : {
							"fill-opacity" : 1
						}
					},
					series : {
						regions : [{
							scale : ['#85a8b6', '#4d7686'],
							normalizeFunction : 'polynomial'
						}]
					} *//* ,
					onRegionLabelShow : function(e, el, code) {
						if ( typeof data_array[code] == 'undefined') {
							e.preventDefault();
						} else {
							var countrylbl = data_array[code];
							var countrymap = 'in_mill_en';
							el.html(el.html() + ': ' + countrylbl + ' visits'+ ':' + '<a href="#" onclick="callCountry()">click</a>');
						}
					},
					onRegionClick: function (event, code) {
					    var countrymap = code+'_mill_en';
					    switchMap(countrymap);
					}, */
				});
				
				$('table.highchart').highchartTable();
				
				
				
				/* $('#usa').click(function(e) {
					alert("new default");
				    e.preventDefault();
				    //var content = $(this).html();
				    $('#vector-map').replaceWith('<div id="india-map" class="vector-map"></div>');
				  }); */
				

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
			
			function loadUSMap(event){
				alert("new default");
				event.preventDefault();
			    //var content = $(this).html();
			    $('#vector-map').replaceWith('<div id="india-map" class="vector-map"></div>');
			}
			
			function switchMap(code) {
				$('#vector-map').vectorMap({
						map: 'in_mill',
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
						}
				});
				/* var scripts = document.getElementsByTagName('script');
				var index = scripts.length - 1;
				var myScript = scripts[index];
				console.log(myScript);
			    /* $.getScript('maps/'+ code +'.js' , function (data){
			        $('#map').vectorMap({map: code});
			    }); */ 
			}

		</script>
		<script type="text/javascript">
		    $(function () {
		        new jvm.MultiMap({
		            container: $('#map'),
		            maxLevel: 1,
		            main: {
		                map: 'us_lcc_en'
		            },
		            mapUrlByCode: function (code, multiMap) {
		                return 'js/counties/jquery-jvectormap-data-' +
		                   code.toLowerCase() + '-' +
		                   multiMap.defaultProjection + '-en.js';
		            }
		        });
		
		
		     onRegionClick:function(event, code) {                        
		        var name = (code);                        
		        alert(name);                    
		        }
		    });
		</script>

	</body>

</html>