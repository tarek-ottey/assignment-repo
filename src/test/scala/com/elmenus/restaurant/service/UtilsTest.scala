package com.elmenus.restaurant.service

import org.scalatest.FunSuite

/**
  * @author Riham Fayez
  * @since  21/10/17.
  */
class UtilsTest extends FunSuite  {

  test("factorial") {
    assert(Utils.factorial(5) == 120)
    assert(Utils.factorial(0) == 1)
    assert(Utils.factorial(1) == 1)
  }


  test("isPalindrome") {
    assert(Utils.isPalindrome(null) == true)
    assert(Utils.isPalindrome("a") == true)
    assert(Utils.isPalindrome("anna") == true)
    assert(Utils.isPalindrome("apple") == false)
    assert(Utils.isPalindrome("madam") == true)
    assert(Utils.isPalindrome("mom") == true)
    assert(Utils.isPalindrome("radar") == true)
    assert(Utils.isPalindrome("refer") == true)
    assert(Utils.isPalindrome("wow") == true)
  }


  test("runLengthEncode") {
    assert(Utils.runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx").equals("a10b3a1x4y3z1y1x1"))
  }

  test("runLengthDecode") {
    assert(Utils.runLengthDecode("a10b3a1x4y3z1y1x1").equals("aaaaaaaaaabbbaxxxxyyyzyx"))
  }


  test("compose") {
    val h=Utils.compose(Utils.square,Utils.increment);
    assert(h(6)==49)
  }

}
