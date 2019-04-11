package com.qf.service;

import com.qf.dto.RoleInfoDto;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
public interface RoleService {
    public List<RoleInfoDto> getRoleByUserId(int userId);
}
