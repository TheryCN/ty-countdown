package com.github.therycn.tycountdownapi.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;

/**
 * Event entity.
 * 
 * @author THERY
 *
 */
@Table(name = "EVENT")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "EVT_PERIODICITY")
@Getter
public abstract class Event extends AbstractEntity<Long> {

	/** Serial version. */
	private static final long serialVersionUID = -850686969756458480L;

	@Id
	@Column(name = "EVT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EVT_TYPE", unique = true)
	@Enumerated(EnumType.STRING)
	private EventType type;

	@Column(name = "EVT_PERIODICITY", insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private EventPeriodicityType periodicity;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.therycn.tycountdownapi.entity.AbstractEntity#getCreatedOn()
	 */
	@Column(name = "EVT_CREATED_ON")
	@Override
	public Date getCreatedOn() {
		return super.getCreatedOn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.therycn.tycountdownapi.entity.AbstractEntity#getUpdatedOn()
	 */
	@Column(name = "EVT_UPDATED_ON")
	@Override
	public Date getUpdatedOn() {
		return super.getUpdatedOn();
	}

	public abstract LocalDateTime getNextFireDateTime(LocalDateTime now);

}
