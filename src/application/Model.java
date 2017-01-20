package application;

import java.time.LocalDate;
import java.util.List;

import bean.River;
import db.Dao;

public class Model {
	
	private Dao dao = new Dao();
	
	public List<River> getfiumi(){
		List<River> fiumi = dao.getFiumi();
		return fiumi;
	}
	
	public LocalDate getPrima(River r ){
		LocalDate data = dao.getPrimaMisurazione(r);
		return data;
	}
	
	public LocalDate getUltima(River r ){
		LocalDate data = dao.getUltimaMisurazione(r);
		return data;
	}
	
	public int getSommaMis(River r ){
		int conta = dao.sommaMisurazioni(r);
		return conta;
	}

	public float getMedia(River r ){
		float media = dao.getValoreMedio(r);
		return media;
	}
}
