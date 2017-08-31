package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class AssassinTest {

  private Card assassin, druid, warlock;

  @Before
  public void setUp() {
    assassin = new Assassin("Random Assassin", 6, 1); 
    druid = new Druid("Keeper of the Grove", 3, 2);
    warlock = new Warlock("Lord Jaraxxus", 8, 3); 
  }

  @Test
  public void testName() {
    assertEquals("Random Assassin", assassin.getName());
  }

  @Test
  public void testLife() {
    assertEquals(6, assassin.getLife(), 0);
  }


  @Test
  public void testAttack() {
    assassin.attack(druid); // testing a normal attack by assassin (without special conditions)
    assertEquals(1, druid.getDamage(), 0);
    assassin.kill();
    assassin.attack(druid);
    assertEquals(1, druid.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    druid.attack(assassin);
    assertEquals(2, assassin.getAttack(), 0);
  }

  @Test
  public void testWeakness2() {
    warlock.attack(assassin);
    assertTrue(assassin.isDead());
  }
}
