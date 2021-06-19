<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <%
        int i=Integer.parseInt(request.getParameter("Number"));
        int j=(int) request.getAttribute("NumberPatients");
    %>
    <title> Delete patient number<%=i%></title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>You deleted patient number <%=i%>!</h2>
<a href="patientList.html">OK</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
