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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.twelve.capital.greetings.service.service.ClpSerializer;
import com.twelve.capital.greetings.service.service.GreetingsMessageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neha.kakkar
 */
public class GreetingsMessageClp extends BaseModelImpl<GreetingsMessage>
	implements GreetingsMessage {
	public GreetingsMessageClp() {
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
	public long getPrimaryKey() {
		return _StatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _StatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getStatusId() {
		return _StatusId;
	}

	@Override
	public void setStatusId(long StatusId) {
		_StatusId = StatusId;

		if (_greetingsMessageRemoteModel != null) {
			try {
				Class<?> clazz = _greetingsMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusId", long.class);

				method.invoke(_greetingsMessageRemoteModel, StatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _Message;
	}

	@Override
	public void setMessage(String Message) {
		_Message = Message;

		if (_greetingsMessageRemoteModel != null) {
			try {
				Class<?> clazz = _greetingsMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_greetingsMessageRemoteModel, Message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getButton_color() {
		return _button_color;
	}

	@Override
	public void setButton_color(String button_color) {
		_button_color = button_color;

		if (_greetingsMessageRemoteModel != null) {
			try {
				Class<?> clazz = _greetingsMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setButton_color", String.class);

				method.invoke(_greetingsMessageRemoteModel, button_color);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGreetingsMessageRemoteModel() {
		return _greetingsMessageRemoteModel;
	}

	public void setGreetingsMessageRemoteModel(
		BaseModel<?> greetingsMessageRemoteModel) {
		_greetingsMessageRemoteModel = greetingsMessageRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _greetingsMessageRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_greetingsMessageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GreetingsMessageLocalServiceUtil.addGreetingsMessage(this);
		}
		else {
			GreetingsMessageLocalServiceUtil.updateGreetingsMessage(this);
		}
	}

	@Override
	public GreetingsMessage toEscapedModel() {
		return (GreetingsMessage)ProxyUtil.newProxyInstance(GreetingsMessage.class.getClassLoader(),
			new Class[] { GreetingsMessage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GreetingsMessageClp clone = new GreetingsMessageClp();

		clone.setStatusId(getStatusId());
		clone.setMessage(getMessage());
		clone.setButton_color(getButton_color());

		return clone;
	}

	@Override
	public int compareTo(GreetingsMessage greetingsMessage) {
		long primaryKey = greetingsMessage.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GreetingsMessageClp)) {
			return false;
		}

		GreetingsMessageClp greetingsMessage = (GreetingsMessageClp)obj;

		long primaryKey = greetingsMessage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{StatusId=");
		sb.append(getStatusId());
		sb.append(", Message=");
		sb.append(getMessage());
		sb.append(", button_color=");
		sb.append(getButton_color());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.twelve.capital.greetings.service.model.GreetingsMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>StatusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>button_color</column-name><column-value><![CDATA[");
		sb.append(getButton_color());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _StatusId;
	private String _Message;
	private String _button_color;
	private BaseModel<?> _greetingsMessageRemoteModel;
}