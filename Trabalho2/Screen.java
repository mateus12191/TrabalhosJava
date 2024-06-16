import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class Screen extends JFrame {
    private JTextArea outputTextArea;
    private JComboBox<String> sortComboBox;

    private ArrayList<PessoaIMC> pessoas;

    public Screen() {
        pessoas = new ArrayList<>();
        // Pessoas teste que já tinham no programa anterior
        pessoas.add(new Homem("Antonio", "Andre", 2, 10, 2003, 70.2, 1.81));
        pessoas.add(new Mulher("Marcia", "Couto", 13, 2, 2001, 60.1, 1.64));
        pessoas.add(new Mulher("Maria", "Santos", 12, 7, 2006, 55.3, 1.60));
        pessoas.add(new Homem("Andre", "Felipe", 17, 9, 2008, 68, 1.78));
        pessoas.add(new Homem("Pedro", "Henriques", 30, 8, 1998, 80, 1.85));
        pessoas.add(new Homem("Rafael", "Cardoso", 19, 2, 2010, 43, 1.62));
        pessoas.add(new Homem("Claudio", "Pinto", 12, 12, 2007, 62, 1.74));
        pessoas.add(new Mulher("Vanessa", "Soares", 2, 6, 1997, 60, 1.65));
        pessoas.add(new Mulher("Roberta", "Goncalves", 23, 5, 2009, 55, 1.59));
        pessoas.add(new Mulher("Beatriz", "Anaral", 14, 10, 1996, 57, 1.68));

        setTitle("CalculaImc.exe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tamanho pré-definido de 800x600 mais por uma questão de não saber o tamanho do monitor do cliente, professor
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        sortComboBox = new JComboBox<>();
        sortComboBox.addItem("Ordem Crescente em altura");
        sortComboBox.addItem("Ordem Crescente em Peso");
        sortComboBox.addItem("Ordem Crescente em imc");
        sortComboBox.addItem("Ordem Decrescente em altura");
        sortComboBox.addItem("Ordem Decrescente em Peso");
        sortComboBox.addItem("Ordem Decrescente em imc");
        sortComboBox.addItem("Ordem Alfabética");
        sortComboBox.addItem("Ordem Alfabética Reversa");
        sortComboBox.addItem("Ordem Crescente em data de nascimento");
        sortComboBox.addItem("Ordem Decrescente em data de nascimento");
        sortComboBox.addItem("Ordem Homens primeiro Mulheres depois");
        sortComboBox.addItem("Ordem Mulheres Primeiros Homens depois");

        JButton printButton = new JButton("Imprimir");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printInformation();
            }
        });

        JButton addButton = new JButton("Adicionar Pessoa");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(sortComboBox);
        topPanel.add(printButton);
        topPanel.add(addButton);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void printInformation() {
        int selectedSortIndex = sortComboBox.getSelectedIndex();
        MinhaListaOrdenavel listaOrdenavel = new MinhaListaOrdenavel();
        listaOrdenavel.pessoas = pessoas;

        switch (selectedSortIndex) {
            case 0:
                listaOrdenavel.Ordena(1);
                break;
            case 1:
                listaOrdenavel.Ordena(2);
                break;
            case 2:
                listaOrdenavel.Ordena(3);
                break;
            case 3:
                listaOrdenavel.Ordena(7);
                break;
            case 4:
                listaOrdenavel.Ordena(8);
                break;
            case 5:
                listaOrdenavel.Ordena(9);
                break;
            case 6:
                listaOrdenavel.Ordena(4);
                break;
            case 7:
                listaOrdenavel.Ordena(10);
                break;
            case 8:
                listaOrdenavel.Ordena(11);
                break;
            case 9:
                listaOrdenavel.Ordena(5);
                break;
            case 10:
                listaOrdenavel.Ordena(12);
                break;
            case 11:
                listaOrdenavel.Ordena(6);
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listaOrdenavel.pessoas.size(); i++) {
            stringBuilder.append(listaOrdenavel.get(i).toString()).append("\n");
        }

        outputTextArea.setText(stringBuilder.toString());
        outputTextArea.setCaretPosition(0);
    }

    //Parte da leitura de dados, não era pedido no outro programa, mas adicionei
    private void addPerson() {
        String nome;
        String sobrenome;
        int dia;
        int mes;
        int ano;
        double peso;
        double altura;

        do {
            nome = JOptionPane.showInputDialog(this, "Digite o nome da pessoa:");
        } while (!isValidString(nome));

        do {
            sobrenome = JOptionPane.showInputDialog(this, "Digite o sobrenome da pessoa:");
        } while (!isValidString(sobrenome));

        do {
            dia = readIntInput("Digite o dia de nascimento da pessoa:");
        } while (!isValidDay(dia));

        do {
            mes = readIntInput("Digite o mês de nascimento da pessoa:");
        } while (!isValidMonth(mes));

        do {
            ano = readIntInput("Digite o ano de nascimento da pessoa:");
        } while (!isValidYear(ano));

        do {
            peso = readDoubleInput("Digite o peso da pessoa:");
        } while (!isValidWeight(peso));

        do {
            altura = readDoubleInput("Digite a altura da pessoa:");
        } while (!isValidHeight(altura));

        pessoas.add(new Homem(nome, sobrenome, dia, mes, ano, peso, altura));
        JOptionPane.showMessageDialog(this, "Pessoa adicionada com sucesso!");

        printInformation();
    }

    private int readIntInput(String message) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                value = Integer.parseInt(JOptionPane.showInputDialog(this, message));
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor inválido! Digite um número inteiro válido.");
            }
        }

        return value;
    }

    private double readDoubleInput(String message) {
        double value = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                value = Double.parseDouble(JOptionPane.showInputDialog(this, message));
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor inválido! Digite um número válido.");
            }
        }

        return value;
    }

    private boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty() && !input.matches("[0-9]+");
    }

    private boolean isValidDay(int day) {
        return day >= 1 && day <= 31;
    }

    private boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean isValidYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= 1900 && year <= currentYear;
    }

    private boolean isValidWeight(double weight) {
        return weight > 0;
    }

    private boolean isValidHeight(double height) {
        return height > 0;
    }
}