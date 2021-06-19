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
        String newData=(String) request.getParameter("data");
    %>
    <title><%=head%> for patient number <%=j+1%> successfully modified.</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
New value for field <%=head%> for patient number <%=j+1%> is <%=newData%>.
<br>
<a href="Details.html?Number=<%=j+1%>">OK</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
