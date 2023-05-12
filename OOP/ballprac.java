public class ballprac {
    public static void main(String[] args){
        Car mycar = new Car("Nissan");
        mycar.carSounds();
        System.out.println(mycar);
    }
}

class Car{
    String carType;
    private Engine myengine = new Engine(10);


    public Car(String type){
        carType = type;
    }
    public void carSounds(){
        myengine.engineSound();
        myengine.engineSound();
    }
    public String toString(){
        return "Type: " + carType + myengine;
    }
}

class Engine{
    private int model;
    public Engine(int m){
        model = m;
    }
    public void engineSound(){
        System.out.print("Vroom Vroom");
    }
    public String toString(){
        return "Model: " + model;
    }
}