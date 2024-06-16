

import java.util.GregorianCalendar;

public class Pessoa {
    protected static int num;
    protected String nome;
    protected String sobreNome;
    protected GregorianCalendar dataNasc = new GregorianCalendar();
    protected String nomeS = nome+""+sobreNome;

    public String getNomeS() {
        return nomeS;
    }

    public void setNomeS(String nomeS) {
        this.nomeS = nomeS;
    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc.set(ano,mes,dia);
        num++;


    }


    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Pessoa.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(GregorianCalendar dataNasc) {
        this.dataNasc = dataNasc;
    }




}


