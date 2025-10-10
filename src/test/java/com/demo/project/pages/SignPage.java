package com.demo.project.pages;
import com.demo.project.utilites.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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





    public SignPage(WebDriver driver){
        super(driver);
        this.driverVariable = driver;
        PageFactory.initElements(driver, this);
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
// Select Role principal value come from test data (Admin / User)
    public void selecionarRolePrincipal(String Role){
        for(WebElement roles : listRoles){
            if (roles.getText().trim().equals(Role)){
                roles.click();
                takeScreenshot("Evidence user Principal Role");
                break;
                  }
            }

     }

 // Select Role normal value come from test data (student / teacher / consultant)

    public void seleccionarRoleNormal(String RoleNo) {
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

   */
        //3rd way we can create a method by value in basepage and reuse this method when need
          selecionarComboPorValue(selectRoleOtroforma,RoleNo);

    }


    public void termsYconditions(){
        tYc.click();
        takeScreenshot("Evidence from mark Terms & Conditions");
    }

    public void buttonSignIn(){
        signIn.click();
        takeScreenshot("Evidence from Signing.. page");
    }


    public void signInExito(){

    }

/*
            try{
                Thread.sleep(3000);
            }
            catch (Exception e) {
                e.getMessage();
            }

*/







    }
