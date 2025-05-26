# testeappium
# testeappium
Framework de Automação Mobile com Appium
📱 Visão Geral
Framework de automação de testes mobile desenvolvido em Java, utilizando Appium para testes em aplicações Android. O framework implementa o padrão Page Object Model (POM) e integra Cucumber para BDD com relatórios avançados via Allure.

🛠️ Tecnologias Utilizadas
Java 11 - Linguagem de programação
Appium 9.2.2 - Automação mobile
Cucumber 7.14.0 - Framework BDD
JUnit 4 - Framework de testes
Allure 2.24.0 - Relatórios de testes avançados
Maven - Gerenciamento de dependências

📂 Estrutura do Projeto
src/test/java/
├── core/
│   └── Driver.java          # Configuração e inicialização do Appium
├── maps/
│   └── LoginMaps.java       # Mapeamento de elementos (Page Objects)
├── pages/
│   └── LoginPage.java       # Ações e interações com as páginas
├── steps/
│   └── LoginSteps.java      # Definições dos steps do Cucumber
├── hooks/
│   └── AllureHooks.java     # Hooks para integração com Allure
└── runner/
    └── TestRunner.java      # Executor dos testes Cucumber


🚀 Principais Funcionalidades
Page Object Model (POM)
Maps: Classes que contêm o mapeamento dos elementos usando @AndroidFindBy
Pages: Classes que herdam dos Maps e implementam as ações/interações
Separação clara entre elementos e lógica de teste
Integração BDD com Cucumber
Suporte para escrita de cenários em português
DataTables para parametrização de testes
Tags para organização e execução seletiva
Relatórios Avançados com Allure
Screenshots automáticos em cada step
Categorização de testes (Epic, Feature, Story)
Níveis de severidade (CRITICAL, NORMAL)
Anexos de page source para debugging
Timeline de execução
Histórico de testes
Gestão de Driver
Inicialização centralizada do Appium
Suporte para gestos (swipe) via JavaScript
Configuração para dispositivos Android

📊 Recursos de Relatório
Screenshots: Capturados automaticamente em cada passo
Parâmetros: Logging de dados de teste (com mascaramento de senhas)
Attachments: Page source XML para análise de falhas
Categorização: Organização hierárquica dos testes
Métricas: Gráficos e estatísticas de execução

🔧 Como Executar
Pré-requisitos
Java 11+
Maven
Appium Server
Dispositivo Android ou Emulador
Executar Testes
# Executar todos os testes
mvn clean test

# Gerar e visualizar relatório Allure
mvn allure:serve

# Gerar relatório sem abrir
mvn allure:report



📝 Exemplo de Uso
@Dado("que esteja na página de login")
@Step("Navegar para a página de login")
@Description("Este passo navega o usuário para a tela de login")
@Severity(SeverityLevel.CRITICAL)
public void queEstejaNaPaginaDeLogin() {
    loginPage = new LoginPage();
    captureScreenshot("Tela de Login");


🎯 Benefícios
Manutenibilidade: Estrutura POM facilita manutenção
Rastreabilidade: Relatórios detalhados com evidências
Reutilização: Componentes modulares e reutilizáveis
Debugging: Screenshots e page source em caso de falha
Documentação: Steps auto-documentados com Allure


