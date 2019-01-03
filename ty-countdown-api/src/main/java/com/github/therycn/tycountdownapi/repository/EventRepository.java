package com.github.therycn.tycountdownapi.repository;

import java.util.List;

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

    List<Event> findByType(EventType type);

}
