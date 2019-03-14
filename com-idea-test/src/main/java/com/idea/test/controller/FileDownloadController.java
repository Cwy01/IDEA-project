package com.idea.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file/download")
public class FileDownloadController {

    @Value("${prop.download-folder}")
    private String downloadPath;
    @Value("${prop.download-file}")
    private String fileName;

    // 下载D盘的file.rar
    @GetMapping("/file")
    public String file(HttpServletResponse response){
        // 构建一个Path对象
        Path path = Paths.get(downloadPath,fileName);
        // 如果路径对象存在，可以下载
        if(Files.exists(path)){
            // 通过response响应出去，设置文件类型,头信息
            response.setContentType("application/zip");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition","attachment; filename=file.zip");
            // 复制文件
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}