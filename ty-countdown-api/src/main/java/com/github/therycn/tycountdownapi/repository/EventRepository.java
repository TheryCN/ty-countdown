package com.github.therycn.tycountdownapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.therycn.tycountdownapi.entity.Event;
import com.github.therycn.tycountdownapi.entity.EventType;

/**
 * Event Repository.
 * 
 * @author THERY
 *
 */
public interface EventRepository extends JpaRepository<Event, Long> {

	Event findByType(EventType type);
}
