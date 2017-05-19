/**
 * @author yfmei
 * @description mava版hello world
 * @date 2017/5/17
 * @time 21:49
 */
public class HelloWorld {
    public String  sayHello(){
        return "hello maven";
    }
    
    public static void main(String[] args) {
        System.out.println("-----------rebat.com-----------new HelloWorld().sayHello()值=" + new HelloWorld().sayHello() + "," + "当前类=HelloWorld.main()");
    }
}
