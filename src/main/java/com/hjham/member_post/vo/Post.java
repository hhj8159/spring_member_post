package com.hjham.member_post. vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("post")
public class Post {
	private Long pno;
	private String title;
	private String writer;
	private String content;
	private Long viewCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // pattern대로 받는다
	private Date regdate;
	private Date updatedate;
	private Integer cno;
	private Boolean attachFlag;	

	private List<Attach> attachs = new ArrayList<>() ;


	
}