package Zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import error.ErrorFilter;
import post.PostFilter;
import pre.PreFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	
	// 處理CORS跨網域問題
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("POST");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
	
	// 要創建此Bean才能執行過濾器
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
	
	@Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
	
	@Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

}



