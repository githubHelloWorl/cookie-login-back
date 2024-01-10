package com.yizhe.sportsReserveSys.mapper;

import com.yizhe.sportsReserveSys.model.dto.venue.ReserveVenue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【reservation(预定信息表)】的数据库操作Mapper
* @createDate 2024-01-05 15:41:28
* @Entity com.yizhe.sportsReserveSys.model.entity.Reservation
*/
@Mapper
public interface ReservationMapper extends BaseMapper<ReserveVenue> {

}




