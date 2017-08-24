 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">	
<script>
	$(document).ready(function() {
		$('#sup_id').dataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ]
		});
	});
</script>
<style>
table, th, td {
    border: 1px solid white;
}
</style>
<body style="background-color:#ba81d3">
<jsp:include page="header.jsp"></jsp:include> 
<c:if test="${check}">
<form:form class="form-horizontal" style="color:white" action="getsupplier" method="post" modelAttribute="supplier">
<fieldset>

<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>

<!-- Select Basic -->
<h3>SUPPLIER</h3> <br>
<!-- Text input-->
<label class="col-md-4 control-label" for="Supplier_Name">Supplier Name</label>
            <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="name"/>
            </div>
        </div>
        <br>
        <br>
 <div class="form-group">
            <label class="col-md-4 control-label" for="description">Address</label>
            <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Address"/>
            </div>
        </div>
 <div class="form-group">
  <label class="col-md-4 control-label" for="description">phone_no</label>
  <div class="col-md-4">
  <form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Phone"/>
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
<form:form class="form-horizontal" style="color:white" action="updsup" modelAttribute="supplier">
<fieldset>
<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>

<!-- Select Basic -->
<h3>SUPPLIER</h3> <br>

<div class="form-group">
 <div class="col-md-4">
<form:input type="hidden" id="address" name="address" placeholder="" class="form-control input-md" required="" path="id"/>
</div>
</div>

<!-- Text input-->
<label class="col-md-4 control-label" for="Supplier_Name">Supplier Name</label>
            <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="name"/>
            </div>
        </div>
        <br>
        <br>
 <div class="form-group">
            <label class="col-md-4 control-label" for="description">Address</label>
            <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Address"/>
            </div>
        </div>
 <div class="form-group">
  <label class="col-md-4 control-label" for="description">phone_no</label>
  <div class="col-md-4">
  <form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Phone"/>
            </div>
        </div>
        <!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">Update</button>
  </div>
</div>
</fieldset>
</form:form>
</c:if>
<div>
<table id="sup_id" class="table table-condensed">
<thead>
<tr>
<td>Supplier id</td>
<td>Supplier Name</td>
<td>Supplier Address</td>
<td>Supplier phone</td>
</tr>
</thead>
<tbody>
<c:forEach items="${supply}" var="s">
<tr>
<td>${s.getId()}</td>
<td>${s.getName()}</td>
<td>${s.getAddress()}</td>
<td>${s.getPhone()}</td>
<td> <div>
<a class="btn icon-btn btn-success"
href="editsup?getsupid=${s.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
<a class="btn icon-btn btn-danger"
href="delsup/${s.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
</div></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<jsp:include page="footer.jsp"></jsp:include> 
