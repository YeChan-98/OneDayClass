package com.classIT.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionPageDTO {
	private int questionCnt;		// 클래스 별 리뷰갯수
	private List<QuestionVO> list;	// 클래스 별 리뷰 목록 저장
}
