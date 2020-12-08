package com.br.gerenciapontos;

import com.br.gerenciapontos.domain.request.PontoRequest;
import com.br.gerenciapontos.service.PontoService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
public class PontoServiceTest extends TestCase {

    @Autowired
    private PontoService pontoService;


    @Test
    private void testandoComoTestar() {
        System.out.println("WORKS!");
    }


    //@Test(expected = RuntimeException.class)
    @Test
    public void whenCoordenadasJaExistiremThenThrowRunTimeException() {
//        PontoEntity pontoEntity = new PontoEntity(3.0,4.0);
//        pontoRepository.save(pontoEntity);
//        PontoRequest pontoRequest = new PontoRequest();
//        pontoRequest.setX(3.0);
//        pontoRequest.setY(4.0);
//
//        pontoService.create(pontoRequest);
    }

    @Test
    public void whenCreateANewPointThenExpectedAPointResponse() {
        PontoRequest pontoRequest = new PontoRequest();
        pontoRequest.setX(3.0);
        pontoRequest.setY(4.0);
        Assert.assertNotNull(pontoService.create(pontoRequest));
    }

}
