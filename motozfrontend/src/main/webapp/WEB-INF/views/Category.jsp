 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
 <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">	
<script>
	
	$(document).ready(function() {
		$('#table_id').dataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ]
		});
	});
</script>	
<title>motoz</title>
<body style="background-color:#ba81d3">
<jsp:include page="header.jsp"></jsp:include> 
<c:if test="${check}">
<form:form class="form-horizontal" style="color:white" action="getcategory" method="post" modelAttribute="category">
<fieldset>

<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>

<!-- Select Basic -->
<h3>CATEGORY</h3> <br>

<!-- Select Basic -->

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="address">name</label>
 <div class="col-md-4">
<form:input type="text" id="address" name="address" placeholder="" class="form-control input-md" required="" path="name"/>
</div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">Description</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="description"/>
</div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">Submit</button>
  </div>
</div>
</fieldset>


</form:form>
</c:if>
<c:if test="${!check}">
<form:form class="form-horizontal" style="color:white" action="updcat"  method="post" modelAttribute="category">
<fieldset>

<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>

<!-- Select Basic -->
<h3>CATEGORY</h3> <br>
<!-- Select Basic -->
<div class="form-group">
 <div class="col-md-4">
<form:input type="hidden" id="address" name="address" placeholder="" class="form-control input-md" required="" path="id"/>
</div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="address">name</label>
 <div class="col-md-4">
<form:input type="text" id="address" name="address" placeholder="" class="form-control input-md" required="" path="name"/>
</div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">Description</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="description"/>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">update</button>
  </div>
</div>
</fieldset>
</form:form>
</c:if>
<div>
<table id="table_id" class="table table-condensed">
<thead>
<tr>
<td>Category id</td>
<td>Category Name</td>
<td>Description</td>
</tr>
</thead>
<tbody>
<c:forEach items="${catable}" var="c">
<tr>
<td>${c.getId()}</td>
<td>${c.getName()}</td>
<td>${c.getDescription()}</td>
<td> <div>
<a class="btn icon-btn btn-success"
href="editcat?g etcatid=${c.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
<a class="btn icon-btn btn-danger"
href="delcat/${c.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
</div></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<jsp:include page="footer.jsp"></jsp:include> 

