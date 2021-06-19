<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Number <%=request.getParameter("Number")%></title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Patient number <%=request.getParameter("Number")%></h2>
    <a href="patientList.html">Back</a>
    <table border="1">
        <tr>
            <th>Position</th>
            <td><%=request.getParameter("Number")%></td>
        </tr>
        <tr>
            <%
                int i=Integer.parseInt(request.getParameter("Number"));
                int j=0;
                ArrayList<ArrayList<String>> allDetails = (ArrayList<ArrayList<String>>) request.getAttribute("Entries");
                ArrayList<String> details =allDetails.get(i-1);
                ArrayList<String> headers = (ArrayList<String>) request.getAttribute("tableColumns");
                for (String head:headers){
                    String detail=new String();
                    if(j<details.size())
                        detail = details.get(j);
                    else
                        detail="";
                    j++;
            %>
            <th><%=head%></th>
            <td><%=detail%></td>
            <td><a href="Modify.html?Number=<%=i%>&Field=<%=j%>" >Modify</a></td>
            <td><a href="DeleteInfo.html?Number=<%=i%>&Field=<%=j%>" >Delete</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
