package Zuul;
/*
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.zuul.context.RequestContext;

@Controller
public class GlobalErrorController implements ErrorController{
	@Override
    public String getErrorPath() {
        return "/error";
    }
    
	
    @ResponseBody
    @RequestMapping("/error")
    public String error() {
    	RequestContext ctx = RequestContext.getCurrentContext();
    	
    	String exception = (String)ctx.get("error.exception");
    	int status_code = (int)ctx.get("error.status_code");
    	String message = (String)ctx.get("error.message");
    	
    	
    	
        //return String.format("Exception: %s\n status_code: %d\n error message: %s", exception, status_code, message);
    	
    	return "error message.";
    }

}
*/