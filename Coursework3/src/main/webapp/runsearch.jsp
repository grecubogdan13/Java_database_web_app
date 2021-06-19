<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.data.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Search Result</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Search Result</h2>
  <%
    String st = (String) request.getParameter("searchstring");
  %>
  You searched for <%=st%>.
  <%
    ArrayList<String> patients = (ArrayList<String>) request.getAttribute("result");
    ArrayList<Integer> link= (ArrayList<Integer>) request.getAttribute("links");
    int j=0;
    if (patients.size() !=0)
    {
    %>
    <ul>
      <%
        for (String patient : patients)
        {
          int i = link.get(j);
          j++;
      %>
      <li><%=patient%> : Link to patient: <a href="Details_from_Search.html?Number=<%=i+1%>">Details</a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
  <a href="search.html">BACK</a>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>