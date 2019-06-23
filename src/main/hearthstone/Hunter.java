package hearthstone;

/**
 * Hunter is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 *
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Hunter extends AbstractCard {

  /**
   * Creates a Hunter card, initially the damage counter is 0.
   *
   * @param name Hunter's name.
   * @param lifePoints Hunter's life points.
   * @param attack Hunter's attack value.
   */
  public Hunter(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByHunter(double) attackedByHunter} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   *
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByHunter(attack);
    System.out.println("---> " + this.name + " attacks " + card.getName() + " with an attack of " + this.attack + "\n");
  }

  /**
   * Hunter's attack value remains the same, and increases the Assassin's damage counter by half of
   * the Druid's attack value.
   *
   * @param attack Druid's attack attribute.
   */
  @Override
  public void attackedByDruid(double attack) {
    damageCounter += attack / 2;
  }

  /**
   * increases the damage counter of the Hunter by double of the Mage's attack value.
   *
   * @param attack Mage's attack attribute.
   */
  @Override
  public void attackedByMage(double attack) {
    damageCounter += 2 * attack;
  }

}
