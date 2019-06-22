package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hearthstone.*;

public class ShamanTest {

  private Card hunter, shaman;

  @Before
  public void setUp() {
    hunter = new Hunter("Tundra Rhino", 5, 2);
    shaman = new Shaman("Al'Akir the Windlord", 8, 3);
  }

  @Test
  public void testAttack() {
    shaman.attack(hunter);
    assertEquals(1, hunter.getAttack(), 0);
    shaman.kill();
    shaman.attack(hunter);
    assertEquals(1, hunter.getAttack(), 0);
  }

  @Test
  public void testWeakness() {
    hunter.attack(shaman);
    assertEquals(4, shaman.getDamage(), 0);
  }

}
