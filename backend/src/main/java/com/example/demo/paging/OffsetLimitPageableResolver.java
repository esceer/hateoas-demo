package com.example.demo.paging;

import java.util.Map;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.support.DefaultedPageable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class OffsetLimitPageableResolver implements HandlerMethodArgumentResolver {

    private static final String DEFAULT_OFFSET = "0";
    private static final String DEFAULT_LIMIT = "20";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return DefaultedPageable.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
        MethodParameter methodParameter,
        ModelAndViewContainer modelAndViewContainer,
        NativeWebRequest webRequest,
        WebDataBinderFactory webDataBinderFactory) {
        Map<String, String[]> params = webRequest.getParameterMap();

        int offset = Integer.parseInt(params.getOrDefault("offset", new String[] { DEFAULT_OFFSET })[0]);
        int limit = Integer.parseInt(params.getOrDefault("limit", new String[] { DEFAULT_LIMIT })[0]);

        Pageable pageable = new OffsetLimitPageable(offset, limit);
        return new DefaultedPageable(pageable, false);
    }
}
