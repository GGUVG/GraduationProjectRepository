package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class Ask_out_office {
	public int id;
	public int staff_id;
	public Timestamp leave_time;
	public Timestamp back_time;
	public String remark;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		return "Ask_out_office [id=" + id + ", staff_id=" + staff_id + ", leave_time=" + leave_time + ", back_time="
				+ back_time + ", remark=" + remark + ", img_prove=" + img_prove + ", state=" + state + "]";
	}
	
	
}
