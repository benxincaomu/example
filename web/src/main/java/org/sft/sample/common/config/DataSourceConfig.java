package org.sft.sample.common.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 数据源配置为druid
 * 
 * @author sun
 *
 */
@Configuration
@EnableTransactionManagement // 开启事务注解
public class DataSourceConfig {

	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		try {
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}

	@Bean
	public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean<StatViewServlet> druidServlet() {
		return new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
	}
}
