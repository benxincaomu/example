package org.sft.sample.common.config;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

/**
 * @author sunfutao
 *
 * @since 2018年8月30日
 */
@Configuration
@AutoConfigureAfter(value = Environment.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RemoteConfig{
	@Resource
	private Environment evn;
	@Bean
	public String ss() {
		System.out.println();
		return "";
	}
	
	
}
