package org.fkit.final_design.Controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.fkit.final_design.Bean.Ask_leave;
import org.fkit.final_design.Bean.Ask_out_office;
import org.fkit.final_design.Bean.Client_sale;
import org.fkit.final_design.Bean.CompanyBranches;
import org.fkit.final_design.Bean.Company_news;
import org.fkit.final_design.Bean.Deal_salepreparation;
import org.fkit.final_design.Bean.Estate;
import org.fkit.final_design.Bean.House_sale;
import org.fkit.final_design.Bean.Markets_news;
import org.fkit.final_design.Bean.RentPreparation;
import org.fkit.final_design.Bean.SalePreparation;
import org.fkit.final_design.Bean.Staff;
import org.fkit.final_design.Bean.Staff_sign;
import org.fkit.final_design.Service.MainPage_Service;
import org.fkit.final_design.Service.Manager_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ManagerController {
	@Resource
	public Manager_Service managerService;
	
	@Resource
	public MainPage_Service mainPage_Service;
	
	@RequestMapping("/checkIfManager")
	public String checkIfManager(int staff_id)
	{
		String s1=managerService.checkIfManager(staff_id);
		return s1;
	}
	
	
	@RequestMapping("/toPermitSalePreparationMethod")
	public String CheckToPermitSalePreparation(int staff_id,SalePreparation salePreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null || s1.isEmpty())
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listMapSalePreparation=managerService.CheckToPermitSalePreparation(staff_id);
		model.addAttribute("listMapSalePreparation",listMapSalePreparation);
		return "platform/Manager/toPermitSalePreparationMethod";
	}
	
	@RequestMapping("/CheckAllPermitSalePreparation")
	public String CheckAllPermitSalePreparation(int staff_id,SalePreparation salePreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listMapAllSalePreparation=managerService.CheckAllPermitSalePreparation(staff_id);
		model.addAttribute("listMapAllSalePreparation", listMapAllSalePreparation);
		return "platform/Manager/toAllPermitSalePreparation";
	}
	
	
	@RequestMapping("/PermitSalePreparation")
	public String PermitSalePreparation(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time,String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark,int Client_sstaffid,Timestamp permit_time,int salePreparation_id,Model model,HttpSession session)
	{
		String row0Check=managerService.PermitSalePreparationP1Check(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
	  if(row0Check==null)
	  {
		int row1=managerService.PermitSalePreparationP1(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
		String row1Check=managerService.PermitSalePreparationP2Check(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark);
		if(row1Check!=null)
		{
			int getHouse_sclientid=managerService.PermitSalePreparationP3(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark, Client_sstaffid);
			int getHouse_sid=managerService.PermitSalePreparationP4(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
			int row3=managerService.PermitSalePreparationP5(getHouse_sclientid, getHouse_sid);
			permit_time=managerService.getTime();
			int row4=managerService.PermitSalePreparationP6(permit_time,salePreparation_id);
			if(row1>0 && row3>0 && row4>0)
			{
				return "MainPlatform";
		    }else
		   return "fail";
		}else
		{
			int row2=managerService.PermitSalePreparationP2(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark, Client_sstaffid);
			int getHouse_sclientid=managerService.PermitSalePreparationP3(Client_sname, Client_ssex, Client_saddress, Client_sphone, Client_sremark, Client_sstaffid);
			int getHouse_sid=managerService.PermitSalePreparationP4(House_sname, House_sestate, House_slocation, House_sprice, House_ssquare, Complete_time);
			int row3=managerService.PermitSalePreparationP5(getHouse_sclientid, getHouse_sid);
			permit_time=managerService.getTime();
			int row4=managerService.PermitSalePreparationP6(permit_time,salePreparation_id);
			if(row1>0 && row2>0 && row3>0 && row4>0)
			{
				return "MainPlatform";
		    }else
		   return "fail";
		}
	  }
	  else
	  {
		  //System.out.println("house_sale already exist...");
		  return "fail";
	  }
	}
	
	@RequestMapping("/toPermitRentPreparationMethod")
	public String CheckToPermitRentPreparation(int staff_id,RentPreparation rentPreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		  if(s1==null)
		  {
		   return "notAdmin";
		  }
		List<Map<String,Object>> listMapRentPreparation=managerService.CheckToPermitRentPreparation(staff_id);
		model.addAttribute("listMapRentPreparation",listMapRentPreparation);
		return "platform/Manager/toPermitRentPreparationMethod";
	}
	
	@RequestMapping("/CheckAllPermitRentPreparation")
	public String CheckAllPermitRentPreparation(int staff_id,RentPreparation rentPreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listMapAllRentPreparation=managerService.CheckAllPermitRentPreparation(staff_id);
		model.addAttribute("listMapAllRentPreparation", listMapAllRentPreparation);
		return "platform/Manager/toAllPermitRentPreparation";
	}
	
	@RequestMapping("/PermitRentPreparation")
	public String PermitRentPreparation(Model model,HttpSession session,String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time,String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark,int Client_lstaffid,Timestamp permit_time,int rentPreparation_id)
	{
		String row0Check=managerService.PermitRentPreparationP1Check(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
		if(row0Check==null)
		{
			System.out.println("new house_lease...");
			String row1check=managerService.PermitRentPreparationP2Check(Client_lname, Client_lsex, Client_laddress, Client_lphone,Client_lremark);
				if(row1check==null)
				 {	//新客户添加新放租房源
					int row1=managerService.PermitRentPreparationP1(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
					int row2=managerService.PermitRentPreparationP2(Client_lname, Client_lsex, Client_laddress, Client_lphone, Client_lremark, Client_lstaffid);
					int row3=managerService.PermitRentPreparationP3(Client_lname, Client_lsex, Client_laddress, Client_lphone, Client_lremark, Client_lstaffid);
					int getHouse_lclientid=row3;
					int row4=managerService.PermitRentPreparationP4(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
					int getHouse_lid=row4;
					int row5=managerService.PermitRentPreparationP5(getHouse_lclientid, getHouse_lid);
					permit_time=managerService.getTime();
					int row6=managerService.PermitRentPreparationP6(permit_time, rentPreparation_id);
					if(row1>0 && row2>0 && row5>0 && row6>0)
					{
						return "MainPlatform";
					}
					else
					{
						//System.out.println("insert into house_lease,client_lease fail...");
						return "fail";
					}
				 }
				 else
				 { 	 //旧客户添加新放租房源
					 int row1=managerService.PermitRentPreparationP1(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
					 int row3=managerService.PermitRentPreparationP3(Client_lname, Client_lsex, Client_laddress, Client_lphone, Client_lremark, Client_lstaffid);
					 int getHouse_lclientid=row3;
					 int row4=managerService.PermitRentPreparationP4(House_lname, House_lestate, House_llocation, House_lprice, House_lsquare, Complete_time);
					 int getHouse_lid=row4;
					 int row5=managerService.PermitRentPreparationP5(getHouse_lclientid, getHouse_lid);
					 permit_time=managerService.getTime();
					 int row6=managerService.PermitRentPreparationP6(permit_time, rentPreparation_id);
					 	if(row1>0 && row5>0 && row6>0)
					 	  {
							  return "MainPlatform";
					 	  }
					 	else
						  {
							//System.out.println("insert into house_lease,client_lease fail...");
							return "fail";
						  }
				 }
		}
			//System.out.println("house_lease already exist...");
		    return "fail";
	}
	
	@RequestMapping("/Check_DealSalePreparation")
	public String Check_DealSalePreparation(int staff_id,Deal_salepreparation deal_salepreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listDeal_salePreparation=managerService.Check_DealSalePreparation(staff_id);
		model.addAttribute("listDeal_salePreparation",listDeal_salePreparation);
		return "platform/Manager/toPermitDeal_SalePreparation";
	}
	
	
	@RequestMapping("/showImgSale_property")
	public String showImgSale_property(int deal_salepreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImg_property(deal_salepreparation_id);
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgSale_property";
	}
	
	@RequestMapping("/showImgSale_purchaserIDcard")
	public String showImgSale_purchaserIDcard(int deal_salepreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImg_purchaserIDcard(deal_salepreparation_id);
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgSale_purchaserIDcard";
	}
	
	@RequestMapping("/showImgSale_agreement")
	public String showImgSale_agreement(int deal_salepreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImg_agreement(deal_salepreparation_id);
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgSale_agreement";
	}
	
	@RequestMapping("/PermitDeal_SalePreparation")
	public String PermitDeal_SalePreparation(Model model,HttpSession session,int House_sid,String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark,int client_wbstaffid,Timestamp permit_time,int deal_salepreparation_id)
	{
		int row1check=managerService.PermitDeal_SalePreparationP1Check(House_sid);
		if(row1check==0)
		{
			String row1_1check=managerService.PermitDeal_SalePreparationP1_1Check(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark);
			System.out.println(row1_1check);
			if(row1_1check==null)
			{
				int row2=managerService.PermitDeal_SalePreparationP2(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark, client_wbstaffid);	
				System.out.println("row2...");
				int row3=managerService.PermitDeal_SalePreparationP3(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark);
				System.out.println("row3...");
				int get_purchaser_id=row3;
				permit_time=managerService.getTime();
				int row4=managerService.PermitDeal_SalePreparationP4(get_purchaser_id, House_sid,permit_time);
				System.out.println("row4...");
				int row5=managerService.PermitDeal_SalePreparationP5(permit_time, deal_salepreparation_id);
				if(row2>0 && row4>0 && row5>0)
				{
					System.out.println("row245 success...");
					return "MainPlatform";
				}
				else
				{
					System.out.println("row245 fail...");
					return "fail";
				}
				
			}
			else
			{
				System.out.println("client_want_buy already exist...");
				int row3=managerService.PermitDeal_SalePreparationP3(client_wbname, client_wbsex, client_wbaddress, client_wbphone, client_wb_remark);
				int get_purchaser_id=row3;
				permit_time=managerService.getTime();
				int row4=managerService.PermitDeal_SalePreparationP4(get_purchaser_id, House_sid,permit_time);
				permit_time=managerService.getTime();
				int row5=managerService.PermitDeal_SalePreparationP5(permit_time, deal_salepreparation_id);
				if(row4>0 && row5>0)
				{
					//System.out.println("row245 success...");
					return "MainPlatform";
				}
				else
				{
					//System.out.println("row245 fail...");
					return "fail";
				}
			}
		}
		else
		{
			//System.out.println("house already sale...check agagin house_sid...");
			return "fail";
		}
	}
	
	@RequestMapping("/Check_AlreadyDealSalePreparation")
	public String Check_AlreadyDealSalePreparation(int staff_id,Deal_salepreparation deal_salepreparation,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listDeal_AlreadysaleP=managerService.Check_AlreadyDealSalePreparation(staff_id);
		model.addAttribute("listDeal_AlreadysaleP",listDeal_AlreadysaleP);
		return "platform/Manager/toAlreadyDeal_SalePreparation";
	}
	
	@RequestMapping("/Check_DealRentPreparation")
	public String Check_DealRentPreparation(int staff_id,Model model,HttpSession session)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			return "notAdmin";
		}
		List<Map<String,Object>> listDeal_rentPreparation=managerService.Check_DealRentPreparation(staff_id);
		model.addAttribute("listDeal_rentPreparation",listDeal_rentPreparation);
		System.out.println(listDeal_rentPreparation);
		return "platform/Manager/toPermitDeal_RentPreparation";
	}
	
	//Check_AlreadyDealRentPreparation
	@RequestMapping("/Check_AlreadyDealRentPreparation")
	public String Check_AlreadyDealRentPreparation(int staff_id,Model model,HttpSession session)
	{

		String s1=managerService.checkIfManager(staff_id);
		if(s1==null)
		{
			JOptionPane.showMessageDialog(null, "not admin");
			return "fail";
		}
		List<Map<String,Object>> listDeal_AlreadyrentP=managerService.Check_AlreadyDealRentPreparation(staff_id);
		model.addAttribute("listDeal_AlreadyrentP",listDeal_AlreadyrentP);
		System.out.println(listDeal_AlreadyrentP);
		return "platform/Manager/toAlreadyDeal_RentPreparation";
	}
	
	@RequestMapping("/showImgRent_agreement")
	public String showImgRent_agreement(int deal_rentpreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImgRent_agreement(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_agreement";
	}
	
	@RequestMapping("/showImgRent_ammeter_record")
	public String showImgRent_ammeter_record(int deal_rentpreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImgRent_ammeter_record(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_ammeter_record";
	}
	
	@RequestMapping("/showImgRent_furniture_record")
	public String showImgRent_furniture_record(int deal_rentpreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImgRent_furniture_record(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_furniture_record";
	}
	
	@RequestMapping("/showImgRent_landlordIDcard_copy")
	public String showImgRent_landlordIDcard_copy(int deal_rentpreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImgRent_landlordIDcard_copy(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_landlordIDcard_copy";
	}
	
	@RequestMapping("/showImgRent_property_copy")
	public String showImgRent_property_copy(int deal_rentpreparation_id, Model model, HttpSession session) {
		String imgPath = managerService.showImgRent_property_copy(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_property_copy";
	}
	
	@RequestMapping("/showImgRent_purchaserIDcard_copy")
	public String showImgRent_purchaserIDcard_copy(int deal_rentpreparation_id, Model model, HttpSession session) 
	{
		String imgPath = managerService.showImgRent_purchaserIDcard_copy(deal_rentpreparation_id);
		System.out.println(imgPath);// check
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImgRent_purchaserIDcard_copy";
	}
	
	@RequestMapping("/PermitDeal_RentPreparation")
	public String PermitDeal_RentPreparation(Model model,HttpSession session,int House_lid,int House_lprice,String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark,int client_wrstaffid,int deal_rentpreparation_id,Timestamp permit_time)
	{
		int row1check=managerService.PermitDeal_RentPreparationP1Check(House_lid);
		if(row1check==0)
		{
			String row1_1check=managerService.PermitDeal_RentPreparationP1_1Check(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark);
			if(row1_1check==null)
			{
				System.out.println("new client_want_rent...");
				int row2=managerService.PermitDeal_RentPreparationP2(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark, client_wrstaffid);
				System.out.println("row2...");
				int row3=managerService.PermitDeal_RentPreparationP3(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark);
				int get_client_wrid=row3;
				System.out.println("row3..."+get_client_wrid);
				permit_time=managerService.getTime();
				int row4=managerService.PermitDeal_RentPreparationP4(House_lprice,get_client_wrid, House_lid, permit_time);
				System.out.println("row4...");
				
				int row5=managerService.PermitDeal_RentPreparationP5(permit_time, deal_rentpreparation_id);
				System.out.println("row5...");
				if(row2>0 && row4>0 &&row5>0)
				{
					System.out.println("row2345 success,permit success...");
					return "MainPlatform";
				}
				else
				{
					System.out.println("fail permit...");
					return "fail";
				}
			}
			else
			{
				System.out.println("client already exist...");
				int row3=managerService.PermitDeal_RentPreparationP3(client_wrname, client_wrsex, client_wraddress, client_wrphone, client_wr_remark);
				int get_client_wrid=row3;
				System.out.println("row3..."+get_client_wrid);
				permit_time=managerService.getTime();
				int row4=managerService.PermitDeal_RentPreparationP4(House_lprice,get_client_wrid, House_lid, permit_time);
				System.out.println("row4...");
				int row5=managerService.PermitDeal_RentPreparationP5(permit_time, deal_rentpreparation_id);
				System.out.println("row5...");
				if(row4>0 &&row5>0)
				{
					System.out.println("row45 success,permit success...");
					return "MainPlatform";
				}
				else
				{
					System.out.println("fail permit...");
					return "fail";
				}
			}
		}
		else
		{
			System.out.println("check house_lid again or update house_lstate,house_lid already exits...");
			return "fail";
		}
	}
	
	@RequestMapping("/Update_house_lease_state")
	public String Update_house_lease_state()
	{
		int row=managerService.Update_house_lease_state();
		return "MainPlatform";

	}
	
	@RequestMapping("/insert_not_in_staff_sign")
	public String insert_not_in_staff_sign()
	{
		
		int row=managerService.insert_not_in_staff_sign();
		return "MainPlatform";
	}
	
	@RequestMapping("/Update_staff_sign_SaturdaySunday")
	public String Update_staff_sign_Saturday()
	{
		int row1=managerService.Update_staff_sign_Saturday();
		int row2=managerService.Update_staff_sign_Sunday();
		return "MainPlatform";
	}

	//check_permit_ask_leave
	@RequestMapping("/check_permit_ask_leave")
	public String check_permit_ask_leave(int staff_id,Model model,HttpSession session)
	{

			String s1=managerService.checkIfManager(staff_id);
			if(s1==null)
			{
				return "notAdmin";
			}
			List<Ask_leave> list_permitAskLeave=managerService.permit_ask_leave(staff_id);
			model.addAttribute("list_permitAskLeave",list_permitAskLeave);
			System.out.println(list_permitAskLeave);
			return "platform/Manager/permit_ask_leave";
	}
	
	@RequestMapping("/show_img_prove")
	public String show_img_prove(int id, Model model, HttpSession session) 
	{
		String imgPath = managerService.show_img_prove(id);
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/show_img_prove";
	}
	
	@RequestMapping("/permit_leave")
	public String permit_leave(Timestamp in_time,int staff_id,int id,Model model,HttpSession session)
	{
		
		int last_day=managerService.datediff_ask_leave(id);
		if(last_day<=1)
		{
			System.out.println("ask for 1 day leave...success insert...");
			int row1=managerService.permit_leaveP1(in_time, staff_id);
			if(row1>=1)
			{
				int row3=managerService.permit_leaveP2(id);
				System.out.println("single leave...");
				return "MainPlatform";
			}
			else
			{
				return "fail";
			}
		}
		else
		{
			for(int i=1;i<=last_day;i++)
			{
				int row2=managerService.permit_leaveP1(in_time, staff_id);
				int row3=managerService.permit_leaveP2(id);
				in_time=managerService.getAdd_1Timestamp(in_time,id);	
			}
			return "MainPlatform";
		}
		
	}
	
	//check_permit_ask_leave
	@RequestMapping("/checkDone_permit_ask_leave")
	public String checkDone_permit_ask_leave(int staff_id,Model model,HttpSession session)
	{

				String s1=managerService.checkIfManager(staff_id);
				if(s1==null || s1=="0")
				{
					return "notAdmin";
				}
				List<Ask_leave> list_permitDoneAskLeave=managerService.permitDone_ask_leave(staff_id);
				model.addAttribute("list_permitDoneAskLeave",list_permitDoneAskLeave);
				return "platform/Manager/permitDone_ask_leave";
	}
	
	//
	@RequestMapping("/checkPermitDone_ask_leaveByStaffId")
	public String checkPermitDone_ask_leaveByStaffId(int checkStaff_id,Model model,HttpSession session)
	{
				List<Ask_leave> list_permitDoneAskLeaveById=managerService.checkPermitDone_ask_leaveByStaffId(checkStaff_id);
				model.addAttribute("list_permitDoneAskLeaveById",list_permitDoneAskLeaveById);
				return "platform/Manager/permitDone_ask_leaveById";
	}
	
	//check_permit_ask_leave
	@RequestMapping("/check_permit_ask_out_office")
	public String check_permit_ask_out_office(int staff_id,Model model,HttpSession session)
	{

				String s1=managerService.checkIfManager(staff_id);
				if(s1==null)
				{
					return "notAdmin";
				}
				List<Ask_out_office> list_permitAsk_out_office=managerService.permit_ask_out_office(staff_id);
				model.addAttribute("list_permitAsk_out_office",list_permitAsk_out_office);
				
				return "platform/Manager/permit_ask_out_office";
	}
	
	@RequestMapping("/permit_out_office")
	public String permit_out_office(Timestamp in_time,Timestamp off_time,int staff_id,int id,Model model,HttpSession session)
	{
		
		int last_day=managerService.datediff_ask_outside_office(id);
		if(last_day<=1)
		{
			int row1=managerService.permit_outside_officeP1(in_time,off_time, staff_id);
			if(row1>=1)
			{
				int row3=managerService.permit_outside_officeP2(id);
				return "MainPlatform";
			}
			else
			{
				return "fail";
			}
		}
		else
		{
			for(int i=1;i<=last_day;i++)
			{
				int row2=managerService.permit_outside_officeP1(in_time,off_time, staff_id);
				int row3=managerService.permit_outside_officeP2(id);
				in_time=managerService.getAdd_1outside_officeTimestamp(in_time, id);
			}
			return "MainPlatform";
		}
	}
	
	@RequestMapping("/checkDone_permit_ask_out_office")
	public String checkDone_permit_ask_out_office(int staff_id,Model model,HttpSession session)
	{
				String s1=managerService.checkIfManager(staff_id);
				if(s1==null)
				{
					return "notAdmin";
				}
				List<Ask_out_office> list_permitDoneAskOut=managerService.permitDone_ask_outside_office(staff_id);
				model.addAttribute("list_permitDoneAskOut",list_permitDoneAskOut);
				return "platform/Manager/permitDone_ask_out_office";
	}
	
	
	@RequestMapping("/show_img_AskOutOffice_prove")
	public String showImg_AskOutOffice(int ask_out_office_id, Model model, HttpSession session) 
	{
		String imgPath = managerService.show_img_AskOutOffice_prove(ask_out_office_id);
		model.addAttribute("imgPath", imgPath);
		return "platform/Manager/showImg_Ask_out_office";
	}
	
	//增加员工
	@RequestMapping(value ="/addStaff",method = RequestMethod.POST)
	public String addStaff(@RequestParam("staff_img1")MultipartFile staff_img1,Model model,HttpSession session,Staff staff,@RequestParam("staff_username1")String staff_username1,@RequestParam("staff_job1")String staff_job1,@RequestParam("staff_level1")int staff_level1,@RequestParam("staff_branch_name1")String staff_branch_name1) throws IllegalStateException, IOException
	{
		staff.setStaff_username(staff_username1);
		staff.setStaff_job(staff_job1);
		staff.setStaff_level(staff_level1);
		int staff_branch_id1=mainPage_Service.GetCb_idByName(staff_branch_name1);
		staff.setStaff_branch_id(staff_branch_id1);
		int row1=managerService.addStaff(staff);
		int staff_id1=staff.getStaff_id();
		if (!staff_img1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\staff_img";
			String filename = staff_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            filename=filename.replace(filename, staff_id1+staff_username1+".jpg");
            staff.setStaff_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			staff_img1.transferTo(new File(path + File.separator + filename));
			int row2=managerService.addStaffP2(filename, staff_id1);
		}
		
		if(row1>0)
		{
			//System.out.println("add staff success...");
			return "main";
		}
		else
		{
			//System.out.println("add staff fail..");
			return "fail";
		}
	}
	
	@RequestMapping("/checkBranchAllStaff")
	public String checkBranchAllStaff(Model model,HttpSession session,int staff_id,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null || s1.isEmpty())
		{
			return "notAdmin";
		}
		PageHelper.startPage(start,size);
		List<Staff> list_allBranchStaff=managerService.checkBranchAllStaff(staff_id);
		PageInfo<Staff> Page_allBranchStaff =new PageInfo<>(list_allBranchStaff);
		model.addAttribute("list_allBranchStaff", list_allBranchStaff);
		model.addAttribute("Page_allBranchStaff", Page_allBranchStaff);
		return "platform/Manager/MyBranchStaff";
	}
	
	@RequestMapping("/BranchStaffSign_Detail")
	public String BranchStaffSign_Detail(Model model,HttpSession session,int branch_staff_id)
	{
		Timestamp time_now=managerService.getTime();
		int year=time_now.getYear()+1900;
		int month=time_now.getMonth()+ 1;
		int day=time_now.getDate();
		Staff_sign staff_sign_details=managerService.checkBranchStaffSign(branch_staff_id, year, month, day);
		model.addAttribute("staff_sign_details", staff_sign_details);
		return "platform/Manager/BranchStaffSign_Details";
	}
	

	@RequestMapping("/delStaff")
	public String delStaff(Model model,HttpSession session,int branch_staff_id)
	{
		int row1=managerService.delStaff(branch_staff_id);
		return "MainPlatform";
	}
	
	@RequestMapping("/UpdateStaff")
	public String UpdateStaff(Model model,HttpSession session,int branch_staff_id,String staff_username,Integer staff_level,String staff_job,Integer staff_branch_id,String staff_img,@RequestParam("staff_username1")String staff_username1,@RequestParam("staff_job1")String staff_job1,@RequestParam("staff_level1")int staff_level1,@RequestParam("staff_branch_name1")String staff_branch_name1,@RequestParam("staff_img1")MultipartFile staff_img1) throws IllegalStateException, IOException
	{
		staff_username=staff_username1;
		staff_level=staff_level1;
		staff_job=staff_job1;
		int staff_branch_id1=mainPage_Service.GetCb_idByName(staff_branch_name1);
		staff_branch_id=staff_branch_id1;
		if (!staff_img1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\staff_img";
			String filename = staff_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            filename=filename.replace(filename, branch_staff_id+staff_username1+".jpg");
            staff_img=filename;     
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			staff_img1.transferTo(new File(path + File.separator + filename));
			int row1=managerService.updateStaff(staff_username,staff_level,staff_job,staff_branch_id,staff_img,branch_staff_id);
		}
		else
		{
		int row2=managerService.updateStaffnullImg(staff_username1, staff_level, staff_job1, staff_branch_id, branch_staff_id);
		}
		return "MainPlatform";
	}
	
	@RequestMapping(value="/CompanyNewsAdd",method = RequestMethod.POST)
	public String CompanyNewsAdd(Model model,HttpSession session,Company_news company_news,@RequestParam("Company_news_img1")MultipartFile Company_news_img1,@RequestParam("Company_news_title1")String Company_news_title1,@RequestParam("Company_news_content1")String Company_news_content1,@RequestParam("Company_news_staffid1")int Company_news_staffid1) throws IllegalStateException, IOException
	{
		Timestamp time_now=managerService.getTime();
		company_news.setCompany_news_title(Company_news_title1);
		company_news.setCompany_news_content(Company_news_content1);
		company_news.setCompany_news_staffid(Company_news_staffid1);
		company_news.setPublish_time(time_now);
		int row1=managerService.CompanyNewsAdd(company_news);
		int company_news_id1=company_news.getCompany_news_id();
		if (!Company_news_img1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\CompanyNews";
			String filename = Company_news_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            String s1="CompanyNews";
            if(filename.contains(".gif"))
            {
            	filename=filename.replace(filename, s1+company_news_id1+".gif");
            }else
            {
            	filename=filename.replace(filename, s1+company_news_id1+".jpg");
            }
            
            company_news.setCompany_news_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists())
			{
				filepath.getParentFile().mkdirs();
			}
			Company_news_img1.transferTo(new File(path + File.separator + filename));
			int row2=managerService.CompanyNewsAddP2(filename, company_news_id1);
		}
		return "MainPlatform";
	}
	
	@RequestMapping(value="/MarketsNewsAdd",method = RequestMethod.POST)
	public String MarketsNewsAdd(Model model,HttpSession session,Markets_news markets_news,@RequestParam("Markets_news_img1")MultipartFile Markets_news_img1,@RequestParam("Markets_news_title1")String Markets_news_title1,@RequestParam("Markets_news_content1")String Markets_news_content1,@RequestParam("Markets_news_staffid1")int Markets_news_staffid1) throws IllegalStateException, IOException
	{
		Timestamp time_now=managerService.getTime();
		markets_news.setMarkets_news_title(Markets_news_title1);
		markets_news.setMarkets_news_content(Markets_news_content1);
		markets_news.setMarkets_news_staffid(Markets_news_staffid1);
		markets_news.setPublish_time(time_now);
		int row1=managerService.MarketsNewsAdd(markets_news);
		int markets_news_id1=markets_news.getMarkets_news_id();
		if (!Markets_news_img1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\MarketsNews";
			String filename = Markets_news_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            String s1="MarketsNews";
            if(filename.contains(".gif"))
            {
            	filename=filename.replace(filename, s1+markets_news_id1+".gif");
            }else
            {
            	filename=filename.replace(filename, s1+markets_news_id1+".jpg");
            }
            markets_news.setMarkets_news_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists())
			{
				filepath.getParentFile().mkdirs();
			}
			Markets_news_img1.transferTo(new File(path + File.separator + filename));
			int row2=managerService.MarketsNewsAddP2(filename, markets_news_id1);
		}
		
		return "MainPlatform";
	}
	
	@RequestMapping(value="/changePassword",method = RequestMethod.POST)
	public String changePassword( Model model, HttpSession session,@RequestParam("staff_password1")String staff_password1,@RequestParam("staff_id1")int staff_id1) 
	{
		int row1=mainPage_Service.changePassword(staff_password1, staff_id1);
		return "main";
	}
	
}
