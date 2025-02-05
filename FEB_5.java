package JAN_27;


abstract class Car {
    String name;
    int model;
    boolean is2ndHand;
    String maxSpeed;

    abstract void carType(String carType);
    abstract void carName(String name);

    public void car(){
        System.out.println("This method can show that normal method are also implemented in " +
                "abstract class");
    }

    static void stat(){
        System.out.println("This method show that static method can also be used in abstract classes");
    }

    public Car(String name, int model, boolean is2ndHand, String maxSpeed) {
        this.name = name;
        this.model = model;
        this.is2ndHand = is2ndHand;
        this.maxSpeed = maxSpeed;
    }
}


class Bugatti extends Car{
    public Bugatti(String name, int model, boolean is2ndHand, String maxSpeed) {
        super(name, model, is2ndHand, maxSpeed);//calling the constructor using super keyword
    }

    @Override // we need to override the method of the abstract classes to use it
    public void carType(String carType) {
        System.out.println("Hey, I am a super car");
    }

    @Override
    public void carName(String name) {
        System.out.println("My name is " + name);
    }
}


class RollsRoyce extends Car{
    public RollsRoyce(String name, int model, boolean is2ndHand, String maxSpeed) {
        super(name, model, is2ndHand, maxSpeed);//calling the constructor using super keyword
    }

    @Override // we need to override the method of the abstract classes to use it
    public void carType(String carType) {
        System.out.println("Hey, I am a " + carType + "car");
    }

    @Override
    public void carName(String name) {
        System.out.println("My name is " + name);
    }
}


public class FEB_5 {
    public static void main(String[] args) {
        System.out.println();
        //Car car = new Car();  you could not make object of the abstract classes
        //Car car = new Bugatti(); you can do this
        Car.stat();//as we can see that static method is called directly hence it is allowed in
        //abstract classes
        System.out.println();
        System.out.println();
        Bugatti bugatti = new Bugatti("Bugatti Sheron",2023,false,"300kmph");
        bugatti.carType("Super Car");
        bugatti.carName("Bugatti Sheron");
        bugatti.car();

        System.out.println("Car model : " + bugatti.model + ", Is the car is used before : " + bugatti.is2ndHand +
                ", Max Speed : " + bugatti.maxSpeed);
        System.out.println();
        System.out.println();

        System.out.println("New car is started from here !!!!");
        System.out.println();
        RollsRoyce rr = new RollsRoyce("Rolls Royce Phantom Limojin",2022,false,"190kmph");
        rr.carName("Rolls Royce Phantom Limojin");
        rr.carType("Royal Car");
        rr.car();

        System.out.println("Car model : " + rr.model + ", Is the car used before : " + rr.is2ndHand +
                ", Max Speed : " + rr.maxSpeed);
    }
}
