package hystrix;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





@Component
public class MyFallbackProvider implements FallbackProvider {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	/*
	 * 指名要返回的服務，如果全部的話就return "*"
	 * */
	public String getRoute() {
		return "*";
	}
	
	/*
	 * 如果請求服務失敗，返回什麼訊息給客戶端
	 * */
	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			public InputStream getBody() throws IOException {
				JSONObject r = new JSONObject();
				r.put("state", "9999");
				r.put("msg", "系統錯誤，請求失敗。");
				return new ByteArrayInputStream(r.toJSONString().getBytes("UTF-8"));
			}
			
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				// 和body中的內容編碼一致，否則容易亂碼
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
			
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
 
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}
 
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}
 
			public void close() {
 
			}

		};
	}
	
	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		if (cause != null && cause.getCause() != null) {
			String reason = cause.getCause().getMessage();;
			logger.info("Excption :{}" , reason);
	    }
	    return fallbackResponse();
	}
	
}
