package Zuul;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


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

	@Override
	public String filterType() {
		return "pre";
	}

	// 該過濾器是否需要被執行
	@Override
	public boolean shouldFilter() {
		return true;
	}
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		/*
		logger.info("--->>> PreFilter"+ request.getMethod() + "," + request.getRequestURL().toString());
		
		String url = request.getRequestURI();
		String[] split1 = url.split("/");
		String[] split2 = split1[0].split("?");
		
		String serviceId = split2[0];*/
		/*
		if(serviceId == null || serviceId.isEmpty() || !serviceId.equals(service)) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("service is not" + service + ": " + url);
		}
*/
	    return null;
    }
}
