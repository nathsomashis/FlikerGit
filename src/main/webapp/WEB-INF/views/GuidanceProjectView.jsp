<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.fliker.Repository.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
		<%
			String profileimage = (String)request.getAttribute("ProfileImage");
			String gender = (String)request.getAttribute("Gender");
			String profilename = (String)request.getAttribute("FullName");
			String userid = (String)request.getAttribute("userid");
			String logo = "";
			String guidanceid = (String)request.getAttribute("guidanceid");
			ArrayList specificationlist = (ArrayList)request.getAttribute("specificationlist");
		
		%>
		<title> Project Info </title>
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
						 <label class="btn btn-default"> <input type="radio"
							name="activity" id="notifications?"> Notification 
						</label> 
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
					data-toggle="dropdown"><img src="/Fliker/imageFromUserid/<%=userid%>" alt="<%=profilename%>" class="online">
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
				<!-- <div id="speech-btn" class="btn-header transparent pull-right hidden-sm hidden-xs">
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
				</div> -->
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
			<div class="login-info">
			<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

				<a href="javascript:void(0);" id="show-shortcut"
				data-action="toggleShortcut"> <%if(profileimage == ""){
					if(gender.equalsIgnoreCase("female")){
						%> <img src="<c:url value='/resources/img/avatars/female.png' />"
					alt="me" class="online" /> <%
					}else{
						%> <img src="<c:url value='/resources/img/avatars/male.png' />"
					alt="me" class="online" /> <% 
					}
				}else{%> <img src=<%=logo%> alt="me" class="online" /> <%} %> <span><%=profilename%>
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
		<li class="active"><a href="gotoguidance?guidanceid=<%=guidanceid%>"><i	class="fa fa-lg fa-fw fa-puzzle-piece txt-color-blue"></i> <span
				class="menu-item-parent">Guidance Info</span> </a></li>
		<li ><a href="gotoguidancedash?guidanceid=<%=guidanceid%>"><i	class="fa fa-lg fa-fw fa-share-square-o"></i> <span
				class="menu-item-parent">Guidance Dashboard</span> </a></li>		
		<li ><a href="gotoguidanceshare?guidanceid=<%=guidanceid%>"><i	class="fa fa-lg fa-fw fa-share-square-o"></i> <span
				class="menu-item-parent">Guidance Share</span> </a></li>

		<li><a href="gotoguidancecalendar?guidanceid=<%=guidanceid%>"><i class="fa fa-lg fa-fw fa-calendar"></i>
				<span class="menu-item-parent">Guidance Calendar</span> </a></li>
		</li>
		<li><a href="gotoguidanceexcersize?guidanceid=<%=guidanceid%>"><i class="fa fa-lg fa-fw fa-qrcode"></i>
				<span class="menu-item-parent">Guidance Excersize</span> </a></li>
		</li>
		<li><a href="gotoguidanceproject?guidanceid=<%=guidanceid%>"><i class="fa fa-lg fa-fw fa-sitemap"></i>
				<span class="menu-item-parent">Guidance Project</span> </a></li>
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

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Guidance Info</li>
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

				<%
					
					HashMap resourcesSearch = (HashMap)request.getAttribute("resourcesSearch");
					Set resourceset = resourcesSearch.entrySet();
					Iterator resourseit = resourceset.iterator();
					String guidancedescription = "";
					String guidanceprice = "";
					String guidancesubjectexperience = "";
					String companies = "";
					String guidanceachievements="";
					String guidancecostcurrancy = "";
					while(resourseit.hasNext()){
						
						StringBuffer companylst = new StringBuffer();
						LinkedList guidanceendorebylist = new LinkedList();
						LinkedList guidanceachevements = new LinkedList();
						Map.Entry resourceme = (Map.Entry)resourseit.next();
						String keyvalue = (String) resourceme.getKey();
						if (keyvalue.equalsIgnoreCase("guidancedescription")) {
							guidancedescription = (String)resourceme.getValue();
						}else if (keyvalue.equalsIgnoreCase("guidanceprice")) {
							String guidancepr = (String)resourceme.getValue();
							String[] guidanceperstrarr = guidancepr.split(" ");
							guidanceprice = guidanceperstrarr[0];
							if(guidanceperstrarr.length >1){
								guidancecostcurrancy = guidanceperstrarr[1];
							}
						}else if (keyvalue.equalsIgnoreCase("guidancesubjectexperience")) {
							guidancesubjectexperience = (String)resourceme.getValue();
						}else if (keyvalue.equalsIgnoreCase("guidanceendorebylist")) {
							guidanceendorebylist = (LinkedList)resourceme.getValue();
							for(int u=0;u<guidanceendorebylist.size();u++){
								
								HashMap companyinfo = (HashMap)guidanceendorebylist.get(u);
								Set companyset = companyinfo.entrySet();
								Iterator companyit = companyset.iterator();
								while(companyit.hasNext()){
									Map.Entry companyme = (Map.Entry)companyit.next();
									String companyname = (String)companyme.getKey();
									String companylogo = (String)companyme.getValue();
									String companyadd = "<img src='/Fliker/imageFromUserid/"+companylogo+"' data-img='/Fliker/imageFromUserid/"+companylogo+"' alt='"+companyname+"' title='Rome' class='superbox-img'>";
									companylst.append(companyadd);
								}
							}
							
							
						}else if (keyvalue.equalsIgnoreCase("guidanceachevements")) {
							guidanceachevements = (LinkedList)resourceme.getValue();
							StringBuffer achievementbuff = new StringBuffer();
							
							for(int s=0;s<guidanceachevements.size();s++){
								
								String achievementname = "";
								String achievementdescr = "";
								String achievefile = "";
								String achievetoken="";
								
								String achievementdata = (String)guidanceachevements.get(s);
								//achievementdata = achievementdata.replaceAll("{", "");
								//achievementdata = achievementdata.replaceAll("}", "");
								System.out.println(achievementdata);
								
								String[] achievementd = achievementdata.split(",");
								for(int d=0;d<achievementd.length;d++){
									String[] achieveset = achievementd[d].split(":");
									String achievefirst = achieveset[0].replaceAll("\"", "");
									String newachieve = achievefirst.replaceAll("\\{", "");
									System.out.println(newachieve);
									if(newachieve.equalsIgnoreCase("achievement")){
										achievementname = achieveset[1].replaceAll("\"", "");
									}else if(newachieve.equalsIgnoreCase("achievementdescription")){
										achievementdescr = achieveset[1].replaceAll("\"", "");
									}else if(newachieve.equalsIgnoreCase("achievementfile")){
										achievefile = achieveset[1].replaceAll("\"", "");
									}else if(newachieve.equalsIgnoreCase("achievementtoken")){
										achievetoken = achieveset[1].replaceAll("\"", "");
										achievetoken = achievetoken.replaceAll("\\}", "");
									}
									
									
								}
								System.out.println(achievementname+" ::"+achievementdescr+" ::"+achievefile+" ::"+achievetoken);
								String achievementelement = "<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'><a data-toggle='collapse'"+ 
										"data-parent='#accordion-2' href='#"+achievetoken+"'> <i class='fa fa-fw fa-plus-circle txt-color-green'></i> <i class='fa fa-fw fa-minus-circle"+ 
										"txt-color-red'></i>"+achievementname+"</a></h4></div><div id="+achievetoken+" class='panel-collapse collapse'>"+
										"<div class='panel-body'>"+achievementdescr+"</div></div></div>";
										
								achievementbuff.append(achievementelement);		
							}
							
							guidanceachievements = achievementbuff.toString();
						}
						companies = companylst.toString();
					}
					Set<Currency> currencyset = (Set<Currency>)request.getAttribute("currencyset");
					StringBuffer currencylist = new StringBuffer();
					for (Currency s : currencyset) {
						if(s.getCurrencyCode().equalsIgnoreCase(guidancecostcurrancy)){
							currencylist.append("<option id="+s.getCurrencyCode()+" selected='true'>"+s.getCurrencyCode()+"</option>"); 
						}else{
							currencylist.append("<option id="+s.getCurrencyCode()+">"+s.getCurrencyCode()+"</option>"); 
						}
					    System.out.println(s.getCurrencyCode());
					}
					
				%>

				<div class="row">
						
						<!-- NEW WIDGET START -->
						<article class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
				
							
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-fullscreenbutton="false" data-widget-sortable="false">
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
									<span class="widget-icon"> <i class="fa fa-pencil"></i> </span>
									<h2>Description</h2>				
									
								</header>
				
								<!-- widget div-->
								<div>
									<textarea class="form-control" id="guidancedescriptioninfo" name="review" rows="8"><%=guidancedescription%></textarea>
									<!-- widget edit box -->
									<!-- <div class="jarviswidget-editbox">
										This area used as dropdown edit box
										
									</div>
									end widget edit box
									
									widget content
									<div class="widget-body no-padding">
										
											<textarea name="guidanceprojecteditor">
												
				                			</textarea>						
										
									</div> -->
									<!-- end widget content -->
									
								</div>
								<!-- end widget div -->
								
							</div>
							<!-- end widget -->
				
						</article>
						<!-- WIDGET END -->
						
					</div>
					<div class="row">
								
						<div class="col-sm-3">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Experience</span> <input
										class="form-control input-lg"
										placeholder="Total Experience" type="text" name="course" value="<%=guidancesubjectexperience%>"
										id="guidanceexperienceinfo">
										<span class="input-group-addon">Years</span>
								</div>
							</div>
	
						</div>
						
						<div class="col-sm-2">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Price</span> <input
										class="form-control input-lg"
										placeholder="Minimum investment amount or multiple of it.." type="text" name="course" value="<%=guidanceprice%>"
										id="guidancecost">
								</div>
							</div>
	
						</div>
						<div class="col-sm-2">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><select class="form-control" id="costcurrency" >
												<%=currencylist.toString()%>
									</select></span>
								</div>
							</div>
	
						</div>
						<div class="col-sm-2">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><select class="form-control" id="guidancecostduration">
										<option>Month</option>
										<option>Day</option>
									</select>
								</span>
								</div>
							</div>
	
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
							<div  class="panel-group smart-accordion-default" id="specificationlist">
						<%
							if(specificationlist!= null){
								for(int k=0;k<specificationlist.size();k++){
								HashMap specificmap = (HashMap)specificationlist.get(k);
								Set specifset = specificmap.entrySet();
								Iterator speciit = specifset.iterator();
								String specificid = "";
								String specificname = "";
								String specificdesc = "";
								String specificper = "";
								while(speciit.hasNext()){
									Map.Entry specificme = (Map.Entry)speciit.next();
									
									if(((String)specificme.getKey()).equalsIgnoreCase("specificationid")){
										specificid = (String)specificme.getValue();
									}else if(((String)specificme.getKey()).equalsIgnoreCase("specificationname")){
										specificname = (String)specificme.getValue();
									}else if(((String)specificme.getKey()).equalsIgnoreCase("specificationdetails")){
										specificdesc = (String)specificme.getValue();
									}else if(((String)specificme.getKey()).equalsIgnoreCase("specificationpercentage")){
										specificper = (String)specificme.getValue();
									}
									
								}
						%>
							
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"><a data-toggle="collapse" data-parent="#specificationlist" href="#<%=specificid%>"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i><%=specificname%></a></h4>
									</div>
									<div id="<%=specificid%>" class="panel-collapse collapse in">
										<div class="panel-body">
											<input type="text" class="form-control" required id="<%=specificname%>" />
											<textarea id="specificOnedesc" class="form-control" placeholder="Please Describe the specification.." rows="5" required><%=specificdesc%></textarea>
											<div class="col-md-4 inputGroupContainer"><input type="text" class="slider slider-primary" id="g1" value="" data-slider-max="10" data-slider-value="<%=specificper%>"	data-slider-selection = "before" data-slider-handle="round"></div>
											<a class="btn btn-primary btn-xs" href="#" onclick="saveSpecific('<%=specificid%>')">Save</a>
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
					<div class="row">
						<div class="superbox col-sm-9">
							<%=companies%>
						</div>
						<div class="superbox-show" style="height:300px; display: none"></div>
					</div>
					<div class="row">
						<article class="col-sm-9 col-md-9 col-lg-9">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-color-blueLight" id="wid-id-10" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-togglebutton="false" data-widget-deletebutton="false" data-widget-fullscreenbutton="false" data-widget-custombutton="false" data-widget-sortable="false">
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
									<span class="widget-icon"> <i class="fa fa-list-alt"></i> </span>
									<h2>Certification</h2>
				
									<div class="widget-toolbar hidden-phone">
										<div class="smart-form">
											<label class="checkbox">
												<button class="btn btn-primary" data-toggle="modal" data-target="#addachievement" onclick="generateToken()">Provide New Achevements</button>
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
				
										<div class="panel-group smart-accordion-default" id="accordion-2">
											
											<%=guidanceachievements%>
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
						<div class="col-sm-9 col-md-9 col-lg-9">
							<div class="col-md-2">
								<a  href="#" onclick="resetGuidanceInfo()"  class="btn btn-labeled btn-primary"> <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Reset Changes</a>
							</div>
							<div class="col-md-7">
							</div>
							<div class="col-md-2">
								<a  href="#" onclick="saveGuidanceInfo()" class="btn btn-labeled btn-success"> <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Save Changes</a>
							</div>
						</div>
						
					</div>

			</div>
			<!-- END MAIN CONTENT -->
			<div class="modal fade" id="addachievement"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">Provide Achievement</h4>
							</div>
							<div class="modal-body">
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Guidance Subject" required id="guidanceachievement" />
										</div>
										<div class="form-group">
											<textarea id="achievementdescribe" class="form-control" placeholder="Provide Information about your guidance. Why you are good on the above mentioned guidance.." rows="5" required></textarea>
										</div>
										<div class="form-group">
											<form id="form2" method="post" action="#" enctype="multipart/form-data">
											<label class="col-md-2 control-label">File input</label>
											<div class="col-md-10">
												<input type="file" id="file2" name="file2" class="btn btn-default" id="achievementfile">
											</div>
											<button class="col-md-2"  type="button" onclick="uploadFormData()">
												Upload
											</button>
											</form>
											<input type="hidden" class="form-control" value="" required id="acheivetoken" />
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Cancel
								</button>
								<button type="button" class="btn btn-primary" id="addnewachievement" onclick="addachieve()">
									Add
								</button>
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
					<!-- <span class="txt-color-white">SmartAdmin 1.8.2 </span> -->
				</div>

				<!-- <div class="col-xs-6 col-sm-6 text-right hidden-xs">
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
				</div> -->
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
		
		<%-- <script src="<c:url value='/resources/js/plugin/ckeditor/ckeditor.js' />"></script>
		<script src="http://malsup.github.com/jquery.form.js"></script> --%>

		<script>
			$(document).ready(function() {

				// DO NOT REMOVE : GLOBAL FUNCTIONS!
				pageSetUp();

				/*
				 * PAGE RELATED SCRIPTS
				 */

				 /* CKEDITOR.replace( 'guidanceprojecteditor', {
						height: 300,
						startupFocus : true,
						// Configure your file manager integration. This example uses CKFinder 3 for PHP.
						filebrowserBrowseUrl: '/ckfinder/ckfinder.html',
						filebrowserImageBrowseUrl: '/ckfinder/ckfinder.html?type=Images',
						filebrowserUploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
						filebrowserImageUploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images'
					} ); */
				
				 $('.superbox').SuperBox();
				 
				 $('#addnewachievement').click(function() {
					 alert("new");
					 
					 
				 }); 
				 
				 
				

			});

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
			
			
			 function uploadFormData(){
				   // $('#result').html('');
				 
				   var file2 = $('#file2');
				   var token = $('#acheivetoken').val();
				   
				  var oMyForm = new FormData();
				  oMyForm.append("file", file2[0].files[0]);
				  oMyForm.append("token", token);
				 
				  $.ajax({
				    url: 'fileUploadAchieve?',
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
			 
			 function  generateToken(){
				 
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
						
						$('#acheivetoken').val(rndString);

					
				 
			 }
					
			function addachieve(){
				alert("new ");	
				
				var achievementname = $('#guidanceachievement').val();
				 var achevedesc = $('#achievementdescribe').val();
				 var token = $('#acheivetoken').val();
				 var guidanceid = '<%=guidanceid%>';
				 alert(guidanceid);
				 
				 $.ajax({
						url : "saveguidanceinfoachievement?guidanceachievement="+achievementname+"&achievementdescribe="+achevedesc+"&acheivetoken="+token+"&guidanceid="+guidanceid,
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
				  var element = '<div id='+token+' class="panel panel-default"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#'+elementcolapse+'"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Collapsible Group Item #1 </a></h4>'+
								'</div><div id="'+elementcolapse+'" class="panel-collapse collapse in"><div class="panel-body"></div></div></div>';
				 $('accordion-2').prepend($(element));
				 
			}
			
			
			function saveGuidanceInfo(){
				var guidancedesc = $('#guidancedescriptioninfo').val();
				var guidanceexperience=	$('#guidanceexperienceinfo').val();
				var guidancecost = $('#guidancecost').val();
				var guidancecostcurrency = $('#costcurrency :selected').text();
				var guidancecostper = $('#guidancecostduration :selected').text();
				var guidanceid = '<%=guidanceid%>';
				
				
				$.ajax({
					url : "saveguidanceinfo?guidancedesc="+guidancedesc+"&guidanceexperience="+guidanceexperience+"&guidancecost="+guidancecost+"&guidancecostcurrency="+guidancecostcurrency+"&guidancecostper="+guidancecostper+"&guidanceid="+guidanceid,
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
			
			function resetGuidanceInfo(){
				$('#guidancedescriptioninfo').val('<%=guidancedescription%>');
				$('#guidanceexperienceinfo').val('<%=guidancesubjectexperience%>');
				$('#guidancecost').val('<%=guidanceprice%>');
				$('#costcurrency :selected').text('<%=guidancecostcurrancy%>');
				$('#guidancecostduration :selected').text();
				
			
			}
			
			function saveSpecific(specificid){
				alert("mo");
				
			}

		</script>

	</body>

</html>