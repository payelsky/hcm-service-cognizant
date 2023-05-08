package com.springboot.hcmservice.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.hcmservice.entity.Hcm;
import com.springboot.hcmservice.repository.HcmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HcmServiceTest {
	
	
	@Autowired
	private HcmService hcmService;
	
	
	@MockBean
	private HcmRepository hcmrepository;
	
	
	@Test
	public void getAllHcmTest() {
		List<Hcm> hcmlist=new ArrayList<>();
		hcmlist.add(Hcm.build(1,"5" , "2", "Y", "Y"));
		hcmlist.add(Hcm.build(2,"2" , "2", "Y", "Y"));
		when(hcmrepository.findAll()).thenReturn(hcmlist);
		assertEquals(2, hcmService.getAllHcm().size());
	}
	
	@Test
	public void createHcmTest() {
		Hcm hcm=Hcm.build(1,"5" , "2", "Y", "Y");
		when(hcmrepository.save(hcm)).thenReturn(hcm);
		assertEquals(hcm, hcmService.createHcm(hcm));
	}

}
