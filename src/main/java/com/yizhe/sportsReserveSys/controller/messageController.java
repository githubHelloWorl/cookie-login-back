package com.yizhe.sportsReserveSys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yizhe.sportsReserveSys.annotation.AuthCheck;
import com.yizhe.sportsReserveSys.common.BaseResponse;
import com.yizhe.sportsReserveSys.common.ResultUtils;
import com.yizhe.sportsReserveSys.constant.UserConstant;
import com.yizhe.sportsReserveSys.mapper.MessageMapper;
import com.yizhe.sportsReserveSys.model.entity.Message;
import com.yizhe.sportsReserveSys.model.entity.MessageReply;
import com.yizhe.sportsReserveSys.model.entity.User;
import com.yizhe.sportsReserveSys.service.MessageReplyService;
import com.yizhe.sportsReserveSys.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.yizhe.sportsReserveSys.constant.UserConstant.USER_LOGIN_STATE;


@RestController
@RequestMapping("/message")
@Slf4j
public class messageController {



    @Resource
    private MessageService messageService;
    @Resource
    private MessageReplyService messageReplyService;

    @Resource
    private MessageMapper messageMapper;

    @PostMapping("post")
    public BaseResponse<Integer> messagePost(String content, HttpServletRequest request){
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) obj;
        Long user_id = user.getId();

        int newPost = messageService.addPost(user_id, content);

        return ResultUtils.success(newPost);
    }


    @GetMapping("info")
    //@AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<Message>> messageGet(){

        List<Message> message = messageMapper.selectAllPost();

        return ResultUtils.success(message);
    }

    @PostMapping ("reply")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<MessageReply> messageReply(int message_id, String contentReply, HttpServletRequest request){
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) obj;
        Long user_id = user.getId();

        MessageReply newReply  = messageReplyService.messageReply(message_id, user_id, contentReply);

        return ResultUtils.success(newReply);


    }

    @PostMapping ("delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Message> messageDelete(int message_id){

        int n = messageMapper.deleteById(message_id);
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("message_id", message_id);
        Message deleteMessage = messageMapper.selectOne(queryWrapper);
        if(n > 0) return ResultUtils.success(deleteMessage);

        return ResultUtils.success(new Message());

    }



    //TODO 公告信息管理
    @PostMapping("postAdmin")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Integer> messagePostAdmin(String content, HttpServletRequest request){
        Object obj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) obj;
        Long user_id = user.getId();

        int newPost = messageService.addPost(user_id, content);

        return ResultUtils.success(newPost);


    }


}


