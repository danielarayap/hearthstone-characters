package hearthstone;

/**
 * Shaman is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 *
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Shaman extends AbstractCard {

  /**
   * Creates a Shaman card, initially the damage counter is 0.
   *
   * @param name Shaman's name.
   * @param lifePoints Shaman's life points.
   * @param attack Shaman's attack value.
   */
  public Shaman(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByShaman(double) attackedByShaman} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   *
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByShaman(attack);
    System.out.println("---> " + this.name + " attacks " + card.getName() + " with an attack of " + this.attack + "\n");
  }

  /**
   * increases the damage counter of the Shaman by double of the Hunter's attack value.
   *
   * @param attack Hunter's attack attribute.
   */
  @Override
  public void attackedByHunter(double attack) {
    damageCounter += attack * 2;
  }

}
