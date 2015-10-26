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
import com.liferay.portal.model.CacheModel;

import com.twelve.capital.greetings.service.model.User_Status;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing User_Status in entity cache.
 *
 * @author neha.kakkar
 * @see User_Status
 * @generated
 */
public class User_StatusCacheModel implements CacheModel<User_Status>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{UserId=");
		sb.append(UserId);
		sb.append(", StatusId=");
		sb.append(StatusId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public User_Status toEntityModel() {
		User_StatusImpl user_StatusImpl = new User_StatusImpl();

		user_StatusImpl.setUserId(UserId);
		user_StatusImpl.setStatusId(StatusId);

		user_StatusImpl.resetOriginalValues();

		return user_StatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		UserId = objectInput.readLong();
		StatusId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(UserId);
		objectOutput.writeLong(StatusId);
	}

	public long UserId;
	public long StatusId;
}