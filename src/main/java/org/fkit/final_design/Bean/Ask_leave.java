package org.fkit.final_design.Bean;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Ask_leave {
	public int id;
	public int staff_id;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Timestamp leave_time;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Timestamp back_time;	
	public String reason;
	
	public String img_prove;
	public int state;
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
	public Timestamp getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(Timestamp leave_time) {
		this.leave_time = leave_time;
	}
	public Timestamp getBack_time() {
		return back_time;
	}
	public void setBack_time(Timestamp back_time) {
		this.back_time = back_time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getImg_prove() {
		return img_prove;
	}
	public void setImg_prove(String img_prove) {
		this.img_prove = img_prove;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Ask_leave [id=" + id + ", staff_id=" + staff_id + ", leave_time=" + leave_time + ", back_time="
				+ back_time + ", reason=" + reason + ", img_prove=" + img_prove + ", state=" + state + "]";
	}
	
}
