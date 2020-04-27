package org.fkit.final_design.Mapper;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
import org.springframework.web.multipart.MultipartFile;
public interface ManagerMapper 
{
	//检查是否为管理级
	@Select("select CB_id from companybranches  where CB_manager_id=#{staff_id}")
	public String checkIfManager(int staff_id);
	
	//查询待审批新报备房源
	@Select("select * from salepreparation where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> CheckToPermitSalePreparation(int staff_id); 
	
	//查询历史审批报备房源
	@Select("select * from salepreparation where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> CheckAllPermitSalePreparation(int staff_id); 
	
	//检查该房源是否已经在房源表
	@Select("select House_sid from house_sale where House_sname=#{House_sname} and House_sestate=#{House_sestate} and House_slocation=#{House_slocation} and House_sprice=#{House_sprice} and House_ssquare=#{House_ssquare} and Complete_time=#{Complete_time}")
	public String PermitSalePreparationP1Check(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time);
	
	//插入新待售房源数据(part1)
	@Insert("insert into house_sale(House_sname,House_sestate,House_slocation,House_sprice,House_ssquare,House_sstate,Complete_time) values(#{House_sname},#{House_sestate},#{House_slocation},#{House_sprice},#{House_ssquare},0,#{Complete_time})")
	public int PermitSalePreparationP1(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time);
	
	//检查该客户是否已经在客户表发布过房源，一个客户可以发布多个房源(part2Check)
	@Select("select Client_sid from client_sale where Client_sname=#{Client_sname} and Client_ssex=#{Client_ssex} and Client_saddress=#{Client_saddress} and Client_sphone=#{Client_sphone} and Client_sremark=#{Client_sremark}")
	public String PermitSalePreparationP2Check(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark);
	
	//插入新待售房源业主数据(part2)
	@Insert("insert into client_sale(Client_sname,Client_ssex,Client_saddress,Client_sphone,Client_sremark,Client_sstaffid) values(#{Client_sname},#{Client_ssex},#{Client_saddress},#{Client_sphone},#{Client_sremark},#{Client_sstaffid})")
	public int PermitSalePreparationP2(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark,int Client_sstaffid);
	
	//查询新插入待售房源ID插入业主表外键House_sclientid(part3)
	@Select("select Client_sid from client_sale where Client_sname=#{Client_sname} and Client_ssex=#{Client_ssex} and Client_saddress=#{Client_saddress} and Client_sphone=#{Client_sphone} and Client_sremark=#{Client_sremark} and Client_sstaffid=#{Client_sstaffid}")
	public int PermitSalePreparationP3(String Client_sname,String Client_ssex,String Client_saddress,String Client_sphone,String Client_sremark,int Client_sstaffid);
	
	//查询新插入待售房源ID(part4)
	@Select("select House_sid from house_sale where House_sname=#{House_sname} and House_sestate=#{House_sestate} and House_slocation=#{House_slocation} and House_sprice=#{House_sprice} and House_ssquare=#{House_ssquare} and House_sstate=0 and Complete_time=#{Complete_time}")
	public int PermitSalePreparationP4(String House_sname,String House_sestate,String House_slocation,int House_sprice,int House_ssquare,String Complete_time);
	
	//更新插入新待售房源业主ID(part5)
	@Update("update house_sale set House_sclientid=#{House_sclientid} where House_sid=#{House_sid}")
	public int PermitSalePreparationP5(int House_sclientid,int House_sid);
	
	//更新待审查表的审批状态从0更新为1(part6)
	@Update("update salepreparation set state=1,permit_time=#{permit_time} where id=#{salePreparation_id}")
	public int PermitSalePreparationP6(Timestamp permit_time,int salePreparation_id);
	
	//查询待审批新报备放租房源
	@Select("select * from rentpreparation where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> CheckToPermitRentPreparation(int staff_id); 
	
	//查询历史审批报备房源
	@Select("select * from rentpreparation where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> CheckAllPermitRentPreparation(int staff_id); 
	
	//检查该房源是否已经在租房源表(part1check)
	@Select("select House_lid from house_lease where House_lname=#{House_lname} and House_lestate=#{House_lestate} and House_llocation=#{House_llocation} and House_lprice=#{House_lprice} and House_lsquare=#{House_lsquare} and Complete_time=#{Complete_time}")
	public String PermitRentPreparationP1Check(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time);
	
	//插入新待租房源数据(part1)
	@Insert("insert into house_lease(House_lname,House_lestate,House_llocation,House_lprice,House_lsquare,House_lstate,Complete_time) values(#{House_lname},#{House_lestate},#{House_llocation},#{House_lprice},#{House_lsquare},0,#{Complete_time})")
	public int PermitRentPreparationP1(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time);
	
	//检查该客户是否已经在客户表发布过房源，一个客户可以发布多个房源(part2Check)
	@Select("select Client_lid from client_lease where Client_lname=#{Client_lname} and Client_lsex=#{Client_lsex} and Client_laddress=#{Client_laddress} and Client_lphone=#{Client_lphone} and Client_lremark=#{Client_lremark}")
	public String PermitRentPreparationP2Check(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark);
	
	//插入新待租房源业主数据(part2)
	@Insert("insert into client_lease(Client_lname,Client_lsex,Client_laddress,Client_lphone,Client_lremark,Client_lstaffid) values(#{Client_lname},#{Client_lsex},#{Client_laddress},#{Client_lphone},#{Client_lremark},#{Client_lstaffid})")
	public int PermitRentPreparationP2(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark,int Client_lstaffid);
	
	//查询新插入待租房源ID插入业主表外键House_sclientid(part3)
	@Select("select Client_lid from client_lease where Client_lname=#{Client_lname} and Client_lsex=#{Client_lsex} and Client_laddress=#{Client_laddress} and Client_lphone=#{Client_lphone} and Client_lremark=#{Client_lremark} and Client_lstaffid=#{Client_lstaffid}")
	public int PermitRentPreparationP3(String Client_lname,String Client_lsex,String Client_laddress,String Client_lphone,String Client_lremark,int Client_lstaffid);
	
	//查询新插入待租房源ID(part4)
	@Select("select House_lid from house_lease where House_lname=#{House_lname} and House_lestate=#{House_lestate} and House_llocation=#{House_llocation} and House_lprice=#{House_lprice} and House_lsquare=#{House_lsquare} and House_lstate=0 and Complete_time=#{Complete_time}")
	public int PermitRentPreparationP4(String House_lname,String House_lestate,String House_llocation,int House_lprice,int House_lsquare,String Complete_time);
	
	//更新插入新待售房源业主ID(part5)
	@Update("update house_lease set House_lclientid=#{House_lclientid} where House_lid=#{House_lid}")
	public int PermitRentPreparationP5(int House_lclientid,int House_lid);
	
	//更新待审查表的审批状态从0更新为1(part6)
	@Update("update rentpreparation set state=1,permit_time=#{permit_time} where id=#{rentPreparation_id}")
	public int PermitRentPreparationP6(Timestamp permit_time,int rentPreparation_id);
	
	//查询待审批房屋交易完成
	@Select("select * from deal_salepreparation where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> Check_DealSalePreparation(int staff_id); 
	
	//看大图property_img
	@Select("select property_img from deal_salepreparation where id=#{deal_salepreparation_id}")
	public String showImg_property(int deal_salepreparation_id);
	
	//看大图purchaserIDcard_img
	@Select("select purchaserIDcard_img from deal_salepreparation where id=#{deal_salepreparation_id}")
	public String showImg_purchaserIDcard(int deal_salepreparation_id);
	
	//看大图agreement_img
	@Select("select agreement_img from deal_salepreparation where id=#{deal_salepreparation_id}")
	public String showImg_agreement(int deal_salepreparation_id);
	
	//检查该房源是否已经交易
	@Select("select House_sstate from house_sale where House_sid=#{House_sid}")
	public int PermitDeal_SalePreparationP1Check(int House_sid);
	
	//检查该客户是否已经存在意向买房客户表
	@Select("select client_wbid from client_want_buy where client_wbname=#{client_wbname} and client_wbsex=#{client_wbsex} and client_wbaddress=#{client_wbaddress} and client_wbphone=#{client_wbphone} and (client_wb_remark=#{client_wb_remark} or client_wb_remark is null)")
	public String PermitDeal_SalePreparationP1_1Check(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark);
	
	//客户不存在，新建该客户插入意向买房客户表
	@Insert("insert into client_want_buy(client_wbname,client_wbsex,client_wbaddress,client_wbphone,client_wb_remark,client_wbstaffid) values(#{client_wbname},#{client_wbsex},#{client_wbaddress},#{client_wbphone},#{client_wb_remark},#{client_wbstaffid})")
	public int PermitDeal_SalePreparationP2(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark,int client_wbstaffid);
	
	//拿到刚才插入新客户的客户ID
	@Select("select client_wbid from client_want_buy where client_wbname=#{client_wbname} and client_wbsex=#{client_wbsex} and client_wbaddress=#{client_wbaddress} and client_wbphone=#{client_wbphone} and client_wb_remark=#{client_wb_remark}")
	public int PermitDeal_SalePreparationP3(String client_wbname,String client_wbsex,String client_wbaddress,String client_wbphone,String client_wb_remark);
	
	//更新house_sale表里的买家客户ID
	@Update("update house_sale set House_spurchaser_id=#{House_spurchaser_id},House_sstate=1,deal_time=#{deal_time} where House_sid=#{House_sid}")
	public int PermitDeal_SalePreparationP4(int House_spurchaser_id,int House_sid,Timestamp deal_time);
	
	//更新Deal_salepraparation待审批表里的状态
	@Update("update deal_salepreparation set state=1,permit_time=#{permit_time} where id=#{deal_salepreparation_id}")
	public int PermitDeal_SalePreparationP5(Timestamp permit_time,int deal_salepreparation_id);
	
	//查询已审批房屋交易完成
	@Select("select * from deal_salepreparation where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> Check_AlreadyDealSalePreparation(int staff_id); 
	
	//查询待审批租赁交易完成
	@Select("select * from deal_rentpreparation where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> Check_DealRentPreparation(int staff_id); 
	
	//查询已审批房屋交易完成
	@Select("select * from deal_rentpreparation where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Map<String,Object>> Check_AlreadyDealRentPreparation(int staff_id); 
	
	//看大图showImgRent_agreement_img
	@Select("select agreement_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_agreement(int deal_rentpreparation_id);
	
	//看大图ammeter_record_img
	@Select("select ammeter_record_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_ammeter_record(int deal_rentpreparation_id);
		
	//看大图furniture_record_img
	@Select("select furniture_record_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_furniture_record(int deal_rentpreparation_id);
		
	//看大图landlordIDcard_copy_img
	@Select("select landlordIDcard_copy_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_landlordIDcard_copy(int deal_rentpreparation_id);
		
	//看大图property_copy_img
	@Select("select property_copy_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_property_copy(int deal_rentpreparation_id);
	
	//看大图purchaserIDcard_copy_img
	@Select("select purchaserIDcard_copy_img from deal_rentpreparation where id=#{deal_rentpreparation_id}")
	public String showImgRent_purchaserIDcard_copy(int deal_rentpreparation_id);
	
	//检查该房源是否已经租赁
	@Select("select House_lstate from house_lease where House_lid=#{House_lid}")
	public int PermitDeal_RentPreparationP1Check(int House_lid);
		
	//检查该客户是否已经存在意向租房客户表
	@Select("select client_wrid from client_want_rent where client_wrname=#{client_wrname} and client_wrsex=#{client_wrsex} and client_wraddress=#{client_wraddress} and client_wrphone=#{client_wrphone} and (client_wr_remark=#{client_wr_remark} or client_wr_remark is null)")
	public String PermitDeal_RentPreparationP1_1Check(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark);
		
	//客户不存在，新建该客户插入意向租房客户表
	@Insert("insert into client_want_rent(client_wrname,client_wrsex,client_wraddress,client_wrphone,client_wr_remark,client_wrstaffid) values(#{client_wrname},#{client_wrsex},#{client_wraddress},#{client_wrphone},#{client_wr_remark},#{client_wrstaffid})")
	public int PermitDeal_RentPreparationP2(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark,int client_wrstaffid);
		
	//拿到刚才插入新客户的客户ID
	@Select("select client_wrid from client_want_rent where client_wrname=#{client_wrname} and client_wrsex=#{client_wrsex} and client_wraddress=#{client_wraddress} and client_wrphone=#{client_wrphone} and client_wr_remark=#{client_wr_remark}")
	public int PermitDeal_RentPreparationP3(String client_wrname,String client_wrsex,String client_wraddress,String client_wrphone,String client_wr_remark);
		
	//更新house_lease
	@Update("update house_lease set House_lprice=#{House_lprice},House_lpurchaser_id=#{House_lpurchaser_id},House_lstate=1,deal_time=#{deal_time} where House_lid=#{House_lid}")
	public int PermitDeal_RentPreparationP4(int House_lprice,int House_lpurchaser_id,int House_lid,Timestamp deal_time);
		
	//更新Deal_rentpraparation待审批表里的状态
	@Update("update deal_rentpreparation set state=1,permit_time=#{permit_time} where id=#{deal_rentpreparation_id}")
	public int PermitDeal_RentPreparationP5(Timestamp permit_time,int deal_rentpreparation_id);
	
	//手动执行更新house_lease状态
	@Update("update house_lease set House_lstate=0,House_lpurchaser_id=null where House_lid in(select house_id from deal_rentpreparation where tenancy<=NOW())")
	public int Update_house_lease_state();
	
	//手动执行更新签到表staff_sign状态
	@Insert("replace into staff_sign(in_time,off_time,final_state,staff_id) \r\n" + 
			"	select DATE_FORMAT(now(),'%Y-%m-%d'),DATE_FORMAT(now(),'%Y-%m-%d'),0,staff_id from staff where staff_id not IN(select staff_id from staff_sign where DATE_FORMAT(in_time,'%d') =DATE_FORMAT(now(),'%d') and DATE_FORMAT(off_time,'%d') =DATE_FORMAT(now(),'%d'))")
	public int insert_not_in_staff_sign();
	
	//手动执行更新staff_sign周六休假状态
	@Update("update staff_sign set final_state=3 where DATE_FORMAT(in_time,'%w') =6")
	public int Update_staff_sign_Saturday();
	
	//手动执行更新staff_sign周日休假状态
	@Update("update staff_sign set final_state=3 where DATE_FORMAT(in_time,'%w') =0")
	public int Update_staff_sign_Sunday();
	
	//查看待审批请假列表
	@Select("select * from ask_leave where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Ask_leave> permit_ask_leave(int staff_id);
	
	//看大图img_prove
	@Select("select img_prove from ask_leave where id=#{id}")
	public String show_img_prove(int id);
	
	//查差值天数
	@Select("select datediff(back_time, leave_time) AS 'day_num' from ask_leave where id=#{id}")
	public int datediff_ask_leave(int id);
	
	//请假时间插入
	@Insert("replace into staff_sign(in_time,in_state,special_state,final_state,staff_id) VALUES(#{in_time},1,2,0,#{staff_id})")
	public int permit_leaveP1(Timestamp in_time,int staff_id);
	
	//拿到+1天的timestamp
	@Select("select DATE_ADD(#{new_in_time},INTERVAL 1 DAY) from ask_leave where id=#{id}")
	public Timestamp getAdd_1Timestamp(Timestamp new_in_time,int id);
	
	//改审批条状态为1
	@Update("update ask_leave set state=1 where id=#{id}")
	public int permit_leaveP2(int id);
	
	//查看已经审批请假列表
	@Select("select * from ask_leave where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Ask_leave> permitDone_ask_leave(int staff_id);
	
	//在已审批请假页面内按工号查询特定记录结果集
	@Select("select * from ask_leave where staff_id=#{checkStaff_id}")
	public List<Ask_leave> checkPermitDone_ask_leaveByStaffId(int checkStaff_id);
	
	//新增员工信息
	@Insert("replace INTO staff(staff_username,staff_password,staff_job,staff_level,staff_branch_id,staff_img) VALUES(#{staff_username},123,#{staff_job},#{staff_level},#{staff_branch_id},#{staff_img})")
	@Options(useGeneratedKeys=true,keyProperty="staff_id",keyColumn="staff_id")
	public int addStaff(Staff staff);
	
	//新增员工信息P2
	@Update("update staff set staff_img=#{new_staff_img} where staff_id=#{staff_id}")
	public int addStaffP2(String new_staff_img,int staff_id);
	
	//所处分行下所有员工
	@Select("select * from staff where staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id})")
	public List<Staff> checkBranchAllStaff(int staff_id);
	
	//出勤详情
	@Select("select staff_id,in_time,in_state,off_time,off_state,special_state from staff_sign where staff_id=#{branch_staff_id} and DATE_FORMAT(in_time,'%Y') =#{year} and DATE_FORMAT(in_time,'%m') =#{month} and  DATE_FORMAT(in_time,'%d') =#{day}")
	public Staff_sign checkBranchStaffSign(int branch_staff_id,int year,int month,int day);
	
	//删除员工
	@Delete("delete from staff where staff_id=#{branch_staff_id}")
	public int delStaff(int branch_staff_id);
	
	//更改员工信息前查询员工
	@Select("select staff_id,staff_username,staff_level,staff_job,staff_branch_id,staff_img from staff where staff_id=#{staff_branch_id}")
	public Staff updateStaffP1(int staff_branch_id);
	
	//更改员工信息
	@Update("update staff set staff_username=#{staff_username},staff_level=#{staff_level},staff_job=#{staff_job},staff_branch_id=#{staff_branch_id},staff_img=#{staff_img} where staff_id=#{branch_staff_id}")
	public int updateStaff(String staff_username,int staff_level,String staff_job,int staff_branch_id,String staff_img,int branch_staff_id);
	
	//更改员工信息(不更改头像)
	@Update("update staff set staff_username=#{staff_username},staff_level=#{staff_level},staff_job=#{staff_job},staff_branch_id=#{staff_branch_id} where staff_id=#{branch_staff_id}")
	public int updateStaffnullImg(String staff_username,int staff_level,String staff_job,int staff_branch_id,int branch_staff_id);
	
	//查看待审批请假列表
	@Select("select * from ask_out_office where state=0 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Ask_out_office> permit_ask_out_office(int staff_id);
	
	//查外勤差值天数
	@Select("select datediff(back_time, leave_time) AS 'day_num' from ask_out_office where id=#{id}")
	public int datediff_ask_outside_office(int id);
		
	//请外勤时间插入
	@Insert("replace into staff_sign(in_time,in_state,off_time,off_state,special_state,final_state,staff_id) VALUES(#{in_time},1,#{off_time},1,1,1,#{staff_id})")
	public int permit_outside_officeP1(Timestamp in_time,Timestamp off_time,int staff_id);
		
	//拿到+1天的timestamp
	@Select("select DATE_ADD(#{new_in_time},INTERVAL 1 DAY) from ask_out_office where id=#{id}")
	public Timestamp getAdd_1outside_officeTimestamp(Timestamp new_in_time,int id);
		
	//改外勤审批条状态为1
	@Update("update ask_out_office set state=1 where id=#{id}")
	public int permit_outside_officeP2(int id);
		
	//查看已经审批请假列表
	@Select("select * from ask_out_office where state=1 and staff_id in(select staff_id from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public List<Ask_out_office> permitDone_ask_outside_office(int staff_id);
	
	//看大图img_AskOutOffice_prove
	@Select("select img_prove from ask_out_office where id=#{id}")
	public String show_img_AskOutOffice_prove(int id);
	
	//在已审批外勤页面内按工号查询特定记录结果集
	@Select("select * from ask_out_office where staff_id=#{checkStaff_id}")
	public List<Ask_out_office> checkPermitDone_ask_outByStaffId(int checkStaff_id);
	
	//发布新公司资讯
	@Insert("replace into company_news(Company_news_title,Company_news_content,Company_news_staffid,publish_time,Company_news_img) values(#{Company_news_title},#{Company_news_content},#{Company_news_staffid},#{publish_time},#{Company_news_img})")
	@Options(useGeneratedKeys=true,keyProperty="Company_news_id",keyColumn="Company_news_id")
	public int CompanyNewsAdd(Company_news company_news);
	
	//发布新公司资讯P2
	@Update("update company_news set Company_news_img=#{Company_news_img} where Company_news_id=#{Company_news_id}")
	public int CompanyNewsAddP2(String Company_news_img,int Company_news_id);
	
	//发布新市场资讯
	@Insert("replace into markets_news(Markets_news_title,Markets_news_content,Markets_news_staffid,publish_time,Markets_news_img) values(#{Markets_news_title},#{Markets_news_content},#{Markets_news_staffid},#{publish_time},#{Markets_news_img})")
	@Options(useGeneratedKeys=true,keyProperty="Markets_news_id",keyColumn="Markets_news_id")
	public int MarketsNewsAdd(Markets_news markets_news);
	
	//发布新市场资讯P2
	@Update("update markets_news set Markets_news_img=#{Markets_news_img} where Markets_news_id=#{Markets_news_id}")
	public int MarketsNewsAddP2(String Markets_news_img,int Markets_news_id);
	
}
 