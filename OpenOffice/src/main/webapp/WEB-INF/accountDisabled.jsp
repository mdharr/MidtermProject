<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account disabled</title>
<%@ include file="bootstrapHead.jsp"%>
</head>

<body>
	<%@include file="navbar.jsp"%>
<div class="yellow-containers zoom">
	<c:choose>
		<c:when test="${success }">
			<h1>Account has been Disabled</h1>

		</c:when>
		<c:otherwise>
			<h1>Ooops something went wrong</h1>

		</c:otherwise>
			<form action="enableAccount" method="get">
  					<button type="submit">Re-Enable</button>
 					 </form>
	</c:choose>
	</div>

	<%@include file="footer.jsp"%>
	<%@ include file="bootstrapFoot.jsp"%>
</body>
</html>
