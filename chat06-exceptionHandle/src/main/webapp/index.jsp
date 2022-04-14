<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  language="java" %>
<html>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    姓名：<input name="name"/><br/>
    密码：<input name="pass"/><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
