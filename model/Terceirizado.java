package model;

public class Terceirizado extends Funcionario {
    private String empresa;

    public Terceirizado(String nome, String matricula, String empresa) {
        super(nome, matricula);
        this.empresa = empresa;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Terceirizado - Nome: " + nome + ", Matrícula: " + matricula + ", Empresa: " + empresa);
    }
}
