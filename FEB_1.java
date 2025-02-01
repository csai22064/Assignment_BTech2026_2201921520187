package JAN_27;

public class FEB_1 {
    private FEB_1(){}
    private static FEB_1 instances;
    public static FEB_1 getInstance(){
        if(instances == null) {
            instances = new FEB_1();
        }
        return instances;
    }

    public static void main(String[] args) {
        FEB_1 obj = FEB_1.getInstance();
        FEB_1 obj2 = FEB_1.getInstance();
        FEB_1 obj3 = FEB_1.getInstance();

        //all three reference variable are just pointing to same object
    }
}
