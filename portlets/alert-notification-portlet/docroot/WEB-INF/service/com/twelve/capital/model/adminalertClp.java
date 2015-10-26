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

package com.twelve.capital.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.twelve.capital.service.ClpSerializer;
import com.twelve.capital.service.adminalertLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author neha.kakkar
 */
public class adminalertClp extends BaseModelImpl<adminalert>
	implements adminalert {
	public adminalertClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return adminalert.class;
	}

	@Override
	public String getModelClassName() {
		return adminalert.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _alertId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlertId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _alertId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("alertId", getAlertId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("location", getLocation());
		attributes.put("resolution", getResolution());
		attributes.put("expectedResolutionTime", getExpectedResolutionTime());
		attributes.put("resolutionStatus", getResolutionStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long alertId = (Long)attributes.get("alertId");

		if (alertId != null) {
			setAlertId(alertId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String resolution = (String)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		Date expectedResolutionTime = (Date)attributes.get(
				"expectedResolutionTime");

		if (expectedResolutionTime != null) {
			setExpectedResolutionTime(expectedResolutionTime);
		}

		String resolutionStatus = (String)attributes.get("resolutionStatus");

		if (resolutionStatus != null) {
			setResolutionStatus(resolutionStatus);
		}
	}

	@Override
	public long getAlertId() {
		return _alertId;
	}

	@Override
	public void setAlertId(long alertId) {
		_alertId = alertId;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setAlertId", long.class);

				method.invoke(_adminalertRemoteModel, alertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_adminalertRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_adminalertRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_adminalertRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_adminalertRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResolution() {
		return _resolution;
	}

	@Override
	public void setResolution(String resolution) {
		_resolution = resolution;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setResolution", String.class);

				method.invoke(_adminalertRemoteModel, resolution);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpectedResolutionTime() {
		return _expectedResolutionTime;
	}

	@Override
	public void setExpectedResolutionTime(Date expectedResolutionTime) {
		_expectedResolutionTime = expectedResolutionTime;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedResolutionTime",
						Date.class);

				method.invoke(_adminalertRemoteModel, expectedResolutionTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResolutionStatus() {
		return _resolutionStatus;
	}

	@Override
	public void setResolutionStatus(String resolutionStatus) {
		_resolutionStatus = resolutionStatus;

		if (_adminalertRemoteModel != null) {
			try {
				Class<?> clazz = _adminalertRemoteModel.getClass();

				Method method = clazz.getMethod("setResolutionStatus",
						String.class);

				method.invoke(_adminalertRemoteModel, resolutionStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getadminalertRemoteModel() {
		return _adminalertRemoteModel;
	}

	public void setadminalertRemoteModel(BaseModel<?> adminalertRemoteModel) {
		_adminalertRemoteModel = adminalertRemoteModel;
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

		Class<?> remoteModelClass = _adminalertRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adminalertRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			adminalertLocalServiceUtil.addadminalert(this);
		}
		else {
			adminalertLocalServiceUtil.updateadminalert(this);
		}
	}

	@Override
	public adminalert toEscapedModel() {
		return (adminalert)ProxyUtil.newProxyInstance(adminalert.class.getClassLoader(),
			new Class[] { adminalert.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		adminalertClp clone = new adminalertClp();

		clone.setAlertId(getAlertId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLocation(getLocation());
		clone.setResolution(getResolution());
		clone.setExpectedResolutionTime(getExpectedResolutionTime());
		clone.setResolutionStatus(getResolutionStatus());

		return clone;
	}

	@Override
	public int compareTo(adminalert adminalert) {
		long primaryKey = adminalert.getPrimaryKey();

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

		if (!(obj instanceof adminalertClp)) {
			return false;
		}

		adminalertClp adminalert = (adminalertClp)obj;

		long primaryKey = adminalert.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{alertId=");
		sb.append(getAlertId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", expectedResolutionTime=");
		sb.append(getExpectedResolutionTime());
		sb.append(", resolutionStatus=");
		sb.append(getResolutionStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.twelve.capital.model.adminalert");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>alertId</column-name><column-value><![CDATA[");
		sb.append(getAlertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolution</column-name><column-value><![CDATA[");
		sb.append(getResolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedResolutionTime</column-name><column-value><![CDATA[");
		sb.append(getExpectedResolutionTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolutionStatus</column-name><column-value><![CDATA[");
		sb.append(getResolutionStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _alertId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _location;
	private String _resolution;
	private Date _expectedResolutionTime;
	private String _resolutionStatus;
	private BaseModel<?> _adminalertRemoteModel;
}