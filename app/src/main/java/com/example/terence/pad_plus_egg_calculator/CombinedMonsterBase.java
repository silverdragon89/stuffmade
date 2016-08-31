package com.example.terence.pad_plus_egg_calculator;

import java.util.LinkedList;

public class CombinedMonsterBase implements Comparable<CombinedMonsterBase> {
  public static int MAX_RECOVERY = 99;
  public static int MAX_ATTACK = 99;
  public static int MAX_HITPOINT = 99;

  private int totalPlusEgg;
  private int totalRecovery;
  private int totalAttack;
  private int totalHitpoint;

  private LinkedList<MonsterBase> list;

  public CombinedMonsterBase() {
    list = new LinkedList<MonsterBase>();
    totalPlusEgg = 0;
    totalRecovery = 0;
    totalHitpoint = 0;
    totalAttack = 0;
  }

  public CombinedMonsterBase(CombinedMonsterBase another) {
    list = new LinkedList<MonsterBase>();
    list.addAll(another.list);
    totalPlusEgg = another.totalPlusEgg;
    totalRecovery = another.totalRecovery;
    totalHitpoint = another.totalHitpoint;
    totalAttack = another.totalAttack;
  }

  public boolean addMonster(MonsterBase monster) {
    if ((totalRecovery + monster.getRecovery() > MAX_RECOVERY) ||
            totalAttack + monster.getAttack() > MAX_ATTACK ||
            totalHitpoint + monster.getHitpoint() > MAX_HITPOINT) {
      return false;
    }

    totalRecovery += monster.getRecovery();
    totalHitpoint += monster.getHitpoint();
    totalAttack += monster.getAttack();
    totalPlusEgg += monster.getTotalPlus();

    list.add(monster);
    return true;
  }

  public int getTotalPlusEgg() {
    return totalPlusEgg;
  }

  public LinkedList<MonsterBase> getList() {
    return list;
  }

  @Override
  public int compareTo(CombinedMonsterBase another) {
    return totalPlusEgg - another.totalPlusEgg;
  }
}
