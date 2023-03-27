package com.ispan.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.model.GoodPhoto;
import com.ispan.demo.model.GoodPhotoDao;

@Transactional
@Service
public class GoodPhotoService {
	
	@Autowired
	private GoodPhotoDao gDao;
	
	public GoodPhoto insertGoodPhoto(GoodPhoto gp) {
		return gDao.save(gp);
	}
	
	public List<GoodPhoto> listGoodPhoto(){
		return gDao.findAll();
	}
	
	public GoodPhoto getPhotoById(Integer id) {
		Optional<GoodPhoto> optional = gDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

}
