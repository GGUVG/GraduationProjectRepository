package org.fkit.final_design.Bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RentPreparation {
	public int id;
	public int staff_id;
	public String house_name;
	public String house_estate;
	public String house_location;
	public int house_price;
	public int house_square;
	public String house_complete_time;
	public String house_client_name;
	public String house_client_sex;
	public String house_client_address;
	public String house_client_phone;
	public String house_client_remark;
	public int state;
	public Timestamp permit_time;
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
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getHouse_estate() {
		return house_estate;
	}
	public void setHouse_estate(String house_estate) {
		this.house_estate = house_estate;
	}
	public String getHouse_location() {
		return house_location;
	}
	public void setHouse_location(String house_location) {
		this.house_location = house_location;
	}
	public int getHouse_price() {
		return house_price;
	}
	public void setHouse_price(int house_price) {
		this.house_price = house_price;
	}
	public int getHouse_square() {
		return house_square;
	}
	public void setHouse_square(int house_square) {
		this.house_square = house_square;
	}
	public String getHouse_complete_time() {
		return house_complete_time;
	}
	public void setHouse_complete_time(String house_complete_time) {
		this.house_complete_time = house_complete_time;
	}
	public String getHouse_client_name() {
		return house_client_name;
	}
	public void setHouse_client_name(String house_client_name) {
		this.house_client_name = house_client_name;
	}
	public String getHouse_client_sex() {
		return house_client_sex;
	}
	public void setHouse_client_sex(String house_client_sex) {
		this.house_client_sex = house_client_sex;
	}
	public String getHouse_client_address() {
		return house_client_address;
	}
	public void setHouse_client_address(String house_client_address) {
		this.house_client_address = house_client_address;
	}
	public String getHouse_client_phone() {
		return house_client_phone;
	}
	public void setHouse_client_phone(String house_client_phone) {
		this.house_client_phone = house_client_phone;
	}
	public String getHouse_client_remark() {
		return house_client_remark;
	}
	public void setHouse_client_remark(String house_client_remark) {
		this.house_client_remark = house_client_remark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getPermit_time() {
		return permit_time;
	}
	public void setPermit_time(Timestamp permit_time) {
		this.permit_time = permit_time;
	}
	@Override
	public String toString() {
		return "RentPreparation [id=" + id + ", staff_id=" + staff_id + ", house_name=" + house_name + ", house_estate="
				+ house_estate + ", house_location=" + house_location + ", house_price=" + house_price
				+ ", house_square=" + house_square + ", house_complete_time=" + house_complete_time
				+ ", house_client_name=" + house_client_name + ", house_client_sex=" + house_client_sex
				+ ", house_client_address=" + house_client_address + ", house_client_phone=" + house_client_phone
				+ ", house_client_expect_price=" + ", house_client_remark="
				+ house_client_remark + ", state=" + state + ", permit_time=" + permit_time + "]";
	}
	
	
}
