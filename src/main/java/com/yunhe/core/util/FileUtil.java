package com.yunhe.core.util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: tradesteward
 * @description: 文件上传
 * @author: 史江浩
 * @create: 2019-01-16 10:13
 **/
public class FileUtil {

    public String fileUpload(String lujing, MultipartFile file) throws IOException {
        File convertFile = new File(lujing+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return "上传成功！";
    }
}
