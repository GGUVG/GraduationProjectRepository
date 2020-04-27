package org.fkit.final_design.Bean;

public class CompanyBranches {
	public int CB_id;
	public String CB_name;
	public String CB_province;
	public String CB_city;
	public String CB_district;
	public int CB_manager_id;
	public int getCB_id() {
		return CB_id;
	}
	public void setCB_id(int cB_id) {
		CB_id = cB_id;
	}
	public String getCB_name() {
		return CB_name;
	}
	public void setCB_name(String cB_name) {
		CB_name = cB_name;
	}
	public String getCB_province() {
		return CB_province;
	}
	public void setCB_province(String cB_province) {
		CB_province = cB_province;
	}
	public String getCB_city() {
		return CB_city;
	}
	public void setCB_city(String cB_city) {
		CB_city = cB_city;
	}
	public String getCB_district() {
		return CB_district;
	}
	public void setCB_district(String cB_district) {
		CB_district = cB_district;
	}
	public int getCB_manager_id() {
		return CB_manager_id;
	}
	public void setCB_manager_id(int cB_manager_id) {
		CB_manager_id = cB_manager_id;
	}
	@Override
	public String toString() {
		return "CompanyBranches [CB_id=" + CB_id + ", CB_name=" + CB_name + ", CB_province=" + CB_province
				+ ", CB_city=" + CB_city + ", CB_district=" + CB_district + ", CB_manager_id=" + CB_manager_id + "]";
	}
	
}
