package com.qf.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2019/4/2.
 */
public class AssignPermessionVo implements Serializable{
    int roleId;
    List<Integer> menuIds;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "AssignPermessionVo{" +
                "roleId=" + roleId +
                ", menuIds=" + menuIds +
                '}';
    }
}
