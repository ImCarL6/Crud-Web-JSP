<%-- 
    Document   : insertCliente
    Created on : 5 de nov. de 2021, 20:26:32
    Author     : carlo
--%>

<%@page import="br.com.dao.ClienteDAO"%>
<%@page import="br.com.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Cliente u = new Cliente();
            u.setNome(request.getParameter("nome"));
            u.setCpf(request.getParameter("cpf"));
            
            ClienteDAO dao = new ClienteDAO();
            dao.salvarCliente(u);
        %>
    </body>
</html>
