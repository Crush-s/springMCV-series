package com.javacode2018.springmvcseries.dto;

import com.javacode2018.springmvcseries.pojo.ExperienceInfoDto;
import com.javacode2018.springmvcseries.pojo.UserInfoDto;
import com.javacode2018.springmvcseries.pojo.WorkInfoDto;
import lombok.Data;

import java.util.List;

/**
 * 用户信息
 */
@Data
public class UserDto {
    //个人基本信息
    private UserInfoDto userInfo;
    //工作信息
    private WorkInfoDto workInfo;
    //工作经验（0到n个）
    private List<ExperienceInfoDto> experienceInfos;
}
