

import java.util.GregorianCalendar;

public class Pessoa {
    protected static int num;
    protected String nome;
    protected String sobreNome;
    protected GregorianCalendar dataNasc = new GregorianCalendar();
    protected long numCPF;
    protected float peso;
    protected float altura;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc.set(dia, mes, ano);
        num++;


    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc.set(ano, mes, dia);
        this.peso = peso;
        this.altura = altura;
        this.numCPF = numCPF;
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

    public long getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public static boolean validaPeso(String x) {
        float y;
        try {
            y = Float.parseFloat(x);
            return y >= 0;
        } catch (NumberFormatException exception) {
            return false;
        }

    }

    public static boolean validaAltura(String x) {
        float y;
        try {
            y = Float.parseFloat(x);
            return y > 0;

        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static String parseCpf(long x) {
        String y;
        y = String.valueOf(x);
        while (y.length() < 11) {
            y = "0" + y;
        }

        y = y.substring(0, 3) + "." + y.substring(3, 6) + "." + y.substring(6, 9) + "-" + y.substring(9, 11);
        return y;
    }
}


