package reflect;

public class ReflectTest {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("reflect.SayHi");
        SayHi sayHi = (SayHi)c.newInstance();
        String s = sayHi.sayWorld("java");
        sayHi.say();
        System.out.println(s);

        Class c2 = SayHi.class;
        SayHi sayHi2 = (SayHi)c2.newInstance();
        sayHi2.say();
    }
}
