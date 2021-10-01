package com.nace.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nace.data.bean.NaceBean;
import com.nace.data.bean.ResponseMessage;
import com.nace.data.exceptions.DataNotFound;
import com.nace.data.service.NaceDataService;
import com.nace.data.utils.CSVHelper;

@RestController
public class NaceDataController {
	
	@Autowired
	NaceDataService naceDataService;
	
	@PostMapping("/saveData")
	public ResponseMessage putNaceDetails(@RequestParam("file") MultipartFile file) {
		ResponseMessage message = new ResponseMessage();

	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	    	naceDataService.putNaceDetails(file);
	        message.setMessage("file uploaded successfully: " + file.getOriginalFilename());
	        return message;
	      } catch (Exception e) {
	    	e.printStackTrace();
	        message.setMessage("Could not upload the file: " + file.getOriginalFilename() + "!");
	        return message;
	      }
	    }

        message.setMessage("Please upload a csv file!");
	    return message;
	}
	
	@GetMapping("/getNaceDetails/{orderID}")
	public NaceBean getNaceDetails(@PathVariable long orderID) {
		Optional<NaceBean> data=naceDataService.getNaceDetails(orderID);
		NaceBean resData=new NaceBean();
		if(data.isPresent()) {
			resData= data.get();
		}
		else {
			throw new DataNotFound("No Data for Order id: "+orderID);
		}
		return resData;
	}
	
	@PostMapping("/saveNaceDetails")
	public ResponseMessage saveNaceDetails(@RequestBody List<NaceBean> naceBean) {
		List<NaceBean> saved=naceDataService.saveNaceDetails(naceBean);
		if(saved.size()==naceBean.size()) {
			return new ResponseMessage("Data Saved Successfully");
		}
		else {
			return new ResponseMessage("Data not synced, some error occured");
		}
	}
}
