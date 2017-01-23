<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

<title>Create New Course</title>
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
<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css">  -->

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
	rel="apple-touch-icon">
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
<!-- 		<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)"> -->
<link href='<c:url value="/resources/img/splash/ipad-landscape.png" />'
	rel="apple-touch-startup-image"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)"> -->
<link href='<c:url value="/resources/img/splash/ipad-portrait.png" />'
	rel="apple-touch-startup-image"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<!-- <link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)"> -->
<link href='<c:url value="/resources/img/splash/iphone.png" />'
	rel="apple-touch-startup-image"
	media="screen and (max-device-width: 320px)">

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

	<!-- HEADER -->
	<header id="header">
		<div id="logo-group">

			<!-- PLACE YOUR LOGO HERE -->
			<span id="logo"> <img src="img/logo.png" alt="Fliker">
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
						This blank page message helps protect your privacy, or you can
						show the first message here automatically.
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
				<span> <a href="logout?" title="Sign Out"
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
			<form action="searchresults?" class="header-search pull-right">
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
								Voice command activated <br> <small>Please speak
									clearly into the mic</small>
							</h4>
							<h4 class="vc-title-error text-center">
								<i class="fa fa-microphone-slash"></i> Voice command failed <br>
								<small class="txt-color-red">Must <strong>"Allow"</strong>
									Microphone
								</small> <br> <small class="txt-color-red">Must have <strong>Internet
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
				data-action="toggleShortcut"> <img src="img/avatars/sunny.png"
					alt="me" class="online" /> <span> john.doe </span> <i
					class="fa fa-angle-down"></i>
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
		<li><a href="searchresults?"><i
				class="fa fa-lg fa-fw fa-search-plus"></i> <span
				class="menu-item-parent">Search</span> </a></li>
		<!-- <li><a href="dashboardanalysis?"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">Dashboard</span> </a></li> -->
		<li ><a href="dashboardsocial?"><i
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
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Post Your Activity</span></a>
		</li>
		<!-- <li><a href="classroom?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">ClassRoom</span></a>
		</li> -->
		<li class="active"><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">Education</span></a>
			<ul>
				<li class="active"><a href="courseEdu?" title="NewPost"><i
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
		</nav>


		<span class="minifyme" data-action="minifyMenu"> <i
			class="fa fa-arrow-circle-left hit"></i>
		</span>

	</aside>
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
				<li>Home</li><li>Course</li><li>New Course</li>
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
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark">
							<i class="fa fa-pencil-square-o fa-fw "></i> 
								Forms
							<span>> 
								Form Plugins
							</span>
						</h1>
					</div>
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
						<ul id="sparks" class="">
							<li class="sparks-info">
								<h5> My Income <span class="txt-color-blue">$47,171</span></h5>
								<div class="sparkline txt-color-blue hidden-mobile hidden-md hidden-sm">
									1300, 1877, 2500, 2577, 2000, 2100, 3000, 2700, 3631, 2471, 2700, 3631, 2471
								</div>
							</li>
							<li class="sparks-info">
								<h5> Site Traffic <span class="txt-color-purple"><i class="fa fa-arrow-circle-up" data-rel="bootstrap-tooltip" title="Increased"></i>&nbsp;45%</span></h5>
								<div class="sparkline txt-color-purple hidden-mobile hidden-md hidden-sm">
									110,150,300,130,400,240,220,310,220,300, 270, 210
								</div>
							</li>
							<li class="sparks-info">
								<h5> Site Orders <span class="txt-color-greenDark"><i class="fa fa-shopping-cart"></i>&nbsp;2447</span></h5>
								<div class="sparkline txt-color-greenDark hidden-mobile hidden-md hidden-sm">
									110,150,300,130,400,240,220,310,220,300, 270, 210
								</div>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="row">
				
					<div class="col-sm-12">
				
				
							<div class="well well-sm">
				
								<div class="row">
								
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">Course</span> <input
													class="form-control input-lg"
													placeholder="Course Name" type="text" name="course"
													id="course">

											</div>
										</div>

									</div>
				
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">CourseDescription</span>
												<input class="form-control input-lg"
													placeholder="Course Description" type="text"
													name="coursedescription" id="coursedescription">

											</div>
										</div>

									</div>
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">Category</span> <input
													class="form-control input-lg"
													placeholder="First Name" type="text" name="category"
													id="category">

											</div>
										</div>
									</div>
									<div class="col-sm-12">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">Course Fee</span> <input
													class="form-control input-lg"
													placeholder="First Name" type="text" name="category"
													id="category">

											</div>
										</div>
									</div>
									
									
								</div>
								<div class="row">
				
						<!-- NEW COL START -->
						<article class="col-sm-12">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget" id="wid-id-3" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
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
									<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
									<h2>Sponsors & Partners </h2>
				
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
				
												<div class="form-group">
													<label>Select2 Plugin (multi-select)</label>
													<select multiple style="width:100%" class="select2">
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
															<option value="MT" selected="selected">Montana</option><option value="NE">Nebraska</option>
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
														<strong>Usage:</strong> &lt;select multiple style=&quot;width:100%&quot; class=&quot;select2&quot; &gt;...&lt;/select&gt;
													</div>
												</div>
				
											</fieldset>
				
											
										</form>
				
									</div>
									<!-- end widget content -->
									<div class="widget-body">
				
										<form class="">
				
											<fieldset>
				
												<div class="form-group">
													<label>Select2 Plugin (multi-select)</label>
													<select multiple style="width:100%" class="select2">
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
															<option value="MT" selected="selected">Montana</option><option value="NE">Nebraska</option>
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
														<strong>Usage:</strong> &lt;select multiple style=&quot;width:100%&quot; class=&quot;select2&quot; &gt;...&lt;/select&gt;
													</div>
												</div>
				
											</fieldset>
				
											
										</form>
				
									</div>
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
				
						</article>
						
						
						
						
						
						</div>
				
							</div>
				
				
					</div>
				
				</div>
				<!-- widget grid -->
				
				<div class="row">
				
					<div class="col-sm-12">
				
				
							<div class="well well-sm" style="background-color: transparent;border: 0">
				
								<div class="row">
									<div class="well well-sm well-light">

															<div class="jarviswidget" id="wid-id-5"
																data-widget-colorbutton="false"
																data-widget-editbutton="false"
																data-widget-fullscreenbutton="false"
																data-widget-custombutton="false"
																data-widget-sortable="false">
																
																
																<header>
																	<h2>Course Material</h2>
																	<div class="widget-toolbar hidden-phone">
																		<div class="smart-form">
																			
																		</div>
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
																				<li class="active"><a href="#tab-r1"
																					data-toggle="tab"><span
																						class="badge bg-color-blue txt-color-white">12</span>
																						Week 1 </a></li>
																				<li><a href="#tab-r2" data-toggle="tab"><span
																						class="badge bg-color-blueDark txt-color-white">3</span>
																						Week 2</a></li>
																				<li><a href="#tab-r3" data-toggle="tab"><span
																						class="badge bg-color-greenLight txt-color-white">0</span>
																						Week 3</a></li>
																				<li><a href="#tab-r4" data-toggle="tab"><span
																						class="badge bg-color-greenLight txt-color-white">0</span>
																						Week 4</a></li>		
																			</ul>
																			<div class="tab-content">
																				<div class="tab-pane active" id="tab-r1">
																					<div class="row" >
																					<article class="col-sm-12" style="height: 100%;margin-top: -10%">
																						<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-0" data-widget-editbutton="false">
																								<header>
																									<span class="widget-icon"> <i class="fa fa-cloud"></i> </span>
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
																				
																										<form action="upload.php" class="dropzone" ></form>
																				
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
																				
																										<form action="upload.php" class="dropzone" id="mydropzone1"></form>
																				
																									</div>
																									<!-- end widget content -->
																				
																								</div>
																								
																						</div>
																						
																					</article>
																					
																				</div>
																				</div>
																				<div class="tab-pane" id="tab-r2">
																					<div class="row" >
																					<article class="col-sm-12" style="height: 100%;margin-top: -10%">
																						<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-1" data-widget-editbutton="false">
																								<header>
																									<span class="widget-icon"> <i class="fa fa-cloud"></i> </span>
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
																				
																										<form action="upload.php" class="dropzone" ></form>
																				
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
																				
																										<form action="upload.php" class="dropzone" id="mydropzone2"></form>
																				
																									</div>
																									<!-- end widget content -->
																				
																								</div>
																								
																						</div>
																						
																					</article>
																					
																				</div>
																				</div>
																				<div class="tab-pane" id="tab-r3">
																					<div class="row" >
																					<article class="col-sm-12" style="height: 100%;margin-top: -10%">
																						<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-3" data-widget-editbutton="false">
																								<header>
																									<span class="widget-icon"> <i class="fa fa-cloud"></i> </span>
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
																				
																										<form action="upload.php" class="dropzone" ></form>
																				
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
																				
																										<form action="upload.php" class="dropzone" id="mydropzone3"></form>
																				
																									</div>
																									<!-- end widget content -->
																				
																								</div>
																								
																						</div>
																						
																					</article>
																					
																				</div>
																				</div>
																				<div class="tab-pane" id="tab-r4">
																					<div class="row" >
																					<article class="col-sm-12" style="height: 100%;margin-top: -10%">
																						<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-4" data-widget-editbutton="false">
																								<header>
																									<span class="widget-icon"> <i class="fa fa-cloud"></i> </span>
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
																				
																										<form action="upload.php" class="dropzone" ></form>
																				
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
																				
																										<form action="upload.php" class="dropzone" id="mydropzone4"></form>
																				
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
				
				<div class="well well-sm well-light">
			

			

			<hr class="simple">
			<h3>FAQ Tabs
			<br>
			<small>Click button to add another faq</small></h3>

			<p>
				<button id="add_tab" class="btn btn-primary">
					Add Tab
				</button>
			</p>

			<div id="tabs2">
				<ul>
					<li>
						<a href="#tabs-1">QUESTIONS</a>
					</li>
				</ul>
				<div id="tabs-1">
					<p>
						ANSWERS
					</p>
				</div>
			</div>

			<!-- Demo -->
			<div id="addtab" title="<div class='widget-header'><h4><i class='fa fa-plus'></i> Add another tab</h4></div>">

				<form>

					<fieldset>
						<input name="authenticity_token" type="hidden">
						<div class="form-group">
							<label>Tab Title</label>
							<input class="form-control" id="tab_title" value="" placeholder="Text field" type="text">
						</div>

						<div class="form-group">
							<label>Content</label>
							<textarea class="form-control" name="tab_content" id="tab_content" placeholder="Tab Content" rows="3"></textarea>
						</div>

					</fieldset>

				</form>

			</div>

		</div>
				
				
			<div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
			
				<div class="widget-body" >
				
					<a href="javascript:void(0);" class="btn btn-primary btn-lg" >Save</a>&nbsp;<a href="javascript:void(0);" class="btn btn-success btn-lg" style=" float: right;">Publish</a>
					
				</div>
			
			</div>			
				<!-- end widget grid -->

			</div>
		<!-- END MAIN CONTENT -->

	</div>
	<!-- END MAIN PANEL -->

	<!-- PAGE FOOTER -->
	<div class="page-footer">
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


	<script type="text/javascript">
		// DO NOT REMOVE : GLOBAL FUNCTIONS!

		$(document)
				.ready(
						function() {

							pageSetUp();

							//Dropzone.autoDiscover = true;

							 Dropzone.autoDiscover = false;
							 /*$(".dropzone").each(function () {
							    new Dropzone($(this).get(0), {url : "file?",
									paramName : "file",
									addRemoveLinks : true,
									maxFilesize : 500,
									dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
									dictResponseError : 'Error uploading file!'});
							}); */

							 $("#mydropzone1").dropzone(
											{
												url : "file?",
												paramName : "file",
												addRemoveLinks : true,
												maxFilesize : 500,
												dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
												dictResponseError : 'Error uploading file!'
											});
							
							//Dropzone.autoDiscover = false;
							$("#mydropzone2").dropzone(
									{
										url : "file?",
										paramName : "file",	
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									});
							
							//Dropzone.autoDiscover = false;
							$("#mydropzone3").dropzone(
									{
										url : "file?",
										paramName : "file",
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									});
							
							//Dropzone.autoDiscover = false;
							$("#mydropzone4").dropzone(
									{
										url : "file?",
										paramName : "file",
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									});
							
							//Dropzone.autoDiscover = false;
							/* $("#mydropzone5").dropzone(
									{
										url : "file?",
										paramName : "file",
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									}); */ 

							// menu
							$("#menu").menu();

							/*
							 * AUTO COMPLETE AJAX
							 */

							function log(message) {
								$("<div>").text(message).prependTo("#log");
								$("#log").scrollTop(0);
							}

							$("#city")
									.autocomplete(
											{
												source : function(request,
														response) {
													$
															.ajax({
																url : "http://ws.geonames.org/searchJSON",
																dataType : "jsonp",
																data : {
																	featureClass : "P",
																	style : "full",
																	maxRows : 12,
																	name_startsWith : request.term
																},
																success : function(
																		data) {
																	response($
																			.map(
																					data.geonames,
																					function(
																							item) {
																						return {
																							label : item.name
																									+ (item.adminName1 ? ", "
																											+ item.adminName1
																											: "")
																									+ ", "
																									+ item.countryName,
																							value : item.name
																						}
																					}));
																}
															});
												},
												minLength : 2,
												select : function(event, ui) {
													log(ui.item ? "Selected: "
															+ ui.item.label
															: "Nothing selected, input was "
																	+ this.value);
												}
											});

							/*
							 * Spinners
							 */
							$("#spinner").spinner();
							$("#spinner-decimal").spinner({
								step : 0.01,
								numberFormat : "n"
							});

							$("#spinner-currency").spinner({
								min : 5,
								max : 2500,
								step : 25,
								start : 1000,
								numberFormat : "C"
							});

							/*
							 * CONVERT DIALOG TITLE TO HTML
							 * REF: http://stackoverflow.com/questions/14488774/using-html-in-a-dialogs-title-in-jquery-ui-1-10
							 */
							$.widget("ui.dialog", $.extend({},
									$.ui.dialog.prototype, {
										_title : function(title) {
											if (!this.options.title) {
												title.html("&#160;");
											} else {
												title.html(this.options.title);
											}
										}
									}));

							/*
							 * DIALOG SIMPLE
							 */

							// Dialog click
							$('#dialog_link').click(function() {
								$('#dialog_simple').dialog('open');
								return false;

							});

							$('#dialog_simple')
									.dialog(
											{
												autoOpen : false,
												width : 600,
												resizable : false,
												modal : true,
												title : "<div class='widget-header'><h4><i class='fa fa-warning'></i> Empty the recycle bin?</h4></div>",
												buttons : [
														{
															html : "<i class='fa fa-trash-o'></i>&nbsp; Delete all items",
															"class" : "btn btn-danger",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														},
														{
															html : "<i class='fa fa-times'></i>&nbsp; Cancel",
															"class" : "btn btn-default",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														} ]
											});

							/*
							 * DIALOG HEADER ICON
							 */

							// Modal Link
							$('#modal_link').click(function() {
								$('#dialog-message').dialog('open');
								return false;
							});

							$("#dialog-message")
									.dialog(
											{
												autoOpen : false,
												modal : true,
												title : "<div class='widget-header'><h4><i class='icon-ok'></i> jQuery UI Dialog</h4></div>",
												buttons : [
														{
															html : "Cancel",
															"class" : "btn btn-default",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														},
														{
															html : "<i class='fa fa-check'></i>&nbsp; OK",
															"class" : "btn btn-primary",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														} ]

											});

							/*
							 * Remove focus from buttons
							 */
							$('.ui-dialog :button').blur();

							/*
							 * Just Tabs
							 */

							$('#tabs').tabs();

							/*
							 *  Simple tabs adding and removing
							 */

							$('#tabs2').tabs();

							// Dynamic tabs
							var tabTitle = $("#tab_title"), tabContent = $("#tab_content"), tabTemplate = "<li style='position:relative;'> <span class='air air-top-left delete-tab' style='top:7px; left:7px;'><button class='btn btn-xs font-xs btn-default hover-transparent'><i class='fa fa-times'></i></button></span></span><a href='#{href}'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; #{label}</a></li>", tabCounter = 2;

							var tabs = $("#tabs2").tabs();

							// modal dialog init: custom buttons and a "close" callback reseting the form inside
							var dialog = $("#addtab")
									.dialog(
											{
												autoOpen : false,
												width : 600,
												resizable : false,
												modal : true,
												buttons : [
														{
															html : "<i class='fa fa-times'></i>&nbsp; Cancel",
															"class" : "btn btn-default",
															click : function() {
																$(this)
																		.dialog(
																				"close");

															}
														},
														{

															html : "<i class='fa fa-plus'></i>&nbsp; Add",
															"class" : "btn btn-danger",
															click : function() {
																addTab();
																$(this)
																		.dialog(
																				"close");
															}
														} ]
											});

							// addTab form: calls addTab function on submit and closes the dialog
							/* var form = dialog.find("form").submit(function(event) {
								addTab();
								dialog.dialog("close");
								event.preventDefault();
							}); */

							// actual addTab function: adds new tab using the input from the form above
							function addTab() {

									var label = tabTitle.val() || "Tab "
											+ tabCounter, id = "tabs-"
											+ tabCounter, li = $(tabTemplate
											.replace(/#\{href\}/g, "#" + id)
											.replace(/#\{label\}/g, label)), tabContentHtml = tabContent
											.val()
											|| "Tab "
											+ tabCounter
											+ " content.";

									tabs.find(".ui-tabs-nav").append(li);
									tabs.append("<div id='" + id + "'><p>"
											+ tabContentHtml + "</p></div>");
									tabs.tabs("refresh");
									tabCounter++;

									// clear fields
									$("#tab_title").val("");
									$("#tab_content").val("");
								
							}

							// addTab button: just opens the dialog
							$("#add_tab").click(function(ev) {
								ev.preventDefault();
								dialog.dialog("open");
								//alert("");
							});

							// close icon: removing the tab on click
							$("#tabs2")
									.on(
											"click",
											'span.delete-tab',
											function() {

												var panelId = $(this).closest(
														"li").remove().attr(
														"aria-controls");
												$("#" + panelId).remove();
												tabs.tabs("refresh");
											});

							/*
							 * ACCORDION
							 */
							//jquery accordion
							var accordionIcons = {
								header : "fa fa-plus", // custom icon class
								activeHeader : "fa fa-minus" // custom icon class
							};

							$("#accordion").accordion({
								autoHeight : false,
								heightStyle : "content",
								collapsible : true,
								animate : 300,
								icons : accordionIcons,
								header : "h4",
							})

							/*
							 * PROGRESS BAR
							 */
							$("#progressbar")
									.progressbar(
											{
												value : 25,
												create : function(event, ui) {
													$(this)
															.removeClass(
																	"ui-corner-all")
															.addClass(
																	'progress')
															.find(
																	">:first-child")
															.removeClass(
																	"ui-corner-left")
															.addClass(
																	'progress-bar progress-bar-success');
												}
											});

							//Bootstrap Wizard Validations

							var $validator = $("#wizard-1")
									.validate(
											{

												rules : {
													email : {
														required : true,
														email : "Your email address must be in the format of name@domain.com"
													},
													fname : {
														required : true
													},
													lname : {
														required : true
													},
													country : {
														required : true
													},
													city : {
														required : true
													},
													postal : {
														required : true,
														minlength : 4
													},
													wphone : {
														required : true,
														minlength : 10
													},
													hphone : {
														required : true,
														minlength : 10
													}
												},

												messages : {
													fname : "Please specify your First name",
													lname : "Please specify your Last name",
													email : {
														required : "We need your email address to contact you",
														email : "Your email address must be in the format of name@domain.com"
													}
												},

												highlight : function(element) {
													$(element)
															.closest(
																	'.form-group')
															.removeClass(
																	'has-success')
															.addClass(
																	'has-error');
												},
												unhighlight : function(element) {
													$(element)
															.closest(
																	'.form-group')
															.removeClass(
																	'has-error')
															.addClass(
																	'has-success');
												},
												errorElement : 'span',
												errorClass : 'help-block',
												errorPlacement : function(
														error, element) {
													if (element
															.parent('.input-group').length) {
														error
																.insertAfter(element
																		.parent());
													} else {
														error
																.insertAfter(element);
													}
												}
											});

							$('#bootstrap-wizard-1')
									.bootstrapWizard(
											{
												'tabClass' : 'form-wizard',
												'onNext' : function(tab,
														navigation, index) {
													var $valid = $("#wizard-1")
															.valid();
													if (!$valid) {
														$validator
																.focusInvalid();
														return false;
													} else {
														$('#bootstrap-wizard-1')
																.find(
																		'.form-wizard')
																.children('li')
																.eq(index - 1)
																.addClass(
																		'complete');
														$('#bootstrap-wizard-1')
																.find(
																		'.form-wizard')
																.children('li')
																.eq(index - 1)
																.find('.step')
																.html(
																		'<i class="fa fa-check"></i>');
													}
												}
											});

							// fuelux wizard
							var wizard = $('.wizard').wizard();

							wizard
									.on(
											'finished',
											function(e, data) {
												$("#fuelux-wizard").submit();
												console.log("submitted!");
												$
														.smallBox({
															title : "Congratulations! Your form was submitted",
															content : "<i class='fa fa-clock-o'></i> <i>1 seconds ago...</i>",
															color : "#5F895F",
															iconSmall : "fa fa-check bounce animated",
															timeout : 4000
														});

											});

							$('#finishCourse')
									.click(
											function() {

												var Course = document
														.getElementById("course").value;
												var Coursedescription = document
														.getElementById("coursedescription").value;
												var Category = document
														.getElementById("category").value;
												var Sponsers = document
														.getElementById("sponsers").value;
												var Partners = document
														.getElementById("partners").value;
												var File = document
														.getElementById("file").value;

												$
														.ajax({
															url : "savecourse?File="
																	+ File
																	+ "&Coursedescription="
																	+ Coursedescription
																	+ "&Category="
																	+ Category
																	+ "&Sponsers="
																	+ Sponsers
																	+ "&Partners="
																	+ Partners
																	+ "&Course="
																	+ Course,
															type : "POST",
															headers : {
																'Content-Type' : 'multipart/form-data'
															},
															mimeType : 'multipart/form-data',
															success : function(
																	result) {
																alert("");
															}
														});
											});

							noUiSlider.create(slider3, {
								range : {
									'min' : 0,
									'max' : 1000
								},
								start : [ 264, 776 ],
								step : 1,
								connect : true
							});

							slider3.noUiSlider.on('update', function(values) {
								$(".nouislider-value").text(
										values[0] + " - " + values[1]);
							});

							slider3.noUiSlider.on('slide', function(values) {
								//var values = $(this).val();
								$(".nouislider-value").text(
										values[0] + " - " + values[1]);
							});

							$("#range-slider-3").ionRangeSlider({
								min : 0,
								from : 2.3,
								max : 10,
								type : 'single',
								step : 0.1,
								postfix : " mm",
								prettify : false,
								grid : true,
								inputValuesSeparator : ';'
							});

							var myDropzoneTheFirst = new Dropzone(
									'#mydropzone', //id of drop zone element 1
									{
										url : "file?",
										paramName : "file",
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									});

							var myDropzoneTheSecond = new Dropzone(
									'#mydropzone2', //id of drop zone element 2
									{
										url : "file?",
										paramName : "file",
										addRemoveLinks : true,
										maxFilesize : 500,
										dictDefaultMessage : '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
										dictResponseError : 'Error uploading file!'
									});

						})
	</script>



</body>

</html>