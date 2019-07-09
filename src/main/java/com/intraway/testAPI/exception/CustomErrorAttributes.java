package com.intraway.testAPI.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable throwable = getError(webRequest);
        if (throwable != null && throwable.getClass().getName() != null) {
            errorAttributes.put("exception", throwable.getClass().getName());
        }
        errorAttributes.put("timestamp", System.currentTimeMillis());
        errorAttributes.remove("trace");

        return errorAttributes;

    }

}
