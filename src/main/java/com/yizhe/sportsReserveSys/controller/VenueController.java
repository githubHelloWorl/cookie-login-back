package com.yizhe.sportsReserveSys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yizhe.sportsReserveSys.common.BaseResponse;
import com.yizhe.sportsReserveSys.common.ErrorCode;
import com.yizhe.sportsReserveSys.common.ResultUtils;
import com.yizhe.sportsReserveSys.mapper.ReservationMapper;
import com.yizhe.sportsReserveSys.mapper.VenueMapper;
import com.yizhe.sportsReserveSys.model.dto.venue.AddVenue;
import com.yizhe.sportsReserveSys.model.dto.venue.ReserveVenue;
import com.yizhe.sportsReserveSys.model.entity.User;
import com.yizhe.sportsReserveSys.model.entity.Venue;
import com.yizhe.sportsReserveSys.model.vo.VenueListVO;
import com.yizhe.sportsReserveSys.service.VenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.yizhe.sportsReserveSys.constant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("/venue")
@Slf4j
public class VenueController {
    @Resource
    private VenueService venueService;

    @Resource
    private VenueMapper venueMapper;

    @Resource
    private ReservationMapper reservationMapper;

    /**
     * 获取所有球馆列表
     *
     * @return
     */
    @GetMapping("list")
    public BaseResponse<List<VenueListVO>> getVenueList() {

        List<VenueListVO> venueList = venueService.getList();

        return ResultUtils.success(venueList);
    }

    /**
     * 场馆增加
     *
     * @param addVenue
     * @return
     */
    @PostMapping("add")
    public BaseResponse<AddVenue> addVenue(@RequestBody AddVenue addVenue) {

        AddVenue newVenue = venueService.addVenue(addVenue);

        return ResultUtils.success(newVenue);
    }

    /**
     * 场馆详细信息查询
     *
     * @param venueType
     * @return
     */
    @PostMapping("view")
    public BaseResponse<Venue> viewVenue(String venueType) {
        QueryWrapper<Venue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("venue_type", venueType);
        Venue venue = venueMapper.selectOne(queryWrapper);
        return ResultUtils.success(venue);

    }


    /**
     * 场馆预定
     *
     * @param reserveVenue
     * @param request
     * @return
     */
    @PostMapping("reserve")
    public BaseResponse<ReserveVenue> venueReserve(@RequestBody ReserveVenue reserveVenue, HttpServletRequest request) {
        System.out.println("reserveVenue = " + reserveVenue);
        Object object = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) object;
        if (user == null) throw new RuntimeException("未登录");
        Long user_id = user.getId();

        String VenueType = reserveVenue.getVenueType();
        QueryWrapper<Venue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("venue_type", VenueType);
        Venue venue = venueMapper.selectOne(queryWrapper);
        int Venue_id = venue.getVenue_id();


        ReserveVenue newReserve = new ReserveVenue();
        newReserve.setUser_id(user_id);
        newReserve.setVenue_id(Venue_id);
        newReserve.setDate(reserveVenue.getDate());
        newReserve.setStart_time(reserveVenue.getStart_time());
        newReserve.setEnd_time(reserveVenue.getEnd_time());
        newReserve.setNumber_of_people(reserveVenue.getNumber_of_people());
        newReserve.setStatus(true);


        int n = reservationMapper.insert(newReserve);
        if (n > 0) {
            return ResultUtils.success(newReserve);
        } else {
            return ResultUtils.error(40000, String.valueOf(ErrorCode.PARAMS_ERROR));
        }
    }

    /**
     * 场馆修改
     *
     * @param updateVenue
     * @return
     */
    @PostMapping("update")
    public BaseResponse<Integer> updateVenue(@RequestBody Venue updateVenue) {

        int newVenue = venueService.updateVenue(updateVenue);

        return ResultUtils.success(newVenue);
    }


    /**
     * 场地删除
     *
     * @param venueType
     * @return
     */
    @PostMapping("delete")
    public BaseResponse<Integer> deleteVenue(String venueType) {

        int newVenue = venueService.deleVenue(venueType);

        return ResultUtils.success(newVenue);
    }
}
