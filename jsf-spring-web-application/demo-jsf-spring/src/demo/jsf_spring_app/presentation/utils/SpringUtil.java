package demo.jsf_spring_app.presentation.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import demo.jsf_spring_app.bl.Services;

public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext ctx;

	public static Services getServices() {
		return (Services)ctx.getBean("services");
		// return (Services) JSFUtil.getBean("services");
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringUtil.ctx = applicationContext;
	}

}