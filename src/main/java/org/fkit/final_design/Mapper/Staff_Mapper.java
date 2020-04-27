package org.fkit.final_design.Mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.final_design.Bean.Client_lease;
import org.fkit.final_design.Bean.Client_sale;
import org.fkit.final_design.Bean.House_lease;
import org.fkit.final_design.Bean.House_sale;
import org.fkit.final_design.Bean.RentPreparation;
import org.fkit.final_design.Bean.SalePreparation;
import org.fkit.final_design.Bean.Client_want_buy;
import org.fkit.final_design.Bean.Client_want_rent;
import org.fkit.final_design.Bean.CompanyBranches;
import org.fkit.final_design.Bean.Deal_rentpreparation;
import org.fkit.final_design.Bean.Deal_salepreparation;
import org.fkit.final_design.Bean.Staff;

public interface Staff_Mapper 
{
	//登录
	@Select("select * from staff where staff_id=#{staff_id} and staff_password=#{staff_password}")
	public Staff StaffLogin(int staff_id,String staff_password);
	
	//待售房源信息
	@Select("select House_sid,House_sname,House_sestate,House_slocation,House_sprice,House_ssquare,House_sclientid,Complete_time from house_sale where House_sstate=0 and House_sclientid in(select Client_sid from client_sale where Client_sstaffid=#{client_sstaffid})")
	public List<House_sale> CheckHouesMsgsale(int client_sstaffid,House_sale house_sale);
	
	
	//待租房源信息
	@Select("select  House_lid,House_lname,House_lestate,House_llocation,House_lprice,House_lsquare,House_lclientid,Complete_time from house_lease where House_lstate=0 and House_lclientid in(select Client_lid from client_lease where Client_lstaffid=#{client_lstaffid})")
	public List<House_lease> CheckHouesMsglease(int client_lstaffid,House_lease house_lease);
	
	//已完成售房历史记录
	@Select("select  House_sid,House_sname,House_sestate,House_slocation,House_sprice,House_ssquare,House_sclientid,Complete_time,deal_time,client_wbid,client_wbname,client_wbsex,client_wbaddress,client_wbphone,client_wbexpect_place,client_wbexpect_price,client_wbexpect_square,client_wbstaffid from house_sale INNER JOIN client_want_buy ON house_sale.House_spurchaser_id=client_want_buy.Client_wbid where House_sstate=1 and House_sclientid in(select Client_sid from client_sale where Client_sstaffid=#{client_sstaffid})")
	public List<Map<String,Object>> CheckHouseMsgSuccessSale(int client_sstaffid);
	
	//已完成租赁历史记录
	@Select("select  House_lid,House_lname,House_lestate,House_llocation,House_lprice,House_lsquare,House_lclientid,Complete_time,deal_time,client_wrid,client_wrname,client_wrsex,client_wraddress,client_wrphone,client_wrexpect_place,client_wrexpect_price,client_wrexpect_square,client_wrstaffid from house_lease INNER JOIN client_want_rent ON house_lease.House_lpurchaser_id=client_want_rent.Client_wrid where House_lstate=1 and House_lclientid in(select Client_lid from client_lease where Client_lstaffid=#{client_lstaffid})")
	public List<Map<String,Object>> CheckHouseMsgSuccessLease(int client_lstaffid);
	
	//查看具体房源信息(售)
	@Select("select * from House_sale where House_sid=#{House_sid}")
	public House_sale HouseSale_information(int House_sid);
	
	//查看具体房源信息(租)
	@Select("select * from House_lease where House_lid=#{House_lid}")
	public House_lease HouseLease_information(int House_lid);
	
	//查看具体客户信息(售)
	@Select("select * from client_sale where Client_sid=#{Client_sid}")
	public Client_sale ClientSale_information(int Client_sid);
	
	//查看具体客户信息(租)
	@Select("select * from client_lease where Client_lid=#{Client_lid}")
	public Client_lease ClientLease_information(int Client_lid);
	
	//查看具体客户信息(寻房买)
	@Select("select * from client_want_buy where client_wbid=#{client_wbid}")
	public Client_want_buy ClientWantBuy_information(int client_wbid);
		
	//查看具体客户信息(寻房租)
	@Select("select * from client_want_rent where client_wrid=#{client_wrid}")
	public Client_want_rent ClientWantRent_information(int client_wrid);
	
	//电子客簿(已报备售房客户)
	@Select("select * from client_sale where Client_sstaffid=#{staff_id}")
	public List<Client_sale> Digital_HouseSale(int staff_id);
	
	//电子客簿(已报备出租房客户)
	@Select("select * from client_lease where Client_lstaffid=#{staff_id}")
	public List<Client_lease> Digital_HouseLease(int staff_id);
		
	//电子客簿(寻买房客户)
	@Select("select * from client_want_buy where client_wbstaffid=#{staff_id} and client_wbid not in(select House_spurchaser_id from house_sale where house_sstate=1)")
	public List<Client_want_buy> Digital_WantBuy(int staff_id);
	
	//电子客簿(寻房客户移至公海)
	@Update("update client_want_buy set client_wbstaffid=null where client_wbid=#{client_wbid}")
	public int dropClient_want_buy(int client_wbid);
		
