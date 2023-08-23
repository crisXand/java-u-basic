<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.List, com.chr.webapp.models.Product, com.chr.webapp.services.*, java.util.Optional"
    %>

<% 	
	List<Product> products = (List<Product>) request.getAttribute("products"); 
	LoginService auth = new LoginSessionServiceImpl();
	Optional<String> cookieOptional = auth.getUser(request, "user");
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
			<li><%= cookieOptional.get() %></li>
			<li><a href="<%=request.getServletContext().getContextPath() %>/session/logout">Logout</a></li>
		<%} %>
		</ul>
	</nav>
	
	<table>
		
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<% if(cookieOptional.isPresent()) {%>
			<td>Precio </td>
			<td>Accion</td>	
			<%} %>
		</tr>
		<tbody>
			<% for(Product p:products) {%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<% if(cookieOptional.isPresent()) {%>
					<td><%= p.getPrice()%> </td>
					<td><a href = "<%= request.getContextPath()%>/shopping/add-product?id=<%=p.getId()%>">Add to car</a></td>
					<%} %>
				</tr>	
			<% } %>
		</tbody>
		
	</table>
	<h1> <%= (String)request.getAttribute("requestAttribute") %></h1>
	<h1> <%= request.getServletContext().getAttribute("contextAttribute") %></h1>
</body>
</html>