<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
きく
<form:form modelAttribute="qikuForm" action="regist">
<dl>
  <dt>question</dt>
  <dd>
    <form:input path="question" />
    <form:errors path="question"/>
  </dd>
</dl>

<button type="submit">登録</button>
</form:form>
<c:forEach items="${questionList}" var="item">
<p><c:out value="${item.question}" /></p>
</c:forEach>
<a href="../">Back to Top.</a>
</body>
</html>