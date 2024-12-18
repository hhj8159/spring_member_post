package com.hjham.member_post.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjham.member_post.dto.Criteria;
import com.hjham.member_post.service.PostService;
import com.hjham.member_post.vo.MyVo;
import com.hjham.member_post.vo.Post;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;



// @Controller  // RestController와 같은 결과를 얻으려면 ResponseBody을 쓴다
// @RestController // Controller의 역할 + 소유한 모든 메서드의 반환형태 @ResponseBody

// @RequestMapping("reply")
@Log4j2
public class OldReplyController {
  // @RequestBody
  // @PathVariable
  // @ResponseBody
  @RequestMapping("test")  
  public String test() {
    log.info("도착 지점 확인 reply/test");
    return "hello";
  }

  // void String ResponseEntity
  // entity 개체
  @RequestMapping("re")
  public ResponseEntity<String> re() {
    // return ResponseEntity.ok().build();
    // return ResponseEntity.status(200).build();
    // return ResponseEntity.notFound().build(); // 404
    // return ResponseEntity.ok("my re");
    return new ResponseEntity<String>("본문", HttpStatus.NOT_FOUND); // 404
  }

  @GetMapping(value = "arr")
  public Integer[] getMethodName() {
    return new Integer[] {3,4,5,6};
  }

  @GetMapping("list")
  public List<String> list() {
    List<String> list = new ArrayList<>();
    list.add("가");
    list.add("나");
    list.add("다");
    list.add("라");
    return list;
  }

  @GetMapping("students")
  public List<?> students() {
    List<Map<?,?>> list = new ArrayList<>();
    Map<String,Object> map = new HashMap<>();
    map.put("no", 1);
    map.put("name", "새똥이");
    map.put("score", 100);
    list.add(map);
    map = new HashMap<>();
    map.put("no", 2);
    map.put("name", "개똥이");
    map.put("score", 80);
    list.add(map);
    return list;
  }
  

  @Autowired
  private PostService postService;
  @GetMapping("post")
  public Post post() {        
    return postService.findBy(1L);
  }

  @GetMapping("myPost")
  public Post myPost(Post post) {
    return post;
  }

  @GetMapping("p1")
  public int[] p1(@RequestParam("arr") int[] arr) {
    return arr;
  }
  @GetMapping("p2")
  public List<?> p2(@RequestParam("arr") List<?> list) {
    return list;
  }

  @InitBinder
  public void init(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy_MM_dd"), false));
  }
  
  @GetMapping("myvo")
  public MyVo mv(MyVo myVo) {
    return myVo;
  }
  
  
  
  

}
