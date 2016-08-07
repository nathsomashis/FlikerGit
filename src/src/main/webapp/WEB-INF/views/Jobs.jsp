<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<title> Jobs </title>
		<meta name="description" content="">
		<meta name="author" content="">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/bootstrap.min.css" />'>
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/font-awesome.min.css" />'>

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/smartadmin-production-plugins.min.css" />' >
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/smartadmin-production.min.css" />'>
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/smartadmin-skins.min.css" />'>

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/assets/css/smartadmin-rtl.min.css" />' > 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<!-- <link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css"> -->

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href='<c:url value="/resources/assets/img/favicon/favicon.ico" />' type="image/x-icon">
		<link rel="icon" href='<c:url value="/resources/assets/img/favicon/favicon.ico" />' type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href='<c:url value="/resources/assets/img/splash/sptouch-icon-iphone.png" />' >
		<link rel="apple-touch-icon" sizes="76x76" href='<c:url value="/resources/assets/img/splash/touch-icon-ipad.png" />' >
		<link rel="apple-touch-icon" sizes="120x120" href='<c:url value="/resources/assets/img/splash/touch-icon-iphone-retina.png" />' >
		<link rel="apple-touch-icon" sizes="152x152" href='<c:url value="/resources/assets/img/splash/touch-icon-ipad-retina.png" />' >
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href='<c:url value="/resources/assets/img/splash/ipad-landscape.png" />'  media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href='<c:url value="/resources/assets/img/splash/ipad-portrait.png" />'  media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href='<c:url value="/resources/assets/img/splash/iphone.png" />' media="screen and (max-device-width: 320px)">

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
			<%-- <div class="container">

			<!-- Section: #MENU -->
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>Menu</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li class="gn-search-item">
									<input placeholder="Search" type="search" class="gn-search">
									<a class="gn-icon gn-icon-search"><span>Search</span></a>
								</li>
								<li>
									<a href="#screenshots" class="gn-icon gn-icon-pictures">Screenshots</a>
								</li>
								<li>
									<a href="#updates" class="gn-icon gn-icon-cog">Updates</a>
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<li class="hidden-xs">
					<a href="hello?"><img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="logo" style="width: 135px; margin-top: -4px;" /></a>
				</li>
				<li>
					<ul class="company-social">
						<li class="social-facebook" style="width: 120px;background-color:transparent;color: black;">
							<a href="hello?" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">Home</a>
						</li>
						<li class="social-twitter" style="width: 120px;background-color:transparent;color: black;">
							<a href="#" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">Skills</a>
						</li>
						<li class="social-dribble" style="width: 120px;background-color:transparent;color: black;">
							<a href="jobs?" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">Jobs</a>
						</li>
						<li class="social-google" style="width: 120px;background-color:transparent;color: black;">
							<a href="javascript:void(0);" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">DashBoard</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- Section: #MENU -->
		
		</div> --%>

		</header>
		<!-- END HEADER -->

		

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<!-- <div id="ribbon">

				<span class="ribbon-button-alignment"> 
					<span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true">
						<i class="fa fa-refresh"></i>
					</span> 
				</span>

				breadcrumb
				<ol class="breadcrumb">
					<li>Home</li><li>App Views</li><li>Projects</li>
				</ol>
				end breadcrumb

				You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span>

			</div> -->
			<!-- END RIBBON -->
			
			

			<!-- MAIN CONTENT -->
			<div id="content">
				<button onclick="searchAjax();">Click</button>
				<!-- row -->
				<div class="row">
					
					<!-- col -->
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark">
							
							<!-- PAGE HEADER -->
							<i class="fa-fw fa fa-puzzle-piece"></i> 
								App Views 
							<span>>  
								Project
							</span>
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
						<!-- end sparks -->
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
				<section id="widget-grid" class="">

					<!-- row -->
					<div class="row">
						
						<!-- NEW WIDGET START -->
						<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							
							<div class="alert alert-info">
								<strong>NOTE:</strong> All the data is loaded from a seperate JSON file
							</div>

							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget well" id="wid-id-0">
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
									<span class="widget-icon"> <i class="fa fa-comments"></i> </span>
									<h2>Widget Title </h2>				
									
								</header>

								<!-- widget div-->
								<div>
									
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
										<input class="form-control" type="text">	
									</div>
									<!-- end widget edit box -->
									
									<!-- widget content -->
									<div class="widget-body no-padding">
										
										<table id="example" class="display projects-table table table-striped table-bordered table-hover" cellspacing="0" width="100%">
									        <thead>
									            <tr>
									                <th></th><th>Projects</th><th><i class="fa fa-fw fa-user text-muted hidden-md hidden-sm hidden-xs"></i> EST</th>
									                <th>Contacts</th>
									                <th>Status</th>
									                <th><i class="fa fa-circle txt-color-darken font-xs"></i> Target/ <i class="fa fa-circle text-danger font-xs"></i> Actual</th>
									                <th><i class="fa fa-fw fa-calendar text-muted hidden-md hidden-sm hidden-xs"></i> Starts</th>
									                <th><i class="fa fa-fw fa-calendar text-muted hidden-md hidden-sm hidden-xs"></i> Ends</th>
									                <th>Tracker</th>
									            </tr>
									        </thead>
									    </table>

									</div>
									<!-- end widget content -->
									
								</div>
								<!-- end widget div -->
								
							</div>
							<!-- end widget -->

						</article>
						<!-- WIDGET END -->
						
					</div>

					<!-- end row -->

					<!-- row -->

					<div class="row">

						<!-- a blank row to get started -->
						<div class="col-sm-12">
							<!-- your contents here -->
						</div>
							
					</div>

					<!-- end row -->

				</section>
				<!-- end widget grid -->
		
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
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="<c:url value='/resources/assets/js/plugin/pace/pace.min.js' />"></script>

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
		<script src="<c:url value='/resources/assets/js/app.config.js' />"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="<c:url value='/resources/assets/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js' />" ></script> 

		<!-- BOOTSTRAP JS -->
		<script src="<c:url value='/resources/assets/js/bootstrap/bootstrap.min.js' />" ></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="<c:url value='/resources/assets/js/notification/SmartNotification.min.js' />" ></script>

		<!-- JARVIS WIDGETS -->
		<script src="<c:url value='/resources/assets/js/smartwidgets/jarvis.widget.min.js' />" ></script>

		<!-- EASY PIE CHARTS -->
		<script src="<c:url value='/resources/assets/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js' />" ></script>

		<!-- SPARKLINES -->
		<script src="<c:url value='/resources/assets/js/plugin/sparkline/jquery.sparkline.min.js' />" ></script>

		<!-- JQUERY VALIDATE -->
		<script src="<c:url value='/resources/assets/js/plugin/jquery-validate/jquery.validate.min.js' />" ></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="<c:url value='/resources/assets/js/plugin/masked-input/jquery.maskedinput.min.js' />" ></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="<c:url value='/resources/assets/js/plugin/select2/select2.min.js' />" ></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="<c:url value='/resources/assets/js/plugin/bootstrap-slider/bootstrap-slider.min.js' />" ></script>

		<!-- browser msie issue fix -->
		<script src="<c:url value='/resources/assets/js/plugin/msie-fix/jquery.mb.browser.min.js' />" ></script>

		<!-- FastClick: For mobile devices -->
		<script src="<c:url value='/resources/assets/js/plugin/fastclick/fastclick.min.js' />" ></script>

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

		<!-- Demo purpose only -->
		<!-- <script src="js/demo.min.js"></script> -->

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value='/resources/assets/js/app.min.js' />" ></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="<c:url value='/resources/assets/js/speech/voicecommand.min.js' />" ></script>

		<!-- SmartChat UI : plugin -->
		<script src="<c:url value='/resources/assets/js/smart-chat-ui/smart.chat.ui.min.js' />" ></script>
		<script src="<c:url value='/resources/assets/js/smart-chat-ui/smart.chat.manager.min.js' />" ></script>

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		<script src="<c:url value='/resources/assets/js/plugin/datatables/jquery.dataTables.min.js' />" ></script>
		<script src="<c:url value='/resources/assets/js/plugin/datatables/dataTables.colVis.min.js' />" ></script>
		<script src="<c:url value='/resources/assets/js/plugin/datatables/dataTables.tableTools.min.js' />" ></script>
		<script src="<c:url value='/resources/assets/js/plugin/datatables/dataTables.bootstrap.min.js' />" ></script>
		<script src="<c:url value='/resources/assets/js/plugin/datatable-responsive/datatables.responsive.min.js' />" ></script>

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
				
				/* Formatting function for row details - modify as you need */
				function format ( d ) {
				    // `d` is the original data object for the row
				    return '<table cellpadding="5" cellspacing="0" border="0" class="table table-hover table-condensed">'+
				        '<tr>'+
				            '<td style="width:100px">Project Title:</td>'+
				            '<td>'+d.name+'</td>'+
				        '</tr>'+
				        '<tr>'+
				            '<td>Deadline:</td>'+
				            '<td>'+d.ends+'</td>'+
				        '</tr>'+
				        '<tr>'+
				            '<td>Extra info:</td>'+
				            '<td>And any further details here (images etc)...</td>'+
				        '</tr>'+
				        '<tr>'+
				            '<td>Comments:</td>'+
				            '<td>'+d.comments+'</td>'+
				        '</tr>'+
				        '<tr>'+
				            '<td>Action:</td>'+
				            '<td>'+d.action+'</td>'+
				        '</tr>'+
				    '</table>';
				}

				// clears the variable if left blank
			    var table = $('#example').DataTable( {
			    	"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-12 hidden-xs'l>r>"+
						"t"+
						"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
			        "ajax": "jobs/getJobsList?",
			        "bDestroy": true,
			        "iDisplayLength": 15,
			        "oLanguage": {
					    "sSearch": '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
					},
			        "columns": [
			            {
			                "class":          'details-control',
			                "orderable":      false,
			                "data":           null,
			                "defaultContent": ''
			            },
			            { "data": "name" },
			            { "data": "est" },
			            { "data": "contacts" },
			            { "data": "status" },
			            { "data": "target-actual" },
			            { "data": "starts" },
			            { "data": "ends" },
			            { "data": "tracker" },
			        ],
			        "order": [[1, 'asc']],
			        "fnDrawCallback": function( oSettings ) {
				       runAllCharts()
				    }
			    } );


			     
			    // Add event listener for opening and closing details
			    $('#example tbody').on('click', 'td.details-control', function () {
			        var tr = $(this).closest('tr');
			        var row = table.row( tr );
			 
			        if ( row.child.isShown() ) {
			            // This row is already open - close it
			            row.child.hide();
			            tr.removeClass('shown');
			        }
			        else {
			            // Open this row
			            row.child( format(row.data()) ).show();
			            tr.addClass('shown');
			        }
			    });

			})
		
			function searchAjax() {
				var data = {}
				data["query"] = $("#query").val();
				
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "jobs/getJobsList?",
					data : JSON.stringify(data),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						display(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
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