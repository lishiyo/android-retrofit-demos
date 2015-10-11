package com.cziyeli.retrofitsample.network.github;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Singleton service class with config setup.
 */
public class GitHubClient {
	private static GitHubAPI API_CLIENT;
    private static String ROOT = "https://api.github.com";

	public static final int GIT_USER_REPOS = 0; // GET user/:username/repos

	public static GitHubAPI createService() {
		return API_CLIENT;
	}

	static {
		setupApiClient();
    }

	private static void setupApiClient() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(ROOT)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		// Construct service using the API interface with defined endpoints
		API_CLIENT = retrofit.create(GitHubAPI.class);
	}
}
