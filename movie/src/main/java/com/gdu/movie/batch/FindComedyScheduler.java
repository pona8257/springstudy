package com.gdu.movie.batch;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;
import com.gdu.movie.mapper.MovieMapper;

@Component
@EnableScheduling
public class FindComedyScheduler {

  @Autowired
  private MovieMapper movieMapper;
  
  @Scheduled(cron = "0 * * * * *")
  public void execute() {
    
    QueryDTO queryDTO = new QueryDTO("GENRE", "코미디");
    List<MovieDTO> list = movieMapper.getMoviesByQuery(queryDTO);
    
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < list.size(); i++) {
      sb.append("제목 : " + list.get(i).getTitle() + "\n");
      sb.append(" 장르 : " + list.get(i).getGenre() + "\n");
      sb.append(" 개요 : " + list.get(i).getDescription() + "\n");
      sb.append(" 평점 : " + list.get(i).getStar() + "\n");
    }
 
    System.out.println(sb);
  }
}
