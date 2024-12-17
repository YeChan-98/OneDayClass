package com.classIT.service;

import java.util.List;

import com.classIT.domain.ProductVO;
import com.classIT.domain.ScheduleVO;

public interface ScheduleService {

	public void register(ScheduleVO schedule);
	public List<ScheduleVO> getList(Long product_no);
	public boolean remove(Long product_no);
	
}
