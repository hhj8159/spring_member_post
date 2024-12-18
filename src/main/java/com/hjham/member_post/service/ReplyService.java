package com.hjham.member_post. service;

import java.util.List;
import java.util.Map;

import com.hjham.member_post.dto.ReplyCri;
import com.hjham.member_post. vo.Reply;

public interface ReplyService {
	int write(Reply reply);
	
	int modify(Reply reply);
	
	int remove(Long rno);
	
	int removeAll(Long pno);
	
	Reply findBy(Long rno);
	
	Map<String, List<Reply>> list(Long pno, ReplyCri cri, Object writer);
}