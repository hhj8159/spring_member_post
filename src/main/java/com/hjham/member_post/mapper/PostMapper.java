package com.hjham.member_post. mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hjham.member_post.dto.Criteria;
import com.hjham.member_post.vo.Post;

@Mapper
public interface PostMapper {
	int insert(Post post);
	
	Post selectOne(Long pno);
	
	int getCount(Criteria cri);
	
	List<Post> selectList(Criteria cri);
	
	int update (Post post);
	
	int increaseViewCount(Long pno);
	
	int delete (Long pno);
}
