package one.digitalinnovation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidadorDeSenhas {
    public static void main(String[] args) throws IOException {
        List<String> validaOuInvalida = new ArrayList<String>();

        // Importando arquivos para execução do EOF.
//        String nome = "c://Users//Thiago//Desktop//Entradas_1.txt";
//        try {
//            System.setIn(new FileInputStream(new File(nome)));
//        } catch (FileNotFoundException e) {
//            System.out.println("Arquivo não encontrado!");
//        }

        // Entrada de dados
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){

            VerificaSenha verificaSenha = new VerificaSenha();

            // Entrada de dados (senha)
            String senha = input.nextLine();

            // Verifica se a senha não contém nenhum caractere de pontuação, acentuação ou espaço
            boolean contemCaracteresEspeciais = false;
            for(int i = 0; i < senha.length(); i++) {
                if(verificaSenha.verificaCaractere(Character.toString(senha.charAt(i)))) {
                    contemCaracteresEspeciais = true;
                    break;
                }
            }

            // Verifica se a senha contém no mínimo, uma letra maiúscula, uma letra minúscula e um número
            boolean verificaMaiuscula = false;
            boolean verificaMinuscula = false;
            boolean verificaNumero = false;
            for(int i = 0; i < senha.length(); i++) {
                if(verificaSenha.verificaLetrasMinusculas(Character.toString(senha.charAt(i)))) {
                    verificaMinuscula = true;

                }
                if(verificaSenha.verificaLetrasMaiusculas(Character.toString(senha.charAt(i)))) {
                    verificaMaiuscula = true;

                }
                if(verificaSenha.verificaLetrasNumeros(Character.toString(senha.charAt(i)))) {
                    verificaNumero = true;

                }
            }

            // Validando a senha
            for(int i = 0;; i++ ) {
                if(senha.length() < verificaSenha.getMin() || senha.length() > verificaSenha.getMax()
                        || !verificaMaiuscula || !verificaMinuscula || !verificaNumero || contemCaracteresEspeciais) { //complete o if de acordo com suas variaveis
                    validaOuInvalida.add("Senha invalida.");
                    break;
                } else {
                    validaOuInvalida.add("Senha valida.");
                    break;
                }
            }
        }
        for (String print : validaOuInvalida) {
            System.out.println(print);
        }
    }
}

class VerificaSenha {
    private final static int MAX = 32;
    private final static int MIN = 6;

    public VerificaSenha() {
    }

    public boolean verificaCaractere(String verificaCaractere) {
        return verificaCaractere.matches("\\p{Punct}|\\s");

    }

    public boolean verificaLetrasMinusculas(String verificaLetrasMinusculas) {
        return verificaLetrasMinusculas.matches("[a-z]");
    }

    public boolean verificaLetrasMaiusculas(String verificaLetrasMaiusculas) {
        return verificaLetrasMaiusculas.matches("[A-Z]");
    }

    public boolean verificaLetrasNumeros(String verificaLetrasNumeros) {
        return verificaLetrasNumeros.matches("[0-9]");
    }

    public int getMax() {
        return MAX;
    }

    public int getMin() {
        return MIN;
    }
}