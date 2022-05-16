import PalavrasEmNumeros.PalavrasEmNumeros;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PalavrasEmNumerosTest {

    private PalavrasEmNumeros palavrasEmNumeros;

    @BeforeEach
    public void setUp() {
        palavrasEmNumeros = new PalavrasEmNumeros();
    }

    @Test
    @DisplayName("Deve converter uma palavra em uma lista de letras")
    public void converterPalavraEmListaDeLetrasTest() {
        String palavra = "abc";
        List<Character> listaLetras = new ArrayList<>();
        listaLetras.add('a');
        listaLetras.add('b');
        listaLetras.add('c');

        List<Character> resultado = palavrasEmNumeros.converterPalavraEmListaDeLetras(palavra);

        assertThat(resultado).isEqualTo(listaLetras);
    }

    @Test
    @DisplayName("Deve calcular o valor de uma letra")
    public void calcularValorLetraTest() {
        char letra = 'A';
        int valorLetra = 27;

        int resultado = palavrasEmNumeros.calcularValorLetra(letra);

        assertThat(resultado).isEqualTo(valorLetra);
    }

    @Test
    @DisplayName("Deve lançar erro se character informado não é uma letra válida")
    public void validarValorLetraTest() {
        char letra = 'ç';

        Throwable exception = Assertions.catchThrowable(() -> palavrasEmNumeros.calcularValorLetra(letra));

        assertThat(exception)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Character informado não é uma letra");
    }

    @Test
    @DisplayName("Deve somar uma lista de letras")
    public void somarListaLetrasTest() {
        List<Character> listaLetras = new ArrayList<>();
        listaLetras.add('a');
        listaLetras.add('b');
        listaLetras.add('c');
        int somaLetras = 6;

        int resultado = palavrasEmNumeros.somarListaLetras(listaLetras);

        assertThat(resultado).isEqualTo(somaLetras);
    }

    @Test
    @DisplayName("Deve calcular o valor de uma palavra")
    public void calcularValorPalavraTest() {
        String palavra = "palavra";
        int valorPalavra = 71;

        int resultado = palavrasEmNumeros.calcularValorPalavra(palavra);

        assertThat(resultado).isEqualTo(valorPalavra);
    }

    @Test
    @DisplayName("Deve validar que um número é primo")
    public void validarNumeroPrimoTest() {
        int numero = 13;

        boolean isPrimo = palavrasEmNumeros.validarNumeroPrimo(numero);

        assertThat(isPrimo).isTrue();
    }

    @Test
    @DisplayName("Deve validar que um número nao é primo")
    public void validarNumeroNaoPrimoTest() {
        int numero = 15;

        boolean isPrimo = palavrasEmNumeros.validarNumeroPrimo(numero);

        assertThat(isPrimo).isFalse();
    }

    @Test
    @DisplayName("Deve validar que uma palavra é prima")
    public void validarPalavraPrimaTest() {
        String palavra = "primo";

        boolean isPalavraPrima = palavrasEmNumeros.validarSePalavraPrima(palavra);

        assertThat(isPalavraPrima).isTrue();
    }

    @Test
    @DisplayName("Deve validar que uma palavra não é prima")
    public void validarPalavraNaoPrimaTest() {
        String palavra = "prima";

        boolean isPalavraPrima = palavrasEmNumeros.validarSePalavraPrima(palavra);

        assertThat(isPalavraPrima).isFalse();
    }

    @Test
    @DisplayName("Deve validar que uma palavra é feliz")
    public void validarPalavraFelizTest() {
        String palavra = "feliz";

        boolean isPalavraFeliz = palavrasEmNumeros.validarSePalavraFeliz(palavra);

        assertThat(isPalavraFeliz).isTrue();
    }

    @Test
    @DisplayName("Deve validar que uma palavra não é feliz")
    public void validarPalavraNaoEFelizTest() {
        String palavra = "infeliz";

        boolean isPalavraFeliz = palavrasEmNumeros.validarSePalavraFeliz(palavra);

        assertThat(isPalavraFeliz).isFalse();
    }

    @Test
    @DisplayName("Deve validar que uma palavra é múltiplo de 3 ou 5")
    public void validarPalavraMultiplo3ou5Test() {
        String palavra = "abb";

        boolean isMultiplo = palavrasEmNumeros.validarSePalavraMultiplo3ou5(palavra);

        assertThat(isMultiplo).isTrue();
    }

    @Test
    @DisplayName("Deve validar que uma palavra não é múltiplo de 3 ou 5")
    public void validarPalavraNaoEMultiplo3ou5Test() {
        String palavra = "naomultiplo";

        boolean isMultiplo = palavrasEmNumeros.validarSePalavraMultiplo3ou5(palavra);

        assertThat(isMultiplo).isFalse();
    }

}
