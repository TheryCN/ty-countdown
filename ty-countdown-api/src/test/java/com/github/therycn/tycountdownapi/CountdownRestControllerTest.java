package com.github.therycn.tycountdownapi;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.therycn.tycountdownapi.entity.Countdown;

/**
 * Test class {@link CountdownRestController}.
 * 
 * @author THERY
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CountdownRestControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Test countdown birthday.
	 */
	@Test
	public void testCountdownBirthday() {
		// Given
		// When
		ResponseEntity<Countdown> response = restTemplate.getForEntity("/countdown/BIRTHDAY", Countdown.class);
		// Then
		Assert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
	}
}
