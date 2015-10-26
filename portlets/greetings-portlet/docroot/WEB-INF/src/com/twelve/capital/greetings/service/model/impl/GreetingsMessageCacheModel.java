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

package com.twelve.capital.greetings.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.twelve.capital.greetings.service.model.GreetingsMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GreetingsMessage in entity cache.
 *
 * @author neha.kakkar
 * @see GreetingsMessage
 * @generated
 */
public class GreetingsMessageCacheModel implements CacheModel<GreetingsMessage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{StatusId=");
		sb.append(StatusId);
		sb.append(", Message=");
		sb.append(Message);
		sb.append(", button_color=");
		sb.append(button_color);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GreetingsMessage toEntityModel() {
		GreetingsMessageImpl greetingsMessageImpl = new GreetingsMessageImpl();

		greetingsMessageImpl.setStatusId(StatusId);

		if (Message == null) {
			greetingsMessageImpl.setMessage(StringPool.BLANK);
		}
		else {
			greetingsMessageImpl.setMessage(Message);
		}

		if (button_color == null) {
			greetingsMessageImpl.setButton_color(StringPool.BLANK);
		}
		else {
			greetingsMessageImpl.setButton_color(button_color);
		}

		greetingsMessageImpl.resetOriginalValues();

		return greetingsMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		StatusId = objectInput.readLong();
		Message = objectInput.readUTF();
		button_color = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(StatusId);

		if (Message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Message);
		}

		if (button_color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(button_color);
		}
	}

	public long StatusId;
	public String Message;
	public String button_color;
}