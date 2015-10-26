package com.twelve.capital.internal.news.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.NoSuchTagException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class InternalNewsPortletAction extends MVCPortlet {

	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		String jspPage = "/html/admin/allNews.jsp";
		if (Validator.isNotNull(cmd)) {
			if (cmd.equalsIgnoreCase("createNews")) {
				jspPage = request.getParameter("jspPage");
			}
			if (cmd.equalsIgnoreCase("editNews")) {
				jspPage = request.getParameter("jspPage");
				request.setAttribute("articleId",
						request.getParameter("articleId"));
			}
		}
		if (Validator.isNull(cmd)) {
			request.setAttribute("internalNewsList",
					fetchInternalNewsList(request, response));

		}
		include(jspPage, request, response);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String cmd = actionRequest.getParameter("cmd");
		if (cmd.equalsIgnoreCase("createnews")) {
			try {
				createNews(actionRequest, actionResponse);
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cmd.equalsIgnoreCase("deleteArticle")){
			try {
				deleteArtcile(actionRequest,actionResponse);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void deleteArtcile(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException {
		// TODO Auto-generated method stub
		long articalId = Long.parseLong(actionRequest.getParameter("articleId"));
		/*System.out.println("----- articleId " + articalId);*/
		
		List<JournalArticle> newsArticles=JournalArticleLocalServiceUtil.getArticlesByResourcePrimKey(articalId);
		/*System.out.println("------ got list of articles" + newsArticles != null ? newsArticles.size() : null);*/
		for(JournalArticle newsArticle : newsArticles) {
			//Delete entry from AssetEntry table
			JournalArticleResource journalArticleResource = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(newsArticle.getResourcePrimKey());
			if(null != journalArticleResource) {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), journalArticleResource.getResourcePrimKey());
				if(null != assetEntry) {
					AssetEntryLocalServiceUtil.deleteAssetEntry(assetEntry.getEntryId());
				}
			}
			//Delete entry from JournalArticle 
			JournalArticleLocalServiceUtil.deleteJournalArticle(newsArticle.getId());
		}
	}

	private void updateNews(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		// TODO Auto-generated method stub

	}

	private void createNews(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {
		// TODO Auto-generated method stub
		Map<Integer, Integer> monthMap = new TreeMap<Integer, Integer>();
		for(int i=0; i<12;i++) {
			monthMap.put(i+1, i);
		}
				
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String newsTitle = actionRequest.getParameter("newsTitle");
		String newsDescription = actionRequest.getParameter("newsDescription");
		String newsLocation = actionRequest.getParameter("newsLocation");
		String newsArticleEditURL = actionRequest.getParameter("articleURL");

		final String[] tagNames = { "internal-news" };
		final String[] tagProperties = new String[0]; // Might be null too
		final String[] assetTagsIds = new String[tagNames.length];
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				JournalArticle.class.getName(), actionRequest);
		for (int i = 0; i < tagNames.length; i++) {
			final String tagName = tagNames[i];
			AssetTag newsTag = null;
			try {
				newsTag = AssetTagLocalServiceUtil.getTag(
						themeDisplay.getScopeGroupId(), tagName);

			} catch (final NoSuchTagException e) {
				newsTag = AssetTagLocalServiceUtil.addTag(
						themeDisplay.getUserId(), tagName, tagProperties,
						serviceContext);
			}
			assetTagsIds[i] = newsTag.getName();
		}
		
		serviceContext.setAssetTagNames(assetTagsIds);
		
		/*System.out.println("Input Parameters---" + "--Title--" + newsTitle
				+ "--description---" + newsDescription + "---location--"
				+ newsLocation + "--articleURL--" + newsArticleEditURL); */
		Locale defaultLocale = LocaleUtil.US;
		Map<Locale, String> titleMap = new HashMap<Locale, String>();

		titleMap.put(defaultLocale, newsTitle);

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

		descriptionMap.put(defaultLocale, newsDescription);

		Calendar expirycalendar = Calendar.getInstance();
		expirycalendar.setTime(new Date());
		expirycalendar.add(Calendar.YEAR, 1);
		//expirycalendar.add(Calendar.MONTH,   -1);

		Calendar displayCalendar = Calendar.getInstance();
		displayCalendar.setTime(new Date());
		/*displayCalendar.add(Calendar.MONTH, 1);*/

		Date newsDisplayDate = displayCalendar.getTime();
		Date newsExpirationDate = expirycalendar.getTime();

		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
		/*System.out.println("Current Date--"
				+ newsDisplayDate
				+ "Display Date---Month---"
				+ Integer.parseInt(monthFormat.format(newsDisplayDate)
						.toString()) + "---Day--"
				+ dayFormat.format(newsDisplayDate) + "---year--"
				+ yearFormat.format(newsDisplayDate)); */
		//To fix the issue of display month, monthMap is used
		int displayMonth = monthMap.get(Integer.parseInt(monthFormat.format(newsDisplayDate).toString()));
		int expirationMonth = monthMap.get(Integer.parseInt(monthFormat.format(newsExpirationDate).toString()));
		
		if (Validator.isNull(actionRequest.getParameter("articleId"))) {
			JournalArticle newsArticle = null;
			newsArticle = JournalArticleLocalServiceUtil.addArticle(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					0, 0, 0, StringPool.BLANK, true, 1.0, titleMap,
					descriptionMap, "<p>" + newsDescription + "</p>", "news",
					null, null, null, displayMonth, Integer
							.parseInt(dayFormat.format(newsDisplayDate)
									.toString()), Integer.parseInt(yearFormat
							.format(newsDisplayDate).toString()), Integer
							.parseInt(hourFormat.format(newsDisplayDate)
									.toString()), Integer.parseInt(minuteFormat
							.format(newsDisplayDate).toString()), Integer
							.parseInt(monthFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(dayFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(yearFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(hourFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(minuteFormat.format(newsExpirationDate)
									.toString()), false, expirationMonth, Integer.parseInt(dayFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(yearFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(hourFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(minuteFormat.format(newsExpirationDate)
									.toString()), true, true, false, null,
					null, null, newsArticleEditURL, serviceContext);
			
			newsArticle.setExpandoBridgeAttributes(serviceContext);

		}
		if (Validator.isNotNull(actionRequest.getParameter("articleId"))) {
			JournalArticle newsArticle = JournalArticleLocalServiceUtil
					.getArticle(Long.parseLong(actionRequest
							.getParameter("articleId")));
			double newsArticleVersion =newsArticle.getVersion();
			newsArticle = JournalArticleServiceUtil.updateArticle(
					themeDisplay.getScopeGroupId(),
					0, newsArticle.getArticleId(), newsArticleVersion, titleMap,
					descriptionMap, "<p>" + newsDescription + "</p>", "news",
					null, null, null,
					 		displayMonth, Integer
							.parseInt(dayFormat.format(newsDisplayDate)
									.toString()), Integer.parseInt(yearFormat
							.format(newsDisplayDate).toString()), Integer
							.parseInt(hourFormat.format(newsDisplayDate)
									.toString()), Integer.parseInt(minuteFormat
							.format(newsDisplayDate).toString()), expirationMonth, Integer.parseInt(dayFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(yearFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(hourFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(minuteFormat.format(newsExpirationDate)
									.toString()), false, Integer
							.parseInt(monthFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(dayFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(yearFormat.format(newsExpirationDate)
									.toString()), Integer.parseInt(hourFormat
							.format(newsExpirationDate).toString()), Integer
							.parseInt(minuteFormat.format(newsExpirationDate)
									.toString()), 
					true, true, false, null,
					null, null, newsArticleEditURL, serviceContext);
			newsArticle.setExpandoBridgeAttributes(serviceContext);
			
		}

		
	}

	private List<JournalArticle> fetchInternalNewsList(RenderRequest request,
			RenderResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

		try {
			long[] anyTagIds = AssetTagLocalServiceUtil.getTagIds(
					themeDisplay.getScopeGroupId(),
					new String[] { "internal-news" });
			assetEntryQuery.addAllTagIdsArray(anyTagIds);
			
			List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil .getEntries(assetEntryQuery);
			for (AssetEntry ae : assetEntryList) {
				JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil
						.getJournalArticleResource(ae.getClassPK());
				JournalArticle journalArticleObj = JournalArticleLocalServiceUtil
						.getArticle(themeDisplay.getScopeGroupId(),
								journalArticleResourceObj.getArticleId());
				journalArticleList.add(journalArticleObj);
			}
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			System.out.println("Error While Searching for JOurnal Article"
					+ e.getMessage());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			System.out.println("Error While Searching for JOurnal Article"
					+ e.getMessage());
		}
		return journalArticleList;
	}
}
