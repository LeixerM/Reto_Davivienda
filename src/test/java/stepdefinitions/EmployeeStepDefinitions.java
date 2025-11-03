package stepdefinitions;

import com.orangehrm.demo.models.DataEmployee;
import com.orangehrm.demo.models.DataLogin;
import com.orangehrm.demo.questions.ValidateInformationEmployee;
import com.orangehrm.demo.tasks.CreateEmployee;
import com.orangehrm.demo.tasks.CredentialsLogin;
import com.orangehrm.demo.tasks.NavigateTo;
import com.orangehrm.demo.ui.EmployeeOrangeHrmUi;
import com.orangehrm.demo.utils.RandomDataGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.lang.ref.Cleaner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

   @Given("Since the user is on the OrangeHRM page")
   public void since_the_user_is_on_the_orange_hrm_page(DataTable dataTable) {
       List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
       Map<String, String> first = rows.get(0);
       theActorInTheSpotlight().wasAbleTo(
               NavigateTo.navigatePageOrangeHrm(),
               CredentialsLogin.withCredentials(first.get("user"), first.get("password"))
       );
   }

    @When("the user creates the employee")
    public void the_user_creates_the_employee() {


        Path pathImage = Paths.get("src/test/resources/images/appium.png").toAbsolutePath();
        String firstName = RandomDataGenerator.genetateFirstName();
        String middleName = RandomDataGenerator.generateMiddleName();
        String lastName = RandomDataGenerator.generateLastName();
        String idEmployee = RandomDataGenerator.generateEmployeeID();

        DataEmployee employeeData = DataEmployee.of(pathImage, firstName, middleName, lastName, idEmployee);

// Guardar el modelo en la memoria del actor
        theActorInTheSpotlight().remember("employeeData", employeeData);

// Ejecutar la Task
        theActorInTheSpotlight().attemptsTo(
                CreateEmployee.dataEmployee(),
                CreateEmployee.attributeSrcImage(),
                CreateEmployee.filterForName(),
                CreateEmployee.visibleInformationEmployee()
        );

        /*Path filePath = Paths.get("src/test/resources/images/appium.png").toAbsolutePath();



        theActorInTheSpotlight().attemptsTo(

        WaitUntil.the(EmployeeOrangeHrmUi.SECTION_PIM , isVisible()).forNoMoreThan(20).seconds(),
                Click.on(EmployeeOrangeHrmUi.SECTION_PIM),
                WaitUntil.the(EmployeeOrangeHrmUi.BUTTON_ADD_EMPLOYEE , isVisible()).forNoMoreThan(20).seconds(),
                Click.on(EmployeeOrangeHrmUi.BUTTON_ADD_EMPLOYEE)
        );
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(EmployeeOrangeHrmUi.INPUT_UPLOAD_AVATAR, isPresent()).forNoMoreThan(40).seconds()
        );

        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('input.oxd-file-input').style.display = 'block';");

        theActorInTheSpotlight().attemptsTo(
                Upload.theFile(filePath).to(EmployeeOrangeHrmUi.INPUT_UPLOAD_AVATAR),
                WaitUntil.the(EmployeeOrangeHrmUi.PLACEHOLDER_IMAGE_EXISTS , isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(EmployeeOrangeHrmUi.INPUT_FIRSTNAME),
                Enter.theValue("Juans").into(EmployeeOrangeHrmUi.INPUT_FIRSTNAME),
                Enter.theValue("123").into(EmployeeOrangeHrmUi.INPUT_LASTNAME),
                Scroll.to(EmployeeOrangeHrmUi.INPUT_EMPLOYEE_ID),
                Click.on(EmployeeOrangeHrmUi.INPUT_EMPLOYEE_ID),
                Enter.theValue(Keys.chord(Keys.CONTROL, "a")).into(EmployeeOrangeHrmUi.INPUT_EMPLOYEE_ID),
                Hit.the(Keys.DELETE).into(EmployeeOrangeHrmUi.INPUT_EMPLOYEE_ID),
                Enter.theValue("6587945").into(EmployeeOrangeHrmUi.INPUT_EMPLOYEE_ID),
                Scroll.to(EmployeeOrangeHrmUi.BUTTON_SAVE_EMPLOYEE),
                Click.on(EmployeeOrangeHrmUi.BUTTON_SAVE_EMPLOYEE),
                WaitUntil.the(EmployeeOrangeHrmUi.TEXT_PERSONAL_DETAILS , isVisible()).forNoMoreThan(60).seconds()

        */
    }
    @Then("the system should display the employee in the search results")
    public void the_system_should_display_the_employee_in_the_search_results() {
        String expectedImage = theActorInTheSpotlight().recall("employeeImageSrc");
        DataEmployee employeeData = theActorInTheSpotlight().recall("employeeData");
        String expectedName = employeeData.getFirstName() + " " + employeeData.getMiddleName() + " " + employeeData.getLastName();
        theActorInTheSpotlight().should(
                seeThat("The path de Image of profile user",
                        ValidateInformationEmployee.profileImageSrc(),
                        equalTo(expectedImage)),
                seeThat("the expected full name or complete name",
                        ValidateInformationEmployee.completeName(expectedName),
                        equalTo(expectedName))
        );
    }
}
