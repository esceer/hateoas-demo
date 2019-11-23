package com.example.demo.configuration;

import com.example.demo.paging.OffsetLimitPageableResolver;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class WebMvcConfiguration /* implements WebMvcConfigurer */ {

    @Autowired
    @Qualifier("repositoryExporterHandlerAdapter")
    private RequestMappingHandlerAdapter adapter;

    @PostConstruct
    public void prioritizeCustomArgumentMethodHandlers() {
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>(adapter.getArgumentResolvers());
        List<HandlerMethodArgumentResolver> customResolvers = adapter.getCustomArgumentResolvers();
        argumentResolvers.removeAll(customResolvers);
        argumentResolvers.addAll(0, customResolvers);
        argumentResolvers.add(0, new OffsetLimitPageableResolver());
        adapter.setArgumentResolvers(argumentResolvers);
    }

    //    @Override
    //    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    //        argumentResolvers.add(new OffsetLimitPageableResolver());

    //                PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
    //        resolver.setFallbackPageable(DEFAULT_PAGE_REQUEST);
    //        argumentResolvers.add(resolver);
    //    }
}
