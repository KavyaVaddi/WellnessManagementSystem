package com.wellnessmanagement.service;

import java.util.List;

import com.wellnessmanagement.model.Trader;

public interface TraderService {

	List<Trader> fetchTraderList(String tname,String tphone,String tmailid);
	Trader updateTrader(Trader t,int tid);
	Trader deleteTrader(int tid);
	void saveTrader(Trader t);
}
