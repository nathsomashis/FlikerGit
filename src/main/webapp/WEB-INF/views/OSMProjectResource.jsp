<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.fliker.Repository.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title> OSM Projects </title>
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
				<span id="logo"> <img src="<c:url value='/resources/img/logo.png' />" alt="Fliker"> </span>
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
					<span> <a href="login.html" title="Sign Out" data-action="userLogout" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->

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
			<%
		
			String fullname = (String)request.getAttribute("FullName");
			String gender = (String)request.getAttribute("Gender");
			String imageid = (String)request.getAttribute("ProfileImage");
			String logo = "";
			
			
		
		%>


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
				data-action="toggleShortcut"> <%if(imageid == ""){
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
				class="menu-item-parent">OSM</span></a>
			<ul>
				<li class=""><a href="ideatoimplement?" title="NewPost"><i
						class="fa fa-tags"></i><span class="menu-item-parent">Idea-Implementation</span></a>
				</li>
				<li class=""><a href="osmprojectinfo?" title="NewJob"><i
						class="fa fa-suitcase"></i><span class="menu-item-parent">Project List</span></a>
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
				<li class=""><a href="standardguidance?" title="Academic"><i
						class="fa fa-plus-square"></i><span class="menu-item-parent">Academic</span></a>
				</li>
				<li class=""><a href="professionalguidance?" title="Profesional"><i
						class="fa fa-group"></i><span class="menu-item-parent">Professional</span></a>
				</li>
				<li class=""><a href="gotoguidance?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">GuidanceSheet Test</span></a>
				</li>
				<li class=""><a href="assignmentAnswer?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">Assignment Answer Test</span></a>
				</li>
				<li class=""><a href="projectstructure?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">Project Directory</span></a>
				</li>
				<li class=""><a href="projectviewdetail?" title="Companies"><i
						class="fa fa-group"></i><span class="menu-item-parent">Project View</span></a>
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
			

			<span class="minifyme" data-action="minifyMenu"> 
				<i class="fa fa-arrow-circle-left hit"></i> 
			</span>

		</aside>
		<!-- END NAVIGATION -->

		<!-- MAIN PANEL -->
		<div id="main" role="main">

		<%
			ArrayList projectlist = (ArrayList)request.getAttribute("osmprojectlist");
			
		%>


			<!-- RIBBON -->
			<div id="ribbon">

				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>OSM Projects</li>
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
				
				
				<div class="jarviswidget" id="wid-id-7" data-widget-editbutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
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
									<ul class="nav nav-tabs pull-left in">
				
										<li class="active">
											<a data-toggle="tab" href="#hr1"> <span class="hidden-mobile hidden-tablet">Description</span> </a>
										</li>
										<li>
											<a data-toggle="tab" href="#hr2"> <span class="hidden-mobile hidden-tablet">Data</span> </a>
										</li>
										<li>
											<a data-toggle="tab" href="#hr3"> <span class="hidden-mobile hidden-tablet">Discussion</span> </a>
										</li>
										<li>
											<a data-toggle="tab" href="#hr4"> <span class="hidden-mobile hidden-tablet">TimeLine</span> </a>
										</li>
										<li>
											<a data-toggle="tab" href="#hr5"> <span class="hidden-mobile hidden-tablet">Project</span> </a>
										</li>
				
									</ul>
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
				
										<div class="tab-content">
											<div class="tab-pane active" id="hr1">
												<div class="row">

													<!-- col -->
													<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
														<h1 class="page-title txt-color-blueDark">
															<!-- PAGE HEADER -->
															Status<span>
														</h1>
													</div>
													<!-- end col -->
								
													<!-- right side of the page with the sparkline graphs -->
													<!-- col -->
													<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
														<!-- sparks -->
														<ul id="sparks">
															<li class="sparks-info">
																<h5> My Income <span class="txt-color-blue">$47,171</span></h5>
																<div class="sparkline txt-color-blue hidden-mobile hidden-md hidden-sm">
																	1300, 1877, 2500, 2577, 2000, 2100, 3000, 2700, 3631, 2471, 2700, 3631, 2471
																</div>
															</li>
															<li class="sparks-info">
																<h5> Like <span class="txt-color-purple"><i class="fa fa-thumbs-up" data-rel="bootstrap-tooltip" title="Increased"></i>&nbsp;45</span></h5>
															</li>
															<li class="sparks-info">
																<h5> Share <span class="txt-color-greenDark"><i class="fa fa-share"></i>&nbsp;2447</span></h5>
															</li>
															<li class="sparks-info" >
																<h5> Investors <span class="txt-color-greenDark"><i class="fa fa-barcode" id='investors' ></i>&nbsp;5</span></h5>
															</li>
														</ul>
														<!-- end sparks -->
													</div>
													<!-- end col -->
								
												</div>
												<div class="row">
				
													<div class="col-sm-12 col-md-12 col-lg-12">
														<div class="col-md-10">
															<h1 style="text-align:left;text-transform: uppercase;font-weight: bold;">Project Title</h1>
														</div>
														<div class="col-md-2">
															<!-- <a href="javascript:void(0);" class="btn btn-labeled btn-success" > <span class="btn-label"><i class="glyphicon glyphicon-thumbs-up"></i></span>Invest</a> -->
															<!-- <a href="" id="dialog_link" class="btn btn-primary btn-lg">Request For Developer</a> -->
															<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Request For Developer</button>
														</div>
													</div>
													
													
													<div class="col-sm-12 col-md-12 col-lg-12">
														<h1> Apollo 11</h1>
								
														<p><strong>Apollo 11</strong> was the spaceflight that landed the first humans, Americans <a href="http://en.wikipedia.org/wiki/Neil_Armstrong" title="Neil Armstrong">Neil Armstrong</a> and <a href="http://en.wikipedia.org/wiki/Buzz_Aldrin" title="Buzz Aldrin">Buzz Aldrin</a>, on the Moon on July 20, 1969, at 20:18 UTC. Armstrong became the first to step onto the lunar surface 6 hours later on July 21 at 02:56 UTC.</p>
														
														<p>Armstrong spent about <s>three and a half</s> two and a half hours outside the spacecraft, Aldrin slightly less; and together they collected 47.5 pounds (21.5&nbsp;kg) of lunar material for return to Earth. A third member of the mission, <a href="http://en.wikipedia.org/wiki/Michael_Collins_(astronaut)" title="Michael Collins (astronaut)">Michael Collins</a>, piloted the <a href="http://en.wikipedia.org/wiki/Apollo_Command/Service_Module" title="Apollo Command/Service Module">command</a> spacecraft alone in lunar orbit until Armstrong and Aldrin returned to it for the trip back to Earth.</p>
														
														<h2>Broadcasting and <em>quotes</em> <a id="quotes" name="quotes"></a></h2>
														
														<p>Broadcast on live TV to a world-wide audience, Armstrong stepped onto the lunar surface and described the event as:</p>
														
														<blockquote>
														<p>One small step for [a] man, one giant leap for mankind.</p>
														</blockquote>
														
														<p>Apollo 11 effectively ended the <a href="http://en.wikipedia.org/wiki/Space_Race" title="Space Race">Space Race</a> and fulfilled a national goal proposed in 1961 by the late U.S. President <a href="http://en.wikipedia.org/wiki/John_F._Kennedy" title="John F. Kennedy">John F. Kennedy</a> in a speech before the United States Congress:</p>
														
														<blockquote>
														<p>[...] before this decade is out, of landing a man on the Moon and returning him safely to the Earth.</p>
														</blockquote>
														
														<h2>Technical details <a id="tech-details" name="tech-details"></a></h2>
														
														<table align="right" border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse; margin:10px 0 10px 15px">
															<caption><strong>Mission crew</strong></caption>
															<thead>
																<tr>
																	<th scope="col">Position</th>
																	<th scope="col">Astronaut</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td>Commander</td>
																	<td>Neil A. Armstrong</td>
																</tr>
																<tr>
																	<td>Command Module Pilot</td>
																	<td>Michael Collins</td>
																</tr>
																<tr>
																	<td>Lunar Module Pilot</td>
																	<td>Edwin &quot;Buzz&quot; E. Aldrin, Jr.</td>
																</tr>
															</tbody>
														</table>
														
														<p>Launched by a <strong>Saturn V</strong> rocket from <a href="http://en.wikipedia.org/wiki/Kennedy_Space_Center" title="Kennedy Space Center">Kennedy Space Center</a> in Merritt Island, Florida on July 16, Apollo 11 was the fifth manned mission of <a href="http://en.wikipedia.org/wiki/NASA" title="NASA">NASA</a>&#39;s Apollo program. The Apollo spacecraft had three parts:</p>
														
														<ol>
															<li><strong>Command Module</strong> with a cabin for the three astronauts which was the only part which landed back on Earth</li>
															<li><strong>Service Module</strong> which supported the Command Module with propulsion, electrical power, oxygen and water</li>
															<li><strong>Lunar Module</strong> for landing on the Moon.</li>
														</ol>
														
														<p>After being sent to the Moon by the Saturn V&#39;s upper stage, the astronauts separated the spacecraft from it and travelled for three days until they entered into lunar orbit. Armstrong and Aldrin then moved into the Lunar Module and landed in the <a href="http://en.wikipedia.org/wiki/Mare_Tranquillitatis" title="Mare Tranquillitatis">Sea of Tranquility</a>. They stayed a total of about 21 and a half hours on the lunar surface. After lifting off in the upper part of the Lunar Module and rejoining Collins in the Command Module, they returned to Earth and landed in the <a href="http://en.wikipedia.org/wiki/Pacific_Ocean" title="Pacific Ocean">Pacific Ocean</a> on July 24.</p>
														
														<hr />
														<p style="text-align:right"><small>Source: <a href="http://en.wikipedia.org/wiki/Apollo_11">Wikipedia.org</a></small></p>
								
								
													</div>
													<hr>
													
												
												</div>
												
				
											</div>
											<div class="tab-pane" id="hr2">
											
												<div class="row">
				
													<div class="col-sm-12 col-md-12 col-lg-12">
														
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
																			<a href="imageDownload/d00a59d99412ef193b81a569c65674934b38f6bd1468208234291"> Download</a>  | <a href="javascript:void(0);"> View</a>
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
												</div>
												
												
				
											</div>
											<div class="tab-pane" id="hr3">
												<div class="row">
				
													<div class="col-sm-12">
												
														<div class="well">
												
															<table class="table table-striped table-forum">
																<thead>
																	<tr>
																		<th colspan="2"><a href="forum.html"> Projects </a> > Business Requirement Docs</th>
																		<th class="text-center hidden-xs hidden-sm" style="width: 100px;">Topics</th>
																		<th class="text-center hidden-xs hidden-sm" style="width: 100px;">Posts</th>
																		<th class="hidden-xs hidden-sm" style="width: 200px;">Last Post</th>
																	</tr>
																</thead>
																<tbody>
																	
																	<!-- TR -->
																	<tr class="warning">
																		<td class="text-center" style="width: 40px;"><i class="glyphicon glyphicon-pushpin fa-2x text-danger"></i></td>
																		<td>
																			<h4><a href="forum-post.html">
																				Welcome message
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
																	
																	<!-- TR -->
																	<tr class="warning">
																		<td class="text-center" style="width: 40px;"><i class="glyphicon glyphicon-pushpin fa-2x text-danger"></i></td>
																		<td>
																			<h4><a href="forum-post.html">
																				Latest Updates
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
																	
																	<!-- TR -->
																	<tr>
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				Nam quam nunc blandit vel
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
																	
																	<!-- TR -->
																	<tr>
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				Maecenas nec odio et ante tincidun
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
												
																	<!-- TR -->
																	<tr>
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				Donec sodales sagittis magna
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
												
																	<!-- TR -->
																	<tr>
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				Sed consequat, leo eget bibendum sodales
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
												
																	<!-- TR -->
																	<tr>
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				Consectetuer adipiscing elit
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
												
																	<!-- TR -->
																	<tr class="locked">
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				This is a locked topic!
																			</a>
																				<small><a href="profile.html">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->
												
																	<!-- TR -->
																	<tr class="closed">
																		<td colspan="2">
																			<h4><a href="forum-post.html">
																				This is a closed topic!
																			</a>
																				<small><a href="javascript:void(0);">John Doe</a> on <em>January 1, 2014</em></small>
																			</h4>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">431</a>
																		</td>
																		<td class="text-center hidden-xs hidden-sm">
																			<a href="javascript:void(0);">1342</a>
																		</td>
																		<td class="hidden-xs hidden-sm">by 
																			<a href="javascript:void(0);">John Doe</a>
																			<br>
																			<small><i>January 1, 2014</i></small>
																		</td>
																	</tr>
																	<!-- end TR -->									
																	
																</tbody>
															</table>
												
															<div class="text-center">
												                <ul class="pagination pagination-sm">
												                    <li class="disabled"><a href="javascript:void(0);">Prev</a></li>
												                    <li class="active"><a href="javascript:void(0);">1</a></li>
												                    <li><a href="javascript:void(0);">2</a></li>
												                    <li><a href="javascript:void(0);">3</a></li>
												                    <li><a href="javascript:void(0);">...</a></li>
												                    <li><a href="javascript:void(0);">99</a></li>
												                    <li><a href="javascript:void(0);">Next</a></li>
												                </ul>
												            </div>
												
														</div>
													</div>
												
												</div>
											</div>
											<div class="tab-pane" id="hr4">
												<div class="row">
				
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												
														<div class="well well-sm">
															<!-- Timeline Content -->
															<div class="smart-timeline">
																<ul class="smart-timeline-list">
																	<li>
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
																	</li>
																	<li>
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
																	</li>
																	<li class="text-center">
																		<a href="javascript:void(0)" class="btn btn-sm btn-default"><i class="fa fa-arrow-down text-muted"></i> LOAD MORE</a>
																	</li>
																</ul>
															</div>
															<!-- END Timeline Content -->
												
														</div>
												
													</div>
												
												</div>
											</div>
										</div>
				
									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">Requested Resource</h4>
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
			
			function gotoCompany(osmmodelid){
				
				$.ajax({
					url : "osmcompanyidentify/osmmodelid="+osmmodelid,
					method : 'GET',
					success : function(){
							
						
					}
				});
				
			}
		
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