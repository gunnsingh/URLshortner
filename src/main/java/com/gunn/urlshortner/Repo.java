package com.gunn.urlshortner;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class Repo {
	HashMap<String, String> urls = new HashMap<>();
}
