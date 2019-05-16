package Zuul;

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
        
        return "錯誤訊息";
    }
}
