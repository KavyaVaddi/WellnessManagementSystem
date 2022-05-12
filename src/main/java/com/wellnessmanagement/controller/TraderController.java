package com.wellnessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellnessmanagement.model.Trader;
import com.wellnessmanagement.service.TraderService;

@RestController
@RequestMapping("/trader")
public class TraderController {
	@Autowired
	TraderService service;
	
	@RequestMapping("/test")
    public String test() {
		System.out.print("hello trader");
		return "trader class created successfully";
	}
	
	@GetMapping("/fetch/{tname}/{tphone}/{tmailid}")
	public List<Trader> fetchTraderList(@PathVariable(value="tname")String tname,@PathVariable(value="tphone")String tphone,@PathVariable(value="tmailid")String tmailid){
		List<Trader> trader = service.fetchTraderList(tname, tphone, tmailid);
		for(Trader t:trader)
			System.out.println(t+"\n");
		return trader;
	}
	
	@PostMapping("/entertraderdetails")
	public ResponseEntity<Trader> saveTraderDetails(@RequestBody Trader t){
		Trader trader = t;
		service.saveTrader(t);
		return new ResponseEntity<Trader>(trader,HttpStatus.OK);
	}
	
	@PutMapping("/updatetrader/{tid}")
	public ResponseEntity<Trader> updateTraderDetails(@PathVariable(value="tid")Integer tid,@RequestBody Trader t){
		service.updateTrader(t, tid);
		return new ResponseEntity<Trader>(t,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletetrader/{tid}")
	public ResponseEntity<Trader> deleteTrader(@PathVariable(value="tid")Integer tid){
		Trader trader = service.deleteTrader(tid);
		return new ResponseEntity<Trader>(trader,HttpStatus.OK);
	}
}
