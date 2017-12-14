package com.nop.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfig extends WebMvcConfigurerAdapter{
	

	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        resolver.setViewClass(JstlView.class);
	        registry.viewResolver(resolver);
	    }
	 
	 
	 @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry.addResourceHandler("/resources/**")
                     .addResourceLocations("/resources/");
     }
	 
	 @Bean
	 @Qualifier("loginServlet")
		// Only used when running in embedded servlet
		public DispatcherServlet dispatcherServlet() {
		  DispatcherServlet disLogin=new DispatcherServlet();
		  disLogin.setContextConfigLocation("/WEB-INF/spring/appServlet/login-servlet-context.xml");
		  disLogin.setNamespace("loginServlet");
		  System.out.println("ServletName:"+disLogin.getServletName());
			return disLogin;
		}
	 @Bean
	 @Qualifier("appservlet")
		// Only used when running in embedded servlet
		public DispatcherServlet dispatcherServletApp() {
		  DispatcherServlet dis=new DispatcherServlet();
		  dis.setContextConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		  System.out.println("ServletName:"+dis.getServletName());
			return dis;
		}
	 
		@Override
		public void configureDefaultServletHandling(
				DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}
		
		
	 
}
