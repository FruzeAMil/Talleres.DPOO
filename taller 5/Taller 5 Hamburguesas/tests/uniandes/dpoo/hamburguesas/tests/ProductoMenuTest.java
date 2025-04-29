package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

    private ProductoMenu producto;

    @BeforeEach
    public void setUp() {
        producto = new ProductoMenu("Hamburguesa sencilla", 19000);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Hamburguesa sencilla", producto.getNombre(), "El nombre del producto no es el esperado.");
    }

    @Test
    public void testGetPrecio() {
        assertEquals(19000, producto.getPrecio(), "El precio del producto no es el esperado.");
    }

    @Test
    public void testGenerarTextoFactura() {
        String textoEsperado = "Hamburguesa sencilla\n            19000\n";
        assertEquals(textoEsperado, producto.generarTextoFactura(), "El texto de la factura no es el esperado.");
    }
}