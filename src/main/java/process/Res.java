package process;

public class Res {
	
	public static String splitServiceId(String url) {
		String temp = "";
		
		if(url.contains("/")) {
			temp = url.split("/")[1];
			if(temp.contains("?"))
				temp = url.split("?")[0];
		}
		
		return temp;
	}
	
}
