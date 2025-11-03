package com.orangehrm.demo.questions;

import com.orangehrm.demo.ui.EmployeeOrangeHrmUi;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

public class ValidateInformationEmployee {

    public static Question<String> completeName(String expectedName) {
        return actor -> EmployeeOrangeHrmUi.NAME_DIRECTORY(expectedName).resolveFor(actor).getText().trim();
    }

    public static Question<String> profileImageSrc() {
        return actor -> Attribute.of(EmployeeOrangeHrmUi.IMAGE_DIRECTORY)
                .named("src")
                .answeredBy(actor);
    }





}
