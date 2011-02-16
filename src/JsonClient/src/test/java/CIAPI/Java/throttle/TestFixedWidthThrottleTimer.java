package CIAPI.Java.throttle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFixedWidthThrottleTimer {
	private FixedWidthThrottleTimer timer;
	private long distance = 100;

	@Before
	public void setUp() throws Exception {
		timer = new FixedWidthThrottleTimer(distance);
	}

	@After
	public void tearDown() throws Exception {
		timer = null;
	}

	/**
	 * Tests that the throttle works...
	 */
	@Test
	public void testThrottle10ReqPerSecond() {
		int requestsMade = 0;
		long startTime = System.currentTimeMillis();
		// loop for 1 second
		while (System.currentTimeMillis() - startTime < 999) {
			if (timer.canMakeRequest()) {
				timer.madeRequest();
				requestsMade++;
			}
		}
		// TODO, should we allow a 1 request variance?
		assertEquals(10, requestsMade);
		requestsMade = 0;
		startTime = System.currentTimeMillis();
		// loop for 1 second
		while (System.currentTimeMillis() - startTime < 9999) {
			if (timer.canMakeRequest()) {
				timer.madeRequest();
				requestsMade++;
			}
		}
		assertEquals(100, requestsMade);
	}
}