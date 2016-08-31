package com.example.terence.pad_plus_egg_calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//the BankBase class contains a listing of monsters currently in that BankBase
public class BankBase {
  ArrayList<MonsterBase> mainMonsterList = new ArrayList<MonsterBase>();
  ArrayList<MonsterBase> bankMonsterList = new ArrayList<MonsterBase>();

  public void addMonsterToMainMonsterList(MonsterBase monster) {
    mainMonsterList.add(monster);
  }

  public void removeMonsterFromMainMonsterList(MonsterBase monster) {
    mainMonsterList.remove(monster);
  }

  public void addMonsterToBankMonsterList(MonsterBase monster) {
    bankMonsterList.add(monster);
  }

  public void removeMonsterFromBankMonsterList(MonsterBase monster) {
    bankMonsterList.remove(monster);
  }

  public MonsterBase findBestMatch(MonsterBase monster) {
    // Find the best match from the bank
    LinkedList<CombinedMonsterBase> list = new LinkedList<CombinedMonsterBase>();

    return null;
  }

  public CombinedMonsterBase getBestCombinationForMonster(MonsterBase monster) {
    ArrayList<CombinedMonsterBase> list = getAllPossibleCombinationsFromBank();
    ArrayList<CombinedMonsterBase> listOfLegalCombinations = new ArrayList<CombinedMonsterBase>();

    for (int i=0; i<list.size(); i++) {
      if (list.get(i).addMonster(monster)) {
        listOfLegalCombinations.add(list.get(i));
      }
    }

    Collections.sort(listOfLegalCombinations);
    return listOfLegalCombinations.get(listOfLegalCombinations.size()-1);
  }


  public ArrayList<CombinedMonsterBase> getAllPossibleCombinationsFromBank() {
    ArrayList<CombinedMonsterBase> list = new ArrayList<CombinedMonsterBase>();
    for (int i=0; i<bankMonsterList.size(); i++) {
      MonsterBase monsterBase = bankMonsterList.get(i);

      int currentListSize = list.size();
      for (int j=0; j<currentListSize; j++) {
        CombinedMonsterBase temp = new CombinedMonsterBase(list.get(j));
        temp.addMonster(monsterBase);
        list.add(temp);
      }

      CombinedMonsterBase currentMonsterBase = new CombinedMonsterBase();
      currentMonsterBase.addMonster(monsterBase);
      list.add(currentMonsterBase);
    }
    return list;
  }
}

