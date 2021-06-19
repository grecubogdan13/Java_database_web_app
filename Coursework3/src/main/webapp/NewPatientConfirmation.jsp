<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>New Patient Added successfully</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<%
    String head = (String) request.getAttribute("mainTableHead");
    String name = (String) request.getParameter("new_data");
%>
A new Patient with <%=head%>=<%=name%> has been added to the database.
<br>
<a href="patientList.html">OK</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
