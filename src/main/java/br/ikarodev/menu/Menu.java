package br.ikarodev.menu;

import br.ikarodev.dao.ClienteDAO;
import br.ikarodev.model.Cliente;

import java.util.Scanner;

public class Menu {
    private ClienteDAO clienteDAO;
    private Scanner input;
    public Menu(){
        clienteDAO = new ClienteDAO();
        input = new Scanner(System.in);
    }

    public void exibirMenu(){
        int opcao;
        System.out.println("-------Menu-------");
        System.out.println("""
                           1. Cadastrar cliente
                           2. Listar clientes
                           3. Atualizar clientes
                           4. Remover clientes
                           """);
        System.out.println("Selecione a opção desejada: ");
        opcao = input.nextInt();
        input.nextLine();
        switch (opcao){
            case 1:
             cadastrarCliente();
                break;
            case 3:
                atualizarCliente();
                break;
            case 4:
                removerCliente();
                break;
        }
    }

    public void cadastrarCliente(){
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Telefone: ");
        String telefone = input.nextLine();
        System.out.println("Email: ");
        String email = input.nextLine();
        Cliente cliente = new Cliente(nome,telefone,email);
        clienteDAO.inserir(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void removerCliente(){
        System.out.println("Digite o id que deseja remover:");
        int id = input.nextInt();
        clienteDAO.remover(id);
        System.out.println("Cliente removido com sucesso!");
    }

    public void atualizarCliente(){
        System.out.println("Digite o ID do cliente que deseja alterar: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Digite o novo nome:");
        String nome = input.nextLine();
        System.out.println("Digite o novo telefone:");
        String telefone = input.nextLine();
        System.out.println("Digite o novo email:");
        String email = input.nextLine();
        Cliente novocliente = new Cliente(id,nome,telefone,email);
        clienteDAO.atualizar(novocliente);
    }
}
