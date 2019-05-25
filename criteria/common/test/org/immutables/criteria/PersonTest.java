package org.immutables.criteria;

import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {

  @Test
  @Ignore("used for compile-time testing only")
  public void collection() {
    PersonCriteria.create()
            .friends.any().nickName.isNotEmpty()
            .aliases.none().startsWith("foo")
            .or()//.or() should not work
            .isMarried.isTrue()
            .or()
            .friends.all().nickName.isNotEmpty()
            .friends.any().nickName.isEmpty()
            .friends.none().nickName.hasSize(3)
            .friends.all(f -> f.nickName.isEmpty().or().nickName.hasSize(2))
            .friends.any(f -> f.nickName.isEmpty().or().nickName.hasSize(2))
            .aliases.contains("test")
            .friends.none(f -> f.nickName.hasSize(3).nickName.startsWith("a"));
  }

}