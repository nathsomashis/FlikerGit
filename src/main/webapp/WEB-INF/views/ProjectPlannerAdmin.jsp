<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<title> My Courses </title>
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
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css">  -->

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
		<link href='<c:url value="/resources/img/splash/touch-icon-ipad.png" />' rel="apple-touch-icon">
		<!-- <link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png"> -->
		<link href='<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />' rel="apple-touch-icon" sizes="120x120">
		<!-- <link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png"> -->
		<link href='<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />' rel="apple-touch-icon" sizes="152x152">
		<!-- <link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png"> -->
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
<!-- 		<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)"> -->
		<link href='<c:url value="/resources/img/splash/ipad-landscape.png" />' rel="apple-touch-startup-image" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<!-- <link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)"> -->
		<link href='<c:url value="/resources/img/splash/ipad-portrait.png" />' rel="apple-touch-startup-image" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<!-- <link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)"> -->
		<link href='<c:url value="/resources/img/splash/iphone.png" />' rel="apple-touch-startup-image" media="screen and (max-device-width: 320px)">

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
								<a href="login.html" class="padding-10 padding-top-5 padding-bottom-5" data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i> <strong><u>L</u>ogout</strong></a>
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
					
					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
						<img src="img/avatars/sunny.png" alt="me" class="online" /> 
						<span>
							john.doe 
						</span>
						<i class="fa fa-angle-down"></i>
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
		<li ><a href="projectdash?"><i
				class="fa fa-lg fa-fw fa-search-plus"></i> <span
				class="menu-item-parent">Dashboard</span> </a></li>
		<li><a href="projectcalendar?"><i
				class="fa fa-lg fa-fw fa-retweet txt-color-blue"></i> <span
				class="menu-item-parent">Calendar</span> </a></li>
		<li><a href="projectblog?"><i class="fa fa-lg fa-fw fa-info"></i>
				<span class="menu-item-parent">Discussion</span> </a></li>
		<li><a href="projecttimeline?"><i class="fa fa-lg fa-fw fa-road"></i>
				<span class="menu-item-parent">Timeline</span> </a></li>
		<li class="active"><a href="projectdrive?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Share Drive</span></a></li>
		<li><a href="projectplanning?" title="NewPost"><i
				class="fa fa-lg fa-fw fa-inbox"></i><span class="menu-item-parent">Project Planning</span></a>
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

				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li><a href="hello?name=Eric?">Home</li><li>Course</li><li>My Course</li>
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
							<i class="fa-fw fa fa-home"></i> App Views <span>>
								Blog </span>
						</h1>
					</div>
					<!-- end col -->

					<!-- right side of the page with the sparkline graphs -->
					<!-- col -->
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
						<!-- sparks -->
						<ul id="sparks">
							<li class="sparks-info">
								<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myTask">
											Create Task
										</button>
							</li>
							<li class="sparks-info">
								<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModule">
											Create Module
										</button>
							</li>
							
						</ul>
						<!-- end sparks -->
					</div>
					<!-- end col -->

				</div>
				<!-- end row -->
				
				<div class="row">

					<div class="col-sm-9">

						<div class="well padding-10">

							<div class="row">
								<div class="col-md-4">
									<img src="img/superbox/superbox-full-15.jpg" class="img-responsive" alt="img">
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
								<div class="col-md-8 padding-left-0">
									<h3 class="margin-top-0"><a href="javascript:void(0);"> Why Should You Make A Separate Mobile Website for your Business? </a><br><small class="font-xs"><i>Published by <a href="javascript:void(0);">John Doe</a></i></small></h3>
									<p>
										At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. 

										<br><br>Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.
										<br><br>
									</p>
									<a class="btn btn-primary" href="javascript:void(0);"> Read more </a>
									<a class="btn btn-warning" href="javascript:void(0);"> Edit </a>
									<a class="btn btn-success" href="javascript:void(0);"> Publish </a>
								</div>
							</div>
							<hr>

							<div class="row">
								<div class="col-md-4">
									<img src="img/superbox/superbox-full-19.jpg" class="img-responsive" alt="img">
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
								<div class="col-md-8 padding-left-0">
									<h3 class="margin-top-0"><a href="javascript:void(0);"> Mums favorite shopping malls in USA </a><br><small class="font-xs"><i>Published by <a href="javascript:void(0);">John Doe</a></i></small></h3>
									<p>
										At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. 

										<br><br>Et harum quidem rerum facilis est et expedita distinctio lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero consectetur adipiscing elit magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat. Pellentesque viverra vehicula sem ut volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non libero magna. Sed et quam lacus. Fusce condimentum eleifend enim a feugiat.
										<br><br>
									</p>
									<a class="btn btn-primary" href="javascript:void(0);"> Read more </a>
								</div>
							</div>
							<hr>

							<div class="row">
								<div class="col-md-4">
									<img src="img/superbox/superbox-full-24.jpg" class="img-responsive" alt="img">
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
								<div class="col-md-8 padding-left-0">
									<h3 class="margin-top-0"><a href="javascript:void(0);"> Best (and Basic) Practices of Mobile Web Design </a><br><small class="font-xs"><i>Published by <a href="javascript:void(0);">John Doe</a></i></small></h3>
									<p>
										With the plethora of smartphones, mobile phones, and tablets available on the market today, research suggests that mobile devices will soon overtake PCs and laptops in a year. More and more,different platforms are made available for all types of consumers to access the web, even including TVs and gaming consoles. 

										<br><br>

										And all this in rapid-fire turnoverânew models and technologies quickly coming and going like fashion trends. So much so that any website that is not mobile friendly cannot claim to be user-friendly anymore. Increasingly, web developers and designers utilize fluid layouts allowing users to browse across different platforms.

										<br><br>
									</p>
									<a class="btn btn-primary" href="javascript:void(0);"> Read more </a>
								</div>
							</div>

							<hr>

							<div class="row">
								<div class="col-md-4">
									<img src="img/superbox/superbox-full-7.jpg" class="img-responsive" alt="img">
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
								<div class="col-md-8 padding-left-0">
									<h3 class="margin-top-0"><a href="javascript:void(0);"> Responsive Design: Best Practices for Designing a Website </a><br><small class="font-xs"><i>Published by <a href="javascript:void(0);">John Doe</a></i></small></h3>
									<p>
										The term Responsive design means developing a website in a way that adapts all the computer screen resolutions. Particularly this concept allows a 4 column layout that is 1292px wide, on 1025px wide screen that is divided into 2 columns automatically. It is adaptable for android phones and tablet screens. This designing method is known as âresponsive web designâ

										<br><br>
										
										Responsive designing is a different concept from traditional web designing, so the question arises how you should build a good responsive website. Here is a general practices that can help you to build a responsive website design.

										<br><br>
									</p>
									<a class="btn btn-primary" href="javascript:void(0);"> Read more </a>
								</div>
							</div>	

						</div>

					</div>

					<!-- <div class="col-sm-3">
						<div class="well padding-10">
							<h5 class="margin-top-0"><i class="fa fa-search"></i> Blog Search...</h5>
							<div class="input-group">
								<input type="text" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button> </span>
							</div>
							/input-group
						</div>
						/well
						<div class="well padding-10">
							<h5 class="margin-top-0"><i class="fa fa-tags"></i> Popular Tags:</h5>
							<div class="row">
								<div class="col-lg-6">
									<ul class="list-unstyled">
										<li>
											<a href=""><span class="badge badge-info">Windows 8</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">C#</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">Windows Forms</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">WPF</span></a>
										</li>
									</ul>
								</div>
								<div class="col-lg-6">
									<ul class="list-unstyled">
										<li>
											<a href=""><span class="badge badge-info">Bootstrap</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">Joomla!</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">CMS</span></a>
										</li>
										<li>
											<a href=""><span class="badge badge-info">Java</span></a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						/well
						<div class="well padding-10">
							<h5 class="margin-top-0"><i class="fa fa-thumbs-o-up"></i> Follow Us!</h5>
							<ul class="no-padding no-margin">
								<p class="no-margin">
									<a title="Facebook" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-facebook fa-stack-1x"></i></span></a>
									<a title="Twitter" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-twitter fa-stack-1x"></i></span></a>
									<a title="Google+" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-google-plus fa-stack-1x"></i></span></a>
									<a title="Linkedin" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-linkedin fa-stack-1x"></i></span></a>
									<a title="GitHub" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-github fa-stack-1x"></i></span></a>
									<a title="Bitbucket" href=""><span class="fa-stack fa-lg"><i class="fa fa-square-o fa-stack-2x"></i><i class="fa fa-bitbucket fa-stack-1x"></i></span></a>
								</p>
							</ul>
						</div>
						/well
						/well
						<div class="well padding-10">
							<h5 class="margin-top-0"><i class="fa fa-fire"></i> Popular Posts:</h5>
							<ul class="no-padding list-unstyled">
								<li>
									<a href="javascript:void(0);" class="margin-top-0">WPF vs. Windows Forms-Which is better?</a>
								</li>
								<li>
									<a href="javascript:void(0);" class="padding-top-5 display-block">How to create responsive website with Bootstrap?</a>
								</li>
								<li>
									<a href="javascript:void(0);" class="margin-top-5">The best Joomla! templates 2014</a>
								</li>
								<li>
									<a href="javascript:void(0);" class="margin-top-5">ASP .NET cms list</a>
								</li>
								<li>
									<a href="javascript:void(0);" class="margin-top-5">C# Hello, World! program</a>
								</li>
								<li>
									<a href="javascript:void(0);" class="margin-top-5">Java random generator</a>
								</li>
							</ul>
						</div>
						/well

						/well
						<div class="well padding-10">
							<h5 class="margin-top-0"><i class="fa fa-video-camera"></i> Featured Videos:</h5>
							<div class="row">

								<div class="col-lg-12">

									<ul class="list-group no-margin">
										<li class="list-group-item">
											<a href=""> <span class="badge pull-right">15</span> Photograph </a>
										</li>
										<li class="list-group-item">
											<a href=""> <span class="badge pull-right">30</span> Life style </a>
										</li>
										<li class="list-group-item">
											<a href=""> <span class="badge pull-right">9</span> Food </a>
										</li>
										<li class="list-group-item">
											<a href=""> <span class="badge pull-right">4</span> Travel world </a>
										</li>
									</ul>

								</div>

								<div class="col-lg-12">
									<div class="margin-top-10">
										<iframe allowfullscreen="" frameborder="0" height="210" mozallowfullscreen="" src="http://player.vimeo.com/video/87025094" webkitallowfullscreen="" width="100%"></iframe>
									</div>
								</div>
							</div>

						</div>
						/well

					</div> -->

				</div>
					
					
					<!-- Modal -->
				<div class="modal fade" id="myTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">Article Post</h4>
							</div>
							<div class="modal-body">
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Title" required />
										</div>
										<div class="form-group">
											<textarea class="form-control" placeholder="Content" rows="5" required></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="category"> Category</label>
											<select class="form-control" id="category">
												<option>Articles</option>
												<option>Tutorials</option>
												<option>Freebies</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="tags"> Tags</label>
											<input type="text" class="form-control" id="tags" placeholder="Tags" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="well well-sm well-primary">
											<form class="form form-inline " role="form">
												<div class="form-group">
													<input type="text" class="form-control" value="" placeholder="Date" required />
												</div>
												<div class="form-group">
													<select class="form-control">
														<option>Draft</option>
														<option>Published</option>
													</select>
												</div>
												<div class="form-group">
													<button type="submit" class="btn btn-success btn-sm">
														<span class="glyphicon glyphicon-floppy-disk"></span> Save
													</button>
													<button type="button" class="btn btn-default btn-sm">
														<span class="glyphicon glyphicon-eye-open"></span> Preview
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>
				
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Cancel
								</button>
								<button type="button" class="btn btn-primary">
									Post Article
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				
				<!-- Modal -->
				<div class="modal fade" id="myModule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">Article Post</h4>
							</div>
							<div class="modal-body">
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Title" required />
										</div>
										<div class="form-group">
											<textarea class="form-control" placeholder="Content" rows="5" required></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="category"> Category</label>
											<select class="form-control" id="category">
												<option>Articles</option>
												<option>Tutorials</option>
												<option>Freebies</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="tags"> Tags</label>
											<input type="text" class="form-control" id="tags" placeholder="Tags" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="well well-sm well-primary">
											<form class="form form-inline " role="form">
												<div class="form-group">
													<input type="text" class="form-control" value="" placeholder="Date" required />
												</div>
												<div class="form-group">
													<select class="form-control">
														<option>Draft</option>
														<option>Published</option>
													</select>
												</div>
												<div class="form-group">
													<button type="submit" class="btn btn-success btn-sm">
														<span class="glyphicon glyphicon-floppy-disk"></span> Save
													</button>
													<button type="button" class="btn btn-default btn-sm">
														<span class="glyphicon glyphicon-eye-open"></span> Preview
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>
				
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Cancel
								</button>
								<button type="button" class="btn btn-primary">
									Post Article
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->


			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

		<!-- PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<span class="txt-color-white">SmartAdmin 1.8.2 <span class="hidden-xs"> - Web Application Framework</span> Â© 2014-2015</span>
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