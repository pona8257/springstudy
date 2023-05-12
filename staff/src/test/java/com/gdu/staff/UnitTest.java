package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	

public class UnitTest {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Test
	public void 삽입테스트() {
		StaffDTO board = new StaffDTO("99999", "김기획", "기획부", 5000);
		assertEquals(1, staffMapper.addStaff(board));	
	}
	
	@Test 
	public void 사원조회테스트(){
		String sno = "11111";
		StaffDTO dto = new StaffDTO();
		dto.setSno(sno);
		Object obj = staffMapper.searchStaff(dto);
		assertNotNull(obj);
	}

}
