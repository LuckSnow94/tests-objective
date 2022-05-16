package Multiplo;

public class Multiplo {

    private int resultado;

    public static void main(String[] args) {
        Multiplo multiplo = new Multiplo();
        int limite = 1000;
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;

        System.out.println("Qual é o valor da soma de todos os números múltiplos de 3 ou 5 de números naturais abaixo de 1000?");
        System.out.println(multiplo.somarMultiplosIndividuais(divisores, limite));

        System.out.println("Qual é o valor da soma de todos os números múltiplos de 3 e 5 de números naturais abaixo de 1000?");
        System.out.println(multiplo.somarMultiplosAgrupados(divisores, limite));

        divisores = new int[3];
        divisores[0] = 3;
        divisores[1] = 5;
        divisores[2] = 7;
        System.out.println("Qual é o valor da soma de todos os números múltiplos de (3 ou 5) e 7 de números naturais abaixo de 1000?");
        System.out.println(multiplo.somarMultiplosIndividuaisEAgrupados(divisores, limite));

    }

    public boolean isMultiplo(int divisor, int multiplo) {
        return multiplo % divisor == 0;
    }

    public boolean isMultiploIndividual(int[] divisores, int multiplo) {
        for (int divisor : divisores)
            if (isMultiplo(divisor, multiplo))
                return true;
        return false;
    }

    public boolean isMultiploAgrupado(int[] divisores, int multiplo) {
        int mmc = 1;
        for (int divisor : divisores)
            mmc *= divisor;
        return isMultiplo(mmc, multiplo);
    }

    private void somarSeMultiploIndividual(int[] divisores, int multiplo) {
        if (isMultiploIndividual(divisores, multiplo))
            resultado += multiplo;
    }

    private void contarESomarSeMultiploIndividual(int[] divisores, int limite) {
        for (int i = 1; i < limite; i++)
            somarSeMultiploIndividual(divisores, i);
    }

    public int somarMultiplosIndividuais(int[] divisores, int limite) {
        resultado = 0;
        contarESomarSeMultiploIndividual(divisores, limite);
        return resultado;
    }

    private void somarSeMultiploAgrupado(int[] divisores, int multiplo) {
        if (isMultiploAgrupado(divisores, multiplo))
            resultado += multiplo;
    }

    private void contarESomarSeMultiploAgrupado(int[] divisores, int limite) {
        for (int i = 1; i < limite; i++) {
            somarSeMultiploAgrupado(divisores, i);
        }
    }

    public int somarMultiplosAgrupados(int[] divisores, int limite) {
        resultado = 0;
        contarESomarSeMultiploAgrupado(divisores, limite);
        return resultado;
    }

    public int somarMultiplosIndividuaisEAgrupados(int[] divisores, int limite) {
        resultado = 0;
        int[] divisores3e7 = new int[2];
        divisores3e7[0] = divisores[0];
        divisores3e7[1] = divisores[2];

        int[] divisores5e7 = new int[2];
        divisores5e7[0] = divisores[1];
        divisores5e7[1] = divisores[2];

        for (int i = 1; i < limite; i++) {
            somarSeMultiploAgrupado(divisores3e7, i);
            somarSeMultiploAgrupado(divisores5e7, i);
        }
        return resultado;
    }
}
