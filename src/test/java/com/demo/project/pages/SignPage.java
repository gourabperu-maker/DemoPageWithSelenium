package com.demo.project.pages;
import com.demo.project.hooks.Hooks;
import com.demo.project.utilites.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


   // Declaration variable, then add locators, then add constructor and finally add  method

public class SignPage extends BasePage {
    private WebDriver driverVariable;
    String urlPage = "https://rahulshettyacademy.com/loginpagePractise/";


    @FindBy(xpath ="//input[@id='username' and @class='form-control']" )
    private WebElement txtusario;

    @FindBy(css ="[name='password']" )
    private WebElement txtpassword;

    @FindBy(css =".customradio span.radiotextsty" )
    private List<WebElement> listRoles;

    @FindBy(css = "select.form-control")
    private WebElement txtBox;

    @FindBy(css ="select.form-control option")
    private List<WebElement> rolesNormal;

    @FindBy(css = "select.form-control")
    WebElement selectRoleOtroforma;

    @FindBy(css ="btn btn-success")
    private List<WebElement> txtOkey;

    @FindBy(xpath ="//input[@type='checkbox' and @name='terms']")
    private WebElement tYc;

    @FindBy(css =" input[name='signin']")
    private WebElement signIn;

    @FindBy(xpath ="//button[@type='button' and @id='okayBtn']")
    private WebElement okeyModalButton;

    @FindBy(xpath ="//div[@class='modal-content']")
    private WebElement roleUserModal;




    // Constructor
    public SignPage(){
        super(Hooks.driver);
        this.driverVariable = Hooks.driver;
        PageFactory.initElements(Hooks.driver, this);
    }


    public void getPagina(){
        //driverVariable.get(urlPage);
        driver.get(urlPage);
        takeScreenshot("Evidence from Sign in page");
    }

    public void ingresarCredenciales(String usario, String password){
        txtusario.sendKeys(usario);
        txtpassword.sendKeys(password);
        takeScreenshot("Evidence user credentiales");

    }
// **** Select Role principal value come from test data (Admin / User)
    public void selecionarRolePrincipal(String Role) {
        for (WebElement roles : listRoles) {
            String text = roles.getText().trim();
            if (text.equals(Role)) {
                roles.click();

                if (text.equals("User")) {
                    wait.until(ExpectedConditions.visibilityOf(okeyModalButton));
                    okeyModalButton.click();
                    wait.until(ExpectedConditions.visibilityOf(roleUserModal));
                }
                takeScreenshot("Evidence user Principal Role");
                break;
            }
        }
    }

 // **** Select Role normal value come from test data (student / teacher / consultant)

    public void seleccionarRoleNormal(String RoleNormal) {
  /*
        We can call using 1st way, where we need to click, then find a parent parameter then compare role values with test data
        txtBox.click();
        for (WebElement rolesno : rolesNormal) {
            if(rolesno.getText().trim().equals(RoleNo)){
                rolesno.click();
                takeScreenshot("Evidence user Role Normal");
                break;
               }


        2nd way we can create a method by parameter in basepage and reuse this method when need
        selecionarComboPorParametro(selectRoleOtroforma,RoleNo);


        //3rd way we can create a method by value in basepage and reuse this method when need
        selecionarComboPorValue(selectRoleOtroforma,RoleNo);

   */
        wait.until(ExpectedConditions.visibilityOf(selectRoleOtroforma));
        selecionarComboPorParametro(selectRoleOtroforma,RoleNormal);

    }


    public void termsYconditions(){
        tYc.click();
        takeScreenshot("Evidence from mark Terms & Conditions");
        scrollarElemento(signIn);
    }

    public void buttonSignIn(){
        signIn.click();
        takeScreenshot("Evidence from Signing.. page");
    }
    }
