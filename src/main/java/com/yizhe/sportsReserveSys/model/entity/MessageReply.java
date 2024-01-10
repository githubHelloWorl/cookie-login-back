package com.yizhe.sportsReserveSys.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 留言回复信息表
 * @TableName message_reply
 */
@TableName(value ="message_reply")
@Data
public class MessageReply implements Serializable {
    /**
     * 回复ID
     */
    @TableId(type = IdType.AUTO)
    private Integer message_reply_id;

    /**
     * 用户ID
     */
    private Long user_id;

    /**
     * 留言ID
     */
    private Integer message_id;

    /**
     * 留言回复
     */
    private String content_reply;

    /**
     * 回复时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MessageReply other = (MessageReply) that;
        return (this.getMessage_reply_id() == null ? other.getMessage_reply_id() == null : this.getMessage_reply_id().equals(other.getMessage_reply_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getMessage_id() == null ? other.getMessage_id() == null : this.getMessage_id().equals(other.getMessage_id()))
            && (this.getContent_reply() == null ? other.getContent_reply() == null : this.getContent_reply().equals(other.getContent_reply()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessage_reply_id() == null) ? 0 : getMessage_reply_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getMessage_id() == null) ? 0 : getMessage_id().hashCode());
        result = prime * result + ((getContent_reply() == null) ? 0 : getContent_reply().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", message_reply_id=").append(message_reply_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", message_id=").append(message_id);
        sb.append(", content_reply=").append(content_reply);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}