package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PatologiaDTO;
import servicios.PatologiaService;

/**
 * Servlet implementation class BuscarPatologia
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatologiaService ps = new PatologiaService();
		
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		
		long tinicial = System.currentTimeMillis();
		PatologiaDTO patoDto = ps.buscarPatologiaPorId(id);
		long tfinal = System.currentTimeMillis();
		long ttotal = tfinal-tinicial;
		System.out.println("Tardó = " + ttotal +" ms");
		
		request.setAttribute("patologia", patoDto);
		request.getRequestDispatcher(".//html//catarata.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
