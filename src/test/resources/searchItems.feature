Feature: Buscar elementos en la página principal

  Background:
    Given Estoy en la pagina principal

  Scenario Outline: Cuando busco un elemento en la lista de resultados los elementos mostrados deben estar relacionas
    When busco el elmento "<item>"
    Then el elemento "<item>" aparece en la lista de resultado y tiene el precio "<precio>"
    Examples:
      | item                    | precio    |
      | iPhone                  | $123.20   |
      | MacBook Pro             | $3,000.00 |
      | Samsung Galaxy Tab 10.1 | $241.99   |

