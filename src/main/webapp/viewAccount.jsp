<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> DoggiVerse </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
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

    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

    <style>
        <style>
                body {
                    font-family: 'Arial', sans-serif;
                    background-color: #f8f9fa;
                }

                .fixed-width-centered {
                    margin: 0 auto;
                    width: 720px;
                    max-width: 100%;
                    padding: 20px;
                }

                .feedback {
                    margin-left: 8px;
                    font-size: 12px;
                }

                .card {
                    border: none;
                    border-radius: 10px;
                    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
                }

                .card-header {
                    border-bottom: none;
                    background: #007bff;
                    color: white;
                    border-top-left-radius: 10px;
                    border-top-right-radius: 10px;
                    text-align: center;
                }

                .card-body {
                    background: white;
                    padding: 30px;
                    border-bottom-left-radius: 10px;
                    border-bottom-right-radius: 10px;
                }

                label {
                    font-weight: bold;
                    color: #333;
                }

                input[type="text"], select {
                    width: 100%;
                    padding: 10px;
                    margin: 5px 0 15px 0;
                    display: inline-block;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    box-sizing: border-box;
                }

                button[type="submit"], button[type="button"] {
                    background-color: #ea9b9a;
                    color: white;
                    padding: 10px 20px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    margin-top: 10px;
                }

                button[type="button"] {
                    background-color: #ea9b9a;
                }

                button[type="submit"]:hover, button[type="button"]:hover {
                    background-color: #ea9b9a;
                }

                .feedback {
                    display: block;
                    margin-top: -10px;
                    margin-bottom: 15px;
                }

                #deleteButton {
                    background-color: #ea9b9a;
                }

                #deleteButton:hover {
                    background-color: #c82333;
                }

                .button-container {
                    display: flex;
                    justify-content: space-between;
                    margin-top: 20px;
                }

                .button-container button {
                    flex: 1;
                    margin: 0 5px;
                }
            </style>
    </style>
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
    <div class="slider-area2 slider-height2 d-flex align-items-center">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center pt-50">
                        <h2>내 계정</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container" style="padding: 50px">
        <div class="fixed-width-centered">
            <div class="card bg-secondary shadow">
                <div class="card-header bg-white border-0">

                      <!--   <h3 class="mb-0" style = "text-align: center;">계정 정보</h3> -->

                </div>
                <div class="card-body" style="background: white;">
                    <form id="updateForm" action="UserServlet" method="POST" onsubmit="return validateForm()">
                        <input type="hidden" name="pagecode" value="updateInfo">

                        <label>아이디:</label>
                        <p>${sessionScope.username}</p>

                        <label>이메일:</label>
                        <p>${sessionScope.email}</p>

                        <label for="nickname">닉네임:</label>
                        <input type="text" id="nickname" name="nickname" value="${sessionScope.nickname}" required onkeyup="validateNickname()">
                        <span id="nickname-feedback" class="feedback"></span><br>

                        <label for="dogName">애완견 이름:</label>
                        <input type="text" id="dogName" name="dogName" value="${sessionScope.dogName}" required><br>

                        <label for="address">기본 주소:</label>
                        <input type="text" id="address" name="address" value="${sessionScope.address}" required readonly>
                        <button type="button" onclick="openPostcode()">주소 검색</button><br>

                        <label for="addressDetail" style ="margin-top: 10px;">상세 주소:</label>
                        <input type="text" id="addressDetail" name="address2" value="${sessionScope.address2}" required><br>

                        <label for="phone_number_1">전화 번호:</label>
                        <div style="display: flex; gap: 10px;">
                            <select id="phone_number_1" name="phone_number_1" required>
                                <option value="010" ${sessionScope.phoneNumber.split('-')[0] == '010' ? 'selected' : ''}>010</option>
                                <option value="011" ${sessionScope.phoneNumber.split('-')[0] == '011' ? 'selected' : ''}>011</option>
                                <option value="016" ${sessionScope.phoneNumber.split('-')[0] == '016' ? 'selected' : ''}>016</option>
                                <option value="017" ${sessionScope.phoneNumber.split('-')[0] == '017' ? 'selected' : ''}>017</option>
                                <option value="018" ${sessionScope.phoneNumber.split('-')[0] == '018' ? 'selected' : ''}>018</option>
                                <option value="019" ${sessionScope.phoneNumber.split('-')[0] == '019' ? 'selected' : ''}>019</option>
                            </select>
                            <input type="text" id="phone_number_2" name="phone_number_2" value="${sessionScope.phoneNumber.split('-')[1]}" required maxlength="4" onkeyup="validatePhoneNumber()"/>
                            <input type="text" id="phone_number_3" name="phone_number_3" value="${sessionScope.phoneNumber.split('-')[2]}" required maxlength="4" onkeyup="validatePhoneNumber()"/>
                        </div>
                        <span id="phone-number-feedback" class="feedback"></span><br>
                            <div class="button-container">
                                <button type="submit" id="submitButton">계정 수정</button>
                                <button type="button" id="passwordChangeButton">비밀번호 변경</button>
                                <button type="button" id="deleteButton">계정 삭제</button>
                            </div>
                    </form>
                    <form id="passwordChangeForm" action="UserServlet" method="POST" style="display: none;">
                        <input type="hidden" name="pagecode" value="changePassword">
                    </form>
                    <form id="deleteForm" action="UserServlet" method="POST">
                        <input type="hidden" name="pagecode" value="deleteAccount">
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
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

    <script>
        document.getElementById('passwordChangeButton').addEventListener('click', function() {
                window.location.href = 'changePassword.jsp';
            });

        function openPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    var fullAddress = data.address;
                    var extraAddress = '';

                    if (data.addressType === 'R') {
                        if (data.bname !== '') {
                            extraAddress += data.bname;
                        }
                        if (data.buildingName !== '') {
                            extraAddress += (extraAddress !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        fullAddress += (extraAddress !== '' ? ' (' + extraAddress + ')' : '');
                    }

                    document.getElementById('address').value = fullAddress;
                    document.getElementById('addressDetail').focus();
                }
            }).open();
        }

        function debounce(func, wait, immediate) {
            var timeout;
            return function() {
                var context = this, args = arguments;
                var later = function() {
                    timeout = null;
                    if (!immediate) func.apply(context, args);
                };
                var callNow = immediate && !timeout;
                clearTimeout(timeout);
                timeout = setTimeout(later, wait);
                if (callNow) func.apply(context, args);
            };
        }

        var validateNickname = debounce(function() {
            var nickname = document.getElementById('nickname').value;
            var feedback = document.getElementById('nickname-feedback');
            var submitButton = document.getElementById('submitButton');
            feedback.style.marginLeft = '8px';

            if (nickname.trim() === "") {
                feedback.textContent = '';
                submitButton.disabled = false;
                return;
            }

            if (nickname.includes(' ')) {
                feedback.textContent = '닉네임에 공백을 포함할 수 없습니다.';
                feedback.style.color = 'red';
                feedback.style.fontSize = '12px';
                submitButton.disabled = true; // Disable the submit button
                return; // Exit the function early if there are spaces
            }

            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'checkNickname?nickname=' + encodeURIComponent(nickname), true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    var isExist = xhr.responseText === 'true';
                    if (isExist) {
                        feedback.textContent = '사용 불가능한 닉네임입니다.';
                        feedback.style.color = 'red';
                        feedback.style.fontSize = '12px';
                        submitButton.disabled = true; // Disable the submit button
                    } else {
                        feedback.textContent = '사용 가능한 닉네임입니다.';
                        feedback.style.color = 'green';
                        feedback.style.fontSize = '12px';
                        submitButton.disabled = false; // Enable the submit button
                    }
                }
            };
            xhr.send();
        }, 250);

        document.getElementById('nickname').addEventListener('keyup', validateNickname);

        function validatePhoneNumber() {
            var phoneNumber2 = document.getElementById('phone_number_2').value;
            var phoneNumber3 = document.getElementById('phone_number_3').value;
            var feedback = document.getElementById('phone-number-feedback');
            var submitButton = document.getElementById('submitButton');

            if (/^\d{3,4}$/.test(phoneNumber2) && /^\d{4}$/.test(phoneNumber3)) {
                feedback.textContent = '유효한 전화번호입니다.';
                feedback.style.color = 'green';
                submitButton.disabled = false;
            } else {
                feedback.textContent = '전화번호를 확인해주세요.';
                feedback.style.color = 'red';
                submitButton.disabled = true;
            }
        }

        function validateForm() {
            var fields = ['nickname', 'dogName', 'phone_number_2', 'phone_number_3'];
            var submitButton = document.getElementById('submitButton');
            var hasSpace = fields.some(function(fieldId) {
                var field = document.getElementById(fieldId);
                if (field.value.includes(' ')) {
                    alert('계정 정보에 공백이 포함되어 있습니다.');
                    submitButton.disabled = true;
                    return true;
                }
                return false;
            });
            return !hasSpace;
        }

        document.getElementById('phone_number_2').addEventListener('keyup', validatePhoneNumber);
        document.getElementById('phone_number_3').addEventListener('keyup', validatePhoneNumber);

        document.getElementById('deleteButton').addEventListener('click', function() {
            if (confirm('정말 계정을 삭제하시겠습니까? 확인을 누르면 계정이 영구적으로 삭제됩니다.')) {
                document.getElementById('deleteForm').submit();
            }
        });
    </script>
</body>
</html>
