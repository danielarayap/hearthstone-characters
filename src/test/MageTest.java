package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class MageTest { 

  private Card assassin, mage, warlock;

  @Before
  public void setUp() {
    assassin = new Assassin("Random Assassin", 6, 1);
    mage = new Mage("Water Elemental", 4, 3);
    warlock = new Warlock("Lord Jaraxxus", 8, 3);
  }

  @Test
  public void testAttack() {
    mage.attack(warlock);
    assertEquals(3, warlock.getDamage(), 0);
    mage.kill();
    mage.attack(warlock);
    assertEquals(3, warlock.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    assassin.attack(mage);
    assertEquals(2, mage.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    warlock.attack(mage);
    assertEquals(1.5, mage.getDamage(), 0);
  }

}
