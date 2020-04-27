package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class Staff_sign 
{
	public int id;
	public int staff_id;
	public Timestamp in_time;
	public Timestamp off_time;
	public int in_state;
	public int off_state;
	public int special_state;
	public int final_state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public Timestamp getIn_time() {
		return in_time;
	}
	public void setIn_time(Timestamp in_time) {
		this.in_time = in_time;
	}
	public Timestamp getOff_time() {
		return off_time;
	}
	public void setOff_time(Timestamp off_time) {
		this.off_time = off_time;
	}
	public int getIn_state() {
		return in_state;
	}
	public void setIn_state(int in_state) {
		this.in_state = in_state;
	}
	public int getOff_state() {
		return off_state;
	}
	public void setOff_state(int off_state) {
		this.off_state = off_state;
	}
	public int getSpecial_state() {
		return special_state;
	}
	public void setSpecial_state(int special_state) {
		this.special_state = special_state;
	}
	public int getFinal_state() {
		return final_state;
	}
	public void setFinal_state(int final_state) {
		this.final_state = final_state;
	}
	@Override
	public String toString() {
		return "Staff_sign [id=" + id + ", staff_id=" + staff_id + ", in_time=" + in_time + ", off_time=" + off_time
				+ ", in_state=" + in_state + ", off_state=" + off_state + ", special_state=" + special_state
				+ ", final_state=" + final_state + "]";
	}
	
	
	
}
