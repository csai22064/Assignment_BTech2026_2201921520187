package JAN_27;

public class FEB_3 {
     public static void validate(int age) throws Exception {
        if(age < 18){
            throw new Exception("Not eligible to vote");
        }
        else{
            System.out.println("Eligible to vote");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age : ");
        int age = sc.nextInt();
        validate(age);
    }
}
