package com.yedam.app.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration.Dynamic;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer   {

	@Override
	protected Class<?>[] getRootConfigClasses() {
	    return new Class[] {RootConfig.class, DataSourceConfig.class, MybatisConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	// 인코딩 필터 등록
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        return new Filter[]{ encodingFilter };
    }

	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		registration.setInitParameter("throwExceptionIfNoHandlerFound","true");
		
		MultipartConfigElement multipartConfig = new MultipartConfigElement("c:/Temp", 200000,400000, 200000);
		registration.setMultipartConfig(multipartConfig);
	}

}
