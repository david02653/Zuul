package Zuul;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
public class PreFilter extends ZuulFilter {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
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
		
		logger.info("--->>> PreFilter {},{}", request.getMethod(), request.getRequestURL().toString());
		
		/*
		Principal principal = request.getUserPrincipal();
		String userId = principal.getName();
	    ctx.addZuulRequestHeader("X-AUTH-ID",userId);
	    
	    // 別的服務可以透過下面code獲得參數
	    // String user = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("X-AUTH-ID");
	    */
		
		/*
		String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
        }
		*/
		
	    return null;
    }
}
