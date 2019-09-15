<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>  
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="HerbChain Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<title>关于我们</title>
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- //custom-theme -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
   

<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />

<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!--bars -->
<script type="text/javascript">
$(function(){
  $("#bars li .bar").each(function(key, bar){
    var percentage = $(this).data('percentage');

    $(this).animate({
      'height':percentage+'%'
    }, 1000);
  })
})
</script>
<script type="text/javascript">
            function logincheck(){
            	var table="<%=session.getAttribute("username")%>"; 
            	if(table=="null"||table=="")
            		{
            		alert("请先登录!");
    				location.href='${pageContext.request.contextPath}/Login.jsp'
            		}
            	
            };

</script>
<!-- bars -->

<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->

</head>	
<body onload="logincheck()">
<!-- banner -->
<div class="header">
		
		<div class="w3layouts_header_right">
			<div class="detail-w3l">
			<ul>
				<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i> + 4 000-000-0000</li>
				
			</ul>
		</div>

		</div>
		<div class="w3layouts_header_left">
			<ul>
					<li><a href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-user" aria-hidden="true"></i>您好，${username }！</a></li>
					
				</ul>

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
				<nav class="link-effect-2" id="link-effect-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="Main.jsp"><span data-hover="Home">主页</span></a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Search ID">ID查询服务</span> <b class="caret"></b></a>
							<ul class="dropdown-menu agile_short_dropdown">
								<li><a href="Planting.jsp">中药种植</a></li>
								<li><a href="Enterprise.jsp">药材企业</a></li>
								<li><a href="Market.jsp">药材市场</a></li>
								<li><a href="Drinks_Production.jsp">饮片生产</a></li>
								<li><a href="Business.jsp">饮片经营</a></li>
								<li><a href="Test_Report.jsp">质检报告</a></li>
								<li><a href="Use.jsp">饮片使用</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Insert">新增记录</span> <b class="caret"></b></a>
							<ul class="dropdown-menu agile_short_dropdown">
								<li><a href="Planting_insert.jsp">中药种植</a></li>
								<li><a href="Enterprise_insert.jsp">药材企业</a></li>
								<li><a href="Market_insert.jsp">药材市场</a></li>
								<li><a href="Drinks_Production_insert.jsp">饮片生产</a></li>
								<li><a href="Business_insert.jsp">饮片经营</a></li>
								<li><a href="Test_Report_insert.jsp">质检报告</a></li>
								<li><a href="Use_insert.jsp">饮片使用</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span data-hover="Update">记录修改</span> <b class="caret"></b></a>
							<ul class="dropdown-menu agile_short_dropdown">
								<li><a href="Planting_update.jsp">中药种植</a></li>
								<li><a href="Enterprise_update.jsp">药材企业</a></li>
								<li><a href="Market_update.jsp">药材市场</a></li>
								<li><a href="Drinks_Production_update.jsp">饮片生产</a></li>
								<li><a href="Business_update.jsp">饮片经营</a></li>
								<li><a href="Test_Report_update.jsp">质检报告</a></li>
								<li><a href="Use_update.jsp">饮片使用</a></li>
							</ul>
						</li>
						<li><a href="about.jsp"><span data-hover="About Us">关于我们</span></a></li>
					</ul>
				</nav>
			
			</div>
			
		</nav>
		</div>

<!-- //banner -->	
    <div class="banner-multi">
        
    </div>
	<div class="about-breadcrumb">
		<div class="container">
			<ul>
				<li><a href="Main.jsp"><font size=6>主页</font></a><i><font size=6>|</font></i></li>
				<li><font size=6>关于我们</font></li>
			</ul>
		</div>
	</div>


													<!-- //Modal1 -->	
													
