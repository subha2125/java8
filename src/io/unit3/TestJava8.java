package io.unit3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {

	public static void main(String[] args) {
		String subStatusReasonCodes = "MPSUSPD|AWLSUS";
        List<String> errorCodes = new ArrayList<>();
        Stream.of(subStatusReasonCodes.split("\\|")).collect(Collectors.toList()).forEach(errorCodes::add);
        System.out.println(errorCodes);
        if(errorCodes.contains("AWLSUS")) {
           System.out.println("TYes");
        }
	}

}
