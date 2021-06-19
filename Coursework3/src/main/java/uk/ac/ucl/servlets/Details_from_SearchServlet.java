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
import java.util.List;
@WebServlet("/Details_from_Search.html")
public class Details_from_SearchServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        request.setAttribute("tableColumns",model.getTableHeads());
        request.setAttribute("Entries",model.getData());
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/Details_from_Search.jsp");
        dispatch.forward(request, response);
    }
}
