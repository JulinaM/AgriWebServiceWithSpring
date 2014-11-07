package com.mkyong.customer.validator;

import com.mkyong.customer.model.Info;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class InfoValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Info.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "required.title", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body",
                "required.body", "Field name is required.");

        Info info = (Info) target;
        if(info.getCropIds().length == 0 && info.getLocationIds().length== 0){
            errors.rejectValue("locationIds","required.locations");
            errors.rejectValue("cropIds","required.crop");
        }

    }
	
}