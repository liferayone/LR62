/**
 * 
 */
package com.twelve.capital.external.feed.util;

/**
 * @author Java
 *
 */
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.sun.syndication.feed.synd.SyndFeedImpl;

public class RSSUtil {
	public static ObjectValuePair<String, SyndFeedImpl> getFeed(String url) throws Exception {
		RSSWebCacheItem wci = new RSSWebCacheItem(url);
		
				return new ObjectValuePair<String, SyndFeedImpl>(
					url,
					(SyndFeedImpl)wci.convert(url));
			}
		
}
