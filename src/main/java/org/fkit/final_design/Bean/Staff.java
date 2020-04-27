package org.fkit.final_design.Bean;

public class Staff {
	public int staff_id;
	public String staff_username;
	public String staff_password;
	public int staff_level;
	public int staff_branch_id;
	public String staff_job;
	public int today_serial_id;
	public String staff_img;
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_username() {
		return staff_username;
	}
	public void setStaff_username(String staff_username) {
		this.staff_username = staff_username;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public int getStaff_level() {
		return staff_level;
	}
	public void setStaff_level(int staff_level) {
		this.staff_level = staff_level;
	}
	public int getStaff_branch_id() {
		return staff_branch_id;
	}
	public void setStaff_branch_id(int staff_branch_id) {
		this.staff_branch_id = staff_branch_id;
	}
	public String getStaff_job() {
		return staff_job;
	}
	public void setStaff_job(String staff_job) {
		this.staff_job = staff_job;
	}
	public int getToday_serial_id() {
		return today_serial_id;
	}
	public void setToday_serial_id(int today_serial_id) {
		this.today_serial_id = today_serial_id;
	}
	
	public String getStaff_img() {
		return staff_img;
	}
	public void setStaff_img(String staff_img) {
		this.staff_img = staff_img;
	}
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", staff_username=" + staff_username + ", staff_password="
				+ staff_password + ", staff_level=" + staff_level + ", staff_branch_id=" + staff_branch_id
				+ ", staff_job=" + staff_job + ", today_serial_id=" + today_serial_id + ", staff_img=" + staff_img
				+ "]";
	}

	
	
}
