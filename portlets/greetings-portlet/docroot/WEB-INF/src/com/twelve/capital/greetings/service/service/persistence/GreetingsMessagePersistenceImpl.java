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

import com.twelve.capital.greetings.service.NoSuchGreetingsMessageException;
import com.twelve.capital.greetings.service.model.GreetingsMessage;
import com.twelve.capital.greetings.service.model.impl.GreetingsMessageImpl;
import com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the greetings message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author neha.kakkar
 * @see GreetingsMessagePersistence
 * @see GreetingsMessageUtil
 * @generated
 */
public class GreetingsMessagePersistenceImpl extends BasePersistenceImpl<GreetingsMessage>
	implements GreetingsMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GreetingsMessageUtil} to access the greetings message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GreetingsMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageModelImpl.FINDER_CACHE_ENABLED,
			GreetingsMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageModelImpl.FINDER_CACHE_ENABLED,
			GreetingsMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GreetingsMessagePersistenceImpl() {
		setModelClass(GreetingsMessage.class);
	}

	/**
	 * Caches the greetings message in the entity cache if it is enabled.
	 *
	 * @param greetingsMessage the greetings message
	 */
	@Override
	public void cacheResult(GreetingsMessage greetingsMessage) {
		EntityCacheUtil.putResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageImpl.class, greetingsMessage.getPrimaryKey(),
			greetingsMessage);

		greetingsMessage.resetOriginalValues();
	}

	/**
	 * Caches the greetings messages in the entity cache if it is enabled.
	 *
	 * @param greetingsMessages the greetings messages
	 */
	@Override
	public void cacheResult(List<GreetingsMessage> greetingsMessages) {
		for (GreetingsMessage greetingsMessage : greetingsMessages) {
			if (EntityCacheUtil.getResult(
						GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
						GreetingsMessageImpl.class,
						greetingsMessage.getPrimaryKey()) == null) {
				cacheResult(greetingsMessage);
			}
			else {
				greetingsMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all greetings messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GreetingsMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GreetingsMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the greetings message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GreetingsMessage greetingsMessage) {
		EntityCacheUtil.removeResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageImpl.class, greetingsMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GreetingsMessage> greetingsMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GreetingsMessage greetingsMessage : greetingsMessages) {
			EntityCacheUtil.removeResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
				GreetingsMessageImpl.class, greetingsMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new greetings message with the primary key. Does not add the greetings message to the database.
	 *
	 * @param StatusId the primary key for the new greetings message
	 * @return the new greetings message
	 */
	@Override
	public GreetingsMessage create(long StatusId) {
		GreetingsMessage greetingsMessage = new GreetingsMessageImpl();

		greetingsMessage.setNew(true);
		greetingsMessage.setPrimaryKey(StatusId);

		return greetingsMessage;
	}

	/**
	 * Removes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param StatusId the primary key of the greetings message
	 * @return the greetings message that was removed
	 * @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage remove(long StatusId)
		throws NoSuchGreetingsMessageException, SystemException {
		return remove((Serializable)StatusId);
	}

	/**
	 * Removes the greetings message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the greetings message
	 * @return the greetings message that was removed
	 * @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage remove(Serializable primaryKey)
		throws NoSuchGreetingsMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GreetingsMessage greetingsMessage = (GreetingsMessage)session.get(GreetingsMessageImpl.class,
					primaryKey);

			if (greetingsMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGreetingsMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(greetingsMessage);
		}
		catch (NoSuchGreetingsMessageException nsee) {
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
	protected GreetingsMessage removeImpl(GreetingsMessage greetingsMessage)
		throws SystemException {
		greetingsMessage = toUnwrappedModel(greetingsMessage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(greetingsMessage)) {
				greetingsMessage = (GreetingsMessage)session.get(GreetingsMessageImpl.class,
						greetingsMessage.getPrimaryKeyObj());
			}

			if (greetingsMessage != null) {
				session.delete(greetingsMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (greetingsMessage != null) {
			clearCache(greetingsMessage);
		}

		return greetingsMessage;
	}

	@Override
	public GreetingsMessage updateImpl(
		com.twelve.capital.greetings.service.model.GreetingsMessage greetingsMessage)
		throws SystemException {
		greetingsMessage = toUnwrappedModel(greetingsMessage);

		boolean isNew = greetingsMessage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (greetingsMessage.isNew()) {
				session.save(greetingsMessage);

				greetingsMessage.setNew(false);
			}
			else {
				session.merge(greetingsMessage);
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

		EntityCacheUtil.putResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
			GreetingsMessageImpl.class, greetingsMessage.getPrimaryKey(),
			greetingsMessage);

		return greetingsMessage;
	}

	protected GreetingsMessage toUnwrappedModel(
		GreetingsMessage greetingsMessage) {
		if (greetingsMessage instanceof GreetingsMessageImpl) {
			return greetingsMessage;
		}

		GreetingsMessageImpl greetingsMessageImpl = new GreetingsMessageImpl();

		greetingsMessageImpl.setNew(greetingsMessage.isNew());
		greetingsMessageImpl.setPrimaryKey(greetingsMessage.getPrimaryKey());

		greetingsMessageImpl.setStatusId(greetingsMessage.getStatusId());
		greetingsMessageImpl.setMessage(greetingsMessage.getMessage());
		greetingsMessageImpl.setButton_color(greetingsMessage.getButton_color());

		return greetingsMessageImpl;
	}

	/**
	 * Returns the greetings message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the greetings message
	 * @return the greetings message
	 * @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGreetingsMessageException, SystemException {
		GreetingsMessage greetingsMessage = fetchByPrimaryKey(primaryKey);

		if (greetingsMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGreetingsMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return greetingsMessage;
	}

	/**
	 * Returns the greetings message with the primary key or throws a {@link com.twelve.capital.greetings.service.NoSuchGreetingsMessageException} if it could not be found.
	 *
	 * @param StatusId the primary key of the greetings message
	 * @return the greetings message
	 * @throws com.twelve.capital.greetings.service.NoSuchGreetingsMessageException if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage findByPrimaryKey(long StatusId)
		throws NoSuchGreetingsMessageException, SystemException {
		return findByPrimaryKey((Serializable)StatusId);
	}

	/**
	 * Returns the greetings message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the greetings message
	 * @return the greetings message, or <code>null</code> if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GreetingsMessage greetingsMessage = (GreetingsMessage)EntityCacheUtil.getResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
				GreetingsMessageImpl.class, primaryKey);

		if (greetingsMessage == _nullGreetingsMessage) {
			return null;
		}

		if (greetingsMessage == null) {
			Session session = null;

			try {
				session = openSession();

				greetingsMessage = (GreetingsMessage)session.get(GreetingsMessageImpl.class,
						primaryKey);

				if (greetingsMessage != null) {
					cacheResult(greetingsMessage);
				}
				else {
					EntityCacheUtil.putResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
						GreetingsMessageImpl.class, primaryKey,
						_nullGreetingsMessage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GreetingsMessageModelImpl.ENTITY_CACHE_ENABLED,
					GreetingsMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return greetingsMessage;
	}

	/**
	 * Returns the greetings message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param StatusId the primary key of the greetings message
	 * @return the greetings message, or <code>null</code> if a greetings message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GreetingsMessage fetchByPrimaryKey(long StatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)StatusId);
	}

	/**
	 * Returns all the greetings messages.
	 *
	 * @return the greetings messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GreetingsMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the greetings messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of greetings messages
	 * @param end the upper bound of the range of greetings messages (not inclusive)
	 * @return the range of greetings messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GreetingsMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the greetings messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.twelve.capital.greetings.service.model.impl.GreetingsMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of greetings messages
	 * @param end the upper bound of the range of greetings messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of greetings messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GreetingsMessage> findAll(int start, int end,
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

		List<GreetingsMessage> list = (List<GreetingsMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GREETINGSMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GREETINGSMESSAGE;

				if (pagination) {
					sql = sql.concat(GreetingsMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GreetingsMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GreetingsMessage>(list);
				}
				else {
					list = (List<GreetingsMessage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the greetings messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GreetingsMessage greetingsMessage : findAll()) {
			remove(greetingsMessage);
		}
	}

	/**
	 * Returns the number of greetings messages.
	 *
	 * @return the number of greetings messages
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

				Query q = session.createQuery(_SQL_COUNT_GREETINGSMESSAGE);

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
	 * Initializes the greetings message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.twelve.capital.greetings.service.model.GreetingsMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GreetingsMessage>> listenersList = new ArrayList<ModelListener<GreetingsMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GreetingsMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GreetingsMessageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GREETINGSMESSAGE = "SELECT greetingsMessage FROM GreetingsMessage greetingsMessage";
	private static final String _SQL_COUNT_GREETINGSMESSAGE = "SELECT COUNT(greetingsMessage) FROM GreetingsMessage greetingsMessage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "greetingsMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GreetingsMessage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GreetingsMessagePersistenceImpl.class);
	private static GreetingsMessage _nullGreetingsMessage = new GreetingsMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GreetingsMessage> toCacheModel() {
				return _nullGreetingsMessageCacheModel;
			}
		};

	private static CacheModel<GreetingsMessage> _nullGreetingsMessageCacheModel = new CacheModel<GreetingsMessage>() {
			@Override
			public GreetingsMessage toEntityModel() {
				return _nullGreetingsMessage;
			}
		};
}