import Multiplo.Multiplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiploTest {

    private Multiplo multiplo;
    private int limite;

    @BeforeEach
    public void setUp() {
        multiplo = new Multiplo();
        limite = 1000;
    }

    @Test
    @DisplayName("Deve verificar se um número é multiplo do divisor")
    public void verificarSeMultiploTest() {
        int numeroDivisor = 3;
        int numeroMultiplo = 9;

        boolean isMultiplo = multiplo.isMultiplo(numeroDivisor, numeroMultiplo);

        assertThat(isMultiplo).isTrue();
    }

    @Test
    @DisplayName("Deve verificar se um número não é multiplo do divisor")
    public void verficarSeNaoEMultiploTest() {
        int numeroDivisor = 3;
        int numeroMultiplo = 8;

        boolean isMultiplo = multiplo.isMultiplo(numeroDivisor, numeroMultiplo);

        assertThat(isMultiplo).isFalse();
    }

    @Test
    @DisplayName("Deve verificar se um número é multiplo de 3 ou 5")
    public void verificarSeMultiplo3ou5Test() {
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;
        int numeroMultiplo = 10;

        boolean isMultiploIndividual = multiplo.isMultiploIndividual(divisores, numeroMultiplo);

        assertThat(isMultiploIndividual).isTrue();
    }

    @Test
    @DisplayName("Deve verificar se um número é multiplo de 3 e 5")
    public void verificarSeMultiplo3e5Test() {
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;
        int numeroMultiplo = 15;

        boolean isMultiploAgrupado = multiplo.isMultiploAgrupado(divisores, numeroMultiplo);

        assertThat(isMultiploAgrupado).isTrue();
    }

    @Test
    @DisplayName("Deve retornar o valor da soma de todos os números múltiplos de 3 ou 5 de números naturais abaixo de 1000")
    public void somarMultiplos3ou5AbaixoDe1000Test() {
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;

        int resultado = multiplo.somarMultiplosIndividuais(divisores, limite);

        assertThat(resultado).isEqualTo(233168);
    }

    @Test
    @DisplayName("Deve retornar o valor da soma de todos os números múltiplos de 3 e 5 de números naturais abaixo de 1000")
    public void somarMultiplos3e5AbaixoDe1000Test() {
        int[] divisores = new int[2];
        divisores[0] = 3;
        divisores[1] = 5;

        int resultado = multiplo.somarMultiplosAgrupados(divisores, limite);

        assertThat(resultado).isEqualTo(33165);
    }

    @Test
    @DisplayName("Deve retornar o valor da soma de todos os números múltiplos de (3 ou 5) e 7 de números naturais abaixo de 1000")
    public void somarMultiplos3ou5e7AbaixoDe1000Test() {
        int[] divisores = new int[3];
        divisores[0] = 3;
        divisores[1] = 5;
        divisores[2] = 7;

        int resultado = multiplo.somarMultiplosIndividuaisEAgrupados(divisores, limite);

        assertThat(resultado).isEqualTo(37898);
    }
}
