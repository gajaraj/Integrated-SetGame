<%-- 
    Document   : GameCreate
    Created on : Aug 11, 2015, 10:27:15 AM
    Author     : A0136420U
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/setcard/process" method=post>
            <table>
                <tr>
                    <td>
                       GameID: 
                    </td>
                    <td>
                        <input type="text" name="gameid" size=15 maxlength=20>
                    </td>
                </tr>
                <tr>
                    <td>
                        Description:
                    </td>
                    <td>
                        <input type="text" name="description" size=15 maxlength=20>
                    </td>
                </tr>
                <tr>
                    <td>
                        Feature1:
                    </td>
                    <td>
                        <input type="text" name="feature1" size=15 maxlength=20>
                    </td>
                </tr>
                <tr>
                    <td>
                        Feature2:
                    </td>
                    <td>
                        <input type="text" name="feature2" size=15 maxlength=20>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Submit"> <input type="reset"  value="Reset">
        </form>       
    </body>
</html>
