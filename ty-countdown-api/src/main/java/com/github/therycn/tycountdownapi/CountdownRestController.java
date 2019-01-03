package com.github.therycn.tycountdownapi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.therycn.tycountdownapi.entity.Countdown;
import com.github.therycn.tycountdownapi.entity.Event;
import com.github.therycn.tycountdownapi.entity.EventNextFireDateTime;
import com.github.therycn.tycountdownapi.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

/**
 * Countdown Rest Controller.
 * 
 * @author THERY
 *
 */
@Api
@RestController
@RequestMapping("/countdown")
@AllArgsConstructor
public class CountdownRestController {

    private EventService eventService;

    @ApiOperation(value = "Find the next event countdown")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Countdown next() {
        LocalDateTime now = LocalDateTime.now();
        EventNextFireDateTime eventNextFireDateTime = eventService.findNext(now);
        return countdown(eventNextFireDateTime.getEvent(), eventNextFireDateTime.getNextFireDateTime(), now);
    }

    @ApiOperation(value = "Find the nexts event countdown")
    @RequestMapping(value = "/nexts", method = RequestMethod.GET)
    public List<Countdown> nexts() {
        LocalDateTime now = LocalDateTime.now();
        List<EventNextFireDateTime> eventNextFireDateTime = eventService.findNexts(now);
        return eventNextFireDateTime.stream().map(evt -> countdown(evt.getEvent(), evt.getNextFireDateTime(), now))
                .collect(Collectors.toList());
    }

    private Countdown countdown(Event event, LocalDateTime eventDateTime, LocalDateTime now) {
        LocalDateTime dateTime = LocalDateTime.from(now);

        long days = dateTime.until(eventDateTime, ChronoUnit.DAYS);
        dateTime = dateTime.plusDays(days);

        // long hours = dateTime.until(eventDateTime, ChronoUnit.HOURS);
        // dateTime = dateTime.plusHours(hours);
        //
        // long minutes = dateTime.until(eventDateTime, ChronoUnit.MINUTES);
        // dateTime = dateTime.plusMinutes(minutes);

        long seconds = dateTime.until(eventDateTime, ChronoUnit.SECONDS);

        return Countdown.builder().type(event.getType()).name(event.getName()).days(days).seconds(seconds).build();
    }

}
