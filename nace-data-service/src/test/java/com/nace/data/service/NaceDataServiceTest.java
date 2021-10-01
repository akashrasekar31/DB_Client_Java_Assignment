package com.nace.data.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nace.data.bean.NaceBean;
import com.nace.data.repository.NaceDataRepository;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class NaceDataServiceTest {
	@MockBean
	private NaceDataRepository repository;
	
	@Autowired
	private NaceDataService service;
	
	@Test
 	public void getNaceDetailsTest() {
		long id=1;
		Optional<NaceBean> testData=Optional.of(new NaceBean(1, 1, "A", "P", "Desc", "Test1", "Test2","TestR", "Test3", "D"));
		when(repository.findById(id)).thenReturn(testData);
		Assertions.assertEquals(true, service.getNaceDetails(id).isPresent());
	}
	
	@Test
 	public void saveNaceDetailsTest(){
		List<NaceBean> data=Arrays.asList(new NaceBean(1, 1, "A", "P", "Desc", "Test1", "Test2","TestR", "Test3", "D"));
		when(repository.saveAll(data)).thenReturn(data);
		Assertions.assertEquals(1, service.saveNaceDetails(data).size());
	}
		
}
