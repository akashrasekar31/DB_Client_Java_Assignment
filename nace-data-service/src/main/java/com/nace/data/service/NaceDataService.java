package com.nace.data.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nace.data.bean.NaceBean;
import com.nace.data.bean.ResponseMessage;
import com.nace.data.repository.NaceDataRepository;
import com.nace.data.service.NaceDataService;
import com.nace.data.utils.CSVHelper;

@Service
public class NaceDataService {

	  @Autowired
	  NaceDataRepository naceDataRepository;

	  public void putNaceDetails(MultipartFile file) {
	    try {
	      List<NaceBean> data = CSVHelper.csvToTutorials(file.getInputStream());
	      naceDataRepository.saveAll(data);
	    } catch (IOException e) {
	      e.printStackTrace();
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	  
	 
	  public Optional<NaceBean> getNaceDetails(long orderId) {
	    return naceDataRepository.findById(orderId);
	  }


	public List<NaceBean> saveNaceDetails(List<NaceBean> naceBean) {
		List<NaceBean> saved=null;
		try {
			saved= naceDataRepository.saveAll(naceBean);
		    } catch (Exception e) {
		      e.printStackTrace();
		      throw new RuntimeException("fail to save data: " + e.getMessage());
		    }	
		return saved;
	}
}
