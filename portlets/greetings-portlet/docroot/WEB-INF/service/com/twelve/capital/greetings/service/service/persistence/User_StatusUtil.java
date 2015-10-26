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

package com.twelve.capital.greetings.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.twelve.capital.greetings.service.model.User_Status;

import java.util.List;

/**
 * The persistence utility for the user_ status service. This utility wraps {@link User_StatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see User_StatusPersistence
 * @see User_StatusPersistenceImpl
 * @generated
 */
public class User_StatusUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(User_Status user_Status) {
		getPersistence().clearCache(user_Status);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<User_Status> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<User_Status> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<User_Status> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static User_Status update(User_Status user_Status)
		throws SystemException {
		return getPersistence().update(user_Status);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static User_Status update(User_Status user_Status,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(user_Status, serviceContext);
	}

	/**
	* Caches the user_ status in the entity cache if it is enabled.
	*
	* @param user_Status the user_ status
	*/
	public static void cacheResult(
		com.twelve.capital.greetings.service.model.User_Status user_Status) {
		getPersistence().cacheResult(user_Status);
	}

	/**
	* Caches the user_ statuses in the entity cache if it is enabled.
	*
	* @param user_Statuses the user_ statuses
	*/
	public static void cacheResult(
		java.util.List<com.twelve.capital.greetings.service.model.User_Status> user_Statuses) {
		getPersistence().cacheResult(user_Statuses);
	}

	/**
	* Creates a new user_ status with the primary key. Does not add the user_ status to the database.
	*
	* @param UserId the primary key for the new user_ status
	* @return the new user_ status
	*/
	public static com.twelve.capital.greetings.service.model.User_Status create(
		long UserId) {
		return getPersistence().create(UserId);
	}

	/**
	* Removes the user_ status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param UserId the primary key of the user_ status
	* @return the user_ status that was removed
	* @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.User_Status remove(
		long UserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchUser_StatusException {
		return getPersistence().remove(UserId);
	}

	public static com.twelve.capital.greetings.service.model.User_Status updateImpl(
		com.twelve.capital.greetings.service.model.User_Status user_Status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(user_Status);
	}

	/**
	* Returns the user_ status with the primary key or throws a {@link com.twelve.capital.greetings.service.NoSuchUser_StatusException} if it could not be found.
	*
	* @param UserId the primary key of the user_ status
	* @return the user_ status
	* @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.User_Status findByPrimaryKey(
		long UserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchUser_StatusException {
		return getPersistence().findByPrimaryKey(UserId);
	}

	/**
	* Returns the user_ status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param UserId the primary key of the user_ status
	* @return the user_ status, or <code>null</code> if a user_ status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.User_Status fetchByPrimaryKey(
		long UserId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(UserId);
	}

	/**
	* Returns all the user_ statuses.
	*
	* @return the user_ statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.twelve.capital.greetings.service.model.User_Status> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.twelve.capital.greetings.service.model.User_Status> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user_ statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_ statuses
	* @param end the upper bound of the range of user_ statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user_ statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.twelve.capital.greetings.service.model.User_Status> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user_ statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user_ statuses.
	*
	* @return the number of user_ statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static User_StatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (User_StatusPersistence)PortletBeanLocatorUtil.locate(com.twelve.capital.greetings.service.service.ClpSerializer.getServletContextName(),
					User_StatusPersistence.class.getName());

			ReferenceRegistry.registerReference(User_StatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(User_StatusPersistence persistence) {
	}

	private static User_StatusPersistence _persistence;
}