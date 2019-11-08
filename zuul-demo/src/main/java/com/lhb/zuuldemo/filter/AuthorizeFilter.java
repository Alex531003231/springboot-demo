package com.lhb.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @description:
 */
@Component
public class AuthorizeFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeFilter.class);
    private static String accessToken;

    public AuthorizeFilter() {
        accessToken = UUID.randomUUID().toString();
        logger.info(" ===> accessToken:{}", accessToken);
    }

    /**
     * 外部请求 --> Zuul -(pre)-> 路由 -(routing)-> 请求服务 -(post)->  Zuul
     * pre (在请求路由之前执行)
     * routing (在请求路由之后执行)
     * post (在请求服务到服务之后执行)
     * error (在其他阶段发生错误时执行)
     *
     * @return 过滤器的类型是什么
     */

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 需不需要执行过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取当前上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取当前request对象
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getParameter("access_token");
        //模拟accessToken授权
        if (Objects.equals(accessToken, AuthorizeFilter.accessToken)) {
            requestContext.setResponseStatusCode(HttpStatus.OK.value());
            requestContext.setResponseBody("authorized");
            requestContext.setSendZuulResponse(false);
        } else {
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            //设置当前请求需不需要再去做Zuul转发
            requestContext.setSendZuulResponse(false);
        }


        return AuthorizeFilter.accessToken;
    }
}
