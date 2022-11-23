package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    private Collection<Hero> heroes;
    private HeroRepository heroRepository;

    @Before
    public void startUp(){
        heroRepository = new HeroRepository();
        heroes = new ArrayList<>();
    }

    public void fillRepository(){
        heroes.forEach(hero -> heroRepository.create(hero));
    }

    public void fillHeroes(){
        Hero hero = new Hero("Ivan",10);
        Hero hero1 = new Hero("Pesho",20);
        Hero hero2 = new Hero("Marian",30);
        Hero hero3 = new Hero("Dimitar",40);
        Hero hero4 = new Hero("Kaloyan",50);

        heroes.add(hero);
        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        heroes.add(hero4);
    }

    @Test(expected = NullPointerException.class)
    public void testCreate_ShouldThrowExceptionForNullHero(){
        Hero hero = null;
        heroRepository.create(hero);
    }
    @Test
    public void testGetHeroes_ShouldReturnCollection(){
        fillHeroes();
        fillRepository();
        List<Hero> actualHeroes = heroRepository.getHeroes().stream().collect(Collectors.toList());
        assertEquals(heroes,actualHeroes);
    }
    @Test
    public void testGetHero_ShouldReturnNullBecauseNoSuchHero(){
        fillHeroes();
        fillRepository();
        assertNull(heroRepository.getHero("test"));
    }
    @Test
    public void testGetHero_ShouldReturnHero(){
        fillHeroes();
        fillRepository();
        String nameForSearch = "Dimitar";
        Hero expectedHero = heroes.stream().filter(hero -> hero.getName().equals(nameForSearch)).findFirst().get();
        Hero actualHero = heroRepository.getHero(nameForSearch);
        assertEquals(expectedHero,actualHero);
    }
    @Test
    public void testCreate_ShouldCreateHero(){

    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowForHeroAlreadyExist(){
        Hero hero = new Hero("Test",10);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }
    @Test(expected = NullPointerException.class)
    public void testRemove_ShouldThrowForNullName(){
        Hero nullHero=new Hero(null,10);
        heroRepository.remove(nullHero.getName());
    }
    @Test(expected = NullPointerException.class)
    public void testRemove_ShouldThrowForEmptyName(){
        Hero emptyName=new Hero("",10);
        heroRepository.remove(emptyName.getName());
    }
    @Test
    public void testRemove_ShouldReturnFalseBecauseNoHeroWithThatName(){
        assertFalse(heroRepository.remove("Petkan"));
    }
    @Test
    public void testRemove_ShouldReturnTrue(){
        fillHeroes();
        fillRepository();
        assertTrue(heroRepository.remove("Ivan"));
    }
    @Test
    public void testGetCount(){
        fillHeroes();
        fillRepository();
        assertEquals(5,heroRepository.getCount());
        heroRepository.create(new Hero("OneMore",21));
        assertEquals(6,heroRepository.getCount());
        heroRepository.remove("Ivan");
        heroRepository.remove("OneMore");
        assertEquals(4,heroRepository.getCount());
    }
    @Test
    public void testGetHeroWithHighestLevelOrNullIfNoHeroes(){
        assertNull(heroRepository.getHeroWithHighestLevel());
        fillHeroes();
        Hero expectedHero = heroes.stream().max(Comparator.comparing(Hero::getLevel)).get();
        fillRepository();
        Hero actualHero = heroRepository.getHeroWithHighestLevel();
        assertEquals(expectedHero,actualHero);
    }
}
