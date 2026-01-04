package br.ikarodev.menu;

import br.ikarodev.dao.ClienteDAO;
import br.ikarodev.db.Conexao;
import br.ikarodev.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClienteDAO clienteDAO;
    private Scanner input;
    private Utilitarios util;
    public Menu(){
        clienteDAO = new ClienteDAO();
        input = new Scanner(System.in);
        util = new Utilitarios();
    }

    public void exibirMenu(){
        Conexao.CriarTabela();
        int opcao;
        do{
        System.out.println("-------Menu-------");
        System.out.println("""
                           1. Cadastrar cliente
                           2. Listar clientes
                           3. Buscar cliente
                           4. Atualizar cliente
                           5. Remover cliente
                           6. Limpar registros
                           0. Sair
                           """);
        System.out.println("Selecione a opção desejada: ");
        opcao = input.nextInt();
        input.nextLine();
        switch (opcao){
            case 1:
             cadastrarCliente();
                break;
            case 2:
                listaClientes();
                break;
            case 3:
                buscarID();
                break;
            case 4:
                atualizarCliente();
                break;
            case 5:
                removerCliente();
                break;
            case 6:
                limparRegistros();
                break;
            case 0:
                System.out.println("Saindo ...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
     }while(opcao!=0);
    }

    public void cadastrarCliente(){
        System.out.println("Nome completo ('0' para cancelar): ");
        String nome = input.nextLine();
        if (nome.equalsIgnoreCase("0")){
            System.out.println("Cadastro cancelado.");
            return;
        }
        String telefone;
        do {
            System.out.println("Telefone ex: 84995662322 ('0' para cancelar): ");
            telefone = input.nextLine();
            if (telefone.equalsIgnoreCase("0")){
                System.out.println("Cadastro cancelado.");
                return;
            }
            if (!util.validarTelefone(telefone)) {
                System.out.println("Telefone inválido!");
            }
        }while (!util.validarTelefone(telefone));
        System.out.println("Email ('0' para cancelar): ");
        String email = input.nextLine();
        if (email.equalsIgnoreCase("0")){
            System.out.println("Cadastro cancelado.");
            return;
        }
        Cliente cliente = new Cliente(nome,telefone,email);
        clienteDAO.inserir(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void removerCliente(){
        if(clienteDAO.TabelaVazia()){
            System.out.println("Não há registros na tabela.");
            return;
        }
        System.out.println("Digite o id que deseja remover ('0' para cancelar):");
        int id;
        while (true) {
            String idString = input.nextLine();
            try {
                id = Integer.parseInt(idString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id inválido. Digite um id válido ('0' para cancelar) : ");
            }
        }
        if (id == 0){
            System.out.println("Remoção cancelada.");
            return;
        }
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else {
            System.out.println("Tem certeza que deseja remover " + clienteDAO.buscarID(id).getNome() + " ? (S/N)");
            String conf;
            do {
                conf = input.nextLine();
                if (conf.equalsIgnoreCase("s")) {
                    clienteDAO.remover(id);
                    System.out.println("Cliente removido com sucesso!");
                } else if (conf.equalsIgnoreCase("n")) {
                    System.out.println("Cliente não removido.");
                } else {
                    System.out.println("Opção inválida. Digite S ou N para confirmação: ");
                }
            }while (!conf.equalsIgnoreCase("s") && !conf.equalsIgnoreCase("n"));
        }
    }

    public void atualizarCliente(){
        if(clienteDAO.TabelaVazia()){
            System.out.println("Não há registros na tabela.");
            return;
        }
        System.out.println("Digite o ID do cliente que deseja atualizar ('0' para cancelar): ");
        int id;
        while(true) {
            String idString = input.nextLine();
            try {
                id = Integer.parseInt(idString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id inválido. Digite um id válido ('0' para cancelar) : ");
            }
        }
        if (id == 0){
            System.out.println("Atualização cancelada.");
            return;
        }
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else {
            System.out.println("Deseja atualizar " + clienteDAO.buscarID(id).getNome() + " ? (S/N)");
            String conf;
          do {
              conf = input.nextLine();
              if (conf.equalsIgnoreCase("s")) {
                  System.out.println("Nome: ('0' para cancelar)");
                  String nome = input.nextLine();
                  if (nome.equalsIgnoreCase("0")){
                      System.out.println("Atualização cancelada.");
                      return;
                  }
                  String telefone;
                  do {
                      System.out.println("Telefone ex: 84995662322 ('0' para cancelar): ");
                      telefone = input.nextLine();
                      if (telefone.equalsIgnoreCase("0")){
                          System.out.println("Atualização cancelada.");
                          return;
                      }
                      if (!util.validarTelefone(telefone)) {
                          System.out.println("Telefone inválido!");
                      }
                  } while (!util.validarTelefone(telefone));
                  System.out.println("Email ('0' para cancelar): ");
                  String email = input.nextLine();
                  if (email.equalsIgnoreCase("0")){
                      System.out.println("Atualização cancelada.");
                      return;
                  }
                  Cliente novocliente = new Cliente(id, nome, telefone, email);
                  clienteDAO.atualizar(novocliente);
                  System.out.println("Cliente atualizado com sucesso!");
              } else if (conf.equalsIgnoreCase("n")) {
                  System.out.println("Cliente não atualizado.");
              } else {
                  System.out.println("Opção inválida. Digite S ou N para confirmação: ");
              }
          }while (!conf.equalsIgnoreCase("s") && !conf.equalsIgnoreCase("n"));
        }
    }
    public void listaClientes(){
        if(clienteDAO.TabelaVazia()){
            System.out.println("Não há registros na tabela.");
            return;
        }
        List<Cliente> clientes = clienteDAO.listar();
            System.out.println("--------Lista de Clientes-------");
            for (Cliente i : clientes) {
                System.out.println(i);
            }
    }
    public void buscarID(){
        if(clienteDAO.TabelaVazia()){
            System.out.println("Não há registros na tabela.");
            return;
        }
        System.out.println("Digite o id que deseja buscar ('0' para cancelar): ");
        int id;
        while(true) {
            String idString = input.nextLine();
            try {
                id = Integer.parseInt(idString);
               break;
            } catch (NumberFormatException e) {
                System.out.println("Id inválido. Digite um id válido ('0' para cancelar) : ");
            }
        }
        if (id == 0){
            System.out.println("Busca cancelada.");
            return;
        }
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else{
            System.out.println(cliente);
        }
    }
    public void limparRegistros(){
        if(clienteDAO.TabelaVazia()){
            System.out.println("Não há registros na tabela.");
            return;
        }
        System.out.println("Tem certeza que deseja limpar os registros de cliente? (S/N)");
        System.out.println("ATENÇÃO: ESTA AÇÃO APAGARÁ TODOS OS REGISTROS DE CLIENTES E NÃO SERÁ POSSÍVEL RECUPERAR.");
        String opcao;
        do {
            opcao = input.nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                clienteDAO.limparRegistros();
                System.out.println("Todos os registros foram apagados com sucesso.");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("Registros NÃO apagados.");
            } else {
                System.out.println("Opção inválida. Digite S ou N para confirmação: ");
            }
        }while (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n"));
    }
}
