import junit.framework.TestCase;

/**
 * @author yfmei
 * @date 2017/5/17
 * @time 22:28
 */
public class HelloWorldTest extends TestCase {
    public void testSayHello() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("hello maven",result);
    }

}