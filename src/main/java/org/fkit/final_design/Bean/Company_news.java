package org.fkit.final_design.Bean;

import java.awt.TextArea;
import java.sql.Timestamp;

public class Company_news {
	public int Company_news_id;
	public String Company_news_title;
	public String Company_news_content;
	public int Company_news_staffid;
	public Timestamp publish_time;
	public String Company_news_img;
	public int getCompany_news_id() {
		return Company_news_id;
	}
	public void setCompany_news_id(int company_news_id) {
		Company_news_id = company_news_id;
	}
	public String getCompany_news_title() {
		return Company_news_title;
	}
	public void setCompany_news_title(String company_news_title) {
		Company_news_title = company_news_title;
	}
	public String getCompany_news_content() {
		return Company_news_content;
	}
	public void setCompany_news_content(String company_news_content) {
		Company_news_content = company_news_content;
	}
	public int getCompany_news_staffid() {
		return Company_news_staffid;
	}
	public void setCompany_news_staffid(int company_news_staffid) {
		Company_news_staffid = company_news_staffid;
	}
	public Timestamp getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	public String getCompany_news_img() {
		return Company_news_img;
	}
	public void setCompany_news_img(String company_news_img) {
		Company_news_img = company_news_img;
	}
	@Override
	public String toString() {
		return "Company_news [Company_news_id=" + Company_news_id + ", Company_news_title=" + Company_news_title
				+ ", Company_news_content=" + Company_news_content + ", Company_news_staffid=" + Company_news_staffid
				+ ", publish_time=" + publish_time + ", Company_news_img=" + Company_news_img + "]";
	}

}
