package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpaceshipTests {

    private Spaceship spaceship;
    private List<Astronaut> astronautlist = new ArrayList<>();

    @Before
    public void startUp(){
        this.spaceship = new Spaceship("Test",5);
        fillAstronauts();
    }
    private void fillSpaceShip(){
        for (Astronaut astronaut : astronautlist) {
            spaceship.add(astronaut);
        }
    }
    private void fillAstronauts(){
        Astronaut astronaut = new Astronaut("Ivan",200);
        Astronaut astronaut1 = new Astronaut("Mariya",100);
        Astronaut astronaut2 = new Astronaut("Georgi",150);
        Astronaut astronaut3 = new Astronaut("Sasho",210);
        Astronaut astronaut4 = new Astronaut("Pesho",170);

        astronautlist.add(astronaut);
        astronautlist.add(astronaut1);
        astronautlist.add(astronaut2);
        astronautlist.add(astronaut3);
        astronautlist.add(astronaut4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_ShouldReturnSpaceShipIsFull(){
        fillSpaceShip();
        spaceship.add(new Astronaut("OverCapacity",9999));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdd_ShouldThrowExceptionForSuchAstronautAdded(){
        spaceship.add(new Astronaut("Ivan",1000));
        spaceship.add(new Astronaut("Ivan",200));
    }

    @Test
    public void testGetCount_ShouldReturnCount(){
        fillSpaceShip();
        assertEquals( 5,spaceship.getCount());
    }
    @Test
    public void testGetName_ShouldReturnName(){
        assertEquals("Test",spaceship.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_ShouldThrowIfCapacityIsBellowZero(){
        Spaceship spaceshipWithNegativeCapacity = new Spaceship("TestWithZeroCapacity",-1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowBecauseNameIsEqualToNull(){
        Spaceship spaceshipWithNullName = new Spaceship(null,100);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowBecauseNameIsEmpty(){
        Spaceship spaceshipWithNullName = new Spaceship("",100);
    }

    @Test
    public void testRemove_ShouldReturnTrue(){
        fillSpaceShip();
        String astronautForRemove="Pesho";
        assertTrue(spaceship.remove(astronautForRemove));
    }
    @Test
    public void testRemove_ShouldReturnFalse(){
        fillSpaceShip();
        String astronautForRemove="petkan";
        assertFalse(spaceship.remove(astronautForRemove));
    }
}
