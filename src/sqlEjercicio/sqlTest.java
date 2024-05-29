package sqlEjercicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Paquete;

class sqlTest {

	@Test
	void testConfirmarID() {
		String nameString = "Daniel";
		String Password = "1234";
		short cargo = sql.confirmarID(nameString, Password);
		assertEquals(1, cargo);
	}

	@Test
	void testModificarPassword() {
		String passwordString = "1256";
		int id = 4;
		boolean mp = sql.modificarPassword(passwordString, id);
		assertTrue(mp);
	}

	@Test
	void testCrearPaquete() {
		Paquete paquete = new Paquete("6", "Sebastian", 80);
		assertFalse(sql.crearPaquete(paquete));//Va a dar failure porque en el metodo devuelve true
	}

}
