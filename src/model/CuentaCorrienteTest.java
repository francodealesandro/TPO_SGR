package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {
    @Test
    void NuevaCuentaCorrienteTest()
    {
        CuentaCorriente cc1 = new CuentaCorriente(1,"Ingresado",1234, false, new Date(),"Empresita",new Date());
        CuentaCorriente cc2 = new CuentaCorriente(1,"Ingresado",1234, false, new Date(),"Empresita",new Date());

        int id1 = cc1.getNumeroCertificadoGarantia();
        int id2 = cc2.getNumeroCertificadoGarantia();

        assertNotEquals(id1,id2);

    }

}