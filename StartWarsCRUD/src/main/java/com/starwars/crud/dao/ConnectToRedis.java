package com.starwars.crud.dao;

import com.google.gson.Gson;
import com.starwars.crud.model.Person;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class ConnectToRedis {
	
	private static final String REDIS_URL = "redis://mp9EB7PKv3LrrDrnJOaw2DBXjKFQP9Ll@redis-12668.c57.us-east-1-4.ec2.cloud.redislabs.com:12668/0";
	
	public void saveCharacter(Person person) {
		RedisClient redisClient = RedisClient.create(REDIS_URL);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.set(person.getName().toLowerCase().replace(" ", "_"), person.toJson());

		connection.close();
		redisClient.shutdown();
	}
	
	public void deleteCharacter(Person person) {
		RedisClient redisClient = RedisClient.create(REDIS_URL);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.del(person.getName().toLowerCase().replace(" ", "_"));
		
		connection.close();
		redisClient.shutdown();
	}
	
	public void listCharacters() {
		RedisClient redisClient = RedisClient.create(REDIS_URL);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.get("*");

		connection.close();
		redisClient.shutdown();
	}
	
	public Person listCharacter(String key) {
		RedisClient redisClient = RedisClient.create(REDIS_URL);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		Gson gson = new Gson();
		Person person = gson.fromJson(syncCommands.get(key), Person.class);

		connection.close();
		redisClient.shutdown();
		
		return person;
	}

}
