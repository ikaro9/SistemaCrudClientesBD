package br.ikarodev.menu;

import br.ikarodev.dao.ClienteDAO;
import br.ikarodev.model.Cliente;

import java.util.List;
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
        do{
        System.out.println("-------Menu-------");
        System.out.println("""
                           1. Cadastrar cliente
                           2. Listar clientes
                           3. Buscar cliente
                           4. Atualizar cliente
                           5. Remover cliente
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
            case 0:
                System.out.println("Saindo ...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
     }while(opcao!=0);
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
        input.nextLine();
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else {
            System.out.println("Tem certeza que deseja remover " + clienteDAO.buscarID(id).getNome() + " ? (S/N)");
            String conf = input.nextLine();
            if (conf.equalsIgnoreCase("s")) {
                clienteDAO.remover(id);
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não removido.");
            }
        }
    }

    public void atualizarCliente(){
        System.out.println("Digite o ID do cliente que deseja atualizar: ");
        int id = input.nextInt();
        input.nextLine();
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else {
            System.out.println("Deseja atualizar " + clienteDAO.buscarID(id).getNome() + " ? (S/N)");
            String conf = input.nextLine();
            if (conf.equalsIgnoreCase("s")) {
                System.out.println("Digite o nome:");
                String nome = input.nextLine();
                System.out.println("Digite o telefone:");
                String telefone = input.nextLine();
                System.out.println("Digite o email:");
                String email = input.nextLine();
                Cliente novocliente = new Cliente(id, nome, telefone, email);
                clienteDAO.atualizar(novocliente);
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não atualizado.");
            }
        }
    }
    public void listaClientes(){
        List<Cliente> clientes = clienteDAO.listar();
        System.out.println("--------Lista de Clientes-------");
        for(Cliente i : clientes){
            System.out.println(i);
        }
    }
    public void buscarID(){
        System.out.println("Digite o id que deseja buscar");
        int id = input.nextInt();
        Cliente cliente = clienteDAO.buscarID(id);
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
        }
        else{
            System.out.println(cliente);
        }
    }
}
