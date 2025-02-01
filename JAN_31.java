package JAN_27;

import java.util.ArrayList;
import java.util.function.Consumer;

public interface JAN_31 {
    int operation(int a, int b);
}
class LambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + 1);
        }

        //() -> statement; this is lambda expression
        // ()-> this is lambda function
        //no need to mention the name of the function
        // lambda expression is applied when we want our code to be one-liner
        // we can only use lambda expression when we use functional interfaces

        list.forEach((item) -> System.out.print(item * 2 + "\t"));
        System.out.println();
        //method of printing list using for each method with lambda expression

        Consumer<Integer> fun = (item) -> System.out.print(item * 2 + "\t");
        list.forEach(fun);

        //another method for using lambda expression

        JAN_31 sum = Integer::sum;
        JAN_31 product = (a,b) -> a * b;
        JAN_31 subtract = (a,b) -> a - b;
        System.out.println();

        LambdaFunction calculate = new LambdaFunction();
        System.out.println(calculate.operate(2,4,product));
    }


    private int operate(int a,int b, JAN_31 op){
        return op.operation(a,b);
    }

}

