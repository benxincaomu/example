package org.sft.sample.common.config.web;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @author sft
 *
 *         2016年5月30日
 */
@Configuration
public class FastJSONMessageConfig implements WebMvcConfigurer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.clear();
		FastJsonConfig fastjsonConfig = new FastJsonConfig();
		fastjsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		// List<SerializerFeature> features=new ArrayList<>();
		SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteEnumUsingToString };
		fastjsonConfig.setSerializerFeatures(features);
		PropertyFilter propertyFilter=new PropertyFilter() {
			
			@Override
			public boolean apply(Object object, String name, Object value) {
				
				return value!=null;
			}
		};
		fastjsonConfig.setSerializeFilters(propertyFilter);
		
		FastJsonHttpMessageConverter fsConverter = new FastJsonHttpMessageConverter();
		fsConverter.setFastJsonConfig(fastjsonConfig);
		converters.add(fsConverter);
	}


}
