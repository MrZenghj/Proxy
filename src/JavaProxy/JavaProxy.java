package JavaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxy {

    public static void main(String[] args){
       UserService userService = (UserService) Proxy.newProxyInstance(JavaProxy.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            UserServiceImpl target = new UserServiceImpl();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               System.out.println("执行前...");
               Object obj = method.invoke(target, args);
               System.out.println("执行后...");
                return obj;
            }
        });
        userService.getName();
    }
}
