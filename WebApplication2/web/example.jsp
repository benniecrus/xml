<%-- 
    Document   : example
    Created on : Mar 10, 2017, 4:21:27 PM
    Author     : Nam NV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:import var="doc" url="http://www.24h.com.vn/upload/rss/bongda.rss" charEncoding="UTF-8" />
        <x:parse var="rss" xml="${doc}" />
        <x:forEach select="$rss/rss/channel/item" var="item" >
            <br/>
            <x:out select="$item/description" escapeXml="false"/>
        </x:forEach>
        
        <c:import var="doc" url="person.xml" />
        <x:parse var="persons" xml="${doc}" />
        <x:forEach select="$persons/listperson/person" var="person" >
            <br/>
            <x:out select="$person/name[1]" />
            <x:out select="$person/name[2]" />
            <x:out select="$person/@code" />
        </x:forEach>
            
        
    </body>
</html>
