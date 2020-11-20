package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ChequeTest {
    @Test
    void NuevoChequeTest()
    {
        Cheque c1 = new Cheque(1,"Ingresado",1234, false, new Date(), 157498, new Date(), "1345-164-1", "pedritop");
        Cheque c2 = new Cheque(1,"Ingresado",1234, false, new Date(), 157498, new Date(), "1345-164-1", "pedritop");

        int id1 = c1.getNumeroCertificadoGarantia();
        int id2 = c2.getNumeroCertificadoGarantia();

        assertNotEquals(id1,id2);
    }


}