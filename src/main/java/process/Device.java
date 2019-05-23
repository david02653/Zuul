package process;

public class Device {
	
	public static boolean isMobileDevice(String requestHeader) {
		/*
		 * android : 所有android設備
		 * mac os : iphone ipad
		 * window phone: Nokia等Windows手機*/
		
		final String[] deviceArray = new String[] {"android","mac os","windows phone"};
		
		if(requestHeader == null)
			return false;
		
		requestHeader = requestHeader.toLowerCase();
		for( int i = 0 ; i < deviceArray.length; i++) {
			if(requestHeader.contains(deviceArray[i]))
				return true;
		}
		
		return false;
	}
	
}
