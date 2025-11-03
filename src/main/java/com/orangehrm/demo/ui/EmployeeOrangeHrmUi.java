package com.orangehrm.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeOrangeHrmUi {

    public static final Target SECTION_PIM = Target.the("where selection module 'PIM'").
            located(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));

    public static final Target BUTTON_ADD_EMPLOYEE = Target.the("button add employee").
            located(By.xpath("//a[contains(text(), 'Add Employee')]"));

    public static final Target BUTTON_UPLOAD_AVATAR = Target.the("button for upload image/avatar of employee").
            located(By.xpath("//i[@class='oxd-icon bi-plus']/parent::button"));

    public static final Target INPUT_UPLOAD_AVATAR = Target.the("button for upload image/avatar of employee").
            located(By.cssSelector("input.oxd-file-input"));

    public static final Target INPUT_FIRSTNAME = Target.the("input for text firstname").
            located(By.xpath("//input[@placeholder='First Name']"));

    public static final Target INPUT_MIDDLENAME = Target.the("input for text middleName").
            located(By.name("middleName"));

    public static final Target INPUT_LASTNAME = Target.the("input for text lastName").
            located(By.name("lastName"));

    public static final Target BUTTON_SAVE_EMPLOYEE = Target.the("button submit").
            located(By.xpath("//button[@type='submit']"));


    public static final Target PLACEHOLDER_IMAGE_EXISTS = Target.the(" IMAGE EXISTS ").
            located(By.xpath("//img[@class='employee-image']"));

    public static final Target INPUT_EMPLOYEE_ID = Target.the(" input employee id ").
            located(By.xpath("(//input[contains(@class, 'oxd-input')])[5]"));



    public static final Target IMAGE_VALUE = Target.the(" input employee id ").
            located(By.xpath("//img[@class='employee-image']"));



    public static final Target SECTION_DIRECTORY = Target.the(" Section Directory ").
            located(By.xpath("(//a[@class='oxd-main-menu-item'])[8]"));

    public static final Target PLACEHOLDER_DIRECTORY_NAME = Target.the(" input employee id ").
            located(By.xpath("//input[@placeholder='Type for hints...']"));


    public static final Target BUTTON_SEARCH = Target.the(" button search ").
            located(By.xpath("//button[@type='submit']"));

    public static Target NAME_DIRECTORY(String employeeName) {
        return Target.the("Nombre en el directorio")
                .locatedBy("//p[contains(normalize-space(.),'" + employeeName + "')]");
    }

    public static Target IMAGE_DIRECTORY = Target.the(" IMAGE DIRECTORY").
            located(By.xpath("//img[contains(@class,'orangehrm-profile-picture-img')]"));







    ///




}
