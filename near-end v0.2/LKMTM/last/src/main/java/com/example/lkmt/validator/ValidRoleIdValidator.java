package com.example.lkmt.validator;


import com.example.lkmt.entity.Role;
import com.example.lkmt.validator.annotation.ValidRoleId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidRoleIdValidator implements ConstraintValidator<ValidRoleId, Role>{
    @Override
    public boolean isValid(Role role, ConstraintValidatorContext context){
        return role != null && role.getId() != null;
    }
}
