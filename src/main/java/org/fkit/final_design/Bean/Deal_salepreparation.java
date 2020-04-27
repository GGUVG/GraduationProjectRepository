package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class Deal_salepreparation 
{
	public int id;
	public int staff_id;
	public int house_id;
	public int deal_price;
	public String purchaser_name;
	public String purchaser_sex;
	public String purchaser_address;
	public String purchaser_phone;
	public String purchaser_remark;
	public String property_img;
	public String purchaserIDcard_img;
	public String agreement_img;
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
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public int getDeal_price() {
		return deal_price;
	}
	public void setDeal_price(int deal_price) {
		this.deal_price = deal_price;
	}
	public String getPurchaser_name() {
		return purchaser_name;
	}
	public void setPurchaser_name(String purchaser_name) {
		this.purchaser_name = purchaser_name;
	}
	public String getPurchaser_sex() {
		return purchaser_sex;
	}
	public void setPurchaser_sex(String purchaser_sex) {
		this.purchaser_sex = purchaser_sex;
	}
	public String getPurchaser_address() {
		return purchaser_address;
	}
	public void setPurchaser_address(String purchaser_address) {
		this.purchaser_address = purchaser_address;
	}
	public String getPurchaser_phone() {
		return purchaser_phone;
	}
	public void setPurchaser_phone(String purchaser_phone) {
		this.purchaser_phone = purchaser_phone;
	}
	public String getPurchaser_remark() {
		return purchaser_remark;
	}
	public void setPurchaser_remark(String purchaser_remark) {
		this.purchaser_remark = purchaser_remark;
	}
	public String getProperty_img() {
		return property_img;
	}
	public void setProperty_img(String property_img) {
		this.property_img = property_img;
	}
	public String getPurchaserIDcard_img() {
		return purchaserIDcard_img;
	}
	public void setPurchaserIDcard_img(String purchaserIDcard_img) {
		this.purchaserIDcard_img = purchaserIDcard_img;
	}
	public String getAgreement_img() {
		return agreement_img;
	}
	public void setAgreement_img(String agreement_img) {
		this.agreement_img = agreement_img;
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
		return "Deal_salepreparation [id=" + id + ", staff_id=" + staff_id + ", house_id=" + house_id + ", deal_price="
				+ deal_price + ", purchaser_name=" + purchaser_name + ", purchaser_sex=" + purchaser_sex
				+ ", purchaser_address=" + purchaser_address + ", purchaser_phone=" + purchaser_phone
				+ ", purchaser_remark=" + purchaser_remark + ", property_img=" + property_img + ", purchaserIDcard_img="
				+ purchaserIDcard_img + ", agreement_img=" + agreement_img + ", state=" + state + ", permit_time="
				+ permit_time + "]";
	}
	
	
}
