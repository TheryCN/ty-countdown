package com.github.therycn.tycountdownapi.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.github.therycn.tycountdownapi.entity.Event;
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
	 * Find one event by {@link EventType}.
	 * 
	 * @param type
	 *            the event type
	 * @return {@link Event}
	 */
	public Event findOne(EventType type) {
		Event event = eventRepo.findByType(type);

		if (event == null) {
			throw new EntityNotFoundException("Event not found");
		}

		return event;
	}

}
