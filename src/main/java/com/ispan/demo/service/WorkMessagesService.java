package com.ispan.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.model.WorkMessages;
import com.ispan.demo.model.WorkMessagesDao;

@Transactional
@Service
public class WorkMessagesService {
	
	@Autowired
	private WorkMessagesDao wDao;
	
	public WorkMessages insert(WorkMessages msg) {
		return wDao.save(msg);
	}
	
	public WorkMessages findById(Integer id) {
		Optional<WorkMessages> optional = wDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public void deleteById(Integer id) {
		wDao.deleteById(id);
	}
	
	public List<WorkMessages> findAllMessages(){
		return wDao.findAll();
	}
	
	public Page<WorkMessages> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
		Page<WorkMessages> page = wDao.findAll(pgb);
		return page;
	}
	
	public WorkMessages findLatest() {
		return wDao.findFirstByOrderByAddedDesc();
	}

}
