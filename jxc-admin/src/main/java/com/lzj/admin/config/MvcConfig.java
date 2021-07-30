package com.lzj.admin.config;

import com.lzj.admin.interceptors.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.config]
 * @ClassName: [MvcConfig]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-07-30  21:55]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-07-30  21:55]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public NoLoginInterceptor noLoginInterceptor() {
        return new NoLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(noLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index","/user/login",
                        "/css/**","/error/**","/images/**","/js/**","/lib/**");
    }
}
