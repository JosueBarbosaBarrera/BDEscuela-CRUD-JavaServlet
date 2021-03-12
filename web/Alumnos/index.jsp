<%-- 
    Document   : index
    Created on : Nov 17, 2020, 1:40:18 AM
    Author     : josueyox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BD Escuela Inicio</title>
    </head>
    <body>
        <h1>Base de Datos Escuela</h1>
        
        <a href="AlumnosController?accion=nuevo">Nuevo registro</a><br>
        <br>
            
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Nc</th>
                    <th>Nombre</th>
                    <th>Domicilio</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alumno" items="${lista}">
                    <tr>
                        <td><c:out value="${alumno.nc}"/></td>
                        <td><c:out value="${alumno.nombre}"/></td>
                        <td><c:out value="${alumno.domicilio}"/></td>
                        <td><c:out value="${alumno.telefono}"/></td>
                        <td><a href="AlumnosController?accion=modificar&id=<c:out value="${alumno.id}"/>">Modificar</a></td>
                        <td><a href="AlumnosController?accion=eliminarar&id=<c:out value="${alumno.id}"/>">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
