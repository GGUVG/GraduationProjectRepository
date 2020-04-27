package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class House_lease {
	public int House_lid;
	public String House_lname;
	public String House_lestate;
	public String House_llocation;
	public int House_lprice;
	public int House_lsquare;
	public int House_lstate;
	public int House_lclientid;
	public String Complete_time;
	public Timestamp deal_time;
	public int House_lpurchaser_id;
	public int getHouse_lid() {
		return House_lid;
	}
	public void setHouse_lid(int house_lid) {
		House_lid = house_lid;
	}
	public String getHouse_lname() {
		return House_lname;
	}
	public void setHouse_lname(String house_lname) {
		House_lname = house_lname;
	}
	public String getHouse_lestate() {
		return House_lestate;
	}
	public void setHouse_lestate(String house_lestate) {
		House_lestate = house_lestate;
	}
	public String getHouse_llocation() {
		return House_llocation;
	}
	public void setHouse_llocation(String house_llocation) {
		House_llocation = house_llocation;
	}
	public int getHouse_lprice() {
		return House_lprice;
	}
	public void setHouse_lprice(int house_lprice) {
		House_lprice = house_lprice;
	}
	public int getHouse_lsquare() {
		return House_lsquare;
	}
	public void setHouse_lsquare(int house_lsquare) {
		House_lsquare = house_lsquare;
	}
	public int getHouse_lstate() {
		return House_lstate;
	}
	public void setHouse_lstate(int house_lstate) {
		House_lstate = house_lstate;
	}
	public int getHouse_lclientid() {
		return House_lclientid;
	}
	public void setHouse_lclientid(int house_lclientid) {
		House_lclientid = house_lclientid;
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
	public int getHouse_lpurchase_id() {
		return House_lpurchaser_id;
	}
	public void setHouse_lpurchase_id(int house_lpurchase_id) {
		House_lpurchaser_id = house_lpurchase_id;
	}
	@Override
	public String toString() {
		return "House_lease [House_lid=" + House_lid + ", House_lname=" + House_lname + ", House_lestate="
				+ House_lestate + ", House_llocation=" + House_llocation + ", House_lprice=" + House_lprice
				+ ", House_lsquare=" + House_lsquare + ", House_lstate=" + House_lstate + ", House_lclientid="
				+ House_lclientid + ", Complete_time=" + Complete_time + ", deal_time=" + deal_time
				+ ", House_lpurchase_id=" + House_lpurchaser_id + "]";
	}
	
	
}
