package org.fkit.final_design.Bean;

public class Client_lease {
	public int client_lid;
	public String client_lname;
	public String client_lsex;
	public String client_laddress;
	public String client_lphone;
	public String client_lremark;
	public int client_lstaffid;
	public int getClient_lid() {
		return client_lid;
	}
	public void setClient_lid(int client_lid) {
		this.client_lid = client_lid;
	}
	public String getClient_lname() {
		return client_lname;
	}
	public void setClient_lname(String client_lname) {
		this.client_lname = client_lname;
	}
	public String getClient_lsex() {
		return client_lsex;
	}
	public void setClient_lsex(String client_lsex) {
		this.client_lsex = client_lsex;
	}
	public String getClient_laddress() {
		return client_laddress;
	}
	public void setClient_laddress(String client_laddress) {
		this.client_laddress = client_laddress;
	}
	public String getClient_lphone() {
		return client_lphone;
	}
	public void setClient_lphone(String client_lphone) {
		this.client_lphone = client_lphone;
	}
	
	public int getClient_lstaffid() {
		return client_lstaffid;
	}
	public void setClient_lstaffid(int client_lstaffid) {
		this.client_lstaffid = client_lstaffid;
	}
	
	public String getClient_lremark() {
		return client_lremark;
	}
	public void setClient_lremark(String client_lremark) {
		this.client_lremark = client_lremark;
	}
	@Override
	public String toString() {
		return "Client_lease [client_lid=" + client_lid + ", client_lname=" + client_lname + ", client_lsex="
				+ client_lsex + ", client_laddress=" + client_laddress + ", client_lphone=" + client_lphone
				+ ", client_lexpect_price=" + ", client_lremark=" + client_lremark
				+ ", client_lstaffid=" + client_lstaffid + "]";
	}
	
}
