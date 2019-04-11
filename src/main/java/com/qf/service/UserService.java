package com.qf.service;

import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

import java.util.List;

/**
 * Created by DELL on 2019/3/27.
 */
public interface UserService {

    public boolean loginCheck(UserInfo userInfo);

    public boolean addUserInfo(UserInfo userInfo) throws Exception;

    public List<UserInfo> getUserInfosBy(UserInfo userInfo);

    public boolean updateUserInfo(UserInfo userInfo);

    public int getCount(UserInfoVo userInfoVo);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);
}
