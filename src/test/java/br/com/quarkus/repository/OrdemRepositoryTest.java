package br.com.quarkus.repository;

import br.com.quarkus.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class OrdemRepositoryTest {

    @InjectMock
    private OrdemRepository ordemRepository;

    @Test
    public void testListAllRetornisListOrdem(){
        Ordem firstOrdem = new Ordem();
        Ordem secundOrdem = new Ordem();

        List<Ordem> ordems = Arrays.asList(firstOrdem, secundOrdem);

        Mockito.when(ordemRepository.listAll()).thenReturn(ordems);

        Assertions.assertSame(secundOrdem, ordemRepository.listAll().get(1));
    }
}
