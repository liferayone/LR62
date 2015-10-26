/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.twelve.capital.greetings.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GreetingsMessage. This utility wraps
 * {@link com.twelve.capital.greetings.service.service.impl.GreetingsMessageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author neha.kakkar
 * @see GreetingsMessageLocalService
 * @see com.twelve.capital.greetings.service.service.base.GreetingsMessageLocalServiceBaseImpl
 * @see com.twelve.capital.greetings.service.service.impl.GreetingsMessageLocalServiceImpl
 * @generated
 */
public class GreetingsMessageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.twelve.capital.greetings.service.service.impl.GreetingsMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the greetings message to the database. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage addGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGreetingsMessage(greetingsMessage);
	}

	/**
	* Creates a new greetings message with the primary key. Does not add the greetings message to the database.
	*
	* @param StatusId the primary key for the new greetings message
	* @return the new greetings message
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage createGreetingsMessage(
		long StatusId) {
		return getService().createGreetingsMessage(StatusId);
	}

	/**
	* Deletes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message that was removed
	* @throws PortalException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage deleteGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGreetingsMessage(StatusId);
	}

	/**
	* Deletes the greetings message from the database. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage deleteGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGreetingsMessage(greetingsMessage);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.twelve.capital.greetings.service.model.GreetingsMessage fetchGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGreetingsMessage(StatusId);
	}

	/**
	* Returns the greetings message with the primary key.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message
	* @throws PortalException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage getGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGreetingsMessage(StatusId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the greetings messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of greetings messages
	* @param end the upper bound of the range of greetings messages (not inclusive)
	* @return the range of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> getGreetingsMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGreetingsMessages(start, end);
	}

	/**
	* Returns the number of greetings messages.
	*
	* @return the number of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public static int getGreetingsMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGreetingsMessagesCount();
	}

	/**
	* Updates the greetings message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage updateGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGreetingsMessage(greetingsMessage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static GreetingsMessageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GreetingsMessageLocalService.class.getName());

			if (invokableLocalService instanceof GreetingsMessageLocalService) {
				_service = (GreetingsMessageLocalService)invokableLocalService;
			}
			else {
				_service = new GreetingsMessageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GreetingsMessageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GreetingsMessageLocalService service) {
	}

	private static GreetingsMessageLocalService _service;
}