Feature: ejemplo de llamado de api de paises

  Background:
    * url 'https://restcountries.com/v3.1/'
    * header Accept = 'application/json'

  Scenario: obtener todos los paises
    Given path 'all'
    And param fields = 'name'
    When method GET
    Then status 200
    And match response[*] contains { name: '#object' }
    And match response == '#[] #object'