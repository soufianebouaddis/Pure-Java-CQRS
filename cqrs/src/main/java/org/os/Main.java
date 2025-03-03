package org.os;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (a)->{
            System.out.println("lambda parameters is : "+a);
        };
        BiConsumer<Integer,Integer> biConsumer = (a,b) -> {
            System.out.println("Sum biConsumer parameters => "+(a+b));
        };
        Supplier<Integer> supplier = () -> (int) (10+Math.random() * 100);
        List<Integer> orgList1 = List.of(1,2,3,4,5);
        List<Integer> orgList2 = List.of(1,3,3,4,5);
        BiConsumer<List<Integer>, List<Integer>> equals = (list1,list2) -> {
            for (int i = 0; i < list1.size(); i++)
                if (list1.get(i) != list2.get(i)) {
                    System.out.println("False");
                    return;
                }
            System.out.println("True");
        };
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };
        equals.andThen(disp).accept(orgList1,orgList2);
    }
}