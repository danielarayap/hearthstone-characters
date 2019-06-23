package hearthstone;

/**
 * Assassin is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for the Assassin subclass.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Assassin extends AbstractCard {

  /**
   * Creates an Assassin card, initially the damage counter is 0.
   * 
   * @param name Assassin's name
   * @param lifePoints Assassin's life points
   * @param attack Assassin's attack value
   */
  public Assassin(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByAssassin(double) attackedByAssassin} method to the Card, unless
   * it is dead, in which case the method doesn't perform this action.
   * 
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByAssassin(attack);
    System.out.println(this.name + " attacks " + card.getName() + " with an attack of " + this.attack + "\n");
  }

  /**
   * the damage counter of the Assassin remains the same, and increases the Assassin's attack by
   * half of the Druid's attack value.
   * 
   * @param attack Druid's attack attribute.
   */
  @Override
  public void attackedByDruid(double attack) {
    this.attack += attack / 2;
  }

  /**
   * increases the damage counter of the Assassin by double of the Warlock's attack value.
   * 
   * @param attack Warlock's attack attribute.
   */
  @Override
  public void attackedByWarlock(double attack) {
    damageCounter += 2 * attack;
  }

}
