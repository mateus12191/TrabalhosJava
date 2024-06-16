

public abstract class  PessoaIMC extends Pessoa {
    protected double altura;
    protected  double peso;

    public PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano,double peso,double altura) {
        super(nome, sobreNome, dia, mes, ano);
        this.peso=peso;
        this.altura=altura;
    }

    public double calculaIMC(){
        return this.peso/Math.pow(this.altura,2);

    }
    public abstract String resultImc();



    public double getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
