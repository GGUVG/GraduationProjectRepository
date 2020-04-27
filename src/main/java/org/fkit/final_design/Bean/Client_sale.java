package org.fkit.final_design.Bean;

public class Client_sale {
	public int client_sid;
	public String client_sname;
	public String client_ssex;
	public String client_saddress;
	public String client_sphone;
	public String client_sremark;
	public int client_sstaffid;
	public int getClient_sid() {
		return client_sid;
	}
	public void setClient_sid(int client_sid) {
		this.client_sid = client_sid;
	}
	public String getClient_sname() {
		return client_sname;
	}
	public void setClient_sname(String client_sname) {
		this.client_sname = client_sname;
	}
	public String getClient_ssex() {
		return client_ssex;
	}
	public void setClient_ssex(String client_ssex) {
		this.client_ssex = client_ssex;
	}
	public String getClient_saddress() {
		return client_saddress;
	}
	public void setClient_saddress(String client_saddress) {
		this.client_saddress = client_saddress;
	}
	public String getClient_sphone() {
		return client_sphone;
	}
	public void setClient_sphone(String client_sphone) {
		this.client_sphone = client_sphone;
	}
	
	public int getClient_sstaffid() {
		return client_sstaffid;
	}
	public void setClient_sstaffid(int client_sstaffid) {
		this.client_sstaffid = client_sstaffid;
	}
	public String getClient_sremark() {
		return client_sremark;
	}
	public void setClient_sremark(String client_sremark) {
		this.client_sremark = client_sremark;
	}
	@Override
	public String toString() {
		return "Client_sale [client_sid=" + client_sid + ", client_sname=" + client_sname + ", client_ssex="
				+ client_ssex + ", client_saddress=" + client_saddress + ", client_sphone=" + client_sphone
				+ ", client_sremark=" + client_sremark + ", client_sstaffid=" + client_sstaffid + "]";
	}
	
}
