package heartstone;

/**
 * Warlock is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Warlock extends AbstractCard {

  /**
   * Creates a Warlock card, initially the damage counter is 0.
   * 
   * @param name Warlock's name.
   * @param lifePoints Warlock's life points.
   * @param attack Warlock's attack value.
   */
  public Warlock(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByWarlock(double) attackedByWarlock} method to the Card, unless it
   * is dead, in which case the method doesn't perform this action.
   * 
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByWarlock(attack);
  }

  /**
   * increases the damage counter of the Warlock by the Healer's complete attack value, instead of
   * restoring it.
   * 
   * @param attack Healer's attack attribute.
   */
  @Override
  public void attackedByHealer(double attack) {
    damageCounter += attack;
  }

  /**
   * increases the damage counter of the Warlock by two thirds of the Shaman's attack value and
   * diminishes the Warlock's attack by the same two thirds of the Shaman's attack value.
   * 
   * @param attack Shaman's attack attribute.
   */
  @Override
  public void attackedByShaman(double attack) {
    damageCounter += (attack * 2) / 3;
    this.attack = Math.max(this.attack - (2 * attack) / 3, 0);
  }

}
