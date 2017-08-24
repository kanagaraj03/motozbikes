<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
form {
	margin: 0px 10px;
}

h2 {
	margin-top: 2px;
	margin-bottom: 2px;
}

.container {
	max-width: 360px;
}

.divider {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 5px;
}

.divider hr {
	margin: 7px 0px;
	width: 35%;
}

.left {
	float: left;
}

.right {
	float: right;
}
</style>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form:form method="POST" role="form" modelAttribute="Customermodel" action="getuser">
						<div class="form-group">
							<h2>Create account</h2>
						</div>
						<div class="form-group">
							<label class="control-label" for="signupName">Customername</label>
							<form:input id="signupName" type="text" maxlength="50"
								class="form-control" path="Customername" />

						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">E-mail</label>
							<form:input id="signupEmail" type="email" maxlength="50"
								class="form-control" path="Email" />
							
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmailagain">E-mail
								again</label>
<form:input id="signupEmailagain" type="email" maxlength="50"
class="form-control" path="Emailagain" />
						</div>
	<div class="form-group">
  <label class="control-label" for="signupPassword">Password</label>
 <form:input id="signupPassword" type="password" maxlength="25" class="form-control" path="Upassword"/>
  </div>
                       
<div class="form-group">
<label class="control-label" for="signupPasswordagain">Password again</label>
							<form:input id="signupPasswordagain" type="password"
								maxlength="25" class="form-control" path="Upasswordname" />
						</div>
						<button class="btn btn-info" type="submit" >Submit</button>
						<a href="login" class="btn btn-info" role="button">login</a>			
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
