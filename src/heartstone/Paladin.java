package heartstone;

/**
 * Paladin is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Paladin extends AbstractCard {

  /**
   * Creates a Paladin card, initially the damage counter is 0.
   * 
   * @param name Paladin's name.
   * @param lifePoints Paladin's life points.
   * @param attack Paladin's attack value.
   */
  public Paladin(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByPaladin(double) attackedByPaladin} method to the Card, unless it
   * is dead, in which case the method doesn't perform this action.
   * 
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByPaladin(attack);
  }

  /**
   * increases the damage counter of the Paladin by half of the Knight's attack value.
   * 
   * @param attack Knight's attack attribute.
   */
  @Override
  public void attackedByKnight(double attack) {
    damageCounter += attack / 2;
  }

  /**
   * increases the damage counter of the Paladin by double of the Mage's attack value.
   * 
   * @param attack Mage's attack attribute.
   */
  @Override
  public void attackedByMage(double attack) {
    damageCounter += attack * 2;
  }

}
