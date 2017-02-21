package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.SintomaDTO;

public class SintomasDAO
{
	public static SintomaDTO componerObjeto (ResultSet rs) throws Exception
	{
		SintomaDTO sintomaDTO = null;
		
			int id_sint = rs.getInt("id_sint");
			String desc_sint = rs.getString("des_sint");
			sintomaDTO = new SintomaDTO(id_sint, desc_sint);
		
		return sintomaDTO;
	}
}