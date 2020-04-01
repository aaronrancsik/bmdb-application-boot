package com.example.bmdb.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

@Component
public class I18nMsg {

    @Inject
    private MessageSource messageSource;

    @Value("hu")
    private Locale locale;

    public String getMsg(String textName, Object... objects){
        return messageSource.getMessage(textName,  objects, locale);
    }
}
