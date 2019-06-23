package hearthstone;

/**
 * Healer is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 *
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Healer extends AbstractCard {

  /**
   * Creates a Healer card, initially the damage counter is 0.
   *
   * @param name Healer's name.
   * @param lifePoints Healer's life points.
   * @param attack Healer's attack value.
   */
  public Healer(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByHealer(double) attackedByHealer} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   *
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByHealer(attack);
    System.out.println("---> " + this.name + " attacks " + card.getName() + " with an attack of " + this.attack + "\n");
  }

  /**
   * increases the damage counter of the Healer by double of the Assassin's attack value.
   *
   * @param attack Assassin's attack attribute.
   */
  @Override
  public void attackedByAssassin(double attack) {
    damageCounter += 2 * attack;
  }

  /**
   * restores the damage counter of the Healer by two thirds of the Paladin's attack value and
   * increases the Healer's attack by the same two thirds of the Paladin's attack value.
   *
   * @param attack Paladin's attack attribute.
   */
  @Override
  public void attackedByPaladin(double attack) {
    this.attack += (2 * attack) / 3;
    damageCounter = Math.max(damageCounter - (2 * attack) / 3, 0);
  }

}
