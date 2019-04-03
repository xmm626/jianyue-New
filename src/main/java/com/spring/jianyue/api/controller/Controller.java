package com.spring.jianyue.api.controller;

import com.aliyun.oss.OSSClient;
import com.spring.jianyue.api.entity.User;
import com.spring.jianyue.api.entity.dto.UserDTO;
import com.spring.jianyue.api.service.UserService;
import com.spring.jianyue.api.util.MsgConst;
import com.spring.jianyue.api.util.ResponseResult;
import com.spring.jianyue.api.util.StatusConst;
import com.spring.jianyue.api.util.StringUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class Controller {
    @Resource
    private UserService userService;

    @PostMapping(value = "/sign_in")
    public ResponseResult signIn(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        User user = userService.getUserByMobile(userDTO.getMobile());
        if (user == null) {
            return ResponseResult.error(StatusConst.USER_MOBILE_NOT_FOUND, MsgConst.USER_MOBILE_NO_FOUND);
        } else {
            //手机号存在，将明文密码转成Base64密文后进行登录
            userDTO.setPassword(StringUtil.getBase64Encoder(userDTO.getPassword()));
            int status = userService.signIn(userDTO);
            if (status == StatusConst.SUCCESS) {
                return ResponseResult.success(user);
            } else if (status == StatusConst.PASSWORD_ERROR) {
                return ResponseResult.error(status, MsgConst.PASSWORD_ERROR);
            } else {
                return ResponseResult.error(status, MsgConst.USER_STATUS_ERROR);
            }
        }
    }

    @PostMapping("/avatar")
    public String ossUpload(@RequestParam("file") MultipartFile sourceFile, @RequestParam("userId") int id) {
        System.out.println(id);
        String endpoint = "*****";
        String accessKeyId = "***";
        String accessKeySecret = "***";
        String bucketName = "***";
        String filedir = "***";
        // 获取文件名
        String fileName = sourceFile.getOriginalFilename();
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //uuid生成主文件名
        String prefix = UUID.randomUUID().toString();
        String newFileName = prefix + suffix;
        File tempFile = null;
        try {
            //创建临时文件
            tempFile = File.createTempFile(prefix, prefix);
            // MultipartFile to File
            sourceFile.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, filedir + newFileName, tempFile);
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, filedir + newFileName, expiration);
        ossClient.shutdown();
        User user = userService.getUserById(id);
        user.setAvatar(url.toString());
        userService.updateUser(user);
        return url.toString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult getUserId(@PathVariable("id") int id){
        User user=userService.getUserById(id);
        return ResponseResult.success(user);
    }

    @PutMapping("/nickname")
    public void updateAvatar(@RequestBody String renickname,int id){
        User user=userService.getUserById(id);
        user.setNickname(renickname);
        userService.updateUser(user);
    }

}
