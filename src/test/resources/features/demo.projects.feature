# @Regression
Feature: Inicio de sesión en Rahul Shetty Academy

Background:
  Given que estoy en la página de login



@Test001
  Scenario Outline: Inicio de sesión exitoso con credenciales válidas
  When ingreso el usuario "<usario>" y la contraseña "<password>"
    And selecciono el "<rolePrincipal>" según la UI
    And Seleccino el "<roleNormal>" según la UI
    And marco I Agree to the terms and conditions
    And hago click en Sign In
    Then debo ver que el inicio de sesión es exitoso


  Examples:
    | usario             | password | rolePrincipal | roleNormal |
    #| rahulshettyacademy | learning | Admin         | consult    |
  #|rahulshettyacademy|  learning|        Admin|           Teacher|
  #|rahulshettyacademy|  learning|        Admin|            stud|
  #|rahulshettyacademy|  learning|        User|           consult|
  |rahulshettyacademy|  learning|        User|           Teacher|
  #|rahulshettyacademy|  learning|        User|            stud|



  @Test002
  Scenario Outline: Inicio de sesión no exitoso con credenciales inválidas
    When ingreso el usuario "<usario>" y la contraseña "<password>"
    And selecciono el "<rolePrincipal>" según la UI
    And Seleccino el "<roleNormal>" según la UI
    And marco I Agree to the terms and conditions
    And hago click en Sign In
    Then debo ver que el inicio de sesión es exitoso


    Examples:
      |usario|                password|      rolePrincipal|   roleNormal|
      |rahulshettyacademy|  learning|        Admin|                  |
      |rahulshettyacademy|  learning|             |           Teacher|
      |rahulshettyacademy|Incorrecto|        Admin|              stud|
      |rahulshettyacademy|          |        User|            consult|
      |Incorrecto|          learning|        User|            Teacher|
      |null|                learning|        User|               stud|








