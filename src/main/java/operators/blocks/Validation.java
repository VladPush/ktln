package operators.blocks;



import javafx.scene.control.Label;
import operators.Entity.StatisticEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class Validation {

    public boolean val(StatisticEntity entity, Label warningLabel) { //усовершенствовать для разных ConstraintViolation<?????>
        Validator val = javax.validation.Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<StatisticEntity>> violations = val.validate(entity);
        StringBuilder message=new StringBuilder();
        violations.stream().forEach(p-> message.append(p.getMessage()+ "\n"));
        warningLabel.setText(message.toString());
        return violations.isEmpty();
    }
}
