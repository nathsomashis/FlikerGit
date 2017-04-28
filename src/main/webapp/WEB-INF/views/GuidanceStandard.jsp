<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.fliker.Repository.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Wall</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- #CSS Links -->
<!-- Basic Styles -->
<link href='<c:url value="/resources/css/bootstrap.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css"> -->
<link href='<c:url value="/resources/css/font-awesome.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css"> -->

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link
	href='<c:url value="/resources/css/smartadmin-production-plugins.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css"> -->
<link
	href='<c:url value="/resources/css/smartadmin-production.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css"> -->
<link href='<c:url value="/resources/css/smartadmin-skins.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css"> -->

<!-- SmartAdmin RTL Support -->
<link href='<c:url value="/resources/css/smartadmin-rtl.min.css" />'
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> -->

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css"> -->
<link href='<c:url value="/resources/css/demo.min.css" />'
	rel="stylesheet">

<!-- #FAVICONS -->
<link href='<c:url value="/resources/img/favicon/favicon.ico" />'
	rel="shortcut icon" type="image/x-icon">
<!-- <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->
<link href='<c:url value="/resources/img/favicon/favicon.ico" />'
	rel="icon" type="image/x-icon">
<!-- <link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->

<!-- #GOOGLE FONT -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

<!-- #APP SCREEN / ICONS -->
<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link
	href='<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />'
	rel="apple-touch-icon">
<!-- <link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png"> -->
<link href='<c:url value="/resources/img/splash/touch-icon-ipad.png" />'
	rel="apple-touch-icon" sizes="76x76">
<!-- <link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png"> -->
<link
	href='<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />'
	rel="apple-touch-icon" sizes="120x120">
<!-- <link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png"> -->
<link
	href='<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />'
	rel="apple-touch-icon" sizes="152x152">
<!-- <link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png"> -->

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link href='<c:url value="/resources/img/splash/ipad-landscape.png" />'
	rel="apple-touch-startup-image"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)"> -->
<link href='<c:url value="/resources/img/splash/ipad-portrait.png" />'
	rel="apple-touch-startup-image"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)"> -->
