package com.genpact.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 
 * @author 710009498
 *@RibbonClient(name = "USER-V1", configuration = CustomConfiguration.class)
 *	中name属性表示你要自定义的服务
 *注意这个类不要和@SpringBootApplication所在的 程序启动类在同一个目录下 否则@RibbonClient 会影响整个clients 而不是name属性指定的
 *具体参照 @see RibbonClientConfiguration for the defaults
 */
@Configuration
@RibbonClient(name = "USER-V1", configuration = CustomConfiguration.class)
public class CustomConfiguration {
	@Autowired IClientConfig config;
	
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}
}