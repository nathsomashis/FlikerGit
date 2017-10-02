<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.fliker.Repository.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title> Market </title>
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
	|  12. #MAIN PANEL               |  main panel                    |
	|  13. #MAIN CONTENT             |  content holder                |
	|  14. #PAGE FOOTER              |  page footer                   |
	|  15. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  16. #PLUGINS                  |  all scripts and plugins       |
	
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

		<!-- #HEADER -->
		<header id="header">
	<div id="logo-group">

		<!-- PLACE YOUR LOGO HERE -->
		<span id="logo"> <img src="img/logo.png" alt="Medha">
		</span>
		<!-- END LOGO PLACEHOLDER -->

		<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
		<span id="activity" class="activity-dropdown"> <i
			class="fa fa-user"></i> <b class="badge"> 21 </b>
		</span>

		<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
		<div class="ajax-dropdown">

				<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
				<div class="btn-group btn-group-justified" data-toggle="buttons">
					 <label class="btn btn-default"> <input type="radio"
						name="activity" id="notifications?"> Notification 
					</label> 
				</div>

				<!-- notification content -->
				<div class="ajax-notifications custom-scroll">

					<div class="alert alert-transparent">
						<h4>Click a button to show messages here</h4>
						This blank page message helps protect your privacy, or you can
						show the first message here automatically.
					</div>

					<i class="fa fa-lock fa-4x fa-border"></i>

				</div>
				<!-- end notification content -->

				<!-- footer: refresh area -->
				<%-- <span> Last updated on: 12/12/2013 9:43AM
					<button type="button"
						data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..."
						class="btn btn-xs btn-default pull-right">
						<i class="fa fa-refresh"></i>
					</button>
				</span> --%>
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

	<!-- end projects dropdown --> <!-- pulled right: nav area -->
	<div class="pull-right">

		<!-- collapse menu button -->
		<div id="hide-menu" class="btn-header pull-right">
			<span> <a href="javascript:void(0);" data-action="toggleMenu"
				title="Collapse Menu"><i class="fa fa-reorder"></i></a>
			</span>
		</div>
		<!-- end collapse menu -->

		<!-- #MOBILE -->
		<!-- Top menu profile link : this shows only when top menu is active -->
		<ul id="mobile-profile-img"
			class="header-dropdown-list hidden-xs padding-5">
			<li class=""><a href="#"
				class="dropdown-toggle no-margin userdropdown"
				data-toggle="dropdown"> <img src="img/avatars/sunny.png"
					alt="John Doe" class="online" />
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
			<span> <a href="logout?" title="Sign Out"
				data-action="userLogout"
				data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i
					class="fa fa-sign-out"></i></a>
			</span>
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
			<span> <a href="javascript:void(0);"
				data-action="launchFullscreen" title="Full Screen"><i
					class="fa fa-arrows-alt"></i></a>
			</span>
		</div>
		<div id="article" class="btn-header transparent pull-right">
				<span> <a href="createpost?" title="Article">Article</a>
				</span>
			</div>
		<!-- end fullscreen button -->

		<!-- #Voice Command: Start Speech -->
		<!-- <div id="speech-btn"
			class="btn-header transparent pull-right hidden-sm hidden-xs">
			<div>
				<a href="javascript:void(0)" title="Voice Command"
					data-action="voiceCommand"><i class="fa fa-microphone"></i></a>
				<div class="popover bottom">
					<div class="arrow"></div>
					<div class="popover-content">
						<h4 class="vc-title">
							Voice command activated <br>
							<small>Please speak clearly into the mic</small>
						</h4>
						<h4 class="vc-title-error text-center">
							<i class="fa fa-microphone-slash"></i> Voice command failed <br>
							<small class="txt-color-red">Must <strong>"Allow"</strong>
								Microphone
							</small> <br>
							<small class="txt-color-red">Must have <strong>Internet
									Connection</strong></small>
						</h4>
						<a href="javascript:void(0);" class="btn btn-success"
							onclick="commands.help()">See Commands</a> <a
							href="javascript:void(0);"
							class="btn bg-color-purple txt-color-white"
							onclick="$('#speech-btn .popover').fadeOut(50);">Close Popup</a>
					</div>
				</div>
			</div>
		</div> -->
		<!-- end voice command -->

		

	</div>
	<!-- end pulled right: nav area --> </header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		
		<%
		
			String fullname = (String)request.getAttribute("FullName");
			String gender = (String)request.getAttribute("Gender");
			String userids = (String)request.getAttribute("userid");
			String imagid = (String)request.getAttribute("ProfileImage");
			String logo = "";
			
			
		
		%>
		
		<aside id="left-panel"> <!-- User info -->
	<div class="login-info">
		<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

			<a href="#" id="show-shortcut"
			data-action="toggleShortcut"> <img src="img/avatars/sunny.png"
				alt="me" class="online" /> <span><%=fullname%></span> <i
				class="fa fa-angle-down"></i>
		</a>

		</span>
	</div>
	<!-- end user info --> <nav> <!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

	<ul>
				<!-- <li><a href="search?"><i
						class="fa fa-lg fa-fw fa-search-plus"></i> <span
						class="menu-item-parent">Search</span> </a></li> -->
				<!-- <li><a href="dashboardanalysis?"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">Dashboard</span> </a></li> -->
				<li><a href="dashboardsocial?"><i
						class="fa fa-lg fa-fw fa-retweet"></i> <span
						class="menu-item-parent">Wall</span></a></li>

				<!-- <li class="active"><a href="profile?"><i
						class="fa fa-lg fa-fw fa-info"></i> <span class="menu-item-parent">Profile</span>
						<span class="badge pull-right inbox-badge margin-right-13">14</span></a></li> -->
				<!-- <li><a href="timeline?"><i class="fa fa-lg fa-fw fa-road"></i>
						<span class="menu-item-parent">Timeline</span></a></li> -->
				<!-- <li><a href="createpost?" title="NewPost"><i
						class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Post
							Your Activity</span></a></li> -->
				<!-- <li><a href="classroom?" title="NewPost"><i
						class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">ClassRoom</span></a>
				</li> -->
				<li><a href="#" title="Dashboard"><i
						class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">Education</span></a>
					<ul>
						<li class=""><a href="standardguidance?" title="ClassRoom"><i
						class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Guidance</span></a>
						</li>
						<li class=""><a href="standardcourse?" title="ClassRoom"><i
						class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Courses</span></a>
						</li>
					</ul>
				</li>
				<li><a href="#" title="Dashboard"><i
					class="fa fa-lg fa-fw fa-briefcase"></i> <span
					class="menu-item-parent">OSM</span></a>
				<ul>
					<li class=""><a href="ideatoimplement?" title="NewPost"><i
							class="fa fa-tags"></i><span class="menu-item-parent">Idea-Implementation</span></a>
					</li>
					<li class=""><a href="osmprojectinfo?" title="NewJob"><i
							class="fa fa-suitcase"></i><span class="menu-item-parent">Project List</span></a>
					</li>
					<li class=""><a href="osmprojectsubscription?" title="NewJob"><i
							class="fa fa-suitcase"></i><span class="menu-item-parent">Project Resource</span></a>
					</li>
					
					
				</ul></li>

				<li class="chat-users top-menu-invisible"><a href="#"><i
						class="fa fa-lg fa-fw fa-comment-o"><em
							class="bg-color-pink flash animated">!</em></i> <span
						class="menu-item-parent">Online Chat</span></a>
					<ul>
						<li>
							<!-- DISPLAY USERS -->
							<div class="display-users">

								<input class="form-control chat-user-filter"
									placeholder="Filter" type="text"> <a href="#"
									class="usr" data-chat-id="cha1" data-chat-fname="Sadi"
									data-chat-lname="Orlaf" data-chat-status="busy"
									data-chat-alertmsg="Sadi Orlaf is in a meeting. Please do not disturb!"
									data-chat-alertshow="true" data-rel="popover-hover"
									data-placement="right" data-html="true"
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
									data-chat-fname="Jessica" data-chat-lname="Dolof"
									data-chat-status="online" data-chat-alertmsg=""
									data-chat-alertshow="false" data-rel="popover-hover"
									data-placement="right" data-html="true"
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
									data-chat-fname="Zekarburg" data-chat-lname="Almandalie"
									data-chat-status="online" data-rel="popover-hover"
									data-placement="right" data-html="true"
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
									data-chat-fname="Barley" data-chat-lname="Krazurkth"
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
								</a> <a href="#" class="usr offline" data-chat-id="cha5"
									data-chat-fname="Farhana" data-chat-lname="Amrin"
									data-chat-status="incognito" data-rel="popover-hover"
									data-placement="right" data-html="true"
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
								</a> <a href="#" class="usr offline" data-chat-id="cha6"
									data-chat-fname="Lezley" data-chat-lname="Jacob"
									data-chat-status="incognito" data-rel="popover-hover"
									data-placement="right" data-html="true"
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
								</a> <a href="ajax/chat.html"
									class="btn btn-xs btn-default btn-block sa-chat-learnmore-btn">About
									the API</a>

							</div> <!-- END DISPLAY USERS -->
						</li>
					</ul></li>
			</ul>
	</nav> <span class="minifyme" data-action="minifyMenu"> <i
		class="fa fa-arrow-circle-left hit"></i>
	</span> </aside>
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
					<li>Market</li>
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
				
						<ul id="myTab1" class="nav nav-tabs bordered">
							<li class="active">
								<a href="#s1" data-toggle="tab">Cart</a>
							</li>
							<li>
								<a href="#s2" data-toggle="tab">Orders</a>
							</li>
							<li>
								<a href="#s3" data-toggle="tab">Sale</a>
							</li>
						</ul>
						<div id="myTabContent1" class="tab-content bg-color-white padding-10">
							<div class="tab-pane fade in active" id="s1">
							
								
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="false" data-widget-deletebutton="false">
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
									<h2>Cart</h2>
				
								</header>
				
								<!-- widget div-->
								<div>
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body">
				
										<div class="row">
											<form id="wizard-1" novalidate="novalidate">
												<div id="bootstrap-wizard-1" class="col-sm-12">
													<div class="form-bootstrapWizard">
														<ul class="bootstrapWizard form-wizard">
															<li class="active" data-target="#step1">
																<a href="#tab1" data-toggle="tab"> <span class="step">1</span> <span class="title">Basic information</span> </a>
															</li>
															<li data-target="#step2">
																<a href="#tab2" data-toggle="tab"> <span class="step">2</span> <span class="title">Billing information</span> </a>
															</li>
															<li data-target="#step3">
																<a href="#tab3" data-toggle="tab"> <span class="step">3</span> <span class="title">Domain Setup</span> </a>
															</li>
															<li data-target="#step4">
																<a href="#tab4" data-toggle="tab"> <span class="step">4</span> <span class="title">Save Form</span> </a>
															</li>
														</ul>
														<div class="clearfix"></div>
													</div>
													<div class="tab-content">
														<div class="tab-pane active" id="tab1">
															<br>
															<h3><strong>Step 1 </strong> - Basic Information</h3>
				
															<div class="row">
				
																<div class="col-sm-12">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-envelope fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" placeholder="email@address.com" type="text" name="email" id="email">
				
																		</div>
																	</div>
				
																</div>
				
															</div>
				
															<div class="row">
																<div class="col-sm-6">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-user fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" placeholder="First Name" type="text" name="fname" id="fname">
				
																		</div>
																	</div>
																</div>
																<div class="col-sm-6">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-user fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" placeholder="Last Name" type="text" name="lname" id="lname">
				
																		</div>
																	</div>
																</div>
															</div>
				
														</div>
														<div class="tab-pane" id="tab2">
															<br>
															<h3><strong>Step 2</strong> - Billing Information</h3>
				
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-flag fa-lg fa-fw"></i></span>
																			<select name="country" class="form-control input-lg">
																				<option value="" selected="selected">Select Country</option>
																				<option value="United States">United States</option>
																				<option value="United Kingdom">United Kingdom</option>
																				<option value="Afghanistan">Afghanistan</option>
																				<option value="Albania">Albania</option>
																				<option value="Algeria">Algeria</option>
																				<option value="American Samoa">American Samoa</option>
																				<option value="Andorra">Andorra</option>
																				<option value="Angola">Angola</option>
																				<option value="Anguilla">Anguilla</option>
																				<option value="Antarctica">Antarctica</option>
																				<option value="Antigua and Barbuda">Antigua and Barbuda</option>
																				<option value="Argentina">Argentina</option>
																				<option value="Armenia">Armenia</option>
																				<option value="Aruba">Aruba</option>
																				<option value="Australia">Australia</option>
																				<option value="Austria">Austria</option>
																				<option value="Azerbaijan">Azerbaijan</option>
																				<option value="Bahamas">Bahamas</option>
																				<option value="Bahrain">Bahrain</option>
																				<option value="Bangladesh">Bangladesh</option>
																				<option value="Barbados">Barbados</option>
																				<option value="Belarus">Belarus</option>
																				<option value="Belgium">Belgium</option>
																				<option value="Belize">Belize</option>
																				<option value="Benin">Benin</option>
																				<option value="Bermuda">Bermuda</option>
																				<option value="Bhutan">Bhutan</option>
																				<option value="Bolivia">Bolivia</option>
																				<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
																				<option value="Botswana">Botswana</option>
																				<option value="Bouvet Island">Bouvet Island</option>
																				<option value="Brazil">Brazil</option>
																				<option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
																				<option value="Brunei Darussalam">Brunei Darussalam</option>
																				<option value="Bulgaria">Bulgaria</option>
																				<option value="Burkina Faso">Burkina Faso</option>
																				<option value="Burundi">Burundi</option>
																				<option value="Cambodia">Cambodia</option>
																				<option value="Cameroon">Cameroon</option>
																				<option value="Canada">Canada</option>
																				<option value="Cape Verde">Cape Verde</option>
																				<option value="Cayman Islands">Cayman Islands</option>
																				<option value="Central African Republic">Central African Republic</option>
																				<option value="Chad">Chad</option>
																				<option value="Chile">Chile</option>
																				<option value="China">China</option>
																				<option value="Christmas Island">Christmas Island</option>
																				<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
																				<option value="Colombia">Colombia</option>
																				<option value="Comoros">Comoros</option>
																				<option value="Congo">Congo</option>
																				<option value="Congo, The Democratic Republic of The">Congo, The Democratic Republic of The</option>
																				<option value="Cook Islands">Cook Islands</option>
																				<option value="Costa Rica">Costa Rica</option>
																				<option value="Cote D'ivoire">Cote D'ivoire</option>
																				<option value="Croatia">Croatia</option>
																				<option value="Cuba">Cuba</option>
																				<option value="Cyprus">Cyprus</option>
																				<option value="Czech Republic">Czech Republic</option>
																				<option value="Denmark">Denmark</option>
																				<option value="Djibouti">Djibouti</option>
																				<option value="Dominica">Dominica</option>
																				<option value="Dominican Republic">Dominican Republic</option>
																				<option value="Ecuador">Ecuador</option>
																				<option value="Egypt">Egypt</option>
																				<option value="El Salvador">El Salvador</option>
																				<option value="Equatorial Guinea">Equatorial Guinea</option>
																				<option value="Eritrea">Eritrea</option>
																				<option value="Estonia">Estonia</option>
																				<option value="Ethiopia">Ethiopia</option>
																				<option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
																				<option value="Faroe Islands">Faroe Islands</option>
																				<option value="Fiji">Fiji</option>
																				<option value="Finland">Finland</option>
																				<option value="France">France</option>
																				<option value="French Guiana">French Guiana</option>
																				<option value="French Polynesia">French Polynesia</option>
																				<option value="French Southern Territories">French Southern Territories</option>
																				<option value="Gabon">Gabon</option>
																				<option value="Gambia">Gambia</option>
																				<option value="Georgia">Georgia</option>
																				<option value="Germany">Germany</option>
																				<option value="Ghana">Ghana</option>
																				<option value="Gibraltar">Gibraltar</option>
																				<option value="Greece">Greece</option>
																				<option value="Greenland">Greenland</option>
																				<option value="Grenada">Grenada</option>
																				<option value="Guadeloupe">Guadeloupe</option>
																				<option value="Guam">Guam</option>
																				<option value="Guatemala">Guatemala</option>
																				<option value="Guinea">Guinea</option>
																				<option value="Guinea-bissau">Guinea-bissau</option>
																				<option value="Guyana">Guyana</option>
																				<option value="Haiti">Haiti</option>
																				<option value="Heard Island and Mcdonald Islands">Heard Island and Mcdonald Islands</option>
																				<option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
																				<option value="Honduras">Honduras</option>
																				<option value="Hong Kong">Hong Kong</option>
																				<option value="Hungary">Hungary</option>
																				<option value="Iceland">Iceland</option>
																				<option value="India">India</option>
																				<option value="Indonesia">Indonesia</option>
																				<option value="Iran, Islamic Republic of">Iran, Islamic Republic of</option>
																				<option value="Iraq">Iraq</option>
																				<option value="Ireland">Ireland</option>
																				<option value="Israel">Israel</option>
																				<option value="Italy">Italy</option>
																				<option value="Jamaica">Jamaica</option>
																				<option value="Japan">Japan</option>
																				<option value="Jordan">Jordan</option>
																				<option value="Kazakhstan">Kazakhstan</option>
																				<option value="Kenya">Kenya</option>
																				<option value="Kiribati">Kiribati</option>
																				<option value="Korea, Democratic People's Republic of">Korea, Democratic People's Republic of</option>
																				<option value="Korea, Republic of">Korea, Republic of</option>
																				<option value="Kuwait">Kuwait</option>
																				<option value="Kyrgyzstan">Kyrgyzstan</option>
																				<option value="Lao People's Democratic Republic">Lao People's Democratic Republic</option>
																				<option value="Latvia">Latvia</option>
																				<option value="Lebanon">Lebanon</option>
																				<option value="Lesotho">Lesotho</option>
																				<option value="Liberia">Liberia</option>
																				<option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
																				<option value="Liechtenstein">Liechtenstein</option>
																				<option value="Lithuania">Lithuania</option>
																				<option value="Luxembourg">Luxembourg</option>
																				<option value="Macao">Macao</option>
																				<option value="Macedonia, The Former Yugoslav Republic of">Macedonia, The Former Yugoslav Republic of</option>
																				<option value="Madagascar">Madagascar</option>
																				<option value="Malawi">Malawi</option>
																				<option value="Malaysia">Malaysia</option>
																				<option value="Maldives">Maldives</option>
																				<option value="Mali">Mali</option>
																				<option value="Malta">Malta</option>
																				<option value="Marshall Islands">Marshall Islands</option>
																				<option value="Martinique">Martinique</option>
																				<option value="Mauritania">Mauritania</option>
																				<option value="Mauritius">Mauritius</option>
																				<option value="Mayotte">Mayotte</option>
																				<option value="Mexico">Mexico</option>
																				<option value="Micronesia, Federated States of">Micronesia, Federated States of</option>
																				<option value="Moldova, Republic of">Moldova, Republic of</option>
																				<option value="Monaco">Monaco</option>
																				<option value="Mongolia">Mongolia</option>
																				<option value="Montserrat">Montserrat</option>
																				<option value="Morocco">Morocco</option>
																				<option value="Mozambique">Mozambique</option>
																				<option value="Myanmar">Myanmar</option>
																				<option value="Namibia">Namibia</option>
																				<option value="Nauru">Nauru</option>
																				<option value="Nepal">Nepal</option>
																				<option value="Netherlands">Netherlands</option>
																				<option value="Netherlands Antilles">Netherlands Antilles</option>
																				<option value="New Caledonia">New Caledonia</option>
																				<option value="New Zealand">New Zealand</option>
																				<option value="Nicaragua">Nicaragua</option>
																				<option value="Niger">Niger</option>
																				<option value="Nigeria">Nigeria</option>
																				<option value="Niue">Niue</option>
																				<option value="Norfolk Island">Norfolk Island</option>
																				<option value="Northern Mariana Islands">Northern Mariana Islands</option>
																				<option value="Norway">Norway</option>
																				<option value="Oman">Oman</option>
																				<option value="Pakistan">Pakistan</option>
																				<option value="Palau">Palau</option>
																				<option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option>
																				<option value="Panama">Panama</option>
																				<option value="Papua New Guinea">Papua New Guinea</option>
																				<option value="Paraguay">Paraguay</option>
																				<option value="Peru">Peru</option>
																				<option value="Philippines">Philippines</option>
																				<option value="Pitcairn">Pitcairn</option>
																				<option value="Poland">Poland</option>
																				<option value="Portugal">Portugal</option>
																				<option value="Puerto Rico">Puerto Rico</option>
																				<option value="Qatar">Qatar</option>
																				<option value="Reunion">Reunion</option>
																				<option value="Romania">Romania</option>
																				<option value="Russian Federation">Russian Federation</option>
																				<option value="Rwanda">Rwanda</option>
																				<option value="Saint Helena">Saint Helena</option>
																				<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
																				<option value="Saint Lucia">Saint Lucia</option>
																				<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
																				<option value="Saint Vincent and The Grenadines">Saint Vincent and The Grenadines</option>
																				<option value="Samoa">Samoa</option>
																				<option value="San Marino">San Marino</option>
																				<option value="Sao Tome and Principe">Sao Tome and Principe</option>
																				<option value="Saudi Arabia">Saudi Arabia</option>
																				<option value="Senegal">Senegal</option>
																				<option value="Serbia and Montenegro">Serbia and Montenegro</option>
																				<option value="Seychelles">Seychelles</option>
																				<option value="Sierra Leone">Sierra Leone</option>
																				<option value="Singapore">Singapore</option>
																				<option value="Slovakia">Slovakia</option>
																				<option value="Slovenia">Slovenia</option>
																				<option value="Solomon Islands">Solomon Islands</option>
																				<option value="Somalia">Somalia</option>
																				<option value="South Africa">South Africa</option>
																				<option value="South Georgia and The South Sandwich Islands">South Georgia and The South Sandwich Islands</option>
																				<option value="Spain">Spain</option>
																				<option value="Sri Lanka">Sri Lanka</option>
																				<option value="Sudan">Sudan</option>
																				<option value="Suriname">Suriname</option>
																				<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
																				<option value="Swaziland">Swaziland</option>
																				<option value="Sweden">Sweden</option>
																				<option value="Switzerland">Switzerland</option>
																				<option value="Syrian Arab Republic">Syrian Arab Republic</option>
																				<option value="Taiwan, Province of China">Taiwan, Province of China</option>
																				<option value="Tajikistan">Tajikistan</option>
																				<option value="Tanzania, United Republic of">Tanzania, United Republic of</option>
																				<option value="Thailand">Thailand</option>
																				<option value="Timor-leste">Timor-leste</option>
																				<option value="Togo">Togo</option>
																				<option value="Tokelau">Tokelau</option>
																				<option value="Tonga">Tonga</option>
																				<option value="Trinidad and Tobago">Trinidad and Tobago</option>
																				<option value="Tunisia">Tunisia</option>
																				<option value="Turkey">Turkey</option>
																				<option value="Turkmenistan">Turkmenistan</option>
																				<option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
																				<option value="Tuvalu">Tuvalu</option>
																				<option value="Uganda">Uganda</option>
																				<option value="Ukraine">Ukraine</option>
																				<option value="United Arab Emirates">United Arab Emirates</option>
																				<option value="United Kingdom">United Kingdom</option>
																				<option value="United States">United States</option>
																				<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
																				<option value="Uruguay">Uruguay</option>
																				<option value="Uzbekistan">Uzbekistan</option>
																				<option value="Vanuatu">Vanuatu</option>
																				<option value="Venezuela">Venezuela</option>
																				<option value="Viet Nam">Viet Nam</option>
																				<option value="Virgin Islands, British">Virgin Islands, British</option>
																				<option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
																				<option value="Wallis and Futuna">Wallis and Futuna</option>
																				<option value="Western Sahara">Western Sahara</option>
																				<option value="Yemen">Yemen</option>
																				<option value="Zambia">Zambia</option>
																				<option value="Zimbabwe">Zimbabwe</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="col-sm-4">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-map-marker fa-lg fa-fw"></i></span>
																			<select class="form-control input-lg" name="city">
																				<option value="" selected="selected">Select City</option>
																				<option>Amsterdam</option>
																				<option>Atlanta</option>
																				<option>Baltimore</option>
																				<option>Boston</option>
																				<option>Buenos Aires</option>
																				<option>Calgary</option>
																				<option>Chicago</option>
																				<option>Denver</option>
																				<option>Dubai</option>
																				<option>Frankfurt</option>
																				<option>Hong Kong</option>
																				<option>Honolulu</option>
																				<option>Houston</option>
																				<option>Kuala Lumpur</option>
																				<option>London</option>
																				<option>Los Angeles</option>
																				<option>Melbourne</option>
																				<option>Mexico City</option>
																				<option>Miami</option>
																				<option>Minneapolis</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="col-sm-4">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-envelope-o fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" placeholder="Postal Code" type="text" name="postal" id="postal">
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-6">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-phone fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" data-mask="+99 (999) 999-9999" data-mask-placeholder= "X" placeholder="+1" type="text" name="wphone" id="wphone">
																		</div>
																	</div>
																</div>
																<div class="col-sm-6">
																	<div class="form-group">
																		<div class="input-group">
																			<span class="input-group-addon"><i class="fa fa-mobile fa-lg fa-fw"></i></span>
																			<input class="form-control input-lg" data-mask="+99 (999) 999-9999" data-mask-placeholder= "X" placeholder="+01" type="text" name="hphone" id="hphone">
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="tab-pane" id="tab3">
															<br>
															<h3><strong>Step 3</strong> - Domain Setup</h3>
															<div class="alert alert-info fade in">
																<button class="close" data-dismiss="alert">
																	×
																</button>
																<i class="fa-fw fa fa-info"></i>
																<strong>Info!</strong> Place an info message box if you wish.
															</div>
															<div class="form-group">
																<label>This is a label</label>
																<input class="form-control input-lg" placeholder="Another input box here..." type="text" name="etc" id="etc">
															</div>
														</div>
														<div class="tab-pane" id="tab4">
															<br>
															<h3><strong>Step 4</strong> - Save Form</h3>
															<br>
															<h1 class="text-center text-success"><strong><i class="fa fa-check fa-lg"></i> Complete</strong></h1>
															<h4 class="text-center">Click next to finish</h4>
															<br>
															<br>
														</div>
				
														<div class="form-actions">
															<div class="row">
																<div class="col-sm-12">
																	<ul class="pager wizard no-margin">
																		<!--<li class="previous first disabled">
																		<a href="javascript:void(0);" class="btn btn-lg btn-default"> First </a>
																		</li>-->
																		<li class="previous disabled">
																			<a href="javascript:void(0);" class="btn btn-lg btn-default"> Previous </a>
																		</li>
																		<!--<li class="next last">
																		<a href="javascript:void(0);" class="btn btn-lg btn-primary"> Last </a>
																		</li>-->
																		<li class="next">
																			<a href="javascript:void(0);" class="btn btn-lg txt-color-darken"> Next </a>
																		</li>
																	</ul>
																</div>
															</div>
														</div>
				
													</div>
												</div>
											</form>
										</div>
				
									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
				
							</div>
							<div class="tab-pane fade" id="s2">
								<h1> Search <span class="semi-bold">Users/Groups/Courses/Job Interviews/Organization/Institutions/Etc..</span></h1>
								<br>
								<div class="input-group input-group-lg">
									<div class="input-group-btn">
										<button id="searchparamset" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
											User <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li class="active">
												<a href="javascript:void(0)"></i> Users</a>
											</li>
											<li>
												<a href="javascript:void(0)">Groups</a>
											</li>
											<li>
												<a href="javascript:void(0)">Organization</a>
											</li>
											<li>
												<a href="javascript:void(0)">Institutes</a>
											</li>
											<li>
												<a href="javascript:void(0)">Courses</a>
											</li>
											<li>
												<a href="javascript:void(0)">Job Interviews</a>
											</li>
											<li>
												<a href="javascript:void(0)">Specializations</a>
											</li>
										</ul>
									</div>
									<input class="form-control input-lg" type="text" placeholder="Mention the type(eg: for Groups --> #Group groupname)..." id="searchcontentspecific">
									<div class="input-group-btn">
										<button type="submit" class="btn btn-default">
											<i class="fa fa-fw fa-search fa-lg"></i>
										</button>
									</div>
								</div>
								<h1 class="font-md"> Search Results for <span class="semi-bold">Users</span><small class="text-danger"> &nbsp;&nbsp;(181 results)</small></h1>
								<br>
								<div class="row" id="searchcontentspecificresult">
								
								</div>
								
								<div class="text-center">
									<hr>
									<ul class="pagination no-margin">
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
										<li>
											<a href="javascript:void(0);">4</a>
										</li>
										<li>
											<a href="javascript:void(0);">5</a>
										</li>
										<li class="next">
											<a href="javascript:void(0);">Next</a>
										</li>
									</ul>
									<br>
									<br>
									<br>
								</div>
							</div>
							<div class="tab-pane fade" id="s3">
								<h1> Search <span class="semi-bold">history</span></h1>
								<p class="alert alert-info">
									Your search history is turned off.
				
								</p>
				
								<span class="onoffswitch-title">Auto save Search History</span>
								<span class="onoffswitch">
									<input type="checkbox" name="save_history" class="onoffswitch-checkbox" id="save_history" checked="checked">
									<label class="onoffswitch-label" for="save_history"> <span class="onoffswitch-inner" data-swchon-text="ON" data-swchoff-text="OFF"></span> <span class="onoffswitch-switch"></span> </label> </span>
				
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
					<span class="txt-color-white">SmartAdmin </span>
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

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->
		<script src="<c:url value='/resources/js/plugin/bootstrap-wizard/jquery.bootstrap.wizard.min.js' />"></script>
		<!-- <script src="js/plugin/bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script> -->
		<script src="<c:url value='/resources/js/plugin/fuelux/wizard/wizard.min.js' />"></script>
		<!-- <script src="js/plugin/fuelux/wizard/wizard.min.js"></script> -->

		<script type="text/javascript">

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
				 
				 
				 var $validator = $("#wizard-1").validate({
					    
					    rules: {
					      email: {
					        required: true,
					        email: "Your email address must be in the format of name@domain.com"
					      },
					      fname: {
					        required: true
					      },
					      lname: {
					        required: true
					      },
					      country: {
					        required: true
					      },
					      city: {
					        required: true
					      },
					      postal: {
					        required: true,
					        minlength: 4
					      },
					      wphone: {
					        required: true,
					        minlength: 10
					      },
					      hphone: {
					        required: true,
					        minlength: 10
					      }
					    },
					    
					    messages: {
					      fname: "Please specify your First name",
					      lname: "Please specify your Last name",
					      email: {
					        required: "We need your email address to contact you",
					        email: "Your email address must be in the format of name@domain.com"
					      }
					    },
					    
					    highlight: function (element) {
					      $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
					    },
					    unhighlight: function (element) {
					      $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
					    },
					    errorElement: 'span',
					    errorClass: 'help-block',
					    errorPlacement: function (error, element) {
					      if (element.parent('.input-group').length) {
					        error.insertAfter(element.parent());
					      } else {
					        error.insertAfter(element);
					      }
					    }
					  });
					  
					  $('#bootstrap-wizard-1').bootstrapWizard({
					    'tabClass': 'form-wizard',
					    'onNext': function (tab, navigation, index) {
					      var $valid = $("#wizard-1").valid();
					      if (!$valid) {
					        $validator.focusInvalid();
					        return false;
					      } else {
					        $('#bootstrap-wizard-1').find('.form-wizard').children('li').eq(index - 1).addClass(
					          'complete');
					        $('#bootstrap-wizard-1').find('.form-wizard').children('li').eq(index - 1).find('.step')
					        .html('<i class="fa fa-check"></i>');
					      }
					    }
					  });
					  
				
					// fuelux wizard
					  var wizard = $('.wizard').wizard();
					  
					  wizard.on('finished', function (e, data) {
					    //$("#fuelux-wizard").submit();
					    //console.log("submitted!");
					    $.smallBox({
					      title: "Congratulations! Your form was submitted",
					      content: "<i class='fa fa-clock-o'></i> <i>1 seconds ago...</i>",
					      color: "#5F895F",
					      iconSmall: "fa fa-check bounce animated",
					      timeout: 4000
					    });
					    
					  });
				 
				
				 
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
		<script type="text/javascript">
			function getPreviousCallSearch(){
				var searchparam = $('#searchparam').val();
				
				var pageno = $('#currentpageno').val();
				alert(pageno);
				if(searchparam!=null && searchparam!="" && pageno !== 1){
					pageno = pageno-1;
				    $.getJSON('searchContentResult?searchparam='+searchparam+'&pageno='+(pageno-1), function(dataset) {
                		console.log(dataset);
                		var searchcontent = "";
                		for(var item in dataset){
                			var contentdesc = (dataset[item].contentDescription).split(",");
                			var guidancesubject = "";
                			var profileimage = "";
                			var currentstatus = "";
                			var experience = "";
                			var contact = "";
                			var profileemail = "";
                			var profilename = "";
                			var contenttype = dataset[item].contentType;
                			var guidanceid = dataset[item].searchid;
                			
                			
                			for(var type in contentdesc){
                				var contentstate = contentdesc[type].split("::");
                				if(contentstate[0] == "Guidance Subject "){
                					guidancesubject = contentstate[1];
                				}else if(contentstate[0] == "Profile Image "){
                					profileimage = contentstate[1];
                				}else if(contentstate[0] == "Profile Name "){
                					profilename = contentstate[1];
                				}else if(contentstate[0] == "Profile Email "){
                					profileemail = contentstate[1];
                				}else if(contentstate[0] == "Profile CurrenStatus "){
                					currentstatus = contentstate[1];
                				}else if(contentstate[0] == "Profile Experience "){
                					experience = contentstate[1];
                				}else if(contentstate[0] == "Profile Contact "){
                					contact = contentstate[1];
                				}
                				
	                		}
                			
                			var searchset = '<div class="search-results clearfix smart-form"><h4><i class="fa fa-plus-square txt-color-blue">'+
    						'</i>&nbsp;<a href="javascript:void(0);">Guidance on'+guidancesubject+' provided by '+profilename+'</a></h4>'+
    						'<div><br><div class="url text-success">'+profilename+'<i class="fa fa-caret-down"></i><h3 class="margin-top-0"><br>'+
    						'<small class="font-xs"><i>Currently working as '+currentstatus+' with experience of '+experience+'<i>'+
    						'Contact: '+contact+','+profileemail+'</i></i></small></h3></div><p><a href="guidanceInfoView?guidanceid='+guidanceid+'" class="btn btn-default btn-xs">Go to Guidance</a></p></div></div>';
                			searchcontent = searchcontent + searchset;
                		}
                		$('#searchcontent').append(searchcontent);
                		$('#currentpageno').val(pageno-1);
                	});
			    }else return false;
				
			}
			
			function getNextCallSearch(){
				
				var searchparam = $('#searchparam').val();
				var currpageno = $('#currentpageno').val();
				var pageno = $('#lastpageno').val();
				var pagemath = parseInt(currpageno,10) + 1;
				alert(pagemath);
				if(searchparam!=null && searchparam!="" && pageno !== currpageno){
					pageno = pageno-1;
				    $.getJSON('searchContentResult?searchparam='+searchparam+'&pageno='+pagemath, function(dataset) {
				    	$('#searchcontent').html('');
                		console.log(dataset);
                		var searchcontent = "";
                		for(var item in dataset){
                			var contentdesc = (dataset[item].contentDescription).split(",");
                			var guidancesubject = "";
                			var profileimage = "";
                			var currentstatus = "";
                			var experience = "";
                			var contact = "";
                			var profileemail = "";
                			var profilename = "";
                			var contenttype = dataset[item].contentType;
                			var guidanceid = dataset[item].searchid;
                			
                			
                			for(var type in contentdesc){
                				var contentstate = contentdesc[type].split("::");
                				if(contentstate[0] == "Guidance Subject "){
                					guidancesubject = contentstate[1];
                				}else if(contentstate[0] == "Profile Image "){
                					profileimage = contentstate[1];
                				}else if(contentstate[0] == "Profile Name "){
                					profilename = contentstate[1];
                				}else if(contentstate[0] == "Profile Email "){
                					profileemail = contentstate[1];
                				}else if(contentstate[0] == "Profile CurrenStatus "){
                					currentstatus = contentstate[1];
                				}else if(contentstate[0] == "Profile Experience "){
                					experience = contentstate[1];
                				}else if(contentstate[0] == "Profile Contact "){
                					contact = contentstate[1];
                				}
                				
	                		}
                			
                			var searchset = '<div class="search-results clearfix smart-form"><h4><i class="fa fa-plus-square txt-color-blue">'+
    						'</i>&nbsp;<a href="javascript:void(0);">Guidance on'+guidancesubject+' provided by '+profilename+'</a></h4>'+
    						'<div><br><div class="url text-success">'+profilename+'<i class="fa fa-caret-down"></i><h3 class="margin-top-0"><br>'+
    						'<small class="font-xs"><i>Currently working as '+currentstatus+' with experience of '+experience+'<i>'+
    						'Contact: '+contact+','+profileemail+'</i></i></small></h3></div><p><a href="guidanceInfoView?guidanceid='+guidanceid+'" class="btn btn-default btn-xs">Go to Guidance</a></p></div></div>';
                			searchcontent = searchcontent + searchset;
                		}
                		$('#searchcontent').append(searchcontent);
                		$('#currentpageno').val(pageno+1);
                	});
			    }else return false;
				
				
			}
			
			function getPageCallSearch(pagenos){
				
				var searchparam = $('#searchparam').val();
				//var currpage = this.id;
				var lastpage = $('#lastpageno').val();
				alert(pagenos);
				if(searchparam!=null && searchparam!=""){
					//pageno = pageno-1;
				    $.getJSON('searchContentResult?searchparam='+searchparam+'&pageno='+pagenos, function(dataset) {
				    	$('#searchcontent').html('');
                		console.log(dataset);
                		var searchcontent = "";
                		for(var item in dataset){
                			var contentdesc = (dataset[item].contentDescription).split(",");
                			var guidancesubject = "";
                			var profileimage = "";
                			var currentstatus = "";
                			var experience = "";
                			var contact = "";
                			var profileemail = "";
                			var profilename = "";
                			var contenttype = dataset[item].contentType;
                			var guidanceid = dataset[item].searchid;
                			
                			
                			for(var type in contentdesc){
                				var contentstate = contentdesc[type].split("::");
                				if(contentstate[0] == "Guidance Subject "){
                					guidancesubject = contentstate[1];
                				}else if(contentstate[0] == "Profile Image "){
                					profileimage = contentstate[1];
                				}else if(contentstate[0] == "Profile Name "){
                					profilename = contentstate[1];
                				}else if(contentstate[0] == "Profile Email "){
                					profileemail = contentstate[1];
                				}else if(contentstate[0] == "Profile CurrenStatus "){
                					currentstatus = contentstate[1];
                				}else if(contentstate[0] == "Profile Experience "){
                					experience = contentstate[1];
                				}else if(contentstate[0] == "Profile Contact "){
                					contact = contentstate[1];
                				}
                				
	                		}
                			
                			var searchset = '<div class="search-results clearfix smart-form"><h4><i class="fa fa-plus-square txt-color-blue">'+
    						'</i>&nbsp;<a href="javascript:void(0);">Guidance on'+guidancesubject+' provided by '+profilename+'</a></h4>'+
    						'<div><br><div class="url text-success">'+profilename+'<i class="fa fa-caret-down"></i><h3 class="margin-top-0"><br>'+
    						'<small class="font-xs"><i>Currently working as '+currentstatus+' with experience of '+experience+'<i>'+
    						'Contact: '+contact+','+profileemail+'</i></i></small></h3></div><p><a href="guidanceInfoView?guidanceid='+guidanceid+'" class="btn btn-default btn-xs">Go to Guidance</a></p></div></div>';
                			searchcontent = searchcontent + searchset;
                		}
                		$('#searchcontent').append(searchcontent);
                		$('#currentpageno').val(pagenos);
                		
                		$('#searchpagenumbers li').each(function(i){
                			
                			if(pagenos === "1"){
                				var currentlink = $(this).attr("class");
                				if(currentlink.indexOf("prev") > 0){
                					$(this).attr("class", "prev disabled");
                				}
                			}else if(pagenos === lastpage){
                				if(currentlink.indexOf("prev") > 0){
                					$(this).attr("class", "prev disabled");
                				}
                			}
                			var currentlink = $(this).attr("class");
                			if(currentlink === "prev disabled" )
                			var currentthread =  (this.innerText).replace("\n","");
                			var currenthtml = (this.innerHTML)
                			
                			
                		});
                	});
			    }else return false;
			}
		
		</script>

	</body>

</html>