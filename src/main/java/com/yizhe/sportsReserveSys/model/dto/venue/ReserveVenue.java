package com.yizhe.sportsReserveSys.model.dto.venue;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.intellij.lang.annotations.Pattern;

/**
 * 预定信息表
 * @TableName reservation
 */
@TableName(value ="reservation")
@Data
public class ReserveVenue implements Serializable {
    /**
     * 预定ID
     */
    @TableId(type = IdType.AUTO)
    private Integer reservation_id;

    /**
     * 用户ID
     */
    private Long user_id;

    /**
     * 场馆ID
     */
    private Integer venue_id;

    /**
     * 预定日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    /**
     * 预定场馆类型
     */
    private String VenueType;

    /**
     * 预定时间
     */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date start_time;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date end_time;

    /**
     * 预定人数
     */
    private Integer number_of_people;

    /**
     * 预定状态
     */
    private Object status;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}