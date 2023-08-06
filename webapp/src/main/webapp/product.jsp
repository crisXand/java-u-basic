<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.List, com.chr.webapp.models.Product, com.chr.webapp.services.*, java.util.Optional"
    %>

<% 	
List<Product> products = (List<Product>) request.getAttribute("products"); 
LoginService auth = new LoginServiceImp();
Optional<Cookie> cookieOptional = auth.getCookie(request, "username");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
		<% if(cookieOptional.isPresent()) {%>
			<li><%= cookieOptional.get().getValue() %></li>
			<li><a href="<%=request.getServletContext().getContextPath() %>/logout">Logout</a></li>
		<%} %>
		</ul>
	</nav>
	
	<table>
		
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<% if(cookieOptional.isPresent()) {%>
			<td>Precio </td>
			<%} %>
		</tr>
		<tbody>
			<% for(Product p:products) {%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<% if(cookieOptional.isPresent()) {%>
					<td><%= p.getPrice()%> </td>
					<%} %>
				</tr>	
			<% } %>
		</tbody>
		
	</table>
</body>
</html>