<link href='<c:url value="/resources/img/splash/iphone.png" />'
	rel="apple-touch-startup-image"
	media="screen and (max-device-width: 320px)">
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
		<span id="logo"> <img src="Resource/img/logo.png" alt="Fliker">
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
					name="activity" id="offlinechatmessages?"> Msgs (14)
				</label> <label class="btn btn-default"> <input type="radio"
					name="activity" id="notifications?"> notify (3)
				</label> <label class="btn btn-default"> <input type="radio"
					name="activity" id="tasklists?"> Tasks (4)
				</label>
			</div>

			<!-- notification content -->
			<div class="ajax-notifications custom-scroll">

				<div class="alert alert-transparent">
					<h4>Click a button to show messages here</h4>
					This blank page message helps protect your privacy, or you can show
					the first message here automatically.
				</div>

				<i class="fa fa-lock fa-4x fa-border"></i>

			</div>
			<!-- end notification content -->

			<!-- footer: refresh area -->
			<span> Last updated on: 12/12/2013 9:43AM
				<button type="button"
					data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..."
					class="btn btn-xs btn-default pull-right">
					<i class="fa fa-refresh"></i>
				</button>
			</span>
			<!-- end footer -->

		</div>
		<!-- END AJAX-DROPDOWN -->
	</div>

	<!-- projects dropdown -->
	<div class="project-context hidden-xs">

		<span class="label">Projects:</span> <span
			class="project-selector dropdown-toggle" data-toggle="dropdown">Recent
			projects <i class="fa fa-angle-down"></i>
		</span>

		<!-- Suggestion: populate this list with fetch and push technique -->
		<ul class="dropdown-menu">
			<li><a href="javascript:void(0);">Online e-merchant
					management system - attaching integration with the iOS</a></li>
			<li><a href="javascript:void(0);">Notes on pipeline upgradee</a>
			</li>
			<li><a href="javascript:void(0);">Assesment Report for
					merchant account</a></li>
			<li class="divider"></li>
			<li><a href="javascript:void(0);"><i class="fa fa-power-off"></i>
					Clear</a></li>
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
					<li><a href="javascript:void(0);"
						class="padding-10 padding-top-0 padding-bottom-0"><i
							class="fa fa-cog"></i> Setting</a></li>
					<li class="divider"></li>
					<li><a href="profile.html"
						class="padding-10 padding-top-0 padding-bottom-0"> <i
							class="fa fa-user"></i> <u>P</u>rofile
					</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						class="padding-10 padding-top-0 padding-bottom-0"
						data-action="toggleShortcut"><i class="fa fa-arrow-down"></i>
							<u>S</u>hortcut</a></li>
					<li class="divider"></li>
					<li><a href="javascript:void(0);"
						class="padding-10 padding-top-0 padding-bottom-0"
						data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i>
							Full <u>S</u>creen</a></li>
					<li class="divider"></li>
					<li><a href="login.html"
						class="padding-10 padding-top-5 padding-bottom-5"
						data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>
							<strong><u>L</u>ogout</strong></a></li>
				</ul></li>
		</ul>

		<!-- logout button -->
		<div id="logout" class="btn-header transparent pull-right">
			<span> <a href="login.html" title="Sign Out"
				data-action="userLogout"
				data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i
					class="fa fa-sign-out"></i></a>
			</span>
		</div>
		<!-- end logout button -->

		<!-- search mobile button (this is hidden till mobile view port) -->
		<div id="search-mobile" class="btn-header transparent pull-right">
			<span> <a href="javascript:void(0)" title="Search"><i
					class="fa fa-search"></i></a>
			</span>
		</div>
		<!-- end search mobile button -->

		<!-- input: search field -->
		<form action="search.html" class="header-search pull-right">
			<input id="search-fld" type="text" name="param"
				placeholder="Find reports and more"
				data-autocomplete='[
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
		<!-- end fullscreen button -->

		<!-- #Voice Command: Start Speech -->
		<div id="speech-btn"
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
	<!-- end pulled right: nav area --> </header>
	<!-- END HEADER -->

	<!-- #NAVIGATION -->
	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->
	<aside id="left-panel"> <!-- User info -->
	<div class="login-info">
		<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

			<a href="javascript:void(0);" id="show-shortcut"
			data-action="toggleShortcut"> <img src="img/avatars/sunny.png"
				alt="me" class="online" /> <span> john.doe </span> <i
				class="fa fa-angle-down"></i>
		</a>

		</span>
	</div>
	<!-- end user info --> <nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
		<li class="active"><a href="search?"><i
				class="fa fa-lg fa-fw fa-search-plus txt-color-blue"></i> <span
				class="menu-item-parent">Search</span> </a></li>
		<!-- <li><a href="dashboardanalysis?"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">Dashboard</span> </a></li> -->
		<li ><a href="dashboardsocial?"><i
				class="fa fa-lg fa-fw fa-retweet "></i> <span
				class="menu-item-parent">Wall</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>

		<li><a href="profile?"><i class="fa fa-lg fa-fw fa-info"></i>
				<span class="menu-item-parent">Profile</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="timeline?"><i class="fa fa-lg fa-fw fa-road"></i>
				<span class="menu-item-parent">Timeline</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="createpost?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Post Your Activity</span></a>
		</li>
		<li><a href="classroom?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">ClassRoom</span></a>
		</li>
		<li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">Education</span></a>
			<ul>
				<li class=""><a href="courseEdu?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">Courses</span></a>
				</li>
				<li class=""><a href="otherprofile?" title="ClassRoom"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">ClassRoom</span></a>
				</li>
			</ul></li>
		 <!-- <li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">#Course Publish</span></a>
			<ul>		
				<li class="active"><a href="#" title="NewCourse"><i
								class="fa fa-plus-square txt-color-red"></i><span class="menu-item-parent">NEW</span></a>
								</li>
				<li class=""><a href="createcourse?" title="NewCourse"><i
											class="fa fa-tags"></i><span class="menu-item-parent">Your Course</span></a></li>	
				<li class=""><a href="newspecialization?" title="NewSpecialization"><i
											class="fa fa-tags"></i><span class="menu-item-parent">Your Specialization</span></a></li>
				<li class=""><a href="neworganizations?" title="NewInstitution"><i
											class="fa fa-tags"></i><span class="menu-item-parent">Your Institution</span></a></li>
			</ul>
		</li> -->
		<li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">Work</span></a>
			<ul>
				<li class=""><a href="ideatoimplement?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">Idea-Implementation</span></a>
				</li>
				<li class=""><a href="jobanalysis?" title="NewJob"><i
						class="fa fa-suitcase"></i><span class="menu-item-parent">Traditional Way</span></a>
				</li>
				
			</ul></li>
		<!-- <li class=""><a href="organizations?" title="Organizations"><i
						class="fa fa-group"></i><span class="menu-item-parent">#Work Publish</span></a>
				<ul>
				<li class=""><a href="createjob?" title="NewJob"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">New Opportunity</span></a>
				</li>
				<li class=""><a href="companies?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">Start New Company</span></a>
				</li>
			</ul></li> -->
		<li class=""><a href="#" title="Organizations"><i
						class="fa fa-group"></i><span class="menu-item-parent">Guidance</span></a>
				<ul>
				<li class=""><a href="standardguidance?" title="NewJob"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">Academic</span></a>
				</li>
				<li class=""><a href="professionalguidance?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">Professional</span></a>
				</li>
			</ul></li>		

		<li class="chat-users top-menu-invisible"><a href="#"><i
				class="fa fa-lg fa-fw fa-comment-o"><em
					class="bg-color-pink flash animated">!</em></i> <span
				class="menu-item-parent">Smart Chat API <sup>beta</sup></span></a>
			<ul>
				<li>
					<!-- DISPLAY USERS -->
					<div class="display-users">

						<input class="form-control chat-user-filter" placeholder="Filter"
							type="text"> <a href="#" class="usr" data-chat-id="cha1"
							data-chat-fname="Sadi" data-chat-lname="Orlaf"
							data-chat-status="busy"
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

			<span class="ribbon-button-alignment"> <span id="refresh"
				class="btn btn-ribbon" data-action="resetWidgets"
				data-title="refresh" rel="tooltip" data-placement="bottom"
				data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings."
				data-html="true"> <i class="fa fa-refresh"></i>
			</span>
			</span>

			<!-- breadcrumb -->
			<ol class="breadcrumb">
				<li>Search Page</li>
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
						<li class="active"><a href="#s1" data-toggle="tab">Resource
								Search<i class="fa fa-caret-down"></i>
						</a></li>
						<li><a href="#s2" data-toggle="tab">OnGoing Guidance</a></li>
						<li><a href="#s3" data-toggle="tab">Progress</a></li>
						<!-- <li class="pull-right hidden-mobile">
								<a href="javascript:void(0);"> <span class="note">About 24,431 results (0.15 seconds) </span> </a>
							</li> -->
					</ul>

					<div id="myTabContent1"
						class="tab-content bg-color-white padding-10">
						<div class="tab-pane fade in active" id="s1">
							<h1>
								Search <span class="semi-bold">Everything</span>
							</h1>
							<br>
							<div class="input-group input-group-lg hidden-mobile">
								<input class="form-control input-lg" type="text"
									placeholder="Search again..." id="search-project">
								<div class="input-group-btn">
									<button type="submit" class="btn btn-default">
										&nbsp;&nbsp;&nbsp;<i class="fa fa-fw fa-search fa-lg"></i>&nbsp;&nbsp;&nbsp;
									</button>
								</div>
							</div>

							<h1 class="font-md">
								Search Results for <small class="text-danger">
									&nbsp;&nbsp;(2,281 results)</small>
							</h1>

							<!-- <div class="search-results clearfix smart-form">

								<h4>
									<i class="fa fa-plus-square txt-color-blue"></i>&nbsp;<a
										href="javascript:void(0);">SmartAdmin - Responsive
										Dashboard Template</a>
								</h4>

								<div>
									<div class="rating display-inline">
										<input type="radio" name="stars-rating" id="stars-rating-5">
										<label for="stars-rating-5"><i class="fa fa-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-4">
										<label for="stars-rating-4"><i class="fa fa-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-3">
										<label for="stars-rating-3"><i class="fa fa-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-2">
										<label for="stars-rating-2"><i class="fa fa-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-1">
										<label for="stars-rating-1"><i class="fa fa-star"></i></label>
									</div>
									<br>
									<div class="url text-success">
										http://www.wrapbootstrap.com <i class="fa fa-caret-down"></i>
									</div>
									<p class="description">Lorem Ipsum is simply dummy text of
										the printing and typesetting industry. Lorem Ipsum has been
										the industry's standard dummy text ever since the 1500s, when
										an unknown printer took a galley of type and scrambled it to
										make a type specimen book</p>
								</div>

							</div> -->
								<div class="superbox col-sm-12">
								
											<%
												ArrayList guidancelist = (ArrayList)request.getAttribute("resourcesSearch");
												for(int m=0;m<guidancelist.size();m++){
													
													String guidanceid = "";
													String guidanceSubject = "";
													String guidanceFlag="";
													String profileid = "";
													String profileimage = "";
													String profilename = "";
													
													HashMap guidancemap = (HashMap)guidancelist.get(m);
													Set perset = guidancemap.entrySet();
													Iterator perit = perset.iterator();
													while (perit.hasNext()) {
														Map.Entry perme = (Map.Entry) perit.next();
														String keyvalue = (String) perme.getKey();
														if (keyvalue.equalsIgnoreCase("guidanceSubject")) {
															guidanceSubject = (String)perme.getValue();
														}else if (keyvalue.equalsIgnoreCase("guidanceflag")) {
															guidanceFlag = (String)perme.getValue();
														}else if (keyvalue.equalsIgnoreCase("profileid")) {
															profileid = (String)perme.getValue();
														}else if (keyvalue.equalsIgnoreCase("profileImage")) {
															profileimage = (String)perme.getValue();
														}else if (keyvalue.equalsIgnoreCase("profileName")) {
															profilename = (String)perme.getValue();
														}else if (keyvalue.equalsIgnoreCase("guidanceid")) {
															guidanceid = (String)perme.getValue();
														}
												}
													
												%>	
													<div class="superbox-list">
														<img id="<%=guidanceid%>" src="/Fliker/imageController/<%=profileimage%>" data-src="/Fliker/imageController/<%=profileimage%>" name="<%=profileid%>" alt="<%=guidanceSubject%>" title="<%=profilename%> for <%=guidanceSubject%>" class="superbox-img">
													</div>
												<%	
											}
											
											%>
											<!-- <div class="superbox-list">
												<img id="" src="img/superbox/superbox-thumb-1.jpg" data-img="img/superbox/superbox-full-1.jpg" alt="My first photoshop layer mask on a high end PSD template theme" title="Miller Cine" class="superbox-img">
											</div>
											<div class="superbox-list">
												<img src="img/superbox/superbox-thumb-2.jpg" data-img="img/superbox/superbox-full-2.jpg" alt="My first photoshop layer mask on a high end PSD template theme" title="Bridge of Edgen" class="superbox-img">
											</div> -->
											<div class="superbox-float"></div>
								</div>
								<!-- /SuperBox -->
								
								<div class="superbox-show" style="height:300px; display: none"></div>

							<div class="text-center">
								<hr>
								<ul class="pagination no-margin">
									<li class="prev disabled"><a href="javascript:void(0);">Previous</a>
									</li>
									<li class="active"><a href="javascript:void(0);">1</a></li>
									<li><a href="javascript:void(0);">2</a></li>
									<li><a href="javascript:void(0);">3</a></li>
									<li class="next"><a href="javascript:void(0);">Next</a></li>
								</ul>
								<br> <br> <br>
							</div>

						</div>

						<div class="tab-pane fade" id="s2">
							<div class="row">

								<div class="col-sm-9">

									<div class="well padding-10">
										<%
										ArrayList resourcelist = (ArrayList)request.getAttribute("ongoingResources");
										for(int m=0;m<guidancelist.size();m++){
											
											String guidanceid="";
											String sharetokenid="";
											String dashboardid = "";
											String averagevelocity = "";
											String blogid="";
											String profileid="";
											String profileimage="";
											String profilename="";
											String timetableid="";
											String consumeuserid= "";
											String particiant = "";
											
											HashMap guidancemap = (HashMap)guidancelist.get(m);
											Set perset = guidancemap.entrySet();
											Iterator perit = perset.iterator();
											while (perit.hasNext()) {
												Map.Entry perme = (Map.Entry) perit.next();
												String keyvalue = (String) perme.getKey();
												if (keyvalue.equalsIgnoreCase("sharetokenid")) {
													sharetokenid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("dashboardid")) {
													dashboardid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("averageVelocity")) {
													averagevelocity = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("blogid")) {
													blogid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("profileid")) {
													profileid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("profileImage")) {
													profileimage = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("profileName")) {
													profilename = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("guidanceid")) {
													guidanceid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timetableid")) {
													timetableid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("userid")) {
													consumeuserid = (String)perme.getValue();
												}
												
												particiant = guidanceid+","+consumeuserid;
												
											}
											
											%>
											
												<div class="row">
													<div class="col-md-4">
														<img src="/Fliker/imageController/<%=profileimage%>"
															class="img-responsive" alt="<%=profilename%>">
														<ul class="list-inline padding-10">
															<li><i class="fa fa-calendar"></i></li>
															<li><i class="fa fa-comments"></i> <a
																href="javascript:void(0);"> 38 Comments </a></li>
														</ul>
													</div>
													<div class="col-md-8 padding-left-0">
														<h3 class="margin-top-0">
															<a href="javascript:void(0);"> Why Should You Make A
																Separate Mobile Website for your Business? </a><br> <small
																class="font-xs"><i>Published by <a
																	href="javascript:void(0);">John Doe</a></i></small>
														</h3>
														<p>
															At vero eos et accusamus et iusto odio dignissimos ducimus
															qui blanditiis praesentium voluptatum deleniti atque
															corrupti quos dolores et quas molestias excepturi sint
															occaecati cupiditate non provident, similique sunt in culpa
															qui officia deserunt mollitia animi, id est laborum et
															dolorum fuga. <br> <br>Et harum quidem rerum
															facilis est et expedita distinctio lorem ipsum dolor sit
															amet, consectetur adipiscing elit. Ut non libero
															consectetur adipiscing elit magna. Sed et quam lacus. Fusce
															condimentum eleifend enim a feugiat. Pellentesque viverra
															vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
															consectetur adipiscing elit. Ut non libero magna. Sed et
															quam lacus. Fusce condimentum eleifend enim a feugiat. <br>
															<br>
														</p>
														<a class="btn btn-primary" href="javascript:void(0);">
															Read more </a> <a class="btn btn-warning"
															href="javascript:void(0);"> Edit </a> <a
															class="btn btn-success" href="javascript:void(0);">
															Publish </a>
													</div>
												</div>
											
											<%
										}
										
										
										%>
									

										<div class="row">
											<div class="col-md-4">
												<img src="img/superbox/superbox-full-15.jpg"
													class="img-responsive" alt="img">
												<ul class="list-inline padding-10">
													<li><i class="fa fa-calendar"></i> <a
														href="javascript:void(0);"> March 12, 2015 </a></li>
													<li><i class="fa fa-comments"></i> <a
														href="javascript:void(0);"> 38 Comments </a></li>
												</ul>
											</div>
											<div class="col-md-8 padding-left-0">
												<h3 class="margin-top-0">
													<a href="javascript:void(0);"> Why Should You Make A
														Separate Mobile Website for your Business? </a><br> <small
														class="font-xs"><i>Published by <a
															href="javascript:void(0);">John Doe</a></i></small>
												</h3>
												<p>
													At vero eos et accusamus et iusto odio dignissimos ducimus
													qui blanditiis praesentium voluptatum deleniti atque
													corrupti quos dolores et quas molestias excepturi sint
													occaecati cupiditate non provident, similique sunt in culpa
													qui officia deserunt mollitia animi, id est laborum et
													dolorum fuga. <br> <br>Et harum quidem rerum
													facilis est et expedita distinctio lorem ipsum dolor sit
													amet, consectetur adipiscing elit. Ut non libero
													consectetur adipiscing elit magna. Sed et quam lacus. Fusce
													condimentum eleifend enim a feugiat. Pellentesque viverra
													vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. Ut non libero magna. Sed et
													quam lacus. Fusce condimentum eleifend enim a feugiat. <br>
													<br>
												</p>
												<a class="btn btn-primary" href="javascript:void(0);">
													Read more </a> <a class="btn btn-warning"
													href="javascript:void(0);"> Edit </a> <a
													class="btn btn-success" href="javascript:void(0);">
													Publish </a>
											</div>
										</div>
										<hr>

										<div class="row">
											<div class="col-md-4">
												<img src="img/superbox/superbox-full-19.jpg"
													class="img-responsive" alt="img">
												<ul class="list-inline padding-10">
													<li><i class="fa fa-calendar"></i> <a
														href="javascript:void(0);"> March 12, 2015 </a></li>
													<li><i class="fa fa-comments"></i> <a
														href="javascript:void(0);"> 38 Comments </a></li>
												</ul>
											</div>
											<div class="col-md-8 padding-left-0">
												<h3 class="margin-top-0">
													<a href="javascript:void(0);"> Mums favorite shopping
														malls in USA </a><br> <small class="font-xs"><i>Published
															by <a href="javascript:void(0);">John Doe</a>
													</i></small>
												</h3>
												<p>
													At vero eos et accusamus et iusto odio dignissimos ducimus
													qui blanditiis praesentium voluptatum deleniti atque
													corrupti quos dolores et quas molestias excepturi sint
													occaecati cupiditate non provident, similique sunt in culpa
													qui officia deserunt mollitia animi, id est laborum et
													dolorum fuga. <br> <br>Et harum quidem rerum
													facilis est et expedita distinctio lorem ipsum dolor sit
													amet, consectetur adipiscing elit. Ut non libero
													consectetur adipiscing elit magna. Sed et quam lacus. Fusce
													condimentum eleifend enim a feugiat. Pellentesque viverra
													vehicula sem ut volutpat. Lorem ipsum dolor sit amet,
													consectetur adipiscing elit. Ut non libero magna. Sed et
													quam lacus. Fusce condimentum eleifend enim a feugiat. <br>
													<br>
												</p>
												<a class="btn btn-primary" href="javascript:void(0);">
													Read more </a>
											</div>
										</div>
										<hr>

										<div class="row">
											<div class="col-md-4">
												<img src="img/superbox/superbox-full-24.jpg"
													class="img-responsive" alt="img">
												<ul class="list-inline padding-10">
													<li><i class="fa fa-calendar"></i> <a
														href="javascript:void(0);"> March 12, 2015 </a></li>
													<li><i class="fa fa-comments"></i> <a
														href="javascript:void(0);"> 38 Comments </a></li>
												</ul>
											</div>
											<div class="col-md-8 padding-left-0">
												<h3 class="margin-top-0">
													<a href="javascript:void(0);"> Best (and Basic)
														Practices of Mobile Web Design </a><br> <small
														class="font-xs"><i>Published by <a
															href="javascript:void(0);">John Doe</a></i></small>
												</h3>
												<p>
													With the plethora of smartphones, mobile phones, and
													tablets available on the market today, research suggests
													that mobile devices will soon overtake PCs and laptops in a
													year. More and more,different platforms are made available
													for all types of consumers to access the web, even
													including TVs and gaming consoles. <br> <br> And
													all this in rapid-fire turnover—new models and
													technologies quickly coming and going like fashion trends.
													So much so that any website that is not mobile friendly
													cannot claim to be user-friendly anymore. Increasingly, web
													developers and designers utilize fluid layouts allowing
													users to browse across different platforms. <br> <br>
												</p>
												<a class="btn btn-primary" href="javascript:void(0);">
													Read more </a>
											</div>
										</div>

										<hr>

										<div class="row">
											<div class="col-md-4">
												<img src="img/superbox/superbox-full-7.jpg"
													class="img-responsive" alt="img">
												<ul class="list-inline padding-10">
													<li><i class="fa fa-calendar"></i> <a
														href="javascript:void(0);"> March 12, 2015 </a></li>
													<li><i class="fa fa-comments"></i> <a
														href="javascript:void(0);"> 38 Comments </a></li>
												</ul>
											</div>
											<div class="col-md-8 padding-left-0">
												<h3 class="margin-top-0">
													<a href="javascript:void(0);"> Responsive Design: Best
														Practices for Designing a Website </a><br> <small
														class="font-xs"><i>Published by <a
															href="javascript:void(0);">John Doe</a></i></small>
												</h3>
												<p>
													The term Responsive design means developing a website in a
													way that adapts all the computer screen resolutions.
													Particularly this concept allows a 4 column layout that is
													1292px wide, on 1025px wide screen that is divided into 2
													columns automatically. It is adaptable for android phones
													and tablet screens. This designing method is known as
													“responsive web design” <br> <br> Responsive
													designing is a different concept from traditional web
													designing, so the question arises how you should build a
													good responsive website. Here is a general practices that
													can help you to build a responsive website design. <br>
													<br>
												</p>
												<a class="btn btn-primary" href="javascript:void(0);">
													Read more </a>
											</div>
										</div>

									</div>

								</div>



							</div>
						</div>

						<div class="tab-pane fade" id="s3">
							<!-- MAIN CONTENT -->
							<div id="content">

								<div class="row">
									<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
										<h1 class="page-title txt-color-blueDark">
											<i class="fa fa-pencil-square-o fa-fw "></i> Forms <span>>
												Form Plugins </span>
										</h1>
									</div>
									<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
										<ul id="sparks" class="">
											<li class="sparks-info">
												<h5>
													My Income <span class="txt-color-blue">$47,171</span>
												</h5>
												<div
													class="sparkline txt-color-blue hidden-mobile hidden-md hidden-sm">
													1300, 1877, 2500, 2577, 2000, 2100, 3000, 2700, 3631, 2471,
													2700, 3631, 2471</div>
											</li>
											<li class="sparks-info">
												<h5>
													Site Traffic <span class="txt-color-purple"><i
														class="fa fa-arrow-circle-up" data-rel="bootstrap-tooltip"
														title="Increased"></i>&nbsp;45%</span>
												</h5>
												<div
													class="sparkline txt-color-purple hidden-mobile hidden-md hidden-sm">
													110,150,300,130,400,240,220,310,220,300, 270, 210</div>
											</li>
											<li class="sparks-info">
												<h5>
													Site Orders <span class="txt-color-greenDark"><i
														class="fa fa-shopping-cart"></i>&nbsp;2447</span>
												</h5>
												<div
													class="sparkline txt-color-greenDark hidden-mobile hidden-md hidden-sm">
													110,150,300,130,400,240,220,310,220,300, 270, 210</div>
											</li>
										</ul>
									</div>
								</div>

								<!-- widget grid -->
								<section id="widget-grid" class=""> <!-- row -->
								<div class="row">

									<!-- NEW COL START -->
									<article class="col-sm-12"> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget jarviswidget-color-blueDark"
										id="wid-id-0" data-widget-colorbutton="false"
										data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>x-ediable</h2>

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
												<div class="widget-body-toolbar">

													<div class="row">

														<div class="col-sm-6">
															<button id="enable" class="btn btn btn-default">
																enable / disable</button>
														</div>
														<div class="col-sm-6 text-right">

															<div class="onoffswitch-container">
																<span class="onoffswitch-title">Auto Open Next</span> <span
																	class="onoffswitch"> <input type="checkbox"
																	class="onoffswitch-checkbox" id="autoopen"> <label
																	class="onoffswitch-label" for="autoopen"> <span
																		class="onoffswitch-inner" data-swchon-text="ON"
																		data-swchoff-text="OFF"></span> <span
																		class="onoffswitch-switch"></span>
																</label>
																</span>


															</div>

															<div class="onoffswitch-container">
																<span class="onoffswitch-title">Open Inline</span> <span
																	class="onoffswitch"> <input type="checkbox"
																	class="onoffswitch-checkbox" id="inline"> <label
																	class="onoffswitch-label" for="inline"> <span
																		class="onoffswitch-inner" data-swchon-text="ON"
																		data-swchoff-text="OFF"></span> <span
																		class="onoffswitch-switch"></span>
																</label>
																</span>
															</div>

														</div>

													</div>


												</div>

												<table id="user" class="table table-bordered table-striped"
													style="clear: both">
													<tbody>
														<tr>
															<td style="width: 35%;">Simple text field</td>
															<td style="width: 65%"><a
																href="form-x-editable.html#" id="username"
																data-type="text" data-pk="1"
																data-original-title="Enter username">superuser</a></td>
														</tr>
														<tr>
															<td>Empty text field, required</td>
															<td><a href="form-x-editable.html#" id="firstname"
																data-type="text" data-pk="1" data-placement="right"
																data-placeholder="Required"
																data-original-title="Enter your firstname"></a></td>
														</tr>
														<tr>
															<td>Select, local array, custom display</td>
															<td><a href="form-x-editable.html#" id="sex"
																data-type="select" data-pk="1" data-value=""
																data-original-title="Select sex"></a></td>
														</tr>
														<tr>
															<td>Select, remote array, no buttons</td>
															<td><a href="form-x-editable.html#" id="group"
																data-type="select" data-pk="1" data-value="5"
																data-source="/groups" data-original-title="Select group">Admin</a></td>
														</tr>
														<tr>
															<td>Select, error while loading</td>
															<td><a href="form-x-editable.html#" id="status"
																data-type="select" data-pk="1" data-value="0"
																data-source="/status"
																data-original-title="Select status">Active</a></td>
														</tr>

														<tr>
															<td>Datepicker</td>
															<td><a href="#" id="vacation" data-type="date"
																data-viewformat="dd.mm.yyyy" data-pk="1"
																data-placement="right"
																data-original-title="When you want vacation to start?">25.02.2013</a></td>
														</tr>
														<tr>
															<td>Combodate (date)</td>
															<td><a href="form-x-editable.html#" id="dob"
																data-type="combodate" data-value="1984-05-15"
																data-format="YYYY-MM-DD" data-viewformat="DD/MM/YYYY"
																data-template="D / MMM / YYYY" data-pk="1"
																data-original-title="Select Date of birth"></a></td>
														</tr>
														<tr>
															<td>Combodate (datetime)</td>
															<td><a href="form-x-editable.html#" id="event"
																data-type="combodate" data-template="D MMM YYYY  HH:mm"
																data-format="YYYY-MM-DD HH:mm"
																data-viewformat="MMM D, YYYY, HH:mm" data-pk="1"
																data-original-title="Setup event date and time"></a></td>
														</tr>

														<tr>
															<td>Textarea, buttons below. Submit by <i>ctrl+enter</i></td>
															<td><a href="form-x-editable.html#" id="comments"
																data-type="textarea" data-pk="1"
																data-placeholder="Your comments here..."
																data-original-title="Enter comments">awesome user!</a></td>
														</tr>

														<tr>
															<td>Twitter typeahead.js</td>
															<td><a href="form-x-editable.html#" id="state2"
																data-type="typeaheadjs" data-pk="1"
																data-placement="right"
																data-original-title="Start typing State.."></a></td>
														</tr>

														<tr>
															<td>Checklist</td>
															<td><a href="form-x-editable.html#" id="fruits"
																data-type="checklist" data-value="2,3"
																data-original-title="Select fruits"></a></td>
														</tr>

														<tr>
															<td>Select2 (tags mode)</td>
															<td><a href="form-x-editable.html#" id="tags"
																data-type="select2" data-pk="1"
																data-original-title="Enter tags">html, javascript</a></td>
														</tr>

														<tr>
															<td>Select2 (dropdown mode)</td>
															<td><a href="form-x-editable.html#" id="country"
																data-type="select2" data-pk="1"
																data-select-search="true" data-value="BS"
																data-original-title="Select country"></a></td>
														</tr>

														<tr>
															<td>Custom input, several fields</td>
															<td><a href="form-x-editable.html#" id="address"
																data-type="address" data-pk="1"
																data-original-title="Please, fill address"></a></td>
														</tr>

													</tbody>
												</table>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget jarviswidget-color-darken"
										id="wid-id-1" data-widget-colorbutton="false"
										data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>Sliders</h2>

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

												<form>

													<fieldset>
														<legend> Smart Scale Slider </legend>
														<div class="row">
															<div class="col-sm-6">

																<div class="form-group">
																	<input id="range-slider-1" type="text" name="range_1"
																		value="">
																</div>
															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<input id="range-slider-2" type="text" name="range_2">
																</div>
															</div>
														</div>

														<div class="row">
															<div class="col-sm-6">

																<div class="form-group">
																	<input id="range-slider-3" type="text" name="range_2a"
																		value="">
																</div>
															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<input id="range-slider-4" type="text" name="range_4"
																		value="">
																</div>
															</div>
														</div>

														<div class="row">
															<div class="col-sm-12">

																<div class="form-group">
																	<input id="range-slider-5" type="text" name="range_5a"
																		value="">
																</div>
															</div>
														</div>

													</fieldset>

													<fieldset>
														<legend> noScale Slider </legend>
														<div class="row">
															<div class="col-sm-6">

																<div class="form-group">
																	<label>Default</label>
																	<div id="nouislider-1" class="noUiSlider"></div>
																</div>
															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<label>Range slider (<span
																		class="nouislider-value">20 - 60</span>)
																	</label>
																	<div id="nouislider-3" class="noUiSlider"></div>
																</div>

															</div>
														</div>


														<div class="row">
															<div class="col-sm-6">

																<div class="form-group">
																	<label>Default Slider (disabled)</label>
																	<div id="nouislider-4" class="noUiSlider"></div>
																</div>
															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<label>Skips a beat</label>
																	<div id="nouislider-2" class="noUiSlider"></div>
																</div>

															</div>
														</div>
													</fieldset>

													<fieldset class="margin-top-10">

														<legend> JQuery UI Slider </legend>
														<div class="row">
															<div class="col-sm-6">
																<label><code>.slider .slider-danger</code></label> <input
																	type="text" class="slider slider-danger" id="sal"
																	value="" data-slider-min="10" data-slider-max="1000"
																	data-slider-step="1" data-slider-value="[50,450]"
																	data-slider-handle="round">
															</div>
															<div class="col-sm-6">
																<label><code>.slider .slider-success</code></label> <input
																	type="text" class="slider slider-success" id="sa2"
																	value="" data-slider-min="10" data-slider-max="1000"
																	data-slider-step="1" data-slider-value="[150,760]"
																	data-slider-handle="triangle">
															</div>
														</div>
														<div class="row">
															<div class="col-sm-6">
																<label><code>.slider .slider-warning</code></label> <input
																	type="text" class="slider slider-warning" id="sa3"
																	value="" data-slider-min="1" data-slider-max="300"
																	data-slider-value="150" data-slider-selection="before"
																	data-slider-handle="squar">
															</div>
															<div class="col-sm-6">
																<label><code>.slider .slider-info</code></label> <input
																	type="text" class="slider slider-info" id="sa4"
																	value="" data-slider-min="1" data-slider-max="300"
																	data-slider-value="150" data-slider-selection="after"
																	data-slider-handle="round">
															</div>
														</div>

														<div class="row">
															<div class="col-sm-12">
																<label><code>.slider .slider-primary</code></label> <input
																	type="text" class="slider slider-primary" id="sa5"
																	value="" data-slider-min="1" data-slider-max="300"
																	data-slider-value="150" data-slider-selection="before"
																	data-slider-handle="round">
															</div>
														</div>

														<div class="row">

															<div class="col-sm-6">

																<pre>
																	<strong class="margin-top-10 margin-bottom-10 font-lg">Usage</strong><br>
				<code>
																		<strong>&lt;input data-slider-min="10" ..  /&gt;</strong>
																	</code>
				data-slider-orientation="vertical" <span class="text-muted"> // vertical or horizontal</span>
				data-slider-step="1"               <span class="text-muted"> // increment step</span>
				data-slider-min="10"               <span class="text-muted"> // slider min value</span>
				data-slider-max="500"              <span class="text-muted"> // slider max value</span>
				data-slider-value="315"            <span class="text-muted"> // handler position on slider</span>
				data-slider-selection = "after"    <span class="text-muted"> // handler position on slider</span>
				data-slider-handle="round"         <span class="text-muted"> // round or square</span> 
				data-slider-tooltip = "show"       <span class="text-muted"> // show or hide</span> 
														</pre>
															</div>

															<div class="col-sm-6">

																<div class="well">

																	<table>
																		<tbody>
																			<tr>
																				<td><input type="text"
																					class="slider slider-danger" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-13"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-handle="square"
																					data-slider-tooltip="hide"></td>
																				<td><input type="text" class="slider" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-11"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-handle="triangle"
																					data-slider-tooltip="hide"></td>
																				<td><input type="text" class="slider" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-6"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-tooltip="hide"></td>
																				<td><input type="text" class="slider" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-4"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-tooltip="hide"></td>
																				<td><input type="text" class="slider" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-6"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-tooltip="hide"></td>
																				<td><input type="text"
																					class="slider slider-warning" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="[-11, 19]"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-handle="triangle"
																					data-slider-tooltip="show"></td>
																				<td><input type="text"
																					class="slider slider-success" value=""
																					data-slider-min="-20" data-slider-max="20"
																					data-slider-step="1" data-slider-value="-17"
																					data-slider-orientation="vertical"
																					data-slider-selection="after"
																					data-slider-tooltip="show"></td>
																			</tr>
																		</tbody>
																	</table>

																</div>

															</div>

														</div>
													</fieldset>


												</form>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget jarviswidget-color-darken"
										id="wid-id-2" data-widget-colorbutton="false"
										data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>Bootstrap Duallist Box</h2>

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

												<select multiple="multiple" size="10"
													name="duallistbox_demo2" id="initializeDuallistbox">
													<option value="option1">Option 1</option>
													<option value="option2">Option 2</option>
													<option value="option3" selected="selected">Option
														3</option>
													<option value="option4">Option 4</option>
													<option value="option5">Option 5</option>
													<option value="option6" selected="selected">Option
														6</option>
													<option value="option7">Option 7</option>
													<option value="option8">Option 8</option>
													<option value="option9">Option 9</option>
													<option value="option0">Option 10</option>
													<option value="option0">Option 11</option>
													<option value="option0">Option 12</option>
													<option value="option0">Option 13</option>
													<option value="option0">Option 14</option>
													<option value="option0">Option 15</option>
													<option value="option0">Option 16</option>
													<option value="option0">Option 17</option>
													<option value="option0">Option 18</option>
													<option value="option0">Option 19</option>
													<option value="option0">Option 20</option>
												</select>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> </article>
									<!-- END COL -->

								</div>

								<!-- end row --> <!-- START ROW -->

								<div class="row">

									<!-- NEW COL START -->
									<article class="col-sm-12 col-md-12 col-lg-6"> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget" id="wid-id-3"
										data-widget-colorbutton="false" data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>Plugins & Enhancers</h2>

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

												<form class="">

													<fieldset>
														<legend> Select 2 </legend>

														<div class="form-group">
															<label>Select2 Plugin (select)</label> <select
																style="width: 100%" class="select2">
																<optgroup label="Alaskan/Hawaiian Time Zone">
																	<option value="AK">Alaska</option>
																	<option value="HI">Hawaii</option>
																</optgroup>
																<optgroup label="Pacific Time Zone">
																	<option value="CA">California</option>
																	<option value="NV">Nevada</option>
																	<option value="OR">Oregon</option>
																	<option value="WA">Washington</option>
																</optgroup>
																<optgroup label="Mountain Time Zone">
																	<option value="AZ">Arizona</option>
																	<option value="CO">Colorado</option>
																	<option value="ID">Idaho</option>
																	<option value="MT">Montana</option>
																	<option value="NE">Nebraska</option>
																	<option value="NM">New Mexico</option>
																	<option value="ND">North Dakota</option>
																	<option value="UT">Utah</option>
																	<option value="WY">Wyoming</option>
																</optgroup>
																<optgroup label="Central Time Zone">
																	<option value="AL">Alabama</option>
																	<option value="AR">Arkansas</option>
																	<option value="IL">Illinois</option>
																	<option value="IA">Iowa</option>
																	<option value="KS">Kansas</option>
																	<option value="KY">Kentucky</option>
																	<option value="LA">Louisiana</option>
																	<option value="MN">Minnesota</option>
																	<option value="MS">Mississippi</option>
																	<option value="MO">Missouri</option>
																	<option value="OK">Oklahoma</option>
																	<option value="SD">South Dakota</option>
																	<option value="TX">Texas</option>
																	<option value="TN">Tennessee</option>
																	<option value="WI">Wisconsin</option>
																</optgroup>
																<optgroup label="Eastern Time Zone">
																	<option value="CT">Connecticut</option>
																	<option value="DE">Delaware</option>
																	<option value="FL">Florida</option>
																	<option value="GA">Georgia</option>
																	<option value="IN">Indiana</option>
																	<option value="ME">Maine</option>
																	<option value="MD">Maryland</option>
																	<option value="MA">Massachusetts</option>
																	<option value="MI">Michigan</option>
																	<option value="NH">New Hampshire</option>
																	<option value="NJ">New Jersey</option>
																	<option value="NY">New York</option>
																	<option value="NC">North Carolina</option>
																	<option value="OH">Ohio</option>
																	<option value="PA">Pennsylvania</option>
																	<option value="RI">Rhode Island</option>
																	<option value="SC">South Carolina</option>
																	<option value="VT">Vermont</option>
																	<option value="VA">Virginia</option>
																	<option value="WV">West Virginia</option>
																</optgroup>
															</select>

															<div class="note">
																<strong>Usage:</strong> &lt;select
																style=&quot;width:100%&quot; class=&quot;select2&quot;
																&quot;&gt;...&lt;/select&gt;
															</div>
														</div>

														<div class="form-group">
															<label>Select2 Plugin (multi-select)</label> <select
																multiple style="width: 100%" class="select2">
																<optgroup label="Alaskan/Hawaiian Time Zone">
																	<option value="AK">Alaska</option>
																	<option value="HI">Hawaii</option>
																</optgroup>
																<optgroup label="Pacific Time Zone">
																	<option value="CA">California</option>
																	<option value="NV" selected="selected">Nevada</option>
																	<option value="OR">Oregon</option>
																	<option value="WA">Washington</option>
																</optgroup>
																<optgroup label="Mountain Time Zone">
																	<option value="AZ">Arizona</option>
																	<option value="CO">Colorado</option>
																	<option value="ID">Idaho</option>
																	<option value="MT" selected="selected">Montana</option>
																	<option value="NE">Nebraska</option>
																	<option value="NM">New Mexico</option>
																	<option value="ND">North Dakota</option>
																	<option value="UT">Utah</option>
																	<option value="WY">Wyoming</option>
																</optgroup>
																<optgroup label="Central Time Zone">
																	<option value="AL">Alabama</option>
																	<option value="AR">Arkansas</option>
																	<option value="IL">Illinois</option>
																	<option value="IA">Iowa</option>
																	<option value="KS">Kansas</option>
																	<option value="KY">Kentucky</option>
																	<option value="LA">Louisiana</option>
																	<option value="MN">Minnesota</option>
																	<option value="MS">Mississippi</option>
																	<option value="MO">Missouri</option>
																	<option value="OK">Oklahoma</option>
																	<option value="SD">South Dakota</option>
																	<option value="TX">Texas</option>
																	<option value="TN">Tennessee</option>
																	<option value="WI">Wisconsin</option>
																</optgroup>
																<optgroup label="Eastern Time Zone">
																	<option value="CT">Connecticut</option>
																	<option value="DE">Delaware</option>
																	<option value="FL">Florida</option>
																	<option value="GA">Georgia</option>
																	<option value="IN">Indiana</option>
																	<option value="ME">Maine</option>
																	<option value="MD">Maryland</option>
																	<option value="MA">Massachusetts</option>
																	<option value="MI" selected="selected">Michigan</option>
																	<option value="NH">New Hampshire</option>
																	<option value="NJ">New Jersey</option>
																	<option value="NY">New York</option>
																	<option value="NC">North Carolina</option>
																	<option value="OH">Ohio</option>
																	<option value="PA">Pennsylvania</option>
																	<option value="RI">Rhode Island</option>
																	<option value="SC">South Carolina</option>
																	<option value="VT">Vermont</option>
																	<option value="VA">Virginia</option>
																	<option value="WV">West Virginia</option>
																</optgroup>
															</select>

															<div class="note">
																<strong>Usage:</strong> &lt;select multiple
																style=&quot;width:100%&quot; class=&quot;select2&quot;
																&gt;...&lt;/select&gt;
															</div>
														</div>

													</fieldset>

													<fieldset>
														<legend> Date Picker (Jquery UI) </legend>

														<div class="row">
															<div class="col-sm-12">
																<div class="form-group">
																	<label>Select a date (single):</label>
																	<div class="input-group">
																		<input type="text" name="mydate"
																			placeholder="Select a date"
																			class="form-control datepicker"
																			data-dateformat="dd/mm/yy"> <span
																			class="input-group-addon"><i
																			class="fa fa-calendar"></i></span>
																	</div>
																</div>
															</div>

															<div class="col-sm-12">
																<label>Select a date (range):</label>
															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<div class="input-group">
																		<input class="form-control" id="from" type="text"
																			placeholder="From"> <span
																			class="input-group-addon"><i
																			class="fa fa-calendar"></i></span>
																	</div>
																</div>

															</div>
															<div class="col-sm-6">

																<div class="form-group">
																	<div class="input-group">
																		<input class="form-control" id="to" type="text"
																			placeholder="Select a date"> <span
																			class="input-group-addon"><i
																			class="fa fa-calendar"></i></span>
																	</div>
																</div>

															</div>

														</div>
													</fieldset>

													<fieldset>
														<legend> Bootstrap Timepicker </legend>

														<div class="row">

															<div class="col-sm-12">
																<div class="row">

																	<div class="col-sm-12">
																		<div class="form-group">
																			<label>Timepicker (default):</label>
																			<div class="input-group">
																				<input class="form-control" id="timepicker"
																					type="text" placeholder="Select time"> <span
																					class="input-group-addon"><i
																					class="fa fa-clock-o"></i></span>
																			</div>
																		</div>
																	</div>

																</div>
															</div>

														</div>

													</fieldset>

													<fieldset>
														<legend> Clockpicker </legend>

														<div class="row">

															<div class="col-sm-12">
																<div class="row">

																	<div class="col-sm-12">
																		<div class="form-group">
																			<label>Clockpicker:</label>
																			<div class="input-group">
																				<input class="form-control" id="clockpicker"
																					type="text" placeholder="Select time"
																					data-autoclose="true"> <span
																					class="input-group-addon"><i
																					class="fa fa-clock-o"></i></span>
																			</div>
																		</div>
																	</div>

																</div>
															</div>

														</div>

													</fieldset>

													<fieldset>
														<legend> Spinners </legend>

														<div class="row">

															<div class="col-sm-6 col-md-4 col-lg-4">

																<div class="form-group">
																	<label>Default</label> <input
																		class="form-control spinner-left" id="spinner"
																		name="spinner" value="1" type="text">
																</div>

															</div>
															<div class="col-sm-6 col-md-4 col-lg-4">
																<div class="form-group">
																	<label>Decimal spinner</label> <input
																		class="form-control" id="spinner-decimal"
																		name="spinner-decimal" value="7.99">
																</div>
															</div>
															<div class="col-sm-12 col-md-4 col-lg-4">
																<div class="form-group">
																	<label>Increment spinner</label> <input
																		class="form-control spinner-both"
																		id="spinner-currency" name="spinner-currency"
																		value="5">
																</div>
															</div>
														</div>

													</fieldset>

													<fieldset>
														<legend> Color Pickers </legend>

														<div class="row">

															<div class="col-sm-6">

																<div class="form-group">
																	<label>Color Picker (HEX)</label> <input
																		class="form-control" id="colorpicker-1" type="text"
																		value="#8fff00">
																</div>

															</div>
															<div class="col-sm-6">
																<div class="form-group">
																	<label>Color Picker (RGBA)</label> <input
																		class="form-control" id="colorpicker-2" type="text"
																		value="rgba(0,194,255,0.78)" data-color-format="rgba">
																</div>
															</div>
														</div>

													</fieldset>

													<fieldset>
														<legend> Tags </legend>

														<div class="row">

															<div class="col-sm-12">
																<div class="form-group">
																	<label>Type and enter to add tag</label> <input
																		class="form-control tagsinput"
																		value="Amsterdam,Washington,Sydney,Beijing,Cairo"
																		data-role="tagsinput">
																</div>
															</div>

														</div>

													</fieldset>

													<div class="form-actions">
														<div class="row">
															<div class="col-md-12">
																<button class="btn btn-default" type="submit">
																	Cancel</button>
																<button class="btn btn-primary" type="submit">
																	<i class="fa fa-save"></i> Submit
																</button>
															</div>
														</div>
													</div>

												</form>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> </article>
									<!-- END COL -->

									<!-- NEW COL START -->
									<article class="col-sm-12 col-md-12 col-lg-6"> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget" id="wid-id-4"
										data-widget-colorbutton="false" data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>All Masking</h2>

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
												<p class="alert alert-info text-align-center">
													USAGE: &lt;input type=&quot;text&quot; <strong>data-mask=&quot;99/99/9999&quot;
														data-mask-placeholder= &quot;-&quot;&gt;</strong>
												</p>

												<form>

													<fieldset>
														<legend> Input Masking made easier! </legend>

														<div class="form-group">
															<label>Date masking</label>
															<div class="input-group">
																<input type="text" class="form-control"
																	data-mask="99/99/9999" data-mask-placeholder="-">
																<span class="input-group-addon"><i
																	class="fa fa-calendar"></i></span>
															</div>
															<p class="note">Data format **/**/****</p>
														</div>

														<div class="form-group">
															<label>Phone masking</label>
															<div class="input-group">
																<input type="text" class="form-control"
																	data-mask="(999) 999-9999" data-mask-placeholder="X">
																<span class="input-group-addon"><i
																	class="fa fa-phone"></i></span>
															</div>
															<p class="note">Data format (XXX) XXX-XXXX</p>
														</div>

														<div class="form-group">
															<label>Credit card masking</label>
															<div class="input-group">
																<input type="text" class="form-control"
																	data-mask="9999-9999-9999-9999"
																	data-mask-placeholder="*"> <span
																	class="input-group-addon"><i
																	class="fa fa-credit-card"></i></span>
															</div>
															<p class="note">Data format ****-****-****-****</p>
														</div>

														<div class="form-group">
															<label>Serial number masking</label>
															<div class="input-group">
																<input type="text" class="form-control"
																	data-mask="***-***-***-***-***-***"
																	data-mask-placeholder="_"> <span
																	class="input-group-addon"><i
																	class="fa fa-asterisk"></i></span>
															</div>
															<p class="note">Data format ***-***-***-***-***-***</p>
														</div>

														<div class="form-group">
															<label>Tax ID masking</label>
															<div class="input-group">
																<input type="text" class="form-control"
																	data-mask="99-9999999" data-mask-placeholder="X">
																<span class="input-group-addon"><i
																	class="fa fa-briefcase"></i></span>
															</div>
															<p class="note">Data format 99-9999999</p>
														</div>

														<div class="form-actions">
															<div class="row">
																<div class="col-md-12">
																	<button class="btn btn-default" type="submit">
																		Cancel</button>
																	<button class="btn btn-primary" type="submit">
																		<i class="fa fa-save"></i> Submit
																	</button>
																</div>
															</div>
														</div>

													</fieldset>
												</form>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> <!-- Widget ID (each widget will need unique ID)-->
									<div class="jarviswidget jarviswidget-color-darken"
										id="wid-id-5" data-widget-colorbutton="false"
										data-widget-editbutton="false"
										data-widget-custombutton="false">
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
											class="fa fa-edit"></i>
										</span>
										<h2>JS Knob</h2>

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

												<form>

													<fieldset>
														<legend> JS Knob Input </legend>

														<div class="knobs-demo">

															<div>
																<input class="knob" data-width="120" data-height="120"
																	data-displayInput=true value="35"
																	data-displayPrevious=true data-fgColor="#428BCA">
															</div>

															<div>
																<input class="knob" data-width="180" data-height="180"
																	data-cursor=true data-fgColor="#222222"
																	data-thickness=.3 value="29">
															</div>

															<div>
																<input class="knob" data-width="80" data-height="80"
																	data-fgColor="#71843F" data-angleOffset=-125
																	data-angleArc=250 value="33" data-thickness=.3>
															</div>

														</div>

													</fieldset>
													<div class="form-actions">

														<div class="row">
															<div class="col-md-12">
																<button class="btn btn-default" type="submit">
																	Cancel</button>
																<button class="btn btn-primary" type="submit">
																	<i class="fa fa-save"></i> Submit
																</button>
															</div>
														</div>
													</div>
												</form>

											</div>
											<!-- end widget content -->

										</div>
										<!-- end widget div -->

									</div>
									<!-- end widget --> </article>
									<!-- END COL -->

								</div>

								<!-- END ROW --> </section>
								<!-- end widget grid -->

							</div>
							<!-- END MAIN CONTENT -->

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
				<span class="txt-color-white">SmartAdmin 1.8.2 <span
					class="hidden-xs"> - Web Application Framework</span> Â©
					2014-2015
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
	</div>
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
				class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span
					class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My
							Profile </span>
				</span>
			</a></li>
		</ul>
	</div>
	<!-- END SHORTCUT AREA -->

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="js/plugin/pace/pace.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script>
		if (!window.jQuery) {
			document
					.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');
		}
	</script>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
		}
	</script>

	<!-- IMPORTANT: APP CONFIG -->
	<script src="<c:url value='/resources/js/app.config.js' />"></script>
	<!-- <script src="js/app.config.js"></script> -->

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
	<script
		src="<c:url value='/resources/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js' />"></script>
	<!-- <script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>  -->

	<!-- BOOTSTRAP JS -->
	<script
		src="<c:url value='/resources/js/bootstrap/bootstrap.min.js' />"></script>
	<!-- <script src="js/bootstrap/bootstrap.min.js"></script> -->

	<!-- CUSTOM NOTIFICATION -->
	<script
		src="<c:url value='/resources/js/notification/SmartNotification.min.js' />"></script>
	<!-- <script src="js/notification/SmartNotification.min.js"></script> -->

	<!-- JARVIS WIDGETS -->
	<script
		src="<c:url value='/resources/js/smartwidgets/jarvis.widget.min.js' />"></script>
	<!-- <script src="js/smartwidgets/jarvis.widget.min.js"></script> -->

	<!-- EASY PIE CHARTS -->
	<script
		src="<c:url value='/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js' />"></script>
	<!-- <script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script> -->

	<!-- SPARKLINES -->
	<script
		src="<c:url value='/resources/js/plugin/sparkline/jquery.sparkline.min.js' />"></script>
	<!-- <script src="js/plugin/sparkline/jquery.sparkline.min.js"></script> -->

	<!-- JQUERY VALIDATE -->
	<script
		src="<c:url value='/resources/js/plugin/jquery-validate/jquery.validate.min.js' />"></script>
	<!-- <script src="js/plugin/jquery-validate/jquery.validate.min.js"></script> -->

	<!-- JQUERY MASKED INPUT -->
	<script
		src="<c:url value='/resources/js/plugin/masked-input/jquery.maskedinput.min.js' />"></script>
	<!-- <script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script> -->

	<!-- JQUERY SELECT2 INPUT -->
	<script
		src="<c:url value='/resources/js/plugin/select2/select2.min.js' />"></script>
	<!-- <script src="js/plugin/select2/select2.min.js"></script> -->

	<!-- JQUERY UI + Bootstrap Slider -->
	<script
		src="<c:url value='/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js' />"></script>
	<!-- <script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script> -->

	<!-- browser msie issue fix -->
	<script
		src="<c:url value='/resources/js/plugin/msie-fix/jquery.mb.browser.min.js' />"></script>
	<!-- <script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script> -->

	<!-- FastClick: For mobile devices -->
	<script
		src="<c:url value='/resources/js/plugin/fastclick/fastclick.min.js' />"></script>
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
	<script
		src="<c:url value='/resources/js/speech/voicecommand.min.js' />"></script>
	<!-- <script src="js/speech/voicecommand.min.js"></script> -->

	<!-- SmartChat UI : plugin -->
	<script
		src="<c:url value='/resources/js/smart-chat-ui/smart.chat.ui.min.js' />"></script>
	<!-- <script src="js/smart-chat-ui/smart.chat.ui.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/smart-chat-ui/smart.chat.manager.min.js' />"></script>
	<!-- <script src="js/smart-chat-ui/smart.chat.manager.min.js"></script> -->

	<script
		src="<c:url value='/resources/js/plugin/jqgrid/jquery.jqGrid.min.js' />"></script>
	<!-- <script src="js/plugin/jqgrid/jquery.jqGrid.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/jqgrid/grid.locale-en.min.js' />"></script>
	<!-- <script src="js/plugin/jqgrid/grid.locale-en.min.js"></script> -->

	<script src="<c:url value='/resources/js/clone-form-td-multiple.js' />"></script>
	<!-- <script type="text/javascript" src="js/clone-form-td-multiple.js"></script> -->

	<script
		src="<c:url value='/resources/js/plugin/dropzone/dropzone.min.js' />"></script>

	<!--  PAGE RELATED PLUGIN(S) -->
	<script
		src="<c:url value='/resources/js/plugin/maxlength/bootstrap-maxlength.min.js' />"></script>
	<!-- <script src="js/plugin/maxlength/bootstrap-maxlength.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js' />"></script>
	<!-- <script src="js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/clockpicker/clockpicker.min.js' />"></script>
	<!-- <script src="js/plugin/clockpicker/clockpicker.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/bootstrap-tags/bootstrap-tagsinput.min.js' />"></script>
	<!-- <script src="js/plugin/bootstrap-tags/bootstrap-tagsinput.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/noUiSlider/jquery.nouislider.min.js' />"></script>
	<!-- <script src="js/plugin/noUiSlider/jquery.nouislider.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/ion-slider/ion.rangeSlider.min.js' />"></script>
	<!-- <script src="js/plugin/ion-slider/ion.rangeSlider.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/bootstrap-duallistbox/jquery.bootstrap-duallistbox.min.js' />"></script>
	<!-- <script src="js/plugin/bootstrap-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>	 -->
	<script
		src="<c:url value='/resources/js/plugin/colorpicker/bootstrap-colorpicker.min.js' />"></script>
	<!-- <script src="js/plugin/colorpicker/bootstrap-colorpicker.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/knob/jquery.knob.min.js' />"></script>
	<!-- <script src="js/plugin/knob/jquery.knob.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/x-editable/moment.min.js' />"></script>
	<!-- <script src="js/plugin/x-editable/moment.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/x-editable/jquery.mockjax.min.js' />"></script>
	<!-- <script src="js/plugin/x-editable/jquery.mockjax.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/x-editable/x-editable.min.js' />"></script>
	<!-- <script src="js/plugin/x-editable/x-editable.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/typeahead/typeahead.min.js' />"></script>
	<!-- <script src="js/plugin/typeahead/typeahead.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/plugin/typeahead/typeaheadjs.min.js' />"></script>
	<!-- <script src="js/plugin/typeahead/typeaheadjs.min.js"></script> -->

	<!-- PAGE RELATED PLUGIN(S) -->
	<script
		src="<c:url value='/resources/js/plugin/bootstrap-wizard/jquery.bootstrap.wizard.min.js' />"></script>
	<script
		src="<c:url value='/resources/js/plugin/fuelux/wizard/wizard.min.js' />"></script>
	<script
		src="<c:url value='/resources/js/plugin/fullcalendar/jquery.fullcalendar.min.js' />"></script>
		
	<script src="<c:url value='/resources/js/plugin/superbox/superboxadv.min.js' />"></script>	
		


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
			 
			$('.superbox').SuperBox(); 

		})
		
		
		
		
		
	</script>

	<!-- Your GOOGLE ANALYTICS CODE Below -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-XXXXXXXX-X' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>

</body>

</html>