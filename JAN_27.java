package JAN_27;

public class JAN_27 {
    //this is how constructor overloading happens
    JAN_27(){
        System.out.println("No values are passed, hence, it is a default constructor");
    }

    JAN_27(double side){
        System.out.println("Volume of Cube is : " + side * side * side);
    }

    JAN_27(double r, double h){
        System.out.println("Volume of Cylinder is : " + Math.PI * r * r * h);
    }

    JAN_27(double l, double b, double h){
        System.out.println("Volume of Cuboid is :" + l * b * h);
    }

    public static void main(String[] args) {
        //this is default one
        JAN_27 v = new JAN_27();
        //this is for one variable
        JAN_27 cube = new JAN_27(2);
        //this is for two variables
        JAN_27 cylinder = new JAN_27(2,10);
        //this is for three variables
        JAN_27 cuboid = new JAN_27(2,4,5);
    }
}
