package com.cziyeli.retrofitsample.network.github;

import com.cziyeli.retrofitsample.models.GitRepo;
import com.cziyeli.retrofitsample.models.GitUser;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Github API endpoints interface.
 * Retrofit 2.0 return value is always a parameterized Call<T> object such as Call<GitRepo>.
 */
public interface GitHubAPI {

	@GET("/users/{user}/repos")
	Call<GitRepo[]> getUserRepos(@Path("user") String user);

	@Headers({
			"Accept: application/vnd.github.v3.full+json",
			"User-Agent: RetrofitSample"
	})
	@GET("/users/{username}")
	Call<GitUser> getUser(@Path("username") String username);

}
