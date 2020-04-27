package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class House_sale {
	public int House_sid;
	public String House_sname;
	public String House_sestate;
	public String House_slocation;
	public int House_sprice;
	public int House_ssquare;
	public int House_sstate;
	public int House_sclientid;
	public String Complete_time;
	public Timestamp deal_time;
	public int House_spurchaser_id;
	public int getHouse_sid() {
		return House_sid;
	}
	public void setHouse_sid(int house_sid) {
		House_sid = house_sid;
	}
	public String getHouse_sname() {
		return House_sname;
	}
	public void setHouse_sname(String house_sname) {
		House_sname = house_sname;
	}
	public String getHouse_sestate() {
		return House_sestate;
	}
	public void setHouse_sestate(String house_sestate) {
		House_sestate = house_sestate;
	}
	public String getHouse_slocation() {
		return House_slocation;
	}
	public void setHouse_slocation(String house_slocation) {
		House_slocation = house_slocation;
	}
	public int getHouse_sprice() {
		return House_sprice;
	}
	public void setHouse_sprice(int house_sprice) {
		House_sprice = house_sprice;
	}
	public int getHouse_ssquare() {
		return House_ssquare;
	}
	public void setHouse_ssquare(int house_ssquare) {
		House_ssquare = house_ssquare;
	}
	public int getHouse_sstate() {
		return House_sstate;
	}
	public void setHouse_sstate(int house_sstate) {
		House_sstate = house_sstate;
	}
	public int getHouse_sclientid() {
		return House_sclientid;
	}
	public void setHouse_sclientid(int house_sclientid) {
		House_sclientid = house_sclientid;
	}
	public String getComplete_time() {
		return Complete_time;
	}
	public void setComplete_time(String complete_time) {
		Complete_time = complete_time;
	}
	public Timestamp getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Timestamp deal_time) {
		this.deal_time = deal_time;
	}
	public int getHouse_spurchase_id() {
		return House_spurchaser_id;
	}
	public void setHouse_spurchase_id(int house_spurchase_id) {
		House_spurchaser_id = house_spurchase_id;
	}
	@Override
	public String toString() {
		return "House_sale [House_sid=" + House_sid + ", House_sname=" + House_sname + ", House_sestate="
				+ House_sestate + ", House_slocation=" + House_slocation + ", House_sprice=" + House_sprice
				+ ", House_ssquare=" + House_ssquare + ", House_sstate=" + House_sstate + ", House_sclientid="
				+ House_sclientid + ", Complete_time=" + Complete_time + ", deal_time=" + deal_time
				+ ", House_spurchase_id=" + House_spurchaser_id + "]";
	}
	
	
}
