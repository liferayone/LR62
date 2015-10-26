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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.twelve.capital.service.http.adminalertServiceSoap}.
 *
 * @author neha.kakkar
 * @see com.twelve.capital.service.http.adminalertServiceSoap
 * @generated
 */
public class adminalertSoap implements Serializable {
	public static adminalertSoap toSoapModel(adminalert model) {
		adminalertSoap soapModel = new adminalertSoap();

		soapModel.setAlertId(model.getAlertId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLocation(model.getLocation());
		soapModel.setResolution(model.getResolution());
		soapModel.setExpectedResolutionTime(model.getExpectedResolutionTime());
		soapModel.setResolutionStatus(model.getResolutionStatus());

		return soapModel;
	}

	public static adminalertSoap[] toSoapModels(adminalert[] models) {
		adminalertSoap[] soapModels = new adminalertSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static adminalertSoap[][] toSoapModels(adminalert[][] models) {
		adminalertSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new adminalertSoap[models.length][models[0].length];
		}
		else {
			soapModels = new adminalertSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static adminalertSoap[] toSoapModels(List<adminalert> models) {
		List<adminalertSoap> soapModels = new ArrayList<adminalertSoap>(models.size());

		for (adminalert model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new adminalertSoap[soapModels.size()]);
	}

	public adminalertSoap() {
	}

	public long getPrimaryKey() {
		return _alertId;
	}

	public void setPrimaryKey(long pk) {
		setAlertId(pk);
	}

	public long getAlertId() {
		return _alertId;
	}

	public void setAlertId(long alertId) {
		_alertId = alertId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getResolution() {
		return _resolution;
	}

	public void setResolution(String resolution) {
		_resolution = resolution;
	}

	public Date getExpectedResolutionTime() {
		return _expectedResolutionTime;
	}

	public void setExpectedResolutionTime(Date expectedResolutionTime) {
		_expectedResolutionTime = expectedResolutionTime;
	}

	public String getResolutionStatus() {
		return _resolutionStatus;
	}

	public void setResolutionStatus(String resolutionStatus) {
		_resolutionStatus = resolutionStatus;
	}

	private long _alertId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _location;
	private String _resolution;
	private Date _expectedResolutionTime;
	private String _resolutionStatus;
}