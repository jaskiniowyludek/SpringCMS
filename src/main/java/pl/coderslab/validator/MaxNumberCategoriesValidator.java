package pl.coderslab.validator;

import pl.coderslab.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MaxNumberCategoriesValidator implements ConstraintValidator<MaxNumberCategories, List<Category>> {
    private int maxNumber;
    @Override
    public void initialize(MaxNumberCategories maxNumberCategories) {
        this.maxNumber= maxNumberCategories.value();
    }

    @Override
    public boolean isValid(List<Category> value, ConstraintValidatorContext constraintValidatorContext) {
        return value.size()<=maxNumber;
    }
}
