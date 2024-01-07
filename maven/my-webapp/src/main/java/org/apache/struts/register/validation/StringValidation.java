package org.apache.struts.register.validation;

import java.util.function.BiPredicate;

public class StringValidation {
  public static BiPredicate<String, Integer> shorterThanSize() {
    return (value, size) -> value.length() <= size;
  }
}
