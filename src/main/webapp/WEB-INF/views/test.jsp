<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
テスト
<form:form modelAttribute="testForm" action="regist">
<dl>
  <dt>test</dt>
  <dd>
    <form:input path="test" />
    <form:errors path="test"/>
  </dd>
</dl>

<button type="submit">登録</button>
</form:form>
<c:forEach items="${testList}" var="item">
<p><c:out value="${item.test}" /></p>
</c:forEach>
<a href="../">Back to Top.</a>
</body>
</html>