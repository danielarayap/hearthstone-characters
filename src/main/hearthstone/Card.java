package hearthstone;

/**
 * Card is an interface with the methods that will be implemented in the AbstractCard abstract
 * class.
 *
 * @author Daniel Araya.
 * @since 1.0.
 */
public interface Card {

  /**
   * @return Card's damage counter's value.
   */
  double getDamage();

  /**
   * @return Card's attack.
   */
  double getAttack();

  /**
   * @return Card's life points.
   */
  double getLife();

  /**
   * @return Card's remaining life points.
   */
  double getHealth();

  /**
   * @return Card type and name.
   */
  String getPrettyName();

  /**
   * @return Card's name.
   */
  String getName();

  /**
   * @param card Card to attack.
   */
  void attack(Card card);

  /**
   * increases the damage counter of a Card by the Assassin's attack value.
   *
   * @param attack Assassin's attack attribute.
   */
  void attackedByAssassin(double attack);

  /**
   * increases the damage counter of a Card by half of the Druid's attack value and increases the
   * Card's attack by the Druid's attack value.
   *
   * @param attack Druid's attack attribute.
   */
  void attackedByDruid(double attack);

  /**
   * restores the damage counter of a Card by half of the Healer's attack value, if the Card is
   * dead, this action does not occurs. Damage counter cannot be negative.
   *
   * @param attack Healer's attack attribute.
   */
  void attackedByHealer(double attack);

  /**
   * increases the damage counter of a Card by the Hunter's attack value.
   *
   * @param attack Hunter's attack attribute.
   */
  void attackedByHunter(double attack);

  /**
   * increases the damage counter of a Card by the Knight's attack value.
   *
   * @param attack Knight's attack attribute.
   */
  void attackedByKnight(double attack);

  /**
   * increases the damage counter of a Card by the Mage's attack value.
   *
   * @param attack Mage's attack attribute.
   */
  void attackedByMage(double attack);

  /**
   * restores the damage counter of a Card by a third of the Paladin's attack value and increases
   * the Card's attack by the same third of the Paladin's attack value. Damage counter cannot result
   * to be negative.
   *
   * @param attack Paladin's attack attribute.
   */
  void attackedByPaladin(double attack);

  /**
   * increases the damage counter of a Card by a third of the Shaman's attack value and diminishes
   * the Card's attack by the same third of the Shaman's attack value. Card's attack cannot result
   * to be negative.
   *
   * @param attack Shaman's attack attribute.
   */
  void attackedByShaman(double attack);

  /**
   * increases the damage counter of a Card by the Warlock's attack value.
   *
   * @param attack Warlock's attack attribute.
   */
  void attackedByWarlock(double attack);

  /**
   * checks if the Card has received more damage than its life points, in which case it is dead.
   *
   * @return <code>true</code> if the damage counter is greater than life points. <code>false</code>
   *         otherwise.
   */
  boolean isDead();

  /**
   * Equalizes the damage counter of a Card with its life points. The existence of this method is
   * only to be implemented in the tests and make them more readable .
   *
   * @see AbstractCard#damageCounter
   * @see AbstractCard#lifePoints
   */
  void kill();

}
