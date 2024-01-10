package com.yizhe.sportsReserveSys.model.dto.venue;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 体育场馆信息表
 * @TableName venue
 */
@TableName(value ="venue")
@Data
public class UpdateVenue implements Serializable {

    /**
     * 场馆名称
     */
    private String venue_name;

    /**
     * 场馆类型
     */
    private String venue_type;

    /**
     * 场馆位置
     */
    private String location;

    /**
     * 场馆设施
     */
    private String facilities;

    /**
     * 场地费用
     */
    private Double fee;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
