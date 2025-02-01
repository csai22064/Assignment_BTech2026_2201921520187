package JAN_27;

public class JAN_28 {
    //for no variable
    public static void sum(){
        System.out.println("Nothing to add.");
    }
    //for one variable
    public static void sum(int a){
        System.out.println("Needed two variable to do sum operation.");
    }
    //for two variable
    public static void sum(int a, int b){
        System.out.println("Sum is : " + (a + b));
    }
    //for three variable
    public static void sum(double c, double d){
        System.out.println("Sum is : "  + (c + d));
    }

    public static void sum(int a, int b, int c){
        System.out.println("Sum is : " + (a + b + c));
    }

    public static void main(String[] args) {
        //calling all the functions
        //this is known as method overloading
        sum();
        sum(2);
        sum(2,3);
        sum(2.5,6.7);
        sum(2,3,4);
    }
}
