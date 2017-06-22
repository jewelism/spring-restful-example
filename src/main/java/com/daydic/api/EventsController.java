package com.daydic.api;

import com.daydic.domain.events.Events;
import com.daydic.domain.events.EventsService;
import com.daydic.domain.users.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by megap on 2017-05-13.
 */

@Slf4j //log
@Api(value = "EVENTS API", description = "DayDic.EVENTS Table API", basePath= "/api/events")
@RestController
@RequestMapping("/api/events")
public class EventsController {
    @Autowired
    EventsService eventsService;

    @ApiOperation(value = "eid로 공유행사목록조회 혹은 행사전체조회", notes = "행사목록조회 - eid로 조회, 파라미터가없으면 전체조회")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody
    List<Events> getEventsList(@RequestParam(value = "eid", defaultValue = "", required = false)Long eid) {
        if(eid==null){
            return eventsService.findAllEventsList();
        } else {
            return eventsService.findEvents(eid);
        }
    }
}
