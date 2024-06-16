
import java.util.Calendar;

public class Mulher extends Pessoa {
    int idade;

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        this.idade = getIdade();
    }

    public int getIdade() {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int anoNascimento = this.dataNasc.get(Calendar.YEAR);
        int mesNascimento = this.dataNasc.get(Calendar.MONTH) + 1;
        int diaNascimento = this.dataNasc.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - anoNascimento;

        if (mesAtual < mesNascimento) {
            idade--;
        } else if (mesAtual == mesNascimento && diaAtual < diaNascimento) {
            idade--;

        }
        return idade;
    }

    @Override
    public String toString() {
        return "Homem " +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", dataNasc=" + dataNasc.get(Calendar.DAY_OF_MONTH) + "/" + dataNasc.get(Calendar.MONTH) + "/" + dataNasc.get(Calendar.YEAR) +
                ", numCPF=" + parseCpf(numCPF) +
                ", peso=" + peso +
                ", altura=" + altura;

    }

}


