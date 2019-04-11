package com.qf.controller;

import com.qf.dto.UserInfoDto;
import com.qf.pojo.UserInfo;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.tools.Md5Utils;
import com.qf.tools.SplitePageBean;
import com.qf.vo.AddUserInfoVo;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/3/28.
 */
@Controller
public class MyController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    public String test(@Valid @RequestBody  AddUserInfoVo addUserInfoVo,BindingResult result, ModelMap ma){
        System.out.println("inner test");
        System.out.println(addUserInfoVo);
        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println(error.getField() + "*" + error.getDefaultMessage());
                ma.put(error.getCode(),error.getObjectName());
            }
        }

        return ma.toString();
    }

    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody UserInfo userInfo) throws Exception {
        boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        flag = this.userService.addUserInfo(userInfo);
        return flag;
    }

    @ResponseBody
    @RequestMapping(value = "clearSession",method = RequestMethod.GET)
    public void clearSession(HttpSession httpSession){
        httpSession.removeAttribute("userInfo");
        System.out.println("clear over");
    }

    @ResponseBody
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody UserInfo userInfo,HttpSession httpSession){
        Boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        System.out.println("username="+userInfo.getUsername()+",password="+userInfo.getPassword());
        //登录成功以后将用户名和密码保存到session中
        flag = userService.loginCheck(userInfo);
        if(flag){
            //登录成功,保存
            httpSession.setAttribute("userInfo",userInfo);
        }
        return flag.toString();
    }

    @ResponseBody
    @RequestMapping(value = "userInfoList",method = RequestMethod.POST)
    public Object userInfoList(@RequestBody(required = false) UserInfoVo userInfoVo){
        //查询并返回UserInfoDto对象
        System.out.println(userInfoVo);
        //当前是第几页、每页多少行
//        UserInfoVo???
        List<UserInfo> userInfoList = this.userService.getUserInfosPageBy(userInfoVo);
//        System.out.println(userInfoList.toString()+"11111");
        //返回集合
        //返回页面
        SplitePageBean splitePageBean = new SplitePageBean();
        int count = this.userService.getCount(userInfoVo);
        splitePageBean.setCurrentPage(userInfoVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setDataCount(count);
        splitePageBean.setPageCount(count%2==0?count/2:count/2+1);
        UserInfoDto dto = new UserInfoDto();
        dto.setUserInfoList(userInfoList);
        dto.setSplitePageBean(splitePageBean);
        return dto;
    }

//    updateUserInfo
    @ResponseBody
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public Object updateUserInfo(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        if(userInfo.getUserId()==0){
            return false+"";
        }
        boolean flag = this.userService.updateUserInfo(userInfo);
        return flag;
    }

    @ResponseBody
    @RequestMapping(value = "testGetPramEncodeing",method = RequestMethod.GET)
    public Object testGetPramEncodeing(@RequestParam String username){
        System.out.println(username);
        return username;
    }

    @ResponseBody
    @RequestMapping(value = "/pathVariableDemo/{username}-{password}")
    public Object pathVariableDemo(@PathVariable String username,@PathVariable String password){
        System.out.println(username+":"+password);
        return username+":"+password;
    }

    @ResponseBody
    @RequestMapping(value = "/getCookieValue")
    public Object getCookieValue(@CookieValue String name,@CookieValue int age){
        System.out.println(name+":"+age);
        return name+":"+age;
    }

    @ResponseBody
    @RequestMapping(value = "/fileUpload1")
    public Object fileUpload1(@RequestParam("uploadFile")CommonsMultipartFile uploadFile) throws IOException {
        //定义文件路径
        String path="E:/"+new Date().getTime()+uploadFile.getOriginalFilename();
        File destFile = new File(path);
        uploadFile.transferTo(destFile);
        return "上传成功";
    }

    @RequestMapping("/testDownload")
    public ResponseEntity<byte[]> download() throws IOException {
        //创建文件
        File file = new File("D://a.txt");
        byte[] body = null;
        //创建输入流(从硬盘读取数据)
        InputStream is = new FileInputStream(file);
        //创建字节数组并指定长度
        body = new byte[is.available()];
        //将数据从输入流导到输出流
        is.read(body);
        //创建响应头并设置指定值
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置HTTP响应状态。
        HttpStatus statusCode = HttpStatus.OK;
        //创建响应实体对象
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @RequestMapping(value = "thymeleafTestOne",method = RequestMethod.GET)
    public Object thymeleafTestOne(ModelAndView modelAndView){
        UserInfo userInfo = new UserInfo();
        ExtendedModelMap extendedModelMap;
        userInfo.setUsername("陈柯旭");
        userInfo.setPassword("123456");
        userInfo.setEmail("haha@163.com");
        userInfo.setName(null);
        modelAndView.addObject("userinfo",userInfo);
        modelAndView.addObject("val",null);
        modelAndView.addObject("flag",true);
        modelAndView.setViewName("thymeleafdemo1");
        return modelAndView;
    }
}