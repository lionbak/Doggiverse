<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.community.dogapi.DogDataFetcher" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>유기동물 조회</title>
   
       </head>
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
    <div class="slider-area2 slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>유기동물 조회하기</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <body>
       <div class="container">
           <h2>&nbsp;</h2>
           <form method="get" class="form-inline">
               <div class="form-group mx-auto">
                   <label for="bgnde">시작일:</label>
                   <input type="text" id="bgnde" name="bgnde" class="form-control mx-2">
               </div>
               <div class="form-group mx-auto">
                   <label for="endde">종료일:</label>
                   <input type="text" id="endde" name="endde" class="form-control mx-2">
               </div>
           <button type="submit" class="btn btn-primary btn-sm">조회</button>
           </form>

           <%
               // 이전 코드 생략

               String bgnde = request.getParameter("bgnde");
               String endde = request.getParameter("endde");

               if (bgnde != null && endde != null) {
                   try {
                       DogDataFetcher dataFetcher = new DogDataFetcher();
                       ArrayList<HashMap<String, String>> itemList = dataFetcher.fetchData(bgnde, endde);

                       int pageSize = 3; // 한 페이지에 출력할 항목 수를 3개로 설정
                       int totalItems = itemList.size();
                       int totalPages = (int) Math.ceil((double) totalItems / pageSize);
                       int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
                       int start = (currentPage - 1) * pageSize;
                       int end = Math.min(start + pageSize, totalItems);

                       out.println("<div class='row'>"); // 부트스트랩 row 시작
                       for (int i = start; i < end; i++) {
                           HashMap<String, String> item = itemList.get(i);
           %>
                           <div class="col-md-4 mb-4"> <!-- 부트스트랩 column 설정 및 간격 조정 -->
                               <div class="dog-card"> <!-- dog-card 클래스 적용 -->
                                   <table class="table"> <!-- 부트스트랩 테이블 클래스 적용 -->
                                       <tr><th>품종</th><td><%= item.get("kindCd") %></td></tr>
                                       <tr><th>나이</th><td><%= item.get("age") %></td></tr>
                                       <tr><th>무게</th><td><%= item.get("weight") %></td></tr>
                                       <tr><th>보호소전화번호</th><td><%= item.get("careTel") %></td></tr>
                                       <tr><th>관리기관</th><td><%= item.get("orgNm") %></td></tr>
                                       <tr><th>담당자연락처</th><td><%= item.get("officetel") %></td></tr>
                                       <tr>
                                           <th>이미지</th>
                                           <td>
                                               <img src='<%= item.get("filename") %>' alt='유기동물 이미지' class='img-fluid' style='width: 200px; height: 200px;' />
                                           </td>
                                       </tr>
                                   </table>
                               </div>
                           </div>
           <%
                           // 3번째 칸이면 줄 바꿈
                           if ((i - start + 1) % 3 == 0) {
                              out.println("</div><div class='row'>"); // 부트스트랩 row 종료 후 새로운 row 시작
                           }
                       }
                       out.println("</div>"); // 마지막 row 종료

                       if (currentPage > 1) {
                              out.println("<a href='?bgnde=" + bgnde + "&endde=" + endde + "&page=" + (currentPage - 1) + "' class='btn btn-primary' style='color: white;'>이전</a>");
                          } else {
                              out.println("<a class='btn btn-primary' style='color: white;'>이전</a>");
                          }
                          if (currentPage < totalPages) {
                              out.println("<a href='?bgnde=" + bgnde + "&endde=" + endde + "&page=" + (currentPage + 1) + "' class='btn btn-primary' style='color: white;'>다음</a>");
                          } else {
                              out.println("<a class='btn btn-primary' style='color: white;'>다음</a>");
                          }



               } catch (Exception e) {
                   e.printStackTrace();
                   out.println("<h3>API 호출 중 오류가 발생했습니다.</h3>");
               }
           }
       %>
   </div>
   <div>&nbsp; </div>
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
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
   </body>
   </html>
   <%@ include file="footer.jsp" %>