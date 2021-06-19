<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient List</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patient List:</h2>
  <a href="index.html">Back</a>
  <table>
    <tr>
      <td><a href="new_patient.html">Add New Patient</a>
    </tr>
  </table>
  <table border="1">
    <thead>
      <tr>
        <%
          String head = (String) request.getAttribute("mainTableHead");
        %>
          <th>Nr.</th>
          <th><%=head%></th>
          <th>Details</th>
          <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <%
        int i;
        int n=(int) request.getAttribute("NumberPatients");
        ArrayList<String> elements = (ArrayList<String>) request.getAttribute("Cell");
        for(i=0;i<n;i++) {
    %>
        <tr>
            <%
                String element = elements.get(i);
            %>
            <td><%=i+1%></td>
            <td><%=element%></td>
            <td><a href="Details.html?Number=<%=i+1%>" >Details</a></td>
            <td><a href="Delete.html?Number=<%=i+1%>" >Delete</a></td>
            <%}%>
        </tr>
    </tbody>
  </table>
  <br>
  <a href="save.html">Save data</a>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
