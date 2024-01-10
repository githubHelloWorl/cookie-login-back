package com.yizhe.sportsReserveSys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhe.sportsReserveSys.model.dto.message.MessagePost;
import com.yizhe.sportsReserveSys.model.entity.Message;
import com.yizhe.sportsReserveSys.service.MessageService;
import com.yizhe.sportsReserveSys.mapper.MessageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author Administrator
* @description 针对表【message(留言信息表)】的数据库操作Service实现
* @createDate 2024-01-05 15:41:28
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{


    @Resource
    private MessageMapper messageMapper;
    @Override
    public int addPost(Long userId, String content) {


        Message newPost = new Message();
        MessagePost messagePost = new MessagePost();
        newPost.setContent(content);
        newPost.setUser_id(userId);
        newPost.setCreateTime(new Date());

        //将 messagePost 对象中的属性值复制到 newPost 对象中
        BeanUtils.copyProperties(newPost,messagePost);
        if (messageMapper.insert(newPost) > 0) return 1;
        return 0;

    }
}




