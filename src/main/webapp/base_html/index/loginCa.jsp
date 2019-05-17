<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CA用户登陆</title>
<meta name="keywords" content="翰维科技后台主题,bootstrap框架,响应式布局,使用了Html5+CSS3等技术">
<meta name="description" content="翰维科技后台主题,bootstrap框架,响应式布局,使用了Html5+CSS3等技术">

    <!-- CSS文件 -->
    <link href="../../base_ui/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../base_ui/css/font-awesome.css" rel="stylesheet">
    <link href="../../base_ui/css/animate.css" rel="stylesheet">
    <link href="../../base_ui/css/style.css" rel="stylesheet">
<style>
.ver_code span.input-group-addon{border:none;padding:0;}
</style>
</head>

<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
  <div>
    <div>
      <h1 class="logo-name">HW</h1>
    </div>
    <h3>欢迎使用 hitworth</h3>
    <form class="m-t" method="post" id="loginca_form" role="form" action="../../j_spring_security_ca_check?callback=html/index/loginCa.jsp">
      <div class="form-group">
        <input name="signature" type="text" class="form-control" placeholder="signature" required>
      </div>
            <div class="form-group">
        <input name="plainText" type="text" class="form-control" placeholder="plainText" required>
      </div>
            <div class="form-group">
        <input name="j_username" type="text" class="form-control" placeholder="用户名" required>
      </div>
      <div class="form-group">
        <input name="j_password" type="password" class="form-control" placeholder="密码" required>
      </div>
      <div id='code' class="form-group ver_code">
        <div class="input-group">
          <input class="form-control" placeholder="验证码" type="text" name="captcha_value" required>
          <span class="input-group-addon">
            <a href="javascript:;" onclick="javascript:refresh();">
                <img  height="34px" width="91px" src="" id="jcaptchaImg">
            </a>
          </span> </div>
      </div>
        <div class="form-group col-sm-8" style="text-align: left" id="valid_area">
        </div>
     <label class="error">${! empty jcaptcha?jcaptcha:SPRING_SECURITY_LAST_EXCEPTION.message}</label>  
      <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
      <p class="text-muted text-center"> <a href="forgetPassword.jsp"><small>忘记密码了？</small></a></p>
    </form>
  </div>
</div>

<!-- 全局js -->
<script src="../../base_ui/js/jquery-1.11.1.min.js"></script>
<script src="../../base_ui/js/bootstrap.min.js"></script>
<script src="../../base_ui/js/jquery.validate.js"></script>

    <script type="text/javascript">
        $('#loginca_form').validate({
            focusInvalid: true, // do not focus the last invalid input
            rules: {
                j_username: {
                    required: true
                },
                j_password: {
                    required: true
                },
                captcha_value:{
                    required: true
                },
                signature: {
                    required: true
                },
                plainText:{
                    required: true
                }
            },

            messages: {
                j_username: {
                    required: "请输入登录名。"
                },
                j_password: {
                    required: "请输入密码。"
                },
                captcha_value: {
                    required: "请输入验证码。"
                },
                signature: {
                    required: "请输入signature。"
                },
                plainText: {
                    required: "请输入plainText。"
                }
            },
            errorPlacement: function(error, element) {
                $("#valid_area").append(error);
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    
    if(<c:out value="${loginTime}" default="0"/><3){
    $("#code").remove();
  
    }else{
    $("#code").show();
    $("#jcaptchaImg")[0].src="../../jcaptcha/generatImage.do";
    
    }
    function refresh() {
        $('#jcaptchaImg').hide().attr(
                'src',
                '')
                .fadeIn();
        $('#jcaptchaImg').show().attr(
                'src',
                "../../jcaptcha/generatImage.do?"+Math.random())
                .fadeIn();
    }
    </script>
</body>
</html>
