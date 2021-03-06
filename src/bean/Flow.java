package bean;

import java.time.LocalDate;

public class Flow {

	private int id;
	private LocalDate day ;
	private float flow;
	private int river;
	
	public Flow(int id, LocalDate day, float flow, int river) {
		super();
		this.id = id;
		this.day = day;
		this.flow = flow;
		this.river = river;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public float getFlow() {
		return flow;
	}
	public void setFlow(float flow) {
		this.flow = flow;
	}
	public int getRiver() {
		return river;
	}
	public void setRiver(int river) {
		this.river = river;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flow other = (Flow) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
