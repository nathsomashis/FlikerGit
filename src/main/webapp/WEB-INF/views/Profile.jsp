<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.fliker.Repository.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>

<%
		
			String fullname = (String)request.getAttribute("FullName");
			String gender = (String)request.getAttribute("Gender");
			String userid = (String)request.getAttribute("userid");
			String imagid = (String)request.getAttribute("ProfileImage");
			String logo = "";
			
			
		
		%>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

<title><%=fullname%></title>
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

<style>
.s2 {
	color: #D14;
}

.c1 {
	color: #998;
	font-style: italic;
}

.mi {
	color: #099;
}
</style>


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
<body class="" onload="geoFindMe()">
	
	<!-- HEADER -->
	<header id="header">
		<div id="logo-group">

			<!-- PLACE YOUR LOGO HERE -->
			<span id="logo"> <img src="img/logo.png" alt="Medha">
			</span>
			<!-- END LOGO PLACEHOLDER -->
			<input type="hidden" class="form-control" value="" required	id="locationspec" />
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
						name="activity" id="offlinechatmessages?"> Msgs 
					</label> <label class="btn btn-default"> <input type="radio"
						name="activity" id="notifications?"> notify 
					</label> <label class="btn btn-default"> <input type="radio"
						name="activity" id="tasklists?"> Tasks 
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
				<span> <a href="#"
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
						class="menu-item-parent">Smart Chat API <sup>beta</sup></span></a>
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
				<li>Profile</li>
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

		<%
			
				String imageid = "";
				String profileid = "";
				String skypeid = "";
				String name = "";
				String emailid = "";
				String currentStatus="";
				String experience = "";
				String hangoverid = "";
				String salary = "";
				String tellaboutme = "";
				String contact = "";
				int articlecount = 0;
				int connectioncount = 0;
				int followercount = 0;
				int skillcount = 0;
				int eventcount = 0;
				int guidancecount = 0;
				int projectcount = 0;
				int coursecount = 0;
				
				String skillString = "";
				ArrayList articlelist = new ArrayList();
				ArrayList connectionlist = new ArrayList();
				ArrayList followerlist = new ArrayList();
				ArrayList skilllist = new ArrayList();
				ArrayList eventlist = new ArrayList();
				ArrayList guidancelist = new ArrayList();
				ArrayList projectlist = new ArrayList();
				ArrayList courselist = new ArrayList();
				ArrayList profilelist = (ArrayList)request.getAttribute("postlist");
				System.out.println(profilelist);
				for(int m=0;m<profilelist.size();m++){
					
					
					if(profilelist.get(m) instanceof Profile){
						Profile profileinfo = (Profile)profilelist.get(m);
						imageid = profileinfo.getProfileImageid();
						profileid = profileinfo.getProfileid();
						skypeid = profileinfo.getSkypeid();
						if(skypeid == null){
							skypeid = "_B_L_A_N_K_";
						}
						name = profileinfo.getName();
						emailid = profileinfo.getEmailid();
						experience = profileinfo.getExperience();
						hangoverid = profileinfo.getHangoverid();
						salary = profileinfo.getSalary();
						tellaboutme = profileinfo.getTellmeaboutme();
						if(tellaboutme == null){
							tellaboutme = "_B_L_A_N_K_";
						}
						currentStatus = profileinfo.getCurrentStatus();
						if(currentStatus == null){
							currentStatus = "_B_L_A_N_K_";
						}
						contact = profileinfo.getContact();
						if(contact == null){
							contact = "_B_L_A_N_K_";
						}
					
					}else {
						
						HashMap collectionlist = (HashMap)profilelist.get(m);
						Set collectionset = collectionlist.entrySet();
						Iterator collit = collectionset.iterator();
						while(collit.hasNext()){
							
							Map.Entry mecoll = (Map.Entry)collit.next();
							String collectionresul = (String)mecoll.getKey();
							
							if(collectionresul.equalsIgnoreCase("articles")){
								articlelist = (ArrayList)mecoll.getValue();
								if(articlelist!= null){
									articlecount = articlelist.size();
								}
								
							}else if(collectionresul.equalsIgnoreCase("connections")){
								connectionlist = (ArrayList)mecoll.getValue();
								if(connectionlist!= null){
									connectioncount = connectionlist.size();
								}
								
							}else if(collectionresul.equalsIgnoreCase("followers")){
								followerlist = (ArrayList)mecoll.getValue();
								if(followerlist!= null){
									followercount = followerlist.size();
								}
							}else if(collectionresul.equalsIgnoreCase("eventids")){
								eventlist = (ArrayList)mecoll.getValue();
								if(eventlist!= null){
									eventcount = eventlist.size();
								}
							}else if(collectionresul.equalsIgnoreCase("guidance")){
								guidancelist = (ArrayList)mecoll.getValue();
								if(guidancelist!= null){
									guidancecount = guidancelist.size();
								}
							}else if(collectionresul.equalsIgnoreCase("skills")){
								skilllist = (ArrayList)mecoll.getValue();
								if(skilllist!= null){
									StringBuffer preskilltop = new StringBuffer();
									
									for(int i=0;i<skilllist.size();i++){
										System.out.println("Size >>"+skilllist.size());
										String skillsetstr = "";
										HashMap skillmap = (HashMap)skilllist.get(i);
										Set skillset = skillmap.entrySet();
										Iterator skillit = skillset.iterator();
										String perskillline = "";
										
										String skillid = "";
										String skillnm = "";
										String skillas = "";
										while(skillit.hasNext()){
											
											Map.Entry skillme = (Map.Entry)skillit.next();
											if(((String)skillme.getKey()).equalsIgnoreCase("skillasses")){
												ArrayList skillasseslist = (ArrayList)skillme.getValue();
												StringBuffer skillassesbuff = new StringBuffer();
												for(int n=0;n<skillasseslist.size();n++){
													String skillasses = (String)skillasseslist.get(n);
													
													String[] assementset = skillasses.split(":");
													if(assementset.length<2){
														String assesstr = "<div class='panel-body'><div class='row'><div class='col-xs-6'><p>"+assementset[0]+"</p></div><div class='col-xs-6'></div></div></div>";
														skillassesbuff.append(assesstr);
													}else{
														String assesstr = "<div class='panel-body'><div class='row'><div class='col-xs-6'><p>"+assementset[0]+"</p></div><div class='col-xs-6'><img class='superbox-img' src='/Fliker/imageFromFileSet/"+assementset[1]+"'/></div></div></div>";
														skillassesbuff.append(assesstr);
													}
												}
												skillas = skillassesbuff.toString();
												System.out.println(skillas);
											}else if(((String)skillme.getKey()).equalsIgnoreCase("skillname")){
												skillnm = (String)skillme.getValue();
											}else if(((String)skillme.getKey()).equalsIgnoreCase("skillid")){
												skillid = (String)skillme.getValue();
											}
											
										}
										perskillline = "<div class='panel panel-default'>"+"<div class='panel-heading'><h4 class='panel-title'><a data-toggle='collapse'"+ 
												"data-parent='#skillset' href='#"+skillid+"'> <i class='fa fa-fw fa-plus-circle txt-color-green'></i> <i class='fa fa-fw fa-minus-circle"+ 
												"txt-color-red'></i>"+skillnm+"</a></h4></div>"+"<div id="+skillid+" class='panel-collapse collapse'>"+
														skillas+"<br><a href='#' rel='tooltip' title='' id='"+skillid+"' data-placement='top' onclick=(AddNewAchievement('"+skillid+"')) data-original-title='Add New Acheivement to Skill'>Add Achievement</a></div></div>";
										
										preskilltop.append(perskillline);
										
									}
									skillString = preskilltop.toString();
									
									
									skillcount = skilllist.size();
								}
							}else if(collectionresul.equalsIgnoreCase("projects")){
								projectlist = (ArrayList)mecoll.getValue();
								if(projectlist!= null){
									projectcount = projectlist.size();
								}
							}else if(collectionresul.equalsIgnoreCase("courses")){
								courselist = (ArrayList)mecoll.getValue();
								if(courselist!= null){
									coursecount = courselist.size();
								}
							}
							
						}
						
					}
					
					
				}
			
			
			%>


		<!-- MAIN CONTENT -->
		<div id="content">

			<!-- Bread crumb is created dynamically -->
			<!-- row -->
			<!-- <div class="row">
				
					col
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark">PAGE HEADER<i class="fa-fw fa fa-puzzle-piece"></i> App Views <span>>
							Profile </span></h1>
					</div>
					end col
				
					right side of the page with the sparkline graphs
					col
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
						sparks
						<ul id="sparks">
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
						end sparks
					</div>
					end col
				
				</div> -->
			<!-- end row -->

			<!-- row -->

			<div class="row">

				<div class="col-sm-12">


					<div class="well well-sm">

						<div class="row">

							<div class="col-sm-12 col-md-12 col-lg-6">
								<div class="well well-light well-sm no-margin no-padding">

									<div class="row">

										<div class="col-sm-12">
											<div id="myCarousel" class="carousel fade profile-carousel">
												<div class="air air-bottom-right padding-10">
													<a href="javascript:void(0);"
														class="btn txt-color-white bg-color-teal btn-sm"><i
														class="fa fa-check"></i> Follow</a>&nbsp; <a
														href="javascript:void(0);"
														class="btn txt-color-white bg-color-pinkDark btn-sm"><i
														class="fa fa-link"></i> Connect</a>
												</div>
												<div class="air air-top-left padding-10">
													<h4 class="txt-color-white font-md">Jan 1, 2014</h4>
												</div>
												<ol class="carousel-indicators">
													<li data-target="#myCarousel" data-slide-to="0"
														class="active"></li>
													<li data-target="#myCarousel" data-slide-to="1" class=""></li>
													<li data-target="#myCarousel" data-slide-to="2" class=""></li>
												</ol>
												<div class="carousel-inner">
													<!-- Slide 1 -->
													<div class="item active">
														<img src="<c:url value='/resources/img/demo/s1.jpg' />"
															alt="demo user">
													</div>
													<!-- Slide 2 -->
													<div class="item">
														<img src="<c:url value='/resources/img/demo/s2.jpg' />"
															alt="demo user">
													</div>
													<!-- Slide 3 -->
													<div class="item">
														<img src="<c:url value='/resources/img/demo/m3.jpg' />"
															alt="demo user">
													</div>
												</div>
											</div>
										</div>

										<div class="col-sm-12">

											<div class="row">

												<div class="col-sm-3 profile-pic">
													<% if(imageid!= null){%>

													<img data-toggle="modal" data-target="#myModal"
														src="<c:url value='/resources/img/avatars/sunny-big.png' />"
														alt="demo user">

													<%}else {%>

													<img data-toggle="modal" data-target="#myModal"
														src="<c:url value='/resources/img/avatars/male.png' />"
														alt="demo user">

													<%} %>
													<div class="padding-10">
														<h4 class="font-md">
															<strong><%=followercount %></strong> <br> <small>Followers</small>
														</h4>
														<br>
														<h4 class="font-md">
															<strong><%=connectioncount%></strong> <br> <small>Connections</small>
														</h4>
													</div>
												</div>
												<div class="col-sm-6">
													<h1>
														<span class="semi-bold"><%=name%></span> <br> <small
															id="currectstatus-result"> <%=currentStatus %></small>&nbsp;&nbsp;<i
															href="#" id="currectstatus-eg5" class="fa fa-edit"></i>
													</h1>

													<ul class="list-unstyled">
														<li>
															<p class="text-muted">
																<i class="fa fa-phone"></i>&nbsp;&nbsp;<span
																	id="contact-result" class="txt-color-darken"><%=contact%></span><i
																	href="#" id="contact-eg6" class="fa fa-edit"></i>
															</p>
														</li>
														<li>
															<p class="text-muted">
																<i class="fa fa-envelope"></i>&nbsp;&nbsp;<a
																	id="email-result" href="mailto:<%=emailid%>"><%=emailid%></a>&nbsp;&nbsp;<i
																	href="#" id="email-eg6" class="fa fa-edit"></i>
															</p>
														</li>
														<li>
															<p class="text-muted">
																<i class="fa fa-skype"></i>&nbsp;&nbsp;<span
																	id="skype-result" class="txt-color-darken"><%=skypeid%></span><i
																	href="#" id="skype-eg6" class="fa fa-edit"></i>
															</p>
														</li>
														<li>
															<p class="text-muted">
																<i class="fa fa-calendar"></i>&nbsp;&nbsp;<span
																	class="txt-color-darken">Free after <a
																	href="javascript:void(0);" rel="tooltip" title=""
																	data-placement="top"
																	data-original-title="Create an Appointment">4:30 PM</a></span>
															</p>
														</li>
													</ul>
													<br>
													<p id="tellabout-result" class="font-md">
														<i>A little about me...</i><i href="#" id="tellabout-eg6"
															class="fa fa-edit"></i>
													</p>
													<p id="tellabout-result">

														<%=tellaboutme%>

													</p>
													<%-- <br>
															<a href="javascript:void(0);" class="btn btn-default btn-xs"><i class="fa fa-envelope-o"></i><%=hangoverid %></a>
															<br> --%>
													<br>

												</div>
												<div class="col-sm-3">
													<h1>
														<small>Connections</small>
													</h1>
													<%if(connectioncount !=0){ %>
													<ul class="list-inline friends-list">
														<%for(int s=0;s<7;s++){ 
																
																	Profile profil = (Profile)connectionlist.get(s);
																	String userids = profil.getUserid();
																	String username = profil.getName();
																	String userimage = profil.getProfileImageid();
																
																%>
														<li><img src="/Fliker/imageFromUserid/<%=userids%>"
															alt="<%=username%>"></li>
														<%} %>
														<li><a href="javascript:void(0);"><%=connectionlist.size()-6%>more</a>
														</li>
													</ul>
													<%} %>
													<h1>
														<small>Followers</small>
													</h1>
													<%if(followercount !=0){ %>
													<ul class="list-inline friends-list">
														<%for(int t=0;t<7;t++){ 
																
																	Profile profil = (Profile)followerlist.get(t);
																	String userids = profil.getUserid();
																	String username = profil.getName();
																	String userimage = profil.getProfileImageid();
																
																%>
														<li><img src="/Fliker/imageFromUserid/<%=userids%>"
															alt="<%=username%>"></li>
														<%} %>
														<li><a href="javascript:void(0);"><%=followerlist.size()-6%>more</a>
														</li>
													</ul>
													<%} %>
												</div>

											</div>

										</div>

									</div>

									<div class="row">

										<div class="col-sm-12">

											<hr>

											<div class="padding-10">

												<ul class="nav nav-tabs tabs-pull-right">
													<li class="active"><a href="#a1" data-toggle="tab">Recent
															Articles</a></li>
													<li><a href="#a2" data-toggle="tab">New Members</a></li>
													<li class="pull-left"><span
														class="margin-top-10 display-inline"><i
															class="fa fa-rss text-success"></i> Activity</span></li>
												</ul>

												<div class="tab-content padding-top-10">
													<div class="tab-pane fade in active" id="a1">

														<div class="row">

															<div class="col-xs-2 col-sm-1">
																<time datetime="2014-09-20" class="icon">
																	<strong>Jan</strong> <span>10</span>
																</time>
															</div>

															<div class="col-xs-10 col-sm-11">
																<h6 class="no-margin">
																	<a href="javascript:void(0);">Allice in Wonderland</a>
																</h6>
																<p>Etiam ultricies nisi vel augue. Curabitur
																	ullamcorper ultricies nisi Nam eget dui. Etiam rhoncus.
																	Maecenas tempus, tellus eget condimentum rhoncus, sem
																	quam semper libero, sit amet adipiscing sem neque sed
																	ipsum. Nam quam nunc, blandit vel.</p>
															</div>

															<div class="col-sm-12">

																<hr>

															</div>

															<div class="col-xs-2 col-sm-1">
																<time datetime="2014-09-20" class="icon">
																	<strong>Jan</strong> <span>10</span>
																</time>
															</div>

															<div class="col-xs-10 col-sm-11">
																<h6 class="no-margin">
																	<a href="javascript:void(0);">World Report</a>
																</h6>
																<p>Morning our be dry. Life also third land after
																	first beginning to evening cattle created let subdue
																	you'll winged don't Face firmament. You winged you're
																	was Fruit divided signs lights i living cattle yielding
																	over light life life sea, so deep. Abundantly given
																	years bring were after. Greater you're meat beast
																	creeping behold he unto She'd doesn't. Replenish
																	brought kind gathering Meat.</p>
															</div>

															<div class="col-sm-12">

																<br>

															</div>

														</div>

													</div>
													<div class="tab-pane fade" id="a2">

														<div class="alert alert-info fade in">

															<i class="fa-fw fa fa-info"></i> <strong>Recommendations</strong>
														</div>

														<div class="user" title="email@company.com">
															<img src="img/avatars/female.png" alt="demo user"><a
																href="javascript:void(0);">Jenn Wilson</a>
															<div class="email">travis@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Marshall Hitt</a>
															<div class="email">marshall@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Joe Cadena</a>
															<div class="email">joe@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Mike McBride</a>
															<div class="email">mike@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Travis Wilson</a>
															<div class="email">travis@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Marshall Hitt</a>
															<div class="email">marshall@company.com</div>
														</div>
														<div class="user" title="Joe Cadena joe@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Joe Cadena</a>
															<div class="email">joe@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Mike McBride</a>
															<div class="email">mike@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Marshall Hitt</a>
															<div class="email">marshall@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);">Joe Cadena</a>
															<div class="email">joe@company.com</div>
														</div>
														<div class="user" title="email@company.com">
															<img src="img/avatars/male.png" alt="demo user"><a
																href="javascript:void(0);"> Mike McBride</a>
															<div class="email">mike@company.com</div>
														</div>

														<div class="text-center">
															<ul class="pagination pagination-sm">
																<li class="disabled"><a href="javascript:void(0);">Prev</a>
																</li>
																<li class="active"><a href="javascript:void(0);">1</a>
																</li>
																<li><a href="javascript:void(0);">2</a></li>
																<li><a href="javascript:void(0);">3</a></li>
																<li><a href="javascript:void(0);">...</a></li>
																<li><a href="javascript:void(0);">99</a></li>
																<li><a href="javascript:void(0);">Next</a></li>
															</ul>
														</div>

													</div>
													<!-- end tab -->
												</div>

											</div>

										</div>

									</div>
									<!-- end row -->

								</div>

							</div>
							<div class="col-sm-12 col-md-12 col-lg-6">

								<form method="post" class="well padding-bottom-10"
									onsubmit="return false;">
									<textarea rows="2" class="form-control"
										placeholder="What are you thinking?"></textarea>
									<div class="margin-top-10">
										<button type="submit"
											class="btn btn-sm btn-primary pull-right">Post</button>
										<a href="javascript:void(0);"
											class="btn btn-link profile-link-btn" rel="tooltip"
											data-placement="bottom" title="Add Location"><i
											class="fa fa-location-arrow"></i></a> <a
											href="javascript:void(0);"
											class="btn btn-link profile-link-btn" rel="tooltip"
											data-placement="bottom" title="Add Voice"><i
											class="fa fa-microphone"></i></a> <a href="javascript:void(0);"
											class="btn btn-link profile-link-btn" rel="tooltip"
											data-placement="bottom" title="Add Photo"><i
											class="fa fa-camera"></i></a> <a href="javascript:void(0);"
											class="btn btn-link profile-link-btn" rel="tooltip"
											data-placement="bottom" title="Add File"><i
											class="fa fa-file"></i></a>
									</div>
								</form>

								<div class="timeline-seperator text-center">
									<span>10:30PM January 1st, 2013</span>
									<div class="btn-group pull-right">
										<a href="javascript:void(0);" data-toggle="dropdown"
											class="btn btn-default btn-xs dropdown-toggle"><span
											class="caret single"></span></a>
										<ul class="dropdown-menu text-left">
											<li><a href="javascript:void(0);">Hide this post</a></li>
											<li><a href="javascript:void(0);">Hide future posts
													from this user</a></li>
											<li><a href="javascript:void(0);">Mark as spam</a></li>
										</ul>
									</div>
								</div>
								<div class="chat-body no-padding profile-message">
									<!-- <ul>
												<li class="message">
													<img src="img/avatars/sunny.png" class="online" alt="sunny">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very
														image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Edit</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger">Delete</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
													<input class="form-control input-xs" placeholder="Type and enter" type="text">
												</li>
											</ul> -->
									Add
								</div>

								<div class="timeline-seperator text-center">
									<span>11:30PM November 27th, 2013</span>
									<div class="btn-group pull-right">
										<a href="javascript:void(0);" data-toggle="dropdown"
											class="btn btn-default btn-xs dropdown-toggle"><span
											class="caret single"></span></a>
										<ul class="dropdown-menu text-left">
											<li><a href="javascript:void(0);">Hide this post</a></li>
											<li><a href="javascript:void(0);">Hide future posts
													from this user</a></li>
											<li><a href="javascript:void(0);">Mark as spam</a></li>
										</ul>
									</div>
								</div>
								<div class="chat-body no-padding profile-message">
									<!-- <ul>
												<li class="message">
													<img src="img/avatars/1.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Hide</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li>
													<div class="input-group wall-comment-reply">
														<input id="btn-input" type="text" class="form-control" placeholder="Type your message here...">
														<span class="input-group-btn">
															<button class="btn btn-primary" id="btn-chat">
																<i class="fa fa-reply"></i> Reply
															</button> </span>
													</div>
												</li>
											</ul> -->

									Add

								</div>


							</div>
						</div>

					</div>


				</div>

			</div>

			<div class="row">
				<article class="col-sm-12 col-md-12 col-lg-12">

					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-blueLight"
						id="skilltag" data-widget-colorbutton="false"
						data-widget-editbutton="false" data-widget-togglebutton="false"
						data-widget-deletebutton="false"
						data-widget-fullscreenbutton="false"
						data-widget-custombutton="false" data-widget-sortable="false">
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
							<span class="widget-icon"> <i class="fa fa-list-alt"></i>
							</span>
							<h2>Skills</h2>

							<div class="widget-toolbar hidden-phone">
								<div class="smart-form">
									<label class="checkbox">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#skillsetimprove"
											onclick="generateToken('skill')">Add New Skill</button>
									</label>
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

								<div class="panel-group smart-accordion-default" id="skillset">
									<%=skillString%>
									
								</div>

							</div>
							<!-- end widget content -->

						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->

				</article>
			</div>
			<div class="row">
				<article class="col-sm-12 col-md-12 col-lg-12">

					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-blueLight"
						id="projecttag" data-widget-colorbutton="false"
						data-widget-editbutton="false" data-widget-togglebutton="false"
						data-widget-deletebutton="false"
						data-widget-fullscreenbutton="false"
						data-widget-custombutton="false" data-widget-sortable="false">
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
							<span class="widget-icon"> <i class="fa fa-list-alt"></i>
							</span>
							<h2>Projects</h2>

							<div class="widget-toolbar hidden-phone">
								<div class="smart-form">
									<label class="checkbox">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#projectsetimprove"
											onclick="generateToken('project')">Add New Project
											Info</button>
									</label>
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

								<div class="panel-group smart-accordion-default" id="projectset">

									<%-- <%=guidanceachievements%> --%>
								</div>

							</div>
							<!-- end widget content -->

						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->

				</article>
			</div>
			<div class="row">
				<article class="col-sm-12 col-md-12 col-lg-12">

					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-blueLight"
						id="articletag" data-widget-colorbutton="false"
						data-widget-editbutton="false" data-widget-togglebutton="false"
						data-widget-deletebutton="false"
						data-widget-fullscreenbutton="false"
						data-widget-custombutton="false" data-widget-sortable="false">
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
							<span class="widget-icon"> <i class="fa fa-list-alt"></i>
							</span>
							<h2>Articles</h2>

							<div class="widget-toolbar hidden-phone">
								<div class="smart-form">
									<label class="checkbox">
										<button class="btn btn-primary" onclick="createNewArticle()">Provide
											New Achevements</button>
									</label>
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

								<div class="panel-group smart-accordion-default" id="articleset">

									<%-- <%=guidanceachievements%> --%>
								</div>

							</div>
							<!-- end widget content -->

						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->

				</article>
			</div>

			<section id="widget-grid" class="">

				<fieldset>
					<legend> Salary & Experience </legend>
					<div class="row">
						<!-- <div class="col-sm-6">

				<div class="form-group">
					<input id="range-slider-1" type="text" name="range_1" value="">
				</div>
			</div> -->
						<div class="col-sm-6">

							<div class="form-group">
								<input id="range-slider-2" type="text" name="range_2">
							</div>
						</div>
					</div>

					<!-- <div class="row">
			<div class="col-sm-6">

				<div class="form-group">
					<input id="range-slider-3" type="text" name="range_2a" value="">
				</div>
			</div>
			<div class="col-sm-6">

				<div class="form-group">
					<input id="range-slider-4" type="text" name="range_4" value="">
				</div>
			</div>
		</div> -->

					<div class="row">
						<div class="col-sm-12">

							<div class="form-group">
								<input id="range-slider-5" type="text" name="range_5a" value="">
							</div>
						</div>

					</div>

				</fieldset>

				<fieldset style="display: none">
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
								<label>Range slider (<span class="nouislider-value">20
										- 60</span>)
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

				<!-- row -->
				<div class="row">

					<!-- NEW WIDGET START -->
					<div class="widget-body">
						<div class="row">

							<!-- NEW WIDGET START -->
							<article class="col-sm-12">



								<!-- Widget ID (each widget will need unique ID)-->
								<div class="jarviswidget jarviswidget-color-blueLight"
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
									<header>
										<span class="widget-icon"> <i class="fa fa-cloud"></i>
										</span>
										<h2>Document Set</h2>

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

											<form action="upload.php" class="dropzone" id="mydropzone"></form>

										</div>
										<!-- end widget content -->

									</div>
									<!-- end widget div -->

								</div>
								<!-- end widget -->

							</article>
							<!-- WIDGET END -->

						</div>

					</div>
					<!-- WIDGET END -->

				</div>


				<!-- end row -->

				<!-- row -->


				<!-- end row -->

			</section>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-body">

							<div class="row">

								<!-- NEW WIDGET START -->
								<div class="widget-body">
									<div class="row">

										<!-- NEW WIDGET START -->
										<article class="col-sm-12">



											<!-- Widget ID (each widget will need unique ID)-->
											<div class="jarviswidget jarviswidget-color-blueLight"
												id="wid-id-1" data-widget-editbutton="false">
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
													<span class="widget-icon"> <i class="fa fa-cloud"></i>
													</span>
													<h2>New Profile Image</h2>

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
															id="Imagedropzone"></form>

													</div>
													<!-- end widget content -->

												</div>
												<!-- end widget div -->

											</div>
											<!-- end widget -->

										</article>
										<!-- WIDGET END -->

									</div>


								</div>
								<!-- WIDGET END -->

							</div>

						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- end row -->

		</div>
		<!-- END MAIN CONTENT -->
		<div class="modal fade" id="skillsetimprove" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Provide Skills</h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Skill Set"
										required id="skill" />
								</div>
								<div class="form-group">
									<textarea id="skilldata" class="form-control"
										placeholder="Provide info on the above skill set. Can add extra info later"
										rows="5" required></textarea>
								</div>
								<div class="form-group">
									<form id="form2" method="post" action="#"
										enctype="multipart/form-data">
										<label class="col-md-2 control-label">Any
											Attachment(Certification)</label>
										<div class="col-md-10">
											<input type="file" id="fileskill" name="fileskill"
												class="btn btn-default" id="skillfile">
										</div>
										<button class="col-md-2" type="button"
											onclick="uploadFormData()">Upload</button>
									</form>
									<input type="hidden" class="form-control" value="" required
										id="skilltoken" />
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cancel</button>
						<button type="button" class="btn btn-primary"
							id="addnewachievement" onclick="addachieve()">Add Skill
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		<div class="modal fade" id="skillnewset" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Provide Skills</h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<textarea id="skillnewdata" class="form-control"
										placeholder="Provide info on the above skill set. Can add extra info later"
										rows="5" required></textarea>
								</div>
								<div class="form-group">
									<form id="form2" method="post" action="#"
										enctype="multipart/form-data">
										<label class="col-md-2 control-label">Any
											Attachment(Certification)</label>
										<div class="col-md-10">
											<input type="file" id="filenewskill" name="filenewskill"
												class="btn btn-default" id="skillnewfile">
										</div>
										<button class="col-md-2" type="button"
											onclick="uploadSkillNewData()">Upload</button>
									</form>
									<input type="hidden" class="form-control" value="" required
										id="skillnewtoken" />
									<input type="hidden" class="form-control" value="" required
										id="skillexistingid" />	
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cancel</button>
						<button type="button" class="btn btn-primary"
							id="addnewachievement" onclick="addOnExistSkillachieve()">Add Skill
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

		<div class="modal fade" id="projectsetimprove" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Provide Projects</h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Project Name" required id="projectname" />
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Project Skill" required id="projectskill" />
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Project Role" required id="projectrole" />
								</div>
								<div class="form-group">
									<textarea id="projectdata" class="form-control"
										placeholder="Provide info on the above skill set. Can add extra info later"
										rows="5" required></textarea>
									<input type="hidden" class="form-control" value="" required
										id="projecttoken" />	
								</div>
								<div class="form-group">
									<form id="form2" method="post" action="#"
										enctype="multipart/form-data">
										<label class="col-md-2 control-label">Any
											Attachment(Certification)</label>
										<div class="col-md-10">
											<input type="file" id="filenewproject" name="filenewproject"
												class="btn btn-default" id="projectfile">
										</div>
										<button class="col-md-2" type="button"
											onclick="uploadProjectData()">Upload</button>
									</form>
									<input type="hidden" class="form-control" value="" required
										id="projecttoken" />
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cancel</button>
						<button type="button" class="btn btn-primary"
							id="addnewproject" onclick="addproject()">Add
							Projects</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<div class="modal fade" id="projectnewsetimprove" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Provide Projects</h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Project New Skill Added" id="projectskilladd" />
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Project New Role" required id="projectnewrole" />
								</div>
								<div class="form-group">
									<textarea id="projectnewdata" class="form-control"
										placeholder="Provide info on the above skill set. Can add extra info later"
										rows="5" required></textarea>
									<input type="hidden" class="form-control" value="" required
										id="projectnewtoken" />	
								</div>
								<div class="form-group">
									<form id="form2" method="post" action="#"
										enctype="multipart/form-data">
										<label class="col-md-2 control-label">Any
											Attachment(Certification)</label>
										<div class="col-md-10">
											<input type="file" id="filenewprojectdat" name="filenewprojectdat"
												class="btn btn-default" id="projectfile">
										</div>
										<button class="col-md-2" type="button"
											onclick="uploadProjectNewData()">Upload</button>
									</form>
									<input type="hidden" class="form-control" value="" required
										id="projectnewtoken" />
									<input type="hidden" class="form-control" value="" required
										id="projectexistingid" />	
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cancel</button>
						<button type="button" class="btn btn-primary"
							id="addnewprojectdata" onclick="addDataproject()">Add
							Projects</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
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
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="js/plugin/pace/pace.min.js"></script>

	<script src="js/plugin/dropzone/dropzone.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
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
	<%-- <script src="<c:url value='/resources/js/app.config.js' />"></script> --%>
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

	<script
		src="<c:url value='/resources/js/plugin/dropzone/dropzone.min.js' />"></script>

	<!-- SmartChat UI : plugin -->
	<script
		src="<c:url value='/resources/js/smart-chat-ui/smart.chat.ui.min.js' />"></script>
	<!-- <script src="js/smart-chat-ui/smart.chat.ui.min.js"></script> -->
	<script
		src="<c:url value='/resources/js/smart-chat-ui/smart.chat.manager.min.js' />"></script>
	<!-- <script src="js/smart-chat-ui/smart.chat.manager.min.js"></script> -->

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
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?key='AIzaSyDuATgAn9J88smIpYM1SD_3RFAiA-PF4q4'&v=3&sensor=true"></script>


	<!-- <script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		
		
		$(document).ready(function() {
			
			pageSetUp();
		
		})

		</script> -->
	<script type="text/javascript">
		
		
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		var slider1 = document.getElementById('nouislider-1'),
			slider2 = document.getElementById('nouislider-2'),
			slider3 = document.getElementById('nouislider-3'),
			slider4 = document.getElementById('nouislider-4');
		
		
		$(document).ready(function() {
			
			pageSetUp();
			
			$("#smart-mod-eg5").click(function(e) {
				
				$.SmartMessageBox({
					title : "Login form",
					content : "Please enter your user name",
					buttons : "[Cancel][Accept]",
					input : "text",
					placeholder : "Enter your user name"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						alert("Why did you cancel that? :(");
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					$.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					});
				});
		
				e.preventDefault();
			});	
			
			$("#smart-mod-eg1").click(function(e) {
				$.SmartMessageBox({
					title : "Smart Alert!",
					content : "This is a confirmation box. Can be programmed for button callback",
					buttons : '[No][Yes]'
				}, function(ButtonPressed) {
					if (ButtonPressed === "Yes") {
		
						$.smallBox({
							title : "Callback function",
							content : "<i class='fa fa-clock-o'></i> <i>You pressed Yes...</i>",
							color : "#659265",
							iconSmall : "fa fa-check fa-2x fadeInRight animated",
							timeout : 4000
						});
					}
					if (ButtonPressed === "No") {
						$.smallBox({
							title : "Callback function",
							content : "<i class='fa fa-clock-o'></i> <i>You pressed No...</i>",
							color : "#C46A69",
							iconSmall : "fa fa-times fa-2x fadeInRight animated",
							timeout : 4000
						});
					}
		
				});
				e.preventDefault();
			})
				
		$("#profileimage-eg5").click(function(e) {
				
				$.SmartMessageBox({
					title : "New Profile Image",
					content : "New Image",
					buttons : "[Cancel][Upload]",
					input : "text",
					placeholder : "Upload New Image"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					
				if(ButtonPress == "Upload"){
						
					var formData = new FormData($('#wizard-1')[0][1]);
				      alert(formData);
				     //var comment = new FormData($('#comments')[0]);
				      
				      /* get some values from elements on the page: */
				      $.ajax({
			                url: "rest/file/upload?",
			                type: 'POST',
			                data : formData,
			                paramName: "file",
			                success: function(result) {
			                    // ... Process the result ...
			                },
			                cache: false,
			                contentType: false,
			                processData: false
			            });
						
						
					}
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});			
				
		$("#currectstatus-eg5").click(function(e) {
				
				$.SmartMessageBox({
					title : "Edit Current Status",
					content : "New Position ",
					buttons : "[Cancel][Save]",
					input : "text",
					placeholder : "Enter your status"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					if(ButtonPress == "Save"){
						
						$('#currectstatus-result')[0].innerHTML = Value;
						//alert(Value);
						
						$.ajax({
							url : "currentStatus?currentstatus="+Value,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
						
						
					}
					
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});				
				
		$("#contact-eg6").click(function(e) {
				
				$.SmartMessageBox({
					title : "Change Contact No",
					content : "New Contact Number",
					buttons : "[Cancel][Save]",
					input : "text",
					placeholder : "Enter your user name"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					
					if(ButtonPress == "Save"){
						
						$('#contact-result')[0].innerHTML = Value;
						//alert(Value);
						
						$.ajax({
							url : "contactNo?contact="+Value,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
						
						
					}
					
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});	
				
				
		$("#email-eg6").click(function(e) {
				
				$.SmartMessageBox({
					title : "Email Form",
					content : "Change Email",
					buttons : "[Cancel][Save]",
					input : "text",
					placeholder : "Enter your user name"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						alert("Why did you cancel that? :(");
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					
				if(ButtonPress == "Save"){
						
						$('#email-result')[0].innerHTML = Value;
						//alert(Value);
						
						$.ajax({
							url : "emailModify?emailid="+Value,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
						
						
					}
					
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});	
				
		$("#skype-eg6").click(function(e) {
				
				$.SmartMessageBox({
					title : "Skype ID",
					content : "New Skype ID",
					buttons : "[Cancel][Save]",
					input : "text",
					placeholder : "Enter your user name"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					
				if(ButtonPress == "Save"){
						
						$('#skype-result')[0].innerHTML = Value;
						//alert(Value);
						
						$.ajax({
							url : "skypeid?skypeid="+Value,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
						
						
					}
					
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});	
				
		$("#tellabout-eg6").click(function(e) {
				
				$.SmartMessageBox({
					title : "About Me",
					content : "Tell Me About",
					buttons : "[Cancel][Save]",
					input : "text",
					rows: "3",
					width:"350",
		            height:"300",
					placeholder : "Tell me about yourself"
				}, function(ButtonPress, Value) {
					if (ButtonPress == "Cancel") {
						return 0;
					}
		
					Value1 = Value.toUpperCase();
					ValueOriginal = Value;
					
				if(ButtonPress == "Submit"){
						
						$('#tellabout-result')[0].innerHTML = Value;
						//alert(Value);
						
						$.ajax({
							url : "tellmeaboutme?aboutme="+Value,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
						
						
					}
					
					/* $.SmartMessageBox({
						title : "Hey! <strong>" + Value1 + ",</strong>",
						content : "And now please provide your password:",
						buttons : "[Login]",
						input : "password",
						placeholder : "Password"
					}, function(ButtonPress, Value) {
						alert("Username: " + ValueOriginal + " and your password is: " + Value);
					}); */
				});
		
				e.preventDefault();
			});		
				
			
			
			// menu
			$("#menu").menu();
		
			/*
			 * AUTO COMPLETE AJAX
			 */
			
			 noUiSlider.create(slider1, {
			        range: {
						'min': 20,
						'max': 100
					},
					behaviour: 'tap',
			        start: 55,
			        connect: 'upper',
			    });


			    noUiSlider.create(slider2, {
			        range: {
						'min': 0,
						'max': 300
					},
			        start: [55, 130],
			        step: 60,
			        connect: true
			    });


				noUiSlider.create(slider3, {
			        range: {
						'min': 0,
						'max': 1000
					},
			        start: [264, 776],
			        step: 1,
			        connect: true
			    });

			    slider3.noUiSlider.on('update', function(values){
			        $(".nouislider-value").text(values[0] + " - " + values[1]);
			    });

			    slider3.noUiSlider.on('slide', function(values){
					//var values = $(this).val();
			        $(".nouislider-value").text(values[0] + " - " + values[1]);
				});

				noUiSlider.create(slider4, {
			        range: {
						'min': 0,
						'max': 100
					},
					behaviour: 'tap',
			        start: 50,
			        connect: 'upper'
			        
			    });

			    slider4.setAttribute('disabled', true);
			
			
				/*
				 * ION SLIDER
				 */
			
			    $("#range-slider-1").ionRangeSlider({
			        min: 0,
			        max: 5000,
			        from: 1000,
			        to: 4000,
			        type: 'double',
			        step: 1,
			        postfix: " &euro;",
			        prettify: false,
			        grid: true,
			        inputValuesSeparator: ';'
			    });
			
			    $("#range-slider-2").ionRangeSlider({
			    	min: 1000,
			        max: 100000,
			        from: 30000,
			        to: 90000,
			        type: 'double',
			        step: 500,
			        postfix: " &dollar;",
			        prettify: false,
			        grid: true,
			        inputValuesSeparator: ';',
			        onChange: function (data) {
			            console.log(data);
			            
			        },
			        onFinish: function (data) {
			            console.log(data);
			            alert(data.from);
			            alert(data.to);
			            
			            $.ajax({
							url : "salary?salarystart="+data.from+"&salaryend="+data.to,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
			        }
			    });
			
			    $("#range-slider-3").ionRangeSlider({
			        min: 0,
			        from: 2.3,
			        max: 10,
			        type: 'single',
			        step: 0.1,
			        postfix: " year",
			        prettify: false,
			        grid: true,
			        inputValuesSeparator: ';',
			        onChange: function (data) {
			            console.log(data);
			            
			        },
			        onFinish: function (data) {
			            console.log(data);
			            alert(data.from);
			            
			            $.ajax({
							url : "experience?experience="+data.from,
							method : 'GET',
							success : function(data) {
								
								
							}
						});
			            
			        }
			    });
			
			    $("#range-slider-4").ionRangeSlider({
			        min: -50,
			        max: 50,
			        from: 5,
			        to: 25,
			        type: 'double',
			        step: 1,
			        postfix: "Â°",
			        prettify: false,
			        grid: true,
			        inputValuesSeparator: ';'
			    });
			
			    $("#range-slider-5").ionRangeSlider({
			        min: 0,
			        from: 0,
			        max: 10,
			        type: 'single',
			        step: 0.1,
			        postfix: " year",
			        prettify: false,
			        grid: true,
			        inputValuesSeparator: ';',
			        onChange: function (data) {
			            console.log(data);
			            
			        },
			        onFinish: function (data) {
			            console.log(data);
			            alert(data.from);
			            
			        }
			    });
			 
			 
			function log(message) {
				$("<div>").text(message).prependTo("#log");
				$("#log").scrollTop(0);
			}
		
			$("#city").autocomplete({
				source : function(request, response) {
					$.ajax({
						url : "http://ws.geonames.org/searchJSON",
						dataType : "jsonp",
						data : {
							featureClass : "P",
							style : "full",
							maxRows : 12,
							name_startsWith : request.term
						},
						success : function(data) {
							response($.map(data.geonames, function(item) {
								return {
									label : item.name + (item.adminName1 ? ", " + item.adminName1 : "") + ", " + item.countryName,
									value : item.name
								}
							}));
						}
					});
				},
				minLength : 2,
				select : function(event, ui) {
					log(ui.item ? "Selected: " + ui.item.label : "Nothing selected, input was " + this.value);
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
			$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
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
		
			$('#dialog_simple').dialog({
				autoOpen : false,
				width : 600,
				resizable : false,
				modal : true,
				title : "<div class='widget-header'><h4><i class='fa fa-warning'></i> Empty the recycle bin?</h4></div>",
				buttons : [{
					html : "<i class='fa fa-trash-o'></i>&nbsp; Delete all items",
					"class" : "btn btn-danger",
					click : function() {
						$(this).dialog("close");
					}
				}, {
					html : "<i class='fa fa-times'></i>&nbsp; Cancel",
					"class" : "btn btn-default",
					click : function() {
						$(this).dialog("close");
					}
				}]
			});
		
			/*
			* DIALOG HEADER ICON
			*/
		
			// Modal Link
			$('#modal_link').click(function() {
				$('#dialog-message').dialog('open');
				return false;
			});
		
			$("#dialog-message").dialog({
				autoOpen : false,
				modal : true,
				title : "<div class='widget-header'><h4><i class='icon-ok'></i> jQuery UI Dialog</h4></div>",
				buttons : [{
					html : "Cancel",
					"class" : "btn btn-default",
					click : function() {
						$(this).dialog("close");
					}
				}, {
					html : "<i class='fa fa-check'></i>&nbsp; OK",
					"class" : "btn btn-primary",
					click : function() {
						$(this).dialog("close");
					}
				}]
		
			});
		
			/*
			 * Remove focus from buttons
			 */
			$('.ui-dialog :button').blur();
		
			
		
			/*
			* ACCORDION
			*/
			//jquery accordion
			
		     var accordionIcons = {
		         header: "fa fa-plus",    // custom icon class
		         activeHeader: "fa fa-minus" // custom icon class
		     };
		     
			$("#accordion").accordion({
				autoHeight : false,
				heightStyle : "content",
				collapsible : true,
				animate : 300,
				icons: accordionIcons,
				header : "h4",
			})
		
			/*
			 * PROGRESS BAR
			 */
			$("#progressbar").progressbar({
		     	value: 25,
		     	create: function( event, ui ) {
		     		$(this).removeClass("ui-corner-all").addClass('progress').find(">:first-child").removeClass("ui-corner-left").addClass('progress-bar progress-bar-success');
				}
			});
			
			Dropzone.autoDiscover = false;
			$("#mydropzone").dropzone({
				url: "guidancefile?",
				paramName: "file",		
				addRemoveLinks : false,
				maxFilesize: 500,
				//maxFiles: 1,
				uploadMultiple: true,
		        parallelUploads: 100,
				dictDefaultMessage: '<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Drop files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
				dictResponseError: 'Error uploading file!',
				dictDuplicate:'<span class="text-center"><span class="font-lg visible-xs-block visible-sm-block visible-lg-block"><span class="font-lg"><i class="fa fa-caret-right text-danger"></i> Duplicate Files <span class="font-xs">to upload</span></span><span>&nbsp&nbsp<h4 class="display-inline"> (Or Click)</h4></span>',
				//clickable: '#preview-template',
				init: function () {
					this.on("addedfile", function(file) {
						
						this.accept = function(file, done) {
							if (this.files.length) {
								var isDuplicate = false;
								var ref = this.files.slice();
								for (var i = 0, len = this.files.length-1; i <= len; i++) {
									isDuplicate = true;
		                            console.log("duplikat: "+file.name);
		                            if (ref[i].name === file.name){
		                            	this.removeFile(ref[i]);
		                            	break;
		                            }
								}
								
							}
							
							
							/* if ( isDuplicate === true ) {
			   // output my error string for duplicates
			                    return done(this.removeFile(this.files[0]));
			                } else {
			                    return this.options.accept.call(this, file, done);
			                } */
							
						}
						
						/* for(var key in filelistmaintain){
							console.log(" inside log >>"+filelistmaintain[key]);
							if(filelistmaintain[key] == file.name){
								
								$('#duplicateModal').modal('show');
								//this.removeFile(file);
								alert("same file");
							}
							
						} */
						
						
						//myDropzone.accept = function(file, done) {

				      // custom duplicate check
				                

				     // default dropzone checks
				               /*  if (file.size > this.options.maxFilesize * 1024 * 1024) {
				                    return done(this.options.dictFileTooBig.replace("{[{filesize}]}", Math.round(file.size / 1024 / 10.24) / 100).replace("{[{maxFilesize}]}", this.options.maxFilesize));
				                } else if (!Dropzone.isValidFile(file, this.options.acceptedFiles)) {
				                    return done(this.options.dictInvalidFileType);
				                } else if ((this.options.maxFiles != null) && this.getAcceptedFiles().length >= this.options.maxFiles) {
				                    done(this.options.dictMaxFilesExceeded.replace("{[{maxFiles}]}", this.options.maxFiles));
				                    return this.emit("maxfilesexceeded", file);
				                } else if ( isDuplicate === true ) {
				   // output my error string for duplicates
				                    return done(this.options.dictDuplicate);
				                } else {
				                    return this.options.accept.call(this, file, done);
				                } */
				           // }
						
						//alert(file.fileid);
						var fileid = file.fileid;
						var filenam = file.name;
						var filsize = file.size;
						var filetype = file.type;
						var sharebutton = Dropzone.createElement("<a href='#' class='btn btn-primary btn-circle'><i class='glyphicon glyphicon-trash'></i></a>");
						var removeButton = Dropzone.createElement("<a href='#' class='btn btn-primary btn-circle'><i class='glyphicon glyphicon-list'></i></a>");
						var downloadButton = Dropzone.createElement("<a href='imageDownload/"+fileid+"' class='btn btn-primary btn-circle'><i class='glyphicon glyphicon-download-alt'></i></a>");
						//$('#fileitem').val(file);
						//generateToken();
						//$('#myModal').modal('show');
						
						<%-- var existringfiles = '<%=existingfilelist%>';
						console.log("existing files ??"+existringfiles );
						var filedataset=new Array();
						<%
							for(int g=0;g<existingfilelist.size();g++){
								String[] fileinfo = (String[])existingfilelist.get(g);
								String fileid = fileinfo[0];
								String filename = fileinfo[1];
								String filesize = fileinfo[2];
								String filetype = fileinfo[3];
								
								%>
								filedataset.push('"<%=(String)existingfilelist.get(g)%>"');
								if(filenam == <%=filename%>){
									if(filetype == <%=filetype%>){
										
									}
								}
								<%
								
							}
						
						%>
						console.log("filedataset >>"+filedataset); --%>
						
						
						filelistmaintain.push(file.name);
						this.files.push(file);
						
						console.log("file history ??"+filelistmaintain);
						
						
						 sharebutton.addEventListener("click", function (e) {
						 	//alert("click on share");
						 	//alert(fileid);
						 	
							$('#shareModal').modal('show');
							$('#unsharedUsers').html("");
	                        // Make sure the button click doesn't submit the form:
	                        e.preventDefault();
	                        e.stopPropagation();
	                        
	                        $.ajax({
	        					url : "guidanceShareConsumers?fileid="+fileid+"&guidanceid="+guidanceid,
	        					method : 'POST',
	        					success : function(data){
	        						alert(data);
	        						//if(data.success == true){ // if true (1)
	        						     /*  setTimeout(function(){// wait for 5 secs(2)
	        						           location.reload(); // then reload the page.(3)
	        						      }, 5000);  */
	        						  // }
	        						
	        					}
	        				
	        		        }); 
	                        // Remove the file preview.
	                        //this.removeFile(file);
	                        // If you want to the delete the file on the server as well,
	                        // you can do the AJAX request here.
	                    }); 
						file.previewElement.appendChild(sharebutton);
						  removeButton.addEventListener("click", function (e) {
							 	//alert("click on remove");
							 	//alert(fileid);
		                        // Make sure the button click doesn't submit the form:
		                        e.preventDefault();
		                        e.stopPropagation();
		                        // Remove the file preview.
		                        this.removeFile(file);
		                        // If you want to the delete the file on the server as well,
		                        // you can do the AJAX request here.
		                    }); 
						
						 file.previewElement.appendChild(removeButton);
						 
						 file.previewElement.appendChild(downloadButton);
			        }),
			        
			        this.on('sending', function(file, xhr, formData){
			        	var generatedtoken = generateToken();
			        	alert(generatedtoken);
			        	formData.append('token', generatedtoken);
			        }),
			        this.on("success", function(file, response) {
			            console.log(response);
			        }),
			        //this.createThumbnailFromUrl(file, "imageController/" + file.fileid);
			        thisDropzone = this;
					
					//var elements = document.getElementsByName('name');
					
					/* for(var i = 0; i < elements.length; i++)
					{
					  data.push(elements[i].value);
					} */
					//alert(guidanceid)
			        $.getJSON('guidanceShareFiles?', function(dataset) {
			        	 console.log(dataset);
			        	 for(var i = 0; i < dataset.length; i++){
			        		 var datavar = dataset[i];
			        		 var fileid = datavar.fileid;
			        		 var filename = datavar.name;
			        		 var filesize = datavar.size;
			        		 var filetoadd = "";
			        		 var mockFile = { name: filename, size: filesize, fileid: fileid };
			        		 for(var key in filelistmaintain){
									console.log(" inside log >>"+filelistmaintain[key]);
									if(filelistmaintain[key] == filename){
										//this.removeFile(file);
										filetoadd = "true";
									}
									
								}
			        		  if(filetoadd != "true"){	
			        		// alert('val variable '+fileid+' var filename '+filename+'file size ::'+filesize);
				        	    thisDropzone.emit("addedfile", datavar);
				        	    //thisDropzone.options.addedfile.call(thisDropzone, mockFile);
				        	    /* thisDropzone.on("addedfile", function(mockFile) {
				                  mockFile.previewElement.addEventListener("click", function() {
				                    alert("click");
				                  });
				                }); */
				                
				        	    thisDropzone.options.thumbnail.call(thisDropzone, mockFile, "imageController/" + fileid);
						    	thisDropzone.createThumbnailFromUrl(mockFile, "imageController/" + fileid);	
				        	    thisDropzone.emit("complete", mockFile);
				        	    //thisDropzone.files.push(mockFile);
				        	    /* var sharebutton = thisDropzone.option.createElement("<button>Share file</button>");
				        	    thisDropzone.options.previewElement.appendChild(sharebutton); */
			        		 
			        		 
			        	 	}
			        	 }
			        	 	
			        	  
			        	});
				}
			});
			
			noUiSlider.create(slider3, {
		        range: {
					'min': 0,
					'max': 1000
				},
		        start: [264, 776],
		        step: 1,
		        connect: true
		    });

		    slider3.noUiSlider.on('update', function(values){
		        $(".nouislider-value").text(values[0] + " - " + values[1]);
		    });

		    slider3.noUiSlider.on('slide', function(values){
				//var values = $(this).val();
		        $(".nouislider-value").text(values[0] + " - " + values[1]);
			});
		    
		    $("#range-slider-3").ionRangeSlider({
		        min: 0,
		        from: 2.3,
		        max: 10,
		        type: 'single',
		        step: 0.1,
		        postfix: " mm",
		        prettify: false,
		        grid: true,
		        inputValuesSeparator: ';'
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
			
			/* var latitude  = position.coords.latitude;
			 var longitude = position.coords.longitude;
			 var location = latitude + "," + longitude;
			
			var geocoder = new google.maps.Geocoder();
		    geocoder.geocode({'latLng': location}, function(results, status) {
		            if (status == google.maps.GeocoderStatus.OK) {
		                if (results[0]) {
		                    var loc = getCountry(results);
		                    alert(loc)
		                }
		            }
		        }); */

		    

		</script>
	<script type="text/javascript">
		 function  generateToken(param){
			 
			 var stringLength = 15;

				// list containing characters for the random string
				var stringArray = ['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','!','?'];

				//$("#providachieve").click(function (){

					var rndString = "";
				
					// build a string with random characters
					for (var i = 1; i < stringLength; i++) { 
						var rndNum = Math.ceil(Math.random() * stringArray.length) - 1;
						rndString = rndString + stringArray[rndNum];
					};
					
					if(param === "skill"){
						$('#skilltoken').val(rndString);
					}else if(param === "project"){
						$('#projecttoken').val(rndString);
					}
					

				
			 
		 }
				
		 function addachieve(){
				alert("new ");	
				
				var skillname = $('#skill').val();
				 var skilldesc = $('#skilldata').val();
				 var token = $('#skilltoken').val();
				 var userid = '<%=userid%>';
				 var location = $('#locationspec').val();
				 //alert(guidanceid);
				 
				 $.ajax({
						url : "saveSkillToProfile?skillname="+skillname+"&skilldesc="+skilldesc+"&skilltoken="+token+"&userid="+userid+"&location="+location,
						method : 'POST',
						success : function(data){
							alert(data);
							//if(data.success == true){ // if true (1)
							     /*  setTimeout(function(){// wait for 5 secs(2)
							           location.reload(); // then reload the page.(3)
							      }, 5000);  */
							  // }
							
						}
					
			        }); 
				  var elementcolapse = 'collapse'+token;	
				  var element = '<div id='+token+' class="panel panel-default"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#skillset" href="#'+elementcolapse+'"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #1 </a></h4>'+
								'<button class="btn btn-primary" data-toggle="modal" data-target="#addAchievements" onclick="generateToken(skill)">Add New Skill</button></div><div id="'+elementcolapse+'" class="panel-collapse collapse in"><div class="panel-body"></div></div></div>';
				 $('skillset').prepend($(element));
				 
			}	
		 
		 function addproject(){
				
				
				var projectname = $('#projectname').val();
				 var projectskill = $('#projectskill').val();
				 var projectrole = $('#projectrole').val();
				 var projectdata = $('#projectdata').val();
				 var projecttoken = $('#projecttoken').val();
				 var location = $('#locationspec').val();
				 //alert(guidanceid);
				 
				 $.ajax({
						url : "saveProjectToProfile?projectname="+projectname+"&projectskill="+projectskill+"&projectrole="+projectrole+"&projectdata="+projectdata+"&location="+location,
						method : 'POST',
						success : function(data){
							alert(data);
							//if(data.success == true){ // if true (1)
							     /*  setTimeout(function(){// wait for 5 secs(2)
							           location.reload(); // then reload the page.(3)
							      }, 5000);  */
							  // }
							
						}
					
			        }); 
				  var elementcolapse = 'collapse'+projecttoken;	
				  var element = '<div id='+token+' class="panel panel-default"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#projectset" href="#'+elementcolapse+'"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #1 </a></h4>'+
								'<button class="btn btn-primary" data-toggle="modal" data-target="#addAchievements" onclick="generateToken(skill)">Add New Skill</button></div><div id="'+elementcolapse+'" class="panel-collapse collapse in"><div class="panel-body"></div></div></div>';
				 $('projectset').prepend($(element));
				 
			}	
		 
		 
		 function addproject(){
				
				
				var projectname = $('#projectname').val();
				 var projectskill = $('#projectskill').val();
				 var projectrole = $('#projectrole').val();
				 var projectdata = $('#projectdata').val();
				 var projecttoken = $('#projecttoken').val();
				 var location = $('#locationspec').val();
				 //alert(guidanceid);
				 
				 $.ajax({
						url : "saveProjectToProfile?projectname="+projectname+"&projectskill="+projectskill+"&projectrole="+projectrole+"&projectdata="+projectdata+"&location="+location,
						method : 'POST',
						success : function(data){
							alert(data);
							//if(data.success == true){ // if true (1)
							     /*  setTimeout(function(){// wait for 5 secs(2)
							           location.reload(); // then reload the page.(3)
							      }, 5000);  */
							  // }
							
						}
					
			        }); 
				  var elementcolapse = 'collapse'+projecttoken;	
				  var element = '<div id='+token+' class="panel panel-default"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#projectset" href="#'+elementcolapse+'"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #1 </a></h4>'+
								'<button class="btn btn-primary" data-toggle="modal" data-target="#addAchievements" onclick="generateToken(skill)">Add New Skill</button></div><div id="'+elementcolapse+'" class="panel-collapse collapse in"><div class="panel-body"></div></div></div>';
				 $('projectset').prepend($(element));
				 
			}
		 
		 function uploadFormData(){
			   // $('#result').html('');
			 
			   var file2 = $('#fileskill');
			   var token = $('#skilltoken').val();
			   
			  var oMyForm = new FormData();
			  oMyForm.append("file", file2[0].files[0]);
			  oMyForm.append("token", token);
			 
			  $.ajax({
			    url: 'fileUploadSKills?',
			    data: oMyForm,
			    dataType: 'text',
			    processData: false,
			    contentType: false,
			    type: 'POST',
			    success: function(data){
			      alert(data);
			    }
			  });
			  
		 }
		 
		 
		 function uploadProjectData(){
			   // $('#result').html('');
			 
			   var file2 = $('#filenewproject');
			   var token = $('#projecttoken').val();
			   
			  var oMyForm = new FormData();
			  oMyForm.append("file", file2[0].files[0]);
			  oMyForm.append("token", token);
			 
			  $.ajax({
			    url: 'fileUploadSKills?',
			    data: oMyForm,
			    dataType: 'text',
			    processData: false,
			    contentType: false,
			    type: 'POST',
			    success: function(data){
			      alert(data);
			    }
			  });
			  
		 }
		 
		 function uploadProjectNewData(){
			   // $('#result').html('');
			 
			   var file2 = $('#filenewprojectdat');
			   var token = $('#projectnewtoken').val();
			   
			  var oMyForm = new FormData();
			  oMyForm.append("file", file2[0].files[0]);
			  oMyForm.append("token", token);
			 
			  $.ajax({
			    url: 'fileUploadSKills?',
			    data: oMyForm,
			    dataType: 'text',
			    processData: false,
			    contentType: false,
			    type: 'POST',
			    success: function(data){
			      alert(data);
			    }
			  });
			  
		 }
		 
		 function uploadSkillNewData(){
			   // $('#result').html('');
			 
			   var file2 = $('#filenewskill');
			   var token = $('#skillnewtoken').val();
			   
			  var oMyForm = new FormData();
			  oMyForm.append("file", file2[0].files[0]);
			  oMyForm.append("token", token);
			 
			  $.ajax({
			    url: 'fileUploadSKills?',
			    data: oMyForm,
			    dataType: 'text',
			    processData: false,
			    contentType: false,
			    type: 'POST',
			    success: function(data){
			      alert(data);
			    }
			  });
			  
		 }
		
		 function geoFindMe() {
			  //var output = document.getElementById("out");

			  /* if (!navigator.geolocation){
			    output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
			    return;
			  } */

			  function success(position) {
			    var latitude  = position.coords.latitude;
			    var longitude = position.coords.longitude;
			    //alert(longitude);
			    
			    //var location = document.getElementById("location");
			    var location = latitude+","+longitude;
			    $('#locationspec').val(location);
			    //alert(location.value);
			    console.log(location);
			    /* var geocoder = new google.maps.Geocoder();
			    geocoder.geocode({'latLng': location}, function(results, status) {
			            if (status == google.maps.GeocoderStatus.OK) {
			                if (results[0]) {
			                    var loc = getCountry(results);
			                    alert(loc)
			                }
			            }
			        }); */

			    //output.innerHTML = '<p>Latitude is ' + latitude + 'Â° <br>Longitude is ' + longitude + 'Â°</p>';

			    var img = new Image();
			    img.src = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=13&size=300x300&sensor=false";

			    //output.appendChild(img);
			  };

			  function error() {
			    //output.innerHTML = "Unable to retrieve your location";
			  };

			 // output.innerHTML = "<p>Locatingâ¦</p>";

			  navigator.geolocation.getCurrentPosition(success, error);
			}
		 
		 function getCountry(results)
		    {
		        for (var i = 0; i < results[0].address_components.length; i++)
		        {
		        var shortname = results[0].address_components[i].short_name;
		        var longname = results[0].address_components[i].long_name;
		        var type = results[0].address_components[i].types;
		        if (type.indexOf("country") != -1)
		        {
		            if (!isNullOrWhitespace(shortname))
		            {
		                return shortname;
		            }
		            else
		            {
		                return longname;
		            }
		        }
		    }

		}

		function isNullOrWhitespace(text) {
		    if (text == null) {
		        return true;
		    }
		    return text.replace(/\s/gi, '').length < 1;
		}
		
		
		function AddNewAchievement(param){
			$('#skillexistingid').val(param);
			
			var stringLength = 15;

			// list containing characters for the random string
			var stringArray = ['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','!','?'];

			//$("#providachieve").click(function (){

				var rndString = "";
			
				// build a string with random characters
				for (var i = 1; i < stringLength; i++) { 
					var rndNum = Math.ceil(Math.random() * stringArray.length) - 1;
					rndString = rndString + stringArray[rndNum];
				};
				
			$('#skillnewtoken').val(rndString);
			
			$('#skillnewset').modal('show');
		
			//console.log( $(this).attr('id'));
		}
			
		function addOnExistSkillachieve(){
				var skilldata = $('#skillnewdata').val();
				var token = $('#skillnewtoken').val();
				var skillid = $('#skillexistingid').val();
				
				$.ajax({
					url : "saveNewAchievementToSkill?skilldata="+skilldata+"&token="+token+"&skillid="+skillid,
					method : 'POST',
					success : function(data){
						alert(data);
						//if(data.success == true){ // if true (1)
						     /*  setTimeout(function(){// wait for 5 secs(2)
						           location.reload(); // then reload the page.(3)
						      }, 5000);  */
						  // }
						
					}
				
		        }); 
		}
		
		</script>

</body>

</html>