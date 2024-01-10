package com.yizhe.sportsReserveSys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhe.sportsReserveSys.model.dto.venue.AddVenue;
import com.yizhe.sportsReserveSys.model.dto.venue.UpdateVenue;
import com.yizhe.sportsReserveSys.model.entity.Venue;
import com.yizhe.sportsReserveSys.model.vo.VenueListVO;
import com.yizhe.sportsReserveSys.service.VenueService;
import com.yizhe.sportsReserveSys.mapper.VenueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【venue(体育场馆信息表)】的数据库操作Service实现
* @createDate 2024-01-05 15:41:28
*/
@Service
public class VenueServiceImpl extends ServiceImpl<VenueMapper, Venue>
    implements VenueService{

    @Resource
    private VenueMapper venueMapper;

    @Override
    public List<VenueListVO> getList() {
        List<VenueListVO> venueListVO = venueMapper.getList();
        return venueListVO;
    }

    @Override
    public AddVenue addVenue( AddVenue addVenue) {

        Venue venue = new Venue();
        venue.setVenue_id(addVenue.getVenue_id());
        venue.setVenue_name(addVenue.getVenue_name());
        venue.setVenue_type(addVenue.getVenue_type());
        venue.setFee(addVenue.getFee());
        venue.setLocation(addVenue.getLocation());
        venue.setFacilities(addVenue.getFacilities());

        int n =  venueMapper.insert(venue);
        if (n > 0) return addVenue;
        return new AddVenue();

    }

    @Override
    public int updateVenue(Venue updateVenue) {

        String type = updateVenue.getVenue_type();
        String name = updateVenue.getVenue_name();
        String facilities = updateVenue.getFacilities();
        Double fee = updateVenue.getFee();
        String location = updateVenue.getLocation();

        UpdateWrapper<Venue> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("venue_name", name).eq("venue_type",type);
        updateWrapper.set("facilities", facilities).eq("venue_type",type);
        updateWrapper.set("fee", fee).eq("venue_type",type);
        updateWrapper.set("location", location).eq("venue_type",type);


        return venueMapper.update(null, updateWrapper);
    }

    @Override
    public int deleVenue(String venueType) {

        QueryWrapper<Venue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("venue_type", venueType);

        return venueMapper.delete(queryWrapper);
    }

}




