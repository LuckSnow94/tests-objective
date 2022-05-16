import NumeroFeliz.NumeroFeliz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumeroFelizTest {

    private NumeroFeliz numeroFeliz;

    @BeforeEach
    public void setUp() {
        numeroFeliz = new NumeroFeliz();
    }

    @Test
    @DisplayName("Deve calcular o quadrado de um número")
    public void calcularQuadradoTest() {
        int numero = 7;
        int quadrado = 49;

        int resultado = numeroFeliz.calcularQuadrado(numero);

        assertThat(resultado).isEqualTo(quadrado);
    }

    @Test
    @DisplayName("Deve separar os algarismos de um número")
    public void separarAlgarismosTest() {
        int numero = 49;
        int[] algarismos = new int[2];
        algarismos[0] = 4;
        algarismos[1] = 9;

        int[] resultado = numeroFeliz.separarAlgarismos(numero);

        assertThat(resultado).isEqualTo(algarismos);
    }

    @Test
    @DisplayName("Deve somar os quadrados de cada algorismo do vetor")
    public void somarQuadradosAlgarismosTest() {
        int[] algarismos = new int[2];
        algarismos[0] = 4;
        algarismos[1] = 9;
        int somaQuadrados = 97;

        int resultado = numeroFeliz.somarQuadradosAlgarismos(algarismos);

        assertThat(resultado).isEqualTo(somaQuadrados);
    }

    @Test
    @DisplayName("Deve validar que o resultado é candidato para verificação de número feliz")
    public void validarCandidatoFelizTest() {
        int candidatoFeliz = 97;
        List<Integer> mockRepetidos = new ArrayList<>();

        boolean isCandidatoFeliz = numeroFeliz.isCandidatoFeliz(mockRepetidos, candidatoFeliz);

        assertThat(isCandidatoFeliz).isTrue();
    }

    @Test
    @DisplayName("Deve validar que o resultado não é candidato para verificação de número feliz")
    public void validarNaoCandidatoFelizTest() {
        int naoCandidatoFeliz = 97;
        List<Integer> mockRepetidos = new ArrayList<>();
        mockRepetidos.add(naoCandidatoFeliz);

        boolean isCandidatoFeliz = numeroFeliz.isCandidatoFeliz(mockRepetidos, naoCandidatoFeliz);

        assertThat(isCandidatoFeliz).isFalse();
    }

    @Test
    @DisplayName("Deve validar que o número informado é feliz")
    public void validarNumeroFelizTest() {
        int numero = 7;

        boolean isNumeroFeliz = numeroFeliz.validarSeNumeroFeliz(numero);

        assertThat(isNumeroFeliz).isTrue();
    }

    @Test
    @DisplayName("Deve validar que o número informado não é feliz")
    public void validarNumeroNaoEFelizTest() {
        int numero = 4;

        boolean isNumeroFeliz = numeroFeliz.validarSeNumeroFeliz(numero);

        assertThat(isNumeroFeliz).isFalse();
    }
}
