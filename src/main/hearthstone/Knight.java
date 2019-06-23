package hearthstone;

/**
 * Knight is a type of Card with some specifications in certain methods, also it defines the
 * abstract method {@link AbstractCard#attack(Card) attack} to work for this subclass.
 *
 * @author Daniel Araya.
 * @since 1.0.
 */
public class Knight extends AbstractCard {

  /**
   * Creates a Knight card, initially the damage counter is 0.
   *
   * @param name Knight's name.
   * @param lifePoints Knight's life points.
   * @param attack Knight's attack value.
   */
  public Knight(String name, double lifePoints, double attack) {
    super(name, lifePoints, attack);
  }

  /**
   * applies the {@link #attackedByKnight(double) attackedByKnight} method to the Card, unless it is
   * dead, in which case the method doesn't perform this action.
   *
   * @param card Card to attack.
   */
  @Override
  public void attack(Card card) {
    if (isDead()) {
      return;
    }
    card.attackedByKnight(attack);
    System.out.println("---> " + this.name + " attacks " + card.getName() + " with an attack of " + this.attack + "\n");
  }

  /**
   * increases the damage counter of the Knight by double of the Hunter's attack value.
   *
   * @param attack Hunter's attack attribute.
   */
  @Override
  public void attackedByHunter(double attack) {
    damageCounter += 2 * attack;
  }

  /**
   * increases the damage counter of the Knight by half of the Assassin's attack value.
   *
   * @param attack Assassin's attack attribute.
   */
  @Override
  public void attackedByAssassin(double attack) {
    damageCounter += attack / 2;
  }

}
