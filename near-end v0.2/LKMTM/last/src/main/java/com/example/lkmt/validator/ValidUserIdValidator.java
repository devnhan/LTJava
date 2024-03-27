package com.example.lkmt.validator;

import com.example.lkmt.entity.User;
import com.example.lkmt.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User>{
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user == null)
            return true;
        return user.getId() != null;
    }
}
