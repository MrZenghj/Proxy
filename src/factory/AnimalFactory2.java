package factory;
/**
 *     反射生产
 * */
public class AnimalFactory2 {

    public static void main(String[] args) {
        Cat c = getAnimal(Cat.class);
        c.animal();
    }
    public static <T extends Animal> T getAnimal(Class<T> claszz){
        T result = null;
        try {
            result =(T)Class.forName(claszz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return result;
    }
}
