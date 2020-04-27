package org.fkit.final_design.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.fkit.final_design.Bean.CompanyBranches;
import org.fkit.final_design.Bean.Company_news;
import org.fkit.final_design.Bean.Estate;
import org.fkit.final_design.Bean.Markets_news;
import org.fkit.final_design.Mapper.MainPageMapper;
import org.springframework.stereotype.Service;

@Service
public class MainPage_Service {
	@Resource
	public MainPageMapper mainPageMapper;
	
	public List<Map<String,Object>> showNews()
	{
		return mainPageMapper.showNews();
	}
	
	public Company_news showNewsDetails(int Company_news_id)
	{
		return mainPageMapper.showNewsDetails(Company_news_id);
	}
	
	public List<Company_news> showAllCompanyNews()
	{
		return mainPageMapper.showAllCompanyNews();
	}
	
	public List<Map<String,Object>> showMarket5News()
	{
		return mainPageMapper.showMarket5News();
	}
	
	public Markets_news showMarketsNewsDetails(int Markets_news_id)
	{
		return mainPageMapper.showMarketsNewsDetails(Markets_news_id);
	}
	
	public List<Markets_news> showAllMarketsNews()
	{
		return mainPageMapper.showAllMarketsNews();
	}
	
	public String showSuperior(int staff_id)
	{
		return mainPageMapper.showSuperior(staff_id);
	}
	
	public String showBranch_name(int staff_id)
	{
		return mainPageMapper.showBranch_name(staff_id);
	}
	
	public List<Estate> showEstateLinkage()
	{
		return mainPageMapper.showEstateLinkage();
	}
	
	public Estate showEstateDetails(int estate_id)
	{
		return mainPageMapper.showEstateDetails(estate_id);
	}
	
	public List<CompanyBranches> showBranchNameList()
	{
		return mainPageMapper.showBranchNameList();
	}
	
	public int GetCb_idByName(String CB_name)
	{
		return mainPageMapper.GetCb_idByName(CB_name);
	}
	
	public int changePassword(String staff_password,int staff_id)
	{
		return mainPageMapper.changePassword(staff_password, staff_id);
	}
	
}
