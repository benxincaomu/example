package org.sft.sample.common.config;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author sunfutao
 *
 * @since 2018年8月30日
 */
@Service
public class RemoteConfig implements InitializingBean, FactoryBean<Properties> {
	@Autowired
	private AbstractApplicationContext applicationContext;
	private Properties props = new Properties();
	private Logger log = LogManager.getLogger(getClass());

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println();
		System.out.println();
		System.out.println();
		props.setProperty("remoteP", "remote");
		log.info(applicationContext);
	}

	@Override
	public Properties getObject() throws Exception {
		return props;
	}

	@Override
	public Class<?> getObjectType() {

		return Properties.class;
	}

}
