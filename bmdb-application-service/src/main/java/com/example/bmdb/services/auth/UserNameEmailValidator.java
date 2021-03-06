package com.example.bmdb.services.auth;

import com.example.bmdb.models.User;
import com.example.bmdb.services.user.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.inject.Inject;

@Component
public class UserNameEmailValidator implements Validator {

    private UserEmailValidator userEmailValidator;

    @Inject
    public void setUserEmailValidator(UserEmailValidator userEmailValidator) {
        this.userEmailValidator = userEmailValidator;
    }

    private UserNameValidator userNameValidator;

    @Inject
    public void setUserNameValidator(UserNameValidator userNameValidator) {
        this.userNameValidator = userNameValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        userNameValidator.validate(o, errors);
        userEmailValidator.validate(o, errors);
    }
}
