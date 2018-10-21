package com.github.therycn.tycountdownapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Countdown.
 * 
 * @author THERY
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Countdown {

	private long days;

	private long hours;

	private long minutes;

	private long seconds;

}
