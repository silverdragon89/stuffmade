package com.example.terence.pad_plus_egg_calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BaseUnitTest {


  @Before
  public void setup() {

  }

  @Test
  public void testGettingHighestPlusMonsterWithOneMonster() throws Exception {

    MonsterBase monsterOne = new MonsterBase(0, 1, 3, 4);

    BankBase bankBase = new BankBase();
    bankBase.addMonsterToBankMonsterList(monsterOne);

    MonsterBase monsterPrimary = new MonsterBase(4, 65, 93, 13);
    CombinedMonsterBase bestCombinationForMonster = bankBase.getBestCombinationForMonster(monsterPrimary);
    LinkedList<MonsterBase> list = bestCombinationForMonster.getList();

    assertTrue(list.contains(monsterOne));
    assertEquals(2, list.size());
  }

  @Test
  public void testGettingHighestPlusMonsterWithFourMonsters() throws Exception {
    MonsterBase monsterOne = new MonsterBase(0, 1, 3, 4);
    MonsterBase monsterTwo = new MonsterBase(1, 1, 3, 5);
    MonsterBase monsterThree = new MonsterBase(2, 1, 2, 1);
    MonsterBase monsterFour = new MonsterBase(3, 1, 5, 4);
    BankBase bankBase = new BankBase();
    bankBase.addMonsterToBankMonsterList(monsterOne);
    bankBase.addMonsterToBankMonsterList(monsterTwo);
    bankBase.addMonsterToBankMonsterList(monsterThree);
    bankBase.addMonsterToBankMonsterList(monsterFour);

    MonsterBase monsterPrimary = new MonsterBase(4, 98, 94, 95);
    CombinedMonsterBase bestCombinationForMonster = bankBase.getBestCombinationForMonster(monsterPrimary);
    LinkedList<MonsterBase> list = bestCombinationForMonster.getList();

    assertTrue(list.contains(monsterFour));
    assertEquals(2, list.size());
  }

  @Test
  public void testGettingHighestPlusMonsterWithThreeCombinedMonsters() throws Exception {
    MonsterBase monsterOne = new MonsterBase(0, 1, 1, 1);
    MonsterBase monsterTwo = new MonsterBase(1, 1, 1, 1);
    MonsterBase monsterThree = new MonsterBase(2, 1, 1, 1);
    MonsterBase monsterFour = new MonsterBase(3, 1, 5, 1);
    BankBase bankBase = new BankBase();
    bankBase.addMonsterToBankMonsterList(monsterOne);
    bankBase.addMonsterToBankMonsterList(monsterTwo);
    bankBase.addMonsterToBankMonsterList(monsterThree);
    bankBase.addMonsterToBankMonsterList(monsterFour);

    MonsterBase monsterPrimary = new MonsterBase(4, 95, 95, 95);
    CombinedMonsterBase bestCombinationForMonster = bankBase.getBestCombinationForMonster(monsterPrimary);
    LinkedList<MonsterBase> list = bestCombinationForMonster.getList();

    assertTrue(list.contains(monsterOne));
    assertTrue(list.contains(monsterTwo));
    assertTrue(list.contains(monsterThree));
    assertEquals(4, list.size());
  }
}

