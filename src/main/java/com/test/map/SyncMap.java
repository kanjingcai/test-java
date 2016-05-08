package com.test.map;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SyncMap {

	
	public static void main(String[] args) {
		Map<String ,Date> last = Collections.synchronizedMap(new HashMap<String,Date>());
		
	}
}
