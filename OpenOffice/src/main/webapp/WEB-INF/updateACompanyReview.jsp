<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update A Company Review</title>
<%@ include file="bootstrapHead.jsp"%>
</head>

<body>
	<%@include file="navbar.jsp"%>

	<div class="containers text-center">
		<div class="row">
			<div class="col text-center">
				<div class="card-title title-container zoom">
					<h3>Update a Company Review</h3>
				</div>
				<div class="containers zoom">
					<form action="updatingACompanyReview" method="POST">
						<input type="hidden" name="id" value="${review.id }">
						<div>
							<label for="title"><strong>Title:</strong></label> <input
								class="zoom" type="text" name="title" value="${review.title }">
						</div>
						<br />

						<div>
							<label for="content"><strong>Content:</strong></label> <input
								class="zoom" type="text" name="content" value="${review.content }">
						</div>
						<br />

						<div>
							<label for="pros"><strong>Pros:</strong></label> <input
								class="zoom" type="text" name="pros" value="${review.pros }">
						</div>
						<br />


						<div>
							<label for="cons"><strong>Cons:</strong></label> <input
								class="zoom" type="text" name="cons" value="${review.cons }">
						</div>
						<br />

						<div>
							<label for="advice"><strong>Advice:</strong></label> <input
								class="zoom" type="text" name="advice" value="${review.advice }">
						</div>
						<br /> <label for="recommendation">Recommended:</label> <select
							class="zoom" id="recommendation" name="recommendation">
							<option value="true"
								<c:if test="${review.recommendation }">selected</c:if>>Yes</option>
							<option value="false"
								<c:if test="${!review.recommendation }">selected</c:if>>No</option>
						</select> <br /> <br /> <label for="rating">Rating:</label> <select
							class="zoom" id="rating" name="rating">
							<option value="1"
								<c:if test="${review.rating == 1}">selected</c:if>>1</option>
							<option value="2"
								<c:if test="${review.rating == 2}">selected</c:if>>2</option>
							<option value="3"
								<c:if test="${review.rating == 3}">selected</c:if>>3</option>
							<option value="4"
								<c:if test="${review.rating == 4}">selected</c:if>>4</option>
							<option value="5"
								<c:if test="${review.rating == 5}">selected</c:if>>5</option>
							<option value="6"
								<c:if test="${review.rating == 6}">selected</c:if>>6</option>
							<option value="7"
								<c:if test="${review.rating == 7}">selected</c:if>>7</option>
							<option value="8"
								<c:if test="${review.rating == 8}">selected</c:if>>8</option>
							<option value="9"
								<c:if test="${review.rating == 9}">selected</c:if>>9</option>
							<option value="10"
								<c:if test="${review.rating == 10}">selected</c:if>>10</option>
						</select> <br /> <br />
						<div>
							<button class="zoom btn" type="submit" id="add-company-btn">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	<%@ include file="bootstrapFoot.jsp"%>
</body>
</html>