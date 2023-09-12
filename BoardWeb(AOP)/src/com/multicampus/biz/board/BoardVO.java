package com.multicampus.biz.board;

import java.util.Date;

import lombok.Data;

// 1. VO(value object) Å¬·¡½º
@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}
