<%@page import="it.data.NumTelefono"%>
<%@page import="it.data.Contatto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>Ricerca per Cognome Effettuata</title>
</head>
<body class="bg-dark">
<% Contatto contatto = (Contatto)session.getAttribute("contatto");%>
<div class="container col-md-4 col-md-offset-4 justify-content-center align-content-center text-center text-light">
<h1 class="mt-5 h1 bg-primary text-white p-3 mb-3">Ricerca per Cognome</h1>
<table class="table">
  <thead>
  <tr>
      <th scope="col">NOME</th>
      <th scope="col">COGNOME</th>
      <th scope="col">EMAIL</th>
      <th scope="col">NUMERI</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= contatto.getNome() %></td>
      <td><%= contatto.getCognome() %></td>
      <td><%= contatto.getEmail() %></td>
      <td><% for(NumTelefono NumTel: contatto.getNumTelefoni()){ %>
			<%= NumTel.getNumTelefono()%>
		<%}%></td>
    </tr>
  </tbody>
</table>
<a class="btn btn-primary" href="index.html" role="button">Ritorna Alla Home</a>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>