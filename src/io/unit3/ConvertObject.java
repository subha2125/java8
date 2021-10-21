package io.unit3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertObject {

	public static void main(String[] args) {
		List<Staff> staff = Arrays.asList(new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)), new Staff("lawrence", 33, new BigDecimal(30000)));
		
		
		List<StaffPublic> result = staff.stream().map(tempObj ->{
			 StaffPublic obj = new StaffPublic();
	            obj.setName(tempObj.getName());
	            obj.setAge(tempObj.getAge());
	            if ("mkyong".equals(tempObj.getName())) {
	                obj.setExtra("this field is for mkyong only!");
	            }
	            return obj;
		}).collect(Collectors.toList());
		
		System.out.println(result);
	}

}
