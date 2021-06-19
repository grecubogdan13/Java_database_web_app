<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <%
        ArrayList<String> headers = (ArrayList<String>) request.getAttribute("tableColumns");
        int i=Integer.parseInt(request.getParameter("Field"))-1;
        int j=Integer.parseInt(request.getParameter("Number"))-1;
        String head=headers.get(i);
    %>
    <title>Delete <%=head%> for patient number <%=j+1%></title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>You deleted field <%=head%> for patient number <%=j+1%>!</h2>
<a href="Details.html?Number=<%=j+1%>">OK</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
