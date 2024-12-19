package com.hjham.member_post.controller;

import javax.management.RuntimeErrorException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import com.hjham.member_post.aop.annotation.MyPost;
import com.hjham.member_post.aop.annotation.SigninCheck;
import com.hjham.member_post.dto.Criteria;
import com.hjham.member_post.dto.PageDto;
import com.hjham.member_post.exception.UnsignedAuthException;
import com.hjham.member_post.service.PostService;
import com.hjham.member_post.vo.Member;
import com.hjham.member_post.vo.Post;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@Log4j2
@Controller
@RequestMapping("post")
@AllArgsConstructor
public class PostController {
  private PostService service;

  @GetMapping("list")
  public String list(Criteria cri, Model model) {
    model.addAttribute("posts", service.list(cri));
		model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
    return "post/list";
  }

  @GetMapping("view")
  public void view(@ModelAttribute("cri") Criteria cri, Long pno, Model model) {
    model.addAttribute("post", service.view(pno));
  }
  
  @GetMapping("write")
  @SigninCheck
  public void write(@ModelAttribute("cri") Criteria cri) { }  
  
  @PostMapping("write")
  public String postWrite(Post post, Criteria cri) {
    post.setCno(cri.getCategory());
    service.write(post);
    log.info(post);
    return "redirect:list?" + cri.getQs2();
  }

  @GetMapping("modify")
  @SigninCheck
  public void modify(@RequestParam("pno") Long pno, Criteria cri, Model model, 
  @SessionAttribute(name = "member",required = false) Member member, String writer) {
    Post post = service.findBy(pno);
    if(member == null || !member.getId().equals(post.getWriter())) {
      throw new UnsignedAuthException("동일하지 않은 혹은 비로그인");
    }
    model.addAttribute("post", post);
  }
  
  @PostMapping("modify")
  @MyPost
  public String postModify(Post post, Criteria cri) {
    log.info(post);
    log.info(cri);
    // service.modify(post);
    return "redirect:list?" + cri.getQs();
  }
    
  @RequestMapping("remove")
  public String remove(@RequestParam("pno") Long pno, Criteria cri) {
    service.remove(pno);
    return "redirect:list?" + cri.getQs();
  }

}
