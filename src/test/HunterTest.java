package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class HunterTest { 

  private Card druid, hunter, mage;

  @Before
  public void setUp() {
    druid = new Druid("Keeper of the Grove", 3, 2);
    hunter = new Hunter("Tundra Rhino", 5, 2);
    mage = new Mage("Water Elemental", 4, 3);
  }

  @Test
  public void testHunter() {
    hunter.attack(mage);
    assertEquals(2, mage.getDamage(), 0);
    hunter.kill();
    hunter.attack(mage);
    assertEquals(2, mage.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    druid.attack(hunter);
    assertEquals(1, hunter.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    mage.attack(hunter);
    assertEquals(6, hunter.getDamage(), 0);
  }

}
