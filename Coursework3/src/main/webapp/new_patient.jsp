<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Add New Patient</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<%
    String head = (String) request.getAttribute("mainTableHead");
%>
<h2>Add New Patient <%=head%> below:</h2>
<br>
<form action="NewPatientConfirmation.html" >
    Field:
    <input type="text" name="new_data" placeholder="type here" />
    <input type="submit" value="done" />
</form>
<a href="patientList.html">BACK</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
