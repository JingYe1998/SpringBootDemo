package com.ispan.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.demo.model.Customer;
import com.ispan.demo.model.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository cDao;
	
	@PostMapping("/customer/insert")
	public Customer insertCustomer() {
		Customer c1 = new Customer();
		c1.setName("廖老大");
		c1.setLevel(5);
		
		Customer resCus = cDao.save(c1);
		
		return resCus;
	}
	
	@PostMapping("/customer/insert2")
	public Customer insertCustomer2(@RequestBody Customer cus) {
		Customer resCus = cDao.save(cus);
		return resCus;
	}
	
	// 試試 兩筆以上丟進來 ?
	@PostMapping("/customer/insert3")
	public List<Customer> insertCustomer2(@RequestBody List<Customer> cus) {
		List<Customer> returnList = cDao.saveAll(cus);
		return returnList;
	}
	
	@GetMapping("/customer/get/{id}")
	public Customer getById(@PathVariable("id") Long id) {
		Optional<Customer> optional = cDao.findById(id);
		
		if(optional.isPresent()) {
			Customer resCus = optional.get();
			return resCus;
		}
		
		Customer emptyCus = new Customer();
		emptyCus.setName("沒有這筆資料");
		
		return emptyCus;
	}
	
	@GetMapping("/customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC, "id");
		Page<Customer> page = cDao.findAll(pgb);
		List<Customer> list = page.getContent();
		return list;
	}
	
	// http://localhost:8081/my-app/customer/findByName?name=xxxx
	@GetMapping("/customer/findByName")
	public List<Customer> findByName(@RequestParam String name){
		 return cDao.findCustomerByName3(name);
	}
	
	@GetMapping("/customer/level")
	public List<Customer> findByLevel(@RequestParam Integer level, @RequestParam String name){
		return cDao.findCustomerByLevel(level, name);
	}

}
