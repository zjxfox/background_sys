package com.qf.mapper;

import com.qf.dto.RoleInfoDto;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
public interface RoleInfoMapper {

    public List<RoleInfoDto> getRoleByUserId(int userId);
}
