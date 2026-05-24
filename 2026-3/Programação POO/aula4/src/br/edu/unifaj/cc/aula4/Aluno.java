package br.edu.unifaj.cc.aula4;

public class Aluno extends Pessoa{
    private String ra;
    float notas[];

    public Aluno(String ra, float[] notas) {
        this.ra = ra;
        this.notas = notas;
    }

    public Aluno(String nome, int idade, String cpf, String ra, float[] notas) {
        super(nome, idade, cpf);
        this.ra = ra;
        this.notas = notas;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    public void estudar(){
        System.out.println(getNome() + " " + getIdade() + " " + " " + getCpf() + " " + ra + " " + "Aluno estudando" );
    }

    public float calcularMedia(){
        if(this.notas == null || this.notas.length == 0){
            return 0;
        }

        float total = 0;
        for(int i = 0; i < this.notas.length; i++){
            total += this.notas[i];
        }
        return total / this.notas.length;
    }
}