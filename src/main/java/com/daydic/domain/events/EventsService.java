package com.daydic.domain.events;

import com.daydic.domain.users.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by megap on 2017-05-13.
 */

@Slf4j
@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public List<Events> findAllEventsList() {
        return eventsRepository.findAll();
    }

    public List<Events> findEvents(Long eid) {
        List<Events> list = new LinkedList<Events>();
        list.add(eventsRepository.findOne(eid));
        return list;
    }
}
