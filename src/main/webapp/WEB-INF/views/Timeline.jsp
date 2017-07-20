<%@page import="com.fliker.Utility.DateFunctionality"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.fliker.*,java.time.format.DateTimeFormatter,java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
		
		<%
		
			String fullname = (String)request.getAttribute("FullName");
			String gender = (String)request.getAttribute("Gender");
			String userid = (String)request.getAttribute("userid");
			String imagid = (String)request.getAttribute("ProfileImage");
			String logo = "";
			
			
		
		%>

		<title><%=fullname%> Timeline </title>
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
	
	<!-- #BODY -->
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
							<input type="radio" name="activity" id="offlinechatmessages?">
							Msgs  </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="notifications?">
							notify  </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="tasklists?">
							Tasks</label>
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
					data-toggle="dropdown"><img src="/Fliker/imageFromUserid/<%=userid%>" alt="<%=fullname%>" class="online">
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
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->
				
				<div id="article" class="btn-header transparent pull-right">
					<span> <a href="createpost?" title="Article">Article</a>
					</span>
				</div>
				
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

		<!-- User info -->

		<%
		/* if(imageid == ""){
			if(gender.equalsIgnoreCase("female")){
				logo = "\""+"<c:url value='/resources/img/avatars/female.png' />"+"\"";
			}else{
				logo = "\""+"<c:url value='/resources/img/avatars/male.png' />"+"\"";
			}
		}else{
			
		} */
		
		
		%>
		<div class="login-info">
			<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

				<a href="javascript:void(0);" id="show-shortcut"
				data-action="toggleShortcut"> <%if(imagid == ""){
					if(gender.equalsIgnoreCase("female")){
						%> <img src="<c:url value='/resources/img/avatars/female.png' />"
					alt="me" class="online" /> <%
					}else{
						%> <img src="<c:url value='/resources/img/avatars/male.png' />"
					alt="me" class="online" /> <% 
					}
				}else{%> <img src=<%=logo%> alt="me" class="online" /> <%} %> <span><%=fullname%>
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
					<li>Timeline</li>
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
				
				<!-- end row -->
				
				<!-- row -->
				<div class="row">
				
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
						<div class="well well-sm">
							<!-- Timeline Content -->
							<div class="smart-timeline">
								<ul class="smart-timeline-list">
									<%
										ArrayList timelines = (ArrayList)request.getAttribute("timelines");
										if(!timelines.isEmpty()){
										for(int m=0;m<timelines.size();m++){
											
											String timelineid="";
											String logEntry = "";
											String event ="";
											String timelineentrytype="";
											String timelinedescription="";
											String timelineimageid="";
											String timelinelink="";
											String timelinedate="";
											String timelinelocation = "";
											String time="";
											String logon1= "";
											String logon2="";
											
											HashMap timelinemap = (HashMap)timelines.get(m);
											Set timelineset = timelinemap.entrySet();
											Iterator timeit = timelineset.iterator();
											while (timeit.hasNext()) {
												Map.Entry perme = (Map.Entry) timeit.next();
												String keyvalue = (String) perme.getKey();
												System.out.println(perme.getValue());
												if (keyvalue.equalsIgnoreCase("timelineid")) {
													timelineid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("logEntry")) {
													logEntry = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("event")) {
													event = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelineentrytype")) {
													timelineentrytype = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelinedescription")) {
													timelinedescription = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelineimageid")) {
													timelineimageid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelinelink")) {
													timelinelink = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelinedate")) {
													timelinedate = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("timelinelocation")) {
													timelinelocation = (String)perme.getValue();
												}
												DateFunctionality datefun = new DateFunctionality();
												DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
												LocalDateTime now = LocalDateTime.now();
												System.out.println(dtf.format(now));
												
												String currentdate = dtf.format(now);
												
												time = datefun.getDateDiffference(timelinedate, currentdate);
												String[] logEn = logEntry.split("::");
												logon1 = "["+logEn[0]+"]";
												logon2 = "["+logEn[1]+"]";
												 
												
											}
											
											if(timelineentrytype.equalsIgnoreCase("Note")){
												
												%>
													<li>
														<div class="smart-timeline-icon">
															<img src="<c:url value='/resources/img/avatars/n_blue.png' />" width="32" height="32" alt="user" />
														</div>
														<div class="smart-timeline-time">
															<%if(time!=null){ %>
															<small><%=time%></small>
															<%} %>
														</div>
														<div class="smart-timeline-content">
															<p>
																<a href="javascript:void(0);"><strong>Note:<%=event%></strong></a>
															</p>
															<p>
																<%=timelinedescription%>
															</p>
															<p>
																<a href="javascript:void(0);" class="btn btn-xs btn-primary"><i class="fa fa-file"></i> Read the post</a>
															</p>
															<img src="img/superbox/superbox-thumb-4.jpg" alt="img" width="150">
														</div>
													</li>
												
												<%
												
											}else if(timelineentrytype.equalsIgnoreCase("Course")){
												%>
													<li>
														<div class="smart-timeline-icon bg-color-greenDark">
															<img src="<c:url value='/resources/img/avatars/c_red.png' />" width="32" height="32" alt="user" />
														</div>
														<div class="smart-timeline-time">
															<%if(time!=null){ %>
															<small><%=time%></small>
															<%} %>
														</div>
														<div class="smart-timeline-content">
															<p>
																<strong class="txt-color-greenDark">Course :<%=event%></strong>
															</p>
															<p>
																<a href="javascript:void(0);"><strong><%=timelinelink%></strong></a>
															</p>
															<p>
																<%=timelinedescription%>
															</p>
															<div class="sparkline" 
															data-sparkline-type="compositeline" 
															data-sparkline-spotradius-top="5" 
															data-sparkline-color-top="#3a6965" 
															data-sparkline-line-width-top="3" 
															data-sparkline-color-bottom="#2b5c59" 
															data-sparkline-spot-color="#2b5c59" 
															data-sparkline-minspot-color-top="#97bfbf" 
															data-sparkline-maxspot-color-top="#c2cccc" 
															data-sparkline-highlightline-color-top="#cce8e4" 
															data-sparkline-highlightspot-color-top="#9dbdb9" 
															data-sparkline-width="170px" 
															data-sparkline-height="40px" 
															data-sparkline-line-val="<%=logon1%>" 
															data-sparkline-bar-val="<%=logon2%>"></div>
															
															<br>
														</div>
													</li>
												<%
											}else if(timelineentrytype.equalsIgnoreCase("Project")){
												
												%>
												<li>
													<div class="smart-timeline-icon bg-color-greenDark">
														<img src="<c:url value='/resources/img/avatars/c_red.png' />" width="32" height="32" alt="user" />
													</div>
													<div class="smart-timeline-time">
														<%if(time!=null){ %>
														<small><%=time%></small>
														<%} %>
													</div>
													<div class="smart-timeline-content">
														<p>
															<strong class="txt-color-greenDark">Project :<%=event%></strong>
														</p>
														<p>
															<a href="javascript:void(0);"><strong><%=timelinelink%></strong></a>
														</p>
														<p>
															<%=timelinedescription%>
														</p>
														<div class="sparkline" 
														data-sparkline-type="compositeline" 
														data-sparkline-spotradius-top="5" 
														data-sparkline-color-top="#3a6965" 
														data-sparkline-line-width-top="3" 
														data-sparkline-color-bottom="#2b5c59" 
														data-sparkline-spot-color="#2b5c59" 
														data-sparkline-minspot-color-top="#97bfbf" 
														data-sparkline-maxspot-color-top="#c2cccc" 
														data-sparkline-highlightline-color-top="#cce8e4" 
														data-sparkline-highlightspot-color-top="#9dbdb9" 
														data-sparkline-width="170px" 
														data-sparkline-height="40px" 
														data-sparkline-line-val="<%=logon1%>" 
														data-sparkline-bar-val="<%=logon2%>"></div>
														
														<br>
													</div>
												</li>
											<%
												
											}else if(timelineentrytype.equalsIgnoreCase("Classroom")){
												
											}else if(timelineentrytype.equalsIgnoreCase("AcademicGuidance")){
												
											}else if(timelineentrytype.equalsIgnoreCase("ProfessionalGuidance")){
												
											}else if(timelineentrytype.equalsIgnoreCase("IdeaWork")){

											}else if(timelineentrytype.equalsIgnoreCase("Work")){
												
											}else if(timelineentrytype.equalsIgnoreCase("Achievement")){
												
											}
												
										}
										
										}
										
									
									
									%>
								
								
									<!-- <li>
										<div class="smart-timeline-icon">
											<img src="img/avatars/sunny.png" width="32" height="32" alt="user" />
										</div>
										<div class="smart-timeline-time">
											<small>just now</small>
										</div>
										<div class="smart-timeline-content">
											<p>
												<a href="javascript:void(0);"><strong>Trip to Adalaskar</strong></a>
											</p>
											<p>
												Check out my tour to Adalaskar
											</p>
											<p>
												<a href="javascript:void(0);" class="btn btn-xs btn-primary"><i class="fa fa-file"></i> Read the post</a>
											</p>
											<img src="img/superbox/superbox-thumb-4.jpg" alt="img" width="150">
				
													
												
										</div>
									</li>
									<li>
										<div class="smart-timeline-icon">
											<i class="fa fa-file-text"></i>
										</div>
										<div class="smart-timeline-time">
											<small>1 min ago</small>
										</div>
										<div class="smart-timeline-content">
											<p>
												<strong>Meeting invite for "GENERAL GNU" [<a href="javascript:void(0);"><i>Go to my calendar</i></a>]</strong>
											</p>
											
											<div class="well well-sm display-inline">
												<p>Will you be able to attend the meeting - <strong> 10:00 am</strong> tomorrow?</p>
												<button class="btn btn-xs btn-default">Confirm Attendance</button>
											</div>		
														
										</div>
									</li>
									<li>
										<div class="smart-timeline-icon bg-color-greenDark">
											<i class="fa fa-bar-chart-o"></i>
										</div>
										<div class="smart-timeline-time">
											<small>5 hrs ago</small>
										</div>
										<div class="smart-timeline-content">
											<p>
												<strong class="txt-color-greenDark">24hrs User Feed</strong>
											</p>
											
											<div class="sparkline" 
											data-sparkline-type="compositeline" 
											data-sparkline-spotradius-top="5" 
											data-sparkline-color-top="#3a6965" 
											data-sparkline-line-width-top="3" 
											data-sparkline-color-bottom="#2b5c59" 
											data-sparkline-spot-color="#2b5c59" 
											data-sparkline-minspot-color-top="#97bfbf" 
											data-sparkline-maxspot-color-top="#c2cccc" 
											data-sparkline-highlightline-color-top="#cce8e4" 
											data-sparkline-highlightspot-color-top="#9dbdb9" 
											data-sparkline-width="170px" 
											data-sparkline-height="40px" 
											data-sparkline-line-val="[6,4,7,8,4,3,2,2,5,6,7,4,1,5,7,9,9,8,7,6]" 
											data-sparkline-bar-val="[4,1,5,7,9,9,8,7,6,6,4,7,8,4,3,2,2,5,6,7]"></div>
											
											<br>
										</div>
									</li> -->
									<!-- <li>
										<div class="smart-timeline-icon">
											<i class="fa fa-user"></i>
										</div>
										<div class="smart-timeline-time">
											<small>yesterday</small>
										</div>
										<div class="smart-timeline-content">
											<p>
												<a href="javascript:void(0);"><strong>Update user information</strong></a>
											</p>
											<p>
												Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus.
											</p>
											
											Tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit
											
											<ul class="list-inline">
												<li>
													<img src="img/superbox/superbox-thumb-6.jpg" alt="img" width="50">
												</li>
												<li>
													<img src="img/superbox/superbox-thumb-5.jpg" alt="img" width="50">
												</li>
												<li>
													<img src="img/superbox/superbox-thumb-7.jpg" alt="img" width="50">
												</li>
											</ul>
										</div>
									</li>
									<li>
										<div class="smart-timeline-icon">
											<i class="fa fa-pencil"></i>
										</div>
										<div class="smart-timeline-time">
											<small>12 Mar, 2013</small>
										</div>
										<div class="smart-timeline-content">
											<p>
												<a href="javascript:void(0);"><strong>Nabi Resource Report</strong></a>
											</p>
											<p>
												Ean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis.
											</p>
											<a href="javascript:void(0);" class="btn btn-xs btn-default">Read more</a>
										</div>
									</li> -->
									<li class="text-center">
										<a href="javascript:void(0)" class="btn btn-sm btn-default"><i class="fa fa-arrow-down text-muted"></i> LOAD MORE</a>
									</li>
								</ul>
							</div>
							<!-- END Timeline Content -->
				
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
				</div>

				<div class="col-xs-6 col-sm-6 text-right hidden-xs">
					<div class="txt-color-white inline-block">
						
						
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

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
		
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