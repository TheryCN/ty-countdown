package com.github.therycn.tycountdownapi.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.therycn.tycountdownapi.entity.Event;
import com.github.therycn.tycountdownapi.entity.EventNextFireDateTime;
import com.github.therycn.tycountdownapi.entity.EventType;
import com.github.therycn.tycountdownapi.repository.EventRepository;

/**
 * Event Service.
 * 
 * @author THERY
 *
 */
@Service
public class EventService {

    private EventRepository eventRepo;

    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    /**
     * Find event list by {@link EventType}.
     * 
     * @param type
     *            the event type
     * @return {@link Event} list
     */
    public List<Event> findByType(EventType type) {
        List<Event> event = eventRepo.findByType(type);

        if (!CollectionUtils.isEmpty(event)) {
            return event;
        }

        throw new EntityNotFoundException("No event found");
    }

    /**
     * Find the next event at the given date.
     * 
     * @param {@link
     *            LocalDateTime}
     * @return {@link Event} list
     */
    public EventNextFireDateTime findNext(LocalDateTime now) {
        List<EventNextFireDateTime> eventList = findNexts(now);

        if (!CollectionUtils.isEmpty(eventList)) {
            return eventList.get(0);
        }

        throw new EntityNotFoundException("No event found");
    }

    /**
     * Find the nexts event at the given date.
     * 
     * @param {@link
     *            LocalDateTime}
     * @return {@link Event} list
     */
    public List<EventNextFireDateTime> findNexts(LocalDateTime now) {
        List<EventNextFireDateTime> eventList = eventRepo.findAll().stream().map(evt -> to(evt, now))
                .filter(evt -> evt.getNextFireDateTime() != null).collect(Collectors.toList());
        eventList.sort(Comparator.comparing(evt -> evt.getNextFireDateTime()));

        return eventList;
    }

    private EventNextFireDateTime to(Event event, LocalDateTime now) {
        return EventNextFireDateTime.builder().event(event).nextFireDateTime(event.getNextFireDateTime(now)).build();
    }

}
