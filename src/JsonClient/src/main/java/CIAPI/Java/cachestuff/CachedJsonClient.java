package CIAPI.Java.cachestuff;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.httpstuff.DefaultSimpleHttpClient;
import CIAPI.Java.httpstuff.SimpleHttpClient;
import CIAPI.Java.logging.Log;

/**
 * An implementation of JsonClient that caches results of GET requests.
 * 
 * @author justin nelson
 * 
 */
public class CachedJsonClient extends DefaultJsonClient {

	private Cache<Pair<String, Class<?>>, Object> cache;

	/**
	 * Creates a new JsonClient with the given cache
	 * 
	 * @param cache
	 *            the cache to use
	 */
	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache) {
		this(cache, new DefaultSimpleHttpClient());
	}

	/**
	 * Creates a Cached Json Client with the given cache and the given Simple
	 * Http client for making requests
	 * 
	 * @param cache
	 *            the cache to use
	 * @param client
	 *            the http client to use
	 */
	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache, SimpleHttpClient client) {
		super(client);
		this.cache = cache;
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		Object cacheResult = cache.get(new Pair<String, Class<?>>(url, clazz));
		if (cacheResult == null) {
			Object getResult = super.makeGetRequest(url, clazz);
			cache.put(new Pair<String, Class<?>>(url, clazz), getResult);
			return getResult;
		} else {
			Log.debug("Cache hit for url: " + url);
			return cacheResult;
		}
	}

	/**
	 * Simple pair class
	 * 
	 * @author justin nelson
	 * 
	 * @param <T>
	 * @param <S>
	 */
	public static class Pair<T, S> {
		/**
		 * Item 1
		 */
		public final T one;
		/**
		 * Item 2
		 */
		public final S two;

		/**
		 * Creates a new pair with the given data
		 * 
		 * @param t
		 *            item 1
		 * @param s
		 *            item 2
		 */
		public Pair(T t, S s) {
			one = t;
			two = s;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((one == null) ? 0 : one.hashCode());
			result = prime * result + ((two == null) ? 0 : two.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (one == null) {
				if (other.one != null)
					return false;
			} else if (!one.equals(other.one))
				return false;
			if (two == null) {
				if (other.two != null)
					return false;
			} else if (!two.equals(other.two))
				return false;
			return true;
		}
	}
}