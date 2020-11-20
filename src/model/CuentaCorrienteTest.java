package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {
    @Test
    void NuevaCuentaCorrienteTest()
    {
        LineaDeCredito l = new LineaDeCredito();
        CuentaCorriente cc1 = new CuentaCorriente(l,1,1234, new Date(),"Empresita",new Date());
        CuentaCorriente cc2 = new CuentaCorriente(l,1,1234,  new Date(),"Empresita",new Date());

        int id1 = cc1.getNumeroCertificadoGarantia();
        int id2 = cc2.getNumeroCertificadoGarantia();

        assertNotEquals(id1,id2);

    }

}