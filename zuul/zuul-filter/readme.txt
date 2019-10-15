Zuul大部分功能都是通过过滤器实现的。

Zuul中定义了4中标准过滤器类型，谢谢过滤器类型对应请求的典型声明周期
    PRE：这种过滤器在请求被路由之前调用。可利用这种过滤器小hi爱心纳身份验证、记录调试信息等。
    ROUTING：这种过滤器将请求路由到微服务。
    POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、
        收集统计信息和指标、将响应从微服务发送给客户端。
    ERROR：在其他阶段发生错误时执行该过滤器。

@EnableZuulProxy默认启用的过滤器
    PRE类型过滤器：
        1.ServletDetectionFilter：该过滤器用于检查请求是否通过Spring Dispatcher。检查后，通过
            FilterConstants.IS_DISPATCHER_SERVLET_REQUEST_KEY设置布尔值。
        2.FormBodyWrapperFilter：解析表单数据，并为请求重新编码。
            *
            *该过滤器并不高效，若没有表单提交，可禁用改过滤器zuul.FormBodyWrapperFilter.pre.disabled=true
            *https://blog.csdn.net/u010739551/article/details/84881226
            *
        3.DebugFilter：调式过滤器。当设置zuul.include-debug-header=true抑或设置zuul.debug.request=true，
            并在请求时，加上?debug=true的参数，就会开启改过滤器。该过滤器会把RequestContext.setDebugRouting()
            以及RequestContext.setDebugRequest()设置为true。
        4.PreDecorationFilter：该过滤器根据提供的RouteLocator确定路由到的地址，以及怎样去路由。同时，
            该过滤器还为下游请求设置各种代理相关的header。
    route类型过滤器：
        1.SendForwardFilter：该过滤器使用Servlet RequestDispatcher转发请求，转发位置存储在RequestContext
            的属性FilterConstants.FORWARD_TO_KEY中。这对转发到Zuul自身的端点很有用。
            可将路由设置成：
            zuul:
                routes:
                    abc:
                        path: /path-a/**
                        url: forward:/path-b
        2.RibbonRoutingFilter：该过滤器使用Ribbon、Hystrix和可插拔的HTTP客户端发送请求。serviceId
            在RequestContext的属性FilterConstants.SERVICE_ID_KEY中。
            可使用的客户端：
                Apache HttpClient：默认的Http客户端
                OkHttpClient：使用时，需要设置ribbon.okhttp.enabled=true
                Netflix Ribbon Http Client：使用时，设置ribbon.restclient.enabled=true，有一定的限制
                    不支持patch方法，另外，它有内置的重试机制。
        3.SimpleHostRoutingFilter：该过滤器通过Apache HttpClient向指定URL发送请求。

    post类型过滤器：
        SendResponseFilter：将代理请求的响应写入当前响应。
    error类型过滤器：
        SendErrorFilter：若RequestContext.getThrowable()不为null，则默认转发到/error，也可以设置
            error.path属性来修改默认的转发路径。


使用Zuul过滤器可以做很多事情，例如安全认证、灰度发布、限流等
限流：http://www.itmuch.com/spring-cloud-sum/spring-cloud-ratelimit/
传播安全Token：https://gitee.com/itmuch/spring-cloud-yes/blob/master/zuul-server/src/main/java/com/itmuch/yes/KeycloakRouteZuulFilter.java