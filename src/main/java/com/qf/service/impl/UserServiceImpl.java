package com.qf.service.impl;

import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserService;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DELL on 2019/3/27.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserInfoMapper userInfoMapper;

    public boolean loginCheck(UserInfo userInfo) {
        if(userInfoMapper.loginCheck(userInfo)!=null){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean addUserInfo(UserInfo userInfo) throws RuntimeException {
        int count = this.userInfoMapper.addUserInfo(userInfo);
//        if(true){
//            throw new NegativeArraySizeException();
//        }
//        int count1 = this.userInfoMapper.addUserInfo(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    public List<UserInfo> getUserInfosBy(UserInfo userInfo){
        return this.userInfoMapper.getUserInfosBy(userInfo);
    }

    public boolean updateUserInfo(UserInfo userInfo){
        boolean flag = false;
        if(this.userInfoMapper.updateUserInfo(userInfo)>0){
            flag = true;
        }
        return flag;
    }

    public int getCount(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getCount(userInfoVo);
    }

    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getUserInfosPageBy(userInfoVo);
    }
}
