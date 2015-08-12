<%-- 
    Document   : game
    Created on : Aug 5, 2015, 4:41:04 PM
    Author     : A0136420U
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/card.css" type="text/css">
        <title>Set Card</title>
        <script type = "text/javascript">  
            var i = 0;
  var count = 0;// = new int[3];
            
 /*function customSubmit()
 {  
     i=i+1;
     switch(i)
     {
    case 1:
        document.form.id1.value = this.id;  
        break;
    case 2:
        document.form.id2.value = this.id; 
        case 3:
        document.form.id3.value = this.id; 
        break;
    default:
        break;
     }
 }*/
 
    function setColor(btn) {
        var property = document.getElementById(btn); 
        if(count<3) { 
           // property.style.backgroundColor = "#7FFF00";
           switch(count)
     {
    case 0:document.form.id1.value = btn;
        //var a = 1;  
        break;
    case 1:document.form.id2.value = btn;
        //var b = 2; 
        case 2:document.form.id3.value = btn;
        //var c = 3; 
        break;default:
        break;
     }
            count = count+1;
        }
    }
 function clicked()
 {
     
     //document.form.action = "check?id1="+a+"&id2="+b+"&id3="+c+"";     
     
    document.form.submit();  
 }  
</script>  
    </head>
    <body>
        <form id="form" name="form" action="setcard" method=get>
            <input type=hidden name="id1" value=""/>  
            <input type=hidden name="id2" value=""/>  
            <input type=hidden name="id3" value=""/>  
        <c:set var="count" value="0" scope="page" />
        <table class="borderAll"><tr>
           
            <% int i = 0; int j = 0;%>
                <c:forEach var="card" items="${cards}" varStatus="status">
<%--
for (i = j ; i < 12 ; i++)
{
    --%>
    <%--<td style="width:120px; height:120px;"><input type="image" id="${count=count+1}"  onclick="setColor('${count}')" src="cards/${card}.gif"/></td>--%>
        <%--<td><input type="button" style= "background-color:rgb(255, 255, 255) ;width:120px; height:120px" id="${count=count+1}" onclick="setColor('${count}')"/></td>--%>
        <td><input type="button" style= "background-image:url(cards/${card}.gif) ;width:100px; height:70px" id="${count=count+1}" onclick="setColor('${count}')"/></td>
            
                        <%if((j+4)%3 == 0) { %>
                        </tr> <tr>
                         <% 
                           } j = j +1;        %>
                </c:forEach></tr>
                                  
        </table>
                <input type="submit" value="Submit" ><%--onclick="clicked()">--%> 
                <input type="reset" value="Clear" ></form>
    </body>
</html>
