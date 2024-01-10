package com.yizhe.sportsReserveSys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhe.sportsReserveSys.model.entity.MessageReply;
import com.yizhe.sportsReserveSys.service.MessageReplyService;
import com.yizhe.sportsReserveSys.mapper.MessageReplyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【message_reply(留言回复信息表)】的数据库操作Service实现
* @createDate 2024-01-06 16:12:50
*/
@Service
public class MessageReplyServiceImpl extends ServiceImpl<MessageReplyMapper, MessageReply>
    implements MessageReplyService{

    @Resource
    private MessageReplyMapper messageReplyMapper;
    @Override
    public MessageReply messageReply(int messageId, Long user_id, String contentReply) {

        MessageReply newReply = new MessageReply();
        newReply.setUser_id(user_id);
        newReply.setMessage_id(messageId);
        newReply.setContent_reply(contentReply);

        int n = messageReplyMapper.insert(newReply);
        if(n > 0)  return newReply;
        return new MessageReply();


    }
}




