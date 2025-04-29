package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import java.util.ArrayList;

public class ComboTest {

    private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new ProductoMenu("Hamburguesa doble carne", 10000);
        producto2 = new ProductoMenu("Papas encebolladas", 5000);
        ArrayList<ProductoMenu> items = new ArrayList<>();
        items.add(producto1);
        items.add(producto2);
        combo = new Combo("Combo prueba", 0.95, items);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo prueba", combo.getNombre(), "El nombre del combo no es el esperado.");
    }

    @Test
    public void testGetPrecio() {
        int precioEsperado = (int) ((producto1.getPrecio() + producto2.getPrecio()) * 0.95);
        assertEquals(precioEsperado, combo.getPrecio(), "El precio del combo no es el esperado.");
    }

    @Test
    public void testGenerarTextoFactura() {
        String textoEsperado = "Combo Combo prueba\n Descuento: 0.95\n            " + combo.getPrecio() + "\n";
        assertEquals(textoEsperado, combo.generarTextoFactura(), "El texto de la factura no es el esperado.");
    }
}
