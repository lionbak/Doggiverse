<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <style>
        .form-group {
            margin-bottom: 15px;
            text-align: center;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 30%;
            padding: 8px;
            box-sizing: border-box;
            display: inline-block;
            height: 30px;
        }
    </style>
</head>
<body>
<div class="container" style="padding: 50px">
    <div class="fixed-width-centered">
        <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0">
                <h3 class="mb-0" style="text-align: center;">비밀번호 변경</h3>
            </div>
            <div class="card-body" style = "background: white;">
                <form id="changePasswordForm" method="POST" >
                    <div class="form-group">
                        <label for="currentPassword">현재 비밀번호:</label>
                        <input type="password" id="currentPassword" name="currentPassword" required>
                    </div>

                    <div class="form-group">
                        <label for="newPassword">새 비밀번호:</label>
                        <input type="password" id="newPassword" name="newPassword" required>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">새 비밀번호 확인:</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required>
                    </div>
                    <div class="password-requirements" style= "text-align: center; padding: 10px;">
                        (영문 대소문자, 숫자, 특수문자 중 2가지 이상 조합, 8자~16자)<br>
                        <span id="password-match-feedback" class="feedback"></span>
                        <span id="current-password-feedback" class="feedback"></span>
                        <span id="new-password-feedback" class="feedback"></span>
                    </div>
                    <div style="text-align: center;">
                        <button type="submit" id="submitPasswordChangeButton" class="btn btn-primary" style = "background:#ea9b9a;">변경</button>
                        <button type="button" id="backButton" class="btn btn-secondary" style = "background:#ea9b9a;">뒤로</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $('#changePasswordForm').on('submit', function(event) {
        event.preventDefault();

        var currentPassword = $('#currentPassword').val();
        var newPassword = $('#newPassword').val();
        var confirmPassword = $('#confirmPassword').val();
        var feedback = $('#password-match-feedback');
        var currentPasswordFeedback = $('#current-password-feedback');
        var newPasswordFeedback = $('#new-password-feedback');

        // Clear previous feedback
        feedback.text('');
        currentPasswordFeedback.text('');
        newPasswordFeedback.text('');

        // Check errors in priority order
        if (newPassword === currentPassword) {
            newPasswordFeedback.text('새 비밀번호는 현재 비밀번호와 다르게 입력하세요.');
            newPasswordFeedback.css('color', 'red');
        } else if (newPassword !== confirmPassword) {
            feedback.text('새 비밀번호가 일치하지 않습니다.');
            feedback.css('color', 'red');
        } else if (!validatePassword(newPassword)) {
            feedback.text('비밀번호 형식을 확인하세요.');
            feedback.css('color', 'red');
        } else {
            $.ajax({
                url: 'UserServlet',
                type: 'POST',
                data: {
                    pagecode: 'changePassword',
                    currentPassword: currentPassword,
                    newPassword: newPassword
                },
                success: function(response) {
                    if (response === 'success') {
                        window.location.href = 'viewAccount.jsp';
                    } else if (response === 'invalid_current_password') {
                        currentPasswordFeedback.text('현재 비밀번호가 잘못되었습니다.');
                        currentPasswordFeedback.css('color', 'red');
                    } else if (response === 'same_as_current_password') {
                        newPasswordFeedback.text('새 비밀번호는 현재 비밀번호와 다르게 입력하세요.');
                        newPasswordFeedback.css('color', 'red');
                    } else {
                        feedback.text('비밀번호 변경에 실패했습니다.');
                        feedback.css('color', 'red');
                    }
                }
            });
        }
    });

    function validatePassword(password) {
        var hasUpperCase = /[A-Z]/.test(password);
        var hasLowerCase = /[a-z]/.test(password);
        var hasNumbers = /\d/.test(password);
        var hasNonalphas = /\W/.test(password);

        var validationCount = [hasUpperCase, hasLowerCase, hasNumbers, hasNonalphas].filter(Boolean).length;

        return password.length >= 8 && password.length <= 16 && validationCount >= 2;
    }

    $('#backButton').on('click', function() {
        window.location.href = 'viewAccount.jsp';
    });
</script>
</body>
</html>
