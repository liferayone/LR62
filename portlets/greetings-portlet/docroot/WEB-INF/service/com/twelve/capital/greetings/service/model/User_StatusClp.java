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
import com.liferay.portal.util.PortalUtil;

import com.twelve.capital.greetings.service.service.ClpSerializer;
import com.twelve.capital.greetings.service.service.User_StatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neha.kakkar
 */
public class User_StatusClp extends BaseModelImpl<User_Status>
	implements User_Status {
	public User_StatusClp() {
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
	public long getPrimaryKey() {
		return _UserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _UserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getUserId() {
		return _UserId;
	}

	@Override
	public void setUserId(long UserId) {
		_UserId = UserId;

		if (_user_StatusRemoteModel != null) {
			try {
				Class<?> clazz = _user_StatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_user_StatusRemoteModel, UserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _UserUuid);
	}

	@Override
	public void setUserUuid(String UserUuid) {
		_UserUuid = UserUuid;
	}

	@Override
	public long getStatusId() {
		return _StatusId;
	}

	@Override
	public void setStatusId(long StatusId) {
		_StatusId = StatusId;

		if (_user_StatusRemoteModel != null) {
			try {
				Class<?> clazz = _user_StatusRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusId", long.class);

				method.invoke(_user_StatusRemoteModel, StatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUser_StatusRemoteModel() {
		return _user_StatusRemoteModel;
	}

	public void setUser_StatusRemoteModel(BaseModel<?> user_StatusRemoteModel) {
		_user_StatusRemoteModel = user_StatusRemoteModel;
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

		Class<?> remoteModelClass = _user_StatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_user_StatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			User_StatusLocalServiceUtil.addUser_Status(this);
		}
		else {
			User_StatusLocalServiceUtil.updateUser_Status(this);
		}
	}

	@Override
	public User_Status toEscapedModel() {
		return (User_Status)ProxyUtil.newProxyInstance(User_Status.class.getClassLoader(),
			new Class[] { User_Status.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		User_StatusClp clone = new User_StatusClp();

		clone.setUserId(getUserId());
		clone.setStatusId(getStatusId());

		return clone;
	}

	@Override
	public int compareTo(User_Status user_Status) {
		long primaryKey = user_Status.getPrimaryKey();

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

		if (!(obj instanceof User_StatusClp)) {
			return false;
		}

		User_StatusClp user_Status = (User_StatusClp)obj;

		long primaryKey = user_Status.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{UserId=");
		sb.append(getUserId());
		sb.append(", StatusId=");
		sb.append(getStatusId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.twelve.capital.greetings.service.model.User_Status");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>UserId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>StatusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _UserId;
	private String _UserUuid;
	private long _StatusId;
	private BaseModel<?> _user_StatusRemoteModel;
}