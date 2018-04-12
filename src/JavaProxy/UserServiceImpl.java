package JavaProxy;

public class UserServiceImpl implements UserService{

    @Override
    public String getName() {
        System.out.println("执行业务...");
        return "Snipe hello";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

        }
    }
}
