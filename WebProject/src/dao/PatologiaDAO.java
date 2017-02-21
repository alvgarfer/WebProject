package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.PatologiaDTO;
import dto.SintomaDTO;

public class PatologiaDAO
{
	public static PatologiaDTO compomonerObjeto (ResultSet rs) throws Exception
	{
		PatologiaDTO patologiaDTO = null;
		
			int id_patol = rs.getInt("id_patol");
			String nom_patol = rs.getString("nom_patol");
			String des_patol = rs.getString("des_patol");
			String trat_patol = rs.getString("trat_patol");
			String causa_patol = rs.getString("causa_patol");
			
			patologiaDTO = new PatologiaDTO(id_patol, nom_patol, causa_patol, trat_patol, des_patol);
		
		return patologiaDTO;
	}
	
	private List<Integer> obtenerIDsPatologias () 
	{
		List<Integer> listaids = new ArrayList<Integer>();
		
		Pool pool = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
			pool = Pool.getInstance();
			con = pool.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(Consultas.CONSULTA_ID_PATOLOGIAS);
			
				while (rs.next())
				{
					listaids.add(rs.getInt(1));
				}
			
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}	finally 
				{
					pool.liberarRecursos(con, st, rs);
				}
			
		return listaids;
	}
	
	public Map<Integer, PatologiaDTO> obtenerListaPalogias ()
	{
		Map<Integer, PatologiaDTO> mapa_patologia = new HashMap<Integer, PatologiaDTO>();
		PatologiaDTO pdto_aux = null;
		
			 List<Integer> lids = obtenerIDsPatologias ();
			 
			 for (Integer i : lids)
			 {
				pdto_aux = buscarPorId(i);
				mapa_patologia.put(i, pdto_aux);
			 }

		return mapa_patologia;
	}
	
	public PatologiaDTO buscarPorId (int id)
	{
		PatologiaDTO patologiaDTO = null;
		Pool pool = null;
		Connection conexion = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		SintomaDTO sintomaDTO = null;
		
		try
		{
			pool = Pool.getInstance();
			conexion = pool.getConnection();
			ps = conexion.prepareStatement(Consultas.CONSULTA_PATO_POR_ID);
			
			ps.setInt(1, id);
			ps.setInt(2, id);
			
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				patologiaDTO = compomonerObjeto(rs);
			}
			
			do
			{
				sintomaDTO = SintomasDAO.componerObjeto(rs);
				patologiaDTO.addSintoma(sintomaDTO);
				
			}	while (rs.next());
			
		} 
			catch (Exception e)
			{
				e.printStackTrace();
			
			}
				finally 
				{
					pool.liberarRecursos(conexion, ps, rs);
				}
	
		return patologiaDTO;
	}
}