package com.yb.onlineexamserver.utils;

import com.yb.onlineexamserver.common.enums.OnlineExamExceptionEnum;
import com.yb.onlineexamserver.common.exception.OnlineExamException;
import com.yb.onlineexamserver.service.teacher.impl.TeacherBannerServiceImpl;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Auther: Yang
 * @Date: 2020/03/20 15:48
 * @Description: 文件上传工具类
 */
@Component
public class FileUploadUtils {
    private static String FILE_FOLDER;
    private static String UPLOAD_SERVER;
    @Value("${prop.upload-folder}")
    public void setFileFolder(String fileFolder){
        FileUploadUtils.FILE_FOLDER = fileFolder;
    }
    @Value("${prop.upload-server}")
    public void setUploadServer(String uploadServer){
        FileUploadUtils.UPLOAD_SERVER = uploadServer;
    }
    public static String upload(MultipartFile file) {
        if (file == null) {
            throw new OnlineExamException(OnlineExamExceptionEnum.FILE_IS_NULL);
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new OnlineExamException(OnlineExamExceptionEnum.FILE_TOO_BIG);
        }
        //获取文件后缀，判断是否是图片类型
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            throw new OnlineExamException(OnlineExamExceptionEnum.FILE_NOT_PICTURE);
        }
        String fileFolder = FILE_FOLDER;
        File fileFolderFile = new File(fileFolder);
        if(!fileFolderFile.exists()){
            fileFolderFile.mkdir();
        }
        //通过uuid生成唯一图片名称
        String realFileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+suffix;
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("47.99.193.37", 21);
            ftpClient.login("ftpuser", "sunshineftp");
//            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("/home/ftpuser/images");
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\文件\\yingmu.png"));
            ftpClient.storeFile(realFileName, file.getInputStream());
            //fileInputStream.close();
            ftpClient.logout();
//            file.transferTo(new File(fileFolder+realFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new OnlineExamException(OnlineExamExceptionEnum.FILE_SAVE_FAIL);
        }
        return UPLOAD_SERVER + realFileName;
    }
}
