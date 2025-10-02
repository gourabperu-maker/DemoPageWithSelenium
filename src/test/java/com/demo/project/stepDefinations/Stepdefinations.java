package com.demo.project.stepDefinations;
import com.demo.project.hooks.Hooks;
import com.demo.project.pages.SignPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Stepdefinations {

    private SignPage signPage;

    @Given("que estoy en la página de login {string}")
    public void queEstoyEnLaPáginaDeLogin(String pagina) {
        signPage = new SignPage(Hooks.driver);
        signPage.getPagina(pagina);
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

    @And("marco {string}")
    public void marco(String arg0) {
    }

    @And("hago click en {string}")
    public void hagoClickEn(String arg0) {
    }

    @Then("debo ver que el inicio de sesión es exitoso")
    public void deboVerQueElInicioDeSesiónEsExitoso() {
    }

    @And("el sistema redirige a la página principal o muestra los elementos del dashboard")
    public void elSistemaRedirigeALaPáginaPrincipalOMuestraLosElementosDelDashboard() {
    }

    @And("no marco la casilla de términos \\(o la dejo según el caso)")
    public void noMarcoLaCasillaDeTérminosOLaDejoSegúnElCaso() {
    }

    @Then("debo ver el mensaje de error {string}")
    public void deboVerElMensajeDeError(String arg0) {
    }



}
