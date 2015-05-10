package com.waynesun.common;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class SpringDAOTestCase extends AbstractTransactionalDataSourceSpringContextTests {
	 protected String[] getConfigLocations(){   
		 return new String[] { "classpath:test.xml" };   
	 }   
}
