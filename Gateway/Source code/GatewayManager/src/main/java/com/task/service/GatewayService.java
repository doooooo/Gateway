package com.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.Gateway;
import com.task.model.Peripheral;
import com.task.repository.GatewayRepository;
import com.task.repository.PeripheralRepository;

@Service
public class GatewayService {

	@Autowired
	GatewayRepository grepository;
	
	@Autowired
	PeripheralRepository prepository;
	
	public List<Gateway> getAllGateways(){
		ArrayList<Gateway> gateways=new ArrayList<Gateway>();
		
		grepository.findAll().forEach(Gateway -> gateways.add(Gateway));
		
		gateways.size();
		
		return gateways;
	}
	
	//https://stackoverflow.com/questions/44566760/spring-boot-using-foreign-key-in-crudrepository
	//public List<Peripheral> findPeriphralsByGateway(){
		//prepository.find
	//}
	
	public Gateway findGatewayById(String id) {
		
		Gateway Gateway=grepository.findById(id).get();
		return Gateway;
		
	}
	
	public void saveGateway(Gateway gateway) throws Exception {
		//ipv4 validation
		String ip=gateway.getIpv4();
		if(ip!=null) {
			if(!isValidIP(ip)) {
				throw new Exception("Invalid IPV4 format");
			}
		}
		grepository.save(gateway);
	}
	
	public void savePeripheral(Peripheral peripheral) throws Exception {
		String gid=peripheral.getGateway().getSerial();
		Gateway gateway=this.findGatewayById(gid);
		if(gateway!=null && gateway.getPeripherals()!=null) {
			if(gateway.getPeripherals().size()>9)
				throw new Exception("No. of peripherals should not exceed 10");
		}
		prepository.save(peripheral);
	}
	
	public void deleteGateway(String id) {
		grepository.deleteById(id);
	}
	
	private boolean isValidIP(String ip) {
	    String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

	    return ip.matches(PATTERN);
	}
	
}
