🍽 Sistema de Restaurante — Java com Swing
Projeto de um Sistema de Gestão de Restaurante com interface gráfica utilizando Java e Swing, voltado para fins didáticos e acadêmicos. Permite o gerenciamento de pratos, clientes e pedidos com menus separados para Gerente, Garçom e Cliente.

✅ Objetivo
Criar um sistema simples que simule o funcionamento básico de um restaurante, com:

Gerenciamento de cardápio e clientes.

Registro, alteração e exclusão de pedidos.

Interface gráfica amigável com o usuário.

Aplicação de conceitos de programação orientada a objetos e interfaces gráficas.

🖥 Tecnologias Utilizadas
Java SE 8+

Swing (javax.swing) — biblioteca gráfica nativa do Java.

JOptionPane e JFrame para interface gráfica.

🚀 Como Executar o Projeto
Abra uma IDE Java (como IntelliJ, Eclipse ou NetBeans).

Crie um novo projeto Java.

Crie um novo arquivo Java chamado SistemaRestauranteGUI.java.

Cole todo o código-fonte do projeto nesse arquivo.

Compile e execute.

O sistema abrirá uma janela com o menu principal.

🧭 Estrutura do Sistema
O sistema possui três menus principais, acessíveis a partir da tela inicial:

1. 👨‍💼 Menu Gerente
   Permite que o gerente realize ações de controle sobre o restaurante.

Funcionalidades:
Cadastrar Cardápio: adiciona novos pratos à lista do cardápio.

Ver Cardápio: exibe todos os pratos cadastrados.

Ver Clientes: mostra todos os clientes cadastrados.

Ver Pedidos: lista todos os pedidos realizados por clientes ou garçons.

2. 🧑‍🍽 Menu Garçom
   Funciona como um painel de atendimento. Aqui o garçom gerencia os pedidos feitos.

Funcionalidades:
Fazer Pedido: seleciona um cliente e um prato do cardápio e registra um pedido.

Alterar Pedido: permite modificar um pedido já existente.

Excluir Pedido: remove um pedido da lista.

3. 👤 Menu Cliente
   Pensado para que o próprio cliente possa consultar e interagir com o sistema.

Funcionalidades:
Ver Cardápio: exibe a lista de pratos disponíveis.

Fazer Pedido: o cliente digita seu nome, escolhe um prato e o pedido é registrado.

Ver Status do Pedido: lista os pedidos feitos com nome e prato.

📌 Lógica dos Pedidos
Quando o garçom ou cliente faz um pedido, ele é adicionado à lista pedidos.

Cada pedido é uma String no formato:
"Nome do Cliente pediu: Nome do Prato"

Os pedidos podem ser visualizados, alterados ou excluídos através dos menus apropriados.

💬 Mensagens e Interface
Todas as interações com o usuário são feitas por meio de janelas do tipo JOptionPane, o que torna o sistema simples e direto para o usuário final.

💡 Sugestões para Melhorias Futuras
Implementar salvamento em arquivo ou banco de dados.

Separar a lógica em classes específicas (MVC).

Adicionar login para gerente, garçom e cliente.

Melhorar o visual com JavaFX ou bibliotecas modernas.