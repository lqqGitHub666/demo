package com.example.demo.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

/**
 * @author 作者 lqq
 * @ClassName 类名 HttpUtils
 * @date 2020/7/20 10:02
 * @注释：
 */
public class HttpUtils {

    public static void postDataWithImage(String url, String json, RestTemplate baseRestTemplate, List<FileSystemResource> objMaterialFile){

//        FileSystemResource fileSystemResource = new FileSystemResource(new File(""));

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("uuid", "12345678");
        params.add("companyId", "6666666");
//        params.add("file", objScreeFile);
        // lambda 写法
        objMaterialFile.forEach(fileSystemResource -> params.add("fileArray", fileSystemResource));
        // 普通写法
//        for (FileSystemResource file : objMaterialFile) {
//            params.add("fileArray",file);
//        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestBody = new HttpEntity<>(params);
        ResponseEntity<String> responseEntity = baseRestTemplate.postForEntity(url, requestBody, String.class);
        JSONObject jsonObject = JSON.parseObject(responseEntity.getBody());

    }


}
