package com.orangehrm.demo.tasks;

import com.orangehrm.demo.ui.LoginOrangeHrmUi;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;


@AllArgsConstructor
public class CredentialsLogin implements Task {

        private final String strUser;
        private final String strPassword;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(LoginOrangeHrmUi.INPUT_USER),
                Enter.theValue(strUser).into(LoginOrangeHrmUi.INPUT_USER),
                Scroll.to(LoginOrangeHrmUi.INPUT_PASSWORD),
                Enter.theValue(strPassword).into(LoginOrangeHrmUi.INPUT_PASSWORD),
                Click.on(LoginOrangeHrmUi.BUTTON_LOGIN)
        );
    }

    public static Performable withCredentials(String strUser, String strPassword) {
            return net.serenitybdd.screenplay.Tasks.instrumented(CredentialsLogin.class, strUser, strPassword);
        }

}


