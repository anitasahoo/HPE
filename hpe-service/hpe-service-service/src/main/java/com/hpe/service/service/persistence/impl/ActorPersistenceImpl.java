/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.hpe.service.service.persistence.impl;

import com.hpe.service.exception.NoSuchActorException;
import com.hpe.service.model.Actor;
import com.hpe.service.model.impl.ActorImpl;
import com.hpe.service.model.impl.ActorModelImpl;
import com.hpe.service.service.persistence.ActorPersistence;
import com.hpe.service.service.persistence.impl.constants.HPEPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the actor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ActorPersistence.class)
public class ActorPersistenceImpl
	extends BasePersistenceImpl<Actor> implements ActorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActorUtil</code> to access the actor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the actors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching actors
	 */
	@Override
	public List<Actor> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the actors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @return the range of matching actors
	 */
	@Override
	public List<Actor> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the actors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actors
	 */
	@Override
	public List<Actor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actor> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the actors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actors
	 */
	@Override
	public List<Actor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Actor> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Actor> list = null;

		if (useFinderCache) {
			list = (List<Actor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Actor actor : list) {
					if (!uuid.equals(actor.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ACTOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Actor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actor
	 * @throws NoSuchActorException if a matching actor could not be found
	 */
	@Override
	public Actor findByUuid_First(
			String uuid, OrderByComparator<Actor> orderByComparator)
		throws NoSuchActorException {

		Actor actor = fetchByUuid_First(uuid, orderByComparator);

		if (actor != null) {
			return actor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActorException(sb.toString());
	}

	/**
	 * Returns the first actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actor, or <code>null</code> if a matching actor could not be found
	 */
	@Override
	public Actor fetchByUuid_First(
		String uuid, OrderByComparator<Actor> orderByComparator) {

		List<Actor> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actor
	 * @throws NoSuchActorException if a matching actor could not be found
	 */
	@Override
	public Actor findByUuid_Last(
			String uuid, OrderByComparator<Actor> orderByComparator)
		throws NoSuchActorException {

		Actor actor = fetchByUuid_Last(uuid, orderByComparator);

		if (actor != null) {
			return actor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActorException(sb.toString());
	}

	/**
	 * Returns the last actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actor, or <code>null</code> if a matching actor could not be found
	 */
	@Override
	public Actor fetchByUuid_Last(
		String uuid, OrderByComparator<Actor> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Actor> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the actors before and after the current actor in the ordered set where uuid = &#63;.
	 *
	 * @param actorId the primary key of the current actor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actor
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	@Override
	public Actor[] findByUuid_PrevAndNext(
			long actorId, String uuid,
			OrderByComparator<Actor> orderByComparator)
		throws NoSuchActorException {

		uuid = Objects.toString(uuid, "");

		Actor actor = findByPrimaryKey(actorId);

		Session session = null;

		try {
			session = openSession();

			Actor[] array = new ActorImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, actor, uuid, orderByComparator, true);

			array[1] = actor;

			array[2] = getByUuid_PrevAndNext(
				session, actor, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Actor getByUuid_PrevAndNext(
		Session session, Actor actor, String uuid,
		OrderByComparator<Actor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ActorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(actor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Actor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Actor actor :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(actor);
		}
	}

	/**
	 * Returns the number of actors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching actors
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "actor.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(actor.uuid IS NULL OR actor.uuid = '')";

	public ActorPersistenceImpl() {
		setModelClass(Actor.class);

		setModelImplClass(ActorImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the actor in the entity cache if it is enabled.
	 *
	 * @param actor the actor
	 */
	@Override
	public void cacheResult(Actor actor) {
		entityCache.putResult(
			entityCacheEnabled, ActorImpl.class, actor.getPrimaryKey(), actor);

		actor.resetOriginalValues();
	}

	/**
	 * Caches the actors in the entity cache if it is enabled.
	 *
	 * @param actors the actors
	 */
	@Override
	public void cacheResult(List<Actor> actors) {
		for (Actor actor : actors) {
			if (entityCache.getResult(
					entityCacheEnabled, ActorImpl.class,
					actor.getPrimaryKey()) == null) {

				cacheResult(actor);
			}
			else {
				actor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all actors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the actor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Actor actor) {
		entityCache.removeResult(
			entityCacheEnabled, ActorImpl.class, actor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Actor> actors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Actor actor : actors) {
			entityCache.removeResult(
				entityCacheEnabled, ActorImpl.class, actor.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ActorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new actor with the primary key. Does not add the actor to the database.
	 *
	 * @param actorId the primary key for the new actor
	 * @return the new actor
	 */
	@Override
	public Actor create(long actorId) {
		Actor actor = new ActorImpl();

		actor.setNew(true);
		actor.setPrimaryKey(actorId);

		String uuid = PortalUUIDUtil.generate();

		actor.setUuid(uuid);

		return actor;
	}

	/**
	 * Removes the actor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor that was removed
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	@Override
	public Actor remove(long actorId) throws NoSuchActorException {
		return remove((Serializable)actorId);
	}

	/**
	 * Removes the actor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the actor
	 * @return the actor that was removed
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	@Override
	public Actor remove(Serializable primaryKey) throws NoSuchActorException {
		Session session = null;

		try {
			session = openSession();

			Actor actor = (Actor)session.get(ActorImpl.class, primaryKey);

			if (actor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(actor);
		}
		catch (NoSuchActorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Actor removeImpl(Actor actor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(actor)) {
				actor = (Actor)session.get(
					ActorImpl.class, actor.getPrimaryKeyObj());
			}

			if (actor != null) {
				session.delete(actor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (actor != null) {
			clearCache(actor);
		}

		return actor;
	}

	@Override
	public Actor updateImpl(Actor actor) {
		boolean isNew = actor.isNew();

		if (!(actor instanceof ActorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(actor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(actor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in actor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Actor implementation " +
					actor.getClass());
		}

		ActorModelImpl actorModelImpl = (ActorModelImpl)actor;

		if (Validator.isNull(actor.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			actor.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (actor.isNew()) {
				session.save(actor);

				actor.setNew(false);
			}
			else {
				actor = (Actor)session.merge(actor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {actorModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((actorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {actorModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {actorModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ActorImpl.class, actor.getPrimaryKey(), actor,
			false);

		actor.resetOriginalValues();

		return actor;
	}

	/**
	 * Returns the actor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the actor
	 * @return the actor
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	@Override
	public Actor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActorException {

		Actor actor = fetchByPrimaryKey(primaryKey);

		if (actor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return actor;
	}

	/**
	 * Returns the actor with the primary key or throws a <code>NoSuchActorException</code> if it could not be found.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	@Override
	public Actor findByPrimaryKey(long actorId) throws NoSuchActorException {
		return findByPrimaryKey((Serializable)actorId);
	}

	/**
	 * Returns the actor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor, or <code>null</code> if a actor with the primary key could not be found
	 */
	@Override
	public Actor fetchByPrimaryKey(long actorId) {
		return fetchByPrimaryKey((Serializable)actorId);
	}

	/**
	 * Returns all the actors.
	 *
	 * @return the actors
	 */
	@Override
	public List<Actor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the actors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @return the range of actors
	 */
	@Override
	public List<Actor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the actors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of actors
	 */
	@Override
	public List<Actor> findAll(
		int start, int end, OrderByComparator<Actor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the actors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of actors
	 */
	@Override
	public List<Actor> findAll(
		int start, int end, OrderByComparator<Actor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Actor> list = null;

		if (useFinderCache) {
			list = (List<Actor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTOR;

				sql = sql.concat(ActorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Actor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the actors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Actor actor : findAll()) {
			remove(actor);
		}
	}

	/**
	 * Returns the number of actors.
	 *
	 * @return the number of actors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACTOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "actorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the actor persistence.
	 */
	@Activate
	public void activate() {
		ActorModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ActorModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ActorModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ActorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = HPEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.hpe.service.model.Actor"),
			true);
	}

	@Override
	@Reference(
		target = HPEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HPEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACTOR =
		"SELECT actor FROM Actor actor";

	private static final String _SQL_SELECT_ACTOR_WHERE =
		"SELECT actor FROM Actor actor WHERE ";

	private static final String _SQL_COUNT_ACTOR =
		"SELECT COUNT(actor) FROM Actor actor";

	private static final String _SQL_COUNT_ACTOR_WHERE =
		"SELECT COUNT(actor) FROM Actor actor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "actor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Actor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Actor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActorPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(HPEPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}