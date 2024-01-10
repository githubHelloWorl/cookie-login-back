package com.yizhe.sportsReserveSys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhe.sportsReserveSys.service.ReservationService;
import com.yizhe.sportsReserveSys.mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import com.yizhe.sportsReserveSys.model.dto.venue.ReserveVenue;
/**
* @author Administrator
* @description 针对表【reservation(预定信息表)】的数据库操作Service实现
* @createDate 2024-01-05 15:41:28
*/
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, ReserveVenue>
    implements ReservationService{

}




