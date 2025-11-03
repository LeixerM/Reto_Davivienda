package com.orangehrm.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginOrangeHrmUi {

    public static final Target INPUT_USER = Target.the("where do writer user").
            located(By.name("username"));

    public static final Target INPUT_PASSWORD = Target.the("where do writer password").
            located(By.name("password"));

    public static final Target BUTTON_LOGIN = Target.the("where button Login").
            located(By.xpath("//button[@type='submit']"));

}
