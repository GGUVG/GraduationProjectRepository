package org.fkit.final_design.Controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fkit.final_design.Bean.Client_lease;
import org.fkit.final_design.Bean.Client_sale;
import org.fkit.final_design.Bean.Client_want_buy;
import org.fkit.final_design.Bean.Client_want_rent;
import org.fkit.final_design.Bean.Company_news;
import org.fkit.final_design.Bean.Deal_rentpreparation;
import org.fkit.final_design.Bean.Deal_salepreparation;
import org.fkit.final_design.Bean.House_lease;
import org.fkit.final_design.Bean.House_sale;
import org.fkit.final_design.Bean.RentPreparation;
import org.fkit.final_design.Bean.SalePreparation;
import org.fkit.final_design.Service.Staff_Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.UUID;

@Controller
public class PlatformController {
	@Resource
	public Staff_Service staffService;

	@RequestMapping(value = "/toMainPlatform")
	public String myself() {
		return "MainPlatform";
	}

	@RequestMapping("/CheckHouesMsgsale")
	public String CheckHouesMsgsale(Integer client_sstaffid, House_sale house_sale, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) 
	{
		PageHelper.startPage(start,size);
		List<House_sale> listHouse_sale = (List<House_sale>) staffService.CheckHouesMsgsale(client_sstaffid,house_sale);
		PageInfo<House_sale> listHouse_salePage =new PageInfo<>(listHouse_sale);
		model.addAttribute("listHouse_sale", listHouse_sale);
		model.addAttribute("listHouse_salePage", listHouse_salePage);
		return "platform/CheckHouesMsgsale";
	}

	@RequestMapping("/CheckHouesMsglease")
	public String CheckHouesMsglease(int client_lstaffid, House_lease house_lease, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<House_lease> listHouse_lease = (List<House_lease>) staffService.CheckHouesMsglease(client_lstaffid,house_lease);
		PageInfo<House_lease> listHouse_leasePage =new PageInfo<>(listHouse_lease);
		model.addAttribute("listHouse_lease", listHouse_lease);
		model.addAttribute("listHouse_leasePage", listHouse_leasePage);
		return "platform/CheckHouesMsglease";
	}

