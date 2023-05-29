# Escala de Coma de Glasgow
## Introdução
A aplicação JavaFX "Escala de Coma de Glasgow" é uma interface gráfica para calcular a pontuação da Escala de Coma de Glasgow em pacientes adultos, crianças e bebês. A aplicação possui diferentes telas para cada faixa etária e exibe resultados específicos, como porcentagem de mortalidade e resultado desfavorável após 6 meses do coma.

https://github.com/jotaven/Escala-Glasgow/assets/94320199/2ebb9dff-1c1d-4471-ae02-321cea8d4d93

## Requisitos
- JDK 8 ou superior
- JavaFX 8 ou superior
- Biblioteca MySQL Connector/J para a conexão com o banco de dados

## Telas e Funcionalidades
### Tela de Login
A tela de login é a primeira tela exibida ao iniciar a aplicação. Nessa tela, o usuário deve inserir um nome de usuário e uma senha para autenticação. Caso os campos estejam vazios ou as informações fornecidas sejam inválidas, uma mensagem de erro é exibida. Ao fazer o login com sucesso, o usuário é redirecionado para a tela do menu.

### Tela do Menu
A tela do menu exibe dois botões: "Ala Pediátrica" e "Ala Adulta". Esses botões representam as diferentes faixas etárias dos pacientes. Ao clicar em um dos botões, o usuário é direcionado para a tela correspondente à faixa etária escolhida.

### Tela da Escala de Coma de Glasgow para Adultos
Nessa tela, o usuário pode realizar o cálculo da Escala de Coma de Glasgow para pacientes adultos. A tela exibe uma série de perguntas sobre a resposta ocular, resposta verbal, resposta motora e resposta pupilar. O usuário deve selecionar as respostas correspondentes e, em seguida, clicar em "Calcular" para obter o resultado. O resultado é exibido na tela, mostrando a pontuação obtida, a porcentagem de mortalidade e a porcentagem de resultado desfavorável após 6 meses. O usuário também tem a opção de reiniciar os valores clicando no botão "Resetar".

### Tela da Escala de Coma de Glasgow para Pediatria
Essa tela é semelhante à tela da Escala de Coma de Glasgow para adultos, mas adaptada para pacientes pediátricos. Ela também exibe perguntas sobre a resposta ocular, resposta verbal, resposta motora e resposta pupilar. O cálculo e os resultados são apresentados da de maneira diferente que o dos adultos, utilizando GCS(Glasgow Coma Scale) em vez do GCS-P (Glasgow Coma Scale Pupilar).

### Outras Funcionalidades
#### Informações sobre a Escala de Coma de Glasgow:
 Em ambas as telas de cálculo, há botões "Informações" que exibem informações detalhadas sobre a Escala de Coma de Glasgow em janelas modais separadas.

#### Tela de Informações da Escala de Coma de Glasgow:
 Essa tela exibe informações detalhadas sobre a Escala de Coma de Glasgow, explicando os critérios de avaliação e as pontuações correspondentes para cada resposta ocular, verbal, motora e pupilar. A tela é aberta quando o usuário clica no botão "Informações" na tela de cálculo.


