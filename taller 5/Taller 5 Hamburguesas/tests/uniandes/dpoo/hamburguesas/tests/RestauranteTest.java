package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.excepciones.*;

import java.io.File;
import java.io.IOException;

public class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    public void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    public void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
        restaurante.iniciarPedido("Raquel Bernal", "Cra. 1 #18a-12");
        assertNotNull(restaurante.getPedidoEnCurso(), "El pedido en curso no debería ser null.");
        assertEquals("Raquel Bernal", restaurante.getPedidoEnCurso().getNombreCliente(), "El nombre del cliente no es el esperado.");
    }

    @Test
    public void testIniciarPedidoYaExistente() {
        assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            restaurante.iniciarPedido("Raquel Bernal", "Cra. 1 #18a-12");
            restaurante.iniciarPedido("Mark Zuckerberg", "1 Hacker Way, Menlo Park, CA 94025");
        }, "Debería lanzarse una excepción si ya hay un pedido en curso.");
    }
    @Test
    public void testCerrarYGuardarPedidoSinPedidoA() throws IOException {
        try {
            restaurante.cerrarYGuardarPedido();
            fail("Debería lanzarse una excepción si no hay un pedido en curso.");
        } catch (NoHayPedidoEnCursoException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCerrarYGuardarPedido() throws YaHayUnPedidoEnCursoException, IOException, NoHayPedidoEnCursoException {
        restaurante.iniciarPedido("Raquel Bernal", "Cra. 1 #18a-12");
        restaurante.cerrarYGuardarPedido();
        assertNull(restaurante.getPedidoEnCurso(), "El pedido en curso debería ser null después de cerrarlo.");
    }

    @Test
    public void testGetPedidos() {
        assertNotNull(restaurante.getPedidos(), "La lista de pedidos no debería ser null.");
        assertTrue(restaurante.getPedidos().isEmpty(), "La lista de pedidos debería estar vacía inicialmente.");
    }

    @Test
    public void testGetMenuBase() {
        assertNotNull(restaurante.getMenuBase(), "El menú base no debería ser null.");
        assertTrue(restaurante.getMenuBase().isEmpty(), "El menú base debería estar vacío inicialmente.");
    }

    @Test
    public void testGetMenuCombos() {
        assertNotNull(restaurante.getMenuCombos(), "El menú de combos no debería ser null.");
        assertTrue(restaurante.getMenuCombos().isEmpty(), "El menú de combos debería estar vacío inicialmente.");
    }

    @Test
    public void testGetIngredientes() {
        assertNotNull(restaurante.getIngredientes(), "La lista de ingredientes no debería ser null.");
        assertTrue(restaurante.getIngredientes().isEmpty(), "La lista de ingredientes debería estar vacía inicialmente.");
    }

    @Test
    public void testCargarInformacionRestaurante() throws IOException, HamburguesaException {

        File archivoIngredientes = new File("data/ingredientes.txt");
        File archivoMenu = new File("data/menu.txt");
        File archivoCombos = new File("data/combos.txt");

        assertTrue(archivoIngredientes.exists(), "El archivo de ingredientes no existe.");
        assertTrue(archivoMenu.exists(), "El archivo del menú no existe.");
        assertTrue(archivoCombos.exists(), "El archivo de combos no existe.");

        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);


        assertNotNull(restaurante.getIngredientes(), "La lista de ingredientes no debería ser null después de cargar información.");
        assertFalse(restaurante.getIngredientes().isEmpty(), "La lista de ingredientes no debería estar vacía después de cargar información.");

        assertNotNull(restaurante.getMenuBase(), "El menú base no debería ser null después de cargar información.");
        assertFalse(restaurante.getMenuBase().isEmpty(), "El menú base no debería estar vacío después de cargar información.");

        assertNotNull(restaurante.getMenuCombos(), "El menú de combos no debería ser null después de cargar información.");
        assertFalse(restaurante.getMenuCombos().isEmpty(), "El menú de combos no debería estar vacío después de cargar información.");
    }
}