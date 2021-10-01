package com.nace.data.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nace.data.bean.NaceBean;
import com.nace.data.bean.ResponseMessage;
import com.nace.data.service.NaceDataService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class NaceDataControllerTest {
	
	@Mock
	private NaceDataService naceDataService;
	
	@InjectMocks
	private NaceDataController naceDataController;
	
	@Test
	public void getNaceDetailsTest() throws Exception {
		long id=0;
		Optional<NaceBean> testData=Optional.of(new NaceBean(1, 1, "A", "P", "Desc", "Test1", "Test2","TestR", "Test3", "D"));
		when(naceDataService.getNaceDetails(id)).thenReturn(testData);
		
		NaceBean data= naceDataController.getNaceDetails(id);
		
		assertThat(data.getOrderId()).isEqualTo(testData.get().getOrderId());
		assertThat(data.getLevel()).isEqualTo(testData.get().getLevel());
		assertThat(data.getCode()).isEqualTo(testData.get().getCode());
	}
	
	@Test
	public void saveNaceDetailsTest() throws Exception {
		List<NaceBean> testData=Arrays.asList(new NaceBean(1, 1, "A", "P", "Desc", "Test1", "Test2","TestR", "Test3", "D"));
		when(naceDataService.saveNaceDetails(testData)).thenReturn(testData);
		
		ResponseMessage msg= naceDataController.saveNaceDetails(testData);
		
		assertThat(msg.getMessage()).isEqualTo("Data Saved Successfully");
		
	}
	
}
