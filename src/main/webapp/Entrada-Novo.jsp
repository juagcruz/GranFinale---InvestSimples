<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Entrada</title>
</head>
<body>

	<h1>Nova Entrada:</h1>
	
	<form action="novaEntrada" method="get">
		Tipo: <input type="text" name="tipo"><br> 
		Descrição: <input type="text" name="descricao"><br> 
		Valor (R$ 99,90): <input type="text" name="valor"><br> 
		<input type="submit" value="Adicionar">
	</form>
	
</body>
</html>