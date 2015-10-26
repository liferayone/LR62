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
 * This class is a wrapper for {@link GreetingsMessage}.
 * </p>
 *
 * @author neha.kakkar
 * @see GreetingsMessage
 * @generated
 */
public class GreetingsMessageWrapper implements GreetingsMessage,
	ModelWrapper<GreetingsMessage> {
	public GreetingsMessageWrapper(GreetingsMessage greetingsMessage) {
		_greetingsMessage = greetingsMessage;
	}

	@Override
	public Class<?> getModelClass() {
		return GreetingsMessage.class;
	}

	@Override
	public String getModelClassName() {
		return GreetingsMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("StatusId", getStatusId());
		attributes.put("Message", getMessage());
		attributes.put("button_color", getButton_color());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long StatusId = (Long)attributes.get("StatusId");

		if (StatusId != null) {
			setStatusId(StatusId);
		}

		String Message = (String)attributes.get("Message");

		if (Message != null) {
			setMessage(Message);
		}

		String button_color = (String)attributes.get("button_color");

		if (button_color != null) {
			setButton_color(button_color);
		}
	}

	/**
	* Returns the primary key of this greetings message.
	*
	* @return the primary key of this greetings message
	*/
	@Override
	public long getPrimaryKey() {
		return _greetingsMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this greetings message.
	*
	* @param primaryKey the primary key of this greetings message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_greetingsMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the status ID of this greetings message.
	*
	* @return the status ID of this greetings message
	*/
	@Override
	public long getStatusId() {
		return _greetingsMessage.getStatusId();
	}

	/**
	* Sets the status ID of this greetings message.
	*
	* @param StatusId the status ID of this greetings message
	*/
	@Override
	public void setStatusId(long StatusId) {
		_greetingsMessage.setStatusId(StatusId);
	}

	/**
	* Returns the message of this greetings message.
	*
	* @return the message of this greetings message
	*/
	@Override
	public java.lang.String getMessage() {
		return _greetingsMessage.getMessage();
	}

	/**
	* Sets the message of this greetings message.
	*
	* @param Message the message of this greetings message
	*/
	@Override
	public void setMessage(java.lang.String Message) {
		_greetingsMessage.setMessage(Message);
	}

	/**
	* Returns the button_color of this greetings message.
	*
	* @return the button_color of this greetings message
	*/
	@Override
	public java.lang.String getButton_color() {
		return _greetingsMessage.getButton_color();
	}

	/**
	* Sets the button_color of this greetings message.
	*
	* @param button_color the button_color of this greetings message
	*/
	@Override
	public void setButton_color(java.lang.String button_color) {
		_greetingsMessage.setButton_color(button_color);
	}

	@Override
	public boolean isNew() {
		return _greetingsMessage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_greetingsMessage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _greetingsMessage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_greetingsMessage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _greetingsMessage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _greetingsMessage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_greetingsMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _greetingsMessage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_greetingsMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_greetingsMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_greetingsMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GreetingsMessageWrapper((GreetingsMessage)_greetingsMessage.clone());
	}

	@Override
	public int compareTo(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage) {
		return _greetingsMessage.compareTo(greetingsMessage);
	}

	@Override
	public int hashCode() {
		return _greetingsMessage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.twelve.capital.greetings.service.model.GreetingsMessage> toCacheModel() {
		return _greetingsMessage.toCacheModel();
	}

	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage toEscapedModel() {
		return new GreetingsMessageWrapper(_greetingsMessage.toEscapedModel());
	}

	@Override
	public com.twelve.capital.greetings.service.model.GreetingsMessage toUnescapedModel() {
		return new GreetingsMessageWrapper(_greetingsMessage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _greetingsMessage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _greetingsMessage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_greetingsMessage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GreetingsMessageWrapper)) {
			return false;
		}

		GreetingsMessageWrapper greetingsMessageWrapper = (GreetingsMessageWrapper)obj;

		if (Validator.equals(_greetingsMessage,
					greetingsMessageWrapper._greetingsMessage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GreetingsMessage getWrappedGreetingsMessage() {
		return _greetingsMessage;
	}

	@Override
	public GreetingsMessage getWrappedModel() {
		return _greetingsMessage;
	}

	@Override
	public void resetOriginalValues() {
		_greetingsMessage.resetOriginalValues();
	}

	private GreetingsMessage _greetingsMessage;
}