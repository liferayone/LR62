/**
 * 
 */
package com.twelve.capital.external.feed.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Java
 *
 */
public class ExternalFeedAction extends MVCPortlet {

	public void getAutoFieldsData(ActionRequest actionRequest,ActionResponse response)
			throws Exception {
		System.out.println("=============getAutoFieldsData==");
		String phonesIndexesString = actionRequest.getParameter("phonesIndexes");
		System.out.println("=============phonesIndexesString=="+phonesIndexesString);
		int[] phonesIndexes = StringUtil.split(phonesIndexesString, 0);

		for (int phonesIndex : phonesIndexes) {
			String number = ParamUtil.getString(actionRequest, "externalFeedUrl" + phonesIndex);
			System.out.println("=============phoneNumber=="+number);
			int typeId = ParamUtil.getInteger(actionRequest, "phoneTypeId" + phonesIndex);
			System.out.println("=============typeId=="+typeId);

		}
	}
}
