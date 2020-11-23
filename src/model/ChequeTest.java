package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ChequeTest {
    @Test
    void NuevoChequeTest()
    {
        LineaDeCredito l = new LineaDeCredito();

        Cheque c1 = new Cheque(l,1,1234, new Date(), 157498, new Date(), "1345-164-1", "pedritop",12);
        Cheque c2 = new Cheque(l,1,1234, new Date(), 157498, new Date(), "1345-164-1", "pedritop",12);

        int id1 = c1.getNumeroCertificadoGarantia();
        int id2 = c2.getNumeroCertificadoGarantia();

        assertNotEquals(id1,id2);
    }


}