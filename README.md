<img src="https://www.devopsschool.com/blog/wp-content/uploads/2022/04/appium-imge.jpg" alt="Appium">

# BaixandoJava JDK
- Acessar o site http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Selecionar o item Accept License Agreement
- Clicar no link referente ao instalador de acordo com seu sistema operacional (Linux, Solaris, MacOSx, Windows)
- Aguardar o download do arquivo instalador
- Clicar no arquivo executável e seguir os passos propostos pelo instalador
- 
# Configurar Java JDK (Windows)
- Vá até as Variáveis de Ambiente no Windows e:
- Adicione a seguinte variável com o respectivo valor e clique em OK
- Nome da variável: JAVA_HOME
- Valor da variável: C:\Program Files\Java\jdk1.8.0_121
- Selecione a variável PATH e clique em Editar...
- Clique no botão Novo e adicione o seguinte valor de variável: "%JAVA_HOME%\bin"
    -- Atenção: se a variável PATH não existir, crie a variável com o mesmo valor de variável.
- Feche todas as telas clicando no botão OK e abra o Prompt de Comando. Se ele estiver aberto, feche-o e abra um novo
- Digite, no Prompt de Comando a palavra java e pressione a tela ENTER
    --Deve ser apresentado uma lista de opções (parâmetros) para o comando.

# Instalação Android Studio
- Acessar o site https://developer.android.com/studio/index.html
- Clicar no botão Download Android Studio
- Aceitar os termos e condições marcando a opção I have read and agree with the above terms and conditions
- Clicar no botão Download Android Studio abaixo dos termos e condições
- Aguardar o download do arquivo instalador
- Clicar no arquivo executável e seguir os passos propostos pelo instalador até concluir a instalação

# Configurar o Android SDK
- Abra o Android Studio
- Na tela inicial clique o item Configure e depois no item SDK Manager
- Copie o caminho apresentado no campo Android SDK Location
- Vá até as Variáveis de Ambiente no Windows e:
    -- Adicione a seguinte variável com o respectivo valor e clique em OK
      -- Nome da variável: ANDROID_HOME
      -- Valor da variável: Diretório presente no campo Android SDK Location
  -- Selecione a variável PATH e clique em Editar...
  -- Clique no botão Novo e adicione o seguinte valor de variável
      -- %ANDROID_HOME%\tools
  -- Clique novamente no botão Novo e adicione o seguinte valor de variável
      -- %ANDROID_HOME%\tools\bin
  -- Clique novamente no botão Novo e adicione o seguinte valor de variável
      -- %ANDROID_HOME%\platform-tools
- Feche todas as telas clicando no botão OK e abra o Prompt de Comando. Se ele estiver aberto, feche-o e abra um novo
- No Prompt de Comando digite uiautomatorviewer e pressione ENTER
- Uma janela com o título UI Automator Viewer deve ser apresentada. Feche a janela
- Ainda no Prompt de Comando digite adb e pressione ENTER
- Deve ser apresentado uma lista de opções (parâmetros) para o comando. A primeira linha possui o texto Android Debug Bridge version

# Atualizar o Android SDK
- Abra o Android Studio
- Na tela inicial clique o item Configure e depois no item SDK Manager
- Você precisa instalar e/ou atualizar os seguintes itens em cada aba
    - SDK Platform (aba)
    - Android 13 (ou superior)
- SDK Tools (aba)
    - Android SDK Build-Tools
    - Android Emulator 27.3.9 (ou superior)
    - Android SDK Platform-Tools 28.0.0 (ou superior)
    - Android SDK Tools 26.1.1 (ou superior)
    - Se existir, marque também o item Intel x86 Emulator Accelerator (HAXM installer)
- Clique no botão Apply para atualizar o Android SDK


