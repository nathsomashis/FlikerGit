<%@page import="com.mongodb.BasicDBList"%>
<%@page
	import="org.springframework.web.servlet.ModelAndView,java.util.*,com.fliker.Repository.*,com.mongodb.DBObject,org.bson.types.ObjectId, java.text.*"%>
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
<body class="" onload="geoFindMe()">

	<!-- #HEADER -->
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
		<li><a href="searchresults?"><i
				class="fa fa-lg fa-fw fa-search-plus"></i> <span
				class="menu-item-parent">SEARCH</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="dashboardanalysis?"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">DASHBOARD</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li class="active"><a href="dashboardsocial?"><i
				class="fa fa-lg fa-fw fa-retweet txt-color-blue"></i> <span
				class="menu-item-parent">WALL</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>

		<li><a href="profile?"><i class="fa fa-lg fa-fw fa-info"></i>
				<span class="menu-item-parent">PROFILE</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="timeline?"><i class="fa fa-lg fa-fw fa-road"></i>
				<span class="menu-item-parent">TIMELINE</span> <span
				class="badge pull-right inbox-badge margin-right-13">14</span></a></li>
		<li><a href="createpost?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">NEWPOST</span></a>
		</li>
		<li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-book"></i> <span class="menu-item-parent">COURSE</span></a>
			<ul>
				<li class=""><a href="mycourse?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">MYCOURSES</span></a>
				</li>
				<li class=""><a href="courseanalysis?" title="NewJob"><i
						class="fa fa-suitcase"></i><span class="menu-item-parent">COURSEDASH</span></a>
				</li>
				<li class=""><a href="createcourse?" title="NewCourse"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">NEWCOURSE</span></a>
				</li>
				<li class=""><a href="organizations?" title="Organizations"><i
						class="fa fa-group"></i><span class="menu-item-parent">ORGANIZATIONS</span></a>
				</li>
			</ul></li>
		<li><a href="#" title="Dashboard"><i
				class="fa fa-lg fa-fw fa-briefcase"></i> <span
				class="menu-item-parent">JOBS</span></a>
			<ul>
				<li class=""><a href="myjobs?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">MYJOBS</span></a>
				</li>
				<li class=""><a href="jobanalysis?" title="NewJob"><i
						class="fa fa-suitcase"></i><span class="menu-item-parent">JOBSDASH</span></a>
				</li>
				<li class=""><a href="createjob?" title="NewJob"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">NEWJOB</span></a>
				</li>
				<li class=""><a href="companies?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">COMPANIES</span></a>
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
				<li>Home</li>
				<li>Dashboard</li>
				<li>Social Wall</li>
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

				<!-- col -->
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
					<h1 class="page-title txt-color-blueDark">
						<!-- PAGE HEADER -->
						<i class="fa-fw fa fa-home"></i> Dashboard <span>> Social
							Wall </span>
					</h1>
				</div>
				<!-- end col -->

			</div>
			<!-- end row -->

			<!--
				The ID "widget-grid" will start to initialize all widgets below
				You do not need to use widgets if you dont want to. Simply remove
				the <section></section> and you can use wells or panels instead
				-->

			<!-- widget grid -->
			<section id="widget-grid" class=""> <!-- row -->
			<div class="row">

				<%
					String postid = "";
					String username = "";
					String postfileid = "";
					String postType = "";
					String postDescription = "";
					String postidDate = "";
					String userid = "";
					String postuserimage = "";
					ArrayList sharedinfo = new ArrayList();
					ArrayList likedinfo = new ArrayList();
					ArrayList commentinfo = new ArrayList();
					int filelimit = 0;
					StringBuffer postfileidString = new StringBuffer();
					String postfileidStr = "";
					

					ArrayList postlist = (ArrayList) request.getAttribute("postlist");
					for (int i = 0; i < postlist.size(); i++) {
						System.out.println("postlist.size() ><><" + postlist.size());
						HashMap perPostSet = (HashMap) postlist.get(i);
						Set perset = perPostSet.entrySet();
						Iterator perit = perset.iterator();
						while (perit.hasNext()) {
							
							Map.Entry perme = (Map.Entry) perit.next();

							String keyvalue = (String) perme.getKey();
							
							System.out.println(perme.getValue());

							if (keyvalue.equalsIgnoreCase("postid")) {
								
								postid = (String)perme.getValue();
								
								
								//postid = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postFileid")) {
								
								BasicDBList basicdb = (BasicDBList)perme.getValue();
								filelimit = basicdb.size();
								
								for(int m = 0;m< basicdb.size(); m++){
									postfileid = (String)basicdb.get(m);
									postfileidString.append(postfileid);
									postfileidString.append(",");
									//System.out.println(imageid);
								}
								int lastcomma = postfileidString.lastIndexOf(",");
								postfileidStr = postfileidString.substring(0, lastcomma);
								System.out.println("postfileidStr"+postfileidStr);
								System.out.println("filelimit >>"+filelimit);
								
								//postfileid = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postType")) {
								
								postType = (String)perme.getValue();
								
								//postType = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postDescription")) {
								
								postDescription = (String)perme.getValue();
								
								//postDescription = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postiddate")) {
								
								postidDate = (String)perme.getValue();
								
								//postidDate = (String) perme.getValue();
								/* long times = System.currentTimeMillis() - Long.parseLong(postidDate);
								
								Date currentDate = new Date(times);
								  
								   //printing value of Date
								   System.out.println("current Date: " + currentDate);
								  
								   DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
								  
								   //formatted value of current Date
								   System.out.println("Milliseconds to Date: " + df.format(currentDate));
								   postidDate = df.format(currentDate); */

							} else if (keyvalue.equalsIgnoreCase("postuser")) {
								
								username = (String)perme.getValue();
								
								//username = (String) perme.getValue();
							}else if (keyvalue.equalsIgnoreCase("profileImageid")) {
								
								postuserimage = (String)perme.getValue();
								
								//postuserimage = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("userid")) {
								
								userid = (String)perme.getValue();
								
								//userid = (String) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postsharedids")) {
								
								sharedinfo = (ArrayList)perme.getValue();
								
								
								
								//sharedinfo = (ArrayList) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postlikedids")) {
								
								likedinfo = (ArrayList)perme.getValue();
								
								//sharedinfo = (ArrayList) perme.getValue();
							} else if (keyvalue.equalsIgnoreCase("postcommentsids")) {
								
								commentinfo = (ArrayList)perme.getValue();
								
								//sharedinfo = (ArrayList) perme.getValue();
							}
							
						}
				
					if ((i == 0) || (i % 4 == 0) || (i % 7 == 0) ) {
							System.out.println("countable >>>" + i);
							if (!postfileid.isEmpty()) {
				%>
						<div id="count<%=i%>" class="col-sm-6 col-lg-4">
							<div id="<%=postid%>" class="panel panel-default">
								<div class="panel-body status">
								
							<%
								if (!sharedinfo.isEmpty()) {
												for (int k = 0; k < sharedinfo.size(); k++) {
													String sharedinformation = (String) sharedinfo.get(k);
													System.out.println("sharedinformation"+sharedinformation);

													String sharedcomm = "";
													String sharedtime = "";
													String sharedloc = "";
													String sharedperson = "";
													String personimage = "";
													while (!sharedinformation.isEmpty()) {
														
														
														
														//String stringshared = (String) sharedme.getKey();
														//if (stringshared.equalsIgnoreCase("sharedPerson")) {
														//	sharedperson = (String) sharedme.getValue(); 
														%>
														<%-- <b><%=sharedperson%></b> --%>
														<%
														//}
													}
												}
									}
							%>
							<div class="who clearfix">
								<img src="/Fliker/imageFromUserid/<%=userid%>" alt="img"
									style="height: 50; width: 50" class="online"> <span
									class="name"><b><%=username%></b> shared a post</span> <span
									class="from"><b><%=postidDate%> ago</b> via Mobile,
									Sydney, Australia</span>
							</div>
							<div class="image" >
							<% if(filelimit>1){%>
									<a id="PostImage<%=postid%>" onclick="openmodalTop('<%=postfileidStr%>');" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
								 	<h2 style="position: absolute;top: 90px;left: 50px;width: 100%;"><%=filelimit%> More</h2>
								 	<%-- <input id="hidden<%=postid%>" type="hidden" value="<%=postfileidStr%>"> --%>
							<%}else{ %>
								 	<a id="PostImage<%=postid%>" onclick="openModalRest('<%=postfileidStr%>')" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
							<%} %>	 
							</div>
							<ul class="links">
								<li><a href="javascript:liked('<%=userid%>','<%=postid%>');"><i
										class="fa fa-thumbs-o-up"></i> Like</a></li>
								<li><a href="javascript:commented();"><i
										class="fa fa-comment-o"></i> Comment</a></li>
								<li><a href="javascript:shared('<%=userid%>','<%=postid%>');"><i
										class="fa fa-share-square-o"></i> Share</a></li>
							</ul>
							
							<%
							if (!commentinfo.isEmpty()) {
							
							%>
							<ul id="commentidul" class="comments">
								<li><img src="img/avatars/sunny.png" alt="img"
									class="online"> <span class="name">John Doe</span> Looks
									like a nice house, when did you get it? Are we having the party
									there next week? ;)</li>
								<li id="commentidli"><img src="img/avatars/2.png" alt="img"
									class="online"> <span class="name">Alice Wonder</span>
									Seems cool.</li>

							</ul>
							
							<%
							}
							%>
							<ul class="comments">
								<li><img src="img/avatars/sunny.png" alt="img"
									class="online"> <input class="commmentclass" id="urcomment" type="text" alt="<%=postid%>" name="<%=userid%>"
									class="form-control" placeholder="Post your comment..."></li>
							</ul>
						</div>
					</div>



					<%
						} else {
					%>
					<div class="col-sm-6 col-lg-4">
						<div class="panel panel-default">
							<div class="panel-body status">
								<div class="who clearfix">
									<img src="img/avatars/sunny.png" alt="img" class="busy">
									<span class="name"><b>You</b> shared a blog</span> <span
										class="from"><b>1 days ago</b> via Mobile, Sydney,
										Australia</span>
								</div>
								<div class="text">
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Quisque in mauris elit. Ut nec arcu pretium eros varius porta
										vitae sit amet ipsum. Suspendisse porttitor, libero in rutrum
										pretium, lectus arcu maximus massa, ut condimentum metus
										libero laoreet lectus. Phasellus a lectus pulvinar, lacinia
										sem quis, suscipit turpis. <br> <br> Nam ipsum orci,
										blandit in lectus ut, viverra vehicula nisl. Proin eu arcu ut
										neque tempus viverra nec ac tellus. <strong>[</strong><a
											href="javascript:void(0);">Keep reading</a><strong>]</strong>
								</div>
								<ul class="links">
									<li><a href="javascript:void(0);"><i
											class="fa fa-thumbs-o-up"></i> Like</a></li>
									<li><a href="javascript:void(0);"><i
											class="fa fa-comment-o"></i> Comment</a></li>
									<li><a href="javascript:void(0);"><i
											class="fa fa-share-square-o"></i> Share</a></li>
								</ul>
							</div>
						</div>

						<%
							}
								}else if ((i % 3 == 0) || (i == 7)) {
									
									System.out.println("countable by 3>>>" + i);
									if (!postfileid.isEmpty()) {
						%>

						<div id="<%=postid%>" class="panel panel-default">
							<div class="panel-body status">
								
								<%
									if (!sharedinfo.isEmpty()) {
													for (int k = 0; k < sharedinfo.size(); k++) {
														String sharedinformation = (String) sharedinfo.get(k);
														System.out.println("sharedinformation"+sharedinformation);

														//String sharedcomm = "";
														//String sharedtime = "";
														//String sharedloc = "";
														//String sharedperson = "";
														//String personimage = "";
														//while (sharedit.hasNext()) {
															//Map.Entry sharedme = (Map.Entry) sharedit.next();
															//String stringshared = (String) sharedme.getKey();
															//if (stringshared.equalsIgnoreCase("sharedPerson")) {
																//sharedperson = (String) sharedme.getValue();
															%>
															<%-- <b><%=sharedperson%></b> --%>
															<%
															//}
														//}
													}
									}
								%>
								<div class="who clearfix">
									<img src="/Fliker/imageFromUserid/<%=userid%>" alt="img"
										style="height: 50; width: 50" class="online"> <span
										class="name"><b><%=username%></b> shared a photo</span> <span
										class="from"><b><%=postidDate%> ago</b> via Mobile,
										Sydney, Australia</span>
								</div>
								<div class="image">
									<% if(filelimit>1){%>
									<a id="PostImage<%=postid%>" onclick="multiModalRest('<%=postfileidStr%>')" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
								 	<h2 style="position: absolute;top: 90px;left: 50px;width: 100%;"><%=filelimit%> More</h2>
								 	<%-- <input id="hidden<%=postid%>" type="hidden" value="<%=postfileidStr%>"> --%>
									<%}else{ %>
										 	<a id="PostImage<%=postid%>" onclick="singleopenModalRest('<%=postfileidStr%>')" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
									<%} %>	
								</div>
								<ul class="links">
									<li><a href="javascript:void(0);"><i
											class="fa fa-thumbs-o-up"></i> Like</a></li>
									<li><a href="javascript:void(0);"><i
											class="fa fa-comment-o"></i> Comment</a></li>
									<li><a href="javascript:void(0);"><i
											class="fa fa-share-square-o"></i> Share</a></li>
								</ul>
								<%
							if (!commentinfo.isEmpty()) {
							
							%>
								<ul class="comments">
									<li><img src="img/avatars/sunny.png" alt="img"
										class="online"> <span class="name">John Doe</span> Looks
										like a nice house, when did you get it? Are we having the
										party there next week? ;)</li>
									<li><img src="img/avatars/2.png" alt="img" class="online">
										<span class="name">Alice Wonder</span> Seems cool.</li>
								</ul>
							
							<%
							}
							%>
								<ul class="comments">		
									<li><img src="img/avatars/sunny.png" alt="img"
										class="online"> <input id="urcomment" type="text"
										class="form-control" placeholder="Post your comment..."></li>
								</ul>
							</div>
						</div>
					</div>
					<%
						} else {
					%>
					<div class="panel panel-default">
						<div class="panel-body status">
							<div class="who clearfix">
								<img src="img/avatars/sunny.png" alt="img" class="busy"> <span
									class="name"><b>You</b> shared a blog</span> <span class="from"><b>1
										days ago</b> via Mobile, Sydney, Australia</span>
							</div>
							<div class="text">
								<p>
									Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Quisque in mauris elit. Ut nec arcu pretium eros varius porta
									vitae sit amet ipsum. Suspendisse porttitor, libero in rutrum
									pretium, lectus arcu maximus massa, ut condimentum metus libero
									laoreet lectus. Phasellus a lectus pulvinar, lacinia sem quis,
									suscipit turpis. <br> <br> Nam ipsum orci, blandit in
									lectus ut, viverra vehicula nisl. Proin eu arcu ut neque tempus
									viverra nec ac tellus. <strong>[</strong><a
										href="javascript:void(0);">Keep reading</a><strong>]</strong>
							</div>
							<ul class="links">
								<li><a href="javascript:void(0);"><i
										class="fa fa-thumbs-o-up"></i> Like</a></li>
								<li><a href="javascript:void(0);"><i
										class="fa fa-comment-o"></i> Comment</a></li>
								<li><a href="javascript:void(0);"><i
										class="fa fa-share-square-o"></i> Share</a></li>
							</ul>
						</div>
					</div>
				</div>
				<%
					}
						} else {
							
							System.out.println("countable by 1>>>" + i);
							if (!postfileid.isEmpty()) {
				%>
				<div id="<%=postid%>" class="panel panel-default">
					<div class="panel-body status">
						<b>Shared by </b>
						<%
							if (!sharedinfo.isEmpty()) {
											for (int k = 0; k < sharedinfo.size(); k++) {
												String sharedinformation = (String) sharedinfo.get(k);
												System.out.println("sharedinformation"+sharedinformation);

												//String sharedcomm = "";
												//String sharedtime = "";
												//String sharedloc = "";
												//String sharedperson = "";
												//String personimage = "";
												//while (sharedit.hasNext()) {
													//Map.Entry sharedme = (Map.Entry) sharedit.next();
													//String stringshared = (String) sharedme.getKey();
													//if (stringshared.equalsIgnoreCase("sharedPerson")) {
														//sharedperson = (String) sharedme.getValue();
														%>
														<%-- <b><%=sharedperson%></b> --%>
														<%
													//}
												//}
											}
											
							}
						%>
						<div class="who clearfix">
							<img src="/Fliker/imageFromUserid/<%=userid%>" alt="img"
								style="height: 50; width: 50" class="online"> <span
								class="name"><b><%=username%></b> shared a photo</span> <span
								class="from"><b><%=postidDate%> ago</b> via Mobile,
								Sydney, Australia</span>
						</div>
						<div class="image">
							<% if(filelimit>1){%>
									<a id="PostImage<%=postid%>" onclick="multiModalRest('<%=postfileidStr%>')" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
								 	<h2 style="position: absolute;top: 90px;left: 50px;width: 100%;"><%=filelimit%> More</h2>
								 	<%-- <input id="hidden<%=postid%>" type="hidden" value="<%=postfileidStr%>"> --%>
							<%}else{ %>
								 	<a id="PostImage<%=postid%>" onclick="singleopenModalRest('<%=postfileidStr%>')" title="<%=postfileidStr%>" ><img  src="/Fliker/imageController/<%=postfileid%>" alt="img"></a>
							<%} %>	
						</div>
						<ul class="links">
							<li><a href="javascript:void(0);"><i
									class="fa fa-thumbs-o-up"></i> Like</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-comment-o"></i> Comment</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-share-square-o"></i> Share</a></li>
						</ul>
						<%
							if (!commentinfo.isEmpty()) {
							
							%>
								<ul class="comments">
									<li><img src="img/avatars/sunny.png" alt="img"
										class="online"> <span class="name">John Doe</span> Looks
										like a nice house, when did you get it? Are we having the
										party there next week? ;)</li>
									<li><img src="img/avatars/2.png" alt="img" class="online">
										<span class="name">Alice Wonder</span> Seems cool.</li>
								</ul>
							
							<%
							}
							%>
							<ul>
							<li><img src="img/avatars/sunny.png" alt="img"
								class="online"> <input id="urcomment" type="text"
								class="form-control" placeholder="Post your comment..."></li>
						</ul>
					</div>
				</div>

				<%
					} else {
				%>
				<div class="panel panel-default">
					<div class="panel-body status">
						<div class="who clearfix">
							<img src="img/avatars/sunny.png" alt="img" class="busy"> <span
								class="name"><b>You</b> shared a blog</span> <span class="from"><b>1
									days ago</b> via Mobile, Sydney, Australia</span>
						</div>
						<div class="text">
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque
								in mauris elit. Ut nec arcu pretium eros varius porta vitae sit
								amet ipsum. Suspendisse porttitor, libero in rutrum pretium,
								lectus arcu maximus massa, ut condimentum metus libero laoreet
								lectus. Phasellus a lectus pulvinar, lacinia sem quis, suscipit
								turpis. <br> <br> Nam ipsum orci, blandit in lectus
								ut, viverra vehicula nisl. Proin eu arcu ut neque tempus viverra
								nec ac tellus. <strong>[</strong><a href="javascript:void(0);">Keep
									reading</a><strong>]</strong>
						</div>
						<ul class="links">
							<li><a href="javascript:void(0);"><i
									class="fa fa-thumbs-o-up"></i> Like</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-comment-o"></i> Comment</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-share-square-o"></i> Share</a></li>
						</ul>
					</div>
				</div>
				<%
					}
						}
					int totalLength = postfileidString.length();	
					postfileidString.delete(0, totalLength);
					
					
					}
				%>



				<!-- a blank row to get started -->


				<!-- <div class="col-sm-6 col-lg-4">

					<div class="panel panel-default">
						<div class="panel-body status">
							<div class="who clearfix">
								<img src="img/avatars/sunny.png" alt="img" class="online">
								<span class="name"><b>John Doe</b> sent you a message</span> <span
									class="from"><b>1 days ago</b> via Mobile, Dubai</span>
							</div>
							<div class="text">Just landed in Dubai. My body must have
								lost like 4 liters of moisture, its 50 degrees here!!</div>
							<ul class="links">
								<li><a href="javascript:void(0);"><i
										class="fa fa-comment"></i> Reply</a></li>
								<li><a href="javascript:void(0);"><i
										class="fa fa-share-square-o"></i> Share</a></li>
							</ul>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-body status smart-form vote">
							<div class="who clearfix">
								<img src="img/avatars/3.png" alt="img" class="offline"> <span
									class="name"><b>Alliz Yaen</b> started a question poll</span> <span
									class="from"><b>2 days ago</b> via Mobile, Sydney,
									Australia</span>
							</div>
							<div class="image">
								<strong>How did you guys like the movie <i>"Albert
										The Einstine?"</i> I reckon it was an awesome movie!
								</strong>
							</div>
							<ul class="comments">
								<li><label class="radio"> <input type="radio"
										name="radio"> <i></i>It was a great movie!
								</label></li>
								<li><label class="radio"> <input type="radio"
										name="radio"> <i></i>The Movie could have been
										better...
								</label></li>
								<li><label class="radio"> <input type="radio"
										name="radio"> <i></i>It was a boring documentry :(
								</label></li>
								<li class="text-right"><a href="javascript:void(0);"
									class="btn btn-xs btn-primary">Submit Vote</a></li>
							</ul>

							<ul class="links">
								<li><a href="javascript:void(0);"><i
										class="fa fa-thumbs-o-up"></i> Like</a></li>
								<li><a href="javascript:void(0);"><i
										class="fa fa-comment-o"></i> Comment</a></li>
								<li><a href="javascript:void(0);"><i
										class="fa fa-share-square-o"></i> Share</a></li>
							</ul>
						</div>
					</div>

					<div class="panel panel-default">

						<div class="panel-body status">

							<div class="who clearfix">
								<h4>Latest Forum Posts</h4>
							</div>

							<div class="who clearfix">
								<img src="img/avatars/2.png" alt="img" class="busy"> <span
									class="name font-sm"> <span class="text-muted">Posted
										by</span> <b> Karrigan Mean <span
										class="pull-right font-xs text-muted"><i>3 minutes
												ago</i></span>
								</b> <br> <a href="javascript:void(0);" class="font-md">Business
										Requirement Docs</a>
								</span>
							</div>

							<div class="who clearfix">
								<img src="img/avatars/3.png" alt="img" class="offline"> <span
									class="name font-sm"> <span class="text-muted">Posted
										by</span> <b> Alliz Yaen <span
										class="pull-right font-xs text-muted"><i>2 days ago</i></span>
								</b> <br> <a href="javascript:void(0);" class="font-md">Maecenas
										nec odio et ante tincidun</a>
								</span>
							</div>

							<div class="who clearfix">
								<img src="img/avatars/4.png" alt="img" class="away"> <span
									class="name font-sm"> <span class="text-muted">Posted
										by</span> <b> Barley Kartzukh <span
										class="pull-right font-xs text-muted"><i>1 month
												ago</i></span>
								</b> <br> <a href="javascript:void(0);" class="font-md">Tincidun
										nec Gasket Mask </a>
								</span>
							</div>

						</div>

					</div>

				</div> -->

				<!-- your contents here -->
				<!-- <div class="panel panel-default">
								<div class="panel-body status">
									<div class="who clearfix">
										<img src="img/avatars/5.png" alt="img" class="online">
										<span class="name"><b>Karrigan Mean</b> shared a photo</span>
										<span class="from"><b>1 days ago</b> via Mobile, Sydney, Australia</span>
									</div>
									<div class="image"><img src="img/realestate/6.png" alt="img">
									</div>
									<ul class="links">
										<li>
											<a href="javascript:void(0);"><i class="fa fa-thumbs-o-up"></i> Like</a>
										</li>
										<li>
											<a href="javascript:void(0);"><i class="fa fa-comment-o"></i> Comment</a>
										</li>
										<li>
											<a href="javascript:void(0);"><i class="fa fa-share-square-o"></i> Share</a>
										</li>
									</ul>
									<ul class="comments">
										<li>
											<img src="img/avatars/sunny.png" alt="img" class="online">
											<span class="name">John Doe</span>
											Looks like a nice house, when did you get it? Are we having the party there next week? ;)
										</li>
										<li>
											<img src="img/avatars/2.png" alt="img" class="online">
											<span class="name">Alice Wonder</span>
											Seems cool.
										</li>
										<li>
											<img src="img/avatars/sunny.png" alt="img" class="online">
											<input type="text" class="form-control" placeholder="Post your comment...">
										</li>
									</ul>
								</div>
							</div> -->

				<!-- <div class="panel panel-default">
								<div class="panel-body status">
									<div class="who clearfix">
										<h4>See anyone you know? Connect with them</h4>
									</div>
									<div class="row">
										<div class="text">
											<div class="col-sm-12 col-md-6 col-lg-4">
												<div class="well text-center connect">
													<img src="img/avatars/female.png" alt="img" class="margin-bottom-5 margin-top-5">
													<br>
													<span class="font-xs"><b>Jennifer Lezly</b></span>
													<a href="javascript:void(0);" class="btn btn-xs btn-success margin-top-5 margin-bottom-5"> <span class="font-xs">Connect</span> </a>
												</div>
											</div>
											<div class="col-sm-12 col-md-6 col-lg-4">
												<div class="well text-center connect">
													<img src="img/avatars/female.png" alt="img" class="margin-bottom-5 margin-top-5">
													<br>
													<span class="font-xs"><b>Jennifer Lezly</b></span>
													<a href="javascript:void(0);" class="btn btn-xs btn-success margin-top-5 margin-bottom-5"> <span class="font-xs">Connect</span> </a>
												</div>
											</div>
											<div class="col-sm-12 col-md-6 col-lg-4">
												<div class="well text-center connect">
													<img src="img/avatars/female.png" alt="img" class="margin-bottom-5 margin-top-5">
													<br>
													<span class="font-xs"><b>Jennifer Lezly</b></span>
													<a href="javascript:void(0);" class="btn btn-xs btn-success margin-top-5 margin-bottom-5"> <span class="font-xs">Connect</span> </a>
												</div>
											</div>
										</div>
									</div>
									<ul class="links text-right">
										<li class="">
											<a href="javascript:void(0);">Find people you know <i class="fa fa-arrow-right"></i> </a>
										</li>
									</ul>
								</div>
							</div> -->


				<!-- <div class="col-sm-6 col-lg-4">

							<div class="panel panel-default">
								<div class="panel-body status">
									<div class="who clearfix">
										<img src="img/avatars/sunny.png" alt="img" class="busy">
										<span class="name"><b>You</b> shared a blog</span>
										<span class="from"><b>1 days ago</b> via Mobile, Sydney, Australia</span>
									</div>
									<div class="text">
										<p>
											Lorem ipsum dolor sit amet, consectetur adipiscing elit.
											Quisque in mauris elit. Ut nec arcu pretium eros varius porta vitae sit amet ipsum. Suspendisse porttitor, libero in rutrum pretium, lectus arcu maximus massa, ut condimentum metus libero laoreet lectus. Phasellus a lectus pulvinar, lacinia sem quis, suscipit turpis.
											<br>
											<br>
											Nam ipsum orci, blandit in lectus ut, viverra vehicula nisl. Proin eu arcu ut neque tempus viverra nec ac tellus. <strong>[</strong><a href="javascript:void(0);">Keep reading</a><strong>]</strong>
									</div>
									<ul class="links">
										<li>
											<a href="javascript:void(0);"><i class="fa fa-thumbs-o-up"></i> Like</a>
										</li>
										<li>
											<a href="javascript:void(0);"><i class="fa fa-comment-o"></i> Comment</a>
										</li>
										<li>
											<a href="javascript:void(0);"><i class="fa fa-share-square-o"></i> Share</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-body status">
									<div class="who clearfix">
										<h4>Live Twitter Feed</h4>
									</div>
									<div class="text">

										<blockquote class="twitter-tweet">
											<p lang="en" xml:lang="en">
												Sunsets don’t get much better than this one over <a href="https://twitter.com/GrandTetonNPS" target="_blank">@GrandTetonNPS</a>. <a href="https://twitter.com/hashtag/nature?src=hash" target="_blank">#nature</a> <a href="https://twitter.com/hashtag/sunset?src=hash">#sunset</a> <a href="http://t.co/YuKy2rcjyU" target="_blank">pic.twitter.com/YuKy2rcjyU</a>
											</p>
											— US Dept of Interior (@Interior) <a href="https://twitter.com/Interior/status/463440424141459456" target="_blank">May 5, 2014</a>
										</blockquote>

									</div>
									<ul class="links text-right">
										<li class="">
											<a href="javascript:void(0);">Next <i class="fa fa-arrow-right"></i> </a>
										</li>
									</ul>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-body status">
									<div class="who clearfix">
										<h4>Live Chat</h4>
									</div>
									
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
												</div>
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
								</div>
							</div>

						</div> -->
		<!-- <!-- <div class="modal fade modal-fullscreen force-fullscreen" id="carousalModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" style="width: 90%; height: 90%">
				<div class="modal-content" style="width: 100%; height: 100%">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body"
						style="width: 55%; height: 90%; float: left;background-color: black;">
						<div class="well" style="height: 100%; background-color: black;">
						
						Main content goes here
							<div id="Imagesetcarousal" class="carousel slide" >
								<ol class="carousel-indicators"></ol>
								<div  class="carousel-inner" style="width: 70%;height: 100%"></div>
								
							</div>
							<a class="left carousel-control" href="#Imagesetcarousal" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span> </a>
							<a class="right carousel-control" href="#Imagesetcarousal" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span> </a>
						</div>	
					</div>	
					
					<div style="width: 23%; height: 80%; float: left;">
						<ul class="links" style="border-top:1px solid rgba(0,0,0,.07);margin:0;padding:15px 20px;background:#fafafa">
							<li style="display:inline;padding-right:20px"><a href="javascript:void(0);"><i
									class="fa fa-thumbs-o-up" style="color:inherit;font-size:14px;margin-right:2px"></i> Like</a></li>
							<li style="display:inline;padding-right:20px"><a href="javascript:void(0);"><i
									class="fa fa-comment-o" style="color:inherit;font-size:14px;margin-right:2px"></i> Comment</a></li>
							<li style="display:inline;padding-right:20px"><a href="javascript:void(0);"><i
									class="fa fa-share-square-o" style="color:inherit;font-size:14px;margin-right:2px"></i> Share</a></li>
						</ul>

						<ul class="comments" style="border-top:1px solid rgba(0,0,0,.07);font-size:13px;padding:0 20px">
							<li style="border-bottom:1px solid rgba(0,0,0,.07);display:block;padding:15px 0 15px 40px;position:relative;border-bottom:none;padding-bottom:5px"><img style="height:30px;left:0;position:absolute;width:30px" src="img/avatars/sunny.png" alt="img"
								class="online"> <input id="urcomment" type="text"
								class="form-control" placeholder="Post your comment..."></li>
						</ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
				/.modal-content
			</div>
			/.modal-dialog
		</div>
		/.modal --> -->
		</div>
		
		
		<!-- <div class="modal fade modal-fullscreen force-fullscreen" id="stillModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" style="width: 90%; height: 90%">
				<div class="modal-content" style="width: 100%; height: 100%">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body"
						style="width: 75%; height: 80%; float: left;">
						<div class="well" style="height: 70%">
						
						Main content goes here
							<div class="carousel slide" >
								<ol class="carousel-indicators"></ol>
							</div>
							
							<div id="" class="carousel-inner"></div>
						
						</div>
					</div>

					<div style="width: 23%; height: 80%; float: left;">
						<ul class="links">
							<li><a href="javascript:void(0);"><i
									class="fa fa-thumbs-o-up"></i> Like</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-comment-o"></i> Comment</a></li>
							<li><a href="javascript:void(0);"><i
									class="fa fa-share-square-o"></i> Share</a></li>
						</ul>

						<ul class="comments">
							<li><img src="img/avatars/sunny.png" alt="img"
								class="online"> <input id="urcomment" type="text"
								class="form-control" placeholder="Post your comment..."></li>
						</ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
				/.modal-content
			</div>
			/.modal-dialog
		</div> -->
		<!-- /.modal -->
		</div>

			<!-- end row --> </section>
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

	!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
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
	
