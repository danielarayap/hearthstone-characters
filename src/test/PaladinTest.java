package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class PaladinTest {

  private Card knight, mage, paladin;

  @Before
  public void setUp() {
    knight = new Knight("Deadscale Knight", 1, 1);
    mage = new Mage("Water Elemental", 4, 3);
    paladin = new Paladin("Bolvan, Fireblood", 6, 3);
  }

  @Test
  public void testPaladin() {
    paladin.attack(knight);
    assertEquals(2, knight.getAttack(), 0);
    paladin.kill();
    paladin.attack(knight);
    assertEquals(2, knight.getAttack(), 0);
  }

  @Test
  public void testWeakness1() {
    knight.attack(paladin);
    assertEquals(0.5, paladin.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    mage.attack(paladin);
    assertEquals(6, paladin.getDamage(), 0);
  }

}
