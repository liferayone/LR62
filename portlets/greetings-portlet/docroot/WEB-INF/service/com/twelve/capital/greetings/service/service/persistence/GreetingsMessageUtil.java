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

import com.twelve.capital.greetings.service.model.GreetingsMessage;

import java.util.List;

/**
 * The persistence utility for the greetings message service. This utility wraps {@link GreetingsMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see GreetingsMessagePersistence
 * @see GreetingsMessagePersistenceImpl
 * @generated
 */
public class GreetingsMessageUtil {
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
	public static void clearCache(GreetingsMessage greetingsMessage) {
		getPersistence().clearCache(greetingsMessage);
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
	public static List<GreetingsMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GreetingsMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GreetingsMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GreetingsMessage update(GreetingsMessage greetingsMessage)
		throws SystemException {
		return getPersistence().update(greetingsMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GreetingsMessage update(GreetingsMessage greetingsMessage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(greetingsMessage, serviceContext);
	}

	/**
	* Caches the greetings message in the entity cache if it is enabled.
	*
	* @param greetingsMessage the greetings message
	*/
	public static void cacheResult(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage) {
		getPersistence().cacheResult(greetingsMessage);
	}

	/**
	* Caches the greetings messages in the entity cache if it is enabled.
	*
	* @param greetingsMessages the greetings messages
	*/
	public static void cacheResult(
		java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> greetingsMessages) {
		getPersistence().cacheResult(greetingsMessages);
	}

	/**
	* Creates a new greetings message with the primary key. Does not add the greetings message to the database.
	*
	* @param StatusId the primary key for the new greetings message
	* @return the new greetings message
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage create(
		long StatusId) {
		return getPersistence().create(StatusId);
	}

	/**
	* Removes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message that was removed
	* @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage remove(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchGreetingsMessageException {
		return getPersistence().remove(StatusId);
	}

	public static com.twelve.capital.greetings.service.model.GreetingsMessage updateImpl(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(greetingsMessage);
	}

	/**
	* Returns the greetings message with the primary key or throws a {@link com.twelve.capital.greetings.service.NoSuchGreetingsMessageException} if it could not be found.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message
	* @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage findByPrimaryKey(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchGreetingsMessageException {
		return getPersistence().findByPrimaryKey(StatusId);
	}

	/**
	* Returns the greetings message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message, or <code>null</code> if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.twelve.capital.greetings.service.model.GreetingsMessage fetchByPrimaryKey(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(StatusId);
	}

	/**
	* Returns all the greetings messages.
	*
	* @return the greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the greetings messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of greetings messages
	* @param end the upper bound of the range of greetings messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the greetings messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of greetings messages.
	*
	* @return the number of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GreetingsMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GreetingsMessagePersistence)PortletBeanLocatorUtil.locate(com.twelve.capital.greetings.service.service.ClpSerializer.getServletContextName(),
					GreetingsMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(GreetingsMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GreetingsMessagePersistence persistence) {
	}

	private static GreetingsMessagePersistence _persistence;
}