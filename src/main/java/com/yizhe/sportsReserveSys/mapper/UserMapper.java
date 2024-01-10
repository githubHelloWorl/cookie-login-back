package com.yizhe.sportsReserveSys.mapper;

import com.yizhe.sportsReserveSys.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author Administrator
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2024-01-05 15:41:28
* @Entity com.yizhe.sportsReserveSys.model.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




