package heartstone;

/**
 * Mage is a type of Card with some specifications in certain methods, also it defines the abstract
 * method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Mage extends AbstractCard {

  /**
   * Creates a Mage card, initially the damage counter is 0.
   * 
   * @param name Mage's name.
   * @param lifePoints Mage's life points.
   * @param attack Mage's attack value.
   */
  public Mage(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByMage(double) attackedByMage} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   * 
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByMage(attack);
  }

  /**
   * increases the damage counter of the Mage by double of the Assassin's attack value.
   * 
   * @param attack Assassin's attack attribute.
   */
  @Override
  public void attackedByAssassin(double attack) {
    damageCounter += 2 * attack;
  }

  /**
   * increases the damage counter of the Knight by half of the Warlock's attack value.
   * 
   * @param attack Warlock's attack attribute.
   */
  @Override
  public void attackedByWarlock(double attack) {
    damageCounter += attack / 2;
  }

}
