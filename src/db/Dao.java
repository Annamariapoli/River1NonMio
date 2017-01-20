package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import bean.River;

public class Dao {
	
	public List<River> getFiumi(){
		Connection conn = DBconnect.getConnection();
		String query ="select  * from river r  order by r.name asc";
		List<River> fiumi = new LinkedList<River>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet res = st.executeQuery();
			while(res.next()){
				River r = new River(res.getInt("id"), res.getString("name"));
				fiumi.add(r);
			}
			conn.close();
			return fiumi;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}		
	}
	
	public LocalDate getPrimaMisurazione(River r ){
		String query ="select f.day "
				+ "from river r, flow f "
				+ "where f.river=r.id and r.id=?  "
				+ "order by f.day ASC "
				+ "limit 1";
		Connection conn = DBconnect.getConnection();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, r.getId());
			LocalDate data = null;
			ResultSet res = st.executeQuery();
			if(res.next()){
				data = res.getDate("day").toLocalDate();
			}
			conn.close();
			return data;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}		
	}
	

	public LocalDate getUltimaMisurazione(River r ){
		String query ="select f.day "
				+ "from river r, flow f "
				+ "where f.river=r.id and r.id=?  "
				+ "order by f.day DESC "
				+ "limit 1";
		Connection conn = DBconnect.getConnection();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, r.getId());
			LocalDate data = null;
			ResultSet res = st.executeQuery();
			if(res.next()){
				data = res.getDate("day").toLocalDate();
			}
			conn.close();
			return data;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}		
	}
	
	public int sommaMisurazioni(River r ){
		String query ="select  count(f.id) as conta  "
				       + "from river r , flow f "
			           + "where f.river=r.id and r.id=?";
		int conta =-1;
		Connection conn = DBconnect.getConnection();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();
			if(res.next()){
				conta = res.getInt("conta");
			}
			conn.close();
			return conta;
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}		
	}
	
	public float getValoreMedio(River r ){
		String query ="select AVG (f.flow) as media "
				+ "from flow f, river r "
				+ "where f.river=r.id and r.id=?";
		float avg =-1;
		Connection conn = DBconnect.getConnection();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();
			if(res.next()){
				avg = res.getInt("media");
			}
			conn.close();
			return avg;
		}catch(SQLException e ){
			e.printStackTrace();
			return -1;
		}		
		
	}

}
