<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${job.title }</title>
<%@ include file="bootstrapHead.jsp"%>
</head>

<body>
	<%@include file="navbar.jsp"%>
	<div class="yellow-containers">
	<div class="title-container zoom text-center">
				<h1>${fn:toUpperCase(job.title) } at
				${fn:toUpperCase(job.company.name) }</h1>
				</div>
		<div class="row col card text-center yellow-containers zoom">

			<p>${job.description }
				<br /> Salary: <br /> ${job.salary } <br> Certifications: <br />
				${job.certifications } <br /> Education: <br /> ${job.education }
				Skills: ${job.skills }
			</p>
		</div>
		<div class="text-center">
				<c:if test="${sessionScope.user.role }">
				<br />
					<a href="updateAJob?jobId=${job.id }"><button class="zoom btn button" style="color: white;">Update</button></a>
				</c:if>
				</div>
		<div class="row">
			<div class="col text-center yellow-containers zoom">
				<a href="allInterviews?jobId=${job.id }">${job.title} Interview
					experiences </a>
			</div>
			<c:choose>
				<c:when test="${sessionScope.user != null }">
					<div class="col card text-center yellow-containers zoom">
							<a href="sendToCreateInterview?jobId=${job.id }">Leave an
								interview experience at ${job.company.name } </a>

					</div>
				</c:when>
				<c:otherwise>
					<div class="col card text-center yellow-containers zoom">
						<a href="reviewJobLogin?jobId=${job.id }">Login to leave an interview
							experience at ${job.company.name }</a>
					</div>

				</c:otherwise>
			</c:choose>

		</div>
		<hr>
		<div class="title-container text-center zoom">
			<h1>Interviews</h1>
		</div>
		<c:forEach var="interview" items="${job.interviews }">
			<div class="row yellow-containers zoom">
				<div class="col text-center" style="margin: 10px;">
					<c:if test="${sessionScope.user.id == interview.user.id }">
						<h4 class="">Your
							Contribution:</h4>
					</c:if>
					<p>
						<a href="interviewBio?interviewId=${interview.id }">
							${interview.title }</a>
					</p>
					<c:if test="${sessionScope.user.id == interview.user.id }">
						<form action="updateInterview">
							<input type="hidden" name="companyId" value="${job.company.id}" />
							<input type="hidden" name="interviewId" value="${interview.id }" />
							<input class="zoom btn" type="submit" value="Update" />
						</form>
					</c:if>
				</div>
			</div>
		</c:forEach>
		<div class="card yellow-containers zoom text-center">
		<c:choose>
		<c:when test="${sessionScope.user != null }">
		<form action="createArticle.do" method="get">
			<button class="zoom btn" type="submit" style="color: white;">Add Article</button>
		</form>
		
		</c:when>
		<c:otherwise>
		<a href="login">Login to add an article</a>
		</c:otherwise>
		</c:choose>
	    </div>
		</div>
		<hr>

	<%@include file="footer.jsp"%>
	<%@ include file="bootstrapFoot.jsp"%>
</body>
</html>