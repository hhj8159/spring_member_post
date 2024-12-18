package com.hjham.member_post. mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hjham.member_post.vo.Member;

@Mapper
public interface MemberMapper {
	int insert(Member member);
	Member selectOne(String id);
}
