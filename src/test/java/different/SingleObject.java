package different;

public class SingleObject {


    // create an object of SingleObject:
    private static SingleObject instance = new SingleObject();

    // make the constructor private ao that class cannot be instantiated:
    private SingleObject(){}

     // get the only object available
    public static SingleObject getInstance(){
        return instance;
    }




}
