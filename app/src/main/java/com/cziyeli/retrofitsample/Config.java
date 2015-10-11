package com.cziyeli.retrofitsample;

/**
 * Created by connieli on 10/5/15.
 */
public class Config {

	/**
	 * GITHUB
 	 */
	public static String GIT_ROOT = "https://api.github.com";
	public static String GIT_USER_AGENT = "lishIyo"; // User-Agent must be username or app name
	public static String GIT_EVENTS = GIT_ROOT + "/events";
	// https://api.github.com/search/repositories?q=tetris+language:assembly&sort=stars&order=desc
	public static String GIT_SEARCH = GIT_ROOT + "/search/repositories";
	public static String GIT_USER_REPORTS = GIT_ROOT + "/users/"; // /:username/repos

	/**
	 * Tumblr
	 */
	public static String TUMBLR_ROOT = "https://api.twitter.com";

	/**
	 * Foursquare
	 */
	public static String FOURSQUARE_ROOT = "https://api.foursquare.com/v2/";

	/**
	 * Wattpad
	 */
	public static String WATTPAD_ROOT = "api.wattpad.com";
}
