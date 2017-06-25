<%@page import="com.fliker.Modal.ProfilePreview"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.fliker.Repository.*,com.mongodb.BasicDBList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Guidance</title>
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
					<li><a href="logout?" 
						class="padding-10 padding-top-5 padding-bottom-5"
						data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>
							<strong><u>L</u>ogout</strong></a></li>
				</ul></li>
		</ul>

		<!-- logout button -->
		<div id="logout" class="btn-header transparent pull-right">
			<span> <a href="logout?"  title="Sign Out"
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
					<input id="search-fld"  type="text" name="param" placeholder="Find reports and more" >
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
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

		

	</div>
	<!-- end pulled right: nav area --> </header>
	<!-- END HEADER -->

	<!-- #NAVIGATION -->
	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->
	<aside id="left-panel"> <!-- User info -->
	<!-- User info -->
			<%
		
			String fullname = (String)request.getAttribute("FullName");
			String gender = (String)request.getAttribute("Gender");
			String imagid = (String)request.getAttribute("ProfileImage");
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
	<!-- end user info --> <nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
		<li class=""><a href="search?"><i
				class="fa fa-lg fa-fw fa-search-plus"></i> <span
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
		
		<li class="active"><a href="#" title="Organizations"><i
						class="fa fa-group"></i><span class="menu-item-parent">Guidance</span></a>
				<ul>
				<li class="active"><a href="standardguidance?" title="NewJob"><i
						class="fa fa-plus-square txt-color-blue"></i><span class="menu-item-parent">Academic</span></a>
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
				<li>Guidance</li>
			</ol>

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">

			<!-- row -->
			
			<div class="row">
					
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-12">
						
						<div class="col-sm-2"><button class="btn btn-primary" data-toggle="modal" data-target="#guidance">Provide New Guidance</button></div>
						<div class="col-sm-2"><button class="btn btn-primary" data-toggle="modal" data-target="#needguidance">Need Guidance</button></div>
					</div>

				</div>
			<div class="row">

				<div class="col-sm-12">

					
							<div class="row">

								<div class="col-sm-12">

									<div class="well padding-10">
										<%
										Set<Currency> currencies = (Set<Currency>)request.getAttribute("currencyset");
										ArrayList ongoingResources = (ArrayList)request.getAttribute("ongoingResources");
										int ongoingResourcessize = ongoingResources.size();
										System.out.println(ongoingResourcessize);
										if(ongoingResources!=null){
										for(int m=0;m<ongoingResources.size();m++){
											
											String guidanceid="";
											String guidancesubject="";
											String profileimage="";
											String profilename="";
											String guidancelocation="";
											String guidanceduration= "";
											String profileid = "";
											String guidancereason="";
											String guidancetype="";
											String nextmeeting="";
											String topiccount = "";
											String timetableid="";
											String providerprofileid="";
											String providerprofileimage="";
											String providername="";
											String provideruserid="";
											String likeid="";
											String shareid="";
											String consumernumber = "";
											System.out.println("fghdfdf");
											StringBuffer consumerlisset = new StringBuffer();
											
											BasicDBList consumerlist = new BasicDBList();
											
											
											HashMap guidancemap = (HashMap)ongoingResources.get(m);
											Set perset = guidancemap.entrySet();
											Iterator perit = perset.iterator();
											System.out.println("fghdfdf1");
											while (perit.hasNext()) {
												Map.Entry perme = (Map.Entry) perit.next();
												String keyvalue = (String) perme.getKey();
												if (keyvalue.equalsIgnoreCase("guidanceduration")) {
													guidanceduration = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("guidancelocation")) {
													guidancelocation = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("guidancereason")) {
													guidancereason = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("guidancesubject")) {
													guidancesubject = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("guidancetype")) {
													guidancetype = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("consumerids")) {
													consumerlist = (BasicDBList)perme.getValue();
													consumernumber = Integer.toString(consumerlist.size());
													
													for(int t=0;t<consumerlist.size();t++){
														
														ProfilePreview profprev = new ProfilePreview();
														Profile profileinfo = profprev.getProfileData((String)consumerlist.get(t));
														String consumerprofile = profileinfo.getProfileid();
														String consumerprofileimage=profileinfo.getProfileImageid();
														String consumername=profileinfo.getName();
														String consumeruserid=profileinfo.getUserid();
														
														
														String composeconsumer = "<li><a href='#'><img src='/Fliker/imageFromUserid/"+consumeruserid+"' alt='"+consumername+"'></a></li>";
														consumerlisset.append(composeconsumer);
														System.out.println(consumerlisset.toString());
													}
													
												}else if (keyvalue.equalsIgnoreCase("guidanceid")) {
													guidanceid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("providerprofileid")) {
													providerprofileid = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("providerprofileimage")) {
													providerprofileimage = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("providername")) {
													providername = (String)perme.getValue();
												}else if (keyvalue.equalsIgnoreCase("provideruserid")) {
													provideruserid = (String)perme.getValue();
												}
												
											}
											
											%>
											
												<div class="row">
													<div class="col-sm-12 col-md-12 col-lg-12">
														<div class="row" style="border: 1px black">
															<div class="col-xs-12 col-sm-7 col-md-7 col-lg-2">
																<h1 class="page-title txt-color-blueDark">
																	<!-- PAGE HEADER -->
																	<%=guidancesubject%><span>
																</h1>
															</div>
															<!-- col -->
															<div class="col-xs-12 col-sm-5 col-md-5 col-lg-10">
																<!-- sparks -->
																<ul id="sparks">
																	<li class="sparks-info" >
																		<h5> Duration <span class="txt-color-greenDark">&nbsp;<%=guidanceduration%></span></h5>
																	</li>
																	<li class="sparks-info" >
																		<h5> Location <span class="txt-color-greenDark">&nbsp;<img src="https://maps.googleapis.com/maps/api/staticmap?center="<%=guidancelocation%>"&zoom=14&size=100x100&key='AIzaSyDuATgAn9J88smIpYM1SD_3RFAiA-PF4q4'" alt="<%=guidancelocation%>"></span></h5>
																	</li>
																	<li class="sparks-info" >
																		<h5> Resources <span class="txt-color-greenDark"><i class="fa fa-group" id='investors' ></i>&nbsp;<%=consumernumber%></span></h5>
																	</li>
																</ul>
																<!-- end sparks -->
															</div>
															<!-- end col -->
										
														</div>
														<div class="row">
														<div class="col-md-12 padding-left-0">	
															<h3 class="margin-top-0"><a href="javascript:void(0);"><%=guidancereason%></a><br><small class="font-xs"><i>Published by <a href="javascript:void(0);"><%=providername %></a></i></small></h3>
															<i><a href="javascript:void(0);"><%=guidancetype%></a></i>
															<p>
																<div class="col-sm-3">
																	<h1><small>Connections</small></h1>
																	<ul class="list-inline friends-list">
																		<%=consumerlisset.toString()%>
																	</ul>
																</div>	
															</p>
															<a href="#" onclick="gotoguidance('<%=guidanceid%>')" class="btn btn-default btn-xs">Go to guidance</a>
														</div>	
														</div>
													</div>
												
												</div>
												<hr>
											<%
										}
										
										}
										
										
										%>
									</div>

								</div>



							</div>
							<div class="row">

								<div class="col-sm-12">

									<div class="well padding-10">
										<%
										ArrayList guidanceconsumesubjectmap = (ArrayList)request.getAttribute("guidanceconsumesubjectmap");
										if(guidanceconsumesubjectmap!= null){
										for(int m=0;m<guidanceconsumesubjectmap.size();m++){
											
											HashMap guidacedata = (HashMap)guidanceconsumesubjectmap.get(m);
											String guidanceconsumereason = "";
											String guidanceconsumelocation = "";
											String guidanceconsumeduration="";
											String guidanceproviderprofile = "";
											String guidanceprovideruserid = "";
											String guidanceconsumesubject = "";
											String guidanceproviderprofilename="";
											String guidanceid = "";
											
											Set guidacedataset = guidacedata.entrySet();
											Iterator guidacedatasetit = guidacedataset.iterator();
											while(guidacedatasetit.hasNext()){
												Map.Entry guidedatame = (Map.Entry)guidacedatasetit.next();
												String guiddatavalue = (String) guidedatame.getKey();
												if (guiddatavalue.equalsIgnoreCase("guidancereason")) {
													guidanceconsumereason = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidancelocation")) {
													guidanceconsumelocation = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceid")) {
													guidanceid = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceduration")) {
													guidanceconsumeduration = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceuserid")) {
													guidanceprovideruserid = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceprofileid")) {
													guidanceproviderprofile = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidancesubject")) {
													guidanceconsumesubject = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceprofilename")) {
													guidanceproviderprofilename = (String)guidedatame.getValue();
												}
												
											}
											
											%>
											<div class="row">
											<div class="search-results clearfix">
												<h4><%=guidanceconsumesubject%>- <%=guidanceconsumereason%>&nbsp;&nbsp;</h4>
												<img src="/Fliker/imageFromUserid/<%=guidanceprovideruserid%>" alt="">
												<div>
													<p class="note">
														<a href="#" class="text-danger"><i class="fa fa-thumbs-up"></i> Like&nbsp;&nbsp;</a>
														<a href="#"><i class="fa fa-chain"></i> Share this link&nbsp;&nbsp;</a>
														<a href="#"><i class="fa fa-star txt-color-yellow"></i> Favorite&nbsp;&nbsp;</a>
													</p>
													<div class="url text-success">
														smartadmin/index.html?#ajax/gallery.html <i class="fa fa-caret-down"></i>
													</div>
													<p class="description">
														<%=guidanceconsumeduration%> - Published by <%=guidanceproviderprofilename%>
														<br>
														<br>
														<a href="#" onclick="pagingConsumer('<%=guidanceid%>')" class="btn btn-default btn-xs">Page</a>
													</p>
												</div>
							
											</div>	
											</div>
										<% 	
											
										}
										
									}
										%>
									</div>

								</div>



							</div>
							<%-- <div class="row">

								<div class="col-sm-12">

									<div class="well padding-10">
										<%
										HashMap guidanceprovidingsubjectmap = (HashMap)request.getAttribute("guidanceprovidingsubjectmap");
										Set guidanceprovidingsubjectset = guidanceprovidingsubjectmap.entrySet();
										Iterator guidanceprovidingsubjectit = guidanceprovidingsubjectset.iterator();
										while(guidanceprovidingsubjectit.hasNext()){
											Map.Entry guidanceprovidingsubjectme = (Map.Entry)guidanceprovidingsubjectit.next();
											
											String guidanceid = (String)guidanceprovidingsubjectme.getKey();
											HashMap guidacedata = (HashMap)guidanceprovidingsubjectme.getValue();
											String guidanceconsumereason = "";
											String guidanceconsumelocation = "";
											String guidanceconsumeduration="";
											ArrayList guidanceproviderprofile = new ArrayList();
											String guidanceprovideruserid = "";
											String guidanceconsumesubject = "";
											String guidanceproviderprofilename="";
											String guidanceproviderlist = "";
											StringBuffer providerlisset = new StringBuffer();
											
											Set guidacedataset = guidacedata.entrySet();
											Iterator guidacedatasetit = guidacedataset.iterator();
											while(guidacedatasetit.hasNext()){
												Map.Entry guidedatame = (Map.Entry)guidacedatasetit.next();
												String guiddatavalue = (String) guidedatame.getKey();
												if (guiddatavalue.equalsIgnoreCase("guidancereason")) {
													guidanceconsumereason = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidancelocation")) {
													guidanceconsumelocation = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceduration")) {
													guidanceconsumeduration = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidanceuserid")) {
													guidanceprovideruserid = (String)guidedatame.getValue();
												}else if (guiddatavalue.equalsIgnoreCase("guidancepresent")) {
													guidanceproviderprofile = (ArrayList)guidedatame.getValue();
													
													for(int f=0;f<guidanceproviderprofile.size();f++){
														String composeprovider = "<li><a href='#'><img src='/Fliker/imageFromUserid/"+guidanceproviderprofile.get(f)+"' alt=''></a></li>";
														providerlisset.append(composeprovider);
													}
													
												}
												
											}
											
											%>
											<div class="row">
											<div class="search-results clearfix">
												<h4><%=guidanceconsumesubject%>- <%=guidanceconsumereason%>&nbsp;&nbsp;</h4>
												<img src="/Fliker/imageFromUserid/<%=guidanceprovideruserid%>" alt="">
												<div>
													<p class="note">
														<a href="#" class="text-danger"><i class="fa fa-thumbs-up"></i> Like&nbsp;&nbsp;</a>
														<a href="#"><i class="fa fa-chain"></i> Share this link&nbsp;&nbsp;</a>
														<a href="#"><i class="fa fa-star txt-color-yellow"></i> Favorite&nbsp;&nbsp;</a>
													</p>
													<div class="url text-success">
														smartadmin/index.html?#ajax/gallery.html <i class="fa fa-caret-down"></i>
													</div>
													<p class="description">
														<%=guidanceconsumeduration%> - Published by <%=guidanceproviderprofilename%>
														<p>
																<div class="col-sm-3">
																	<h1><small>providers</small></h1>
																	<ul class="list-inline friends-list">
																		<%=providerlisset.toString()%>
																	</ul>
																</div>	
															</p>
														<a href="#" onclick="gotoGuidanceView('<%=guidanceid%>')" class="btn btn-default btn-xs">Go to guidance</a>
													</p>
												</div>
							
											</div>	
											</div>
										<% 	
											
										}
										%>
									</div>

								</div>



							</div> --%>
						<!-- </div> -->

						<!-- <div class="tab-pane fade" id="s3">
							MAIN CONTENT
								
							END MAIN CONTENT

						</div> -->

				</div>

			</div>

			<!-- end row -->

		</div>
		<!-- END MAIN CONTENT -->
		<div class="modal fade" id="guidance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">Provide Guidance</h4>
							</div>
							<div class="modal-body">
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Guidance Subject" required id="guidancesubject" />
										</div>
										<div class="form-group">
											<textarea id="guidancereason" class="form-control" placeholder="Provide Information about your guidance. Why you are good on the above mentioned guidance.." rows="5" required></textarea>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<input type="text" class="form-control" placeholder="Guidance Price" required id="guidanceprice" />
											</div>
											<div class="col-md-3">
												<select class="form-control" id="guidancepricecurr">
													<%
														for (Currency s : currencies) {
														    %>
														    	<option><%=s.getCurrencyCode()%></option>
															<%
														}
													%>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<input type="text" class="form-control" value="" placeholder="Duration if any leave it blank" id="duration" />
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="durationtype">Duration Type</label>
											<select class="form-control" id="durationtypeid">
												<option>Month</option>
												<option>Day</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="guidancetype">Guidance Type</label>
											<select class="form-control" id="guidancetypeid">
												<option>Acedamic</option>
												<option>Professional</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Location" required id="location"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="publish">Publish</label>
											<select class="form-control" id="published">
												<option>All</option>
												<option>Friends</option>
											</select>
										</div>
									</div>
								</div>
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Cancel
								</button>
								<a href="#" id="createguidance" class="btn btn-primary"> <i class="fa fa-warning"></i>Create</a>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				
				<div class="modal fade" id="needguidance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">Need Guidance</h4>
							</div>
							<div class="modal-body">
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Guidance Subject" required id="guidancesubjectneed" />
										</div>
										<div class="form-group">
											<textarea id="guidancereasonneed" class="form-control" placeholder="Practically what you missing? from the above mentioned subject.." rows="5" required></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<input type="text" class="form-control" value="" placeholder="Duration if any leave it blank" id="durationneed" />
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="durationtypeneed">Duration Type</label>
											<select class="form-control" id="durationtypeidneed">
												<option>Month</option>
												<option>Day</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="guidancetypeneed">Guidance Type</label>
											<select class="form-control" id="guidancetypeidneed">
												<option>Acedamic</option>
												<option>Professional</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Any Location Specific" required id="locationneed"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="publishneed">Publish</label>
											<select class="form-control" id="publishedneed">
												<option>All</option>
												<option>Friends</option>
											</select>
										</div>
									</div>
								</div>
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Cancel
								</button>
								<a href="#" id="needguidanceto" class="btn btn-primary"></i>Create</a>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
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
		
		 <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>


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
			 
			 $('#createguidance').click(function() {
				 
				 var guidancesubject = $('#guidancesubject').val();
				 var guidancereason = $('#guidancereason').val();
				 var duration = $('#duration').val()+$('#durationtypeid').val();
				 var location = $('#location').val();
				 var published = $('#published').val();
				 var guidancetype = $('#guidancetypeid').val();
				 var guidanceprice = $('#guidanceprice').val();
				 var currencyprice = $('#guidancepricecurr option:selected').text();
				 /* var coordinate = "";
				 
				 var geocoder =  new google.maps.Geocoder();
				 geocoder.geocode( { 'address': location}, function(results, status) {
				 if (status == google.maps.GeocoderStatus.OK) {
					 coordinate = results[0].geometry.location.lat() + "," +results[0].geometry.location.lng(); 
				     alert(coordinate);
				     alert("result ::"+results[0].geometry.location.lat() + "," +results[0].geometry.location.lng())
				 }
				 }); */
				 
				 
				 
				 $.ajax({
						url : "provideguidance?guidanceSubject="+guidancesubject+"&guidancereason="+guidancereason+"&location="+location+"&published="+published+"&duration="+duration+"&guidencetype="+guidancetype+"&guidanceprice="+guidanceprice+"&currency="+currencyprice,
						method : 'POST',
						success : function(data){
							if(data.success == "true"){ 
								
								$('#guidance').modal('hide');
								
								// if true (1)
							     /*  setTimeout(function(){// wait for 5 secs(2)
							           location.reload(); // then reload the page.(3)
							      }, 5000);  */
							   }
							
						}
					
			        }); 
				 
			 });
			 
			$('#needguidanceto').click(function() {
				 
				 var guidancesubject = $('#guidancesubjectneed').val();
				 var guidancereason = $('#guidancereasonneed').val();
				 var duration = $('#durationneed').val()+$('#durationtypeidneed').val();
				 var location = $('#locationneed').val();
				 var published = $('#publishedneed').val();
				 var guidancetype = $('#guidancetypeidneed').val();
				 //var guidanceprice = $('#guidanceprice').val();
				 /* var coordinate = "";
				 
				 var geocoder =  new google.maps.Geocoder();
				 geocoder.geocode( { 'address': location}, function(results, status) {
				 if (status == google.maps.GeocoderStatus.OK) {
					 coordinate = results[0].geometry.location.lat() + "," +results[0].geometry.location.lng(); 
				     alert(coordinate);
				     alert("result ::"+results[0].geometry.location.lat() + "," +results[0].geometry.location.lng())
				 }
				 }); */
				 
				 
				 
				 $.ajax({
						url : "consumeguidance?guidanceSubject="+guidancesubject+"&guidancereason="+guidancereason+"&location="+location+"&published="+published+"&duration="+duration+"&guidencetype="+guidancetype,
						method : 'POST',
						success : function(data){
							//if(data.success == true){ // if true (1)
							     /*  setTimeout(function(){// wait for 5 secs(2)
							           location.reload(); // then reload the page.(3)
							      }, 5000);  */
							  // }
							
						}
					
			        }); 
				 
			 });
			 
			 
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
		
		
		function gotoguidance( guidanceid){
			 window.open("gotoguidance?guidanceid="+guidanceid);
			 
			 
		 }
		
		function gotoGuidanceView( guidanceid){
			 window.open("guidanceview?guidanceid="+guidanceid);
			 
			 
		 }
		
		function endorse(consumerid, providerid, guidancesubject){
			
			$.ajax({
				url : "endorseStudent?student="+consumerid+"&provider="+providerid+"&guidanceSubject="+guidancesubject,
				method : 'POST',
				success : function(){
					
					
				}
			
	        }); 
			
		}
		
		function pagingConsumer(guidanceid){
			
			$.ajax({
				url : "pagingguidance?guidanceid="+guidanceid,
				method : 'POST',
				success : function(){
					
				}
			
	        }); 
		}
		
		
		
	function apply(guidanceid){
			
			$.ajax({
				url : "endorseStudent?student="+consumerid+"&provider="+providerid+"&guidanceSubject="+guidancesubject,
				method : 'POST',
				success : function(){
					
					
				}
			
	        }); 
			
		}

		
	</script>

</body>

</html>