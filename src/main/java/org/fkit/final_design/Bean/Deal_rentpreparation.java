package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class Deal_rentpreparation 
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
	public String agreement_img;//合同协议
	public String ammeter_record_img;//电表记录
	public String furniture_record_img;//家具清单
	public String landlordIDcard_copy_img;//房东身份证复印件
	public String property_copy_img;//房产证复印件
	public String purchaserIDcard_copy_img;//租客身份证复印件
	public Timestamp tenancy;//租期到期时间
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
	public String getAgreement_img() {
		return agreement_img;
	}
	public void setAgreement_img(String agreement_img) {
		this.agreement_img = agreement_img;
	}
	public String getAmmeter_record_img() {
		return ammeter_record_img;
	}
	public void setAmmeter_record_img(String ammeter_record_img) {
		this.ammeter_record_img = ammeter_record_img;
	}
	public String getFurniture_record_img() {
		return furniture_record_img;
	}
	public void setFurniture_record_img(String furniture_record_img) {
		this.furniture_record_img = furniture_record_img;
	}
	public String getLandlordIDcard_copy_img() {
		return landlordIDcard_copy_img;
	}
	public void setLandlordIDcard_copy_img(String landlordIDcard_copy_img) {
		this.landlordIDcard_copy_img = landlordIDcard_copy_img;
	}
	public String getProperty_copy_img() {
		return property_copy_img;
	}
	public void setProperty_copy_img(String property_copy_img) {
		this.property_copy_img = property_copy_img;
	}
	public String getPurchaserIDcard_copy_img() {
		return purchaserIDcard_copy_img;
	}
	public void setPurchaserIDcard_copy_img(String purchaserIDcard_copy_img) {
		this.purchaserIDcard_copy_img = purchaserIDcard_copy_img;
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
	public Timestamp getTenancy() {
		return tenancy;
	}
	public void setTenancy(Timestamp tenancy) {
		this.tenancy = tenancy;
	}
	@Override
	public String toString() {
		return "Deal_rentpreparation [id=" + id + ", staff_id=" + staff_id + ", house_id=" + house_id + ", deal_price="
				+ deal_price + ", purchaser_name=" + purchaser_name + ", purchaser_sex=" + purchaser_sex
				+ ", purchaser_address=" + purchaser_address + ", purchaser_phone=" + purchaser_phone
				+ ", purchaser_remark=" + purchaser_remark + ", agreement_img=" + agreement_img
				+ ", ammeter_record_img=" + ammeter_record_img + ", furniture_record_img=" + furniture_record_img
				+ ", landlordIDcard_copy_img=" + landlordIDcard_copy_img + ", property_copy_img=" + property_copy_img
				+ ", purchaserIDcard_copy_img=" + purchaserIDcard_copy_img + ", tenancy=" + tenancy + ", state=" + state
				+ ", permit_time=" + permit_time + "]";
	}
	
	
	
}
