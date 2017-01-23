<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!-- end user info --> <nav> <!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

	<ul>
		<li class="active"><a href="searchresults?"><i
				class="fa fa-lg fa-fw fa-search-plus"></i> <span
				class="menu-item-parent">Search</span> </a></li>
		<!-- <li><a href="dashboardanalysis?"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">Dashboard</span> </a></li> -->
		<li><a href="dashboardsocial?"><i
				class="fa fa-lg fa-fw fa-retweet txt-color-blue"></i> <span
				class="menu-item-parent">Wall</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>

		<li><a href="profile?"><i class="fa fa-lg fa-fw fa-info"></i>
				<span class="menu-item-parent">Profile</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="timeline?"><i class="fa fa-lg fa-fw fa-road"></i>
				<span class="menu-item-parent">Timeline</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="createpost?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Post
					Your Activity</span></a></li>
		<li><a href="classroom?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">ClassRoom</span></a>
		</li>
		<li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">Education</span></a>
			<ul>
				<li class=""><a href="courseEdu?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">Courses</span></a>
				</li>
				<li class=""><a href="classroom?" title="ClassRoom"><i
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
						class="fa fa-suitcase"></i><span class="menu-item-parent">Traditional
							Way</span></a></li>

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
				<li class=""><a href="createjob?" title="NewJob"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">Academic</span></a>
				</li>
				<li class=""><a href="companies?" title="Companies"><i
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
						<li class="active"><a href="#s1" data-toggle="tab">Project
								Dashboard<i class="fa fa-caret-down"></i>
						</a></li>
						<li><a href="#s2" data-toggle="tab">Project Calendar</a></li>
						<li><a href="#s3" data-toggle="tab">Project Shared</a></li>
						<li><a href="#s4" data-toggle="tab">Project Case</a></li>
						<li><a href="#s5" data-toggle="tab">Project
								Publish(!Beta)</a></li>
						<!-- <li class="pull-right hidden-mobile">
								<a href="javascript:void(0);"> <span class="note">About 24,431 results (0.15 seconds) </span> </a>
							</li> -->
					</ul>

					<div id="myTabContent1"
						class="tab-content bg-color-white padding-10">
						<div class="tab-pane fade in active" id="s1">
							<div id="content1">
								<div class="row">
									<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
										<h1 class="page-title txt-color-blueDark">
											<i class="fa-fw fa fa-home"></i> Dashboard <span>> My
												Dashboard</span>
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
														class="fa fa-arrow-circle-up"></i>&nbsp;45%</span>
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
								<section id="widget-grid" class=""> <!-- row -->
								<div class="row">
									<article class="col-sm-12"> <!-- new widget -->
									<div class="jarviswidget" id="wid-id-0"
										data-widget-togglebutton="false"
										data-widget-editbutton="false"
										data-widget-fullscreenbutton="false"
										data-widget-colorbutton="false"
										data-widget-deletebutton="false">
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
											class="glyphicon glyphicon-stats txt-color-darken"></i>
										</span>
										<h2>Live Feeds</h2>

										<ul class="nav nav-tabs pull-right in" id="myTab">
											<li class="active"><a data-toggle="tab" href="#s1"><i
													class="fa fa-clock-o"></i> <span
													class="hidden-mobile hidden-tablet">Live Stats</span></a></li>

											<li><a data-toggle="tab" href="#s2"><i
													class="fa fa-facebook"></i> <span
													class="hidden-mobile hidden-tablet">Social Network</span></a></li>

											<li><a data-toggle="tab" href="#s3"><i
													class="fa fa-dollar"></i> <span
													class="hidden-mobile hidden-tablet">Revenue</span></a></li>
										</ul>

										</header>

										<!-- widget div-->
										<div class="no-padding">
											<!-- widget edit box -->
											<div class="jarviswidget-editbox">test</div>
											<!-- end widget edit box -->

											<div class="widget-body">
												<!-- content -->
												<div id="myTabContent" class="tab-content">
													<div
														class="tab-pane fade active in padding-10 no-padding-bottom"
														id="s1">
														<div class="row no-space">
															<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
																<span class="demo-liveupdate-1"> <span
																	class="onoffswitch-title">Live switch</span> <span
																	class="onoffswitch"> <input type="checkbox"
																		name="start_interval" class="onoffswitch-checkbox"
																		id="start_interval"> <label
																		class="onoffswitch-label" for="start_interval">
																			<span class="onoffswitch-inner" data-swchon-text="ON"
																			data-swchoff-text="OFF"></span> <span
																			class="onoffswitch-switch"></span>
																	</label>
																</span>
																</span>
																<div id="updating-chart"
																	class="chart-large txt-color-blue"></div>

															</div>
															<div
																class="col-xs-12 col-sm-12 col-md-4 col-lg-4 show-stats">

																<div class="row">
																	<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
																		<span class="text"> My Tasks <span
																			class="pull-right">130/200</span>
																		</span>
																		<div class="progress">
																			<div class="progress-bar bg-color-blueDark"
																				style="width: 65%;"></div>
																		</div>
																	</div>
																	<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
																		<span class="text"> Transfered <span
																			class="pull-right">440 GB</span>
																		</span>
																		<div class="progress">
																			<div class="progress-bar bg-color-blue"
																				style="width: 34%;"></div>
																		</div>
																	</div>
																	<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
																		<span class="text"> Bugs Squashed<span
																			class="pull-right">77%</span>
																		</span>
																		<div class="progress">
																			<div class="progress-bar bg-color-blue"
																				style="width: 77%;"></div>
																		</div>
																	</div>
																	<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
																		<span class="text"> User Testing <span
																			class="pull-right">7 Days</span>
																		</span>
																		<div class="progress">
																			<div class="progress-bar bg-color-greenLight"
																				style="width: 84%;"></div>
																		</div>
																	</div>

																	<span class="show-stat-buttons"> <span
																		class="col-xs-12 col-sm-6 col-md-6 col-lg-6"> <a
																			href="javascript:void(0);"
																			class="btn btn-default btn-block hidden-xs">Generate
																				PDF</a>
																	</span> <span class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
																			<a href="javascript:void(0);"
																			class="btn btn-default btn-block hidden-xs">Report
																				a bug</a>
																	</span>
																	</span>

																</div>

															</div>
														</div>

														<div class="show-stat-microcharts">
															<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">

																<div class="easy-pie-chart txt-color-orangeDark"
																	data-percent="33" data-pie-size="50">
																	<span class="percent percent-sign">35</span>
																</div>
																<span class="easy-pie-title"> Server Load <i
																	class="fa fa-caret-up icon-color-bad"></i>
																</span>
																<ul class="smaller-stat hidden-sm pull-right">
																	<li><span class="label bg-color-greenLight"><i
																			class="fa fa-caret-up"></i> 97%</span></li>
																	<li><span class="label bg-color-blueLight"><i
																			class="fa fa-caret-down"></i> 44%</span></li>
																</ul>
																<div
																	class="sparkline txt-color-greenLight hidden-sm hidden-md pull-right"
																	data-sparkline-type="line" data-sparkline-height="33px"
																	data-sparkline-width="70px"
																	data-fill-color="transparent">130, 187, 250, 257,
																	200, 210, 300, 270, 363, 247, 270, 363, 247</div>
															</div>
															<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
																<div class="easy-pie-chart txt-color-greenLight"
																	data-percent="78.9" data-pie-size="50">
																	<span class="percent percent-sign">78.9 </span>
																</div>
																<span class="easy-pie-title"> Disk Space <i
																	class="fa fa-caret-down icon-color-good"></i></span>
																<ul class="smaller-stat hidden-sm pull-right">
																	<li><span class="label bg-color-blueDark"><i
																			class="fa fa-caret-up"></i> 76%</span></li>
																	<li><span class="label bg-color-blue"><i
																			class="fa fa-caret-down"></i> 3%</span></li>
																</ul>
																<div
																	class="sparkline txt-color-blue hidden-sm hidden-md pull-right"
																	data-sparkline-type="line" data-sparkline-height="33px"
																	data-sparkline-width="70px"
																	data-fill-color="transparent">257, 200, 210, 300,
																	270, 363, 130, 187, 250, 247, 270, 363, 247</div>
															</div>
															<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
																<div class="easy-pie-chart txt-color-blue"
																	data-percent="23" data-pie-size="50">
																	<span class="percent percent-sign">23 </span>
																</div>
																<span class="easy-pie-title"> Transfered <i
																	class="fa fa-caret-up icon-color-good"></i></span>
																<ul class="smaller-stat hidden-sm pull-right">
																	<li><span class="label bg-color-darken">10GB</span>
																	</li>
																	<li><span class="label bg-color-blueDark"><i
																			class="fa fa-caret-up"></i> 10%</span></li>
																</ul>
																<div
																	class="sparkline txt-color-darken hidden-sm hidden-md pull-right"
																	data-sparkline-type="line" data-sparkline-height="33px"
																	data-sparkline-width="70px"
																	data-fill-color="transparent">200, 210, 363, 247,
																	300, 270, 130, 187, 250, 257, 363, 247, 270</div>
															</div>
															<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
																<div class="easy-pie-chart txt-color-darken"
																	data-percent="36" data-pie-size="50">
																	<span class="percent degree-sign">36 <i
																		class="fa fa-caret-up"></i></span>
																</div>
																<span class="easy-pie-title"> Temperature <i
																	class="fa fa-caret-down icon-color-good"></i></span>
																<ul class="smaller-stat hidden-sm pull-right">
																	<li><span class="label bg-color-red"><i
																			class="fa fa-caret-up"></i> 124</span></li>
																	<li><span class="label bg-color-blue"><i
																			class="fa fa-caret-down"></i> 40 F</span></li>
																</ul>
																<div
																	class="sparkline txt-color-red hidden-sm hidden-md pull-right"
																	data-sparkline-type="line" data-sparkline-height="33px"
																	data-sparkline-width="70px"
																	data-fill-color="transparent">2700, 3631, 2471,
																	2700, 3631, 2471, 1300, 1877, 2500, 2577, 2000, 2100,
																	3000</div>
															</div>
														</div>

													</div>
													<!-- end s1 tab pane -->

													<div class="tab-pane fade" id="s2">
														<div class="widget-body-toolbar bg-color-white">

															<form class="form-inline" role="form">

																<div class="form-group">
																	<label class="sr-only" for="s123">Show From</label> <input
																		type="email" class="form-control input-sm" id="s123"
																		placeholder="Show From">
																</div>
																<div class="form-group">
																	<input type="email" class="form-control input-sm"
																		id="s124" placeholder="To">
																</div>

																<div class="btn-group hidden-phone pull-right">
																	<a class="btn dropdown-toggle btn-xs btn-default"
																		data-toggle="dropdown"><i class="fa fa-cog"></i>
																		More <span class="caret"> </span> </a>
																	<ul class="dropdown-menu pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file-text-alt"></i> Export to PDF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-question-sign"></i> Help</a></li>
																	</ul>
																</div>

															</form>

														</div>
														<div class="padding-10">
															<div id="statsChart"
																class="chart-large has-legend-unique"></div>
														</div>

													</div>
													<!-- end s2 tab pane -->

													<div class="tab-pane fade" id="s3">
														<div id="content3">



															<!-- widget grid -->
															<section id="widget-grid" class=""> <!-- row -->
															<div class="row">

																<!-- NEW WIDGET START -->
																<article class="col-sd-12"> <!-- Widget ID (each widget will need unique ID)-->
																<div class="jarviswidget jarviswidget-color-darken"
																	id="wid-id-0" data-widget-editbutton="false"
																	data-widget-deletebutton="false">
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
																		class="fa fa-check"></i>
																	</span>
																	<h2>New Posts</h2>

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

																				<!-- NEW WIDGET START -->
																				<article class="col-sm-12"> <!-- Widget ID (each widget will need unique ID)-->
																				<div
																					class="jarviswidget jarviswidget-color-blueLight"
																					id="wid-id-0" data-widget-editbutton="false">
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
																					<header> <span class="widget-icon">
																						<i class="fa fa-cloud"></i>
																					</span>
																					<h2>New Post</h2>

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

																							<form action="upload.php" class="dropzone"
																								id="mydropzone"></form>

																						</div>
																						<!-- end widget content -->

																					</div>
																					<!-- end widget div -->

																				</div>
																				<!-- end widget --> </article>
																				<!-- WIDGET END -->

																			</div>
																			<div class="row">
																				<!-- <form id="wizard-1" novalidate="novalidate" action="postcreate?" method="post" enctype="multipart/form-data">
												<div id="bootstrap-wizard-1" class="col-sm-12">
													
													<div class="tab-content">
														<div class="tab-pane active" id="tab1">
															
				
																<div class="col-sm-12">
																	<div class="form-group">
																		<div class="input-group">
																			
																		</div>
																	</div>
																</div>
															</div>
															
															<div class="row">
																<div class="col-sm-12">
																	<form method="post" action="postcreate?" class="well padding-bottom-10" onsubmit="return false;">
																		<input type="hidden" class="form-control" id="location" name="location" >
																		<textarea rows="2" class="form-control" placeholder="Write a review" name="postdescription" id="postdescription"></textarea>
																		<div class="margin-top-10">
																			<button type="submit" onclick="geoFindMe()" class="btn btn-sm btn-primary pull-right">
																				Submit Post
																			</button>
																			<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="" data-original-title="Add Location"><i class="fa fa-location-arrow"></i></a>
																		</div>
																	</form>
																</div>
																
															</div>
				
														</div>
				
														
				
												</div>
											</form> -->
																			</div>

																		</div>
																		<!-- end widget content -->

																	</div>
																	<!-- end widget div -->

																</div>
																<!-- end widget --> </article>
																<!-- WIDGET END -->

																<!-- NEW WIDGET START -->

																<!-- WIDGET END -->

															</div>

															<!-- end row --> </section>
															<!-- end widget grid -->

														</div>

													</div>
													<!-- end s3 tab pane -->
													
													<div class="tab-pane fade" id="s4">

														
													</div>
													<!-- end s4 tab pane -->
													
													<div class="tab-pane fade" id="s5">

														
													</div>
													
													<!-- end s5 tab pane -->
													
												</div>

												<!-- end content -->
											</div>

										</div>
										<!-- end widget div -->
									</div>
									<!-- end widget --> </article>
								</div>

								<!-- end row --> <!-- row -->

								<div class="row">

									<article class="col-sm-12 col-md-12 col-lg-6"> <!-- new widget -->
									<!-- <div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-1" data-widget-editbutton="false" data-widget-fullscreenbutton="false">

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
									<span class="widget-icon"> <i class="fa fa-comments txt-color-white"></i> </span>
									<h2> SmartChat </h2>
									<div class="widget-toolbar">
										add: non-hidden - to disable auto hide

										<div class="btn-group">
											<button class="btn dropdown-toggle btn-xs btn-success" data-toggle="dropdown">
												Status <i class="fa fa-caret-down"></i>
											</button>
											<ul class="dropdown-menu pull-right js-status-update">
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-green"></i> Online</a>
												</li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-red"></i> Busy</a>
												</li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-circle txt-color-orange"></i> Away</a>
												</li>
												<li class="divider"></li>
												<li>
													<a href="javascript:void(0);"><i class="fa fa-power-off"></i> Log Off</a>
												</li>
											</ul>
										</div>
									</div>
								</header>

								widget div
								<div>
									widget edit box
									<div class="jarviswidget-editbox">
										<div>
											<label>Title:</label>
											<input type="text" />
										</div>
									</div>
									end widget edit box

									<div class="widget-body widget-hide-overflow no-padding">
										content goes here

										CHAT CONTAINER
										<div id="chat-container">
											<span class="chat-list-open-close"><i class="fa fa-user"></i><b>!</b></span>

											<div class="chat-list-body custom-scroll">
												<ul id="chat-users">
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/5.png" alt="">Robin Berry <span class="badge badge-inverse">23</span><span class="state"><i class="fa fa-circle txt-color-green pull-right"></i></span></a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Mark Zeukartech <span class="state"><i class="last-online pull-right">2hrs</i></span></a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Belmain Dolson <span class="state"><i class="last-online pull-right">45m</i></span></a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Galvitch Drewbery <span class="state"><i class="fa fa-circle txt-color-green pull-right"></i></span></a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Sadi Orlaf <span class="state"><i class="fa fa-circle txt-color-green pull-right"></i></span></a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Markus <span class="state"><i class="last-online pull-right">2m</i></span> </a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/sunny.png" alt="">Sunny <span class="state"><i class="last-online pull-right">2m</i></span> </a>
													</li>
													<li>
														<a href="javascript:void(0);"><img src="img/avatars/male.png" alt="">Denmark <span class="state"><i class="last-online pull-right">2m</i></span> </a>
													</li>
												</ul>
											</div>
											<div class="chat-list-footer">

												<div class="control-group">

													<form class="smart-form">

														<section>
															<label class="input">
																<input type="text" id="filter-chat-list" placeholder="Filter">
															</label>
														</section>

													</form>

												</div>

											</div>

										</div>

										CHAT BODY
										<div id="chat-body" class="chat-body custom-scroll">
											<ul>
												<li class="message">
													<img src="img/avatars/5.png" class="online" alt="">
													<div class="message-text">
														<time>
															2014-01-13
														</time> <a href="javascript:void(0);" class="username">Sadi Orlaf</a> Hey did you meet the new board of director? He's a bit of an geek if you ask me...anyway here is the report you requested. I am off to launch with Lisa and Andrew, you wanna join?
														<p class="chat-file row">
															<b class="pull-left col-sm-6"> <i class="fa fa-spinner fa-spin"></i> <i class="fa fa-file"></i> report-2013-demographic-report-annual-earnings.xls </b>
															<span class="col-sm-6 pull-right"> <a href="javascript:void(0);" class="btn btn-xs btn-default">cancel</a> <a href="javascript:void(0);" class="btn btn-xs btn-success">save</a> </span>
														</p>
														<p class="chat-file row">
															<b class="pull-left col-sm-6"> <i class="fa fa-ok txt-color-green"></i> tobacco-report-2012.doc </b>
															<span class="col-sm-6 pull-right"> <a href="javascript:void(0);" class="btn btn-xs btn-primary">open</a> </span>
														</p> </div>
												</li>
												<li class="message">
													<img src="img/avatars/sunny.png" class="online" alt="">
													<div class="message-text">
														<time>
															2014-01-13
														</time> <a href="javascript:void(0);" class="username">John Doe</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> 
													</div>
												</li>
											</ul>

										</div>

										CHAT FOOTER
										<div class="chat-footer">

											CHAT TEXTAREA
											<div class="textarea-div">

												<div class="typearea">
													<textarea placeholder="Write a reply..." id="textarea-expand" class="custom-scroll"></textarea>
												</div>

											</div>

											CHAT REPLY/SEND
											<span class="textarea-controls">
												<button class="btn btn-sm btn-primary pull-right">
													Reply
												</button> <span class="pull-right smart-form" style="margin-top: 3px; margin-right: 10px;"> <label class="checkbox pull-right">
														<input type="checkbox" name="subscription" id="subscription">
														<i></i>Press <strong> ENTER </strong> to send </label> </span> <a href="javascript:void(0);" class="pull-left"><i class="fa fa-camera fa-fw fa-lg"></i></a> </span>

										</div>

										end content
									</div>

								</div>
								end widget div
							</div> --> <!-- end widget --> <!-- new widget -->
									<div class="jarviswidget jarviswidget-color-blueDark"
										id="wid-id-3" data-widget-colorbutton="false">

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
											class="fa fa-calendar"></i>
										</span>
										<h2>My Events</h2>
										<div class="widget-toolbar">
											<!-- add: non-hidden - to disable auto hide -->
											<div class="btn-group">
												<button class="btn dropdown-toggle btn-xs btn-default"
													data-toggle="dropdown">
													Showing <i class="fa fa-caret-down"></i>
												</button>
												<ul class="dropdown-menu js-status-update pull-right">
													<li><a href="javascript:void(0);" id="mt">Month</a></li>
													<li><a href="javascript:void(0);" id="ag">Agenda</a></li>
													<li><a href="javascript:void(0);" id="td">Today</a></li>
												</ul>
											</div>
										</div>
										</header>

										<!-- widget div-->
										<div>
											<!-- widget edit box -->
											<div class="jarviswidget-editbox">

												<input class="form-control" type="text">

											</div>
											<!-- end widget edit box -->

											<div class="widget-body no-padding">
												<!-- content goes here -->
												<div class="widget-body-toolbar">

													<div id="calendar-buttons">

														<div class="btn-group">
															<a href="javascript:void(0)"
																class="btn btn-default btn-xs" id="btn-prev"><i
																class="fa fa-chevron-left"></i></a> <a
																href="javascript:void(0)" class="btn btn-default btn-xs"
																id="btn-next"><i class="fa fa-chevron-right"></i></a>
														</div>
													</div>
												</div>
												<div id="calendar"></div>

												<!-- end content -->
											</div>

										</div>
										<!-- end widget div -->
									</div>
									<!-- end widget --> </article>

									<article class="col-sm-12 col-md-12 col-lg-6"> <!-- new widget -->
									<div class="jarviswidget" id="wid-id-2"
										data-widget-colorbutton="false" data-widget-editbutton="false">

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
											class="fa fa-map-marker"></i>
										</span>
										<h2>Birds Eye</h2>
										<div class="widget-toolbar hidden-mobile">
											<span class="onoffswitch-title"><i
												class="fa fa-location-arrow"></i> Realtime</span> <span
												class="onoffswitch"> <input type="checkbox"
												name="onoffswitch" class="onoffswitch-checkbox"
												checked="checked" id="myonoffswitch"> <label
												class="onoffswitch-label" for="myonoffswitch"> <span
													class="onoffswitch-inner" data-swchon-text="YES"
													data-swchoff-text="NO"></span> <span
													class="onoffswitch-switch"></span>
											</label>
											</span>
										</div>
										</header>

										<!-- widget div-->
										<div>
											<!-- widget edit box -->
											<div class="jarviswidget-editbox">
												<div>
													<label>Title:</label> <input type="text" />
												</div>
											</div>
											<!-- end widget edit box -->

											<div class="widget-body no-padding">
												<!-- content goes here -->

												<div id="vector-map" class="vector-map"></div>
												<div id="heat-fill">
													<span class="fill-a">0</span> <span class="fill-b">5,000</span>
												</div>

												<table
													class="table table-striped table-hover table-condensed">
													<thead>
														<tr>
															<th>Country</th>
															<th>Visits</th>
															<th class="text-align-center">User Activity</th>
															<th class="text-align-center hidden-xs">Online</th>
															<th class="text-align-center">Demographic</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><a href="javascript:void(0);">USA</a></td>
															<td>4,977</td>
															<td class="text-align-center">
																<div class="sparkline txt-color-blue text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	2700, 3631, 2471, 1300, 1877, 2500, 2577, 2700, 3631,
																	2471, 2000, 2100, 3000</div>
															</td>
															<td class="text-align-center hidden-xs">143</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">17,83</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
														<tr>
															<td><a href="javascript:void(0);">Australia</a></td>
															<td>4,873</td>
															<td class="text-align-center">
																<div class="sparkline txt-color-blue text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	1000, 1100, 3030, 1300, -1877, -2500, -2577, -2700,
																	3631, 2471, 4700, 1631, 2471</div>
															</td>
															<td class="text-align-center hidden-xs">247</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">22,88</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
														<tr>
															<td><a href="javascript:void(0);">India</a></td>
															<td>3,671</td>
															<td class="text-align-center">
																<div class="sparkline txt-color-blue text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	3631, 1471, 2400, 3631, 471, 1300, 1177, 2500, 2577,
																	3000, 4100, 3000, 7700</div>
															</td>
															<td class="text-align-center hidden-xs">373</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">10,90</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
														<tr>
															<td><a href="javascript:void(0);">Brazil</a></td>
															<td>2,476</td>
															<td class="text-align-center">
																<div class="sparkline txt-color-blue text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	2700, 1877, 2500, 2577, 2000, 3631, 2471, -2700, -3631,
																	2471, 1300, 2100, 3000,</div>
															</td>
															<td class="text-align-center hidden-xs ">741</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">34,66</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
														<tr>
															<td><a href="javascript:void(0);">Turkey</a></td>
															<td>1,476</td>
															<td class="text-align-center">
																<div class="sparkline txt-color-blue text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	1300, 1877, 2500, 2577, 2000, 2100, 3000, -2471, -2700,
																	-3631, -2471, 2700, 3631</div>
															</td>
															<td class="text-align-center hidden-xs">123</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">75,25</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
														<tr>
															<td><a href="javascript:void(0);">Canada</a></td>
															<td>146</td>
															<td class="text-align-center">
																<div
																	class="sparkline txt-color-orange text-align-center"
																	data-sparkline-height="22px"
																	data-sparkline-width="90px" data-sparkline-barwidth="2">
																	5, 34, 10, 1, 4, 6, -9, -1, 0, 0, 5, 6, 7</div>
															</td>
															<td class="text-align-center hidden-xs">23</td>
															<td class="text-align-center">
																<div class="sparkline display-inline"
																	data-sparkline-type='pie'
																	data-sparkline-piecolor='["#E979BB", "#57889C"]'
																	data-sparkline-offset="90"
																	data-sparkline-piesize="23px">50,50</div>
																<div
																	class="btn-group display-inline pull-right text-align-left hidden-tablet">
																	<button class="btn btn-xs btn-default dropdown-toggle"
																		data-toggle="dropdown">
																		<i class="fa fa-cog fa-lg"></i>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-xs pull-right">
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-file fa-lg fa-fw txt-color-greenLight"></i>
																				<u>P</u>DF</a></li>
																		<li><a href="javascript:void(0);"><i
																				class="fa fa-times fa-lg fa-fw txt-color-red"></i> <u>D</u>elete</a>
																		</li>
																		<li class="divider"></li>
																		<li class="text-align-center"><a
																			href="javascript:void(0);">Cancel</a></li>
																	</ul>
																</div>
															</td>
														</tr>
													</tbody>
													<tfoot>
														<tr>
															<td colspan=5>
																<ul class="pagination pagination-xs no-margin">
																	<li class="prev disabled"><a
																		href="javascript:void(0);">Previous</a></li>
																	<li class="active"><a href="javascript:void(0);">1</a>
																	</li>
																	<li><a href="javascript:void(0);">2</a></li>
																	<li><a href="javascript:void(0);">3</a></li>
																	<li class="next"><a href="javascript:void(0);">Next</a>
																	</li>
																</ul>
															</td>
														</tr>
													</tfoot>
												</table>

												<!-- end content -->

											</div>

										</div>
										<!-- end widget div -->
									</div>
									<!-- end widget --> <!-- new widget --> <!-- <div class="jarviswidget jarviswidget-color-blue" id="wid-id-4" data-widget-editbutton="false" data-widget-colorbutton="false">

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
									<span class="widget-icon"> <i class="fa fa-check txt-color-white"></i> </span>
									<h2> ToDo's </h2>
									<div class="widget-toolbar">
									add: non-hidden - to disable auto hide

									</div>
								</header>

								widget div
								<div>
									widget edit box
									<div class="jarviswidget-editbox">
										<div>
											<label>Title:</label>
											<input type="text" />
										</div>
									</div>
									end widget edit box

									<div class="widget-body no-padding smart-form">
										content goes here
										<h5 class="todo-group-title"><i class="fa fa-warning"></i> Critical Tasks (<small class="num-of-tasks">1</small>)</h5>
										<ul id="sortable1" class="todo">
											<li>
												<span class="handle"> <label class="checkbox">
														<input type="checkbox" name="checkbox-inline">
														<i></i> </label> </span>
												<p>
													<strong>Ticket #17643</strong> - Hotfix for WebApp interface issue [<a href="javascript:void(0);" class="font-xs">More Details</a>] <span class="text-muted">Sea deep blessed bearing under darkness from God air living isn't. </span>
													<span class="date">Jan 1, 2014</span>
												</p>
											</li>
										</ul>
										<h5 class="todo-group-title"><i class="fa fa-exclamation"></i> Important Tasks (<small class="num-of-tasks">3</small>)</h5>
										<ul id="sortable2" class="todo">
											<li>
												<span class="handle"> <label class="checkbox">
														<input type="checkbox" name="checkbox-inline">
														<i></i> </label> </span>
												<p>
													<strong>Ticket #1347</strong> - Inbox email is being sent twice <small>(bug fix)</small> [<a href="javascript:void(0);" class="font-xs">More Details</a>] <span class="date">Nov 22, 2013</span>
												</p>
											</li>
											<li>
												<span class="handle"> <label class="checkbox">
														<input type="checkbox" name="checkbox-inline">
														<i></i> </label> </span>
												<p>
													<strong>Ticket #1314</strong> - Call customer support re: Issue <a href="javascript:void(0);" class="font-xs">#6134</a><small>(code review)</small>
													<span class="date">Nov 22, 2013</span>
												</p>
											</li>
											<li>
												<span class="handle"> <label class="checkbox">
														<input type="checkbox" name="checkbox-inline">
														<i></i> </label> </span>
												<p>
													<strong>Ticket #17643</strong> - Hotfix for WebApp interface issue [<a href="javascript:void(0);" class="font-xs">More Details</a>] <span class="text-muted">Sea deep blessed bearing under darkness from God air living isn't. </span>
													<span class="date">Jan 1, 2014</span>
												</p>
											</li>
										</ul>

										<h5 class="todo-group-title"><i class="fa fa-check"></i> Completed Tasks (<small class="num-of-tasks">1</small>)</h5>
										<ul id="sortable3" class="todo">
											<li class="complete">
												<span class="handle" style="display:none"> <label class="checkbox state-disabled">
														<input type="checkbox" name="checkbox-inline" checked="checked" disabled="disabled">
														<i></i> </label> </span>
												<p>
													<strong>Ticket #17643</strong> - Hotfix for WebApp interface issue [<a href="javascript:void(0);" class="font-xs">More Details</a>] <span class="text-muted">Sea deep blessed bearing under darkness from God air living isn't. </span>
													<span class="date">Jan 1, 2014</span>
												</p>
											</li>
										</ul>

										end content
									</div>

								</div>
								end widget div
							</div> --> <!-- end widget --> </article>

								</div>

								<!-- end row --> </section>


							</div>

						</div>

						<div class="tab-pane fade" id="s2">
							<div id="content2">

								<div class="row">
									<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
										<h1 class="page-title txt-color-blueDark">
											<i class="fa fa-calendar fa-fw "></i> Calendar

										</h1>
									</div>

								</div>
								<!-- row -->

								<div class="row">

									<div class="col-sm-12 col-md-12 col-lg-3">
										<!-- new widget -->
										<div class="jarviswidget jarviswidget-color-blueDark">
											<header>
											<h2>Add Events</h2>
											</header>

											<!-- widget div-->
											<div>

												<div class="widget-body">
													<!-- content goes here -->

													<form id="add-event-form">
														<fieldset>

															<div class="form-group">
																<label>Select Event Icon</label>
																<div class="btn-group btn-group-sm btn-group-justified"
																	data-toggle="buttons">
																	<label class="btn btn-default active"> <input
																		type="radio" name="iconselect" id="icon-1"
																		value="fa-info" checked> <i
																		class="fa fa-info text-muted"></i>
																	</label> <label class="btn btn-default"> <input
																		type="radio" name="iconselect" id="icon-2"
																		value="fa-warning"> <i
																		class="fa fa-warning text-muted"></i>
																	</label> <label class="btn btn-default"> <input
																		type="radio" name="iconselect" id="icon-3"
																		value="fa-check"> <i
																		class="fa fa-check text-muted"></i>
																	</label> <label class="btn btn-default"> <input
																		type="radio" name="iconselect" id="icon-4"
																		value="fa-user"> <i
																		class="fa fa-user text-muted"></i>
																	</label> <label class="btn btn-default"> <input
																		type="radio" name="iconselect" id="icon-5"
																		value="fa-lock"> <i
																		class="fa fa-lock text-muted"></i>
																	</label> <label class="btn btn-default"> <input
																		type="radio" name="iconselect" id="icon-6"
																		value="fa-clock-o"> <i
																		class="fa fa-clock-o text-muted"></i>
																	</label>
																</div>
															</div>

															<div class="form-group">
																<label>Event Title</label> <input class="form-control"
																	id="title" name="title" maxlength="40" type="text"
																	placeholder="Event Title">
															</div>
															<div class="form-group">
																<label>Event Description</label>
																<textarea class="form-control"
																	placeholder="Please be brief" rows="3" maxlength="40"
																	id="description"></textarea>
																<p class="note">Maxlength is set to 40 characters</p>
															</div>

															<div class="form-group">
																<label>Select Event Color</label>
																<div
																	class="btn-group btn-group-justified btn-select-tick"
																	data-toggle="buttons">
																	<label class="btn bg-color-darken active"> <input
																		type="radio" name="priority" id="option1"
																		value="bg-color-darken txt-color-white" checked>
																		<i class="fa fa-check txt-color-white"></i>
																	</label> <label class="btn bg-color-blue"> <input
																		type="radio" name="priority" id="option2"
																		value="bg-color-blue txt-color-white"> <i
																		class="fa fa-check txt-color-white"></i>
																	</label> <label class="btn bg-color-orange"> <input
																		type="radio" name="priority" id="option3"
																		value="bg-color-orange txt-color-white"> <i
																		class="fa fa-check txt-color-white"></i>
																	</label> <label class="btn bg-color-greenLight"> <input
																		type="radio" name="priority" id="option4"
																		value="bg-color-greenLight txt-color-white"> <i
																		class="fa fa-check txt-color-white"></i>
																	</label> <label class="btn bg-color-blueLight"> <input
																		type="radio" name="priority" id="option5"
																		value="bg-color-blueLight txt-color-white"> <i
																		class="fa fa-check txt-color-white"></i>
																	</label> <label class="btn bg-color-red"> <input
																		type="radio" name="priority" id="option6"
																		value="bg-color-red txt-color-white"> <i
																		class="fa fa-check txt-color-white"></i>
																	</label>
																</div>
															</div>

														</fieldset>
														<div class="form-actions">
															<div class="row">
																<div class="col-md-12">
																	<button class="btn btn-default" type="button"
																		id="add-event">Add Event</button>
																</div>
															</div>
														</div>
													</form>

													<!-- end content -->
												</div>

											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->

										<div class="well well-sm" id="event-container">
											<form>
												<fieldset>
													<legend> Draggable Events </legend>
													<ul id='external-events' class="list-unstyled">
														<li><span class="bg-color-darken txt-color-white"
															data-description="Currently busy" data-icon="fa-time">Office
																Meeting</span></li>
														<li><span class="bg-color-blue txt-color-white"
															data-description="No Description" data-icon="fa-pie">Lunch
																Break</span></li>
														<li><span class="bg-color-red txt-color-white"
															data-description="Urgent Tasks" data-icon="fa-alert">URGENT</span>
														</li>
													</ul>
													<div class="checkbox">
														<label> <input type="checkbox" id="drop-remove"
															class="checkbox style-0" checked="checked"> <span>remove
																after drop</span>
														</label>

													</div>
												</fieldset>
											</form>

										</div>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-9">

										<!-- new widget -->
										<div class="jarviswidget jarviswidget-color-blueDark">

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
												class="fa fa-calendar"></i>
											</span>
											<h2>My Events</h2>
											<div class="widget-toolbar">
												<!-- add: non-hidden - to disable auto hide -->
												<div class="btn-group">
													<button class="btn dropdown-toggle btn-xs btn-default"
														data-toggle="dropdown">
														Showing <i class="fa fa-caret-down"></i>
													</button>
													<ul class="dropdown-menu js-status-update pull-right">
														<li><a href="javascript:void(0);" id="mt">Month</a></li>
														<li><a href="javascript:void(0);" id="ag">Agenda</a>
														</li>
														<li><a href="javascript:void(0);" id="td">Today</a></li>
													</ul>
												</div>
											</div>
											</header>

											<!-- widget div-->
											<div>

												<div class="widget-body no-padding">
													<!-- content goes here -->
													<div class="widget-body-toolbar">

														<div id="calendar-buttons">

															<div class="btn-group">
																<a href="javascript:void(0)"
																	class="btn btn-default btn-xs" id="btn-prev"><i
																	class="fa fa-chevron-left"></i></a> <a
																	href="javascript:void(0)"
																	class="btn btn-default btn-xs" id="btn-next"><i
																	class="fa fa-chevron-right"></i></a>
															</div>
														</div>
													</div>
													<div id="calendar"></div>

													<!-- end content -->
												</div>

											</div>
											<!-- end widget div -->
										</div>
										<!-- end widget -->
										<button type="submit" onclick="geoFindMe()"
																		class="btn btn-sm btn-primary pull-right">
																		Publish New Time Table</button>
									</div>

								</div>

								<!-- end row -->

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

	<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

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