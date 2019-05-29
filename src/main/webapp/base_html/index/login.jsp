<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="翰维科技后台主题,bootstrap框架,响应式布局,使用了Html5+CSS3等技术">
    <meta name="description" content="翰维科技后台主题,bootstrap框架,响应式布局,使用了Html5+CSS3等技术">
    <title>登录 - 翰维系统框架2.0</title>

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
  <div style="margin-top:180px;">
    <h3 style="font-size:28px;">自主诚信备案系统</h3>
    <form class="m-t" method="post" id="login_form" role="form" action="../../j_spring_security_check?callback=html/index/login.jsp">
      <div class="form-group">
        <input name="j_username" type="text" class="form-control" placeholder="用户名" required>
      </div>
      <div class="form-group">
        <input name="j_password" type="password" class="form-control" placeholder="密码" required>
      </div>
      <div id ='code' class="form-group ver_code">
        <div class="input-group">
          <input id='captcha' class="form-control" placeholder="验证码" type="text" name="captcha_value" required>
          <span class="input-group-addon">
              <a href="javascript:;" onclick="javascript:refresh();">
                  <img  height="34px" width="91px" src="" id="code_img">
              </a>
          </span> </div>
      </div>
        <div class="form-group col-sm-8" style="text-align: left" id="valid_area">
        </div>
      <label class="error">${! empty jcaptcha?jcaptcha:SPRING_SECURITY_LAST_EXCEPTION.message}</label>
      <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
    </form>
  </div>
</div>

<!-- 全局js -->
<script src="../../base_ui/js/jquery-1.11.1.min.js"></script>
<script src="../../base_ui/js/bootstrap.min.js"></script>
<script src="../../base_ui/js/jquery.validate.js"></script>

    <script type="text/javascript">
        $('#login_form').validate({
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
    $("#code_img")[0].src="../../jcaptcha/generatImage.do";
    
    }
    
    function refresh() {
        $('#code_img').hide().attr(
                'src',
                '')
                .fadeIn();
        $('#code_img').show().attr(
                'src',
                "../../jcaptcha/generatImage.do?"+Math.random())
                .fadeIn();
    }
    </script>
</body>
</html>
