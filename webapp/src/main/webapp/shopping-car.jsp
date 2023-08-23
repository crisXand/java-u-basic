<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.chr.webapp.models.ShoppingCar, com.chr.webapp.models.CarItem"%>
    
<% ShoppingCar car = (ShoppingCar) session.getAttribute("car"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(car == null || car.getCar().isEmpty() ){%>
			<h2>Carrito de compras vacio</h2>
	<% }else{ %>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Total</th>
				</tr>
			</thead>
			
				<tbody>
				<% for(CarItem item: car.getCar()) {%>
					<tr> 
						<td><%= item.getProduct().getName() %></td>
						<td><%= item.getProduct().getPrice() %></td>
						<td><%= item.getAmount() %></td>
					</tr>
					
				<%} %>
					<tr>
						<td colspan="2">Total</td>
						<td> <%= car.getTotal() %></td>
					</tr>
				</tbody>
			
		</table>
	<% } %>
</body>

<a href = "<%= request.getContextPath() %>/products">Regresar a productos</a>
</html>