package pl.coderslab.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MaxNumberCategoriesValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxNumberCategories {

    int value();
    String message() default "Max number of categories is 5";
    Class<?>[]	groups()	default	{};

    Class<?	extends Payload>[]	payload()	default	{};
}
