<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<nav class="navbar navbar-expand-lg sticky-top navbar-custom">
	<div class="container">
		<a class="navbar-brand zoom" href="home"><img id="site-logo"
			src="https://i.ibb.co/RYhZBvf/open-office-logo.png"
			alt="open-office-logo" border="0"></a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbar1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar1">
			<ul class="navbar-nav ms-auto" style="vertical-align: middle;">
				<c:choose>
					<c:when test="${sessionScope.user != null && sessionScope.user.role }">
						<li class="nav-item active"><a class="nav-link zoom"
							href="userSessionBio?userId=${sessionScope.user.id }"><img
								class="user-profile-pic" src="${sessionScope.user.imgUrl }"></a></li>
						<li class="nav-item active"><a class="nav-link zoom"
							href="loggingOut.do">Logout</a></li>
						<li><a class="nav-link zoom" href="search">Search</a></li>
						<li><a class="nav-link zoom" href="adminCenter">Admin</a></li>
					</c:when>
					<c:when test="${sessionScope.user != null }">
						<li class="nav-item active"><a class="nav-link zoom"
							href="userSessionBio?userId=${sessionScope.user.id }"><img
								class="user-profile-pic" src="${sessionScope.user.imgUrl }"></a></li>
						<li class="nav-item active"><a class="nav-link zoom"
							href="loggingOut.do">Logout</a></li>
						<li><a class="nav-link zoom" href="search">Search</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item active"><a class="nav-link zoom"
							href="login">Login</a></li>

						<li class="nav-item"><a class="nav-link zoom" href="register">Register</a>
						</li>
						<li class="nav-item"><a class="nav-link zoom" href="search">Search</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

