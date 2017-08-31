package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import heartstone.*;

public class DruidTest {

  private Card druid, paladin, shaman;

  @Before
  public void setUp() {
    druid = new Druid("Keeper of the Grove", 3, 2);
    paladin = new Paladin("Bolvan, Fireblood", 6, 3);
    shaman = new Shaman("Al'Akir the Windlord", 8, 3); 
  }

  @Test
  public void testAttack() {
    druid.attack(shaman);
    assertEquals(5, shaman.getAttack(), 0);
    druid.kill();
    druid.attack(shaman);
    assertEquals(5, shaman.getAttack(), 0);
  }

  @Test
  public void testWeakness1() {
    shaman.attack(druid);
    assertEquals(0, druid.getAttack(), 0);
  }

  @Test
  public void testWeakness2() {
    paladin.attack(druid);
    assertEquals(4, druid.getAttack(), 0);
  }

}
