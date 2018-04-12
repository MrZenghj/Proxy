package factory;
/**
 *     静态工厂多方法生产方法
 * */
public class AnimalFactory {

    public static Cat createCat(){
        return new Cat();
    }
    public static Dog createDog(){
        return new Dog();
    }
    public static Tiger createTiger(){
        return new Tiger();
    }

}
