package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.*;

public class CoordinatesTest {
	@Test
	public void attach() {
		Coordinates c = new Coordinates(123, 123);
		Observer observer = null;
		c.attach(observer);
	}
}
