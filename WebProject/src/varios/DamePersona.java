package varios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import proyectoweb.Actor;

/** Servlet implementation class DamePersona */
	@WebServlet("/DamePersona")
public class DamePersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** @see HttpServlet#HttpServlet()   */
    public DamePersona()
    {
        super();
    }
    /** http://localhost:8090/proyectoweb/ObtenerInfoPatologia?id=45 */
    

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{			
		Actor actor = new Actor("Juan", 32);
		Gson gson = new Gson();
		String json = gson.toJson(actor);
		
		PrintWriter pw = response.getWriter();
		pw.write(json);
				
		response.setContentType("application/json");
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
		@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
	{
		super.service(arg0, arg1);
		System.out.println("Pasa por Service");
	}
	
		@Override
	public void init() throws ServletException
	{
		System.out.println("Pasa por INIT");
	}
}
