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

package com.hpe.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActorLocalService
 * @generated
 */
public class ActorLocalServiceWrapper
	implements ActorLocalService, ServiceWrapper<ActorLocalService> {

	public ActorLocalServiceWrapper(ActorLocalService actorLocalService) {
		_actorLocalService = actorLocalService;
	}

	/**
	 * Adds the actor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was added
	 */
	@Override
	public com.hpe.service.model.Actor addActor(
		com.hpe.service.model.Actor actor) {

		return _actorLocalService.addActor(actor);
	}

	@Override
	public void addEditActor(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String actorName, int age, String language, String movies,
		int criticRating) {

		_actorLocalService.addEditActor(
			themeDisplay, actorName, age, language, movies, criticRating);
	}

	/**
	 * Creates a new actor with the primary key. Does not add the actor to the database.
	 *
	 * @param actorId the primary key for the new actor
	 * @return the new actor
	 */
	@Override
	public com.hpe.service.model.Actor createActor(long actorId) {
		return _actorLocalService.createActor(actorId);
	}

	/**
	 * Deletes the actor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was removed
	 */
	@Override
	public com.hpe.service.model.Actor deleteActor(
		com.hpe.service.model.Actor actor) {

		return _actorLocalService.deleteActor(actor);
	}

	/**
	 * Deletes the actor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor that was removed
	 * @throws PortalException if a actor with the primary key could not be found
	 */
	@Override
	public com.hpe.service.model.Actor deleteActor(long actorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actorLocalService.deleteActor(actorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _actorLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hpe.service.model.impl.ActorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _actorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hpe.service.model.impl.ActorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _actorLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _actorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _actorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.hpe.service.model.Actor fetchActor(long actorId) {
		return _actorLocalService.fetchActor(actorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _actorLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the actor with the primary key.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor
	 * @throws PortalException if a actor with the primary key could not be found
	 */
	@Override
	public com.hpe.service.model.Actor getActor(long actorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actorLocalService.getActor(actorId);
	}

	/**
	 * Returns a range of all the actors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.hpe.service.model.impl.ActorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of actors
	 * @param end the upper bound of the range of actors (not inclusive)
	 * @return the range of actors
	 */
	@Override
	public java.util.List<com.hpe.service.model.Actor> getActors(
		int start, int end) {

		return _actorLocalService.getActors(start, end);
	}

	/**
	 * Returns the number of actors.
	 *
	 * @return the number of actors
	 */
	@Override
	public int getActorsCount() {
		return _actorLocalService.getActorsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _actorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _actorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _actorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was updated
	 */
	@Override
	public com.hpe.service.model.Actor updateActor(
		com.hpe.service.model.Actor actor) {

		return _actorLocalService.updateActor(actor);
	}

	@Override
	public void updateActor(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		com.hpe.service.model.Actor actor) {

		_actorLocalService.updateActor(themeDisplay, actor);
	}

	@Override
	public ActorLocalService getWrappedService() {
		return _actorLocalService;
	}

	@Override
	public void setWrappedService(ActorLocalService actorLocalService) {
		_actorLocalService = actorLocalService;
	}

	private ActorLocalService _actorLocalService;

}