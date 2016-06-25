<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Home</title>

		<!-- #Bootstrap Core CSS -->
		<link href='<c:url value="/resources/css/bootstrap.min.css" />' rel="stylesheet">
		

		<!-- #SLIDER REVOLUTION 4.x CSS SETTINGS -->
		<link href='<c:url value="/resources/css/extralayers.css" />' rel="stylesheet">
		<link href='<c:url value="/resources/css/settings.css" />' rel="stylesheet">
		<!-- <link rel="stylesheet" type="text/css" href="css/settings.css" media="screen"> -->

		<!-- #RELATED CSS -->
		<link href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
		<link href='<c:url value="/resources/css/nivo-lightbox.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="css/nivo-lightbox.css" rel="stylesheet"> -->
		<link href='<c:url value="/resources/css/nivo-lightbox-theme/default/default.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="css/nivo-lightbox-theme/default/default.css" rel="stylesheet"> -->
		<link href='<c:url value="/resources/css/animate.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="css/animate.css" rel="stylesheet"> -->

		<!-- #SMARTADMIN LANDING CSS -->
		<link href='<c:url value="/resources/css/main.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="css/main.css" rel="stylesheet"> -->
		<link href='<c:url value="/resources/color/default.css" />' rel="stylesheet">
		<!-- <link type="text/css" href="color/default.css" rel="stylesheet"> -->

		<!-- #FAVICONS -->
		<link href='<c:url value="/resources/img/favicon/favicon.ico" />' rel="shortcut icon" type="image/x-icon">
		<!-- <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->
		<link href='<c:url value="/resources/img/favicon/favicon.ico" />' rel="icon" type="image/x-icon">
		<!-- <link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon"> -->

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

	</head>

	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #MENU                                                      |
	|  02. #INTRO                                                     |
	|  03. #PRICING                                                   |
	|  04. #TEAM                                                      |
	|  05. #FEATURES                                                  |
	|  06. #SCREENSHOT                                                |
	|  07. #UPDATES                                                   |
	|  08. #QUOTES                                                    |
	|  09. #CONTACT                                                   |
	|  10. #BOTTOM CONTENT                                            |
	|  11. #FOOTER                                                    |
	|  12. #Core Javascript                                           |
	|  13. #REVOLUITION SLIDER                                        |
	|  14. #PAGE SCRIPT                                               |
	
	===================================================================
	
	-->

	<body data-spy="scroll">

		


		<div class="container">

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
							<a href="course?id=" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">Skills</a>
						</li>
						<li class="social-dribble" style="width: 120px;background-color:transparent;color: black;">
							<a href="jobs?" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">Jobs</a>
						</li>
						<li class="social-google" style="width: 120px;background-color:transparent;color: black;">
							<a href="dashboard?" target="_self" style="background-color: transparent;font-size: 20px;color: black;text-align: center;">DashBoard</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- Section: #MENU -->
		
		</div>

		
		<!-- /Section: FEATURES -->

		<!-- Section: #SCREENSHOT -->
		<section id="screenshots" class="home-section text-center bg-gray">
			<div class="heading-works marginbot-50">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">

							<div class="section-heading">
								<h2>Screenshots</h2>
								<p>
									Lorem ipsum dolor sit amet, no nisl mentitum recusabo per, vim at blandit qualisque dissentiunt. Diam efficiantur conclusionemque ut has
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="container">

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12" >

						<div class="row gallery-item">
							<div class="col-md-3">
								<a href='<c:url value="/resources/img/works/1.jpg" />' title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi='<c:url value="/resources/img/works/1@2x.jpg" />'> <img src='<c:url value="/resources/img/works/1.jpg" />' class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/2.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/2.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/3.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/3.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/4.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/4.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/5.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/5.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/6.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/6.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/7.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/7.jpg" class="img-responsive" alt="img"> </a>
							</div>
							<div class="col-md-3">
								<a href="<%=request.getContextPath()%>/resources/img/works/8.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="<%=request.getContextPath()%>/resources/img/works/1@2x.jpg"> <img src="<%=request.getContextPath()%>/resources/img/works/8.jpg" class="img-responsive" alt="img"> </a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</section>
		<!-- /Section: SCREENSHOT -->

		<!-- Section: #UPDATES -->
		<section id="updates" class="home-section text-center">
			<div class="heading-contact marginbot-50">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">

							<div class="section-heading">
								<h2>Fliker</h2>
								<p>
									Study --> Skill --> Career --> Share --> Analyse.
								</p>
								<p>
									Its just a way to free think the education and career.
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="row">
					<div class="timeline-centered">
			    
				<article class="timeline-entry">
					
					<div class="timeline-entry-inner">
						<time class="timeline-time" datetime="2014-01-10T03:45"><span>Student</span></time>
						
						<div class="timeline-icon bg-success">
							<i class="entypo-feather"></i>
						</div>
						
						<div class="timeline-label">
							<h2><a href="#">Student:</a> </h2>
							<p>Learning Course and Skills. Sharing the same in profile. Apply for Jobs or Create your own organization of your skills. Visualise your progress and make desicive steps.</p>
						</div>
					</div>
					
				</article>
				
				
				<article class="timeline-entry left-aligned">
					
					<div class="timeline-entry-inner">
						<time class="timeline-time" datetime="2014-01-10T03:45"><span>Teacher</span> <span>4 weeks ago</span></time>
						
						<div class="timeline-icon bg-secondary">
							<i class="entypo-suitcase"></i>
						</div>
						
						<div class="timeline-label">
							<h2><a href="#">SmartAdmin goes public!</a></h2>
							<p>Yahoo buys a share in <strong>SmartAdmin</strong></p>
						</div>
					</div>
					
				</article>
				
				
				<article class="timeline-entry">
					
					<div class="timeline-entry-inner">
						<time class="timeline-time" datetime="2014-01-09T13:22"><span>03:45 AM</span> <span>3 months ago</span></time>
						
						<div class="timeline-icon bg-info">
							<i class="entypo-location"></i>
						</div>
						
						<div class="timeline-label">
							<h2><a href="#">SmartAdmin Convention</a> <span>checked in at</span> <a href="#">Laborator</a></h2>
							
							<blockquote>Place was booked till 3am!</blockquote>
							
							<img src="<%=request.getContextPath()%>/resources/img/map.png" alt="map" class="img-responsive">


						</div>
					</div>
					
				</article>
				
				
				<article class="timeline-entry left-aligned">
					
					<div class="timeline-entry-inner">
						<time class="timeline-time" datetime="2014-01-10T03:45"><span>03:45 AM</span> <span>8 months ago</span></time>
						
						<div class="timeline-icon bg-warning">
							<i class="entypo-camera"></i>
						</div>
						
						<div class="timeline-label">
							<h2><a href="#">We have lift off!</a></h2>
							
							<blockquote>SmartAdmin Launched with grace and beauty</blockquote>

						</div>
					</div>
					
				</article>
				
				
				<article class="timeline-entry begin">
				
					<div class="timeline-entry-inner">
						
						<div class="timeline-icon" style="-webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg);">
							<i class="entypo-flight"></i>
						</div>
						
					</div>
					
				</article>
				
			</div>
				</div>
			</div>
		</section>
		<!-- /Section: UPDATES -->

		<!-- Section: #QUOTES -->
		<section id="quotes" class="home-section text-center bg-gray">
			
				<div class="container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
			                <div class="quote"><i class="fa fa-quote-left fa-4x"></i></div>
							<div class="carousel slide" id="fade-quote-carousel" data-ride="carousel" data-interval="3000">
							  <!-- Carousel indicators -->
			                  <ol class="carousel-indicators">
							    <li data-target="#fade-quote-carousel" data-slide-to="0" class="active"></li>
							    <li data-target="#fade-quote-carousel" data-slide-to="1"></li>
							    <li data-target="#fade-quote-carousel" data-slide-to="2"></li>
							  </ol>
							  <!-- Carousel items -->
							  <div class="carousel-inner">
							    <div class="active item">
							    	<blockquote>
							    		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, veritatis nulla eum laudantium totam tempore optio doloremque laboriosam quas.</p>
							    	</blockquote>
							    	<div class="profile-circle" style="background-color: rgba(0,0,0,.2);"></div>
							    </div>
							    <div class="item">
							    	<blockquote>
							    		<p>Lorem ipsum dolor sit amet, eaque molestias odio aut eius animi. Impedit temporibus nisi accusamus.</p>
							    	</blockquote>
							    	<div class="profile-circle" style="background-color: rgba(77,5,51,.2);"></div>
							    </div>
							    <div class="item">
							    	<blockquote>
							    		<p>Consectetur adipisicing elit. Quidem, veritatis  aut eius animi. Impedit temporibus nisi accusamus.</p>
							    	</blockquote>
							    	<div class="profile-circle" style="background-color: rgba(145,169,216,.2);"></div>
							    </div>
							  </div>
							</div>
						</div>							
					</div>
				</div>
			
		</section>
		<!-- /Section: QUOTES -->

		<!-- Section: #CONTACT -->
		<!-- <section id="contact" class="home-section text-center">
			<div class="heading-contact marginbot-50">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">

							<div class="section-heading">
								<h2>Get in touch</h2>
								<p>
									Lorem ipsum dolor sit amet, no nisl mentitum recusabo per, vim at blandit qualisque dissentiunt. Diam efficiantur conclusionemque ut has
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="container">

				<div class="row">
					<div class="col-lg-8 col-md-offset-2">
						<div class="boxed-grey">
							<form id="contact-form">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="name"> Name</label>
											<input type="text" class="form-control" id="name" placeholder="Enter name" required="required" />
										</div>
										<div class="form-group">
											<label for="email"> Email Address</label>
											<div class="input-group">
												<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span> </span>
												<input type="email" class="form-control" id="email" placeholder="Enter email" required="required" />
											</div>
										</div>
										<div class="form-group">
											<label for="subject"> Subject</label>
											<select id="subject" name="subject" class="form-control" required="required">
												<option value="">Choose One:</option>
												<option value="service">General Customer Service</option>
												<option value="suggestions">Suggestions</option>
												<option value="product">Product Support</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="name"> Message</label>
											<textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required" placeholder="Message"></textarea>
										</div>
									</div>
									<div class="col-md-12">
										<button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
											Send Message
										</button>
									</div>
								</div>
							</form>
						</div>

						<div class="widget-contact row">
							<div class="col-lg-6">
								<address>
									<strong>SMARTADMIN Ltd.</strong>
									<br>
									Big Villa 334 Awesome, Beautiful Suite 1200
									<br>
									San Francisco, CA 94107
									<br>
									<abbr title="Phone">P:</abbr> (123) 456-7890
								</address>
							</div>

							<div class="col-lg-6">
								<address>
									<strong>Email</strong>
									<br>
									<a href="mailto:#">email.name@example.com</a>
									<br />
									<a href="mailto:#">name.name@example.com</a>
								</address>

							</div>
						</div>
					</div>

				</div>

			</div>
		</section> -->
		<!-- /Section: CONTACT -->

		<!-- #BOTTOM CONTENT -->
		<!-- <div class="bottom-content">
			<div class="container custom-container text-center">
				<h2>We Always Try to Create a Difference</h2>
				<p>
					Thank you for buying this template :)
				</p>
				Provides extra visual weight and identifies the primary action in a set of buttons
				<a href="https://bootstraphunter.com" class="btn btn-default btn-lg purchase">Purchase SmartAdmin</a>
			</div>
		</div> -->
		<!-- /#BOTTOM CONTENT -->

		<!-- #FOOTER -->
		
		<!-- / #FOOTER -->

		<!-- # Core JavaScript Files -->

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');
			}
		</script>

		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>


		<!-- BOOTSTRAP JS -->
		<script src="<c:url value='/resources/js/bootstrap/bootstrap.min.js' />"></script>
		<!-- <script src="js/bootstrap/bootstrap.min.js"></script> -->

		<!--# JS PLUGINS -->
		<script src="<c:url value='/resources/js/plugins/classie.js' />"></script>
		<!-- <script src="js/plugins/classie.js"></script> -->
		<script src="<c:url value='/resources/js/plugins/gnmenu.js' />"></script>
		<!-- <script src="js/plugins/gnmenu.js"></script> -->
		<script src="<c:url value='/resources/js/plugins/jquery.scrollUp.js' />"></script>
		<!-- <script src="js/plugins/jquery.scrollUp.js"></script> -->
		<script src="<c:url value='/resources/js/plugins/nivo-lightbox.min.js' />"></script>
		<!-- <script src="js/plugins/nivo-lightbox.min.js"></script> -->
		<script src="<c:url value="/resources/js/plugins/smoothscroll.js" />"></script>
		<!-- <script src="js/plugins/smoothscroll.js"></script> -->
		<script src="<c:url value="/resources/js/plugins/jquery.themepunch.plugins.min.js" />"></script>
		<!-- <script src="js/plugins/jquery.themepunch.plugins.min.js"></script> -->
		<script src="<c:url value="/resources/js/plugins/jquery.themepunch.revolution.min.js" />"></script>
		<!-- <script src="js/plugins/jquery.themepunch.revolution.min.js"></script> -->

		<!-- # Custom Theme JavaScript -->
		<script src="<c:url value="/resources/js/custom.js" />"></script>
		<!-- <script src="js/custom.js"></script> -->

		<!-- #PAGE SCRIPT -->
		<script type="text/javascript">
			jQuery(document).ready(function() {

				jQuery('.tp-banner').show().revolution({
					dottedOverlay : "none",
					delay : 8000,
					startwidth : 1170,
					startheight : 700,
					hideThumbs : 200,

					thumbWidth : 100,
					thumbHeight : 50,
					thumbAmount : 5,

					navigationType : "bullet",
					navigationArrows : "solo",
					navigationStyle : "preview4",

					touchenabled : "on",
					onHoverStop : "off",

					swipe_velocity : 0.7,
					swipe_min_touches : 1,
					swipe_max_touches : 1,
					drag_block_vertical : false,

					parallax : "mouse",
					parallaxBgFreeze : "on",
					parallaxLevels : [7, 4, 3, 2, 5, 4, 3, 2, 1, 0],

					keyboardNavigation : "off",

					navigationHAlign : "center",
					navigationVAlign : "bottom",
					navigationHOffset : 0,
					navigationVOffset : 20,

					soloArrowLeftHalign : "left",
					soloArrowLeftValign : "center",
					soloArrowLeftHOffset : 20,
					soloArrowLeftVOffset : 0,

					soloArrowRightHalign : "right",
					soloArrowRightValign : "center",
					soloArrowRightHOffset : 20,
					soloArrowRightVOffset : 0,

					shadow : 0,
					fullWidth : "off",
					fullScreen : "on",

					spinner : "spinner4",

					stopLoop : "off",
					stopAfterLoops : -1,
					stopAtSlide : -1,

					shuffle : "off",

					autoHeight : "off",
					forceFullWidth : "off",

					hideThumbsOnMobile : "off",
					hideNavDelayOnMobile : 1500,
					hideBulletsOnMobile : "off",
					hideArrowsOnMobile : "off",
					hideThumbsUnderResolution : 0,

					hideSliderAtLimit : 0,
					hideCaptionAtLimit : 0,
					hideAllCaptionAtLilmit : 0,
					startWithSlide : 0,
					fullScreenOffsetContainer : ""
				});

			});
			//ready

			$.scrollUp();
		</script>

	</body>

</html>
