package varios;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.eclipse.jdt.internal.compiler.batch.Main;

import dao.PatologiaDAO;
import dto.PatologiaDTO;
import dto.MapaPatologias;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFin
 *
 */
@WebListener
public class EscuchaInicioYFin implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaInicioYFin() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	System.out.println("PROGRMA DESTRUIDO");
    	MainSSH.desconectate_D_SSH();
    
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	System.out.println("PROGRMA INICIADO");
    	try {
			MainSSH.conectate_A_SSH();
			System.out.println("La conexión SSH queda iniciada");
			
			
			PatologiaDAO patologiaDAO = new PatologiaDAO();
			Map<Integer, PatologiaDTO> mapa_patDto = patologiaDAO.obtenerListaPalogias();
			
			MapaPatologias mapaPatologias = new MapaPatologias();
			mapaPatologias.setMapapatologia(mapa_patDto);
			
			System.out.println("Mapa Inicializado");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
