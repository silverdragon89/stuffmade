package com.example.terence.pad_plus_egg_calculator;

//Class contains the buildings of a MonsterBase's enhanced stat
//Does not handle errors for adding over MAX_STAT plug eggs

public class MonsterBase implements Comparable<MonsterBase> {
  public static int internalIDCounter = 0;
  private int hitpoint;
  private int attack;
  private int recovery;

  private String name;
  private int id;
  private int internalID;

  public MonsterBase(int id, int hitpoint, int attack, int recovery) {
    this.id = id;
    this.hitpoint = hitpoint;
    this.attack = attack;
    this.recovery = recovery;

    internalID = internalIDCounter++;
  }

  public int getHitpoint() {
    return hitpoint;
  }

  public void setHitpoint(int hitpoint) {
    this.hitpoint = hitpoint;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getRecovery() {
    return recovery;
  }

  public void setRecovery(int recovery) {
    this.recovery = recovery;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getInternalID() {
    return internalID;
  }

  public String getName() {
    // TODO: Perform a lookup with ID to grab name
    return null;
  }

  public int getTotalPlus() {
    return hitpoint + attack + recovery;
  }

  @Override
  public int compareTo(MonsterBase another) {
    return (another.recovery + another.attack + this.hitpoint) - (this.recovery + this.attack + this.hitpoint);
  }
}
