<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>  
    <html>
<head>
<title>系统登陆</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="HerbChain Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/mainStyles.css" />
		<link rel='stylesheet' href='css/dscountdown.css' type='text/css' media='all' />

<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
<!-- gallery -->
<link href="css/lsb.css" rel="stylesheet" type="text/css">
<!-- //gallery -->
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
 
<!-- start-smooth-scrolling -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
</head>	
<body>
<!-- banner -->
<div class="header">
		
		<div class="w3layouts_header_right">
			<div class="detail-w3l">
			<ul>
				<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i> + 400-000-000</li>
				
			</ul>
		</div>

		</div>

		<div class="agileits-social top_content">
						<ul>
					
						</ul>
					</div>

		<div class="clearfix"> </div>
	</div>

	<div class="banner">
		<nav class="navbar navbar-default">
			<div class="navbar-header navbar-left">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<h1><a class="navbar-brand" href="Main.jsp"><span></span>药材溯源系统</a></h1>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
			<li class="active"><a href="welcome.jsp"><span data-hover="Visitor">游客模式</span></a></li>
			
			</div>
			
		</nav>
		</div>

<!-- //banner -->	
<div class="skills w3-agileits w3-services-page">
		<div class="container"> 
			<div class="skills-agileinfo">
<center>
				<h4>请输入账户及密码</h4>		
				<form action="user/login.action"  method="post">
				<label>账户：</label>				
				<input type="text" id="username" name="username" ><br/><br/>
				<label>密码：</label>				
				<input type="password" id="password" name="password" ><br/>
				${error }
				<br/>
				
				<input type="submit" value="登陆" />
				</form>
</center>
</div></div></div>
<!-- /footer-contact -->
<div class="w3-footer-contact">
	<div class="container">
		<div class="col-md-4 w3-footer-contact-left">
			<h3>南开大学</h3>
			<p>南开大学计算机学院可信智能计算系统研究室.</p>
		</div>
		<div class="col-md-4 w3-footer-contact-middle">
		<img src="images/v11.jpg" height="300" width="350"  alt="img">
		</div>
		<div class="col-md-4 w3-footer-contact-right">
			<div class="col-md-2 w3-footer-contact-icon1">
			<i class="fa fa-map-marker" aria-hidden="true"></i>	
			</div>
			<div class="col-md-10 w3-footer-contact-info">
			<p>Location:</p>
			<h4>天津市海河教育园区<br/>同砚路38号<br/>南开大学理科组团<br/>计算机学院</h4>
					
			</div>
			<div class="clearfix"></div>
			<div class="col-md-2 w3-footer-contact-icon1">
			</div>
			<div class="col-md-10 w3-footer-contact-info">
					
			</div>
			<div class="clearfix"></div>
			<div class="col-md-2 w3-footer-contact-icon1">
			<i class="fa fa-envelope" aria-hidden="true"></i>
			</div>
			<div class="col-md-10 w3-footer-contact-info">
			<p>Email:</p>
			<h4><a href="mailto:example@mail.com"> luye@nankai.edu.cn</a></h4>
					
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
		<br/><br/>


</div>

<!-- //footer-contact -->
<div class="footer-final">
		<div class="copyw3-agile"> 
			<div class="container">
				<p>&copy; 2018 HerbChain. All rights reserved | Design by NKU</a></p>
			</div>
		</div>
	</div>


<script src="js/mainScript.js"></script>
<script src="js/rgbSlide.min.js"></script>


<!--team-->
<script type="text/javascript">
							$(window).load(function() {
								$("#flexiselDemo1").flexisel({
									visibleItems:4,
									animationSpeed: 1000,
									autoPlay: true,
									autoPlaySpeed: 3000,    		
									pauseOnHover: true,
									enableResponsiveBreakpoints: true,
									responsiveBreakpoints: { 
										portrait: { 
											changePoint:480,
											visibleItems: 1
										}, 
										landscape: { 
											changePoint:640,
											visibleItems:2
										},
										tablet: { 
											changePoint:768,
											visibleItems: 3
										}
									}
								});
								
							});
					</script>
					<script type="text/javascript" src="js/jquery.flexisel.js"></script>
<!--team-->
<!-- //here ends scrolling icon -->
 
				<script type="text/javascript">
					$(document).ready(function() {
					/*
						var defaults = {
						containerID: 'toTop', // fading element id
						containerHoverID: 'toTopHover', // fading element hover id
						scrollSpeed: 1200,
						easingType: 'linear' 
						};
					*/								
					$().UItoTop({ easingType: 'easeOutQuart' });
					});
				</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
				<script src="js/SmoothScroll.min.js"></script>
 <!-- start-smoth-scrolling -->
				<script type="text/javascript" src="js/move-top.js"></script>
				<script type="text/javascript" src="js/easing.js"></script>
				
		<!-- start-smoth-scrolling -->
<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->

</body>
</html>