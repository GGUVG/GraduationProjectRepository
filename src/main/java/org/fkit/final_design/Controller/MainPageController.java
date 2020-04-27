package org.fkit.final_design.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fkit.final_design.Bean.Company_news;
import org.fkit.final_design.Bean.Estate;
import org.fkit.final_design.Bean.Markets_news;
import org.fkit.final_design.Bean.Staff;
import org.fkit.final_design.Bean.Staff_sign;
import org.fkit.final_design.Service.MainPage_Service;
import org.fkit.final_design.Service.PayrollAttendance_Service;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MainPageController {
	@Resource
	public PayrollAttendance_Service payrollAttendance_Service;
	
	//@Resource
	public Staff_sign staff_sign;
	
	//@Resource
	public Company_news company_news;
	
	@Resource
	public MainPage_Service mainPage_Service;
	
	@RequestMapping("/staff_sign_in")
	public String staff_sign_in(Model model,HttpSession session,Staff_sign staff_sign,Staff staff) throws Exception
	{
		Timestamp in_time=payrollAttendance_Service.getTime();
		staff_sign.setIn_time(in_time);
		int row=payrollAttendance_Service.staff_sign_in(staff_sign);
		int serial_id=staff_sign.getId();
		session.setAttribute("today_serial_id",serial_id);
		int hour=in_time.getHours();
		int minute=in_time.getMinutes();
		int seconds=in_time.getSeconds();
		staff=(Staff)session.getAttribute("STAFF_SESSION");
		
		if(hour<9)
		{
			System.out.println("sign early 09:00...");
			int row_early=payrollAttendance_Service.staff_sign_in_state_success(serial_id);
			int row_insure=payrollAttendance_Service.staff_sign_in_state_insure(serial_id,staff.getStaff_id());
			return "main";
		}
		else if(hour>9)
		{
			System.out.println("hour>09:00,late...");
			int row_late=payrollAttendance_Service.staff_sign_in_state_late(serial_id);
			int row_insure=payrollAttendance_Service.staff_sign_in_state_insure(serial_id,staff.getStaff_id());
			return "main";
		}else
		{
			//hour==8
			if(minute>=1)
			{
				System.out.println("minute>09:01,late...");
				int row_late=payrollAttendance_Service.staff_sign_in_state_late(serial_id);
				int row_insure=payrollAttendance_Service.staff_sign_in_state_insure(serial_id,staff.getStaff_id());
				return "main";
			}
			else
			{
				System.out.println("09:00<minute<08:01,normal...");
				int row_success=payrollAttendance_Service.staff_sign_in_state_success(serial_id);
				int row_insure=payrollAttendance_Service.staff_sign_in_state_insure(serial_id,staff.getStaff_id());
				return "main";
			}
		}
		
		//https://blog.csdn.net/zjc324106/article/details/27351923
	}
	
	@RequestMapping("/staff_sign_off")
	public String staff_sign_off(Model model,HttpSession session,Staff_sign staff_sign,Timestamp off_time,Staff staff) throws Exception
	{
		staff=(Staff)session.getAttribute("STAFF_SESSION");
		off_time=payrollAttendance_Service.getTime();
		int row_off=payrollAttendance_Service.staff_sign_off(off_time,(int)session.getAttribute("today_serial_id"));
		int off_hour=off_time.getHours();
		int off_minute=off_time.getMinutes();
		int off_seconds=off_time.getSeconds();
		if(off_hour<18)
		{
			System.out.println("early off...");
			int row_off_early=payrollAttendance_Service.staff_sign_off_state_early((int)session.getAttribute("today_serial_id"));
			int row_incheck=payrollAttendance_Service.staff_sign_final_inCheck((int)session.getAttribute("today_serial_id"));
			int row_offcheck=payrollAttendance_Service.staff_sign_final_offCheck((int)session.getAttribute("today_serial_id"));
			if(row_incheck==1 && row_offcheck==1)
			{
				int row_final_success=payrollAttendance_Service.staff_sign_final_state((int)session.getAttribute("today_serial_id"));
				int row_off_insure=payrollAttendance_Service.staff_sign_off_state_insure(staff.getStaff_id());
				session.removeAttribute("STAFF_SESSION");
				session.removeAttribute("today_serial_id");
				return "index";
			}
			else
			{
				int row_final_fail=payrollAttendance_Service.staff_sign_final_stateBad((int)session.getAttribute("today_serial_id"));
				int row_off_insure=payrollAttendance_Service.staff_sign_off_state_insure(staff.getStaff_id());
				session.removeAttribute("STAFF_SESSION");
				session.removeAttribute("today_serial_id");
				return "index";
			}
			
		}
		else
		{
			System.out.println("normal off...");
			int row_off_success=payrollAttendance_Service.staff_sign_off_state_success((int)session.getAttribute("today_serial_id"));
			int row_incheck=payrollAttendance_Service.staff_sign_final_inCheck((int)session.getAttribute("today_serial_id"));
			int row_offcheck=payrollAttendance_Service.staff_sign_final_offCheck((int)session.getAttribute("today_serial_id"));
			if(row_incheck==1 && row_offcheck==1)
			{
				int row_final_success=payrollAttendance_Service.staff_sign_final_state((int)session.getAttribute("today_serial_id"));
				int row_off_insure=payrollAttendance_Service.staff_sign_off_state_insure(staff.getStaff_id());
				session.removeAttribute("STAFF_SESSION");
				session.removeAttribute("today_serial_id");
				return "index";
			}
			else
			{
				int row_final_fail=payrollAttendance_Service.staff_sign_final_stateBad((int)session.getAttribute("today_serial_id"));
				int row_off_insure=payrollAttendance_Service.staff_sign_off_state_insure(staff.getStaff_id());
				session.removeAttribute("STAFF_SESSION");
				session.removeAttribute("today_serial_id");
				return "index";
			}
		}
	}
	
	@RequestMapping("/newsDetails")
	public String showNewsDetails(Model model,HttpSession session,int Company_news_id,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		Company_news company_news=mainPage_Service.showNewsDetails(Company_news_id);
		
		model.addAttribute("company_news", company_news);
		System.out.println(company_news);
		return "main/news_Details";
	}
	
	@RequestMapping("/showAllCompanyNews")
	public String showCompanyNews(HttpSession session,Model model,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Company_news> showNews=mainPage_Service.showAllCompanyNews();
		//System.out.println("List<Company_news>:..."+showNews);
		PageInfo<Company_news> NewsPage =new PageInfo<>(showNews);
		//System.out.println("PageInfo<Company_news>:..."+NewsPage);
		model.addAttribute("showNews", showNews);
		model.addAttribute("NewsPage", NewsPage);
		return "main/news";
		//https://how2j.cn/k/springboot/springboot-crud/1742.html#nowhere
	}
	
	@RequestMapping("/showMarketsNewsDetails")
	public String showMarketsNewsDetails(Model model,HttpSession session,int Markets_news_id)
	{
		Markets_news markets_news=mainPage_Service.showMarketsNewsDetails(Markets_news_id);
		model.addAttribute("markets_news", markets_news);
		return "main/MarketsNews_Details";
	}
	
	@RequestMapping("/showAllMarketsNews")
	public String showAllMarketsNews(HttpSession session,Model model,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Markets_news> showMarketsNews=mainPage_Service.showAllMarketsNews();
		PageInfo<Markets_news> NewsMarketsPage =new PageInfo<Markets_news>(showMarketsNews);
		model.addAttribute("showMarketsNews", showMarketsNews);
		model.addAttribute("NewsMarketsPage", NewsMarketsPage);
		return "main/MarketsNews";
	}
	
	@RequestMapping("/toSearchLinkage")
	public String toSearchLinkage(HttpSession session,Model model,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "3") int size)
	{
		PageHelper.startPage(start,size);
		List<Estate> list_EstateLinkage=mainPage_Service.showEstateLinkage();
		PageInfo<Estate> EstateLinkagePage =new PageInfo<>(list_EstateLinkage);
		model.addAttribute("list_EstateLinkage", list_EstateLinkage);
		model.addAttribute("EstateLinkagePage", EstateLinkagePage);
		return "main/SearchLinkage";
	}
	
	@RequestMapping("/showEstateDetails")
	public String showEstateDetails(HttpSession session,Model model,int estate_id)
	{
		Estate estateDetails=mainPage_Service.showEstateDetails(estate_id);
		model.addAttribute("estateDetails", estateDetails);
		return "main/SearchLinkage_Details";
	}
	
	@RequestMapping("/toPersonal")
	public String toPersonal(HttpSession session,Model model,int staff_id)
	{
		String superior_name=mainPage_Service.showSuperior(staff_id);
		String branch_name=mainPage_Service.showBranch_name(staff_id);
		model.addAttribute("superior_name", superior_name);
		model.addAttribute("branch_name", branch_name);
		return "main/Personal";
	}
	
	
}
