package com.classIT.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.classIT.domain.AnswerVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AnswerServiceTest {

	@Autowired
	private AnswerService service; 
	
	@Test
	public void getOneTest() {
		Long answer_no = 32L;
		
		AnswerVO test = service.getOne(answer_no);
		
		log.info(test);
	}
	
	@Test
	public void getListTest() {
		Long question_no = 32L;
		
		List<AnswerVO> test = service.getList(question_no);
		
		test.forEach(answer -> log.info(answer));
	}

}
