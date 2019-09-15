<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>  

    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>	
<body onload="logincheck()">

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
				<li><font size=6>ID查询</font></li>
			
			</ul>
		</div>
	</div>
<div class="skills w3-agileits w3-services-page">
		<div class="container"> 
			<div class="skills-agileinfo">
				<div class="col-md-6 skills-w3left">
					<h4>请输入查询ID</h4>
				<form action="test_Report/search.action" method="post">
				<input type="text" id="ID" name="ID" placeholder="请输入ID" value=${mytest_Report.ID }>
				<span>
				<input type="submit" value="查询" />
				</span>
				</form>
				<form action="test_Report/reset.action" method="post">
				<input type="submit" value="重置" />
				</form>
									<h3>药材图片展示</h3>
				<img src="${mytest_Report.picture_url }" alt="" id="pic" name="pic" height="300" width="450"><br/><br/> 
													<h3>质检图片展示</h3>
				<img src="${mytest_Report.picture_url1 }" alt="" id="pic1" name="pic1" height="300" width="450"><br/><br/> 
				</div>
				<h4>质检报告信息</h4>
				<div class="col-md-6 skills-w3right bar_group"> 
				<label>报告ID：</label>
				<input type="text" id="Report_ID" name="Report_ID" style="border:0px" readonly value=${mytest_Report.report_ID }><br/><br/>
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
				<label>样本来源：</label>
				<input type="text" id="Sample_Origin" name="Sample_Origin" style="border:0px" readonly value=${mytest_Report.sample_Origin }><br/><br/>
				<label>测试种类：</label>
				<input type="text" id="Test_Type" name="Test_Type" style="border:0px" readonly value=${mytest_Report.test_Type }><br/><br/>
				<label>测试时间：</label>
				<input type="text" id="Test_Date" name="Test_Date" style="border:0px" readonly value=${mytest_Report.test_Date }><br/>	<br/>
				<label>报告时间：</label>
				<input type="text" id="Report_Date" name="Report_Date" style="border:0px" readonly value=${mytest_Report.report_Date }><br/><br/>
				<label>报告参考：</label>
				<input type="text" id="Reference" name="Reference" style="border:0px" readonly value=${mytest_Report.reference }><br/><br/>
				<label>样本性质：</label>
				<input type="text" id="Characteristics" name="Characteristics" style="border:0px" readonly value=${mytest_Report.characteristics }><br/><br/>
				<label>样本微观性质：</label>
				<input type="text" id="Micro_Character" name="Micro_Character" style="border:0px" readonly value=${mytest_Report.micro_Character }><br/><br/>
				<label>样本薄性质：</label>
				<input type="text" id="Thin_Layer_Character" name="Thin_Layer_Character" style="border:0px" readonly value=${mytest_Report.thin_Layer_Character }><br/><br/>
				<label>湿度：</label>
				<input type="text" id="Moisture" name="Moisture" style="border:0px" readonly value=${mytest_Report.moisture }><br/><br/>
				<label>含灰量：</label>
				<input type="text" id="Ashes" name="Ashes" style="border:0px" readonly value=${mytest_Report.ashes }><br/><br/>
				<label>不溶酸含灰量：</label>
				<input type="text" id="Acid_Insoluble_Ash" name="Acid_Insoluble_Ash" style="border:0px" readonly value=${mytest_Report.acid_Insoluble_Ash }><br/><br/>
				<label>SO2残留：</label>
				<input type="text" id="SO2_Remain" name="SO2_Remain" style="border:0px" readonly value=${mytest_Report.sO2_Remain }><br/><br/>
				<label>粒度：</label>
				<input type="text" id="Granularity" name="Granularity" style="border:0px" readonly value=${mytest_Report.granularity }><br/><br/>
				<label>均匀度：</label>
				<input type="text" id="Evenness" name="Evenness" style="border:0px" readonly value=${mytest_Report.evenness }><br/><br/>
				<label>细菌含量：</label>
				<input type="text" id="Microbe_Limitation" name="Microbe_Limitation" style="border:0px" readonly value=${mytest_Report.microbe_Limitation }><br/><br/>
				<label>萃取成分：</label>
				<input type="text" id="Extractive" name="Extractive" style="border:0px" readonly value=${mytest_Report.extractive }><br/><br/>
				<label>鉴定结论：</label>
				<input type="text" id="Conclusion" name="Conclusion" style="border:0px" readonly value=${mytest_Report.conclusion }><br/><br/><br/>
				<div class="clearfix"> </div>
			</div>
		</div>

	</div>
	<!-- //skills -->

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