package com.twelve.capital.external.feed.util;


import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
//import com.liferay.portal.security.lang.DoPrivilegedBean;
//import com.liferay.portal.util.HttpImpl;
//import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class RSSWebCacheItem {
	
	public RSSWebCacheItem(String url) {
		_url = url;
	}

	public Object convert(String key) throws Exception {
		SyndFeed feed = null;

		try {

			// com.liferay.portal.kernel.util.HttpUtil will break the connection
			// if it spends more than 5 seconds looking up a location. However,
			// German umlauts do not get encoded correctly. This may be a bug
			// with commons-httpclient or with how FeedParser uses
			// java.io.Reader.

			// Use http://xml.newsisfree.com/feeds/29/629.xml and
			// http://test.domosoft.com/up/RSS to test if German umlauts show up
			// correctly.

			/*Reader reader = new StringReader(
				new String(HttpUtil.URLtoByteArray(_url)));

			channel = FeedParser.parse(builder, reader);*/

			HttpImpl httpImpl = new HttpImpl();

//			Object httpObject = HttpUtil.getHttp();
//
//			/*if (httpObject instanceof DoPrivilegedBean) {
//				DoPrivilegedBean doPrivilegedBean =
//					(DoPrivilegedBean)httpObject;
//
//				httpImpl = (HttpImpl)doPrivilegedBean.getActualBean();
//			}
//			else {*/
//				httpImpl = (HttpImpl)httpObject;
			/*}*/

			HostConfiguration hostConfiguration = httpImpl.getHostConfiguration(
				_url);
			/*System.out.println("###### Got hostConfiguration " + hostConfiguration);*/
			HttpClient httpClient = httpImpl.getClient(hostConfiguration);

			httpImpl.proxifyState(httpClient.getState(), hostConfiguration);

			HttpClientParams httpClientParams = httpClient.getParams();

			httpClientParams.setConnectionManagerTimeout(
				PropsValues.RSS_CONNECTION_TIMEOUT);
			httpClientParams.setSoTimeout(PropsValues.RSS_CONNECTION_TIMEOUT);

			GetMethod getMethod = new GetMethod(
				httpImpl.encodeParameters(_url));
			/*System.out.println("###### Got getMethod " + getMethod);*/
			httpClient.executeMethod(hostConfiguration, getMethod);

			SyndFeedInput input = new SyndFeedInput();

			feed = input.build(
				new XmlReader(getMethod.getResponseBodyAsStream()));
			/*System.out.println("#### Got feed " + feed);*/
		}
		catch (Exception e) {
			/*throw new WebCacheException(_url + " " + e.toString());*/
			//System.out.println("Got exception " + e.getMessage());
			throw e;
		}

		return feed;
	}

	public long getRefreshTime() {
		return _REFRESH_TIME;
	}

	private final long _REFRESH_TIME = Time.MINUTE * 20;

	private static String _url;
	
}