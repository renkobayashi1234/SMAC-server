package com.example.smac.web;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/download")
public class MP3DownloadController {

    @Value("${path.to.mp3}")
    private String mp3Path;

    @CrossOrigin
    @GetMapping("/mp3")
    public void downloadMP3(@RequestParam(value = "fileName") String fileName, HttpServletResponse response) {

        try (OutputStream outputStream = response.getOutputStream();) {
            
            //ダウンロードファイルをバイト配列に変換
            Path path = Paths.get(mp3Path+fileName);
            byte[] fileByte = Files.readAllBytes(path);

            //レスポンスヘッダに値をセット 
            response.setContentType("audio/mpeg");
            response.setHeader("Content-Disposition", "attachment; filename="+fileName);
            response.setContentLength(fileByte.length);
            outputStream.write(fileByte);
            outputStream.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
