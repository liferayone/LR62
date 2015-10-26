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
public class GreetingsMessageSoap implements Serializable {
	public static GreetingsMessageSoap toSoapModel(GreetingsMessage model) {
		GreetingsMessageSoap soapModel = new GreetingsMessageSoap();

		soapModel.setStatusId(model.getStatusId());
		soapModel.setMessage(model.getMessage());
		soapModel.setButton_color(model.getButton_color());

		return soapModel;
	}

	public static GreetingsMessageSoap[] toSoapModels(GreetingsMessage[] models) {
		GreetingsMessageSoap[] soapModels = new GreetingsMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GreetingsMessageSoap[][] toSoapModels(
		GreetingsMessage[][] models) {
		GreetingsMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GreetingsMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GreetingsMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GreetingsMessageSoap[] toSoapModels(
		List<GreetingsMessage> models) {
		List<GreetingsMessageSoap> soapModels = new ArrayList<GreetingsMessageSoap>(models.size());

		for (GreetingsMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GreetingsMessageSoap[soapModels.size()]);
	}

	public GreetingsMessageSoap() {
	}

	public long getPrimaryKey() {
		return _StatusId;
	}

	public void setPrimaryKey(long pk) {
		setStatusId(pk);
	}

	public long getStatusId() {
		return _StatusId;
	}

	public void setStatusId(long StatusId) {
		_StatusId = StatusId;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String Message) {
		_Message = Message;
	}

	public String getButton_color() {
		return _button_color;
	}

	public void setButton_color(String button_color) {
		_button_color = button_color;
	}

	private long _StatusId;
	private String _Message;
	private String _button_color;
}