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
@WebServlet("/Delete.html")
public class DeleteServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        int row = Integer.parseInt(request.getParameter("Number"))-1;
        model.removeEntry(row);
        request.setAttribute("NumberPatients",model.getSize());
        model.Print();
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/Delete.jsp");
        dispatch.forward(request, response);
    }
}
