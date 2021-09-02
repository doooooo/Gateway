package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Gateway;
import com.task.model.Peripheral;
import com.task.service.GatewayService;

@RestController
public class GatewayController {
	
	@Autowired
	GatewayService service;
	
	@GetMapping("/gateway/{id}")
	public Gateway getGatewayById(@PathVariable("id") String id) {
		return service.findGatewayById(id);
	}
	
	@GetMapping("/gateways")
	public List<Gateway> getAllGateways(){
		return service.getAllGateways();
	}
	
	@PostMapping("/gateway")  
	public void saveGateway(@RequestBody Gateway gateway) throws Exception {
		service.saveGateway(gateway);
	}
	
	@PostMapping("/gateway/peripheral")  
	public void savePeripheral(@RequestBody Peripheral peripheral) throws Exception {
		service.savePeripheral(peripheral);
	}
	
	@DeleteMapping("/gateway/{id}")  
	public void deleteGateway(@PathVariable("id") String id) {
		service.deleteGateway(id);
	}

}
