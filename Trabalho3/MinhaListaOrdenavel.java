

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel {
    ArrayList<PessoaIMC> pessoas= new ArrayList<PessoaIMC>();
    public  void add(PessoaIMC p){
        pessoas.add(p);
    }
    public PessoaIMC get(int i){
       return pessoas.get(i);
    }
    public void Ordena(int numero){
        Comparator<PessoaIMC> com = new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                if(o2.getAltura()-o1.getAltura()>0){
                    return 1;
                }else if(o2.getAltura()- o1.getAltura()<0){
                    return -1;
                }
                return 0;
            }
        };
        Comparator<PessoaIMC> com1 = new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                if(o2.getPeso()-o1.getPeso()>0){
                    return 1;
                }else if(o2.getPeso()- o1.getPeso()<0){
                    return -1;
                }
                return 0;
            }
        };
        Comparator<PessoaIMC> com3 = new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                if(o2.calculaIMC()-o1.calculaIMC()>0){
                    return 1;
                }else if(o2.calculaIMC()- o1.calculaIMC()<0){
                    return -1;
                }
                return 0;
            }
        };
        Comparator<PessoaIMC> com4=new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return o1.getNome().compareTo(o2.getNome());

            }
        };
        Comparator<PessoaIMC> com5=new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                if(o1.nome.equalsIgnoreCase(o2.getNome())){
                    return o2.sobreNome.compareTo(o1.sobreNome);
                }
                return o2.dataNasc.compareTo(o1.dataNasc);
            }
        };
        Comparator<PessoaIMC> com6= new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                if(o1 instanceof Homem){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        switch (numero){
            case 1:

                this.pessoas.sort(com);
            break;
            case 2:

                this.pessoas.sort(com1);
                break;
            case 3:

                this.pessoas.sort(com3);
                break;
            case 4:

                this.pessoas.sort(com4);
            break;
            case 5:
                this.pessoas.sort(com5);
            break;
            case 6:
                this.pessoas.sort(com6);
                break;
            case 7:

                this.pessoas.sort(com.reversed());
            break;
            case 8:
                this.pessoas.sort(com1.reversed());
            break;
            case 9:
                this.pessoas.sort(com3.reversed());
            break;
            case 10:
                this.pessoas.sort(com4.reversed());
                break;
            case 11:
                this.pessoas.sort(com5.reversed());
                break;
            case 12:
                this.pessoas.sort(com6.reversed());
                break;



        }


    }
}

