<%--
  Created by IntelliJ IDEA.
  User: vitthalawate
  Date: 29/8/16
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="Hello world JSTL"></c:out>

<jsp:useBean id="test" class="beans.TestBeans" scope="page"></jsp:useBean>

<p>Bean: <c:out value="${test.info}" /></p>
</body>
</html>
