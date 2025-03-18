<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html class="no-js" lang="kor">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> DoggiVerse </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <!--  <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.css">
    <link rel="stylesheet" href="assets/css/flaticon.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/nice-select.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <script>
        function handleLogout() {
            alert('로그아웃 되었습니다.');
            document.getElementById('logout-form').submit();
        }
    </script>
</head>
<body>
	<!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/logo.jpeg" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <main> 
        <!--? Slider Area Start-->
        <div class="slider-area">
            <div class="slider-active dot-style">
                <!-- Slider Single -->
                <div class="single-slider d-flex align-items-center slider-height">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-xl-7 col-lg-8 col-md-10 ">
                                <!-- Video icon -->
                                <div class="video-icon">
                                    <a class="popup-video btn-icon" href="https://www.youtube.com/watch?v=o32faIi1FKE" data-animation="bounceIn" data-delay=".4s">
                                        <i class="fas fa-play"></i>
                                    </a>
                                </div>
                                <div class="hero__caption">
                                    <span data-animation="fadeInUp" data-delay=".3s">도기버스의 추천영상 #1</span>
                                    <h1 data-animation="fadeInUp" data-delay=".3s">애견을 다루는법</h1>
                                    <p data-animation="fadeInUp" data-delay=".6s">강형욱 반려견 훈련사 #10 | 반려견을 안정시키고 싶다면, 이 행동만 반복하면 된다 | #어쩌다어른 #사피엔스</p>
                                    <!-- <a href="#" class="hero-btn" data-animation="fadeInLeft" data-delay=".3s">Contact Now<i class="ti-arrow-right"></i> </a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>   
                <!-- Slider Single -->
                <div class="single-slider d-flex align-items-center slider-height">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-xl-7 col-lg-8 col-md-10 ">
                                <!-- Video icon -->
                                <div class="video-icon">
                                    <a class="popup-video btn-icon" href="https://www.youtube.com/watch?v=RhDsF596plY" data-animation="bounceIn" data-delay=".4s">
                                        <i class="fas fa-play"></i>
                                    </a>
                                </div>
                                <div class="hero__caption">
                                    <span data-animation="fadeInUp" data-delay=".3s">도기버스의 추천영상 #2</span>
                                    <h1 data-animation="fadeInUp" data-delay=".3s">애견이 피해야 할 음식</h1>
                                    <p data-animation="fadeInUp" data-delay=".6s">강아지가 먹으면 안되는 음식 5가지(feat. 과일, 고기) / 5 Foods Your Dogs Should Never Eat</p>
                                    <a href="#" class="hero-btn" data-animation="fadeInLeft" data-delay=".3s">Contact Now<i class="ti-arrow-right"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>   
            </div>
            <!-- slider Social -->
            <div class="button-text d-none d-md-block">
            <span>Screll</span>
            </div>
        </div>
        <!-- Slider Area End -->
        <!--? Our Services Start -->
        <div class="our-services section-padding30">
            <div class="container">
                <div class="row justify-content-sm-center">
                    <div class="cl-xl-7 col-lg-8 col-md-10">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-70">
                            <span>우리가 제공하는 서비스들</span>
                            <h2>애견인들을 위한 맞춤형 서비스 </h2>
                        </div> 
                    </div>
                </div>
                <div class="row">
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services text-center mb-30">
                            <div class="services-ion">
                                <span class="flaticon-animal-kingdom"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="News.jsp">실시간 애견 관련 뉴스</a></h5>
                                <p>각종 언론사의 애견 관련 뉴스를 여러분들께 제공합니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services text-center mb-30">
                            <div class="services-ion">
                                <span class="flaticon-animals"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="${pageContext.request.contextPath}/list.board?page=1&cpp=">커뮤니티</a></h5>
                                <p>애견인들이 서로 정보를 더 쉽게 공유할 수 있도록 소통의 장을 마련했습니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services text-center mb-30">
                            <div class="services-ion">
                                <span class="flaticon-animals-1"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="dog.jsp">유기견 조회 서비스</a></h5>
                                <p>유기견들이 사랑스러운 주인을 만날 수 있도록 유기견 조회 서비스를 제공합니다.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Our Services End -->
       
        <!--? Gallery Area Start -->
        <div class="gallery-area section-padding5">
            <div class="container fix">
                <div class="row justify-content-sm-center">
                    <div class="cl-xl-7 col-lg-8 col-md-10">
                        <!-- Section Tittle -->
                        <!-- <div class="section-tittle text-center mb-70">
                            <span>Our Recent Photos</span>
                            <h2>Pets Photo Gallery</h2>
                        </div>  -->
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <!-- <a href="assets/img/gallery/gallery1.png" class="img-pop-up">View Project</a> -->
                            <div class="gallery-img size-img" style="background-image: url(assets/img/gallery/gallery1.png);"></div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <div class="gallery-img size-img" style="background-image: url(assets/img/gallery/gallery2.png);"></div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <div class="gallery-img size-img" style="background-image: url(assets/img/gallery/gallery3.png);"></div>
                        </div>
                    </div>
                    <div class="col-lg-4  col-md-6 col-sm-6">
                        <div class="single-gallery mb-30">
                            <div class="gallery-img size-img" style="background-image: url(assets/img/gallery/gallery4.png);"></div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- Gallery Area End -->
       
    </main>
    <footer>
        <!-- Footer Start-->
        <div class="footer-area footer-padding">
            <div class="container">
                <div class="row d-flex justify-content-between">
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-6">
                       <div class="single-footer-caption mb-50">
                         <div class="single-footer-caption mb-30">
                              <!-- logo -->
                             <div class="footer-logo mb-25">
                                 <a href="index.jsp"><img src="assets/img/logo/logo.png" alt=""></a>
                             </div>
                             <div class="footer-tittle">
                                 <div class="footer-pera">
                                     <p>"도기버스는 모든 애견인들과 정보를 공유하고 소통하기 위해 노력합니다."</p>
                                </div>
                             </div>
                         </div>
                       </div>
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-4 col-sm-5">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Menu</h4>
                                <ul>
                                    <li><a href="index.jsp">홈</a></li>
                                    <li><a href="about.html">우리동네 산책메이트</a></li>
                                    <li><a href="News.jsp">뉴스</a></li>
                                    <li><a href="board_list.jsp">자유게시판</a></li>
                                    <li><a href="dog.jsp">유기동물 조회하기</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Contact</h4>
                                <ul>
                                 <li><a href="#">010-0000-0000</a></li>
                                 <li><a href="#"> myEmail@gmail.com</a></li>
                                 <li><a href="#">Seoul, Republic Of Korea</a></li>
                             </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer-bottom area -->
        <div class="footer-bottom-area">
            <div class="container">
                <div class="footer-border">
                     <div class="row d-flex align-items-center">
                         <div class="col-xl-12 ">
                             <div class="footer-copy-right text-center">
                                 <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">31 Team</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                             </div>
                         </div>
                     </div>
                </div>
            </div>
        </div>
        <!-- Footer End-->
    </footer>
    <!-- Scroll Up -->
    <div id="back-top" >
        <a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
    </div>

    <!-- JS here -->
    
    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Nice-select, sticky -->
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    
    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->	
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
        
    </body>
</html>