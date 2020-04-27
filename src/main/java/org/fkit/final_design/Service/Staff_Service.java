package org.fkit.final_design.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.fkit.final_design.Bean.Client_lease;
import org.fkit.final_design.Bean.Client_sale;
import org.fkit.final_design.Bean.Client_want_buy;
import org.fkit.final_design.Bean.Client_want_rent;
import org.fkit.final_design.Bean.Deal_rentpreparation;
import org.fkit.final_design.Bean.Deal_salepreparation;
import org.fkit.final_design.Bean.House_lease;
import org.fkit.final_design.Bean.House_sale;
import org.fkit.final_design.Bean.RentPreparation;
import org.fkit.final_design.Bean.Staff;
import org.fkit.final_design.Bean.SalePreparation;
import org.fkit.final_design.Mapper.Staff_Mapper;
import org.springframework.stereotype.Service;

@Service
public class Staff_Service {
	@Resource
	public Staff_Mapper staffMapper;
	
	public Staff staffLogin(int staff_id,String staff_password)
	{
		return staffMapper.StaffLogin(staff_id,staff_password);
	}
	
	public List<House_sale> CheckHouesMsgsale(int client_sstaffid,House_sale house_sale)
	{
		return staffMapper.CheckHouesMsgsale(client_sstaffid,house_sale);
	}
	
	public List<House_lease> CheckHouesMsglease(int client_lstaffid,House_lease house_lease)
	{
		return staffMapper.CheckHouesMsglease(client_lstaffid,house_lease);
	}
	
	public List<Map<String,Object>> CheckHouseMsgSuccessSale(int client_sstaffid)
	{	
		return staffMapper.CheckHouseMsgSuccessSale(client_sstaffid);
	}
	
	public List<Map<String,Object>> CheckHouseMsgSuccessLease(int client_lstaffid)
	{
		return staffMapper.CheckHouseMsgSuccessLease(client_lstaffid);
	}
	
	public House_sale HouseSale_information(int House_sid)
	{
		return staffMapper.HouseSale_information(House_sid);
	}
	
	public House_lease HouseLease_information(int House_lid)
	{
		return staffMapper.HouseLease_information(House_lid);
	}
	
	public Client_sale ClientSale_information(int Client_sid)
	{
		return staffMapper.ClientSale_information(Client_sid);
	}
	
	public Client_lease ClientLease_information(int Client_lid)
	{
		return staffMapper.ClientLease_information(Client_lid);
	}
	
	public Client_want_buy ClientWantBuy_information(int client_wbid)
	{
		return staffMapper.ClientWantBuy_information(client_wbid);
	}
	
	public Client_want_rent ClientWantRent_information(int client_wrid)
	{
		return staffMapper.ClientWantRent_information(client_wrid);
	}
	
	public int SalePreparationMethod(SalePreparation salePreparation)
	{
		return staffMapper.SalePreparationMethod(salePreparation);
	}
	
	public int RentPreparationMethod(RentPreparation RentPreparation)
	{
		return staffMapper.RentPreparationMethod(RentPreparation);
	}
	
	public List<Map<String,Object>> permitNewHouse(int staff_id)
	{
		return staffMapper.permitNewHouse(staff_id);
	}
	
	public List<Map<String,Object>> permitNewHouseDone(int staff_id)
	{
		return staffMapper.permitNewHouseDone(staff_id);
	}
	
	public List<Map<String,Object>> permitNewLease(int staff_id)
	{
		return staffMapper.permitNewLease(staff_id);
	}
	
	public List<Map<String,Object>> permitNewLeaseDone(int staff_id)
	{
		return staffMapper.permitNewLeaseDone(staff_id);
	}
	
	public int Deal_toSalePreparation(Deal_salepreparation deal_salepreparation)
	{
		return staffMapper.Deal_toSalePreparation(deal_salepreparation);
	}
	
	public int Deal_toRentPreparation(Deal_rentpreparation deal_rentpreparation)
	{
		return staffMapper.Deal_toRentPreparation(deal_rentpreparation);
	}
	
	public List<Client_sale> Digital_HouseSale(int staff_id)
	{
		return staffMapper.Digital_HouseSale(staff_id);
	}
	
	
	public List<Client_lease> Digital_HouseLease(int staff_id)
	{
		return staffMapper.Digital_HouseLease(staff_id);
	}
	
	public List<Client_want_buy> Digital_WantBuy(int staff_id)
	{
		return staffMapper.Digital_WantBuy(staff_id);
	}
	
	public int dropClient_want_buy(int client_wbid)
	{
		return staffMapper.dropClient_want_buy(client_wbid);
	}
	
	public List<Client_want_rent> Digital_WantRent(int staff_id)
	{
		return staffMapper.Digital_WantRent(staff_id);
	}
	
	public int dropClient_want_rent(int client_wrid)
	{
		return staffMapper.dropClient_want_rent(client_wrid);
	}
	
	public List<Client_want_buy> digOrphan_buy()
	{
		return staffMapper.digOrphan_buy();
	}
	
	public List<Client_want_rent> digOrphan_rent()
	{
		return staffMapper.digOrphan_rent();
	}
	
	public int addOrphan_buy(int staff_id,int client_wbid)
	{
		return staffMapper.addOrphan_buy(staff_id, client_wbid);
	}

	public int addOrphan_rent(int staff_id,int client_wrid)
	{
		return staffMapper.addOrphan_rent(staff_id, client_wrid);
	}
	
}
