package com.yizhe.sportsReserveSys.model.dto.message;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 留言信息表
 * @TableName message
 */
@TableName(value ="message")
@Data
public class MessagePost implements Serializable {
    /**
     * 留言ID
     */
    @TableId(type = IdType.AUTO)
    private Integer message_id;

    /**
     * 用户ID
     */
    private Long user_id;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}