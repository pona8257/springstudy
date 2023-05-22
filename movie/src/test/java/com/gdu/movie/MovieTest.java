package com.gdu.movie;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	

public class MovieTest {
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Test
	public void 영화목록테스트() {
	  List<MovieDTO> list = movieMapper.getAllMovies();;
	  
	  assertNotNull(list);
	}
	

}
