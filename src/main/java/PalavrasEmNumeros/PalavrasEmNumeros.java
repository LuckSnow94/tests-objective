package PalavrasEmNumeros;

import Multiplo.Multiplo;
import NumeroFeliz.NumeroFeliz;

import java.util.ArrayList;
import java.util.List;

public class PalavrasEmNumeros {

    private final List<Character> letras;

    private final NumeroFeliz numeroFeliz;
    private final Multiplo multiplo;

    public static void main(String[] args) {
        PalavrasEmNumeros palavrasEmNumeros = new PalavrasEmNumeros();
        String palavra = "feliz";

        boolean isPalavraPrima = palavrasEmNumeros.validarSePalavraPrima(palavra);
        if (isPalavraPrima)
            System.out.println("A palavra " + palavra + " é prima");
        else
            System.out.println("A palavra " + palavra + " não é prima");

        boolean isPalavraFeliz = palavrasEmNumeros.validarSePalavraFeliz(palavra);
        if (isPalavraFeliz)
            System.out.println("A palavra " + palavra + " é feliz");
        else
            System.out.println("A palavra " + palavra + " não é feliz");

        boolean isPalavraMultipla3ou5 = palavrasEmNumeros.validarSePalavraMultiplo3ou5(palavra);
        if (isPalavraMultipla3ou5)
            System.out.println("A palavra " + palavra + " é múltipla de 3 ou 5");
        else
            System.out.println("A palavra " + palavra + " não é múltipla de 3 ou 5");
    }

    public PalavrasEmNumeros() {
        this.numeroFeliz = new NumeroFeliz();
        this.multiplo = new Multiplo();
        String alfabeto = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ";
        this.letras = converterPalavraEmListaDeLetras(alfabeto);
    }

    public List<Character> converterPalavraEmListaDeLetras(String palavra) {
        List<Character> listaLetras = new ArrayList<>();
        for (char letra : palavra.toCharArray())
            listaLetras.add(letra);
        return listaLetras;
    }

    public int calcularValorLetra(char letra) {
        int valorLetra = letras.indexOf(letra) + 1;
        validarLetra(valorLetra);
        return valorLetra;
    }

    private void validarLetra(int valorLetra) {
        if (valorLetra < 1)
            throw new UnsupportedOperationException("Character informado não é uma letra");
    }

    public int somarListaLetras(List<Character> listaLetras) {
        int somaLetras = 0;
        for (char letra : listaLetras)
            somaLetras += calcularValorLetra(letra);
        return somaLetras;
    }

    public int calcularValorPalavra(String palavra) {
        List<Character> listaLetras = converterPalavraEmListaDeLetras(palavra);
        return somarListaLetras(listaLetras);
    }

    public boolean validarSePalavraFeliz(String palavra) {
        int valorPalavra = calcularValorPalavra(palavra);
        return numeroFeliz.validarSeNumeroFeliz(valorPalavra);
    }

    public boolean validarSePalavraMultiplo3ou5(String palavra) {
        int valorPalavra = calcularValorPalavra(palavra);
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;
        return multiplo.isMultiploIndividual(divisores, valorPalavra);
    }

    public boolean validarNumeroPrimo(int numero) {
        for (int i = 2; i < numero; i++)
            if (multiplo.isMultiplo(i, numero))
                return false;
        return true;
    }

    public boolean validarSePalavraPrima(String palavra) {
        int valorPalavra = calcularValorPalavra(palavra);
        return validarNumeroPrimo(valorPalavra);
    }
}
