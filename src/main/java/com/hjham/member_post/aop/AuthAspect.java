package com.hjham.member_post.aop;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.hjham.member_post.vo.Member;
import com.hjham.member_post.vo.Post;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@AllArgsConstructor
@Log4j2
public class AuthAspect {
  private HttpSession session;
  private HttpServletRequest req;
  private HttpServletResponse resp;

  @Before("@annotation(com.hjham.member_post.aop.MyPost)")
  public void myPost(JoinPoint joinPoint, MyPost myPost) {
    
    Object o = session.getAttribute("member");
    String id = ((Member) o).getId(); // 현재 로그인한 사용자

    Object[] args = joinPoint.getArgs();
    String writerParam = myPost.value();
    log.info(Arrays.toString(args));
    log.info(id);
    log.info(writerParam);

    // if(o == null || !((Member)o).getId().equals(post.getWriter())) {
    //   throw new RuntimeException("본인 게시글 아님");
    // }
  }

  @Before("@annotation(com.hjham.member_post.aop.SigninCheck)")
  public void signinCheck(JoinPoint jp) throws IOException {
    log.info(req.getRequestURI());
    log.info(req.getRequestURL());
    log.info(req.getQueryString());
    if(session.getAttribute("member") == null) {
      String url = "/member/signin?url=" + URLEncoder.encode(req.getRequestURI() + "?" + req.getQueryString(), "utf-8");
      resp.sendRedirect("/msg?msg=" + URLEncoder.encode("로그인이 필요한 페이지 입니다.", "utf-8") + "&url=" + url);
    }
  }
}