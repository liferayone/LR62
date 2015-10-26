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

package com.twelve.capital.service.persistence;

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

import com.twelve.capital.NoSuchadminalertException;
import com.twelve.capital.model.adminalert;
import com.twelve.capital.model.impl.adminalertImpl;
import com.twelve.capital.model.impl.adminalertModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the adminalert service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see adminalertPersistence
 * @see adminalertUtil
 * @generated
 */
public class adminalertPersistenceImpl extends BasePersistenceImpl<adminalert>
	implements adminalertPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link adminalertUtil} to access the adminalert persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = adminalertImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertModelImpl.FINDER_CACHE_ENABLED, adminalertImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertModelImpl.FINDER_CACHE_ENABLED, adminalertImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public adminalertPersistenceImpl() {
		setModelClass(adminalert.class);
	}

	/**
	 * Caches the adminalert in the entity cache if it is enabled.
	 *
	 * @param adminalert the adminalert
	 */
	@Override
	public void cacheResult(adminalert adminalert) {
		EntityCacheUtil.putResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertImpl.class, adminalert.getPrimaryKey(), adminalert);

		adminalert.resetOriginalValues();
	}

	/**
	 * Caches the adminalerts in the entity cache if it is enabled.
	 *
	 * @param adminalerts the adminalerts
	 */
	@Override
	public void cacheResult(List<adminalert> adminalerts) {
		for (adminalert adminalert : adminalerts) {
			if (EntityCacheUtil.getResult(
						adminalertModelImpl.ENTITY_CACHE_ENABLED,
						adminalertImpl.class, adminalert.getPrimaryKey()) == null) {
				cacheResult(adminalert);
			}
			else {
				adminalert.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all adminalerts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(adminalertImpl.class.getName());
		}

		EntityCacheUtil.clearCache(adminalertImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the adminalert.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(adminalert adminalert) {
		EntityCacheUtil.removeResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertImpl.class, adminalert.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<adminalert> adminalerts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (adminalert adminalert : adminalerts) {
			EntityCacheUtil.removeResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
				adminalertImpl.class, adminalert.getPrimaryKey());
		}
	}

	/**
	 * Creates a new adminalert with the primary key. Does not add the adminalert to the database.
	 *
	 * @param alertId the primary key for the new adminalert
	 * @return the new adminalert
	 */
	@Override
	public adminalert create(long alertId) {
		adminalert adminalert = new adminalertImpl();

		adminalert.setNew(true);
		adminalert.setPrimaryKey(alertId);

		return adminalert;
	}

	/**
	 * Removes the adminalert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alertId the primary key of the adminalert
	 * @return the adminalert that was removed
	 * @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert remove(long alertId)
		throws NoSuchadminalertException, SystemException {
		return remove((Serializable)alertId);
	}

	/**
	 * Removes the adminalert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the adminalert
	 * @return the adminalert that was removed
	 * @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert remove(Serializable primaryKey)
		throws NoSuchadminalertException, SystemException {
		Session session = null;

		try {
			session = openSession();

			adminalert adminalert = (adminalert)session.get(adminalertImpl.class,
					primaryKey);

			if (adminalert == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchadminalertException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adminalert);
		}
		catch (NoSuchadminalertException nsee) {
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
	protected adminalert removeImpl(adminalert adminalert)
		throws SystemException {
		adminalert = toUnwrappedModel(adminalert);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adminalert)) {
				adminalert = (adminalert)session.get(adminalertImpl.class,
						adminalert.getPrimaryKeyObj());
			}

			if (adminalert != null) {
				session.delete(adminalert);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adminalert != null) {
			clearCache(adminalert);
		}

		return adminalert;
	}

	@Override
	public adminalert updateImpl(com.twelve.capital.model.adminalert adminalert)
		throws SystemException {
		adminalert = toUnwrappedModel(adminalert);

		boolean isNew = adminalert.isNew();

		Session session = null;

		try {
			session = openSession();

			if (adminalert.isNew()) {
				session.save(adminalert);

				adminalert.setNew(false);
			}
			else {
				session.merge(adminalert);
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

		EntityCacheUtil.putResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
			adminalertImpl.class, adminalert.getPrimaryKey(), adminalert);

		return adminalert;
	}

	protected adminalert toUnwrappedModel(adminalert adminalert) {
		if (adminalert instanceof adminalertImpl) {
			return adminalert;
		}

		adminalertImpl adminalertImpl = new adminalertImpl();

		adminalertImpl.setNew(adminalert.isNew());
		adminalertImpl.setPrimaryKey(adminalert.getPrimaryKey());

		adminalertImpl.setAlertId(adminalert.getAlertId());
		adminalertImpl.setGroupId(adminalert.getGroupId());
		adminalertImpl.setCreateDate(adminalert.getCreateDate());
		adminalertImpl.setModifiedDate(adminalert.getModifiedDate());
		adminalertImpl.setLocation(adminalert.getLocation());
		adminalertImpl.setResolution(adminalert.getResolution());
		adminalertImpl.setExpectedResolutionTime(adminalert.getExpectedResolutionTime());
		adminalertImpl.setResolutionStatus(adminalert.getResolutionStatus());

		return adminalertImpl;
	}

	/**
	 * Returns the adminalert with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the adminalert
	 * @return the adminalert
	 * @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert findByPrimaryKey(Serializable primaryKey)
		throws NoSuchadminalertException, SystemException {
		adminalert adminalert = fetchByPrimaryKey(primaryKey);

		if (adminalert == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchadminalertException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adminalert;
	}

	/**
	 * Returns the adminalert with the primary key or throws a {@link com.twelve.capital.NoSuchadminalertException} if it could not be found.
	 *
	 * @param alertId the primary key of the adminalert
	 * @return the adminalert
	 * @throws com.twelve.capital.NoSuchadminalertException if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert findByPrimaryKey(long alertId)
		throws NoSuchadminalertException, SystemException {
		return findByPrimaryKey((Serializable)alertId);
	}

	/**
	 * Returns the adminalert with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the adminalert
	 * @return the adminalert, or <code>null</code> if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		adminalert adminalert = (adminalert)EntityCacheUtil.getResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
				adminalertImpl.class, primaryKey);

		if (adminalert == _nulladminalert) {
			return null;
		}

		if (adminalert == null) {
			Session session = null;

			try {
				session = openSession();

				adminalert = (adminalert)session.get(adminalertImpl.class,
						primaryKey);

				if (adminalert != null) {
					cacheResult(adminalert);
				}
				else {
					EntityCacheUtil.putResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
						adminalertImpl.class, primaryKey, _nulladminalert);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(adminalertModelImpl.ENTITY_CACHE_ENABLED,
					adminalertImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adminalert;
	}

	/**
	 * Returns the adminalert with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alertId the primary key of the adminalert
	 * @return the adminalert, or <code>null</code> if a adminalert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public adminalert fetchByPrimaryKey(long alertId) throws SystemException {
		return fetchByPrimaryKey((Serializable)alertId);
	}

	/**
	 * Returns all the adminalerts.
	 *
	 * @return the adminalerts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<adminalert> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adminalerts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.model.impl.adminalertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminalerts
	 * @param end the upper bound of the range of adminalerts (not inclusive)
	 * @return the range of adminalerts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<adminalert> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the adminalerts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.model.impl.adminalertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of adminalerts
	 * @param end the upper bound of the range of adminalerts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of adminalerts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<adminalert> findAll(int start, int end,
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

		List<adminalert> list = (List<adminalert>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADMINALERT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINALERT;

				if (pagination) {
					sql = sql.concat(adminalertModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<adminalert>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<adminalert>(list);
				}
				else {
					list = (List<adminalert>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the adminalerts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (adminalert adminalert : findAll()) {
			remove(adminalert);
		}
	}

	/**
	 * Returns the number of adminalerts.
	 *
	 * @return the number of adminalerts
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

				Query q = session.createQuery(_SQL_COUNT_ADMINALERT);

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
	 * Initializes the adminalert persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.twelve.capital.model.adminalert")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<adminalert>> listenersList = new ArrayList<ModelListener<adminalert>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<adminalert>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(adminalertImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADMINALERT = "SELECT adminalert FROM adminalert adminalert";
	private static final String _SQL_COUNT_ADMINALERT = "SELECT COUNT(adminalert) FROM adminalert adminalert";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adminalert.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No adminalert exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(adminalertPersistenceImpl.class);
	private static adminalert _nulladminalert = new adminalertImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<adminalert> toCacheModel() {
				return _nulladminalertCacheModel;
			}
		};

	private static CacheModel<adminalert> _nulladminalertCacheModel = new CacheModel<adminalert>() {
			@Override
			public adminalert toEntityModel() {
				return _nulladminalert;
			}
		};
}