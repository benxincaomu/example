package org.sft.sample.common.config.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
@Configuration
public class SessionRedisConfig extends RedisHttpSessionConfiguration {

	public SessionRedisConfig() {
		super();
		setDefaultRedisSerializer(new KryoRedisSerializer<>());
	}

}
