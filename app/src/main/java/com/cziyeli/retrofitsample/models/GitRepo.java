package com.cziyeli.retrofitsample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Github Repo for a User
 * GSON
 * GET /users/:username/repos
 */

public class GitRepo {
	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("owner")
	@Expose
	private GitOwner owner;

	public GitRepo() {
	}

	public GitRepo(int id, String name, String description, GitOwner owner) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public GitOwner getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return Integer.toString(id) + " " + getName();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof GitRepo) == false) {
			return false;
		}
		GitRepo rhs = ((GitRepo) other);

		return (getId() == rhs.getId());
	}

	public static class GitOwner {
		public int id;
		public String avatar_url;

		// no args constructor
		public GitOwner() {
		}

		public GitOwner(final int id, final String avatar_url) {
			this.id = id;
			this.avatar_url = avatar_url;
		}

		public int getId() {
			return id;
		}

		public String getAvatarUrl() {
			return avatar_url;
		}

		// dummy owner
		public static GitOwner createOwner(){ // lishiyo
			return new GitRepo.GitOwner(7489058, "https://avatars.githubusercontent.com/u/7489058?v=3");
		}
	}
}
