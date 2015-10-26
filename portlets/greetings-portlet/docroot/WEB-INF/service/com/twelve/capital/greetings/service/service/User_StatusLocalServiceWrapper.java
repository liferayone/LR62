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
 * Provides a wrapper for {@link User_StatusLocalService}.
 *
 * @author neha.kakkar
 * @see User_StatusLocalService
 * @generated
 */
public class User_StatusLocalServiceWrapper implements User_StatusLocalService,
	ServiceWrapper<User_StatusLocalService> {
	public User_StatusLocalServiceWrapper(
		User_StatusLocalService user_StatusLocalService) {
		_user_StatusLocalService = user_StatusLocalService;
	}

	/**
	* Adds the user_ status to the database. Also notifies the appropriate model listeners.
	*
	* @param user_Status the user_ status
	* @return the user_ status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status addUser_Status(
		com.twelve.capital.greetings.service.model.User_Status user_Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.addUser_Status(user_Status);
	}

	/**
	* Creates a new user_ status with the primary key. Does not add the user_ status to the database.
	*
	* @param UserId the primary key for the new user_ status
	* @return the new user_ status
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status createUser_Status(
		long UserId) {
		return _user_StatusLocalService.createUser_Status(UserId);
	}

	/**
	* Deletes the user_ status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param UserId the primary key of the user_ status
	* @return the user_ status that was removed
	* @throws PortalException if a user_ status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status deleteUser_Status(
		long UserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.deleteUser_Status(UserId);
	}

	/**
	* Deletes the user_ status from the database. Also notifies the appropriate model listeners.
	*
	* @param user_Status the user_ status
	* @return the user_ status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status deleteUser_Status(
		com.twelve.capital.greetings.service.model.User_Status user_Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.deleteUser_Status(user_Status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _user_StatusLocalService.dynamicQuery();
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
		return _user_StatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _user_StatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _user_StatusLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _user_StatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _user_StatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.twelve.capital.greetings.service.model.User_Status fetchUser_Status(
		long UserId) throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.fetchUser_Status(UserId);
	}

	/**
	* Returns the user_ status with the primary key.
	*
	* @param UserId the primary key of the user_ status
	* @return the user_ status
	* @throws PortalException if a user_ status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status getUser_Status(
		long UserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.getUser_Status(UserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user_ statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_ statuses
	* @param end the upper bound of the range of user_ statuses (not inclusive)
	* @return the range of user_ statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.twelve.capital.greetings.service.model.User_Status> getUser_Statuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.getUser_Statuses(start, end);
	}

	/**
	* Returns the number of user_ statuses.
	*
	* @return the number of user_ statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUser_StatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.getUser_StatusesCount();
	}

	/**
	* Updates the user_ status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param user_Status the user_ status
	* @return the user_ status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.twelve.capital.greetings.service.model.User_Status updateUser_Status(
		com.twelve.capital.greetings.service.model.User_Status user_Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_StatusLocalService.updateUser_Status(user_Status);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _user_StatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_user_StatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _user_StatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateUserStatus(long userId, long statusId) {
		_user_StatusLocalService.updateUserStatus(userId, statusId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public User_StatusLocalService getWrappedUser_StatusLocalService() {
		return _user_StatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUser_StatusLocalService(
		User_StatusLocalService user_StatusLocalService) {
		_user_StatusLocalService = user_StatusLocalService;
	}

	@Override
	public User_StatusLocalService getWrappedService() {
		return _user_StatusLocalService;
	}

	@Override
	public void setWrappedService(
		User_StatusLocalService user_StatusLocalService) {
		_user_StatusLocalService = user_StatusLocalService;
	}

	private User_StatusLocalService _user_StatusLocalService;
}