<!-- //bootstrap-pop-up -->
<!-- about page -->
	<div class="inner_main_agile_section">
		<div class="container">
				<div class="w3-headings-all">
				<h3>区块链技术</h3>
				</div>
			<div class="agile_inner_grids">
								
				<div class="col-md-6 w3_agileits_about_grid_left">
					<p>区块链技术是利用块链式数据结构来验证与存储数据、利用分布式节点共识算法来生成
						和更新数据、利用密码学的方式保证数据传输和访问的安全、
						利用由自动化脚本代码组成的智能合约来编程和操作数据的一种全新的分布式基础架构与计算范式。简单来讲， 在区块链
						系统中， 每过一段时间， 各参与主体产生的交易数据会被打包成一个数据区块， 数据区块按照时间顺序依次排列， 形成数据区块的链
						条，各参与主体拥有同样的数据链条， 且无法单方面篡改，任何信息的修改只有经过约定比例的主体同意方可进行，并且只能添加新的信息
						，无法删除或修改旧的信息，从而实现多主体间的信息共享和一致决策， 确保各主体身份和主体间交易信息的不可篡改、 公开透明。</span> </p>
					<ul>
						<li><i class="fa fa-long-arrow-right" aria-hidden="true"></i>Speed deliver</li>
						<li><i class="fa fa-long-arrow-right" aria-hidden="true"></i>Interational clients</li>
						<li><i class="fa fa-long-arrow-right" aria-hidden="true"></i>Fast Response</li>
						<li><i class="fa fa-long-arrow-right" aria-hidden="true"></i>Effective Solutions</li>
					</ul>
				</div>
				<div class="col-md-6 w3_agileits_about_grid_right">
					
							  <div id="chart">
							  <ul id="numbers">
								<li><span>100%</span></li>
								<li><span>90%</span></li>
								<li><span>80%</span></li>
								<li><span>70%</span></li>
								<li><span>60%</span></li>
								<li><span>50%</span></li>
								<li><span>40%</span></li>
								<li><span>30%</span></li>
								<li><span>20%</span></li>
								<li><span>10%</span></li>
								<li><span>0%</span></li>
							  </ul>
							  <ul id="bars">
								<li><div data-percentage="2" class="bar"></div><span>2012</span></li>
								<li><div data-percentage="11" class="bar"></div><span>2013</span></li>
								<li><div data-percentage="18" class="bar"></div><span>2014</span></li>
								<li><div data-percentage="36" class="bar"></div><span>2015</span></li>
								<li><div data-percentage="59" class="bar"></div><span>2016</span></li>
								<li><div data-percentage="88" class="bar"></div><span>2017</span></li>
							  </ul>
							</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //about page -->


<!-- team -->
	<div class="team1" id="team1">
		<div class="container">
			<div class="w3-headings-all">
				<h3>Our Team</h3>
			</div>
			<div class="agileinfo-team-grids">
				<div class="col-md-3 wthree-team-grid">
					<img src="images/w1.jpg" alt="">
					<div class="wthree-team-grid-info">
						<h4>王子纯</h4>
						<p>区块链架构开发</p>

					</div>
				</div>
				<div class="col-md-3 wthree-team-grid">
					<img src="images/w2.jpg" alt="">
					<div class="wthree-team-grid-info">
						<h4>张琳</h4>
						<p>区块链架构开发</p>
						<div class="team-social-grids">
						</div>
					</div>
				</div>
				<div class="col-md-3 wthree-team-grid">
					<img src="images/w3.jpg" alt="">
					<div class="wthree-team-grid-info">
						<h4>刘明昊</h4>
						<p>网站开发</p>
	
					</div>
				</div>
				<div class="col-md-3 wthree-team-grid">
					<img src="images/w4.jpg" alt="">
					<div class="wthree-team-grid-info">
						<h4>任仕睿</h4>
						<p>安卓开发</p>
						<div class="team-social-grids">
							<ul>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //team -->
<!-- testimonial -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
														<div class="modal-dialog">
														<!-- Modal content-->
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal">&times;</button>
																	
																	<div class="signin-form profile">
																	<h3 class="agileinfo_sign">您好，${username }！</h3>	
																			<div class="login-form">
																				<form action="user/quit.action" method="post">
																					<div class="tp">
																						<input type="submit" value="退出登录">
																					</div>
																				</form>
																			</div>
								
																		</div>
																</div>
															</div>
														</div>
													</div>
<!-- //testimonial --> 

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
				<p>&copy; 2018 HerbChain. All rights reserved | Design by W3layouts</a></p>
			</div>
		</div>
	</div>



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

<!-- ResponsiveTabs -->
	<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default', //Types: default, vertical, accordion           
				width: 'auto', //auto or any width like 600px
				fit: true   // 100% fit in a container
			});
		});
	</script>
<!-- //ResponsiveTabs --> 
<!-- start-smooth-scrolling -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>

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



</body>
</html>