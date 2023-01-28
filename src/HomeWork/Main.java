package HomeWork;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) {

        // задача 1

        List<Integer> list = new ArrayList<> ();
        list.add ( 61 );
        list.add ( 23 );
        list.add ( 45 );
        list.add ( 13 );
        list.add ( 76 );
        list.add ( 10 );
        list.add ( 78 );
        list.add ( 33 );
        list.add ( 4 );
        Stream<Integer> emptyStream = Stream.empty ();
        Stream<Integer> streamList = list.stream ();
        findMinMax ( streamList , Comparator.comparingInt ( i -> i ) ,
                (x , y) -> System.out.println ( " Min " + x + "\n" + " Max " + y ) );
        findMinMax ( emptyStream , Comparator.comparingInt ( i -> i ) ,
                (x , y) -> System.out.println ( " Min " + x + "\n" + " Max " + y ) );

        // задача 2

        evenNumeric ( list );


    }

    public static <T> void findMinMax(Stream<? extends T> stream , Comparator<? super T> order , BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted ( order )
                .collect ( Collectors.toList () );
        if (arrayList.size () != 0) {
            min = arrayList.get ( 0 );
            max = arrayList.get ( arrayList.size () - 1 );
        }
        minMaxConsumer.accept ( min , max );
    }

    public static void evenNumeric(List<Integer> listNumeric) {
        List<Integer> evenNumericList = listNumeric.stream ()
                .filter ( x -> x % 2 == 0 )
                .collect ( Collectors.toList () );
        System.out.println ( "Список содержит следующие четные числа " + evenNumericList );
        System.out.println ( "Количество четных чисел " + evenNumericList.size () );
    }



}


