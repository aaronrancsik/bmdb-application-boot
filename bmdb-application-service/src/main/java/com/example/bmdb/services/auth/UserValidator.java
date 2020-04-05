package com.example.bmdb.services.auth;

import com.example.bmdb.models.User;
import com.example.bmdb.services.user.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.inject.Inject;


@Component
public class UserValidator implements Validator {


    private UserService userService;
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    UserNameEmailValidator userNameEmailValidator;
    @Inject
    public void setUserNameEmailValidator(UserNameEmailValidator userNameEmailValidator) {
        this.userNameEmailValidator = userNameEmailValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        userNameEmailValidator.validate(o,errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }


}
