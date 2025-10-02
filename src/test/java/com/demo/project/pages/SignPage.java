package com.demo.project.pages;
import org.example.utilites.utilitiesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// variable y locators, constructor, metodo
public class SignPage extends utilitiesScreenshot {
    private WebDriver driver;
    String urlPageSignIn = "https://rahulshettyacademy.com/loginpagePractise/";

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



    public SignPage(WebDriver driver){    // constructor
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void getPagina(String pagina){
        driver.get(pagina);
        takeScreenshot("Evidence from Sign in page");
    }

    public void ingresarCredenciales(String usario, String password){
        txtusario.sendKeys(usario);
        txtpassword.sendKeys(password);
        takeScreenshot("Evidence user credentiales");

    }

    public void selecionarRolePrincipal(String Role){
        for(WebElement roles : listRoles){
            if (roles.getText().trim().equals(Role)){
                roles.click();
                takeScreenshot("Evidence user Principal Role");
                break;
                  }
            }
     }

    public void seleccionarRoleNormal(String RoleNo) {
        txtBox.click();
        for (WebElement rolesno : rolesNormal) {
            if(rolesno.getText().trim().equals(RoleNo)){
                rolesno.click();
                takeScreenshot("Evidence user Role Normal");
                break;
            }
        }
        try{
            Thread.sleep(8000);
        }
        catch (Exception e) {
            e.getMessage();
        }

    }

    }
