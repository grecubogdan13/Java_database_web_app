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
    <title>Modify <%=head%> for patient number <%=j+1%></title>
</head>
<body>
<jsp:include page="/header.jsp"/>
New value for field <%=head%> for patient number <%=j+1%>.
<br>
<form action="ModifyConfirmation.html" >
    Field:
    <input type="text" name="data" placeholder="type here" />
    <input type="hidden" id="Number" name="Number" value=<%=j+1%> />
    <input type="hidden" id="Field" name="Field" value=<%=i+1%> />
    <input type="submit" value="done" />
</form>
<br>
<a href="Details.html?Number=<%=j+1%>">Back</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
