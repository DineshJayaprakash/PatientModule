package com.PatientModule.PatientModule.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.PatientModule.PatientModule.Model.Patient;


/**
 * Class RedisConfig
 * 
 * @created By Dinesh J
 * @Created Date 11/12
 * @description used to create redis configuration manually
 */

@Configuration
public class RedisConfig {
	

	/**
	 * function jedisConnectionFactory
	 * 
	 * @return JedisConnectionFactory bean
	 * @description used add the redis connection configuration pool
	 */
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		 JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory();
	    jedisConFactory.setHostName("host.docker.internal");
	    jedisConFactory.setPort(6379);
	    return jedisConFactory;
	}

	
	/**
	 * function redisTemplate
	 * 
	 * @return the Datas from redis repository Based on key value pair
	 * @description used to crea
	 */
	@Bean
	RedisTemplate<String, Patient> redisTemplate() {
		RedisTemplate<String, Patient> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}


}
