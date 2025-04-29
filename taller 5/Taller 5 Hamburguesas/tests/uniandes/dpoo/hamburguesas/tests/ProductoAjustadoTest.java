package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class ProductoAjustadoTest {

    private ProductoMenu productoBase;
    private ProductoAjustado productoAjustado;

    @BeforeEach
    public void setUp() {
        productoBase = new ProductoMenu("Hamburguesa sencilla", 19000);
        productoAjustado = new ProductoAjustado(productoBase);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Hamburguesa sencilla", productoAjustado.getNombre(), "El nombre del producto ajustado no es el esperado.");
    }

    @Test
    public void testGetPrecio() {
        assertEquals(19000, productoAjustado.getPrecio(), "El precio del producto ajustado sin modificaciones no es el esperado.");
    }
    @Test
    public void testGenerarTextoFacturaSinModificaciones() {
        String textoEsperado = "Hamburguesa sencilla\n            19000\n";
        assertEquals(textoEsperado, productoAjustado.generarTextoFactura(), "El texto de la factura sin modificaciones no es el esperado.");
    }

    @Test
    public void testGenerarTextoFacturaConAgregados() {
        Ingrediente queso = new Ingrediente("Queso extra", 2000);
        Ingrediente tocineta = new Ingrediente("Tocineta", 3000);

        productoAjustado.agregarIngrediente(queso);
        productoAjustado.agregarIngrediente(tocineta);

        String textoEsperado = "Hamburguesa sencilla\n" +
                               "    +Queso extra                2000\n" +
                               "    +Tocineta                   3000\n" +
                               "            24000\n";
        assertEquals(textoEsperado, productoAjustado.generarTextoFactura(), "El texto de la factura con agregados no es el esperado.");
    }

    @Test
    public void testGenerarTextoFacturaConEliminados() {
        Ingrediente cebolla = new Ingrediente("Cebolla", 0);

        productoAjustado.eliminarIngrediente(cebolla);

        String textoEsperado = "Hamburguesa sencilla\n" +
                               "    -Cebolla\n" +
                               "            19000\n";
        assertEquals(textoEsperado, productoAjustado.generarTextoFactura(), "El texto de la factura con eliminados no es el esperado.");
    }

    @Test
    public void testGenerarTextoFacturaConAgregadosYEliminados() {
        Ingrediente queso = new Ingrediente("Queso extra", 2000);
        Ingrediente tocineta = new Ingrediente("Tocineta", 3000);
        Ingrediente cebolla = new Ingrediente("Cebolla", 0);
    
        productoAjustado.agregarIngrediente(queso);
        productoAjustado.agregarIngrediente(tocineta);
        productoAjustado.eliminarIngrediente(cebolla);
    
        String textoEsperado = "Hamburguesa sencilla\n" +
                               "    +Queso extra              2000\n" +
                               "    +Tocineta                 3000\n" +
                               "    -Cebolla\n" +
                               "            24000\n";
        assertEquals(textoEsperado, productoAjustado.generarTextoFactura(), "El texto de la factura con agregados y eliminados no es el esperado.");
    }
}