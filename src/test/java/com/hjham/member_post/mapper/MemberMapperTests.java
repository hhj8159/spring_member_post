package com.hjham.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.member_post.mapper.MemberMapper;
import com.hjham.member_post.vo.Member;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {
  @Autowired
  private MemberMapper mapper;

  @Test
  @DisplayName("MemberMapper 생성 여부 확인")
  public void testMapper() {
    assertNotNull(mapper, "메세지");
  }

  @Test
  public void testSignin() {
    log.info(mapper.selectOne("abcd"));
  }

  @Test
  public void testSignup() {
    Member member = Member.builder().id("abcdef").pw("1234").name("말똥쓰").build();
    mapper.insert(member);
  }
}
