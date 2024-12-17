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
import com.classIT.domain.ReviewPageDTO;
import com.classIT.domain.ReviewVO;
import com.classIT.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	
	//Ŭ���� �� ���� ����Ʈ									// ��� JSON
//	@GetMapping(value = "/getList/{product_no}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<List<ReviewVO>> getList(@PathVariable("product_no") Long product_no) {
//		
//	    if (service == null) {
//	        log.error("ReviewService is null!");
//	    } else {
//	        log.info("ReviewService is injected");
//	    }
//	    
//		log.info("////////////////////////////////getList : " + product_no);
//		return new ResponseEntity<List<ReviewVO>>(service.getList(product_no), HttpStatus.OK);
//		
//	}
	
//	//Ŭ���� �� ���� ����Ʈ(����¡)									// ��� JSON
//	@GetMapping(value = "/getPagingList/{product_no}/{pageNum}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<List<ReviewVO>> getList(@PathVariable("product_no") Long product_no,@PathVariable("pageNum") int pageNum) {
//		
//		Criteria cri = new Criteria(pageNum,5); // 1�������� 5���� ���
//	    
//		log.info("////////////////////////////////getPagingList : " + product_no);
//		return new ResponseEntity<List<ReviewVO>>(service.getPagingList(product_no,cri), HttpStatus.OK);
//		
//	}
	
	//Ŭ���� �� ���� ����Ʈ(����¡)									// ��� JSON
	@GetMapping(value = "/getPagingList/{product_no}/{pageNum}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReviewPageDTO> getList(@PathVariable("product_no") Long product_no, @PathVariable("pageNum") int pageNum) {
		
		log.info("////////////////////////////////getPagingList : " + product_no);
		Criteria cri = new Criteria(pageNum,5); // 1�������� 5���� ���
	    
		return new ResponseEntity<ReviewPageDTO>(service.getListPage(product_no,cri), HttpStatus.OK);	// ��۰���, ��۸�� ���� ��ȯ
		
	}
	
	
	// �ۼ��� �� ���� ����Ʈ
	@GetMapping(value = "/getListForUser/{user_id}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReviewVO>> getListForUser(@PathVariable("user_id") String user_id) {

		log.info("////////////////////////////////getListForUser : " + user_id);
		return new ResponseEntity<List<ReviewVO>>(service.getListForUser(user_id), HttpStatus.OK);
		
	}
	
	// ���� 1�� ��ȯ
	@GetMapping(value = "/getOne/{review_no}" ,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReviewVO> getOne(@PathVariable("review_no") Long review_no) {

		log.info("////////////////////////////////getOne : " + review_no);
		
		return new ResponseEntity<>(service.getOne(review_no), HttpStatus.OK);
	}
	
	// ���� ���
	@PostMapping(value="/register", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(@RequestBody ReviewVO rVo){
		
		log.info("////////////////////////////////register : " + rVo);
		return service.register(rVo) == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	// ���� ������Ʈ
	@PutMapping(value="/modify", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReviewVO rVo){
		
		log.info("////////////////////////////////modify : " + rVo);
		return service.modify(rVo) == 1 ? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// ���� ����
	@DeleteMapping(value="/remove/{review_no}/{user_id}", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable Long review_no,@PathVariable String user_id){
		log.info("////////////////////////////////remove : " + review_no + ", " + user_id);
		return service.remove(review_no, user_id) == 1 ? new ResponseEntity<String>("success",HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
}
