package com.wellnessmanagement.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellnessmanagement.model.Trader;
import com.wellnessmanagement.repository.trader.TraderRepository;
import com.wellnessmanagement.service.TraderService;

@Service

public class TraderServiceImpl implements TraderService {
	
	@Autowired
	TraderRepository repo;

	@Override
	public List<Trader> fetchTraderList(String tname, String tphone, String tmailid) {
		List<Trader> list = repo.findAll();
		return list.stream().filter(z -> z.getTname().equalsIgnoreCase(tname) && z.getTphone().equalsIgnoreCase(tphone) && z.getTmailid().equalsIgnoreCase(tmailid)).collect(Collectors.toList());
	}
	

	@Override
	public Trader updateTrader(Trader t, int tid) {
		Trader trader = repo.getById(tid);
		trader.setTname(t.getTname());
		trader.setTphone(t.getTphone());
		trader.setTmailid(t.getTmailid());
		trader.setTpassword(t.getTpassword());
		trader.setTfeedback(t.getTfeedback());
		repo.save(trader);
		return trader;
	}


	@Override
	public Trader deleteTrader(int tid) {
		Trader t = repo.getById(tid);
		repo.deleteById(tid);
		return t;
	}


	@Override
	public void saveTrader(Trader t) {
		repo.save(t);
		
	}


	
	
	
	

}