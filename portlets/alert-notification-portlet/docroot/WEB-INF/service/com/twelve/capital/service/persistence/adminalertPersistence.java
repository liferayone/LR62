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

package com.twelve.capital.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.twelve.capital.model.adminalert;

/**
 * The persistence interface for the adminalert service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see adminalertPersistenceImpl
 * @see adminalertUtil
 * @generated
 */
public interface adminalertPersistence extends BasePersistence<adminalert> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link adminalertUtil} to access the adminalert persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the adminalert in the entity cache if it is enabled.
	*
	* @param adminalert the adminalert
	*/
	public void cacheResult(com.twelve.capital.model.adminalert adminalert);

	/**
	* Caches the adminalerts in the entity cache if it is enabled.
	*
	* @param adminalerts the adminalerts
	*/
	public void cacheResult(
		java.util.List<com.twelve.capital.model.adminalert> adminalerts);

	/**
	* Creates a new adminalert with the primary key. Does not add the adminalert to the database.
	*
	* @param alertId the primary key for the new adminalert
	* @return the new adminalert
	*/
	public com.twelve.capital.model.adminalert create(long alertId);

	/**
	* Removes the adminalert with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param alertId the primary key of the adminalert
	* @return the adminalert that was removed
	* @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.model.adminalert remove(long alertId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.NoSuchadminalertException;

	public com.twelve.capital.model.adminalert updateImpl(
		com.twelve.capital.model.adminalert adminalert)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the adminalert with the primary key or throws a {@link com.twelve.capital.NoSuchadminalertException} if it could not be found.
	*
	* @param alertId the primary key of the adminalert
	* @return the adminalert
	* @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.model.adminalert findByPrimaryKey(long alertId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.twelve.capital.NoSuchadminalertException;

	/**
	* Returns the adminalert with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param alertId the primary key of the adminalert
	* @return the adminalert, or <code>null</code> if a adminalert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.twelve.capital.model.adminalert fetchByPrimaryKey(long alertId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the adminalerts.
	*
	* @return the adminalerts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.twelve.capital.model.adminalert> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the adminalerts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.model.impl.adminalertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adminalerts
	* @param end the upper bound of the range of adminalerts (not inclusive)
	* @return the range of adminalerts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.twelve.capital.model.adminalert> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the adminalerts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.model.impl.adminalertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of adminalerts
	* @param end the upper bound of the range of adminalerts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of adminalerts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.twelve.capital.model.adminalert> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the adminalerts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of adminalerts.
	*
	* @return the number of adminalerts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}