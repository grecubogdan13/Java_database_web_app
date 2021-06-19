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
@WebServlet("/NewPatientConfirmation.html")
public class NewPatientConfirmationServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        request.setAttribute("mainTableHead",model.getID());
        String newEntry=request.getParameter("new_data");
        int i;
        if(model.getSize()!=0)
            i=model.getEntry("0").size();
        else
            i=0;
        model.addEntry(newEntry,i);
        model.updateField(0, model.getSize()-1,newEntry);
        model.Print();
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/NewPatientConfirmation.jsp");
        dispatch.forward(request, response);
    }
}