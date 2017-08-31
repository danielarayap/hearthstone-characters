package heartstone;

/**
 * Druid is a type of Card with some specifications in certain methods, also it defines the abstract
 * method {@link AbstractCard#attack(Card) attack} to work for the Druid subclass.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Druid extends AbstractCard {

  /**
   * Creates a Druid card, initially the damage counter is 0.
   * 
   * @param name Druid's name.
   * @param lifePoints Druid's life points.
   * @param attack Druid's attack value.
   */
  public Druid(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByDruid(double) attackedByDruid} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   * 
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByDruid(attack);
  }

  /**
   * increases the damage counter of the Druid by two thirds of the Shaman's attack value and
   * diminishes the Druid's attack by the same two thirds of the Shaman's attack value.
   * 
   * @param attack Shaman's attack attribute.
   */
  @Override
  public void attackedByShaman(double attack) {
    damageCounter += (2 * attack) / 3;
    this.attack = Math.max(this.attack - (2 * attack) / 3, 0);
  }

  /**
   * restores the damage counter of the Druid by two thirds of the Paladin's attack value and
   * increases the Druid's attack by the same two thirds of the Paladin's attack value.
   * 
   * @param attack Paladin's attack attribute.
   */
  @Override
  public void attackedByPaladin(double attack) {
    this.attack += (2 * attack) / 3;
    damageCounter = Math.max(damageCounter - (2 * attack) / 3, 0);
  }

}
