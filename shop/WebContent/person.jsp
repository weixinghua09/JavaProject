<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eElectronics - HTML eCommerce Template</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=basePath%>/css/owl.carousel.css">
    <link rel="stylesheet" href="<%=basePath%>/style.css">
    <link rel="stylesheet" href="<%=basePath%>/css/responsive.css">
  </head>
  <body>
   
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="person.html"><i class="fa fa-user"></i> 个人中心</a></li>
                            <li><a href="order.html"><i class="fa fa-heart"></i> 订单</a></li>
                            <li><a href="cart.html"><i class="fa fa-user"></i> 购物车</a></li>
                            <li><a href="checkout.html"><i class="fa fa-user"></i> 收货地址</a></li>
                            <li><a href="regist.html"><i class="fa fa-user"></i> 注册</a></li>
                            <li><a href="login.html"><i class="fa fa-user"></i> 登录</a></li>
                            <li><a href="admin.html"><i class="fa fa-user"></i> 后台管理</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index.html">e<span>电子商店</span></a></h1>
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="shopping-item">
                        <a href="cart.html">购物车 - <span class="cart-amunt">$800</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">首页</a></li>
                        <li><a href="shop.html">商店</a></li>
                        <li><a href="single-product.html">单品</a></li>
                        <li class="active"><a href="person.jsp">个人中心</a></li>
                        <li><a href="checkout.html">收货地址</a></li>
                        <li><a href="#">类别</a></li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->    
    <div class="maincontent-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="latest-product">
                        <h2 class="section-title">个人中心</h2>
                        <div id="myform">
                        	<span>欢迎您，</span><span>${user.userName }</span>
                                <span><!--头像显示--></span>
                                <SPAN>年龄：</SPAN><span>${user.age }</span>
                                <SPAN>联系方式：</SPAN><span>${user.phone }</span>
                            </div>
                        <div id="myform">
                            <a href="<%=basePath%>user/modify">完善资料</a>
                        	<a href="<%=basePath%>user/address">管理地址</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End main content area -->  
    <div class="footer-top-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="footer-about-us">
                        <h2>e<span>电子商店</span></h2>
                        <p>如果你能用相机找到宇宙的意义，那么你就是一个摄影师。不管你用的是哪种相机，你是在拍摄艺术还是娱乐。只要你的心在寻找，你就是一个摄影师。这就是摄影的意义！</p>
                        <div class="footer-social">
                            <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">用户导航</h2>
                        <ul>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">历史订单</a></li>
                            <li><a href="#">收藏</a></li>
                            <li><a href="#">联系供应商</a></li>
                            <li><a href="#">首页</a></li>
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">分类</h2>
                        <ul>
                            <li><a href="#">手机</a></li>
                            <li><a href="#">相机</a></li>
                            <li><a href="#">LED电视</a></li>
                            <li><a href="#">电脑</a></li>
                            <li><a href="#">平板</a></li>
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-newsletter">
                        <h2 class="footer-wid-title">新用户</h2>
                        <p>成为我们的用户，丢掉繁琐的步骤，只需邮箱激活</p>
                        <div class="newsletter-form">
                            <form action="#">
                                <input type="email" placeholder="请输入邮箱地址">
                                <input type="submit" value="注册">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer top area -->
    
    <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                        <p>&copy; 2015 eElectronics. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="footer-card-icon">
                        <i class="fa fa-cc-discover"></i>
                        <i class="fa fa-cc-mastercard"></i>
                        <i class="fa fa-cc-paypal"></i>
                        <i class="fa fa-cc-visa"></i>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer bottom area -->
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="<%=basePath%>js/owl.carousel.min.js"></script>
    <script src="<%=basePath%>js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="<%=basePath%>js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="<%=basePath%>js/main.js"></script>
  </body>
</html>