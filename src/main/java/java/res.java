package java;

public class res {
	
	public static String serviceName(String url) {
		String temp = "";
		
		if(url.contains("/")) {
			temp = url.split("/")[1];
			if(temp.contains("?"))
				temp = url.split("?")[0];
		}
		
		return temp;
	}
	
}
