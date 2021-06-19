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
@WebServlet("/ModifyConfirmation.html")
public class ModifyConfirmationServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        request.setAttribute("tableColumns",model.getTableHeads());
        int row = Integer.parseInt(request.getParameter("Number"))-1;
        int fieldIndex = Integer.parseInt(request.getParameter("Field"))-1;
        String newData=request.getParameter("data");
        model.updateField(fieldIndex,row,newData);
        model.Print();
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/ModifyConfirmation.jsp");
        dispatch.forward(request, response);
    }
}