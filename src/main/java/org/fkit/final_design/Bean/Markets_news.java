package org.fkit.final_design.Bean;

import java.sql.Timestamp;

public class Markets_news {
	public int Markets_news_id;
	public String Markets_news_title;
	public String Markets_news_content;
	public int Markets_news_staffid;
	public Timestamp publish_time;
	public String Markets_news_img;
	public int getMarkets_news_id() {
		return Markets_news_id;
	}
	public void setMarkets_news_id(int markets_news_id) {
		Markets_news_id = markets_news_id;
	}
	public String getMarkets_news_title() {
		return Markets_news_title;
	}
	public void setMarkets_news_title(String markets_news_title) {
		Markets_news_title = markets_news_title;
	}
	public String getMarkets_news_content() {
		return Markets_news_content;
	}
	public void setMarkets_news_content(String markets_news_content) {
		Markets_news_content = markets_news_content;
	}
	public int getMarkets_news_staffid() {
		return Markets_news_staffid;
	}
	public void setMarkets_news_staffid(int markets_news_staffid) {
		Markets_news_staffid = markets_news_staffid;
	}
	public Timestamp getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	public String getMarkets_news_img() {
		return Markets_news_img;
	}
	public void setMarkets_news_img(String markets_news_img) {
		Markets_news_img = markets_news_img;
	}
	@Override
	public String toString() {
		return "Markets_news [Markets_news_id=" + Markets_news_id + ", Markets_news_title=" + Markets_news_title
				+ ", Markets_news_content=" + Markets_news_content + ", Markets_news_staffid=" + Markets_news_staffid
				+ ", publish_time=" + publish_time + ", Markets_news_img=" + Markets_news_img + "]";
	}
	
	
}
