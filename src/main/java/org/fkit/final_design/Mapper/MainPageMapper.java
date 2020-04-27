package org.fkit.final_design.Mapper;

import java.util.List;
import java.util.Map;
import org.fkit.final_design.Bean.Estate;
import org.fkit.final_design.Bean.Markets_news;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.final_design.Bean.CompanyBranches;
import org.fkit.final_design.Bean.Company_news;

public interface MainPageMapper {
	//最新5公司资讯显示
	@Select("select * from company_news order by publish_time desc limit 5")
	public List<Map<String,Object>> showNews();
	
	//公司资讯详情
	@Select("select * from company_news where company_news_id=#{Company_news_id}")
	public Company_news showNewsDetails(int Company_news_id);
	
	//公司资讯
	@Select("select * from company_news order by publish_time desc")
	public List<Company_news> showAllCompanyNews();
	
	//最新5市场资讯显示
	@Select("select * from markets_news order by publish_time desc limit 5")
	public List<Map<String,Object>> showMarket5News();
	
	//市场资讯详情
	@Select("select * from markets_news where Markets_news_id=#{Markets_news_id}")
	public Markets_news showMarketsNewsDetails(int Markets_news_id);
		
	//市场资讯
	@Select("select * from markets_news order by publish_time desc")
	public List<Markets_news> showAllMarketsNews();
	
	//个人中心显示上司
	@Select("select staff_username from staff where staff_id in(select CB_manager_id from companybranches where CB_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public String showSuperior(int staff_id);
	
	//个人中心显示所在分行
	@Select("select CB_name from companybranches where CB_id in(select staff_branch_id from staff where staff_id=#{staff_id})")
	public String showBranch_name(int staff_id);
	
	//一二手联动搜索小区
	@Select("select estate_id,estate_name,estate_location_province,estate_location_city,estate_location_district,estate_location_street,estate_img_bg from estate order by RAND()")
	public List<Estate> showEstateLinkage();
	
	//一二手联动小区具体信息
	@Select("select * from estate where estate_id=#{estate_id}")
	public Estate showEstateDetails(int estate_id);
	
	//查询所有分行名字
	@Select("select CB_name from companybranches")
	public List<CompanyBranches> showBranchNameList();
	
	//查询所有分行名字
	@Select("select cb_id from companybranches where cb_name=#{CB_name}")
	public int GetCb_idByName(String CB_name);
	
	//分行省级
	@Select("select distinct CB_province from companybranches")
	public int GetCB_provinceOption();
	
	//分行市级
	@Select("select distinct CB_city from companybranches where CB_province=#{CB_province}")
	public int GetCB_cityOption(String CB_province);
		
	//分行区级
	@Select("select distinct CB_district from companybranches where CB_city=#{CB_city}")
	public int GetCB_districtOption(String CB_city);
	
	//员工改密码
	@Update("update staff set staff_password=#{staff_password} where staff_id=#{staff_id}")
	public int changePassword(String staff_password,int staff_id);
}
