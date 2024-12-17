package com.classIT.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.classIT.domain.Criteria;
import com.classIT.domain.QuestionVO;

public interface QuestionMapper {

	
	public QuestionVO getOne(Long question_no);
	public List<QuestionVO> getList(Long product_no);
	public List<QuestionVO> getListForUser(String user_id);
	
	public int insert(QuestionVO rVo);
	public int update(QuestionVO rVo);
	public int delete(@Param("question_no") Long question_no, @Param("user_id") String user_id);
	
	
	// ����¡ ������ ������� �Խù� ����� ��������
	public List<QuestionVO> getListWithPaging(@Param("product_no") Long product_no, @Param("cri") Criteria cri);
	
	// Product_no�� review������ ����
	public int getCountByProductNo(Long product_no);
	
	// Question ��ȣ�� �ش��ϴ� answercnt(�亯��)�� ������Ʈ
	public void updateAnswerCnt(@Param("question_no") Long question_no, @Param("amount") int amount);
	
}
