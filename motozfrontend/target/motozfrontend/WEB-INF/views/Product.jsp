<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">	
<script>
	$(document).ready(function(){
	$('#table_id').dataTable({
	"pagingType" : "full_numbers",
	"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ]
		});
	});
	</script>
 <title>motoz</title>
<style>
table, th, td {
    border: 1px solid white;
}
</style>
<body style="background-color:#ba81d3">
<jsp:include page="header.jsp"></jsp:include> 
<c:if test="${check}">
<form:form class="form-horizontal" style="color:white" action="getproduct" modelAttribute="product" encType="multipart/form-data">
<fieldset>
<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>
<!-- Select Basic -->
<h3>PRODUCT</h3> <br>
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
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">quantity</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="quantity"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">price</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="price"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">Suppliername</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Suppliername"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">categoryname</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="categoryname"/>
</div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">Product Image</label>
 <div class="col-md-4">
<form:input id="File" type="File" name="phoneno" placeholder="" class="form-control input-md" required="" path="ProdImage"/>
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
<form:form class="form-horizontal" style="color:white" action="updprodu"  modelAttribute="product" encType="multipart/form-data">
<fieldset>
<!-- Form Name -->
<center><legend><a style="color:white">ADMIN</a></legend></center>
<!-- Select Basic -->
<h3>PRODUCT</h3> <br>

<div class="form-group">
 <div class="col-md-4">
<form:input type="hidden" id="address" name="address" placeholder="" class="form-control input-md" required="" path="id"/>
</div>
</div>
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
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">quantity</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="quantity"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">price</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="price"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">Suppliername</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="Suppliername"/>
</div>
</div>
<div class="form-group">
<label class="col-md-4 control-label" for="phoneno">categoryname</label>
 <div class="col-md-4">
<form:input type="text" id="phoneno" name="phoneno" placeholder="" class="form-control input-md" required="" path="categoryname"/>
</div>
</div>

<div class="form-group">	
<label class="col-md-4 control-label" for="phoneno">Product Image</label>
 <div class="col-md-4">
<form:input id="File" type="File" name="phoneno" placeholder="" class="form-control input-md" required="" path="ProdImage"/>
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
<table id="table_id" class="table table-condensed">
<thead>
<tr>
<td>Product image</td>
<td>Product id</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Product Quantity</td>
<td>Product Price </td>
<td>Product Suppliername </td>
<td>Product Categoryname </td>
</tr>
</thead>
<tbody>
<c:forEach items="${producter}" var="p">
<tr>
<td> <img style="vertical-align:bottom;"width="120" height="60" src="resources/ProductImage/${p.getId()}.jpg"/> </td>
<td>${p.getId()} </td>
<td>${p.getName()} </td>
<td>${p.getDescription()} </td>
<td>${p.getQuantity()}</td>
<td>${p.getPrice()} </td>
<td>${p.getSuppliername()} </td>
<td>${p.getCategoryname()} </td>
<td> <div>
<a class="btn icon-btn btn-success"
href="editprodu?getproduid=${p.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
<a class="btn icon-btn btn-danger"
href="delprodu?pid=${p.getId()}"><span
class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
</div></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<jsp:include page="footer.jsp"></jsp:include> 

