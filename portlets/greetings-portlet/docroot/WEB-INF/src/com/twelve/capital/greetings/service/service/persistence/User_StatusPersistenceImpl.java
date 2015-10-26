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

package com.twelve.capital.greetings.service.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.twelve.capital.greetings.service.NoSuchUser_StatusException;
import com.twelve.capital.greetings.service.model.User_Status;
import com.twelve.capital.greetings.service.model.impl.User_StatusImpl;
import com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user_ status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see User_StatusPersistence
 * @see User_StatusUtil
 * @generated
 */
public class User_StatusPersistenceImpl extends BasePersistenceImpl<User_Status>
	implements User_StatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link User_StatusUtil} to access the user_ status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = User_StatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusModelImpl.FINDER_CACHE_ENABLED, User_StatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusModelImpl.FINDER_CACHE_ENABLED, User_StatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public User_StatusPersistenceImpl() {
		setModelClass(User_Status.class);
	}

	/**
	 * Caches the user_ status in the entity cache if it is enabled.
	 *
	 * @param user_Status the user_ status
	 */
	@Override
	public void cacheResult(User_Status user_Status) {
		EntityCacheUtil.putResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusImpl.class, user_Status.getPrimaryKey(), user_Status);

		user_Status.resetOriginalValues();
	}

	/**
	 * Caches the user_ statuses in the entity cache if it is enabled.
	 *
	 * @param user_Statuses the user_ statuses
	 */
	@Override
	public void cacheResult(List<User_Status> user_Statuses) {
		for (User_Status user_Status : user_Statuses) {
			if (EntityCacheUtil.getResult(
						User_StatusModelImpl.ENTITY_CACHE_ENABLED,
						User_StatusImpl.class, user_Status.getPrimaryKey()) == null) {
				cacheResult(user_Status);
			}
			else {
				user_Status.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user_ statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(User_StatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(User_StatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user_ status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(User_Status user_Status) {
		EntityCacheUtil.removeResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusImpl.class, user_Status.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<User_Status> user_Statuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (User_Status user_Status : user_Statuses) {
			EntityCacheUtil.removeResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
				User_StatusImpl.class, user_Status.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user_ status with the primary key. Does not add the user_ status to the database.
	 *
	 * @param UserId the primary key for the new user_ status
	 * @return the new user_ status
	 */
	@Override
	public User_Status create(long UserId) {
		User_Status user_Status = new User_StatusImpl();

		user_Status.setNew(true);
		user_Status.setPrimaryKey(UserId);

		return user_Status;
	}

	/**
	 * Removes the user_ status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param UserId the primary key of the user_ status
	 * @return the user_ status that was removed
	 * @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status remove(long UserId)
		throws NoSuchUser_StatusException, SystemException {
		return remove((Serializable)UserId);
	}

	/**
	 * Removes the user_ status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user_ status
	 * @return the user_ status that was removed
	 * @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status remove(Serializable primaryKey)
		throws NoSuchUser_StatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			User_Status user_Status = (User_Status)session.get(User_StatusImpl.class,
					primaryKey);

			if (user_Status == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUser_StatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(user_Status);
		}
		catch (NoSuchUser_StatusException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected User_Status removeImpl(User_Status user_Status)
		throws SystemException {
		user_Status = toUnwrappedModel(user_Status);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(user_Status)) {
				user_Status = (User_Status)session.get(User_StatusImpl.class,
						user_Status.getPrimaryKeyObj());
			}

			if (user_Status != null) {
				session.delete(user_Status);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (user_Status != null) {
			clearCache(user_Status);
		}

		return user_Status;
	}

	@Override
	public User_Status updateImpl(
		com.twelve.capital.greetings.service.model.User_Status user_Status)
		throws SystemException {
		user_Status = toUnwrappedModel(user_Status);

		boolean isNew = user_Status.isNew();

		Session session = null;

		try {
			session = openSession();

			if (user_Status.isNew()) {
				session.save(user_Status);

				user_Status.setNew(false);
			}
			else {
				session.merge(user_Status);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
			User_StatusImpl.class, user_Status.getPrimaryKey(), user_Status);

		return user_Status;
	}

	protected User_Status toUnwrappedModel(User_Status user_Status) {
		if (user_Status instanceof User_StatusImpl) {
			return user_Status;
		}

		User_StatusImpl user_StatusImpl = new User_StatusImpl();

		user_StatusImpl.setNew(user_Status.isNew());
		user_StatusImpl.setPrimaryKey(user_Status.getPrimaryKey());

		user_StatusImpl.setUserId(user_Status.getUserId());
		user_StatusImpl.setStatusId(user_Status.getStatusId());

		return user_StatusImpl;
	}

	/**
	 * Returns the user_ status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_ status
	 * @return the user_ status
	 * @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUser_StatusException, SystemException {
		User_Status user_Status = fetchByPrimaryKey(primaryKey);

		if (user_Status == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUser_StatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return user_Status;
	}

	/**
	 * Returns the user_ status with the primary key or throws a {@link com.twelve.capital.greetings.service.NoSuchUser_StatusException} if it could not be found.
	 *
	 * @param UserId the primary key of the user_ status
	 * @return the user_ status
	 * @throws com.twelve.capital.greetings.service.NoSuchUser_StatusException if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status findByPrimaryKey(long UserId)
		throws NoSuchUser_StatusException, SystemException {
		return findByPrimaryKey((Serializable)UserId);
	}

	/**
	 * Returns the user_ status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_ status
	 * @return the user_ status, or <code>null</code> if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		User_Status user_Status = (User_Status)EntityCacheUtil.getResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
				User_StatusImpl.class, primaryKey);

		if (user_Status == _nullUser_Status) {
			return null;
		}

		if (user_Status == null) {
			Session session = null;

			try {
				session = openSession();

				user_Status = (User_Status)session.get(User_StatusImpl.class,
						primaryKey);

				if (user_Status != null) {
					cacheResult(user_Status);
				}
				else {
					EntityCacheUtil.putResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
						User_StatusImpl.class, primaryKey, _nullUser_Status);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(User_StatusModelImpl.ENTITY_CACHE_ENABLED,
					User_StatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return user_Status;
	}

	/**
	 * Returns the user_ status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param UserId the primary key of the user_ status
	 * @return the user_ status, or <code>null</code> if a user_ status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_Status fetchByPrimaryKey(long UserId) throws SystemException {
		return fetchByPrimaryKey((Serializable)UserId);
	}

	/**
	 * Returns all the user_ statuses.
	 *
	 * @return the user_ statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_Status> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user_ statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user_ statuses
	 * @param end the upper bound of the range of user_ statuses (not inclusive)
	 * @return the range of user_ statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_Status> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user_ statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.User_StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user_ statuses
	 * @param end the upper bound of the range of user_ statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user_ statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_Status> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<User_Status> list = (List<User_Status>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USER_STATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USER_STATUS;

				if (pagination) {
					sql = sql.concat(User_StatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<User_Status>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<User_Status>(list);
				}
				else {
					list = (List<User_Status>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user_ statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (User_Status user_Status : findAll()) {
			remove(user_Status);
		}
	}

	/**
	 * Returns the number of user_ statuses.
	 *
	 * @return the number of user_ statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USER_STATUS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the user_ status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.twelve.capital.greetings.service.model.User_Status")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<User_Status>> listenersList = new ArrayList<ModelListener<User_Status>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<User_Status>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(User_StatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USER_STATUS = "SELECT user_Status FROM User_Status user_Status";
	private static final String _SQL_COUNT_USER_STATUS = "SELECT COUNT(user_Status) FROM User_Status user_Status";
	private static final String _ORDER_BY_ENTITY_ALIAS = "user_Status.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No User_Status exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(User_StatusPersistenceImpl.class);
	private static User_Status _nullUser_Status = new User_StatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<User_Status> toCacheModel() {
				return _nullUser_StatusCacheModel;
			}
		};

	private static CacheModel<User_Status> _nullUser_StatusCacheModel = new CacheModel<User_Status>() {
			@Override
			public User_Status toEntityModel() {
				return _nullUser_Status;
			}
		};
}