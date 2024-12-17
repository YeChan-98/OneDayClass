package com.classIT.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionPageDTO {
	private int questionCnt;		// Ŭ���� �� ���䰹��
	private List<QuestionVO> list;	// Ŭ���� �� ���� ��� ����
}
