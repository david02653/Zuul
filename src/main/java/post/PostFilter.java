package post;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


import java.util.logging.*;


@Configuration
public class PostFilter extends ZuulFilter {
	final Logger logger = Logger.getLogger(getClass().getName());
	
	// 數字越大，優先級越低
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
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
		
		logger.info("--->>> PostFilter：  "+ request.getMethod() + "," + request.getRequestURL().toString());
		
        return null;
    }
}
