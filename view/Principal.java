package view;

import java.util.Scanner;
import controller.FuncionarioController;
import model.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioController controller = new FuncionarioController();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Menu Funcionários ---");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Buscar por Matrícula");
            System.out.println("4 - Atualizar Nome do Funcionário");
            System.out.println("5 - Remover Funcionário");
            System.out.println("6 - Sair");
            System.out.print(">> ");
            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarFuncionario(controller, sc);
                    case 2 -> controller.listar();
                    case 3 -> buscarFuncionario(controller, sc);
                    case 4 -> atualizarFuncionario(controller, sc);
                    case 5 -> removerFuncionario(controller, sc);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }

    private static void cadastrarFuncionario(FuncionarioController controller, Scanner sc) throws EntradaInvalidaException {
        System.out.println("Tipo (1-Efetivo, 2-Temporário, 3-Terceirizado): ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        if (tipo == 1) {
            System.out.print("Salário: ");
            double salario = Double.parseDouble(sc.nextLine());
            controller.adicionar(new Efetivo(nome, matricula, salario));
        } else if (tipo == 2) {
            System.out.print("Meses de contrato: ");
            int meses = Integer.parseInt(sc.nextLine());
            controller.adicionar(new Temporario(nome, matricula, meses));
        } else if (tipo == 3) {
            System.out.print("Empresa terceirizada: ");
            String empresa = sc.nextLine();
            controller.adicionar(new Terceirizado(nome, matricula, empresa));
        } else {
            throw new EntradaInvalidaException("Tipo de funcionário inválido.");
        }
    }

    private static void buscarFuncionario(FuncionarioController controller, Scanner sc) throws FuncionarioNaoEncontradoException {
        System.out.print("Digite a matrícula: ");
        String matricula = sc.nextLine();
        Funcionario f = controller.buscarPorMatricula(matricula);
        f.exibirDetalhes();
    }

    private static void atualizarFuncionario(FuncionarioController controller, Scanner sc) throws FuncionarioNaoEncontradoException {
        System.out.print("Digite a matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();
        controller.atualizarNome(matricula, novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }

    private static void removerFuncionario(FuncionarioController controller, Scanner sc) throws FuncionarioNaoEncontradoException {
        System.out.print("Digite a matrícula: ");
        String matricula = sc.nextLine();
        controller.removerPorMatricula(matricula);
        System.out.println("Funcionário removido com sucesso!");
    }
}
