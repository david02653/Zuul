package error;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


import java.util.logging.*;


@Configuration
public class ErrorFilter extends ZuulFilter {
	final Logger logger = Logger.getLogger(getClass().getName());
	
	// 數字越大，優先級越低
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
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
		
		logger.info("--->>> ErrorFilter： "+ request.getMethod() + "," + request.getRequestURL().toString());
		
		
		Throwable throwable = ctx.getThrowable();
        /*
        int statusCode = (Integer) ctx.get("error.status_code");
        Object e = ctx.get("error.exception");
        String message = (String) ctx.get("error.message");
        */
        
        logger.log(Level.SEVERE, "this is a ErrorFilter :" + throwable.getCause().getMessage(), throwable);
        
        ctx.set("error.exception",throwable.getCause());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.message",throwable.getCause().getMessage());
        
        
        /*
        ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ctx.setResponseBody("this is a ErrorFilter :" + throwable.getCause().getMessage());
		*/
        
        return null;
    }
}
