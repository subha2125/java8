package com.java8.interview.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumDigit {

	public static void main(String[] args) {
		Integer num = 124567;
		
		List<String> sNum = Arrays.asList(String.valueOf(num).split(""));
		int sumDigit = sNum.stream().mapToInt(s -> Integer.parseInt(s)).sum();
		System.out.println("Sum of Digit.."+ sumDigit);
		
		Stream<Integer> lList =  Stream.of(1,2,5,8,3,8);
		lList.filter(x -> x%2==0).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		
		//List sort desending
		LinkedList<Integer> ll = new LinkedList<>();

		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println(ll);

		LinkedList<Integer> ll1 = new LinkedList<>();

		ll.descendingIterator().forEachRemaining(ll1::add);

		System.out.println(ll1);
		
		
		//Sum Arrays
		
		Integer[] array = { 1, 7, 3, 6, 5 };
		List<Integer> arrayNum = Arrays.asList(array);
		
		int sum = arrayNum.stream().mapToInt(x -> x).sum();
				
		System.out.println(sum );
		System.out.println("\n\n");
		Arrays.sort(array, (x,y) -> {
			if(x < y) {
				return 1;
			}else
				return 0;
		});
		for(int i : array) {
			System.out.println(i);	
		}
		
		
		
		Map<String, Integer> scores = new HashMap<>();

		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Xmas", 60);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);
		
		scores.entrySet().stream().sorted(Map.Entry.comparingByKey());
		for(Map.Entry<String, Integer> m : scores.entrySet()) {
			System.out.println(m.getKey()+m.getValue());
		}
		
		Map<Object,Object> result = scores.entrySet().stream()
			    .sorted(Map.Entry.comparingByKey()) 			
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		System.out.println(result);
		
		Predicate<Integer> p = n ->  {
			if (n == 0 || n == 1) {
				return false;
			}
			if (n == 2) {
				return true;
			}
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					return false;
				}
			}

			return true;
		};
		
		System.out.println("Is Prime:"+p.test(11));
	}
}
