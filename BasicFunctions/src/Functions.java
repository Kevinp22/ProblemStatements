import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Functions {

	public static void main(String[] args) {
//		Reverse a String
				String str = "Spacemonk";
				String reversedString ="";
				for(int l = str.length() - 1; l >= 0 ;l--) {
					reversedString = reversedString + str.charAt(l);
				}
				System.out.println(reversedString);

		Map<String, Integer> toReverse = new HashMap<String, Integer>();
		toReverse.put("Kevin", 8);
		toReverse.put("yash", 3);
		toReverse.put("zaid", 5);
		toReverse.put("mayuresh", 6);
		Map<String, Integer> temp = toReverse.entrySet()
				.stream()
				.sorted((i1, i2)
						-> i1.getValue().compareTo(
								i2.getValue()))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(temp);

		//		 List<Map.Entry<String, Integer> > list = new ArrayList<Map.Entry<String, Integer> >(toReverse.entrySet());
		//		 Collections.sort(list ,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
		//		 //		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>(toReverse.entrySet());
		//		 
		//		
		//		 HashMap<String, Integer> temp = new HashMap<String, Integer>();
		//     for (Map.Entry<String, Integer> aa : list) {
		//         temp.put(aa.getKey(), aa.getValue());         
		//     }
		//     System.out.println(temp);

		//		System.out.println(isPrimeNumber(29));
		List<String> list = List.of("Spacemonk", "Kevin", "Yash","Zaid","Mayuresh");

		List<String> modifiablelist = new ArrayList<String>(list);
		Collections.sort(modifiablelist);
		//		System.out.println(list);
		System.out.println(modifiablelist);

		System.out.println(BinarySearch(modifiablelist, "Kevin"));

	}
	public static String isPrimeNumber(Integer num) {
		Boolean flag = false;
		for(int i =2;i <=num /2;i++) {
			if(num % i ==0) {
				flag = true;
				break;
			}
		}
		if (!flag)
			return num + " is a prime number.";
		else
			return num + " is not a prime number.";
	}

	public static String  BinarySearch(List<String> sortedList, String target) {
		Integer left = 0;
		Integer right = sortedList.size();

		while(left<=right) {
			int  mid = left + (right - left) / 2;

			Integer comparation = target.compareTo(sortedList.get(mid));
			if(comparation == 0) {
				return "Element found at index "+mid;
			}

			else if(comparation < 0) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}

		}
		return "Not found";
	}

}
