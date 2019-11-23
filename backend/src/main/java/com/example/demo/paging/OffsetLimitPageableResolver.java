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
        Pageable pageable = new OffsetLimitPageable(Integer.parseInt(params.get("offset")[0]), Integer.parseInt(params.get("limit")[0]));
        return new DefaultedPageable(pageable, false);
    }
}
