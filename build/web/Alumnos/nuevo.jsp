<%-- 
    Document   : nuevo
    Created on : Nov 17, 2020, 1:40:41 AM
    Author     : josueyox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BD Escuela Nuevo</title>
    </head>
    <body>
        <h2>Nuevo Registro</h2><br>
        
        <form action="AlumnosController?accion=insertar" method="POST" autocomplete="off">
            <p>
                Nc:
                <input id="nc" name="nc" type="text"/>
            </p>
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text"/>
            </p>
            <p>
                Domicilio:
                <input id="domicilio" name="domicilio" type="text"/>
            </p>
            <p>
                Telefono:
                <input id="telefono" name="telefono" type="text"/>
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
