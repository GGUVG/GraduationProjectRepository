package org.fkit.final_design.Mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.final_design.Bean.Ask_leave;
import org.fkit.final_design.Bean.Ask_out_office;
import org.fkit.final_design.Bean.Staff_sign;

public interface PayrollAttendance_Mapper 
{
	//签到
	@Insert("insert into staff_sign(staff_id,in_time) values(#{staff_id},#{in_time})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public int staff_sign_in(Staff_sign staff_sign);
	
	//避免服务器崩溃重启session失去等原因,存入当日签到流水ID保险
	@Update("update staff set today_serial_id=#{serial_id} where staff_id=#{staff_id}")
	public int staff_sign_in_state_insure(int serial_id,int staff_id);
	
	
	//签到正常
	@Update("update staff_sign set in_state=1 where id=#{serial_id}")
	public int staff_sign_in_state_success(int serial_id);
	
	//签到迟到
	@Update("update staff_sign set in_state=0 where id=#{serial_id}")
	public int staff_sign_in_state_late(int serial_id);
	
	//签退
	@Update("update staff_sign set off_time=#{off_time} where id=#{serial_id}")
	public int staff_sign_off(Timestamp off_time,int serial_id);
	
	//签退正常
	@Update("update staff_sign set off_state=1 where id=#{serial_id}")
	public int staff_sign_off_state_success(int serial_id);
		
	//签退早退
	@Update("update staff_sign set off_state=0 where id=#{serial_id}")
	public int staff_sign_off_state_early(int serial_id);
	
	//清除当日签到流水保险ID
	@Update("update staff set today_serial_id=null where staff_id=#{staff_id}")
	public int staff_sign_off_state_insure(int staff_id);
	
	//最终判断检查签到
	@Select("select in_state from staff_sign where id=#{serial_id}")
	public int staff_sign_final_inCheck(int serial_id);
	
	//最终判断检查签到
	@Select("select off_state from staff_sign where id=#{serial_id}")
	public int staff_sign_final_offCheck(int serial_id);
	
	//最终当日考勤状态正常
	@Update("update staff_sign set final_state=1 where id=#{serial_id}")
	public int staff_sign_final_state(int serial_id);
	
	//最终当日考勤状态迟到或早退或旷班
	@Update("update staff_sign set final_state=0 where id=#{serial_id}")
	public int staff_sign_final_stateBad(int serial_id);
	
	//查询某年月考勤详细
	@Select("SELECT * FROM staff_sign WHERE staff_id=1 and DATE_FORMAT(in_time,'%Y') =#{year} and DATE_FORMAT(in_time,'%m') =#{month}")
	public List<Staff_sign> checkMonthSign(int staff_id,String year,String month);
	
	//查询某年月考勤汇总
	@Select("SELECT staff_id,SUM(final_state=0) AS 'AbsenceFromDuty',SUM(final_state=1) AS 'Normal',SUM(special_state=2) AS 'Leave',SUM(special_state=3) AS 'Vacation',SUM(special_state=4) AS 'Sick' FROM staff_sign where staff_id=#{staff_id} and DATE_FORMAT(in_time,'%Y') =#{year} and DATE_FORMAT(in_time,'%m') =#{month}")
	public List<Map<String,Object>> checkSignSummary(int staff_id,String year,String month);
	
	//查询某年月卖房交易成功宗数
	@Select("select  House_sid,House_sestate,House_sprice,House_ssquare,House_sclientid,deal_time,House_spurchaser_id,estate_commission,estate_type from house_sale INNER JOIN estate ON house_sale.House_sestate=estate.estate_name where House_sstate=1 and House_sclientid in(select Client_sid from client_sale where Client_sstaffid=#{staff_id}) and DATE_FORMAT(deal_time,'%Y') =#{year} and DATE_FORMAT(deal_time,'%m') =#{month}")
	public List<Map<String,Object>> checkSale_monthSalary(int staff_id,String year,String month);
	
	//查工资-年-月,不包含佣金
	@Select("select staff.staff_id,IFNULL(salary_job,0) as salary_job,IFNULL(salary_base,0)as salary_base,IFNULL(salary_bonus,0)as salary_bonus,IFNULL(salary_leave,0)as salary_leave,IFNULL(SUM(final_state=0) ,0)AS 'AbsenceFromDuty',IFNULL(SUM(final_state=1),0) AS 'Normal',IFNULL(SUM(special_state=2),0) AS 'Leave',IFNULL(SUM(special_state=3),0) AS 'Vacation',IFNULL(SUM(special_state=4),0) AS 'Sick',IFNULL(CONVERT(salary_base+(if(SUM(final_state=0)>=1,0,salary_bonus))-SUM(final_state=0)*salary_leave,DECIMAL(12,2)),0) AS 'total' from staff join salary_job on staff.staff_job=salary_job.salary_job join staff_sign on staff.staff_id=staff_sign.staff_id where staff.staff_id=#{staff_id} and DATE_FORMAT(staff_sign.in_time,'%Y') =#{year} and DATE_FORMAT(staff_sign.in_time,'%m') =#{month}")
	public List<Map<String,Object>> checkSalary_Month(int staff_id,String year,String month);
	
	//查该月所得全部佣金-卖房
	@Select("select IFNULL(SUM(House_sprice*House_ssquare*estate_commission) ,0)AS 'earnSale' from house_sale INNER JOIN estate ON house_sale.House_sestate=estate.estate_name where House_sstate=1 and House_sclientid in(select Client_sid from client_sale where Client_sstaffid=#{staff_id}) and DATE_FORMAT(deal_time,'%Y') =#{year} and DATE_FORMAT(deal_time,'%m') =#{month}")
	public BigDecimal checkSaleCommission_Month(int staff_id,String year,String month);
	
	//查该月所得全部佣金-租赁
	@Select("select IFNULL(SUM(House_lprice*estate_rent_commission),0) AS 'earnRent' from house_lease INNER JOIN estate ON house_lease.House_lestate=estate.estate_name where House_lstate=1 and House_lclientid in(select Client_lid from client_lease where Client_lstaffid=#{staff_id}) and DATE_FORMAT(deal_time,'%Y') =#{year} and DATE_FORMAT(deal_time,'%m') =#{month}")
	public BigDecimal checkRentCommission_Month(int staff_id,String year,String month);
	
	//请假
	@Insert("insert into ask_leave(staff_id,leave_time,back_time,reason,img_prove,state) VALUES(#{staff_id},#{leave_time},#{back_time},#{reason},#{img_prove},0)")
	public int ask_leave(Ask_leave ask_leave);
	
	//请外勤
	@Insert("insert into ask_out_office(staff_id,leave_time,back_time,remark,img_prove,state) VALUES(#{staff_id},#{leave_time},#{back_time},#{remark},#{img_prove},0)")
	public int ask_out_office(Ask_out_office ask_out_office);
	
}
