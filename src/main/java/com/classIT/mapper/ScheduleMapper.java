package com.classIT.mapper;

import java.util.List;

import com.classIT.domain.ProductVO;
import com.classIT.domain.ScheduleVO;

public interface ScheduleMapper {

	public void insertSelectKey(ScheduleVO schedule);
	public List<ScheduleVO> getList(Long product_no);
	public int delete(Long product_no);
	
}
