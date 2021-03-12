<%-- 
    Document   : modificar
    Created on : Nov 17, 2020, 1:40:27 AM
    Author     : josueyox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BD Escuela Modificar</title>
    </head>
    <body>
         <h2>Modificar Registro</h2><br>
        
        <form action="AlumnosController?accion=actualizar" method="POST" autocomplete="off">
            
            <input id="id" name="id" type="hidden" value="<c:out value="${alumno.id}"/>" />
            
            <p>
                Nc:
                <input id="nc" name="nc" type="text" value="<c:out value="${alumno.nc}"/>"/>
            </p>
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text" value="<c:out value="${alumno.nombre}"/>"/>
            </p>
            <p>
                Domicilio:
                <input id="domicilio" name="domicilio" type="text" value="<c:out value="${alumno.domicilio}"/>"/>
            </p>
            <p>
                Telefono:
                <input id="telefono" name="telefono" type="text" value="<c:out value="${alumno.telefono}"/>"/>
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
