package org.fkit.final_design.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.fkit.final_design.Mapper.PayrollAttendance_Mapper;
import org.fkit.final_design.Bean.Ask_leave;
import org.fkit.final_design.Bean.Ask_out_office;
import org.fkit.final_design.Bean.Staff_sign;
import org.springframework.stereotype.Service;

@Service
public class PayrollAttendance_Service {
	@Resource
	public PayrollAttendance_Mapper payrollAttendance_Mapper;
	
	public Timestamp getTime()
	{
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	public int staff_sign_in(Staff_sign staff_sign)
	{
		return payrollAttendance_Mapper.staff_sign_in(staff_sign);
	}
	
	public int staff_sign_in_state_success(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_in_state_success(serial_id);
	}
	
	public int staff_sign_in_state_insure(int serial_id,int staff_id)
	{
		return payrollAttendance_Mapper.staff_sign_in_state_insure(serial_id, staff_id);
	}
	
	public int staff_sign_in_state_late(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_in_state_late(serial_id);
	}
	
	public int staff_sign_off(Timestamp off_time,int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_off(off_time, serial_id);
	}
	
	public int staff_sign_off_state_success(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_off_state_success(serial_id);
	}
	
	public int staff_sign_off_state_early(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_off_state_early(serial_id);
	}
	
	
	public int staff_sign_off_state_insure(int staff_id)
	{
		return payrollAttendance_Mapper.staff_sign_off_state_insure(staff_id);
	}
	
	public int staff_sign_final_inCheck(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_final_inCheck(serial_id);
	}
	
	public int staff_sign_final_offCheck(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_final_offCheck(serial_id);
	}
	
	public int staff_sign_final_state(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_final_state(serial_id);
	}
	
	public int staff_sign_final_stateBad(int serial_id)
	{
		return payrollAttendance_Mapper.staff_sign_final_stateBad(serial_id);
	}
	
	public List<Staff_sign> checkMonthSign(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkMonthSign(staff_id,year,month);
	}
	
	public List<Map<String,Object>> checkSignSummary(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkSignSummary(staff_id, year, month);
	}
	
	public List<Map<String,Object>> checkSale_monthSalary(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkSale_monthSalary(staff_id, year, month);
	}
	
	public List<Map<String,Object>> checkSalary_Month(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkSalary_Month(staff_id, year, month);
	}
	
	public BigDecimal checkSaleCommission_Month(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkSaleCommission_Month(staff_id, year, month);
	}
	
	public BigDecimal checkRentCommission_Month(int staff_id,String year,String month)
	{
		return payrollAttendance_Mapper.checkRentCommission_Month(staff_id, year, month);
	}
	
	public int ask_leave(Ask_leave ask_leave)
	{
		return payrollAttendance_Mapper.ask_leave(ask_leave);
	}
	
	public int ask_out_office(Ask_out_office ask_out_office)
	{
		return payrollAttendance_Mapper.ask_out_office(ask_out_office);
	}
	
}
