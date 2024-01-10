package com.yizhe.sportsReserveSys.model.vo;

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
public class VenueListVO implements Serializable {
    /**
     * 场馆ID
     */
    @TableId(type = IdType.AUTO)
    private Integer venue_id;

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
        com.yizhe.sportsReserveSys.model.entity.Venue other = (com.yizhe.sportsReserveSys.model.entity.Venue) that;
        return (this.getVenue_id() == null ? other.getVenue_id() == null : this.getVenue_id().equals(other.getVenue_id()))
                && (this.getVenue_name() == null ? other.getVenue_name() == null : this.getVenue_name().equals(other.getVenue_name()))
                && (this.getVenue_type() == null ? other.getVenue_type() == null : this.getVenue_type().equals(other.getVenue_type()))
                && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
                && (this.getFacilities() == null ? other.getFacilities() == null : this.getFacilities().equals(other.getFacilities()))
                && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
                && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
                && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVenue_id() == null) ? 0 : getVenue_id().hashCode());
        result = prime * result + ((getVenue_name() == null) ? 0 : getVenue_name().hashCode());
        result = prime * result + ((getVenue_type() == null) ? 0 : getVenue_type().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getFacilities() == null) ? 0 : getFacilities().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", venue_id=").append(venue_id);
        sb.append(", venue_name=").append(venue_name);
        sb.append(", venue_type=").append(venue_type);
        sb.append(", location=").append(location);
        sb.append(", facilities=").append(facilities);
        sb.append(", fee=").append(fee);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
