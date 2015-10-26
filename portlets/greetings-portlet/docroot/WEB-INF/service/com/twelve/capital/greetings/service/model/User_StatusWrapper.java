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

package com.twelve.capital.greetings.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link User_Status}.
 * </p>
 *
 * @author neha.kakkar
 * @see User_Status
 * @generated
 */
public class User_StatusWrapper implements User_Status,
	ModelWrapper<User_Status> {
	public User_StatusWrapper(User_Status user_Status) {
		_user_Status = user_Status;
	}

	@Override
	public Class<?> getModelClass() {
		return User_Status.class;
	}

	@Override
	public String getModelClassName() {
		return User_Status.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("UserId", getUserId());
		attributes.put("StatusId", getStatusId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long UserId = (Long)attributes.get("UserId");

		if (UserId != null) {
			setUserId(UserId);
		}

		Long StatusId = (Long)attributes.get("StatusId");

		if (StatusId != null) {
			setStatusId(StatusId);
		}
	}

	/**
	* Returns the primary key of this user_ status.
	*
	* @return the primary key of this user_ status
	*/
	@Override
	public long getPrimaryKey() {
		return _user_Status.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user_ status.
	*
	* @param primaryKey the primary key of this user_ status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_user_Status.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user_ status.
	*
	* @return the user ID of this user_ status
	*/
	@Override
	public long getUserId() {
		return _user_Status.getUserId();
	}

	/**
	* Sets the user ID of this user_ status.
	*
	* @param UserId the user ID of this user_ status
	*/
	@Override
	public void setUserId(long UserId) {
		_user_Status.setUserId(UserId);
	}

	/**
	* Returns the user uuid of this user_ status.
	*
	* @return the user uuid of this user_ status
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_Status.getUserUuid();
	}

	/**
	* Sets the user uuid of this user_ status.
	*
	* @param UserUuid the user uuid of this user_ status
	*/
	@Override
	public void setUserUuid(java.lang.String UserUuid) {
		_user_Status.setUserUuid(UserUuid);
	}

	/**
	* Returns the status ID of this user_ status.
	*
	* @return the status ID of this user_ status
	*/
	@Override
	public long getStatusId() {
		return _user_Status.getStatusId();
	}

	/**
	* Sets the status ID of this user_ status.
	*
	* @param StatusId the status ID of this user_ status
	*/
	@Override
	public void setStatusId(long StatusId) {
		_user_Status.setStatusId(StatusId);
	}

	@Override
	public boolean isNew() {
		return _user_Status.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_user_Status.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _user_Status.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_user_Status.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _user_Status.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _user_Status.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_user_Status.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _user_Status.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_user_Status.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_user_Status.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_user_Status.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new User_StatusWrapper((User_Status)_user_Status.clone());
	}

	@Override
	public int compareTo(
		com.twelve.capital.greetings.service.model.User_Status user_Status) {
		return _user_Status.compareTo(user_Status);
	}

	@Override
	public int hashCode() {
		return _user_Status.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.twelve.capital.greetings.service.model.User_Status> toCacheModel() {
		return _user_Status.toCacheModel();
	}

	@Override
	public com.twelve.capital.greetings.service.model.User_Status toEscapedModel() {
		return new User_StatusWrapper(_user_Status.toEscapedModel());
	}

	@Override
	public com.twelve.capital.greetings.service.model.User_Status toUnescapedModel() {
		return new User_StatusWrapper(_user_Status.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _user_Status.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _user_Status.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_user_Status.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof User_StatusWrapper)) {
			return false;
		}

		User_StatusWrapper user_StatusWrapper = (User_StatusWrapper)obj;

		if (Validator.equals(_user_Status, user_StatusWrapper._user_Status)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public User_Status getWrappedUser_Status() {
		return _user_Status;
	}

	@Override
	public User_Status getWrappedModel() {
		return _user_Status;
	}

	@Override
	public void resetOriginalValues() {
		_user_Status.resetOriginalValues();
	}

	private User_Status _user_Status;
}