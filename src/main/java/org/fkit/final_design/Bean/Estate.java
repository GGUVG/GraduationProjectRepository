package org.fkit.final_design.Bean;

import java.math.BigDecimal;

public class Estate 
{
	public int estate_id;
	public String estate_name;
	public String estate_location_province;
	public String estate_location_city;
	public String estate_location_district;
	public String estate_location_street;
	public BigDecimal estate_commission;
	public BigDecimal estate_rent_commission;
	public int estate_type;
	public String estate_img_bg;
	public String estate_img_floor;
	public int getEstate_id() {
		return estate_id;
	}
	public void setEstate_id(int estate_id) {
		this.estate_id = estate_id;
	}
	public String getEstate_name() {
		return estate_name;
	}
	public void setEstate_name(String estate_name) {
		this.estate_name = estate_name;
	}
	public BigDecimal getEstate_commission() {
		return estate_commission;
	}
	public void setEstate_commission(BigDecimal estate_commission) {
		this.estate_commission = estate_commission;
	}
	public BigDecimal getEstate_rent_commission() {
		return estate_rent_commission;
	}
	public void setEstate_rent_commission(BigDecimal estate_rent_commission) {
		this.estate_rent_commission = estate_rent_commission;
	}
	public int getEstate_type() {
		return estate_type;
	}
	public void setEstate_type(int estate_type) {
		this.estate_type = estate_type;
	}
	public String getEstate_img_bg() {
		return estate_img_bg;
	}
	public void setEstate_img_bg(String estate_img_bg) {
		this.estate_img_bg = estate_img_bg;
	}
	public String getEstate_img_floor() {
		return estate_img_floor;
	}
	public void setEstate_img_floor(String estate_img_floor) {
		this.estate_img_floor = estate_img_floor;
	}
	public String getEstate_location_province() {
		return estate_location_province;
	}
	public void setEstate_location_province(String estate_location_province) {
		this.estate_location_province = estate_location_province;
	}
	public String getEstate_location_city() {
		return estate_location_city;
	}
	public void setEstate_location_city(String estate_location_city) {
		this.estate_location_city = estate_location_city;
	}
	public String getEstate_location_district() {
		return estate_location_district;
	}
	public void setEstate_location_district(String estate_location_district) {
		this.estate_location_district = estate_location_district;
	}
	public String getEstate_location_street() {
		return estate_location_street;
	}
	public void setEstate_location_street(String estate_location_street) {
		this.estate_location_street = estate_location_street;
	}
	@Override
	public String toString() {
		return "Estate [estate_id=" + estate_id + ", estate_name=" + estate_name + ", estate_location_province="
				+ estate_location_province + ", estate_location_city=" + estate_location_city
				+ ", estate_location_district=" + estate_location_district + ", estate_location_street="
				+ estate_location_street + ", estate_commission=" + estate_commission + ", estate_rent_commission="
				+ estate_rent_commission + ", estate_type=" + estate_type + ", estate_img_bg=" + estate_img_bg
				+ ", estate_img_floor=" + estate_img_floor + "]";
	}

}
