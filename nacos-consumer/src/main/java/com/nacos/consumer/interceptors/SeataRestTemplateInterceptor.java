package com.nacos.consumer.interceptors;

import io.seata.core.context.RootContext;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StringUtils;

/**
 * RestTemplate拦截器，在请求头中加入seata全局事务xid，被调用方会自动解析请求头中的xid，并设置到seata上下文中
 */
@Slf4j
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        String xid = RootContext.getXID();
        if(!StringUtils.isEmpty(xid)) {

            //构建请求头，传递seata全局事务xid
            requestWrapper.getHeaders().add("TX_XID", xid);
        }
        return clientHttpRequestExecution.execute(requestWrapper, bytes);
    }
}
