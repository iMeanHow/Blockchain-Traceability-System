<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>  
    <html>
    <head>
    <title>药材企业信息插入</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="HerbChain Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="js/ajaxfileupload.js"></script>
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


<script type="text/javascript">
	function UpladFile() {
		var fileObj = document.getElementById("file").files[14]; // js 获取文件对象
		var FileController = "${pageContext.request.contextPath}/enterprise/UpImg.action"; // 接收上传文件的后台地址 
		// FormData 对象
		var form = new FormData($("#uploadForm")[0]);//创建一个form对象
		// XMLHttpRequest 对象
		var xhr = new XMLHttpRequest();//创建XMLHttpRequest对象
		xhr.open("post", FileController, true);//打开连接，(访问类型，地址，是否异步)
		xhr.onload = function() {//请求完成后执行  里面可用
		};
 
		xhr.upload.addEventListener("progress", progressFunction, false);//添加上传监听器方法
		xhr.send(form);//发送请求
	}
 
	function progressFunction(evt) {
 
		var progressBar = document.getElementById("progressactive");//获取进度条对象
		var percentageDiv = document.getElementById("sr-only");//获取展示进度数据对象
		if (evt.lengthComputable) {
			var max = evt.total;//文件总大小
			var loaded = evt.loaded;//已上传文件大小
			console.log(max);
			progressBar.style.width = Math.round(loaded / max * 100) + "%";
			percentageDiv.innerHTML = Math.round(loaded / max * 100) + "%";
			if (evt.loaded == evt.total) {
				percentageDiv.innerHTML = "上传完成";
			}
		}
 
	}
</script>





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
				<li><font size=6>药材经营企业信息插入</font></li>
			
			</ul>
		</div>
	</div>






<div class="skills w3-agileits w3-services-page">
		<div class="container"> 
			<div class="skills-agileinfo">
		
				<center>
					<h4>请输入增添信息</h4>		
				<form action="enterprise/insert.action" id="uploadForm" method="post">
			
				<label>ID：</label>				
				<input type="text" id="ID" name="ID" ><br/>
				<label>公司：</label>
				<input type="text" id="Company" name="Company" ><br/>
				<label>追溯承诺书：</label>
				<input type="text" id="Traceability_Promise" name="Traceability_Promise" ><br/>
				<label>营业执照：</label>
				<input type="text" id="Business_License" name="Business_License" ><br/>
				<label>生成批次：</label>
				<input type="text" id="Product_Batch" name="Product_Batch" ><br/>
				<label>入库时间：</label>
				<input type="text" id="Save_Time" name="Save_Time" ><br/>
				<label>来源：</label>
				<input type="text" id="Source" name="Source" ><br/>
				<label>仓库温度：</label>
				<input type="text" id="Save_Temp" name="Save_Temp" ><br/>
				<label>仓库湿度：</label>
				<input type="text" id="Save_Humidity" name="Save_Humidity" ><br/>
				<label>交易凭证：</label>
				<input type="text" id="Transaction_Voucher" name="Transaction_Voucher" ><br/><br/>
				<label>图片上传</label>
				<input type="file" name="file" id="file"  onchange="UpladFile()"/>
				<div class="progress" style="width: 30%">		
				<div id="progressactive"			class="progress-bar progress-bar-striped active" role="progressbar"			aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"			style="width: 0%">
				</div>	</div>	
				<span id="sr-only"></span>
				<input type="hidden" name="Picture_url" id="Picture_url">
				<img src="" alt="" id="Show" >

				<br/>
				<input type="submit" value="添加" />
				
				
				</form>	
				<a href="Enterprise_upload.jsp">批量上传</a>
				</center>
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