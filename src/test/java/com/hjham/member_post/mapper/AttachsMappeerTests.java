package com.hjham.member_post.mapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.member_post.vo.Attach;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AttachsMappeerTests {
  @Autowired
  private AttachMapper mapper;
  @Test
  public void testSelectAttach() {
    String date = "2024/12/19";
    
    List<Attach> list = mapper.selectListByPath(date);
    list.forEach(log::info);
    log.info("============================================");
    List<File> files = new ArrayList<>(Arrays.asList(new File("c:/upload", date).listFiles()));
    files.forEach(log::info);

    log.info("============================================");
    List<File> list2 = list.stream().map(Attach::toFile).toList();
  }
}
