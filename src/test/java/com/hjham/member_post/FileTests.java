package com.hjham.member_post;

import java.io.File;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class FileTests {
  @Test
  public void testDeleteFiles() {
    File file = new File("c:/upload/2024/12/19", "19a657a4-5bb1-423e-afa3-0f04706d0de0.png");
    file.delete();
  }

  @Test
  public void testListFiles() {
    File file = new File("c:/upload/2024/12/19");
    log.info(file.isDirectory());
    log.info(file.isFile());

    new ArrayList<>(Arrays.asList(file.listFiles(pathname -> pathname.getName().endsWith("jpg")))).forEach(log::info);
  }
}
