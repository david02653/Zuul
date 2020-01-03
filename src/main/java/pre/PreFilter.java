package pre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import process.*;

import java.util.logging.*;


@Configuration
public class PreFilter extends ZuulFilter {
	final Logger logger = Logger.getLogger(getClass().getName());
	final String service = "service-provider";
	
	// 數字越大，優先級越低
	@Override
	public int filterOrder() {
		return 0;
	}
	
	// Filter種類
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	// 該過濾器是否需要被執行
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	// Filter執行
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		String requestHeader = request.getHeader("user-agent");
		
		logger.info("--->>> PreFilter： "+ request.getMethod() + "," + request.getRequestURL().toString());
		
		logger.info("--->>> header: " + requestHeader);
		
		if(Device.isMobileDevice(requestHeader))
			logger.info("--->>> 使用手機瀏覽器");
		else
			logger.info("--->>> 使用電腦瀏覽器");
		
		
		

		
		String url = request.getRequestURI().toString();
		String serviceId = Res.splitServiceId(url);
		
		if(serviceId != null || !serviceId.isEmpty() || serviceId.equals(service)) {
			// do something
		}
		
	    return null;
    }
}
