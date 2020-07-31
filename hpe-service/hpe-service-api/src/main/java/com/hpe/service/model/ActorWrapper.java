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

package com.hpe.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Actor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Actor
 * @generated
 */
public class ActorWrapper
	extends BaseModelWrapper<Actor> implements Actor, ModelWrapper<Actor> {

	public ActorWrapper(Actor actor) {
		super(actor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("actorId", getActorId());
		attributes.put("actorName", getActorName());
		attributes.put("age", getAge());
		attributes.put("languages", getLanguages());
		attributes.put("movies", getMovies());
		attributes.put("criticRating", getCriticRating());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long actorId = (Long)attributes.get("actorId");

		if (actorId != null) {
			setActorId(actorId);
		}

		String actorName = (String)attributes.get("actorName");

		if (actorName != null) {
			setActorName(actorName);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String languages = (String)attributes.get("languages");

		if (languages != null) {
			setLanguages(languages);
		}

		String movies = (String)attributes.get("movies");

		if (movies != null) {
			setMovies(movies);
		}

		Integer criticRating = (Integer)attributes.get("criticRating");

		if (criticRating != null) {
			setCriticRating(criticRating);
		}
	}

	/**
	 * Returns the actor ID of this actor.
	 *
	 * @return the actor ID of this actor
	 */
	@Override
	public long getActorId() {
		return model.getActorId();
	}

	/**
	 * Returns the actor name of this actor.
	 *
	 * @return the actor name of this actor
	 */
	@Override
	public String getActorName() {
		return model.getActorName();
	}

	/**
	 * Returns the age of this actor.
	 *
	 * @return the age of this actor
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the critic rating of this actor.
	 *
	 * @return the critic rating of this actor
	 */
	@Override
	public int getCriticRating() {
		return model.getCriticRating();
	}

	/**
	 * Returns the languages of this actor.
	 *
	 * @return the languages of this actor
	 */
	@Override
	public String getLanguages() {
		return model.getLanguages();
	}

	/**
	 * Returns the movies of this actor.
	 *
	 * @return the movies of this actor
	 */
	@Override
	public String getMovies() {
		return model.getMovies();
	}

	/**
	 * Returns the primary key of this actor.
	 *
	 * @return the primary key of this actor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this actor.
	 *
	 * @return the uuid of this actor
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the actor ID of this actor.
	 *
	 * @param actorId the actor ID of this actor
	 */
	@Override
	public void setActorId(long actorId) {
		model.setActorId(actorId);
	}

	/**
	 * Sets the actor name of this actor.
	 *
	 * @param actorName the actor name of this actor
	 */
	@Override
	public void setActorName(String actorName) {
		model.setActorName(actorName);
	}

	/**
	 * Sets the age of this actor.
	 *
	 * @param age the age of this actor
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the critic rating of this actor.
	 *
	 * @param criticRating the critic rating of this actor
	 */
	@Override
	public void setCriticRating(int criticRating) {
		model.setCriticRating(criticRating);
	}

	/**
	 * Sets the languages of this actor.
	 *
	 * @param languages the languages of this actor
	 */
	@Override
	public void setLanguages(String languages) {
		model.setLanguages(languages);
	}

	/**
	 * Sets the movies of this actor.
	 *
	 * @param movies the movies of this actor
	 */
	@Override
	public void setMovies(String movies) {
		model.setMovies(movies);
	}

	/**
	 * Sets the primary key of this actor.
	 *
	 * @param primaryKey the primary key of this actor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this actor.
	 *
	 * @param uuid the uuid of this actor
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ActorWrapper wrap(Actor actor) {
		return new ActorWrapper(actor);
	}

}