	@RequestMapping("/CheckHouseMsgSuccessSale")
	public String CheckHouseMsgSuccessSale(int client_sstaffid, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) 
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> listHouseSuccessSale = staffService.CheckHouseMsgSuccessSale(client_sstaffid);
		PageInfo<Map<String, Object>> listHouse_SuccessSalePage =new PageInfo<>(listHouseSuccessSale);
		model.addAttribute("listHouseSuccessSale", listHouseSuccessSale);
		//System.out.println("...?"+listHouse_SuccessSalePage);
		model.addAttribute("listHouse_SuccessSalePage", listHouse_SuccessSalePage);
		return "platform/CheckHouseMsgSuccessSale";
	}

	@RequestMapping("/CheckHouseMsgSuccessLease")
	public String CheckHouseMsgSuccessLease(int client_lstaffid, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> listHouseSuccessLease = staffService.CheckHouseMsgSuccessLease(client_lstaffid);
		PageInfo<Map<String, Object>> listHouse_SuccessLeasePage =new PageInfo<>(listHouseSuccessLease);
		model.addAttribute("listHouseSuccessLease", listHouseSuccessLease);
		model.addAttribute("listHouse_SuccessLeasePage", listHouse_SuccessLeasePage);
		return "platform/CheckHouseMsgSuccessLease";
	}

	@RequestMapping("/HouseSale_information")
	public String HouseSale_information(int House_sid, Model model, HttpSession session) {
		House_sale house_sale = staffService.HouseSale_information(House_sid);
		System.out.println(house_sale);// check
		model.addAttribute("house_sale", house_sale);
		return "platform/HouseSale_information";
	}

	@RequestMapping("/HouseLease_information")
	public String HouseLease_information(int House_lid, Model model, HttpSession session) {
		House_lease house_lease = staffService.HouseLease_information(House_lid);
		System.out.println(house_lease);// check
		model.addAttribute("house_lease", house_lease);
		return "platform/HouseLease_information";
	}

	@RequestMapping("/ClientSale_information")
	public String ClientSale_information(int Client_sid, Model model, HttpSession session) {
		Client_sale client_sale = staffService.ClientSale_information(Client_sid);
		System.out.println(client_sale);// check
		model.addAttribute("client_sale", client_sale);
		return "platform/ClientSale_information";
	}

	@RequestMapping("/ClientLease_information")
	public String ClientLease_information(int Client_lid, Model model, HttpSession session) {
		Client_lease client_lease = staffService.ClientLease_information(Client_lid);
		System.out.println(client_lease);// check
		model.addAttribute("client_lease", client_lease);
		return "platform/ClientLease_information";
	}

	@RequestMapping("/ClientWantBuy_information")
	public String ClientWantBuy_information(int client_wbid, Model model, HttpSession session) {
		Client_want_buy client_want_buy = staffService.ClientWantBuy_information(client_wbid);
		System.out.println(client_want_buy);// check
		model.addAttribute("client_want_buy", client_want_buy);
		return "platform/ClientWantBuy_information";
	}

	@RequestMapping("/ClientWantRent_information")
	public String ClientWantRent_information(int client_wrid, Model model, HttpSession session) {
		Client_want_rent client_want_rent = staffService.ClientWantRent_information(client_wrid);
		System.out.println(client_want_rent);// check
		model.addAttribute("client_want_rent", client_want_rent);
		return "platform/ClientWantRent_information";
	}

	@RequestMapping("/SalePreparationMethod")
	public String SalePreparationMethod(SalePreparation salePreparation, Model model, HttpSession session) {
		int rows = staffService.SalePreparationMethod(salePreparation);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}

	@RequestMapping("/RentPreparationMethod")
	public String RentPreparationMethod(RentPreparation rentPreparation, Model model, HttpSession session) {
		int rows = staffService.RentPreparationMethod(rentPreparation);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}

	@RequestMapping("/permitNewHouse")
	public String permitNewHouse(int staff_id, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) 
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> list_permitNewHouse = staffService.permitNewHouse(staff_id);
		PageInfo<Map<String, Object>> list_permitNewHousePage =new PageInfo<>(list_permitNewHouse);
		model.addAttribute("list_permitNewHouse", list_permitNewHouse);
		model.addAttribute("list_permitNewHousePage", list_permitNewHousePage);
		return "platform/permitNewHouse";
	}

	@RequestMapping("/permitNewHouseDone")
	public String permitNewHouseDone(int staff_id, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) 
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> list_permitNewHouseDone = staffService.permitNewHouseDone(staff_id);
		PageInfo<Map<String, Object>> list_permitNewHouseDonePage =new PageInfo<>(list_permitNewHouseDone);
		model.addAttribute("list_permitNewHouseDone", list_permitNewHouseDone);
		model.addAttribute("list_permitNewHouseDonePage", list_permitNewHouseDonePage);
		return "platform/permitNewHouseDone";
	}

	@RequestMapping("/permitNewLease")
	public String permitNewLease(int staff_id, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size) 
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> list_permitNewLease = staffService.permitNewLease(staff_id);
		PageInfo<Map<String, Object>> list_permitNewLeasePage =new PageInfo<>(list_permitNewLease);
		model.addAttribute("list_permitNewLease", list_permitNewLease);
		model.addAttribute("list_permitNewLeasePage", list_permitNewLeasePage);
		return "platform/permitNewLease";
	}

	@RequestMapping("/permitNewLeaseDone")
	public String permitNewLeaseDone(int staff_id, Model model, HttpSession session,@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "10") int size)
	{
		PageHelper.startPage(start,size);
		List<Map<String, Object>> list_permitNewLeaseDone = staffService.permitNewLeaseDone(staff_id);
		PageInfo<Map<String, Object>> list_permitNewLeaseDonePage =new PageInfo<>(list_permitNewLeaseDone);
		model.addAttribute("list_permitNewLeaseDone", list_permitNewLeaseDone);
		model.addAttribute("list_permitNewLeaseDonePage", list_permitNewLeaseDonePage);
		return "platform/permitNewLeaseDone";
	}

	@RequestMapping(value = "/Deal_toSalePreparation", method = RequestMethod.POST)
	public String Deal_toSalePreparation(@RequestParam("property_img1")MultipartFile property_img1, @RequestParam("purchaserIDcard_img1")MultipartFile purchaserIDcard_img1,
			@RequestParam("agreement_img1")MultipartFile agreement_img1, HttpServletRequest request, Deal_salepreparation deal_salepreparation,
			Model model, HttpSession session) throws IOException {
		/*
		*property_img之所以改名成property_img1,如果同名于数据库，则会直接封装在deal_salepreparation这个
		*实体化类里,但图片是file类型并不是String,因此需要重命名单独拎出来用实体化类的set/get方法重新赋值
		*/
		if (!property_img1.isEmpty()) {
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_SalePreparation\\property";
			String filename = property_img1.getOriginalFilename();
			//判断文件名是否带路径，带路径则去除，不同浏览器不同
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_salepreparation.setProperty_img(filename);
			//System.out.println("new filename="+filename);
			String realpath = path + filename;//上传的路径+上传文件的名字组合成新的路径
			//System.out.println("realpath="+realpath);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			property_img1.transferTo(new File(path + File.separator + filename));
		}

		if (!purchaserIDcard_img1.isEmpty()) {
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_SalePreparation\\purchaserIDcard";
			String filename = purchaserIDcard_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_salepreparation.setPurchaserIDcard_img(filename);
			String realpath = path + filename;
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			purchaserIDcard_img1.transferTo(new File(path + File.separator + filename));
		}

		if (!agreement_img1.isEmpty()) {
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_SalePreparation\\agreement";
			String filename = agreement_img1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_salepreparation.setAgreement_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			agreement_img1.transferTo(new File(path + File.separator + filename));
		}
		int rows = staffService.Deal_toSalePreparation(deal_salepreparation);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}
	
	@RequestMapping(value = "/Deal_toRentPreparation",method = RequestMethod.POST)
	public String Deal_toRentPreparation(@RequestParam("agreement_img1")MultipartFile agreement1, @RequestParam("ammeter_record_img1")MultipartFile ammeter_record1,
			@RequestParam("furniture_record_img1")MultipartFile furniture_record1, @RequestParam("landlordIDcard_copy_img1")MultipartFile landlordIDcard_copy1,
			@RequestParam("property_copy_img1")MultipartFile property_copy1, @RequestParam("purchaserIDcard_copy_img1")MultipartFile purchaserIDcard_copy1,HttpServletRequest request, Deal_rentpreparation deal_rentpreparation,
			Model model, HttpSession session) throws IOException 
	{
		if (!agreement1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\agreement";
			String filename = agreement1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setAgreement_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			agreement1.transferTo(new File(path + File.separator + filename));
		}
		
		if (!ammeter_record1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\ammeter_record";
			String filename = ammeter_record1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setAmmeter_record_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			ammeter_record1.transferTo(new File(path + File.separator + filename));
		}
		if (!furniture_record1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\furniture_record";
			String filename = furniture_record1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setFurniture_record_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			furniture_record1.transferTo(new File(path + File.separator + filename));
		}
		
		if (!landlordIDcard_copy1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\landlordIDcard_copy";
			String filename = landlordIDcard_copy1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setLandlordIDcard_copy_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			landlordIDcard_copy1.transferTo(new File(path + File.separator + filename));
		}
		
		if (!property_copy1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\property_copy";
			String filename = property_copy1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setProperty_copy_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			property_copy1.transferTo(new File(path + File.separator + filename));
		}
		
		if (!purchaserIDcard_copy1.isEmpty()) 
		{
			String path = "E:\\Work\\SoftWare\\Eclipse\\eclipse\\WorkSpace\\final_design\\src\\main\\resources\\static\\img\\deal_RentPreparation\\purchaserIDcard_copy";
			String filename = purchaserIDcard_copy1.getOriginalFilename();
			int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep : unixSep);
            if (pos != -1)  {
                filename = filename.substring(pos + 1);
            }
			deal_rentpreparation.setPurchaserIDcard_copy_img(filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			purchaserIDcard_copy1.transferTo(new File(path + File.separator + filename));
		}
		
		int rows = staffService.Deal_toRentPreparation(deal_rentpreparation);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}

	@RequestMapping("/Digital_HouseSale")
	public String Digital_HouseSale(int staff_id, Client_sale client_sale, Model model, HttpSession session) {
		List<Client_sale> list_client_sale = (List<Client_sale>) staffService.Digital_HouseSale(staff_id);
		model.addAttribute("list_client_sale", list_client_sale);
		return "platform/Digital_HouseSale";
	}

	@RequestMapping("/Digital_HouseLease")
	public String Digital_HouseLease(int staff_id, Client_lease client_lease, Model model, HttpSession session) {
		List<Client_lease> list_client_lease = (List<Client_lease>) staffService.Digital_HouseLease(staff_id);
		model.addAttribute("list_client_lease", list_client_lease);
		return "platform/Digital_HouseLease";
	}

	@RequestMapping("/Digital_WantBuy")
	public String Digital_WantBuy(int staff_id, Client_want_buy client_want_buy, Model model, HttpSession session) {
		List<Client_want_buy> list_client_want_buy = (List<Client_want_buy>) staffService.Digital_WantBuy(staff_id);
		model.addAttribute("list_client_want_buy", list_client_want_buy);
		return "platform/Digital_WantBuy";
	}

	@RequestMapping("/dropClient_want_buy")
	public String dropClient_want_buy(int client_wbid, Model model, HttpSession session) {
		int rows = staffService.dropClient_want_buy(client_wbid);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}

	@RequestMapping("/Digital_WantRent")
	public String Digital_WantRent(int staff_id, Client_want_rent client_want_rent, Model model, HttpSession session) {
		List<Client_want_rent> list_client_want_rent = (List<Client_want_rent>) staffService.Digital_WantRent(staff_id);
		model.addAttribute("list_client_want_rent", list_client_want_rent);
		return "platform/Digital_WantRent";
	}

	@RequestMapping("/dropClient_want_rent")
	public String dropClient_want_rent(int client_wrid, Model model, HttpSession session) {
		int rows = staffService.dropClient_want_rent(client_wrid);
		if (rows > 0) {
			return "MainPlatform";
		} else
			return "fail";
	}

	@RequestMapping("/digOrphan_buy")
	public String digOrphan_buy(Client_want_buy client_want_buy, Model model, HttpSession session) {
		List<Client_want_buy> list_client_want_buy = (List<Client_want_buy>) staffService.digOrphan_buy();
		model.addAttribute("list_client_want_buy", list_client_want_buy);
		return "platform/digOrphan_buy";
	}

	@RequestMapping("/digOrphan_rent")
	public String digOrphan_rent(Client_want_rent client_want_rent, Model model, HttpSession session) {
		List<Client_want_rent> list_client_want_rent = (List<Client_want_rent>) staffService.digOrphan_rent();
		model.addAttribute("list_client_want_rent", list_client_want_rent);
		return "platform/digOrphan_rent";
	}
	
	@RequestMapping("/addOrphan_buy")
	public String addOrphan_buy(Model model,HttpSession session,int staff_id,int client_wbid)
	{
		int row=staffService.addOrphan_buy(staff_id, client_wbid);
		if(row>=1)
		{
			return "MainPlatform";
		}
		else
		{
			return "fail";
		}
		
	}
	
	@RequestMapping("/addOrphan_rent")
	public String addOrphan_rent(Model model,HttpSession session,int staff_id,int client_wrid)
	{
		int row=staffService.addOrphan_rent(staff_id, client_wrid);
		if(row>=1)
		{
			return "MainPlatform";
		}
		else
		{
			return "fail";
		}
		
	}
	
	@RequestMapping(value = "/toSchedule")
	public String toSchedule() 
	{
		return "platform/Schedule";
	}
	
}
