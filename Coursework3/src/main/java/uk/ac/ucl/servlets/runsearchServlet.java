package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/runsearch.html")
public class runsearchServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    Model model = ModelFactory.getModel();
    String searching = request.getParameter("searchstring");
    ArrayList<String> searchResult = model.searchFor(searching);
    ArrayList<Integer> linesResult = model.searchForInt(searching);
    request.setAttribute("result", searchResult);
    request.setAttribute("links",linesResult);
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/runsearch.jsp");
    dispatch.forward(request, response);
  }
}
