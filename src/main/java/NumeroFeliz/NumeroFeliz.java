package NumeroFeliz;

import java.util.ArrayList;
import java.util.List;

public class NumeroFeliz {

    public static void main(String[] args) {
        NumeroFeliz numeroFeliz = new NumeroFeliz();
        int numero = 4;
        System.out.println("Verificando se o numero " + numero + " é feliz");
        boolean isFeliz = numeroFeliz.validarSeNumeroFeliz(numero);
        if (isFeliz)
            System.out.println("É feliz");
        else
            System.out.println("Não é feliz");
    }

    public int calcularQuadrado(int numero) {
        return numero * numero;
    }

    public int[] separarAlgarismos(int numero) {
        char[] algarismos = String.valueOf(numero).toCharArray();
        int[] listaNumeros = new int[algarismos.length];
        for (int i = 0; i < listaNumeros.length; i++)
            listaNumeros[i] = Integer.parseInt(String.valueOf(algarismos[i]));
        return listaNumeros;
    }

    public int somarQuadradosAlgarismos(int[] algarismos) {
        int somaQuadrados = 0;
        for (int algarismo : algarismos)
            somaQuadrados += calcularQuadrado(algarismo);
        return somaQuadrados;
    }

    public boolean isCandidatoFeliz(List<Integer> repetidos, int quadrado) {
        return quadrado != 1 && !repetidos.contains(quadrado);
    }

    public boolean validarSeNumeroFeliz(int numero) {
        List<Integer> repetidos = new ArrayList<>();
        boolean isNumeroFeliz = false;
        int candidato = calcularQuadrado(numero);
        do {
            repetidos.add(candidato);
            int[] algarismos = separarAlgarismos(candidato);
            int somaQuadrados = somarQuadradosAlgarismos(algarismos);
            if (somaQuadrados == 1) isNumeroFeliz = true;
            candidato = somaQuadrados;
        } while (isCandidatoFeliz(repetidos, candidato));
        return isNumeroFeliz;
    }
}
