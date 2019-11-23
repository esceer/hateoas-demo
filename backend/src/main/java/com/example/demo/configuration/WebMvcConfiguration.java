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
public class WebMvcConfiguration {

    @Autowired
    @Qualifier("repositoryExporterHandlerAdapter")
    private RequestMappingHandlerAdapter adapter;

    @PostConstruct
    public void prioritizeCustomPageableResolvers() {
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>(adapter.getArgumentResolvers());
        argumentResolvers.add(0, new OffsetLimitPageableResolver());
        adapter.setArgumentResolvers(argumentResolvers);
    }
}

