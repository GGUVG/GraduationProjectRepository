package org.fkit.final_design.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.fkit.final_design.Bean.Ask_leave;
import org.fkit.final_design.Bean.Ask_out_office;
import org.fkit.final_design.Bean.Client_sale;
import org.fkit.final_design.Bean.Client_want_buy;
import org.fkit.final_design.Bean.Company_news;
import org.fkit.final_design.Bean.Deal_salepreparation;
import org.fkit.final_design.Bean.House_sale;
import org.fkit.final_design.Bean.Markets_news;
import org.fkit.final_design.Bean.SalePreparation;
import org.fkit.final_design.Bean.Staff;
import org.fkit.final_design.Bean.Staff_sign;
import org.fkit.final_design.Mapper.ManagerMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Manager_Service {
	@Resource
	public ManagerMapper managerMapper;
	
	public String checkIfManager(int staff_id)
	{
		return managerMapper.checkIfManager(staff_id);
	}
	
	public Timestamp getTime()
	{
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	//SaleHouse...
	
	public List<Map<String,Object>> CheckToPermitSalePreparation(int staff_id)
	{
		return managerMapper.CheckToPermitSalePreparation(staff_id);
	}
	
	public List<Map<String,Object>> CheckAllPermitSalePreparation(int staff_id)
	{
		return managerMapper.CheckAllPermitSalePreparation(staff_id);
	}
	
	public String PermitSalePreparationP1Check(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time)
	{
		return managerMapper.PermitSalePreparationP1Check(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
	}
	
	public int PermitSalePreparationP1(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time)
	{
		return managerMapper.PermitSalePreparationP1(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare,Complete_time);
	}
	
	public String PermitSalePreparationP2Check(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark)
	{
		return managerMapper.PermitSalePreparationP2Check(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark);
	}
	
	public int PermitSalePreparationP2(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark,int Client_sstaffid)
	{
		return managerMapper.PermitSalePreparationP2(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark, Client_sstaffid);
	}
	
	public int PermitSalePreparationP3(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark,int Client_sstaffid)
	{
		return managerMapper.PermitSalePreparationP3(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark, Client_sstaffid);
	}
	
	public int PermitSalePreparationP4(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time)
	{
		return managerMapper.PermitSalePreparationP4(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
	}
	
	public int PermitSalePreparationP5(int House_sclientid,int House_sid)
	{
		return managerMapper.PermitSalePreparationP5(House_sclientid,House_sid);
	}
	
	public int PermitSalePreparationP6(Timestamp permit_time,int salePreparation_id)
	{
		return managerMapper.PermitSalePreparationP6(permit_time,salePreparation_id);
	}
	
	//RentHouse...
	
	public List<Map<String,Object>> CheckToPermitRentPreparation(int staff_id)
	{
		return managerMapper.CheckToPermitRentPreparation(staff_id);
	}
	
	public List<Map<String,Object>> CheckAllPermitRentPreparation(int staff_id)
	{
		return managerMapper.CheckAllPermitRentPreparation(staff_id);
	}
	
	public String PermitRentPreparationP1Check(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time)
	{
		return managerMapper.PermitRentPreparationP1Check(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
	}
	
	public int PermitRentPreparationP1(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time)
	{
		return managerMapper.PermitRentPreparationP1(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
	}
	
	public String PermitRentPreparationP2Check(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark)
	{
		return managerMapper.PermitRentPreparationP2Check(Client_lname, Client_lsex, Client_laddress, Client_lphone, Client_lremark);
	}
	
	public int PermitRentPreparationP2(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark,int Client_lstaffid)
	{
		return managerMapper.PermitRentPreparationP2(Client_lname, Client_lsex, Client_laddress, Client_lphone,Client_lremark, Client_lstaffid);
	}
	
	public int PermitRentPreparationP3(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark,int Client_lstaffid)
	{
		return managerMapper.PermitRentPreparationP3(Client_lname, Client_lsex, Client_laddress, Client_lphone, Client_lremark, Client_lstaffid);
	}
	
	public int PermitRentPreparationP4(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time)
	{
		return managerMapper.PermitRentPreparationP4(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
	}
	
	public int PermitRentPreparationP5(int House_lclientid,int House_lid)
	{
		return managerMapper.PermitRentPreparationP5(House_lclientid, House_lid);
	}
	
	public int PermitRentPreparationP6(Timestamp permit_time,int rentPreparation_id)
	{
		return managerMapper.PermitRentPreparationP6(permit_time, rentPreparation_id);
	}
	
	//deal_saleHouse...
	
	public List<Map<String,Object>> Check_DealSalePreparation(int staff_id){
		return managerMapper.Check_DealSalePreparation(staff_id);
	}
	
	public List<Map<String,Object>> Check_AlreadyDealSalePreparation(int staff_id)
	{
		return managerMapper.Check_AlreadyDealSalePreparation(staff_id);
	}
	
	public String showImg_property(int deal_salepreparation_id)
	{
		return managerMapper.showImg_property(deal_salepreparation_id);
	}
	
	public String showImg_purchaserIDcard(int deal_salepreparation_id)
	{
		return managerMapper.showImg_purchaserIDcard(deal_salepreparation_id);
	}
	
	public String showImg_agreement(int deal_salepreparation_id)
	{
		return managerMapper.showImg_agreement(deal_salepreparation_id);
	}
	
	public int PermitDeal_SalePreparationP1Check(int House_sid)
	{
		return managerMapper.PermitDeal_SalePreparationP1Check(House_sid);
	}
	
	public String PermitDeal_SalePreparationP1_1Check(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark)
	{
		return managerMapper.PermitDeal_SalePreparationP1_1Check(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark);
	}
	
	public int PermitDeal_SalePreparationP2(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark,int client_wbstaffid)
	{
		return managerMapper.PermitDeal_SalePreparationP2(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark, client_wbstaffid);
	}
	
	public int PermitDeal_SalePreparationP3(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark)
	{
		return managerMapper.PermitDeal_SalePreparationP3(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark);
	}
	
	public int PermitDeal_SalePreparationP4(int House_spurchaser_id,int House_sid,Timestamp deal_time)
	{
		return managerMapper.PermitDeal_SalePreparationP4(House_spurchaser_id, House_sid,deal_time);
	}
	
	public int PermitDeal_SalePreparationP5(Timestamp permit_time,int deal_salepreparation_id)
	{
		return managerMapper.PermitDeal_SalePreparationP5(permit_time, deal_salepreparation_id);
	}
	
	
	
	//rent_dealRentPreparation
	
	public List<Map<String,Object>> Check_DealRentPreparation(int staff_id)
	{
		return managerMapper.Check_DealRentPreparation(staff_id);
	}
	
	public List<Map<String,Object>> Check_AlreadyDealRentPreparation(int staff_id)
	{
		return managerMapper.Check_AlreadyDealRentPreparation(staff_id);
	}
	
	public String showImgRent_agreement(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_agreement(deal_rentpreparation_id);
	}
	
	public String showImgRent_ammeter_record(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_ammeter_record(deal_rentpreparation_id);
	}
	
	public String showImgRent_furniture_record(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_furniture_record(deal_rentpreparation_id);
	}
	
	public String showImgRent_landlordIDcard_copy(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_landlordIDcard_copy(deal_rentpreparation_id);
	}
	
	public String showImgRent_property_copy(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_property_copy(deal_rentpreparation_id);
	}
	
	public String showImgRent_purchaserIDcard_copy(int deal_rentpreparation_id)
	{
		return managerMapper.showImgRent_purchaserIDcard_copy(deal_rentpreparation_id);
	}
	
	public int PermitDeal_RentPreparationP1Check(int House_lid)
	{
		return managerMapper.PermitDeal_RentPreparationP1Check(House_lid);
	}
	
	public String PermitDeal_RentPreparationP1_1Check(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark)
	{
		return managerMapper.PermitDeal_RentPreparationP1_1Check(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark);
	}
	
	public int PermitDeal_RentPreparationP2(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark,int client_wrstaffid)
	{
		return managerMapper.PermitDeal_RentPreparationP2(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark, client_wrstaffid);
	}
	
	public int PermitDeal_RentPreparationP3(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark)
	{
		return managerMapper.PermitDeal_RentPreparationP3(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark);
	}
	
	public int PermitDeal_RentPreparationP4(int House_lprice,int House_lpurchaser_id,int House_lid,Timestamp deal_time)
	{
		return managerMapper.PermitDeal_RentPreparationP4(House_lprice,House_lpurchaser_id, House_lid, deal_time);
	}
	
	public int PermitDeal_RentPreparationP5(Timestamp permit_time,int deal_rentpreparation_id)
	{
		return managerMapper.PermitDeal_RentPreparationP5(permit_time, deal_rentpreparation_id);
	}
	
	public int Update_house_lease_state()
	{
		return managerMapper.Update_house_lease_state();
	}
	
	public int insert_not_in_staff_sign()
	{
		return managerMapper.insert_not_in_staff_sign();
	}
	
	public int Update_staff_sign_Saturday()
	{
		return managerMapper.Update_staff_sign_Saturday();
	}
	
	public int Update_staff_sign_Sunday()
	{
		return managerMapper.Update_staff_sign_Sunday();
	}
	
	public List<Ask_leave> permit_ask_leave(int staff_id)
	{
		return managerMapper.permit_ask_leave(staff_id);
	}
	
	public List<Ask_leave> permitDone_ask_leave(int staff_id)
	{
		return managerMapper.permitDone_ask_leave(staff_id);
	}
	
	public List<Ask_leave> checkPermitDone_ask_leaveByStaffId(int checkStaff_id)
	{
		return managerMapper.checkPermitDone_ask_leaveByStaffId(checkStaff_id);
	}
	
	public String show_img_prove(int id)
	{
		return managerMapper.show_img_prove(id);
	}
	
	public int datediff_ask_leave(int id)
	{
		return managerMapper.datediff_ask_leave(id);
	}
	
	public int permit_leaveP1(Timestamp in_time,int staff_id)
	{
		return managerMapper.permit_leaveP1(in_time, staff_id);
	}
	
	public Timestamp getAdd_1Timestamp(Timestamp new_in_time,int id)
	{
		return managerMapper.getAdd_1Timestamp(new_in_time,id);
	}
	
	public int permit_leaveP2(int id)
	{
		return managerMapper.permit_leaveP2(id);
	}
	
	public int addStaff(Staff staff)
	{
		return managerMapper.addStaff(staff);
	}
	
	public int addStaffP2(String new_staff_img,int staff_id)
	{
		return managerMapper.addStaffP2(new_staff_img, staff_id);
	}
	
	public List<Staff> checkBranchAllStaff(int staff_id)
	{
		return managerMapper.checkBranchAllStaff(staff_id);
	}
	
	public Staff_sign checkBranchStaffSign(int branch_staff_id,int year,int month,int day)
	{
		return managerMapper.checkBranchStaffSign(branch_staff_id, year, month, day);
	}
	
	public int delStaff(int branch_staff_id)
	{
		return managerMapper.delStaff(branch_staff_id);
	}
	
	public Staff updateStaffP1(int staff_branch_id)
	{
		return managerMapper.updateStaffP1(staff_branch_id);
	}
	
	
	
	public int updateStaff(String staff_username,int staff_level,String staff_job,int staff_branch_id,String staff_img,int branch_staff_id)
	{
		return managerMapper.updateStaff(staff_username,staff_level,staff_job,staff_branch_id,staff_img,branch_staff_id);
	}
	
	public int updateStaffnullImg(String staff_username,int staff_level,String staff_job,int staff_branch_id,int branch_staff_id)
	{
		return managerMapper.updateStaffnullImg(staff_username,staff_level,staff_job,staff_branch_id,branch_staff_id);
	}
	
	public List<Ask_out_office> permit_ask_out_office(int staff_id)
	{
		return managerMapper.permit_ask_out_office(staff_id);
	}
	
	public int datediff_ask_outside_office(int id)
	{
		return managerMapper.datediff_ask_outside_office(id);
	}
	
	public int permit_outside_officeP1(Timestamp in_time,Timestamp off_time,int staff_id)
	{
		return managerMapper.permit_outside_officeP1(in_time,off_time, staff_id);
	}
	
	public Timestamp getAdd_1outside_officeTimestamp(Timestamp new_in_time,int id)
	{
		return managerMapper.getAdd_1outside_officeTimestamp(new_in_time, id);
	}
	
	public int permit_outside_officeP2(int id)
	{
		return managerMapper.permit_outside_officeP2(id);
	}
	
	public List<Ask_out_office> permitDone_ask_outside_office(int staff_id)
	{
		return managerMapper.permitDone_ask_outside_office(staff_id);
	}
	
	public String show_img_AskOutOffice_prove(int id)
	{
		return managerMapper.show_img_AskOutOffice_prove(id);
	}
	
	public int CompanyNewsAdd(Company_news company_news)
	{
		return managerMapper.CompanyNewsAdd(company_news);
	}
	
	public int CompanyNewsAddP2(String Company_news_img,int Company_news_id)
	{
		return managerMapper.CompanyNewsAddP2(Company_news_img, Company_news_id);
	}
	
	public int MarketsNewsAdd(Markets_news markets_news)
	{
		return managerMapper.MarketsNewsAdd(markets_news);
	}
	
	public int MarketsNewsAddP2(String Markets_news_img,int Markets_news_id)
	{
		return managerMapper.MarketsNewsAddP2(Markets_news_img, Markets_news_id);
	}
	
	
}
