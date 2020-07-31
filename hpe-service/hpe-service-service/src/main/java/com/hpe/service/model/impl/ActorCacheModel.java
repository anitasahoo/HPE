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

package com.hpe.service.model.impl;

import com.hpe.service.model.Actor;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Actor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActorCacheModel implements CacheModel<Actor>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActorCacheModel)) {
			return false;
		}

		ActorCacheModel actorCacheModel = (ActorCacheModel)obj;

		if (actorId == actorCacheModel.actorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, actorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", actorId=");
		sb.append(actorId);
		sb.append(", actorName=");
		sb.append(actorName);
		sb.append(", age=");
		sb.append(age);
		sb.append(", languages=");
		sb.append(languages);
		sb.append(", movies=");
		sb.append(movies);
		sb.append(", criticRating=");
		sb.append(criticRating);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Actor toEntityModel() {
		ActorImpl actorImpl = new ActorImpl();

		if (uuid == null) {
			actorImpl.setUuid("");
		}
		else {
			actorImpl.setUuid(uuid);
		}

		actorImpl.setActorId(actorId);

		if (actorName == null) {
			actorImpl.setActorName("");
		}
		else {
			actorImpl.setActorName(actorName);
		}

		actorImpl.setAge(age);

		if (languages == null) {
			actorImpl.setLanguages("");
		}
		else {
			actorImpl.setLanguages(languages);
		}

		if (movies == null) {
			actorImpl.setMovies("");
		}
		else {
			actorImpl.setMovies(movies);
		}

		actorImpl.setCriticRating(criticRating);

		actorImpl.resetOriginalValues();

		return actorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		actorId = objectInput.readLong();
		actorName = objectInput.readUTF();

		age = objectInput.readInt();
		languages = objectInput.readUTF();
		movies = objectInput.readUTF();

		criticRating = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(actorId);

		if (actorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actorName);
		}

		objectOutput.writeInt(age);

		if (languages == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languages);
		}

		if (movies == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(movies);
		}

		objectOutput.writeInt(criticRating);
	}

	public String uuid;
	public long actorId;
	public String actorName;
	public int age;
	public String languages;
	public String movies;
	public int criticRating;

}