<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码重置</title>
<style>
* {
	margin: 0;
	padding: 0;
}
body {
	font-family: "Microsoft Yahei";
}
.email-wrap {
	width: 646px;
	margin: 20px auto;
	border: 3px solid #1ab395;
	border-radius: 3px;
}
.logo {
	padding: 33px 35px 24px;
}
.border-ed {
	border-bottom: 1px solid #ededed;
}
.pl-35 {
	padding-left: 35px;
	padding-right: 20px;
}
.account {
	font-size: 16px;
	line-height: 43px;
	padding-top: 5px;
	padding-bottom: 5px;
	color: #787878;
}
.account-p {
	color: #3a3a3a;
	font-size: 18px;
}
.link {
	padding-bottom: 25px;
}
.link a {
	font-size: 12px;
	color: #2375ee;
	word-break: break-all;
}
.reset {
	font-size: 14px;
	color: #494949;
	padding-top: 21px;
}
.reset button {
	display: inline-block;
	width: 91px;
	height: 33px;
	line-height: 33px;
	background: #1ab395;
	border-radius: 2px;
	border: none;
	font-size: 14px;
	text-align: center;
	color: #fff;
	cursor: pointer;
}
.link-p {
	line-height: 22px;
}
.tips, .aging {
	font-size: 14px;
	margin: 22px 0;
}
.tips {
	color: #838383;
}
.aging {
	color: #9d9d9d;
}
.issuer, .release-time {
	text-align: right;
	color: #838383;
	line-height: 24px;
}
.issuer {
	font-size: 14px;
	font-weight: bold;
}
.release-time {
	font-size: 12px;
}
.statement {
	padding-top: 30px;
	line-height: 24px;
	color: #7f7e7e;
	font-size: 12px;
	text-align: center;
}
.copyright {
	color: #979696;
	font-size: 12px;
	height: 81px;
	line-height: 81px;
	text-align: center;
}
</style>
</head>

<body>
<div class="email-wrap">
  <div class="account border-ed pl-35">
    <p class="account-p">Hi,<span id="account-id">${arg0}</span></p>
    <p class="">以下是您的密码重置信息，请查收：</p>
  </div>
  <div class="link border-ed pl-35">
    <p class="reset"> <span>您可以通过点击验证按钮或链接完成密码重置验证：</span>
    </p>
    <p class="link-p"> <a href="${arg1}" id="link_a">${arg2}</a> </p>
    <p class="tips">(如果点击链接没有反应,请复制上述链接,粘贴浏览器地址栏后访问）</p>
    <p class="aging">重置变更链接10分钟内有效，超过10分钟请重新申请变更</p>
    <p class="issuer">翰维科技</p>
    <p class="release-time">${arg3}</p>
  </div>
  <div class="statement pl-35"> 如果您错误的收到了此邮件，请不要点击激活链接，该帐号将不会被变更。这是一封系统<br />
    自动发出的邮件，请不要直接回复，如您有任何疑问，请联系service@hitworth.com </div>
  <div class="copyright"> HitWorth Technology Development Co. Ltd.&copy;2014 北京翰维科技发展有限公司 版权所有 京ICP备14039590号 </div>
</div>
</body>
</html>
