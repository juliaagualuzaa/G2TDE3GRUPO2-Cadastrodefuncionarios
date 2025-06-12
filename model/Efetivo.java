package model;

public class Efetivo extends Funcionario {
    private double salario;

    public Efetivo(String nome, String matricula, double salario) {
        super(nome, matricula);
        this.salario = salario;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Efetivo - Nome: " + nome + ", Matrícula: " + matricula + ", Salário: R$" + salario);
    }
}
