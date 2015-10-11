package com.cziyeli.retrofitsample.network.github;

import com.cziyeli.retrofitsample.models.GitRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * array of { gitRepo }
 */
public class GitRepoResponse {
	List<GitRepo> mGitRepos;

	// public constructor is necessary for collections
	public GitRepoResponse() {
	}

	public static GitRepo[] parseResponse(String response) throws IOException {
//		Moshi moshi = new Moshi.Builder().build();
//		JsonAdapter<GitRepo[]> jsonAdapter = moshi.adapter(GitRepo[].class);
//		GitRepo[] mGitRepos = jsonAdapter.fromJson(response);

		Gson gson = new GsonBuilder().create();
		GitRepo[] gitRepos = gson.fromJson(response, GitRepo[].class);

		return gitRepos;
	}

	public void setGitRepos(List<GitRepo> repos) {
		mGitRepos = repos;
	}

	/**
	 * ========= DUMMY TEST DATA =========
	 */

	public static GitRepo[] getDummyRepos() {
		ArrayList<GitRepo> repos = new ArrayList<>();
		final GitRepo.GitOwner owner = GitRepo.GitOwner.createOwner();
		final GitRepo r1 = new GitRepo(123, "first", "my first dummy repo", owner);
		final GitRepo r2 = new GitRepo(456, "second", "my second dummy repo", owner);
		repos.add(r1);
		repos.add(r2);
		GitRepo[] repoArr = repos.toArray(new GitRepo[repos.size()]);

		return repoArr;
	}
}
