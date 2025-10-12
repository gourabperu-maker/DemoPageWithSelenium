package com.demo.project.stepDefinations;

import com.demo.project.hooks.Hooks;
import com.demo.project.pages.SignPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class SignInStepDefinations {

    private SignPage signPage;  //Declare an instantiated variable

    @Given("que estoy en la página de login")
    public void queEstoyEnLaPáginaDeLogin() {
        // First create a object to give value in driver which come from hook class or instantiate in 'Stepdefinations page' then create a constructor 'SignPage' for his functions
        signPage = new SignPage();
        // call 'SignPage' for his specific functions
        signPage.getPagina();
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingresoElUsuarioYLaContraseña(String usuario, String password) {
        signPage.ingresarCredenciales(usuario,password);
    }

    @And("selecciono el {string} según la UI")
    public void seleccionoElSegúnLaUI(String rolePrincipal) {

        signPage.selecionarRolePrincipal(rolePrincipal);
    }

    @And("Seleccino el {string} según la UI")
    public void seleccinoElSegúnLaUI(String roleNormal) {
        signPage.seleccionarRoleNormal(roleNormal);
    }

    @And("marco I Agree to the terms and conditions")
    public void marco() {
        signPage.termsYconditions();
    }

    @And("hago click en Sign In")
    public void hagoClickEn() {
        signPage.buttonSignIn();
    }

 }
