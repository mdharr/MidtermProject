<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Office Baseline</title>
<%@ include file="bootstrapHead.jsp"%>
</head>

<body>
	<%@include file="navbar.jsp"%>
	<div class="containers text-center">
		<div class="row">
			<div class="col  text-center">
				<div class="card-title title-container zoom">
					<h3>Update a Article</h3>
				</div>

				<div class="card card-body text-center yellow-containers zoom">

					<form action="updatingAArticle" method="POST">

						<input type="hidden" name="id" value="${article.id}"> <input
							type="hidden" name="articleUrl" value="${article.articleUrl}">
						<input type="hidden" name="articleId" value="${article.id }">
						<label>Title:</label> <br> <input class="zoom" type="text" name="title"
							value="${article.title}"> <br><br> Industry: 
							<br />
							
							<select class="zoom" name="industryId">
							<c:forEach var="industry" items="${industryList }">
								<option value="${industry.id}" <c:if test="${article.industry.id == industry.id }">selected</c:if>>"${industry.name }"</option>
							</c:forEach>
							
						</select> <br /> <br> <label>Description:</label>
						<br>
						<textarea class="zoom" name="description" rows="4" cols="40">${article.description}</textarea>
						<br><br>
						<input class="zoom btn" type="submit" value="Update" />
						<br>
					</form>

				</div>
					<div class="card card-body text-center yellow-containers zoom">
						<form action="deletedArticle" method="post">
							<input type="hidden" name="articleId" value="${article.id }">
							<input class="zoom btn" type="submit" value="Delete Article" />
						</form>
					</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<%@ include file="bootstrapFoot.jsp"%>
</body>
</html>