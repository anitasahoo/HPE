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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActorSoap implements Serializable {

	public static ActorSoap toSoapModel(Actor model) {
		ActorSoap soapModel = new ActorSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setActorId(model.getActorId());
		soapModel.setActorName(model.getActorName());
		soapModel.setAge(model.getAge());
		soapModel.setLanguages(model.getLanguages());
		soapModel.setMovies(model.getMovies());
		soapModel.setCriticRating(model.getCriticRating());

		return soapModel;
	}

	public static ActorSoap[] toSoapModels(Actor[] models) {
		ActorSoap[] soapModels = new ActorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActorSoap[][] toSoapModels(Actor[][] models) {
		ActorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActorSoap[] toSoapModels(List<Actor> models) {
		List<ActorSoap> soapModels = new ArrayList<ActorSoap>(models.size());

		for (Actor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActorSoap[soapModels.size()]);
	}

	public ActorSoap() {
	}

	public long getPrimaryKey() {
		return _actorId;
	}

	public void setPrimaryKey(long pk) {
		setActorId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getActorId() {
		return _actorId;
	}

	public void setActorId(long actorId) {
		_actorId = actorId;
	}

	public String getActorName() {
		return _actorName;
	}

	public void setActorName(String actorName) {
		_actorName = actorName;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getLanguages() {
		return _languages;
	}

	public void setLanguages(String languages) {
		_languages = languages;
	}

	public String getMovies() {
		return _movies;
	}

	public void setMovies(String movies) {
		_movies = movies;
	}

	public int getCriticRating() {
		return _criticRating;
	}

	public void setCriticRating(int criticRating) {
		_criticRating = criticRating;
	}

	private String _uuid;
	private long _actorId;
	private String _actorName;
	private int _age;
	private String _languages;
	private String _movies;
	private int _criticRating;

}