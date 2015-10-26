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

import com.liferay.portal.service.persistence.BasePersistence;

import com.twelve.capital.greetings.service.model.GreetingsMessage;

/**
 * The persistence interface for the greetings message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see GreetingsMessagePersistenceImpl
 * @see GreetingsMessageUtil
 * @generated
 */
public interface GreetingsMessagePersistence extends BasePersistence<GreetingsMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GreetingsMessageUtil} to access the greetings message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the greetings message in the entity cache if it is enabled.
	*
	* @param greetingsMessage the greetings message
	*/
	public void cacheResult(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage);

	/**
	* Caches the greetings messages in the entity cache if it is enabled.
	*
	* @param greetingsMessages the greetings messages
	*/
	public void cacheResult(
		java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> greetingsMessages);

	/**
	* Creates a new greetings message with the primary key. Does not add the greetings message to the database.
	*
	* @param StatusId the primary key for the new greetings message
	* @return the new greetings message
	*/
	public com.twelve.capital.greetings.service.model.GreetingsMessage create(
		long StatusId);

	/**
	* Removes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message that was removed
	* @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.greetings.service.model.GreetingsMessage remove(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchGreetingsMessageException;

	public com.twelve.capital.greetings.service.model.GreetingsMessage updateImpl(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the greetings message with the primary key or throws a {@link com.twelve.capital.greetings.service.NoSuchGreetingsMessageException} if it could not be found.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message
	* @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.greetings.service.model.GreetingsMessage findByPrimaryKey(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.greetings.service.NoSuchGreetingsMessageException;

	/**
	* Returns the greetings message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param StatusId the primary key of the greetings message
	* @return the greetings message, or <code>null</code> if a greetings message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.greetings.service.model.GreetingsMessage fetchByPrimaryKey(
		long StatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the greetings messages.
	*
	* @return the greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.twelve.capital.greetings.service.model.GreetingsMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the greetings messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of greetings messages.
	*
	* @return the number of greetings messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}