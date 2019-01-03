package com.github.therycn.tycountdownapi.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@DiscriminatorValue("DATED")
@Getter
public class DatedEvent extends Event {

    /** Serial version. */
    private static final long serialVersionUID = 3392429924562093257L;

    @Column(name = "EVT_DATE")
    private Date date;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.github.therycn.tycountdownapi.entity.Event#getNextFireDateTime(java.
     * time.LocalDateTime)
     */
    @Override
    public LocalDateTime getNextFireDateTime(LocalDateTime now) {
        LocalDateTime next = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return now.isBefore(next) ? next : null;
    }

}
