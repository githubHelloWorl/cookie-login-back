package com.yizhe.sportsReserveSys.service;

import com.yizhe.sportsReserveSys.model.entity.MessageReply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【message_reply(留言回复信息表)】的数据库操作Service
* @createDate 2024-01-06 16:12:50
*/
public interface MessageReplyService extends IService<MessageReply> {

    MessageReply messageReply(int messageId, Long user_id, String contentReply);
}
