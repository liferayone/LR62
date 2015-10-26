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

package com.twelve.capital.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.twelve.capital.model.adminalert;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing adminalert in entity cache.
 *
 * @author neha.kakkar
 * @see adminalert
 * @generated
 */
public class adminalertCacheModel implements CacheModel<adminalert>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{alertId=");
		sb.append(alertId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", location=");
		sb.append(location);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", expectedResolutionTime=");
		sb.append(expectedResolutionTime);
		sb.append(", resolutionStatus=");
		sb.append(resolutionStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public adminalert toEntityModel() {
		adminalertImpl adminalertImpl = new adminalertImpl();

		adminalertImpl.setAlertId(alertId);
		adminalertImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			adminalertImpl.setCreateDate(null);
		}
		else {
			adminalertImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adminalertImpl.setModifiedDate(null);
		}
		else {
			adminalertImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (location == null) {
			adminalertImpl.setLocation(StringPool.BLANK);
		}
		else {
			adminalertImpl.setLocation(location);
		}

		if (resolution == null) {
			adminalertImpl.setResolution(StringPool.BLANK);
		}
		else {
			adminalertImpl.setResolution(resolution);
		}

		if (expectedResolutionTime == Long.MIN_VALUE) {
			adminalertImpl.setExpectedResolutionTime(null);
		}
		else {
			adminalertImpl.setExpectedResolutionTime(new Date(
					expectedResolutionTime));
		}

		if (resolutionStatus == null) {
			adminalertImpl.setResolutionStatus(StringPool.BLANK);
		}
		else {
			adminalertImpl.setResolutionStatus(resolutionStatus);
		}

		adminalertImpl.resetOriginalValues();

		return adminalertImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		alertId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		location = objectInput.readUTF();
		resolution = objectInput.readUTF();
		expectedResolutionTime = objectInput.readLong();
		resolutionStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(alertId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (resolution == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resolution);
		}

		objectOutput.writeLong(expectedResolutionTime);

		if (resolutionStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resolutionStatus);
		}
	}

	public long alertId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String location;
	public String resolution;
	public long expectedResolutionTime;
	public String resolutionStatus;
}