package com.github.therycn.tycountdownapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

/**
 * Yearly event.
 * 
 * @author THERY
 *
 */
@Entity
@DiscriminatorValue("YEARLY")
@Getter
public class YearlyEvent extends Event {

    /** Serial version. */
    private static final long serialVersionUID = -8410523048743090260L;

    @Column(name = "EVT_MONTH")
    private int month;

    @Column(name = "EVT_DAY")
    private int day;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.github.therycn.tycountdownapi.entity.Event#getNextFireDateTime(java.
     * time.LocalDateTime)
     */
    @Override
    public LocalDateTime getNextFireDateTime(LocalDateTime now) {
        LocalDateTime nextFireDateTime = LocalDateTime.of(now.getYear(), getMonth(), getDay(), 0, 0);
        if (now.isAfter(nextFireDateTime)) {
            nextFireDateTime = nextFireDateTime.plusYears(1);
        }

        return nextFireDateTime;
    }

}
