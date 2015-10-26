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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author neha.kakkar
 * @generated
 */
public class User_StatusSoap implements Serializable {
	public static User_StatusSoap toSoapModel(User_Status model) {
		User_StatusSoap soapModel = new User_StatusSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setStatusId(model.getStatusId());

		return soapModel;
	}

	public static User_StatusSoap[] toSoapModels(User_Status[] models) {
		User_StatusSoap[] soapModels = new User_StatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static User_StatusSoap[][] toSoapModels(User_Status[][] models) {
		User_StatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new User_StatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new User_StatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static User_StatusSoap[] toSoapModels(List<User_Status> models) {
		List<User_StatusSoap> soapModels = new ArrayList<User_StatusSoap>(models.size());

		for (User_Status model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new User_StatusSoap[soapModels.size()]);
	}

	public User_StatusSoap() {
	}

	public long getPrimaryKey() {
		return _UserId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _UserId;
	}

	public void setUserId(long UserId) {
		_UserId = UserId;
	}

	public long getStatusId() {
		return _StatusId;
	}

	public void setStatusId(long StatusId) {
		_StatusId = StatusId;
	}

	private long _UserId;
	private long _StatusId;
}