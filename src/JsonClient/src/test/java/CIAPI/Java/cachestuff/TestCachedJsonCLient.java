package CIAPI.Java.cachestuff;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.ApiException;
import CIAPI.Java.cachestuff.CachedJsonClient.Pair;

public class TestCachedJsonCLient {

	private long maxAge = 200;
	private Cache<Pair<String, Class<?>>, Object> cache;
	private CachedJsonClient client;

	@Before
	public void setUp() throws Exception {
		cache = new DefaultCache<Pair<String, Class<?>>, Object>(maxAge);
		cache.put(new Pair<String, Class<?>>("http://fakeUrl1", String.class), "result1");
		cache.put(new Pair<String, Class<?>>("http://fakeUrl2", String.class), "result2");
		cache.put(new Pair<String, Class<?>>("http://fakeUrl3", String.class), "result3");
		client = new CachedJsonClient(cache);
	}

	@After
	public void tearDown() throws Exception {
		cache = null;
	}

	/**
	 * Tests that we can retrieve items from the cache.
	 * 
	 * @throws ApiException
	 */
	@Test
	public void testBasicCachedStuff() throws ApiException {
		String result1 = (String) client.makeGetRequest("http://fakeUrl1", String.class, true);
		assertEquals("result1", result1);
		String result2 = (String) client.makeGetRequest("http://fakeUrl2", String.class, true);
		assertEquals("result2", result2);
		String result3 = (String) client.makeGetRequest("http://fakeUrl3", String.class, true);
		assertEquals("result3", result3);
		String result4 = (String) client.makeGetRequest("http://fakeUrl4", String.class, true);
		assertNull("There should be no result for this url.", result4);
	}

	@Test
	public void testCacheExpires() throws ApiException {
		String result1 = (String) client.makeGetRequest("http://fakeUrl1", String.class, true);
		assertEquals("result1", result1);
		try {
			Thread.sleep(maxAge + 1);
		} catch (InterruptedException e) {
			fail();
		}
		String result2 = (String) client.makeGetRequest("http://fakeUrl1", String.class, true);
		assertNull("The cached should have expired and be null.", result2);
	}
}