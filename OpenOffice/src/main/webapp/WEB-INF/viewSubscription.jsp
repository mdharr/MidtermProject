<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Subscription</title>
<%@ include file="bootstrapHead.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="containers text-center">
		<div class="row">
			<div class="col  text-center zoom">
				<div class="card-title title-container">
					<h3>
						Companies <a href="userBio?userId=${user.id }">${fn:toUpperCase(user.username) }</a>
						Is Subscribed To:
					</h3>
					<c:forEach var="company" items="${user.companies}">
						<div class="card yellow-containers">
							<p>
								<a href="companyBio?companyId=${company.id}">${company.name }</a>
							</p>
							<form action="unsubscribe.do" method="post">
								<input type="submit" value="Unsubscribe" /> <input type="hidden"
									name="userId" value="${user.id }" /> <input type="hidden"
									name="companyId" value="${company.id }" />
							</form>
						</div>


					</c:forEach>
				</div>
			</div>
		</div></div>
		<%@include file="footer.jsp"%>
		<%@ include file="bootstrapFoot.jsp"%>
</body>
</html>


