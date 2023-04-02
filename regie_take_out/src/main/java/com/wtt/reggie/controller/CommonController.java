package com.wtt.reggie.controller;

import com.wtt.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Multicast;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        log.info(file.toString());
        return null;
    }
}
