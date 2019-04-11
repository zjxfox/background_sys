package com.qf.mapper;

import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

import java.util.List;

/**
 * Created by DELL on 2019/3/27.
 */
public interface UserInfoMapper {

    public UserInfo loginCheck(UserInfo userInfo);

    public int addUserInfo(UserInfo userInfo);

    public List<UserInfo> getUserInfosBy(UserInfo userInfo);

    public int updateUserInfo(UserInfo userInfo);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(UserInfoVo userInfoVo);
}
