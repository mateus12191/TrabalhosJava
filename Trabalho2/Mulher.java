

import java.util.Calendar;

public class Mulher extends PessoaIMC {


    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, double peso, double altura) {
        super(nome, sobreNome, dia, mes, ano, peso, altura);
    }

    @Override
    public String resultImc() {
        double y = calculaIMC();
        if(y<18.5){
            return "Baixo peso";

        }else if(y>=18.5 && y<24.9){
            return " Peso Normal";

        }else if(y>=24.9 && y<29.9){
            return "Sobrepeso";
        }else if(y>=29.9 && y<34.9){
            return "Obesidade grau I";
        }else if(y>=34.9 && y<39.9){
            return "Obesidade Grau II";
        }else{
            return "Obesidade grau III";
        }
    }



    public String toString() {
        return "Mulher " +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", dataNasc=" + dataNasc.get(Calendar.DAY_OF_MONTH) + "/" + dataNasc.get(Calendar.MONTH) + "/" + dataNasc.get(Calendar.YEAR)+
                ", Altura= "+ altura +
                ", Peso= " + peso +
                ", Imc= " + calculaIMC();



    }

}




