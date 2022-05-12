package com.wellnessmanagement.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellnessmanagement.model.TraderProducts;
import com.wellnessmanagement.repository.trader.TraderProductsRepository;
import com.wellnessmanagement.service.TraderProductsService;

@Service
public class TraderProductsServiceImpl implements TraderProductsService {
@Autowired
TraderProductsRepository repo;
@Override
public List<TraderProducts> fetchProductsList() {
	List<TraderProducts> list = repo.findAll();
	return list;
}


@Override
public List<TraderProducts> traderproducts(int tid) {
	// TODO Auto-generated method stub
	List<TraderProducts> list = repo.findAll();
	list = list.stream().filter(a -> String.valueOf(a.getPpid()).substring(0, 4).equalsIgnoreCase(String.valueOf(tid))).collect(Collectors.toList());
	return list;
}


@Override
public TraderProducts updateProduct(TraderProducts p, int ppid) {
	TraderProducts p2 = repo.getById(ppid);
	p2.setPpname(p.getPpname());
	p2.setPpquantity(p.getPpquantity());
	p2.setPprice(p.getPpprice());
	repo.save(p2);
	return p2;
}

@Override
public TraderProducts deleteProduct(int ppid) {
	TraderProducts p = repo.getById(ppid);
	repo.deleteById(ppid);
	return p;
}

@Override
public void saveProduct(TraderProducts p) {
	repo.save(p);
}
}
