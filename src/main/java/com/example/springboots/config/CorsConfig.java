package com.example.springboots.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Administrator
 * @create 2018/3/12-15:17
 * @DESCRIPTION 跨域系统配置
 */
@Configuration
public class CorsConfig {

    /**
     * 初始化cors配置对象
     *
     * @param
     * @return 
     * @description TODO
     * @author dongye2@iflytek.com
     * @date 2019/07/26 16:32
     */
    private CorsConfiguration buildConfig() {
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域的域名。如果需要携带cookie 不能写*. *:代表所有的域名都可以跨域访问
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        // allowCredential 允许携带cookie 需设置为true
        corsConfiguration.setAllowCredentials(true);
        //允许所有的请求方法 GET POST PUT DELECT,,,,,
        corsConfiguration.addAllowedHeader("*");
        //允许携带任何头信息
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 初始化cors配置源
     *
     * @param
     * @return
     * @description TODO
     * @author dongye2@iflytek.com
     * @date 2019/07/26 16:36
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
