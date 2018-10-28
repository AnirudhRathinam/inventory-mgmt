<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Inventory Management</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Inv Mgmt</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">All Items</a></li>
      <li><a href="/addItem">New Item</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
	<c:choose>
	
		<c:when test = "${ mode == 'ITEM_VIEW'}">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Item Name</th>
			        <th>Quantity</th>
			        <th>Purchase Date</th>
			        <th>Edit</th>
			        <th>Delete</th>
			      </tr>
			    </thead>
			    <tbody>
				    <c:forEach var = "item" items="${items}">
			         	<tr>
			         		<td>${ item.id }</td>
			         		<td>${ item.itemName }</td>
			         		<td>${ item.quantity }</td>
			         		<td>${ item.purchaseDate }</td>
			         		<td>
			         			<a href="updateItem?id=${item.id}">
			         				<div class="btn btn-primary">Edit</div>
			         			</a>
			         		</td>
			         		<td>
			         			<a href="deleteItem?id=${item.id}">
			         				<div class="btn btn-danger">Delete</div>
			         			</a>
			         		</td>
			         	</tr>
			      	</c:forEach>
			    </tbody>
			</table>
		</c:when>
		
		<c:when test = "${ mode == 'ITEM_EDIT' || mode == 'ITEM_NEW' }">
			<form action="save" method="POST">
			
			  <input type=hidden class="form-control" value="0" value="${item.id}" name="id" id="id">
			  <!-- value="${item.id}" -->
			  
			  <div class="form-group">
			    <label for="itemName">Item Name:</label>
			    <input type="text" class="form-control" value="${ item.itemName }" name="itemName" id="itemName">
			  </div>
			  
			  <div class="form-group">
			    <label for="quantity">Quantity:</label>
			    <input type="number" class="form-control" value="${ item.quantity }" name="quantity" id="quantity">
			  </div>
			  
			  <div class="form-group">
			    <label for="purchaseDate">Purchase Date:</label>
			    <input type="date" class="form-control" value="${ item.purchaseDate }" name="purchaseDate" id="purchaseDate">
			  </div>		
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			  
			</form>
		</c:when>
		
	</c:choose>
</div>

</body>
</html>
