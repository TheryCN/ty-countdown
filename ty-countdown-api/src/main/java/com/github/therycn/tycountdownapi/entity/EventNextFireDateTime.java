package com.github.therycn.tycountdownapi.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Event with next fire date time.
 * 
 * @author TheryLeopard
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventNextFireDateTime {

    private Event event;

    private LocalDateTime nextFireDateTime;

}
