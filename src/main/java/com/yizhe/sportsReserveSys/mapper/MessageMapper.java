package com.yizhe.sportsReserveSys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yizhe.sportsReserveSys.model.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【message(留言信息表)】的数据库操作Mapper
 * @createDate 2024-01-05 15:41:28
 * @Entity com.yizhe.sportsReserveSys.model.entity.Message
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    @Select("SELECT * FROM sportsreservesys.message")
    List<Message> selectAllPost();
    //Message selectAllPost();
}




