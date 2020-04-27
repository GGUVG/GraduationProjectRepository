package org.fkit.final_design.Controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.fkit.final_design.Bean.Staff_sign;
import org.fkit.final_design.Bean.Ask_leave;
import org.fkit.final_design.Bean.Ask_out_office;
import org.fkit.final_design.Service.PayrollAttendance_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PayrollAttendance_Controller {
	@Resource
	public PayrollAttendance_Service payrollAttendance_Service;
	
	@RequestMapping("/checkMonthSign")
	public String checkMonthSign(Model model,HttpSession session,int staff_id,String year,String month,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) throws Exception
	{
		PageHelper.startPage(start,size);
		List<Staff_sign> listStaff_sign=(List<Staff_sign>) payrollAttendance_Service.checkMonthSign(staff_id,year,month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		PageInfo<Staff_sign> listStaff_signPage =new PageInfo<>(listStaff_sign);
		model.addAttribute("listStaff_sign",listStaff_sign);
		model.addAttribute("listStaff_signPage",listStaff_signPage);
		return "platform/PayrollAttendance/checkMonthSign";
	}
	
	@RequestMapping("/checkSignSummary")
	public String checkSignSummary(Model model,HttpSession session,int staff_id,String year,String month,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Map<String,Object>> listStaff_checkSignSummary=payrollAttendance_Service.checkSignSummary(staff_id, year, month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		PageInfo<Map<String,Object>> listStaff_checkSignSummaryPage =new PageInfo<>(listStaff_checkSignSummary);
		model.addAttribute("listStaff_checkSignSummary",listStaff_checkSignSummary);
		model.addAttribute("listStaff_checkSignSummaryPage",listStaff_checkSignSummaryPage);
		return "platform/PayrollAttendance/checkSignSummary";
	}
	
	@RequestMapping("/checkSale_monthSalary")
	public String checkSale_monthSalary(Model model,HttpSession session,int staff_id,String year,String month,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Map<String,Object>> listCheckSale_monthSalary=payrollAttendance_Service.checkSale_monthSalary(staff_id, year, month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		PageInfo<Map<String,Object>> listCheckSale_monthSalaryPage =new PageInfo<>(listCheckSale_monthSalary);
		model.addAttribute("listCheckSale_monthSalary",listCheckSale_monthSalary);
		model.addAttribute("listCheckSale_monthSalaryPage",listCheckSale_monthSalaryPage);
		return "platform/PayrollAttendance/checkSale_monthSalary";
	}
	
	@RequestMapping("/checkSalary_Month")
	public String checkSalary_Month(Model model,HttpSession session,int staff_id,String year,String month,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Map<String,Object>> list_checkSalaryMonth1=payrollAttendance_Service.checkSalary_Month(staff_id, year, month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		PageInfo<Map<String,Object>> list_checkSalaryMonthPage =new PageInfo<>(list_checkSalaryMonth1);
		BigDecimal earnSale=payrollAttendance_Service.checkSaleCommission_Month(staff_id, year, month);
		BigDecimal rentSale=payrollAttendance_Service.checkRentCommission_Month(staff_id, year, month);
		model.addAttribute("list_checkSalaryMonth1",list_checkSalaryMonth1);
		model.addAttribute("list_checkSalaryMonthPage",list_checkSalaryMonthPage);
		model.addAttribute("earnSale",earnSale);
		model.addAttribute("rentSale",rentSale);
		return "platform/PayrollAttendance/checkSalary_Month";
	}
	
	@RequestMapping(value = "/ask_leave", method = RequestMethod.POST)
	public String Ask_leave(Model model,HttpSession session,Ask_leave ask_leave,@RequestParam("img_prove1")MultipartFile img_prove1) throws IllegalStateException, IOException
	{
		if (!img_prove1.isEmpty()) {
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\Ask_leave";
			String filename = img_prove1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            ask_leave.setImg_prove(filename);
			//String realpath = path + filename;
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			img_prove1.transferTo(new File(path + File.separator + filename));
		}
		
		
		
		
		//ask_leave.setLeave_time(ts_leave_time1);
		//ask_leave.setBack_time(ts_back_time1);
		int row=payrollAttendance_Service.ask_leave(ask_leave);
		if(row>=1)
		{
			System.out.println("insert ask_leave success...");
			return "MainPlatform";
		}
		else
		{
			System.out.println("insert ask_leave fail...");
			return "fail";
		}
		
	}
	
	@RequestMapping(value = "/ask_out_office", method = RequestMethod.POST)
	public String ask_outside_office(Model model,HttpSession session,Ask_out_office ask_out_office,@RequestParam("img_prove1")MultipartFile img_prove1) throws IllegalStateException, IOException
	{
		if (!img_prove1.isEmpty()) {
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\Ask_out_office";
			String filename = img_prove1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
            ask_out_office.setImg_prove(filename);
			//String realpath = path + filename;
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			img_prove1.transferTo(new File(path + File.separator + filename));
		}
		int row=payrollAttendance_Service.ask_out_office(ask_out_office);
		if(row>=1)
		{
			System.out.println("insert ask_leave success...");
			return "MainPlatform";
		}
		else
		{
			System.out.println("insert ask_leave fail...");
			return "fail";
		}
		
	}
	
}
