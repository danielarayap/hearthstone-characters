package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class HealerTest {

  private Card assassin, healer, paladin;

  @Before
  public void setUp() {
    assassin = new Assassin("Random Assassin", 6, 1);
    healer = new Healer("Hozen Healer", 4, 2);
    paladin = new Paladin("Bolvan, Fireblood", 6, 3);
  }

  @Test
  public void testAttack() {
    healer.attack(assassin);
    assertEquals(0, assassin.getDamage(), 0);
    healer.kill();
    healer.attack(assassin);
    assertEquals(0, assassin.getDamage(), 0);
    assassin.kill();
    new Healer("Hozen Healer", 4, 2).attack(assassin);
    assertEquals(6, assassin.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    assassin.attack(healer);
    assertEquals(2, healer.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    paladin.attack(healer);
    assertEquals(4, healer.getAttack(), 0);
  }

}
