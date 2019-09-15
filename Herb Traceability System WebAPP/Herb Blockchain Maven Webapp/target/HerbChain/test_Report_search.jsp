<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>  

<html>
<head>
<title>质检报告信息查询</title>
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

<style type="text/css">
label { width:100px; text-align:center;}
</style>


<!-- banner -->
<div class="header">
		
		<div class="w3layouts_header_right">
			<div class="detail-w3l">
			<ul>
				<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i> + 400-000-000</li>
				
			</ul>
		</div>

		</div>
		<div class="w3layouts_header_left">
			<ul>
					
					
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
				<h1><a class="navbar-brand" href="welcome.jsp"><span></span>药材溯源系统</a></h1>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
				<nav class="link-effect-2" id="link-effect-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="welcome.jsp"><span data-hover="Home">主页</span></a></li>

						<li><a href="planting_id.jsp">中药种植</a></li>
						<li><a href="enterprise_id.jsp">药材企业</a></li>
						<li><a href="market_id.jsp">药材市场</a></li>
						<li><a href="drinks_Production_id.jsp">饮片生产</a></li>
						<li><a href="business_id.jsp">饮片经营</a></li>
						<li><a href="test_Report_id.jsp">质检报告</a></li>
											<li><a href="use_id.jsp">饮片使用</a></li> <li class="active"><a href="about_info.jsp"><span data-hover="About">关于我们</span></a></li>
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
			
				<li><a href="welcome.jsp"><font size=6>主页</font></a><i><font size=6>|</font></i></li>
				<li><font size=6>质检报告ID查询</font></li>
			
			</ul>
		</div>
	</div>
<div class="skills w3-agileits w3-services-page">
<center>
					<h4> ID:${mytest_Report.ID }</h4>
</center><br/>
		<div class="container"> 
			<div class="skills-agileinfo">
				<div class="col-md-6 skills-w3left">
				<center><h2>药材图片展示</h2></center>
				<img src="${mytest_Report.picture_url }" alt="" id="pic" name="pic" height="300" width="450"><br/><br/> 
				</div>
				<center><h2>药材产品信息</h2></center>
				<div class="col-md-6 skills-w3right bar_group"> 		
				<label>产品名称：</label>
				<input type="text" id="Product_Name" name="Product_Name" style="border:0px" readonly value=${mytest_Report.product_Name }><br/><br/>
				<label>产品特点：</label>
				<input type="text" id="Specification" name="Specification" style="border:0px" readonly value=${mytest_Report.specification }><br/><br/>
				<label>生产地点：</label>
				<input type="text" id="Production_Place" name="Production_Place" style="border:0px" readonly value=${mytest_Report.production_Place }><br/><br/>
				<label>生产数量：</label>
				<input type="text" id="Quantity" name="Quantity" style="border:0px" readonly value=${mytest_Report.quantity }><br/><br/>
				<label>生产批次：</label>
				<input type="text" id="Batch" name="Batch" style="border:0px" readonly value=${mytest_Report.batch }><br/><br/>
				<div class="clearfix"> </div>
			</div>
		</div>
							

	</div>
	<!-- //skills -->
<div class="container"> 
			<div class="skills-agileinfo">
				<div class="col-md-6 skills-w3left">
				<center><h2>质检图片展示</h2></center><br/> 
				<img src="${mytest_Report.picture_url }" alt="" id="pic" name="pic" height="300" width="450"><br/><br/> 
				</div>
				<center><h2>药材检测信息</h2></center><br/> 
				<div class="col-md-6 skills-w3right bar_group"> 
				<label>报告ID：</label>
				<input type="text" id="Report_ID" name="Report_ID" style="border:0px" readonly value=${mytest_Report.report_ID }><br/>
				<label>样本来源：</label>
				<input type="text" id="Sample_Origin" name="Sample_Origin" style="border:0px" readonly value=${mytest_Report.sample_Origin }><br/>
				<label>测试种类：</label>
				<input type="text" id="Test_Type" name="Test_Type" style="border:0px" readonly value=${mytest_Report.test_Type }><br/>
				<label>测试时间：</label>
				<input type="text" id="Test_Date" name="Test_Date" style="border:0px" readonly value=${mytest_Report.test_Date }><br/>	
				<label>报告时间：</label>
				<input type="text" id="Report_Date" name="Report_Date" style="border:0px" readonly value=${mytest_Report.report_Date }><br/>
				<label>报告参考：</label>
				<input type="text" id="Reference" name="Reference" style="border:0px" readonly value=${mytest_Report.reference }><br/>
				<label>样本性质：</label>
				<input type="text" id="Characteristics" name="Characteristics" style="border:0px" readonly value=${mytest_Report.characteristics }><br/>
				<label>样本微观性质：</label>
				<input type="text" id="Micro_Character" name="Micro_Character" style="border:0px" readonly value=${mytest_Report.micro_Character }><br/>
				<label>样本薄性质：</label>
				<input type="text" id="Thin_Layer_Character" name="Thin_Layer_Character" style="border:0px" readonly value=${mytest_Report.thin_Layer_Character }><br/>
				<label>湿度：</label>
				<input type="text" id="Moisture" name="Moisture" style="border:0px" readonly value=${mytest_Report.moisture }><br/>
				<label>含灰量：</label>
				<input type="text" id="Ashes" name="Ashes" style="border:0px" readonly value=${mytest_Report.ashes }><br/>
				<label>不溶酸含灰量：</label>
				<input type="text" id="Acid_Insoluble_Ash" name="Acid_Insoluble_Ash" style="border:0px" readonly value=${mytest_Report.acid_Insoluble_Ash }><br/>
				<label>SO2残留：</label>
				<input type="text" id="SO2_Remain" name="SO2_Remain" style="border:0px" readonly value=${mytest_Report.sO2_Remain }><br/>
				<label>粒度：</label>
				<input type="text" id="Granularity" name="Granularity" style="border:0px" readonly value=${mytest_Report.granularity }><br/>
				<label>均匀度：</label>
				<input type="text" id="Evenness" name="Evenness" style="border:0px" readonly value=${mytest_Report.evenness }><br/>
				<label>细菌含量：</label>
				<input type="text" id="Microbe_Limitation" name="Microbe_Limitation" style="border:0px" readonly value=${mytest_Report.microbe_Limitation }><br/>
				<label>萃取成分：</label>
				<input type="text" id="Extractive" name="Extractive" style="border:0px" readonly value=${mytest_Report.extractive }><br/>
				<label>鉴定结论：</label>
				<input type="text" id="Conclusion" name="Conclusion" style="border:0px" readonly value=${mytest_Report.conclusion }><br/>
				<div class="clearfix"> </div>
			</div>
		</div>
							

	</div>

													<!-- //Modal1 -->	
													
<!-- //bootstrap-pop-up -->




<!-- //footer-contact -->
<div class="footer-final">
		<div class="copyw3-agile"> 
			<div class="container">
				<p>&copy; 中药药材区块链溯源系统. All rights reserved | Design by NKU</a></p>
			</div>
		</div>
	</div>


<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->

<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->

<script src="js/lightbox-plus-jquery.min.js"> </script> 
<!-- //light box js--> 
<!-- bar-js -->
				<script src="js/bars.js"></script>
				<!-- bar-js -->
<!--  light box js -->
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
	<script src="js/SmoothScroll.min.js"></script>
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smooth-scrolling -->

<!-- here stars scrolling icon -->
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
<!-- //here ends scrolling icon -->
</body>
</html>