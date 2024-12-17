package com.classIT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.classIT.domain.Criteria;
import com.classIT.domain.QuestionPageDTO;
import com.classIT.domain.QuestionVO;
import com.classIT.mapper.QuestionMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	private QuestionMapper mapper;
	
	@Override
	public QuestionVO getOne(Long question_no) {
		log.info("[question] getOne......" + question_no);
		return mapper.getOne(question_no);
	}

	@Override
	public List<QuestionVO> getList(Long product_no) {
		log.info("[question] getList......" + product_no);
		return mapper.getList(product_no);
	}

	@Override
	public List<QuestionVO> getListForUser(String user_id) {
		log.info("[question] getListForUser......" + user_id);
		return mapper.getListForUser(user_id);
	}

	@Override
	public int register(QuestionVO rVo) {
		log.info("[question] register......" + rVo);
		return mapper.insert(rVo);
	}

	@Override
	public int modify(QuestionVO rVo) {
		log.info("[question] modify......" + rVo);
		return mapper.update(rVo);
	}

	@Override
	public int remove(Long question_no, String user_id) {
		log.info("[question] modify......" + question_no +","+ user_id);
		return mapper.delete(question_no,user_id);
	}

	@Override
	public List<QuestionVO> getPagingList(Long product_no, Criteria cri) {
		log.info("[question] getPagingList......" + product_no +","+ cri);
		return mapper.getListWithPaging(product_no,cri);
	}

	@Override
	public QuestionPageDTO getListPage(Long product_no, Criteria cri) {
		log.info("[question] getListPage......" + product_no +","+ cri);
		return new QuestionPageDTO(mapper.getCountByProductNo(product_no), mapper.getListWithPaging(product_no, cri));
	}

}
