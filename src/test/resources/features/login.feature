#language:pt
@login
Funcionalidade: Login

  @1
  Cenario: Realizar criar login válido
    Dado que esteja na página de login
    Quando clico em Sign Up
    E preencho os dados
      | email | gabriel@gab.com |
      | senha | 12345678        |
    Então confirmo que a conta foi criada

  Cenario: Realizar login válido
    Dado que esteja na página de login
    Quando for realizado login com os seguintes dados
      | email | gabriel@gab.com |
      | senha | 12345678                      |
    Entao valido que exibe o popup de sucesso

  Esquema do Cenario: Realizar login <cenario>
    Dado que esteja na página de login
    Quando for realizado login com os seguintes dados
      | email | <email> |
      | senha | <senha> |
    Entao valido que no campo erro email exibe a mensagem "<msg>"
    Exemplos:
      | cenario             | email   | senha  | msg                             |
      | com email inválido  | teste   | 123456 | Please enter a valid email address           |
      | com email em branco | [blank] | 123456 | Please enter a valid email address |

  Esquema do Cenario: Realizar login <cenario>
    Dado que esteja na página de login
    Quando for realizado login com os seguintes dados
      | email | <email> |
      | senha | <senha> |
    Entao valido que no campo erro senha exibe a mensagem "<msg>"

    Exemplos:
      | cenario             | email                       | senha   | msg                                      |
      | com senha inválida  | gabriel@gab.com | 123     | Please enter at least 8 characters |
      | com senha em branco | teste@chronosacademy.com.br | [blank] | Please enter at least 8 characters          |

