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
@WebServlet("/DeleteInfo.html")
public class DeleteInfoServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        request.setAttribute("tableColumns",model.getTableHeads());
        int row = Integer.parseInt(request.getParameter("Number"))-1;
        int fieldIndex = Integer.parseInt(request.getParameter("Field"))-1;
        model.removeField(fieldIndex,row);
        request.setAttribute("NumberPatients",model.getSize());
        model.Print();
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/DeleteInfo.jsp");
        dispatch.forward(request, response);
    }
}
