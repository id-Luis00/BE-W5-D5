package luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (Enum<?> enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equals(value)) {
                return true;
            }
        }

        return false;
    }

}
