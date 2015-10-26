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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link adminalert}.
 * </p>
 *
 * @author neha.kakkar
 * @see adminalert
 * @generated
 */
public class adminalertWrapper implements adminalert, ModelWrapper<adminalert> {
	public adminalertWrapper(adminalert adminalert) {
		_adminalert = adminalert;
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

	/**
	* Returns the primary key of this adminalert.
	*
	* @return the primary key of this adminalert
	*/
	@Override
	public long getPrimaryKey() {
		return _adminalert.getPrimaryKey();
	}

	/**
	* Sets the primary key of this adminalert.
	*
	* @param primaryKey the primary key of this adminalert
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adminalert.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the alert ID of this adminalert.
	*
	* @return the alert ID of this adminalert
	*/
	@Override
	public long getAlertId() {
		return _adminalert.getAlertId();
	}

	/**
	* Sets the alert ID of this adminalert.
	*
	* @param alertId the alert ID of this adminalert
	*/
	@Override
	public void setAlertId(long alertId) {
		_adminalert.setAlertId(alertId);
	}

	/**
	* Returns the group ID of this adminalert.
	*
	* @return the group ID of this adminalert
	*/
	@Override
	public long getGroupId() {
		return _adminalert.getGroupId();
	}

	/**
	* Sets the group ID of this adminalert.
	*
	* @param groupId the group ID of this adminalert
	*/
	@Override
	public void setGroupId(long groupId) {
		_adminalert.setGroupId(groupId);
	}

	/**
	* Returns the create date of this adminalert.
	*
	* @return the create date of this adminalert
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _adminalert.getCreateDate();
	}

	/**
	* Sets the create date of this adminalert.
	*
	* @param createDate the create date of this adminalert
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_adminalert.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this adminalert.
	*
	* @return the modified date of this adminalert
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _adminalert.getModifiedDate();
	}

	/**
	* Sets the modified date of this adminalert.
	*
	* @param modifiedDate the modified date of this adminalert
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adminalert.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the location of this adminalert.
	*
	* @return the location of this adminalert
	*/
	@Override
	public java.lang.String getLocation() {
		return _adminalert.getLocation();
	}

	/**
	* Sets the location of this adminalert.
	*
	* @param location the location of this adminalert
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_adminalert.setLocation(location);
	}

	/**
	* Returns the resolution of this adminalert.
	*
	* @return the resolution of this adminalert
	*/
	@Override
	public java.lang.String getResolution() {
		return _adminalert.getResolution();
	}

	/**
	* Sets the resolution of this adminalert.
	*
	* @param resolution the resolution of this adminalert
	*/
	@Override
	public void setResolution(java.lang.String resolution) {
		_adminalert.setResolution(resolution);
	}

	/**
	* Returns the expected resolution time of this adminalert.
	*
	* @return the expected resolution time of this adminalert
	*/
	@Override
	public java.util.Date getExpectedResolutionTime() {
		return _adminalert.getExpectedResolutionTime();
	}

	/**
	* Sets the expected resolution time of this adminalert.
	*
	* @param expectedResolutionTime the expected resolution time of this adminalert
	*/
	@Override
	public void setExpectedResolutionTime(java.util.Date expectedResolutionTime) {
		_adminalert.setExpectedResolutionTime(expectedResolutionTime);
	}

	/**
	* Returns the resolution status of this adminalert.
	*
	* @return the resolution status of this adminalert
	*/
	@Override
	public java.lang.String getResolutionStatus() {
		return _adminalert.getResolutionStatus();
	}

	/**
	* Sets the resolution status of this adminalert.
	*
	* @param resolutionStatus the resolution status of this adminalert
	*/
	@Override
	public void setResolutionStatus(java.lang.String resolutionStatus) {
		_adminalert.setResolutionStatus(resolutionStatus);
	}

	@Override
	public boolean isNew() {
		return _adminalert.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adminalert.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adminalert.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adminalert.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adminalert.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adminalert.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adminalert.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adminalert.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adminalert.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adminalert.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adminalert.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new adminalertWrapper((adminalert)_adminalert.clone());
	}

	@Override
	public int compareTo(adminalert adminalert) {
		return _adminalert.compareTo(adminalert);
	}

	@Override
	public int hashCode() {
		return _adminalert.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<adminalert> toCacheModel() {
		return _adminalert.toCacheModel();
	}

	@Override
	public adminalert toEscapedModel() {
		return new adminalertWrapper(_adminalert.toEscapedModel());
	}

	@Override
	public adminalert toUnescapedModel() {
		return new adminalertWrapper(_adminalert.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adminalert.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adminalert.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adminalert.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof adminalertWrapper)) {
			return false;
		}

		adminalertWrapper adminalertWrapper = (adminalertWrapper)obj;

		if (Validator.equals(_adminalert, adminalertWrapper._adminalert)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public adminalert getWrappedadminalert() {
		return _adminalert;
	}

	@Override
	public adminalert getWrappedModel() {
		return _adminalert;
	}

	@Override
	public void resetOriginalValues() {
		_adminalert.resetOriginalValues();
	}

	private adminalert _adminalert;
}