function deletefun(){
		
		var element = document.getElementById('topbottom');
		alert('in the click');
		element.remove();
	}
	
	function openmodalTop(postfileids){
		
		// ev.preventDefault();
		
		var filelist = postfileids.split(",");
		var fileimages = "";
		for(var i=0;i<filelist.length;i++){
			if(filelist[i] != " "){
			var fileimage = "";
			alert("in the loop"+i+" dsdsfdfs"+filelist.length+" ghdgdhgdhg file list"+filelist[i]);
			//var	fileimage = "";
				if(i==0){
					fileimage = "<div class='item active' style='height:100%;margin-top:20px;'><img style='height:100%;width:100%' src='/Fliker/imageController/"+filelist[i]+"' alt=''></div>";
					fileimages = fileimages+fileimage;
				}else{
					fileimage = "<div class='item' style='height:100%;margin-top:20px;'><img style='height:100%;width:100%' src='/Fliker/imageController/"+filelist[i]+"' alt=''></div>";
					fileimages = fileimages+fileimage;
				} 
				
			
			}
			
			/* if(i==0){
			var	fileimage = "<div class='item active'><img src='/Fliker/imageController/"+filelist[i]+"' alt=""></div>"
			fileimages = fileimages+fileimage;
			}else{
			var	fileimage = "<div class='item'><img src='/Fliker/imageController/"+filelist[i]+"' alt=""></div>"
			fileimages = fileimages+fileimage;
			} */
			//alert(fileimages);
			
		} 
		 
		alert(fileimages); 
		
		
		 var modaldialogue = "<div style='position: fixed; width: 100%; height: 100%; top: 0%; left: 0%; text-align: center; background-color:gray;margin-top:30px;' id='topbottom' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
			 +"aria-hidden='true'><div style='width: 98%; height: 90%;margin-top:30px;margin-left:30px;'><div style='width: 100%; height: 100%'><div style='margin-left: 100%;'><button type='button' class='close' style='padding:20px;background:white;border:1px' onclick='deletefun();'" 
		 +"aria-hidden='true'>&times;</button></div><div	style='width: 55%; height: 92%; margin-left: 200px;  float: left; background-color: black; opacity: 0.7'><div class='well' style='height: 100%;"
		 +"background-color: black;'><div id='Imagesetcarousal'style='height:100%' class='carousel slide'><ol class='carousel-indicators'></ol><div class='carousel-inner' style='width: 100%; height: 100%'>"+fileimages
		 +"</div></div><a class='left carousel-control'  href='#Imagesetcarousal' data-slide='prev'> <span class='glyphicon glyphicon-chevron-left'></span></a><a class='right carousel-control' href='#Imagesetcarousal'"
		 +"data-slide='next'> <span class='glyphicon glyphicon-chevron-right'></span></a></div></div><div style='width: 23%; height: 93%;  float: left;background-color: white;'><div style='width: 100%; height: 100%;" +"background-color: white;'><ul class='links' style='border-top: 1px solid rgba(0, 0, 0, .07); margin: 0; padding: 15px 20px; background: #fafafa'><li style='display: inline; padding-right: 20px'><a"
		 +" href='javascript:void(0);'> <i class='fa fa-thumbs-o-up' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Like</a></li><li style='display: inline; padding-right: 20px'><a"							+"href='javascript:void(0);'><i class='fa fa-comment-o'	style='color: inherit; font-size: 14px; margin-right: 2px'></i>Comment</a></li><li style='display: inline; padding-right: 20px'><a"				+"href='javascript:void(0);'><i class='fa fa-share-square-o' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Share</a></li></ul><ul class='comments' "
		 +"style='border-top: 1px solid rgba(0, 0, 0, .07); font-size: 13px; padding: 0 20px'><li style='border-bottom: 1px solid rgba(0, 0, 0, .07); display: block; padding: 15px 0 15px 40px; position: relative;" +"border-bottom: none; padding-bottom: 5px'><img style='height: 30px; left: 0; position: absolute; width: 30px'	src='img/avatars/sunny.png' alt='img' class='online'> "
		 +"<input id='urcomment' type='text' class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div></div>";
		
		// $('.carousel-inner').append(fileimages);
		 
		$('#content').append(modaldialogue);			
		 
		 //formElement(postid);
		 
		 
	 }
	
	function openModalRest(postfileids){
		
		// ev.preventDefault();
		 /* var id = $(this)[0].id;
		 alert(id);
		 var postid = $(this)[0].title;
		 alert("in the form"+postid); */
		 alert(postfileids);
		 //<img src='/Fliker/imageController/"+postfileids+"' alt=''>
		 
		 var modaldialogue = "<div style='position: fixed; width: 100%; height: 100%; top: 0%; left: 0%; text-align: center; background-color:gray;margin-top:30px;' id='topbottom' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
			 +"aria-hidden='true'><div style='width: 98%; height: 90%;margin-top:30px;margin-left:30px;'><div style='width: 100%; height: 100%'><div style='margin-left: 100%;'><button type='button' class='close' style='padding:20px;background:white;border:1px' onclick='deletefun();'" 
		 +"aria-hidden='true'>&times;</button></div><div	style='width: 55%; height: 92%; margin-left: 200px;  float: left; background-color: black; opacity: 0.7'><div class='well' style='height: 100%;"
		 +"background-color: black;'><div id='Imagesetcarousal' class='carousel slide'></div><img style='height:100%;width:100%' src='/Fliker/imageController/"+postfileids+"' alt=''>"
		 +"</div></div><div style='width: 23%; height: 93%;  float: left;background-color: white;'><div style='width: 100%; height: 100%;" +"background-color: white;'><ul class='links' style='border-top: 1px solid rgba(0, 0, 0, .07); margin: 0; padding: 15px 20px; background: #fafafa'><li style='display: inline; padding-right: 20px'><a"
		 +" href='javascript:void(0);'> <i class='fa fa-thumbs-o-up' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Like</a></li><li style='display: inline; padding-right: 20px'><a"							+"href='javascript:void(0);'><i class='fa fa-comment-o'	style='color: inherit; font-size: 14px; margin-right: 2px'></i>Comment</a></li><li style='display: inline; padding-right: 20px'><a"				+"href='javascript:void(0);'><i class='fa fa-share-square-o' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Share</a></li></ul><ul class='comments' "
		 +"style='border-top: 1px solid rgba(0, 0, 0, .07); font-size: 13px; padding: 0 20px'><li style='border-bottom: 1px solid rgba(0, 0, 0, .07); display: block; padding: 15px 0 15px 40px; position: relative;" +"border-bottom: none; padding-bottom: 5px'><img style='height: 30px; left: 0; position: absolute; width: 30px'	src='img/avatars/sunny.png' alt='img' class='online'> "
		 +"<input id='urcomment' type='text' class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div></div>";

		$('#content').append(modaldialogue);			
		 
		 //formElement(postid);
		 
		 
	 }
	
	function singleopenModalRest(postfileids){
		
		// ev.preventDefault();
		 /* var id = $(this)[0].id;
		 alert(id);
		 var postid = $(this)[0].title;
		 alert("in the form"+postid); */
		 alert(postfileids);
		 //<img src='/Fliker/imageController/"+postfileids+"' alt=''>
		 
		 var modaldialogue = "<div style='position: fixed; width: 100%; height: 100%; top: 0%; left: 0%; text-align: center; background-color:gray;margin-top:30px;' id='topbottom' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
			 +"aria-hidden='true'><div style='width: 98%; height: 90%;margin-top:30px;margin-left:30px;'><div style='width: 100%; height: 100%'><div style='margin-left: 100%;'><button type='button' class='close' style='padding:20px;background:white;border:1px' onclick='deletefun();'" 
		 +"aria-hidden='true'>&times;</button></div><div	style='width: 55%; height: 92%; margin-left: 200px;  float: left; background-color: black; opacity: 0.7'><div class='well' style='height: 100%;"
		 +"background-color: black;'><div id='Imagesetcarousal' class='carousel slide'></div><img style='height:100%;width:100%' src='/Fliker/imageController/"+postfileids+"' alt=''>"
		 +"</div></div><div style='width: 23%; height: 93%;  float: left;background-color: white;'><div style='width: 100%; height: 100%;" +"background-color: white;'><ul class='links' style='border-top: 1px solid rgba(0, 0, 0, .07); margin: 0; padding: 15px 20px; background: #fafafa'><li style='display: inline; padding-right: 20px'><a"
		 +" href='javascript:void(0);'> <i class='fa fa-thumbs-o-up' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Like</a></li><li style='display: inline; padding-right: 20px'><a"							+"href='javascript:void(0);'><i class='fa fa-comment-o'	style='color: inherit; font-size: 14px; margin-right: 2px'></i>Comment</a></li><li style='display: inline; padding-right: 20px'><a"				+"href='javascript:void(0);'><i class='fa fa-share-square-o' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Share</a></li></ul><ul class='comments' "
		 +"style='border-top: 1px solid rgba(0, 0, 0, .07); font-size: 13px; padding: 0 20px'><li style='border-bottom: 1px solid rgba(0, 0, 0, .07); display: block; padding: 15px 0 15px 40px; position: relative;" +"border-bottom: none; padding-bottom: 5px'><img style='height: 30px; left: 0; position: absolute; width: 30px'	src='img/avatars/sunny.png' alt='img' class='online'> "
		 +"<input id='urcomment' type='text' class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div></div>";

		$('#content').append(modaldialogue);			
		 
		 //formElement(postid);
		 
		 
	 }
	
	function multiModalRest(postfileids){
		
		var filelist = postfileids.split(",");
		var fileimages = "";
		for(var i=0;i<filelist.length;i++){
			if(filelist[i] != " "){
			var fileimage = "";
			alert("in the loop"+i+" dsdsfdfs"+filelist.length+" ghdgdhgdhg file list"+filelist[i]);
			//var	fileimage = "";
				if(i==0){
					fileimage = "<div class='item active' style='height:100%;margin-top:20px;'><img style='height:100%;width:100%' src='/Fliker/imageController/"+filelist[i]+"' alt=''></div>";
					fileimages = fileimages+fileimage;
				}else{
					fileimage = "<div class='item' style='height:100%;margin-top:20px;'><img style='height:100%;width:100%' src='/Fliker/imageController/"+filelist[i]+"' alt=''></div>";
					fileimages = fileimages+fileimage;
				} 
				
			
			}
			
			/* if(i==0){
			var	fileimage = "<div class='item active'><img src='/Fliker/imageController/"+filelist[i]+"' alt=""></div>"
			fileimages = fileimages+fileimage;
			}else{
			var	fileimage = "<div class='item'><img src='/Fliker/imageController/"+filelist[i]+"' alt=""></div>"
			fileimages = fileimages+fileimage;
			} */
			//alert(fileimages);
			
		} 
		 
		alert(fileimages); 
		
		// ev.preventDefault();
		 /* var id = $(this)[0].id;
		 alert(id);
		 var postid = $(this)[0].title;
		 alert("in the form"+postid); */
		 /* var modaldialogue = "<div style='position: fixed; width: 100%; height: 100%; top: 0%; left: 0%; text-align: center; background-color:gray;' id='topbottom' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
			 +"aria-hidden='true'><div style='width: 98%; height: 90%;margin-top:30px;margin-left:30px;'><div style='width: 100%; height: 100%'><div style='margin-left: 100%;'><button type='button' class='close' style='padding:20px;background:white;border:1px' onclick='deletefun();'" 
		 +"aria-hidden='true'>&times;</button></div><div	style='width: 55%; height: 92%; margin-left: 200px;  float: left; background-color: black; opacity: 0.7'><div class='well' style='height: 100%;"
		 +"background-color: black;'><div id='Imagesetcarousal' class='carousel slide'><ol class='carousel-indicators'></ol><div class='carousel-inner' style='width: 70%; height: 100%'></div></div>"
		 +"<a class='left carousel-control' href='#Imagesetcarousal' data-slide='prev'> <span class='glyphicon glyphicon-chevron-left'></span></a><a class='right carousel-control' href='#Imagesetcarousal'"
		 +"data-slide='next'> <span class='glyphicon glyphicon-chevron-right'></span></a></div></div><div style='width: 23%; height: 93%;  float: left;background-color: white;'><div style='width: 100%; height: 100%;" +"background-color: white;'><ul class='links' style='border-top: 1px solid rgba(0, 0, 0, .07); margin: 0; padding: 15px 20px; background: #fafafa'><li style='display: inline; padding-right: 20px'><a"
		 +" href='javascript:void(0);'> <i class='fa fa-thumbs-o-up' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Like</a></li><li style='display: inline; padding-right: 20px'><a"							+"href='javascript:void(0);'><i class='fa fa-comment-o'	style='color: inherit; font-size: 14px; margin-right: 2px'></i>Comment</a></li><li style='display: inline; padding-right: 20px'><a"				+"href='javascript:void(0);'><i class='fa fa-share-square-o' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Share</a></li></ul><ul class='comments' "
		 +"style='border-top: 1px solid rgba(0, 0, 0, .07); font-size: 13px; padding: 0 20px'><li style='border-bottom: 1px solid rgba(0, 0, 0, .07); display: block; padding: 15px 0 15px 40px; position: relative;" +"border-bottom: none; padding-bottom: 5px'><img style='height: 30px; left: 0; position: absolute; width: 30px'	src='img/avatars/sunny.png' alt='img' class='online'> "
		 +"<input id='urcomment' type='text' class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div></div>"; */
		 var modaldialogue = "<div style='position: fixed; width: 100%; height: 100%; top: 0%; left: 0%; text-align: center; background-color:gray;margin-top:30px;' id='topbottom' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
			 +"aria-hidden='true'><div style='width: 98%; height: 90%;margin-top:30px;margin-left:30px;'><div style='width: 100%; height: 100%'><div style='margin-left: 100%;'><button type='button' class='close' style='padding:20px;background:white;border:1px' onclick='deletefun();'" 
		 +"aria-hidden='true'>&times;</button></div><div	style='width: 55%; height: 92%; margin-left: 200px;  float: left; background-color: black; opacity: 0.7'><div class='well' style='height: 100%;"
		 +"background-color: black;'><div id='Imagesetcarousal'style='height:100%' class='carousel slide'><ol class='carousel-indicators'></ol><div class='carousel-inner' style='width: 100%; height: 100%'>"+fileimages
		 +"</div></div><a class='left carousel-control'  href='#Imagesetcarousal' data-slide='prev'> <span class='glyphicon glyphicon-chevron-left'></span></a><a class='right carousel-control' href='#Imagesetcarousal'"
		 +"data-slide='next'> <span class='glyphicon glyphicon-chevron-right'></span></a></div></div><div style='width: 23%; height: 93%;  float: left;background-color: white;'><div style='width: 100%; height: 100%;" +"background-color: white;'><ul class='links' style='border-top: 1px solid rgba(0, 0, 0, .07); margin: 0; padding: 15px 20px; background: #fafafa'><li style='display: inline; padding-right: 20px'><a"
		 +" href='javascript:void(0);'> <i class='fa fa-thumbs-o-up' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Like</a></li><li style='display: inline; padding-right: 20px'><a"							+"href='javascript:void(0);'><i class='fa fa-comment-o'	style='color: inherit; font-size: 14px; margin-right: 2px'></i>Comment</a></li><li style='display: inline; padding-right: 20px'><a"				+"href='javascript:void(0);'><i class='fa fa-share-square-o' style='color: inherit; font-size: 14px; margin-right: 2px'></i>Share</a></li></ul><ul class='comments' "
		 +"style='border-top: 1px solid rgba(0, 0, 0, .07); font-size: 13px; padding: 0 20px'><li style='border-bottom: 1px solid rgba(0, 0, 0, .07); display: block; padding: 15px 0 15px 40px; position: relative;" +"border-bottom: none; padding-bottom: 5px'><img style='height: 30px; left: 0; position: absolute; width: 30px'	src='img/avatars/sunny.png' alt='img' class='online'> "
		 +"<input id='urcomment' type='text' class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div></div>";

		$('#content').append(modaldialogue);			
		 
		 //formElement(postid);
		 
		 
	 }
	
	
	function liked(){
		alert('in the like');
		
	}
	
	</script>

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
				 
				 /* $(this).click(function test(){
					
					// ev.preventDefault();
					 var id = $(this)[0].id;
					 alert(id);
					 var postid = $(this)[0].title;
					 alert("in the form"+postid);
					 var modaldialogue = "<div style='position:fixed; width:100%; height:100%; margin:-300px auto auto -250px;   top:0%; left:0%; text-align:center;background-color: black;opacity: 0.7' id='' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'"
										+"aria-hidden='true'><div style='width: 90%; height: 90%'><div style='width: 100%; height: 100%'><div >"
										+"<button type='button' class='close' onclick='' aria-hidden='true'>&times;</button></div><div style='width: 55%; height: 90%; float: left;background-color: black;'>"
										+"<div class='well' style='height: 100%; background-color: black;'><div id='Imagesetcarousal' class='carousel slide' ><ol class='carousel-indicators'></ol><div  class='carousel-inner' style='width: 70%;height: 100%'></div>"
										+"</div><a class='left carousel-control' href='#Imagesetcarousal' data-slide='prev'> <span class='glyphicon glyphicon-chevron-left'></span> </a><a class='right carousel-control' href='#Imagesetcarousal' data-slide='next'> <span class='glyphicon glyphicon-chevron-right'></span> </a>"
										+"</div></div><div style='width: 23%; height: 80%; float: left;'><ul class='links' style='border-top:1px solid rgba(0,0,0,.07);margin:0;padding:15px 20px;background:#fafafa'><li style='display:inline;padding-right:20px'><a href='javascript:void(0);'>"
										+"<i class='fa fa-thumbs-o-up' style='color:inherit;font-size:14px;margin-right:2px'></i> Like</a></li><li style='display:inline;padding-right:20px'><a href='javascript:void(0);'><i class='fa fa-comment-o' style='color:inherit;font-size:14px;margin-right:2px'></i> Comment</a></li>"
										+"<li style='display:inline;padding-right:20px'><a href='javascript:void(0);'><i class='fa fa-share-square-o' style='color:inherit;font-size:14px;margin-right:2px'></i> Share</a></li></ul><ul class='comments' style='border-top:1px solid rgba(0,0,0,.07);font-size:13px;padding:0 20px'>"
										+"<li style='border-bottom:1px solid rgba(0,0,0,.07);display:block;padding:15px 0 15px 40px;position:relative;border-bottom:none;padding-bottom:5px'><img style='height:30px;left:0;position:absolute;width:30px' src='img/avatars/sunny.png' alt='img' class='online'> <input id='urcomment' type='text'"
										+"class='form-control' placeholder='Post your comment...'></li></ul></div></div></div></div></div>";
					 
				$('#content').append(modaldialogue);
					 //formElement(postid);
					 
					 
				 }); */
				 
				 
				 function formElement(postfileids){
					 alert("in the form");
					 var m = postfileids.split(",");
					 alert(m);
					 
					 for(var i=0 ; i< m.length ; i++) {
						  $('<div class="item" style="width: 100%; height: 100%;"><img src="/Fliker/imageController/'+m[i]+'"><div class="carousel-caption"></div>   </div>').appendTo('.carousel-inner');
						  $('<li data-target="#Imagesetcarousal" data-slide-to="'+i+'"></li>').appendTo('.carousel-indicators')

						  }
						  $('.item').first().addClass('active');
						  $('.carousel-indicators > li').first().addClass('active');
						  $('#Imagesetcarousal').carousel();
					 
					 
				 }
				 
				function stillElement(){
					 
					 /* for(var i=0 ; i< m.length ; i++) {
						    $('<div class="item"><img src="'+m[i]+'"><div class="carousel-caption"></div>   </div>').appendTo('.carousel-inner');
						    $('<li data-target="#carousel-example-generic" data-slide-to="'+i+'"></li>').appendTo('.carousel-indicators')

						  }
						  $('.item').first().addClass('active');
						  $('.carousel-indicators > li').first().addClass('active');
						  $('#carousel-example-generic').carousel(); */
					 
					 
				 }
				 
				 
				 function geoFindMe() {
					  /* var output = document.getElementById("out");

					  if (!navigator.geolocation){
					    output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
					    return;
					  }
 */
					  function success(position) {
					    var latitude  = position.coords.latitude;
					    var longitude = position.coords.longitude;
					    alert(latitude)

					   // output.innerHTML = '<p>Latitude is ' + latitude + '° <br>Longitude is ' + longitude + '°</p>';

					    var img = new Image();
					    img.src = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=13&size=300x300&sensor=false";

					    //output.appendChild(img);
					  };

					  /* function error() {
					    output.innerHTML = "Unable to retrieve your location";
					  }; */

					 // output.innerHTML = "<p>Locating…</p>";

					  navigator.geolocation.getCurrentPosition(success, error);
					}
				 
				 
				 
				 	function createPhotoSection(){
				 		
				 		var modal = "<div class='modal fade modal-fullscreen force-fullscreen' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'><div class='modal-dialog'><div class='modal-content'>"+
				 					"<div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button><h4 class='modal-title'>Modal title</h4></div><div class='modal-body'><p>One fine body…</p>"+
				 					"</div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>Close</button><button type='button' class='btn btn-primary'>Save changes</button></div></div></div></div>";
				 					
				 					
				 		
				 		
				 	}
				 
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
				 $(window)
					.scroll(
							function() {
								if ($(window).scrollTop()
										+ $(window).height() == $(
										document).height()) {
									alert("bottom!");

									$
											.ajax({
												url : "dashboardsocialpost?",
												method : 'GET',
												success : function(
														data) {

													console
															.log(data);

													var postid = "";
													var username = "";
													var postfileid = "";
													var postType = "";
													var postDescription = "";
													var postidDate = "";
													var userid = "";
													var postuser = "";
													var postshareids = null;
													var postcommentid = null;
													var postlikeid = null;

													for (i = 0; i < data.length; i++) {
														var dataentry = data[i];
														for ( var key in dataentry) {
															if (dataentry
																	.hasOwnProperty(key)) {
																if (key == "postid") {
																	postid = dataentry[key];
																} else if (key == "postType") {
																	postType = dataentry[key];
																} else if (key == "postDescription") {
																	postDescription = dataentry[key];
																} else if (key == "postiddate") {
																	postidDate = dataentry[key];
																} else if (key == "postuser") {
																	postuser = dataentry[key];
																} else if (key == "postsharedids") {
																	postshareids = dataentry[key];

																	var sharedlocation = "";
																	var sharedperson = "";
																	var sharedpersonimage = "";
																	var sharedcomment = "";
																	var sharedtime = "";

																	var sharediv = "";

																	for (var j = 0; j < postshareids.length; j++) {

																		var sharedinfo = postshareids[j];
																		for ( var shared in sharedinfo) {
																			if (sharedinfo
																					.hasOwnProperty(shared)) {
																				if (shared == "sharedLocation") {
																					sharedlocation = sharedinfo[shared];
																				} else if (shared == "sharedPerson") {
																					sharedperson = sharedinfo[shared];
																					sharediv = sharediv
																							+ "<b>"
																							+ sharedperson
																							+ "</b>";

																				} else if (shared == "sharedPersonImage") {
																					sharedpersonimage = sharedinfo[shared];
																				} else if (shared == "sharedcomment") {
																					sharedcomment = sharedinfo[shared];
																				} else if (shared == "sharedtime") {
																					sharedtime = sharedinfo[shared];
																				}

																			}
																		}

																	}

																} else if (key == "userid") {
																	userid = dataentry[key];

																} else if (key == "postcommentids") {
																	postcommentid = dataentry[key];

																	var commentdiv = "";

																	for (var t = 0; t < postcommentid.length; t++) {

																		var commentdate = "";
																		var comments = "";
																		var commentownerid = "";
																		var replyerComment = null;
																		var commentowner = "";
																		var commentid = "";

																		var tempcommentdiv = "";
																		var coomentinfo = postcommentid[t];
																		for ( var comment in coomentinfo) {
																			if (coomentinfo
																					.hasOwnProperty(comment)) {

																				if (comment == "commentdate") {
																					commentdate = coomentinfo[comment];
																				} else if (comment == "comments") {
																					comments = coomentinfo[comment];
																				} else if (comment == "commentid") {
																					commentid = coomentinfo[comment];
																				}else if (comment == "commentsOwner") {
																					commentowner = coomentinfo[comment];
																				} /* else if (comment == "replyperComment") {
																					replyerComment = coomentinfo[comment];

																					for (var s = 0; s < replyerComment.length; s++) {

																						var replyinfo = replyerComment[s];

																						var replyid = "";
																						var replycomment = "";
																						var replytime = "";

																						for ( var reply in replyinfo) {
																							if (replyinfo
																									.hasOwnProperty(reply)) {

																								if (reply == "replyid") {
																									replyid = replyinfo[reply];
																								} else if (reply == "replycomment") {
																									replycomment = replyinfo[reply];
																								} else if (reply == "replytime") {
																									replytime = replyinfo[reply];
																								}

																							}

																						}

																					}

																				} */

																			}
																		}

																		var percommentdiv = "<li id='"+commentid+"'><img src='/Fliker/imageFromUserid/"+userid+"' alt='img' class='online'><span class='name'>"
																				+ commentowner
																				+ "</span>"
																				+ comments
																				+ "</li>";

																		var tempcommentdiv = tempcommentdiv
																				+ percommentdiv;

																	}

																	commentdiv = "<ul class='comments'>"
																			+ tempcommentdiv + "</ul><ul>"
																			+ "<li><img src='img/avatars/sunny.png' alt='img' class='online'> <input type='text' class='form-control' placeholder='Post your comment...''></li>"
																			+ "</ul>";

																} else if (key == "postlikeids") {
																	postlikeid = dataentry[key];

																	var likeid = "";
																	var likeowner = "";

																	for (var t = 0; t < postlikeid.length; t++) {

																		var likedinfo = postlikeid[t];

																		for ( var liked in likedinfo) {
																			if (likedinfo
																					.hasOwnProperty(liked)) {

																				if (liked == "likeid") {
																					likeid = likedinfo[liked];
																				} else if (liked == "likeowner") {
																					likeowner = likedinfo[liked];
																				}

																			}

																		}

																	}

																} else if (key == "postFileid") {
																	postfileid = dataentry[key];

																}

																if (postfileid != "") {

																	var div1 = "<div id="+postid+" class='panel panel-default'><div class='panel-body status'><b>Shared by </b>"
																			+ sharediv
																			+ "<div class='who clearfix'><img src='/Fliker/imageFromUserid/"+userid+"' alt='img' class='online'>"
																			+ "<span class='name'><b>"
																			+ postuser
																			+ "</b> shared a photo</span><span class='from'><b>"
																			+ postidDate
																			+ "days ago</b> via Mobile, Sydney, Australia</span></div><div class='image'><img src='/Fliker/imageController/"+postfileid+"' alt='img'>"
																			+ "</div><ul class='links'><li><a href='javascript:void(0);'><i class='fa fa-thumbs-o-up'></i> Like</a></li><li>"
																			+ "<a href='javascript:void(0);'><i class='fa fa-comment-o'></i> Comment</a></li><li><a href='javascript:void(0);'><i class='fa fa-share-square-o'></i> Share</a>"
																			+ "</li></ul>"
																			+ commentdiv
																			+ "</div></div>";
																} else {
																	var div1 = "<div id="+postid+" class='panel panel-default'><div class='panel-body status'><b>Shared by </b>"
																			+ sharediv
																			+ "<div class='who clearfix'><img src='/Fliker/imageFromUserid/"+userid+"' alt='img' class='online'>"
																			+ "<span class='name'><b>"
																			+ postuser
																			+ "</b> shared a photo</span><span class='from'><b>"
																			+ postidDate
																			+ "days ago</b> via Mobile, Sydney, Australia</span></div>"
																			+ "<ul class='links'><li><a href='javascript:void(0);'><i class='fa fa-thumbs-o-up'></i> Like</a></li><li>"
																			+ "<a href='javascript:void(0);'><i class='fa fa-comment-o'></i> Comment</a></li><li><a href='javascript:void(0);'><i class='fa fa-share-square-o'></i> Share</a>"
																			+ "</li></ul>"
																			+ commentdiv
																			+ "</div></div>";
																}

															}

														}

														if (i % 2 == 0) {
															$(
																	'#count4')
																	.append(
																			div1);
														} else {
															$(
																	'#count0')
																	.append(
																			div1);
														}

													}
												}
											});

									var div = "<div class='panel panel-default'><div class='panel-body status'><div class='who clearfix'><h4>Live Twitter Feed</h4></div>"
											+ "<div class='text'><blockquote class='twitter-tweet'><p lang='en' xml:lang='en'>Sunsets don’t get much better than this one over "
											+ "<a href='https://twitter.com/GrandTetonNPS' target='_blank'>@GrandTetonNPS</a>. <a href='https://twitter.com/hashtag/nature?src=hash' target='_blank'>#nature</a>"
											+ " <a href='https://twitter.com/hashtag/sunset?src=hash'>#sunset</a> <a href='http://t.co/YuKy2rcjyU' target='_blank'>pic.twitter.com/YuKy2rcjyU</a>"
											+ "</p>— US Dept of Interior (@Interior) <a href='https://twitter.com/Interior/status/463440424141459456' target='_blank'>May 5, 2014</a></blockquote>"
											+ "</div><ul class='links text-right'><li class=''><a href='javascript:void(0);'>Next <i class='fa fa-arrow-right'></i> </a></li></ul></div></div>";

									$('#count0').append(div);
									$('#count4').append(div);

								}
							});
			 
			 
			$('.commmentclass').bind("enterKey",function(e){
				   alert("entered");
				});
			$('.commmentclass').keyup(function(e){
			    if(e.keyCode == 13)
			    {
			        $(this).trigger("enterKey");
			        
			        comment = $('#urcomment')[0].value;
			        postid = $('#urcomment')[0].alt;
			        userid = $('#urcomment')[0].name
			        
			        
			         $.ajax({
						url : "dashboardsocial/saveComments?postid="+postid+"&comment="+comment+"&userid="+userid,
						method : 'POST',
						success : function(){
							
							
						}
					
			        }); 
			        
			        var newcommentdiv = "<li id='commentidli1'><img src='img/avatars/2.png' alt='img' class='online'><span class='name'>Alice Wonder</span> Seems cool.</li>";
			        
			        $('#commentidul').append(newcommentdiv);
			        
			        
			    }
			}); 

		})
		
		
				 
				 /* $("#notedown").on("click", function(){
					    alert("form has been submitted.");
					     var note = $('textarea#notemessage').val();
						
					    
					    $.ajax({
					    	url: "dailynotes?note="+note, 
							success : function() {
								
							} 	
					    
				 });
					  
					    $('textarea#notemessage').val(" ");
				 });
				 
				
			}) */
		
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
		<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript">
function initialize() {
    var loc = {};
    var geocoder = new google.maps.Geocoder();
    if(google.loader.ClientLocation) {
        loc.lat = google.loader.ClientLocation.latitude;
        loc.lng = google.loader.ClientLocation.longitude;

        var latlng = new google.maps.LatLng(loc.lat, loc.lng);
        geocoder.geocode({'latLng': latlng}, function(results, status) {
            if(status == google.maps.GeocoderStatus.OK) {
                alert(results[0]['formatted_address']);
            };
        });
    }
}

google.load("maps", "3.x", {other_params: "sensor=false", callback:initialize});

</script>
</body>

</html>