<%-- 
    Document   : GameSelect
    Created on : Aug 9, 2015, 10:59:14 PM
    Author     : KARTHIK R
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Card</title>
       <script type = "text/javascript">  
            var i = 0;
  var count = 0;
  
    function setColor(btn) {
        var property = document.getElementById(btn); 
        document.form2.gameid.value = btn;
    }
 function clicked()
 {
    document.form2.submit();  
 }  
</script>  
    </head>
    <body>
        <form id="form2" name="form2" action="setcard" method=get>
            <input type=hidden name="gameid" value=""/> 
        <c:set var="count" value="0" scope="page" />
        <table class="borderAll">
           
            <% int i = 0; int j = 0;%>
                <c:forEach var="gaming" items="${games}" varStatus="status">
                    <%-- <!--<td><c:out value="${count}"/></td>  -->--%>
                <tr><td><input type="button" style="width:100px; height:70px" id="${count=count+1}" value="${gaming.gameid}" onclick="setColor('${gaming.gameid}')"/>
                    </td> </tr>
              
                </c:forEach>
                                  
        </table>
                <input type="submit" value="Submit" ><%--onclick="clicked()">--%> 
                <input type="reset" value="Clear" ></form>
    </body>
</html>
