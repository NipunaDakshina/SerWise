<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 3/3/2023
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="popup" style="display:none;">
  <form >
    <label>Appoinment Id : </label><input name="id" value="<%=appoinmentId %>"><br>
    <label>Date to be reshedule : </label> <input type="date" value="<%=date%>"><br>
    <label>Time to be reshedule : </label> <input type="time" value="<%=time%>"><br>
    <label>To which date : </label><input type="date" name="resheduled_date"><br>
    <label>To which time : </label><input type="time" name="resheduled_time"><br>
    <input type="submit" value="Confirm"><br>
  </form>
</div>

</body>
</html>
