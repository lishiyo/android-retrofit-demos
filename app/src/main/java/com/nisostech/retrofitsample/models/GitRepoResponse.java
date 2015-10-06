package com.nisostech.retrofitsample.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by connieli on 10/5/15.
 */
public class GitRepoResponse {
	List<GitRepo> events;

	public GitRepoResponse() {
		events = new ArrayList<GitRepo>();
	}

	public static GitRepoResponse parseJSON(String response) {
		Gson gson = new GsonBuilder().create();
		GitRepoResponse gitRepoResponse = gson.fromJson(response, GitRepoResponse.class);
		return gitRepoResponse;
	}
}
