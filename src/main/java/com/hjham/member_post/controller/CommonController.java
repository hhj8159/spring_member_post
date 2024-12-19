package com.hjham.member_post.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.common.lang.Nullable;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CommonController {
  @GetMapping({"/", "/index"})
  public String index() {
    log.info("index controller");
    return "common/index";
  }

  // 테스트
  @GetMapping("map")
  @ResponseBody
  public Map<?,?> getmethodName() {
    Map<String, Object> map = new HashMap<>();
    map.put("A", 1) ;
    return map;
  }

  @RequestMapping(value = "msg")
  public String msg(@ModelAttribute("msg") String msg, @RequestParam("url") @Nullable String url, Model model) throws UnsupportedEncodingException {  
    log.info(msg);
    log.info(url);
    if(url != null) {
      int idx = url.indexOf("?url=") + 5;
      log.info(url.substring(0, idx));
      log.info(url.substring(idx));
      url = url.substring(0, idx) + URLEncoder.encode(url.substring(idx),"utf-8");
    }
    model.addAttribute("url", url);
    return "common/msg";
  }

}
