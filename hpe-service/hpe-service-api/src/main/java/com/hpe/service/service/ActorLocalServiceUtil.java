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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Actor. This utility wraps
 * <code>com.hpe.service.service.impl.ActorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActorLocalService
 * @generated
 */
public class ActorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.hpe.service.service.impl.ActorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the actor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was added
	 */
	public static com.hpe.service.model.Actor addActor(
		com.hpe.service.model.Actor actor) {

		return getService().addActor(actor);
	}

	public static void addEditActor(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String actorName, int age, String language, String movies,
		int criticRating) {

		getService().addEditActor(
			themeDisplay, actorName, age, language, movies, criticRating);
	}

	/**
	 * Creates a new actor with the primary key. Does not add the actor to the database.
	 *
	 * @param actorId the primary key for the new actor
	 * @return the new actor
	 */
	public static com.hpe.service.model.Actor createActor(long actorId) {
		return getService().createActor(actorId);
	}

	/**
	 * Deletes the actor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was removed
	 */
	public static com.hpe.service.model.Actor deleteActor(
		com.hpe.service.model.Actor actor) {

		return getService().deleteActor(actor);
	}

	/**
	 * Deletes the actor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor that was removed
	 * @throws PortalException if a actor with the primary key could not be found
	 */
	public static com.hpe.service.model.Actor deleteActor(long actorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteActor(actorId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.hpe.service.model.Actor fetchActor(long actorId) {
		return getService().fetchActor(actorId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the actor with the primary key.
	 *
	 * @param actorId the primary key of the actor
	 * @return the actor
	 * @throws PortalException if a actor with the primary key could not be found
	 */
	public static com.hpe.service.model.Actor getActor(long actorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActor(actorId);
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
	public static java.util.List<com.hpe.service.model.Actor> getActors(
		int start, int end) {

		return getService().getActors(start, end);
	}

	/**
	 * Returns the number of actors.
	 *
	 * @return the number of actors
	 */
	public static int getActorsCount() {
		return getService().getActorsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the actor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actor the actor
	 * @return the actor that was updated
	 */
	public static com.hpe.service.model.Actor updateActor(
		com.hpe.service.model.Actor actor) {

		return getService().updateActor(actor);
	}

	public static void updateActor(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		com.hpe.service.model.Actor actor) {

		getService().updateActor(themeDisplay, actor);
	}

	public static ActorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActorLocalService, ActorLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActorLocalService.class);

		ServiceTracker<ActorLocalService, ActorLocalService> serviceTracker =
			new ServiceTracker<ActorLocalService, ActorLocalService>(
				bundle.getBundleContext(), ActorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}