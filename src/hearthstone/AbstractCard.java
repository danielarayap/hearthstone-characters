package hearthstone;

/**
 * AbstractCard is an object that includes other Card objects. AbstractCard implements methods from
 * Interface Card.
 * 
 * @author Daniel Araya.
 * @since 1.0.
 */
public abstract class AbstractCard implements Card {

  protected double lifePoints;
  protected double attack;
  protected double damageCounter;
  protected String name;

  AbstractCard(String name, double lifePoints, double attack) {
    this.lifePoints = lifePoints;
    damageCounter = 0;
    this.attack = attack;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public double getDamage() {
    return damageCounter;
  }

  public double getLife() {
    return lifePoints;
  }

  public double getAttack() {
    return attack;
  }

  public double getHealth() { return lifePoints - damageCounter; }

  /**
   * @param card Card to attack.
   */
  public abstract void attack(Card card);

  public void attackedByAssassin(double attack) {
    damageCounter += attack;
  }

  public void attackedByDruid(double attack) {
    this.attack += attack;
    damageCounter += attack / 2;
  }

  public void attackedByHealer(double attack) {
    if ((lifePoints - damageCounter) <= 0) {
      return;
    }
    damageCounter = Math.max(damageCounter - attack / 2, 0);
  }

  public void attackedByHunter(double attack) {
    damageCounter += attack;
  }

  public void attackedByKnight(double attack) {
    damageCounter += attack;
  }

  public void attackedByMage(double attack) {
    damageCounter += attack;
  }

  public void attackedByPaladin(double attack) {
    this.attack += attack / 3;
    damageCounter = Math.max(damageCounter - attack / 3, 0);
  }

  public void attackedByShaman(double attack) {
    damageCounter += attack / 3;
    this.attack = Math.max(this.attack - attack / 3, 0);
  }

  public void attackedByWarlock(double attack) {
    damageCounter += attack;
  }

  public boolean isDead() {
    return lifePoints <= damageCounter;
  }

  public void kill() {
    damageCounter = lifePoints;
  }

}
