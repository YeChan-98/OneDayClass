package com.classIT.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	Long review_no;
	Long reserve_no;
	String review_title;
	String review_text;
	Date review_date;
	int review_rate;
	String user_id;
	
}
