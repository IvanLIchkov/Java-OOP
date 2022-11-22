package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AquariumTests {
    private List<Fish> fishList = new ArrayList<>();

    private Aquarium aquarium;

    @Before
    public void startUp(){
        aquarium = new Aquarium("Test",5);
        fillFishList();
    }

    public void fillAquarium(){
        fishList.forEach(fish -> aquarium.add(fish));
    }

    public void fillFishList(){
        Fish fish = new Fish("Tosho");
        Fish fish1 = new Fish("Pesho");
        Fish fish2 = new Fish("Gosho");
        Fish fish3 = new Fish("Ivan");
        Fish fish4 = new Fish("Georgi");

        fishList.add(fish);
        fishList.add(fish1);
        fishList.add(fish2);
        fishList.add(fish3);
        fishList.add(fish4);
    }

    @Test
    public void testGetCapacity_ShouldReturnCapacity(){
        assertEquals(5,aquarium.getCapacity());
    }
    @Test
    public void testGetName(){
        assertEquals("Test",aquarium.getName());
    }
    @Test
    public void testSetNameName(){
        String name= "TestName";
        Aquarium aquarium1 = new Aquarium(name,10);

        assertEquals(name,aquarium1.getName());
    }
    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowForEmptyName(){
        String name= "";
        Aquarium aquarium1 = new Aquarium(name,10);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowForNullName(){
        String name= null;
        Aquarium aquarium1 = new Aquarium(name,10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_ShouldThrowForNegativeCapacity(){
        Aquarium aquarium1 = new Aquarium("InvalidCapacity",-1);
    }
    @Test
    public void testCapacity_ShouldSetCapacity(){
        Aquarium aquarium1 = new Aquarium("testCapacity",0);
        assertEquals(0,aquarium1.getCapacity());
    }
    @Test
    public void testAddFish_ShouldAddFish(){
        aquarium.add(new Fish("Pesho"));
        assertEquals(1,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFish_ShouldThrowForFullAquarium(){
        fillAquarium();
        aquarium.add(new Fish("Ivan"));
    }
    @Test
    public void testGetCount_ShouldReturnFishCount(){
        fillAquarium();
        assertEquals(5,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFish_ShouldThrowForNoSuchFish(){
        String name = "Bashko";
        fillAquarium();
        aquarium.remove(name);
    }
    @Test
    public void testRemoveFish_ShouldRemoveFish(){
        String fishForRemoveName = "Tosho";
        fillAquarium();
        int countBeforeRemove=aquarium.getCount();
        aquarium.remove(fishForRemoveName);
        int countAfterRemove = aquarium.getCount();
        assertEquals(countBeforeRemove,countAfterRemove+1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSellFish_ShouldThrowForNoSuchFish(){
        Fish fish = new Fish("Fincii");
        fillAquarium();
        aquarium.sellFish(fish.getName());
    }
    @Test
    public void testSellFish_ShouldReturnSealedFish(){
        String fishForSaleName = "Ivan";
        Fish expectedFishForSale = fishList.stream().filter(fish -> fish.getName().equals(fishForSaleName)).findFirst().get();
        fillAquarium();
        Fish sealedFish=aquarium.sellFish(fishForSaleName);
        assertEquals(expectedFishForSale,sealedFish);
    }
    @Test
    public void testReport_ShouldReturnReport(){
        String names = fishList.stream().map(Fish::getName).collect(Collectors.joining(", "));
        String expectedReport = String.format("Fish available at %s: %s", aquarium.getName(), names);
        fillAquarium();
        String actualReport = aquarium.report();
        assertEquals(expectedReport,actualReport);
    }
}

