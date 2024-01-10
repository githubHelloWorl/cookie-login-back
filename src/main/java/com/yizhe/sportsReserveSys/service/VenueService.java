package com.yizhe.sportsReserveSys.service;

import com.yizhe.sportsReserveSys.model.dto.venue.AddVenue;
import com.yizhe.sportsReserveSys.model.dto.venue.UpdateVenue;
import com.yizhe.sportsReserveSys.model.entity.Venue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhe.sportsReserveSys.model.vo.VenueListVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【venue(体育场馆信息表)】的数据库操作Service
* @createDate 2024-01-05 15:41:28
*/
public interface VenueService extends IService<Venue> {

    List<VenueListVO> getList();

    AddVenue addVenue(AddVenue addVenue);

    int updateVenue(Venue updateVenue);

    int deleVenue(String venueType);
}
