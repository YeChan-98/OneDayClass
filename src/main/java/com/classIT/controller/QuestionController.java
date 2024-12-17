package com.classIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classIT.domain.Criteria;
import com.classIT.domain.QuestionPageDTO;
import com.classIT.domain.QuestionVO;
import com.classIT.service.QuestionService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	
//	//Ŭ���� �� ���� ����Ʈ									// ��� JSON
//	@GetMapping(value = "/getList/{product_no}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<List<QuestionVO>> getList(@PathVariable("product_no") Long product_no) {
//		
//	    if (service == null) {
//	        log.error("ReviewService is null!");
//	    } else {
//	        log.info("ReviewService is injected");
//	    }
//	    
//		log.info("////////////////////////////////getList : " + product_no);
//		return new ResponseEntity<List<QuestionVO>>(service.getList(product_no), HttpStatus.OK);
//		
//	}
	
	//Ŭ���� �� ���� ����Ʈ(����¡)									// ��� JSON
	@GetMapping(value = "/getPagingList/{product_no}/{pageNum}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<QuestionPageDTO> getList(@PathVariable("product_no") Long product_no, @PathVariable("pageNum") int pageNum) {
		
		log.info("////////////////////////////////getPagingList : " + product_no);
		Criteria cri = new Criteria(pageNum,5); // 1�������� 5���� ���
	    
		return new ResponseEntity<QuestionPageDTO>(service.getListPage(product_no,cri), HttpStatus.OK);	// ��۰���, ��۸�� ���� ��ȯ
		
	}
	
	
	
	
	// �ۼ��� �� ���� ����Ʈ
	@GetMapping(value = "/getListForUser/{user_id}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<QuestionVO>> getListForUser(@PathVariable("user_id") String user_id) {

		log.info("////////////////////////////////getListForUser : " + user_id);
		return new ResponseEntity<List<QuestionVO>>(service.getListForUser(user_id), HttpStatus.OK);
		
	}
	
	// ���� 1�� ��ȯ
	@GetMapping(value = "/getOne/{question_no}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<QuestionVO> getOne(@PathVariable("question_no") Long question_no) {

		log.info("////////////////////////////////getOne : " + question_no);
		
		return new ResponseEntity<>(service.getOne(question_no), HttpStatus.OK);
	}
	
	// ���� ���
	@PostMapping(value="/register", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(@RequestBody QuestionVO qVo){
		
		log.info("////////////////////////////////register : " + qVo);
		return service.register(qVo) == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	// ���� ������Ʈ
	@PutMapping(value="/modify", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody QuestionVO qVo){
		
		log.info("////////////////////////////////modify : " + qVo);
		return service.modify(qVo) == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// ���� ����
	@DeleteMapping(value="/remove/{question_no}/{user_id}",  produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable Long question_no,@PathVariable String user_id){
		log.info("////////////////////////////////remove : " + question_no + ", " + user_id);
		return service.remove(question_no, user_id) == 1 ? new ResponseEntity<String>("success",HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
