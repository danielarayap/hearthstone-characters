package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hearthstone.*;

public class WarlockTest {

  private Card healer, shaman, warlock;

  @Before
  public void setUp() {
    healer = new Healer("Hozen Healer", 4, 2);
    shaman = new Shaman("Al'Akir the Windlord", 8, 3);
    warlock = new Warlock("Lord Jaraxxus", 8, 3);
  }

  @Test
  public void testWarlock() {
    warlock.attack(shaman);
    assertEquals(3, shaman.getDamage(), 0);
    warlock.kill();
    warlock.attack(shaman);
    assertEquals(3, shaman.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    healer.attack(warlock);
    assertEquals(2, warlock.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    shaman.attack(warlock);
    assertEquals(2, warlock.getDamage(), 0);
  }

}
