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

package com.twelve.capital.greetings.service.service.impl;


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.twelve.capital.greetings.service.NoSuchUser_StatusException;
import com.twelve.capital.greetings.service.model.User_Status;
import com.twelve.capital.greetings.service.service.User_StatusLocalServiceUtil;
import com.twelve.capital.greetings.service.service.base.User_StatusLocalServiceBaseImpl;

/**
 * The implementation of the user_ status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.twelve.capital.greetings.service.service.User_StatusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author neha.kakkar
 * @see com.twelve.capital.greetings.service.service.base.User_StatusLocalServiceBaseImpl
 * @see com.twelve.capital.greetings.service.service.User_StatusLocalServiceUtil
 */
public class User_StatusLocalServiceImpl extends User_StatusLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.twelve.capital.greetings.service.service.User_StatusLocalServiceUtil} to access the user_ status local service.
	 */
	public void updateUserStatus(long userId, long statusId){
		
		User_Status userStatus=null;
		try {
			userStatus = user_StatusPersistence.findByPrimaryKey(userId);
		} catch (NoSuchUser_StatusException | SystemException e) {
			// TODO Auto-generated catch block
			
		}
		
		if (Validator.isNull(userStatus)){
			 userStatus= User_StatusLocalServiceUtil.createUser_Status(userId);
				
		}
		
		userStatus.setStatusId(statusId);
		try {
			user_StatusPersistence.update(userStatus);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}