	//电子客簿(寻租房客户)
	@Select("select * from client_want_rent where client_wrstaffid=#{staff_id} and client_wrid not in(select House_lpurchaser_id from house_lease where house_lstate=1)")
	public List<Client_want_rent> Digital_WantRent(int staff_id);
	
	//电子客簿(寻租客户移至公海)
	@Update("update client_want_rent set client_wrstaffid=null where client_wrid=#{client_wrid}")
	public int dropClient_want_rent(int client_wrid);
	
	//查找该员工所属上级
	@Select("select * from staff where staff_id in(select CB_manager_id from companybranches where CB_id in(select staff_branch_id from staff where staff_id=#{staff_id}))")
	public Staff findSuperior(int staff_id);
	
	//找下属
	@Select("select * from staff where staff_level=1 and staff_branch_id in(select staff_branch_id from staff where staff_id=#{staff_id})")
	public Staff findDD(int staff_id);
	
	//验证是否为主管
	@Select("select CB_manager_id from companybranches  where CB_manager_id=#{staff_id}")
	public CompanyBranches checkIfManager(int staff_id);
	
	//报备新房源消息
	@Insert("insert into salepreparation(staff_id,house_name,house_estate,house_location,house_price,house_square,house_complete_time,house_client_name,house_client_sex,house_client_address,house_client_phone,house_client_remark,state) values(#{staff_id},#{house_name},#{house_estate},#{house_location},#{house_price},#{house_square},#{house_complete_time},#{house_client_name},#{house_client_sex},#{house_client_address},#{house_client_phone},#{house_client_remark},0)")
	public int SalePreparationMethod(SalePreparation salePreparation);
	
	//报备新租源消息
	@Insert("insert into rentpreparation(staff_id,house_name,house_estate,house_location,house_price,house_square,house_complete_time,house_client_name,house_client_sex,house_client_address,house_client_phone,house_client_remark,state) values(#{staff_id},#{house_name},#{house_estate},#{house_location},#{house_price},#{house_square},#{house_complete_time},#{house_client_name},#{house_client_sex},#{house_client_address},#{house_client_phone},#{house_client_remark},0)")
	public int RentPreparationMethod(RentPreparation RentPreparation);
	
	//交易完成房屋报备
	@Insert("insert into deal_salepreparation(staff_id,house_id,deal_price,purchaser_name,purchaser_sex,purchaser_address,purchaser_phone,purchaser_remark,property_img,purchaserIDcard_img,agreement_img,state) values(#{staff_id},#{house_id},#{deal_price},#{purchaser_name},#{purchaser_sex},#{purchaser_address},#{purchaser_phone},#{purchaser_remark},#{property_img},#{purchaserIDcard_img},#{agreement_img},0)")
	public int Deal_toSalePreparation(Deal_salepreparation deal_salepreparation);
	
	//交易完成租赁报备
	@Insert("insert into deal_rentpreparation(staff_id,house_id,deal_price,purchaser_name,purchaser_sex,purchaser_address,purchaser_phone,purchaser_remark,tenancy,agreement_img,ammeter_record_img,furniture_record_img,landlordIDcard_copy_img,property_copy_img,purchaserIDcard_copy_img,state) values(#{staff_id},#{house_id},#{deal_price},#{purchaser_name},#{purchaser_sex},#{purchaser_address},#{purchaser_phone},#{purchaser_remark},#{tenancy},#{agreement_img},#{ammeter_record_img},#{furniture_record_img},#{landlordIDcard_copy_img},#{property_copy_img},#{purchaserIDcard_copy_img},0)")
	public int Deal_toRentPreparation(Deal_rentpreparation deal_rentpreparation);
	
	//查询新房源待审批
	@Select("select * from salepreparation where state=0 and staff_id=#{staff_id}")
	public List<Map<String,Object>> permitNewHouse(int staff_id);
	
	//查询房源已审批
	@Select("select * from salepreparation where state=1 and staff_id=#{staff_id}")
	public List<Map<String,Object>> permitNewHouseDone(int staff_id);
	
	//查询新租源待审批
	@Select("select * from rentpreparation where state=0 and staff_id=#{staff_id}")
	public List<Map<String,Object>> permitNewLease(int staff_id);
		
	//查询租源已审批
	@Select("select * from rentpreparation where state=1 and staff_id=#{staff_id}")
	public List<Map<String,Object>> permitNewLeaseDone(int staff_id);
	
	//淘客-曾想买房
	@Select("select * from client_want_buy where client_wbstaffid is NULL")
	public List<Client_want_buy> digOrphan_buy();
	
	//淘客-曾想租房
	@Select("select * from client_want_rent where client_wrstaffid is NULL")
	public List<Client_want_rent> digOrphan_rent();
	
	//淘客-加入个人电子客簿
	@Update("update client_want_buy set client_wbstaffid=#{staff_id} where client_wbid=#{client_wbid}")
	public int addOrphan_buy(int staff_id,int client_wbid);
	
	//淘客-加入个人电子客簿
	@Update("update client_want_rent set client_wrstaffid=#{staff_id} where client_wrid=#{client_wrid}")
	public int addOrphan_rent(int staff_id,int client_wrid);
}
