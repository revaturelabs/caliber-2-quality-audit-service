/**
 * 
 */
package com.revature.caliber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

/**
 * @author pgerringer
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuditServiceApplication.class)
public class AuditServiceServiceTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void test() {
		
	}

}
