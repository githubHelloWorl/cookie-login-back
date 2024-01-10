package com.yizhe.sportsReserveSys.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yizhe.sportsReserveSys.model.dto.venue.UpdateVenue;
import com.yizhe.sportsReserveSys.model.entity.Venue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yizhe.sportsReserveSys.model.vo.VenueListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Administrator
* @description 针对表【venue(体育场馆信息表)】的数据库操作Mapper
* @createDate 2024-01-05 15:41:28
* @Entity com.yizhe.sportsReserveSys.model.entity.Venue
*/
@Mapper
public interface VenueMapper extends BaseMapper<Venue> {

    @Select("SELECT * FROM sportsreservesys.venue")
    List<VenueListVO> getList();

}




