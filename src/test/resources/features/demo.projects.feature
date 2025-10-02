Feature: Inicio de sesión en Rahul Shetty Academy
@Hotfix
  Scenario Outline: Inicio de sesión exitoso con credenciales válidas
    Given que estoy en la página de login "https://rahulshettyacademy.com/loginpagePractise/"
    When ingreso el usuario "<usario>" y la contraseña "<password>"
    And selecciono el "<rolePrincipal>" según la UI
    And Seleccino el "<roleNormal>" según la UI
    And marco "I Agree to the terms and conditions"
    And hago click en "Sign In"
    Then debo ver que el inicio de sesión es exitoso
    And el sistema redirige a la página principal o muestra los elementos del dashboard

  Examples:
  |usario|                password|      rolePrincipal|   roleNormal|
#  |rahulshettyacademy|  learning|        Admin|           Student|
  |rahulshettyacademy|  learning|        Admin|           Teacher|
  |rahulshettyacademy|  learning|        Admin|           Consultant|
 # |rahulshettyacademy|  learning|        User|










  Scenario Outline: Mostrar mensaje de error con credenciales inválidas
    Given que estoy en la página de login "https://rahulshettyacademy.com/loginpagePractise/"
    When ingreso el usuario "<user>" y la contraseña "<pass>"
    And no marco la casilla de términos (o la dejo según el caso)
    And hago click en "Sign In"
    Then debo ver el mensaje de error "Incorrect username/password."








    Examples:


    1. buscar locator
    2. agregar en steps
    3. agregar en examples