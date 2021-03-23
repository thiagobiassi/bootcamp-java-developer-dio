package one.digitalinnovation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conjuntos {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        while (true) {
            List<String> palavrasEmConjunto = new ArrayList<>();
            // Determinar a quantidade de palavras no conjunto
            int qtWords = input.nextInt();input.nextLine();

            // Verificando o máximo de palavras utilizadas no Array
            if (qtWords >= 1 && qtWords <= 100000){}
            else {break;}

            String word = null;
            // Entrada de dados das palavras do conjunto
            for (int n = 1; n <= qtWords; n++) {
                word = input.nextLine().toLowerCase().replaceAll(" ", "");
                if (word.length() > 100) {
                    break;
                } else {
                    palavrasEmConjunto.add(word);
                } // Verifica se a String possui mais que 100 caracteres
            }

            // Contador para repetições
            int repeticao = 0;

            // Looping para navegar nos Arrays e compará-los
            for (int i = 0; i < palavrasEmConjunto.size(); i++) {
                if (word.length() > 100) {break;}
                String prefixo = palavrasEmConjunto.get(i).substring(0, 1);
                for (int j = 0; j < palavrasEmConjunto.size(); j++) {
                    if (i == j) {
                        continue;
                    } // Quando os índices forem iguais então pula para o próximo
                    String prefixoVerifica = palavrasEmConjunto.get(j).substring(0, 1);
                    if (prefixo.equals(prefixoVerifica)) { // Se forem iguais, adiciona na var repeticao
                        repeticao++;
                    }
                }
            }
            if(word.length() < 100) {
                if (repeticao == 0) {
                    System.out.println("Conjunto Bom");
                } else {
                    System.out.println("Conjunto Ruim");
                }
            }
        }
    }
}