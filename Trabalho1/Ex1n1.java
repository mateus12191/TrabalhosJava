

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1n1 {
    public static void main(String args[]) {
        int y = 0, x = 0; /*contadores de genero*/
        String nome = "";
        String Sobrenome = "";
        String peso = "", altura = "";
        String cpf = "";
        String data = "";

        Pessoa[] p = new Pessoa[1];
        /*Assumindo que a ordem digitada na linha de comando seja a mesma ordem dos atributos da classe pessoa apresentados: Nome,sobreNome...etc */
        try {
            for (int i = 0; i < args[0].length(); i++) {
                if (Character.isDigit(args[0].charAt(i))) {
                    System.out.println("Nome invalido digitado na linha de comando");
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nome nao Digitado na linha de comando");
            return;
        }
        try {
            for (int i = 0; i < args[1].length(); i++) {
                if (Character.isDigit(args[1].charAt(i))) {
                    System.out.println("SobreNome invalido digitado na linha de comando");
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("SobreNome nao Digitado na linha de comando");
            return;
        }
        try {
            if (!ValidaData.isAno(args[2]) || !ValidaData.isDia(args[2]) || !ValidaData.isMes(args[2])) {
                System.out.println("Data digitada na linha de comando invalida");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Data nao Digitada na linha de comando");
            return;
        }
        try {
            if (!ValidaCpf.isCpf(args[3]) || !(ValidaCpf.toIntCPF(args[3]) != 0)) {
                System.out.println("CPF digitado na linha de comando invalido");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("CPF nao Digitado na linha de comando");
            return;
        }
        try {
            if (!Pessoa.validaPeso(args[4])) {
                System.out.println("Peso digitado na linha de comando é invalido");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Peso nao Digitado na linha de comando");
            return;
        }
        try {
            if (!Pessoa.validaAltura(args[5])) {
                System.out.println("Altura digitada na linha de comando invalida");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Altura nao Digitado na linha de comando");
            return;
        }
        try {
            if (args[6].equalsIgnoreCase("M") || args[6].equalsIgnoreCase("Mulher")) {
                Mulher m = new Mulher(args[0], args[1], ValidaData.parseDia(args[2]), ValidaData.parseMes(args[2]), ValidaData.parseAno(args[2]), ValidaCpf.toIntCPF(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]));
                y++;
                p[0] = m;
                System.out.println("Pessoa da linha de comando " + m.toString());
            } else {

                if (args[6].equalsIgnoreCase("h") || args[6].equalsIgnoreCase("Homem")) {
                    Homem h = new Homem(args[0], args[1], ValidaData.parseDia(args[2]), ValidaData.parseMes(args[2]), ValidaData.parseAno(args[2]), ValidaCpf.toIntCPF(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]));
                    x++;
                    p[0] = h;
                    System.out.println("Pessoa da linha de comando " + h.toString());
                } else {
                    System.out.println("Genero Invalido Digitado na linha de comando");
                    return;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Genero nao digitado");
            return;
        }


        /* Rotina de leitura de dados */
        Scanner ler = new Scanner(System.in);
        int i = 0, n;
        while (true) {
            try {
                System.out.println("Escreva quantas pessoas voce quer inicializar");
                n = Integer.parseInt(ler.nextLine());
                if (n <= 0) {
                    System.out.println("Numero invalido");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido");
                continue;
            }

        }
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(p[0]);
        String s;
        while (i < n) {
            if (nome.equalsIgnoreCase("")) {
                System.out.println("Digite um nome valido");
                nome = ler.nextLine();
                if (!nome.equalsIgnoreCase("")) {
                    if (!nome.matches("[a-zA-Z]+")) {
                        nome = "";
                        continue;
                    }

                } else {
                    break;
                }

            }
            if (Sobrenome.equalsIgnoreCase("")) {
                System.out.println("Digite o Sobrenome");
                Sobrenome = ler.nextLine();
                if (!Sobrenome.equalsIgnoreCase("")) {
                    if (!Sobrenome.matches("[a-zA-Z]+")) {
                        Sobrenome = "";
                        continue;
                    }
                } else {
                    break;

                }
            }
            if (data.equalsIgnoreCase("")) {
                System.out.println("Digite uma data valida no Formato dd/mm/yy ou dia/mes/ano");
                data = ler.nextLine();
                if (!data.equalsIgnoreCase("")) {
                    if (!ValidaData.isDia(data) || !ValidaData.isMes(data) || !ValidaData.isAno(data)) {
                        System.out.println();
                        data = "";
                        continue;
                    }
                } else {
                    break;
                }
            }
            if (cpf.equalsIgnoreCase("")) {
                System.out.println("Digite Um cpf Valido");
                cpf = ler.nextLine();
                if (!cpf.equalsIgnoreCase("")) {
                    if (!ValidaCpf.isCpf(cpf) || ValidaCpf.toIntCPF(cpf) == 0) {
                        cpf = "";
                        continue;

                    } else {
                        if (ValidaCpf.cpfIgual(cpf, pessoas)) {
                            System.out.println("Cpf igual a de outra pessoa registrada anteriormente");
                            cpf = "";
                            continue;
                        }
                    }
                } else {
                    break;
                }
            }
            if (peso.equalsIgnoreCase("")) {
                System.out.println("Digite um peso Valido separado por ponto");
                peso = ler.nextLine();
                if (!peso.equalsIgnoreCase("")) {
                    if (!Pessoa.validaPeso(peso)) {
                        peso = "";
                        continue;
                    }
                } else {
                    break;
                }
            }
            if (altura.equalsIgnoreCase("")) {
                System.out.println("Digite uma altura valida");
                altura = ler.nextLine();
                if (!altura.equalsIgnoreCase("")) {
                    if (!Pessoa.validaAltura(altura)) {
                        altura = "";
                        continue;
                    }
                } else {
                    break;
                }
            }
            System.out.println("Digite um genero valido : Mulher ou Homem");
            s = ler.nextLine();
            peso.replaceAll("[\\D]", "");
            altura.replaceAll("[\\D]", "");
            if (s.equalsIgnoreCase("Mulher") || s.equalsIgnoreCase("M")) {
                Mulher m = new Mulher(nome, Sobrenome, ValidaData.parseDia(data), ValidaData.parseMes(data), ValidaData.parseAno(data), ValidaCpf.toIntCPF(cpf), Float.parseFloat(peso), Float.parseFloat(altura));
                pessoas.add(m);
                i++;
                nome = "";
                Sobrenome = "";
                data = "";
                cpf = "";
                peso = "";
                altura = "";
            } else if (s.equalsIgnoreCase("Homem") || s.equalsIgnoreCase("H")) {
                Homem h = new Homem(nome, Sobrenome, ValidaData.parseDia(data), ValidaData.parseMes(data), ValidaData.parseAno(data), ValidaCpf.toIntCPF(cpf), Float.parseFloat(peso), Float.parseFloat(altura));
                pessoas.add(h);
                i++;
                nome = "";
                Sobrenome = "";
                data = "";
                cpf = "";
                peso = "";
                altura = "";
            }

        }

        System.out.println("numero de pessoa inicializadas: " + Pessoa.getNum());
        for (i = 1; i < Pessoa.getNum(); i++) {
            if (pessoas.get(i) instanceof Homem) {
                x++;
            } else {
                y++;
            }
            System.out.println("Informacao da pessoa " + i + " : " + pessoas.get(i).toString());
        }
        System.out.println("Numero de homens inicializados: " + x + " Numero de mulheres inicializados: " + y);


    }


}


