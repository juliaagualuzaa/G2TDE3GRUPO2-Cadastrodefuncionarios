package model;

public class Temporario extends Funcionario {
    private int mesesContrato;

    public Temporario(String nome, String matricula, int mesesContrato) {
        super(nome, matricula);
        this.mesesContrato = mesesContrato;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Temporário - Nome: " + nome + ", Matrícula: " + matricula + ", Contrato: " + mesesContrato + " meses");
    }
}
