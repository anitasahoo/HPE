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

package com.hpe.service.service.impl;

import com.hpe.service.model.Actor;
import com.hpe.service.service.base.ActorLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the actor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.hpe.service.service.ActorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActorLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.hpe.service.model.Actor",
	service = AopService.class
)
public class ActorLocalServiceImpl extends ActorLocalServiceBaseImpl {

	public void addEditActor(ThemeDisplay themeDisplay, String actorName,int age, String language,String movies, int criticRating) {
		Actor actor = actorPersistence.create(CounterLocalServiceUtil.increment());
		actor.setActorName(actorName);
		actor.setAge(age);
		actor.setLanguages(language);
		actor.setMovies(movies);
		actor.setCriticRating(criticRating);
		actorPersistence.update(actor);
		try {
			assetEntryLocalService.updateEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), new Date(), new Date(), Actor.class.getName(), actor.getActorId(), actor.getUuid(), 0, null, null, true, false, new Date(), null, new Date(),null, ContentTypes.TEXT_HTML, actor.getActorName(), actor.getActorName(), null, null, null, 0, 0, null);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	
	public void updateActor(ThemeDisplay themeDisplay,Actor actor) {
		
		actorPersistence.update(actor);
		try {
			assetEntryLocalService.updateEntry(Actor.class.getName(), actor.getActorId(), new Date(), null, true, true);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
	}
}