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
    <title>电子商店</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=basePath%>css/owl.carousel.css">
    <link rel="stylesheet" href="<%=basePath%>style.css">
    <link rel="stylesheet" href="<%=basePath%>css/responsive.css">
  </head>
  <body>
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="regist.jsp "><i class="fa fa-user"></i> 个人中心</a></li>
                            <li><a href="regist.jsp"><i class="fa fa-heart"></i> 订单</a></li>
                            <li><a href="regist.jsp"><i class="fa fa-user"></i> 购物车</a></li>
                            <li><a href="regist.jsp"><i class="fa fa-user"></i> 收货地址</a></li>
                            <li><a href="regist.jsp"><i class="fa fa-user"></i> 注册</a></li>
                            <li><a href="login.jsp"><i class="fa fa-user"></i> 登录</a></li>
                            <li><a href="adminlogin.jsp"><i class="fa fa-user"></i> 后台管理</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- End header area -->
    
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
                        <a href="cart.html">购物车 - <span class="cart-amunt">$0</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">0</span></a>
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
                        <li class="active"><a href="index.jsp">首页</a></li>
                        <li><a href="regist.jsp">商店</a></li>
                        <li><a href="regist.jsp">单品</a></li>
                        <li><a href="regist.jsp">购物车</a></li>
                        <li><a href="regist.jsp">收货地址</a></li>
                        <li><a href="regist.jsp">类别</a></li>
                        <li><a href="regist.jsp">其他</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    
    <div class="slider-area">
        <div class="zigzag-bottom"></div>
        <div id="slide-list" class="carousel carousel-fade slide" data-ride="carousel">
            <div class="slide-bulletz">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <ol class="carousel-indicators slide-indicators">
                                <li data-target="#slide-list" data-slide-to="0" class="active"></li>
                                <li data-target="#slide-list" data-slide-to="1"></li>
                                <li data-target="#slide-list" data-slide-to="2"></li>
                            </ol>                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <div class="single-slide">
                        <div class="slide-bg slide-one"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="slide-content">
                                                <h2>We are awesome</h2>
                                                <p>I could not help to cut these words together, and to regroup with photographs, immediately, a beautiful photographic prose shines in front of my eyes! I read it silently, and at that moment, my heart and vision were deeply intoxicated with enjoyment...</p>
                                                <p>I could not help to cut these words together, and to regroup with photographs, immediately, a beautiful photographic prose shines in front of my eyes! I read it silently, and at that moment, my heart and vision were deeply intoxicated with enjoyment...</p>
                                                <a href="regist.jsp" class="readmore">Learn more</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="single-slide">
                        <div class="slide-bg slide-two"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="slide-content">
                                                <h2>We are great</h2>
                                                <p>If you can use your camera to find the universal meaning, then you're a photographer. No matter what type of camera you're using, whether you're shooting for art or enjoyment. As long as your heart is searching, you're a photographer. That's what photography means!</p>
                                                <a href="regist.jsp" class="readmore">Learn more</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="single-slide">
                        <div class="slide-bg slide-three"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="slide-content">
                                                <h2>We are superb</h2>
                                                <p>The story behind the photograph, the thinking after the moment. It's the photographer's greatness, and it's the photographer's responsibility. ?</p>
                                                <p> To find the photo in the universal significance, while the ordinary real meaning is to impress people that a sincere, that a good sigh; that a heartache, the hidden side of a resonance; that a sorrowful anger, a wordless moved.</p>
                                                <a href="regist.jsp" class="readmore">Learn more</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>        
    </div> <!-- End slider area -->
    <div class="promo-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-refresh"></i>
                        <p>30天退换</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-truck"></i>
                        <p>免费送达</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-lock"></i>
                        <p>安全支付</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-gift"></i>
                        <p>最新单品</p>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End promo area -->
    
    <div class="maincontent-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="latest-product">
                        <h2 class="section-title">热门单品</h2>
                        <div class="product-carousel">
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-1.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                
                                <h2><a href="single-product.html">索尼智能电视 - 2015</a></h2>
                                
                                <div class="product-carousel-price">
                                    <ins>￥700.00</ins> <del>￥800.00</del>
                                </div> 
                            </div>
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-2.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                
                                <h2><a href="<%=basePath%>single-product.html">苹果新款Mac book 2015 March :P</a></h2>
                                <div class="product-carousel-price">
                                    <ins>￥899.00</ins> <del>￥999.00</del>
                                </div> 
                            </div>
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-3.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                
                                <h2><a href="single-product.html">i phone 6</a></h2>

                                <div class="product-carousel-price">
                                    <ins>￥400.00</ins> <del>￥425.00</del>
                                </div>                                 
                            </div>
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-4.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                
                                <h2><a href="single-product.html">Sony playstation microsoft</a></h2>

                                <div class="product-carousel-price">
                                    <ins>￥200.00</ins> <del>￥225.00</del>
                                </div>                            
                            </div>
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-5.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                
                                <h2><a href="single-product.html">索尼智能空调</a></h2>

                                <div class="product-carousel-price">
                                    <ins>￥1200.00</ins> <del>￥1355.00</del>
                                </div>                                 
                            </div>
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=basePath%>img/product-6.jpg" alt="">
                                    <div class="product-hover">
                                        <a href="regist.jsp" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> 加入购物车</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> 查看详情</a>
                                    </div>
                                </div>
                                <h2><a href="single-product.html">三星 gallaxy note 4</a></h2>
                                <div class="product-carousel-price">
                                    <ins>￥400.00</ins>
                                </div>                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End main content area -->
    
    <div class="brands-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="brand-wrapper">
                        <h2 class="section-title">大牌</h2>
                        <div class="brand-list">
                            <img src="<%=basePath%>img/services_logo__1.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__2.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__3.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__4.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__1.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__2.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__3.jpg" alt="">
                            <img src="<%=basePath%>img/services_logo__4.jpg" alt="">                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End brands area -->
    
    <div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">热门商品</h2>
                        <a href="" class="wid-view-more">查看全部</a>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">索尼智能电视 - 2015</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-2.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">苹果新款Mac book 2015</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-3.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html"> i phone 6</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">我的足迹</h2>
                        <a href="#" class="wid-view-more">查看全部</a>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-4.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">Sony playstation microsoft</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">索尼智能空调</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-2.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">三星gallaxy note 4</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">最新单品</h2>
                        <a href="#" class="wid-view-more">查看全部</a>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-3.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">i phone 6</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-4.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">三星gallaxy note 4</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="<%=basePath%>img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">Sony playstation microsoft</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>$400.00</ins> <del>$425.00</del>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
    
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
                        <p>丢掉繁琐的步骤，成为我们的用户，只需邮箱激活</p>
                        <div class="newsletter-form">
                            <form action="#"><!--邮箱激活验证-->
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
                        <p>&copy; 2015 eElectronics. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="电子商店">电子商店</a> - Collect from <a href="http://www.cssmoban.com/" title="电子商店" target="_blank">电子商店</a></p>
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