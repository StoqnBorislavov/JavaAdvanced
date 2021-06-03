package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Comparator<Integer> comparator = ((first, second) ->{
          if(Math.abs(first) % 2 == 0 && Math.abs(second) % 2 == 1){
              return -1;
          } else if(Math.abs(first) % 2 == 1 && Math.abs(second) % 2 == 0){
              return 1;
          } else if((Math.abs(first) % 2 == 0 && Math.abs(second) % 2 == 0) || (Math.abs(first) % 2 == 1 && Math.abs(second) % 2 == 1)){
              if(first > second){
                  return 1;
              } else {
                  return -1;
              }
          }
          return 0;
        });
        numbers.sort(comparator);
        numbers.forEach(e -> System.out.print(e + " "));

    }
}
