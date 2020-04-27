package org.fkit.final_design.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.fkit.final_design.Bean.CompanyBranches;
import org.fkit.final_design.Bean.Staff;
import org.fkit.final_design.Bean.Staff_sign;
import org.fkit.final_design.Service.MainPage_Service;
import org.fkit.final_design.Service.Manager_Service;
import org.fkit.final_design.Service.Staff_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

@Controller
public class LoginController {
	@Resource
	public Staff_Service staffService;
	
	@Resource
	public Manager_Service managerService;
	
	@Resource
	public MainPage_Service mainPageService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String staffLogin(@RequestParam("staff_id")int staff_id,@RequestParam("staff_password")String staff_password,Model model,HttpSession session)
	{
		Staff staff=staffService.staffLogin(staff_id, staff_password);
		if(staff != null)
		{
			session.setAttribute("STAFF_SESSION", staff);
			List<Map<String,Object>> showNews=mainPageService.showNews();
			List<Map<String,Object>> showMarket5News=mainPageService.showMarket5News();
			model.addAttribute("showNews", showNews);
			model.addAttribute("showMarket5News", showMarket5News);
			return "main";
		}
		model.addAttribute("msg","error admin_id or admin_password");
		return "index";
	}
	
	@RequestMapping(value="loginToPlatform",method=RequestMethod.POST)
	public String loginToPlatform()
	{
		return "MainPlatform";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		//clear session
		session.invalidate();
		//redirect to login page's method
		return "index";
	}
	
	@RequestMapping(value="/toMain")
	public String myself(HttpSession session,Staff staff,Model model)
	{
		//session.setAttribute("STAFF_SESSION", staff);
		List<Map<String,Object>> showNews=mainPageService.showNews();
		List<Map<String,Object>> showMarket5News=mainPageService.showMarket5News();
		model.addAttribute("showNews", showNews);
		model.addAttribute("showMarket5News", showMarket5News);
		return "main";
	}
	
	@RequestMapping(value="/toPlatform")
	public String toPlatform()
	{
		return "MainPlatform";
	}
	
	@RequestMapping(value="/toSalePreparationMethod")
	public String toSalePreparationMethod()
	{
		return "platform/SalePreparationMethod";
	}
	
	@RequestMapping(value="/toRentPreparationMethod")
	public String toRentPreparationMethod()
	{
		return "platform/RentPreparationMethod";
	}
	
	@RequestMapping(value="/toDeal_salepreparation")
	public String toDeal_salepreparation()
	{
		return "platform/Deal_salepreparation";
	}
	
	@RequestMapping(value="/toDeal_RentPreparation")
	public String toDeal_rentpreparation()
	{
		return "platform/Deal_rentpreparation";
	}
	
	@RequestMapping(value="/tocheckMonthSign")
	public String tocheckMonthSign(Model model)
	{
//		PageInfo<Staff_sign> listStaff_signPage =new PageInfo<Staff_sign>();
//		model.addAttribute("listStaff_signPage",listStaff_signPage);
		return "platform/PayrollAttendance/checkMonthSign";
	}
	
	@RequestMapping(value="/tocheckSignSummary")
	public String tocheckSignSummary()
	{
		return "platform/PayrollAttendance/checkSignSummary";
	}
	
	@RequestMapping(value="/tocheckSale_monthSalary")
	public String tocheckSale_monthSalary()
	{
		return "platform/PayrollAttendance/checkSale_monthSalary";
	}
	
	@RequestMapping(value="/tocheckSalary_Month")
	public String tocheckSalary_Month()
	{
		return "platform/PayrollAttendance/checkSalary_Month";
	}
	
	@RequestMapping(value="/toask_outside_office")
	public String toask_outside_office()
	{
		return "platform/PayrollAttendance/ask_outside_office";
	}
	
	@RequestMapping(value="/toask_leave")
	public String toask_leave()
	{
		return "platform/PayrollAttendance/ask_leave";
	}
	
	@RequestMapping(value="/toTest")
	public String toTest()
	{
		return "Test";
	}
	
	@RequestMapping(value="/toWebChat")
	public String toWebChat(HttpSession session)
	{
		System.out.println((Staff)session.getAttribute("STAFF_SESSION"));
		return "WebChat";
	}
	
	@RequestMapping(value="/toaddStaff")
	public String toaddStaff(HttpSession session,int staff_id,Model model)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null || s1.isEmpty())
		{
			return "notAdmin";
		}
		List<CompanyBranches> list_showBranchName=mainPageService.showBranchNameList();
		model.addAttribute("list_showBranchName", list_showBranchName);
		return "platform/Manager/addStaff";
	}
	
	@RequestMapping(value="/toEditStaff")
	public String toEditStaff(HttpSession session,Model model,int staff_branch_id)
	{
		Staff staff1=managerService.updateStaffP1(staff_branch_id);
		List<CompanyBranches> list_showBranchName=mainPageService.showBranchNameList();
		model.addAttribute("staff1", staff1);
		model.addAttribute("list_showBranchName", list_showBranchName);
		return "platform/Manager/EditStaff";
	}
	
	@RequestMapping(value="/toCompanyNewsAdd")
	public String toCompanyNewsAdd(HttpSession session,int staff_id,Model model)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null || s1.isEmpty())
		{
			return "notAdmin";
		}
		return "platform/Manager/CompanyNewsAdd";
	}
	
	@RequestMapping(value="/toMarketsNewsAdd")
	public String toMarketsNewsAdd(HttpSession session,int staff_id,Model model)
	{
		String s1=managerService.checkIfManager(staff_id);
		if(s1==null || s1.isEmpty())
		{
			return "notAdmin";
		}
		return "platform/Manager/MarketsNewsAdd";
	}
	
	@RequestMapping(value="/toChangePassword")
	public String toChangePassword(HttpSession session,Model model)
	{
		
		return "main/ChangePassword";
	}
	
}
