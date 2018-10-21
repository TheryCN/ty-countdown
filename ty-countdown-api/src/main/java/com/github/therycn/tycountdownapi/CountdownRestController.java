package com.github.therycn.tycountdownapi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.therycn.tycountdownapi.entity.Countdown;
import com.github.therycn.tycountdownapi.entity.Event;
import com.github.therycn.tycountdownapi.entity.EventType;
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

	@ApiOperation(value = "Find countdown before the given event type")
	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public Countdown countdown(@PathVariable EventType type) {
		Event event = eventService.findOne(type);

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime eventDateTime = event.getNextFireDateTime(now);

		LocalDateTime dateTime = LocalDateTime.from(now);

		long days = dateTime.until(eventDateTime, ChronoUnit.DAYS);
		dateTime = dateTime.plusDays(days);

		long hours = dateTime.until(eventDateTime, ChronoUnit.HOURS);
		dateTime = dateTime.plusHours(hours);

		long minutes = dateTime.until(eventDateTime, ChronoUnit.MINUTES);
		dateTime = dateTime.plusMinutes(minutes);

		long seconds = dateTime.until(eventDateTime, ChronoUnit.SECONDS);

		return Countdown.builder().days(days).hours(hours).minutes(minutes).seconds(seconds).build();
	}

}
