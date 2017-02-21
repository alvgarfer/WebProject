package varios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Servlet implementation class CargarMenu */
@WebServlet("/CargarMenu")
public class CargarMenu extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /** @see HttpServlet#HttpServlet() */
    public CargarMenu()
    {
        super();
    }

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("num"));
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		out = response.getWriter();
		out.println("MENSAJE INICIAL");
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}
