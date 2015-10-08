package com.cziyeli.retrofitsample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Github User.
 */
public class GitUser {
	@SerializedName("id")
	@Expose
	private int mId;
	@SerializedName("avatar_url")
	@Expose
	private String mAvatarUrl;

	public GitUser() {
	}

	public GitUser(final int id, final String avatar_url) {
		mId = id;
		mAvatarUrl = avatar_url;
	}

	public int getId() {
		return mId;
	}

	public String getAvatarUrl() {
		return mAvatarUrl;
	}
}
