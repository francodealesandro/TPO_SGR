package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {
    @Test
    void NuevoPrestamoTest()
    {
        Prestamo p1 = new Prestamo(1,"Ingresado",1234, false, new Date(),"Empresita",23,new Date(),12,"Aleman");
        Prestamo p2 = new Prestamo(1,"Ingresado",1234, false, new Date(),"Empresita",23,new Date(),12,"Aleman");

        int id1 = p1.getNumeroCertificadoGarantia();
        int id2 = p2.getNumeroCertificadoGarantia();

        assertNotEquals(id1,id2);


    }

}