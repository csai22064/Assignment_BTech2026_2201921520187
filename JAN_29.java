package JAN_27;


class A {
    public void fun(){
        System.out.println("Enjoying.....");
    }
}
class B extends A{

    //this is called overriding
    //means changing the variables or methods definition in the subclass
    public void fun(){
        System.out.println("Enjoying very much...........:)");
    }
}
public class JAN_29 {
    public static void main(String[] args) {
        A a = new A();
        a.fun();
        //this will print the method of A
        A ab = new B();
        ab.fun();
        //this will print the method of B
        //because of overriding
        B b = new B();
        b.fun();
        //this will print the method of B
    }
}
