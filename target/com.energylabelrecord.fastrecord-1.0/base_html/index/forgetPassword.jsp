<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>忘记密码</title>
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
    <h3>邮箱找回密码</h3>
    <form id="formid" class="m-t" method="post" role="form" action="../../user/mail.do">
      <div class="form-group">
        <input name="loginName" type="text" class="form-control" placeholder="请输入用户名">
      </div>
      <button type="submit" id="subbutton" class="btn btn-primary block full-width m-b">发送邮件</button>
    </form>
  </div>
  
</div>

<!-- 全局js -->
<script src="../../base_ui/js/jquery-1.11.1.min.js"></script>
<script src="../../base_ui/js/bootstrap.min.js"></script>
<script src="../../base_ui/js/jquery.validate.js"></script>
<script type="text/javascript">
    
   $().ready(function() {
     $("#formid").validate({
     	rules: {
   			loginName: {
    			required: true
   			}
  		},
        messages: {
   			loginName: {
    			required: "请输入登录名"
   			}
   		},
   		submitHandler: function(form) 
   		{  
   			 submitData();
   		}
     });
    });
    
    
    function submitData(){
    
      $.ajax({
      type: "POST",
    url: "../../user/mail.do",
    data:$('#formid').serialize(),
    async:false,
    success: function(data) {
             if(data.result){
     	alertText("info","邮件已发送至账号对应的邮箱地址,请注意查收邮箱",60000);  
     time($("#subbutton"));
     }else{
    	 alertText("danger",data.err,5000);  
     }
    }
    });
    }
    
    var wait=60;
    function time(o) {
        if (wait == 0) {
            o.removeAttr("disabled");            
            o.html("发送邮件");
            wait = 60;
        } else {
            o.attr("disabled", true);
            o.html("(" + wait + ")秒后,重新发送");
            wait--;
            setTimeout(function() {
                time(o);
            },
            1000);
        }
    }
    function alertText(type,msg,time){
    	if(!type){
    		type="info";
    	}
    	if(!msg){
    		msg="操作成功";
    	}
    	var alert_div = $('<div class="alert alert-'+type+' alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>'+msg+'</div>');
			$("#formid").append(alert_div);
			setTimeout(function() {
                alert_div.remove();
            },
            time);	
    }
    </script>
</body>
</html>
