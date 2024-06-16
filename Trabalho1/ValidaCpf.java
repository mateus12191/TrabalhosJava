

import java.util.ArrayList;

public class ValidaCpf {
    public static boolean isCpf(String CPF) {
        CPF = CPF.replaceAll("[\\D]", "");
        if (CPF.length() != 11) {
            return false;

        }
        return true;
    }

    public static long toIntCPF(String CPF) {

        int dig1, dig2;
        CPF = CPF.replaceAll("[\\D]", "");
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999")) {
            return 0;
        } else {
            int soma = 0, soma2 = 0, r = 0;
            /*Validacao dos digitos */
            for (int i = 0; i < 9; i++) {
                soma += ((int) CPF.charAt(i) - 48) * (10 - i);

            }
            r = 11 - (soma % 11);

            if (r == 11 || r == 10) {
                dig1 = 0;

            } else {
                dig1 = r;
            }
            for (int i = 0; i < 10; i++) {
                soma2 += ((int) CPF.charAt(i) - 48) * (11 - i);


            }
            r = 11 - (soma2 % 11);
            if (r == 11 || r == 10) {
                dig2 = 0;

            } else {
                dig2 = r;
            }
            if (dig1 == ((int) CPF.charAt(9) - 48) && dig2 == ((int) CPF.charAt(10) - 48)) {
                long x = Long.parseLong(CPF);
                return Long.parseLong(CPF);
            } else {
                return 0;
            }


        }
    }

    public static boolean cpfIgual(String cpf, ArrayList<Pessoa> pessoas) {

        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).numCPF == Long.parseLong(cpf.replaceAll("[\\D]", ""))) {
                return true;
            }
        }
        return false;
    }

}
