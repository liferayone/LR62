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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GreetingsMessageLocalService}.
 *
 * @author neha.kakkar
 * @see GreetingsMessageLocalService
 * @generated
 */
public class GreetingsMessageLocalServiceWrapper
	implements GreetingsMessageLocalService,
		ServiceWrapper<GreetingsMessageLocalService> {
	public GreetingsMessageLocalServiceWrapper(
		GreetingsMessageLocalService greetingsMessageLocalService) {
		_greetingsMessageLocalService = greetingsMessageLocalService;
	}

	/**
	* Adds the greetings message to the database. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage addGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.addGreetingsMessage(greetingsMessage);
	}

	/**
	* Creates a new greetings message with the primary key. Does not add the greetings message to the database.
	*
	* @param StatusId the primary key for the new greetings message
	* @return the new greetings message
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage createGreetingsMessage(
		long StatusId) {
		return _greetingsMessageLocalService.createGreetingsMessage(StatusId);
	}

	/**
	* Deletes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message that was removed
	* @throws PortalException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage deleteGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.deleteGreetingsMessage(StatusId);
	}

	/**
	* Deletes the greetings message from the database. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage deleteGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.deleteGreetingsMessage(greetingsMessage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _greetingsMessageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage fetchGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.fetchGreetingsMessage(StatusId);
	}

	/**
	* Returns the greetings message with the primary key.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message
	* @throws PortalException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage getGreetingsMessage(
		long StatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.getGreetingsMessage(StatusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> getGreetingsMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.getGreetingsMessages(start, end);
	}

	/**
	* Returns the number of greetings messages.
	*
	* @return the number of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGreetingsMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.getGreetingsMessagesCount();
	}

	/**
	* Updates the greetings message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param greetingsMessage the greetings message
	* @return the greetings message that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage updateGreetingsMessage(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _greetingsMessageLocalService.updateGreetingsMessage(greetingsMessage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _greetingsMessageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_greetingsMessageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _greetingsMessageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GreetingsMessageLocalService getWrappedGreetingsMessageLocalService() {
		return _greetingsMessageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGreetingsMessageLocalService(
		GreetingsMessageLocalService greetingsMessageLocalService) {
		_greetingsMessageLocalService = greetingsMessageLocalService;
	}

	@Override
	public GreetingsMessageLocalService getWrappedService() {
		return _greetingsMessageLocalService;
	}

	@Override
	public void setWrappedService(
		GreetingsMessageLocalService greetingsMessageLocalService) {
		_greetingsMessageLocalService = greetingsMessageLocalService;
	}

	private GreetingsMessageLocalService _greetingsMessageLocalService;
}