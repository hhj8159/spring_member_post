package com.hjham.member_post.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hjham.member_post.service.MemberService;
import com.hjham.member_post.vo.Member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
@RequestMapping("member")
@Log4j2
@AllArgsConstructor
public class MemberController {  
  // /member/signin
  // return type
  // String : '해당 위치의 jsp' (ex: /WEB-INF/views/member/signin.jsp) 로 forward
  // void : 접속 requestURI 위치를 반환 forward
  private MemberService service;
  
  @GetMapping("mv")
  public ModelAndView mv(ModelAndView mav) {
    mav.addObject("test", "abcd");
    mav.setViewName("common/index");
    log.info(mav);
    return mav;
  }

  InternalResourceViewResolver resolver;
  @RequestMapping(value = {"", "*"}, method = RequestMethod.GET) @ResponseBody
  public Member all() {
    DispatcherServlet servlet;
    log.info(resolver);
    log.info(resolver.getAttributesMap());
    log.info(resolver.getOrder());
    return new Member();
  } 
  @RequestMapping(value = {"", "*"}, method = RequestMethod.PUT) @ResponseBody
  public Member all2() {
    return new Member();
  } 

  @RequestMapping(value = "signin", method = RequestMethod.GET)
  public void signin() {}
  
  @PostMapping("signin")
  // optional도 있음 
  // public String postSignin(Member member, @Nullable @RequestParam("remember-id") String remember) {
  public String postSignin(
    Member member, @RequestParam(required = false, value = "remember-id") String remember,
    HttpSession session, RedirectAttributes rttr, HttpServletResponse resp
  ) {
    log.info(remember);
    log.info(member);

    if(service.login(member.getId(), member.getPw())) {
      // 성공
      // 1. 세션에 member라는 이름의 attribute
      session.setAttribute("member", service.findBy(member.getId()));

      // 1-1. 아이디 저장 시 cookie에 remember-id 지정
      Cookie cookie = new Cookie("remember-id", member.getId());
      cookie.setPath("/");
      if(remember != null) {
        cookie.setMaxAge(60 * 60 * 24 * 7);
      }
      else {
        cookie.setMaxAge(0);
      }
      resp.addCookie(cookie);

      // 2. redirect index
      return "redirect:/";
    }
    else {
      // 쿠키 끄면 세션 작동 안함
      // 실패
      rttr.addFlashAttribute("msg", "failed");
      return "redirect:signin";
    }
  }

  @RequestMapping("logout")
  public String requestMethodName(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }
  
  @GetMapping("signup")
  public void signup() {  }
  
  @PostMapping("signup")
  public String postSignup(Member member) {
    log.info(member);
    service.register(member);
    return "redirect:signin";
  } 

}
