<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.com.fiap.investSimples.model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> listas = (ArrayList<JavaBeans>) request.getAttribute("listaEntradas");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<h1>Lista de Produtos</h1>

	<a href="Entrada-Novo.jsp">Adicionar Nova Entrada</a>

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Data de Lançamento</th>
				<th>Valor</th>
				<th>Tipo</th>
				<th>Descrição</th>
				<th>Cliente</th>
			</tr>
		</thead>
		<tbody>
		<% if (listas != null) { %>
			<%for (int i = 0;i < listas.size();i++) { %>
				<tr>
					<td><%=listas.get(i).getId() %></td>
					<td><%=listas.get(i).getDataLancamento() %></td>
					<td><%=listas.get(i).getValor() %></td>
					<td><%=listas.get(i).getTipo() %></td>
					<td><%=listas.get(i).getDescricao() %></td>
					<td><%=listas.get(i).getCliente() %></td>
				</tr>
			<%} %>
			<% } else { %>
			    <tr>
			        <td colspan="6">No data available</td>
			    </tr>
<% } %>
		</tbody>
	</table>
</body>
</html>