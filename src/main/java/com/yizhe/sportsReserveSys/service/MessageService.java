package com.yizhe.sportsReserveSys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhe.sportsReserveSys.model.entity.Message;

/**
* @author Administrator
* @description 针对表【message(留言信息表)】的数据库操作Service
* @createDate 2024-01-05 15:41:28
*/
public interface MessageService extends IService<Message> {

    int addPost(Long userId, String content);
}
