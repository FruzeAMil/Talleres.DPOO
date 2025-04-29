package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import java.io.File;
import java.io.FileNotFoundException;

public class PedidoTest {

    private Pedido pedido;
    private ProductoMenu producto1;
    private ProductoMenu producto2;
    @BeforeEach
    public void setUp() throws Exception {
        java.lang.reflect.Field field = Pedido.class.getDeclaredField("numeroPedidos");
        field.setAccessible(true);
        field.set(null, 0);
    
        pedido = new Pedido("Raquel Bernal", "Cra. 1 #18a-12");
        producto1 = new ProductoMenu("Hamburguesa mexicana", 24000);
        producto2 = new ProductoMenu("Coca Cola", 4000);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
    }
    @Test
    public void testGetIdPedido() {
        assertEquals(0, pedido.getIdPedido(), "El ID del pedido no es el esperado.");
    }

    @Test
    public void testGetNombreCliente() {
        assertEquals("Raquel Bernal", pedido.getNombreCliente(), "El nombre del cliente no es el esperado.");
    }

    @Test
    public void testAgregarProducto() {
        ProductoMenu producto3 = new ProductoMenu("Papas fritas", 9000);
        pedido.agregarProducto(producto3);
    
        int precioEsperado = (int) ((producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio()) * 1.19); // IVA del 19%
        assertEquals(precioEsperado, pedido.getPrecioTotalPedido(), "El producto no se agregó correctamente.");
    }

    @Test
    public void testGetPrecioTotalPedido() {
        int precioEsperado = (int) ((producto1.getPrecio() + producto2.getPrecio()) * 1.19);  // iva del 19%
        assertEquals(precioEsperado, pedido.getPrecioTotalPedido(), "El precio total del pedido no es el esperado.");
    }

    @Test
    public void testGenerarTextoFactura() {
        String textoFactura = pedido.generarTextoFactura();
        assertTrue(textoFactura.contains("Cliente: Raquel Bernal"), "El texto de la factura no contiene el nombre del cliente.");
        assertTrue(textoFactura.contains("Dirección: Cra. 1 #18a-12"), "El texto de la factura no contiene la dirección del cliente.");
        assertTrue(textoFactura.contains("Precio Neto:"), "El texto de la factura no contiene el precio neto.");
        assertTrue(textoFactura.contains("IVA:"), "El texto de la factura no contiene el IVA.");
        assertTrue(textoFactura.contains("Precio Total:"), "El texto de la factura no contiene el precio total.");
    }

    @Test
    public void testGuardarFactura() {
        File archivo = new File("data/factura.txt");
        try {
            pedido.guardarFactura(archivo);
            assertTrue(archivo.exists(), "El archivo de la factura no fue creado.");
        } catch (FileNotFoundException e) {
            fail("No se pudo guardar la factura: " + e.getMessage());
        } finally {
            archivo.delete();
        }
    }
}