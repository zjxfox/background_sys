package com.qf.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by DELL on 2019/4/2.
 */
public class AddUserInfoVo implements Serializable{
    //不能为空，最少6个字符，最多16字符
    @Length(min = 6,max = 16,message = "过于短小")
    String username;
    //不能为空，最少6个字符，最多16字符
    @Length(min = 6,max = 16,message = "过于短小")
    String password;
    //不能为空且不能为空字符串
    @NotBlank(message = "完全没有")
    String name;
    //不能为空，符合邮箱规则
    @Email(message = "邮箱不符合规则")
    String email;
    @Min(value = 0)
    @Max(value = 1)
    int status = 1;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddUserInfoVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
