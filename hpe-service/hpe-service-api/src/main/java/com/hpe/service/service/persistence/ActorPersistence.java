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

package com.hpe.service.service.persistence;

import com.hpe.service.exception.NoSuchActorException;
import com.hpe.service.model.Actor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the actor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActorUtil
 * @generated
 */
@ProviderType
public interface ActorPersistence extends BasePersistence<Actor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActorUtil} to access the actor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the actors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching actors
	 */
	public java.util.List<Actor> findByUuid(String uuid);

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
	public java.util.List<Actor> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Actor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator);

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
	public java.util.List<Actor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actor
	 * @throws NoSuchActorException if a matching actor could not be found
	 */
	public Actor findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Actor>
				orderByComparator)
		throws NoSuchActorException;

	/**
	 * Returns the first actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching actor, or <code>null</code> if a matching actor could not be found
	 */
	public Actor fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator);

	/**
	 * Returns the last actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actor
	 * @throws NoSuchActorException if a matching actor could not be found
	 */
	public Actor findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Actor>
				orderByComparator)
		throws NoSuchActorException;

	/**
	 * Returns the last actor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching actor, or <code>null</code> if a matching actor could not be found
	 */
	public Actor fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator);

	/**
	 * Returns the actors before and after the current actor in the ordered set where uuid = &#63;.
	 *
	 * @param actorId the primary key of the current actor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next actor
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	public Actor[] findByUuid_PrevAndNext(
			long actorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Actor>
				orderByComparator)
		throws NoSuchActorException;

	/**
	 * Removes all the actors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of actors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching actors
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the actor in the entity cache if it is enabled.
	 *
	 * @param actor the actor
	 */
	public void cacheResult(Actor actor);

	/**
	 * Caches the actors in the entity cache if it is enabled.
	 *
	 * @param actors the actors
	 */
	public void cacheResult(java.util.List<Actor> actors);

	/**
	 * Creates a new actor with the primary key. Does not add the actor to the database.
	 *
	 * @param actorId the primary key for the new actor
	 * @return the new actor
	 */
	public Actor create(long actorId);

	/**
	 * Removes the actor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor that was removed
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	public Actor remove(long actorId) throws NoSuchActorException;

	public Actor updateImpl(Actor actor);

	/**
	 * Returns the actor with the primary key or throws a <code>NoSuchActorException</code> if it could not be found.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor
	 * @throws NoSuchActorException if a actor with the primary key could not be found
	 */
	public Actor findByPrimaryKey(long actorId) throws NoSuchActorException;

	/**
	 * Returns the actor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor, or <code>null</code> if a actor with the primary key could not be found
	 */
	public Actor fetchByPrimaryKey(long actorId);

	/**
	 * Returns all the actors.
	 *
	 * @return the actors
	 */
	public java.util.List<Actor> findAll();

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
	public java.util.List<Actor> findAll(int start, int end);

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
	public java.util.List<Actor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator);

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
	public java.util.List<Actor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Actor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the actors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of actors.
	 *
	 * @return the number of actors
	 */
	public int countAll();

}