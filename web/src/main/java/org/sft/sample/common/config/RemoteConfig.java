package org.sft.sample.common.config;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author sunfutao
 *
 * @since 2018年8月30日
 */
@Service
public class RemoteConfig implements InitializingBean,FactoryBean<Properties>{
	private Properties props=new Properties();
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println();
		System.out.println();
		System.out.println();
		props.setProperty("remoteP", "remote");
		
	}

	@Override
	public Properties getObject() throws Exception{
		return props;
	}

	@Override
	public Class<?> getObjectType(){
		
		return Properties.class;
	}
	
}
