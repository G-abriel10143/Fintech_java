package utils;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class StringUtils {
	public static String join(String separator, List<Object> list) {
		String str = "";
		
		for(int i=0; i < list.size(); i++) {
			// TODO abstrair melhor
			if(list.get(i) instanceof Date) {
				str += String.format(
					"TO_DATE(%s, 'YYYY-MM-DD')",
					new SimpleDateFormat("yyyy-MM-dd").format(list.get(i))
				);
			} else {
				str += list.get(i);
			}
			
			if(i + 1 < list.size()) {
				str += separator;
			}
		}
		
		return str;
	}
}
