package ca.acorn;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple ca.acorn.clients.App.
 */
public class CleintsApplication
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CleintsApplication(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CleintsApplication.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
