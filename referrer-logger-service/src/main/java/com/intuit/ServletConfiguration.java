package com.intuit;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] { JspConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

}