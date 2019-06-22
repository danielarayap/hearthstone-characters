package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hearthstone.*;

public class KnightTest {

  private Card assassin, hunter, knight;

  @Before
  public void setUp() {
    assassin = new Assassin("Random Assassin", 6, 1);
    hunter = new Hunter("Tundra Rhino", 5, 2);
    knight = new Knight("Deadscale Knight", 1, 1);
  }

  @Test
  public void testAttack() { 
    knight.attack(hunter);
    assertEquals(1, hunter.getDamage(), 0);
    knight.kill();
    knight.attack(hunter);
    assertEquals(1, hunter.getDamage(), 0);
  }

  @Test
  public void testWeakness1() {
    hunter.attack(knight);
    assertEquals(4, knight.getDamage(), 0);
  }

  @Test
  public void testWeakness2() {
    assassin.attack(knight);
    assertEquals(0.5, knight.getDamage(), 0);
  }

}
