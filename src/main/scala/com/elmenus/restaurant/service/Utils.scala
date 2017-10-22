package com.elmenus.restaurant.service

/**
  * @author Riham Fayez
  * @since  21/10/17.
  */
object Utils {


  /**
    * @param n integer param to get factorial for
    * @return factorial of the specified parameter https://en.wikipedia.org/wiki/Factorial) of an integer
    */
  def factorial(n: Int): Int = {
    if (n == 0 || n==1)
      return 1
    else
      return n * factorial(n-1)
  }

  /**
    * A palindrome is a word or sequence of characters which reads the same backward or forward.
    * For example the words: `level, anna, noon, rotator` are all palindromes.
    * Implement the Scala function `isPalindrome` that accepts a string as an argument and returns a boolean indicating
    * whether the input is a palindrome or not.
    * Test your implementation with the following words: `madam mom radar refer wow`
    * Example:
    * palindrome("anna")   // returns true
    * palindrome("apple")  // returns false
    *
    * @param s string to check if it is Palindrome
    * @return flag to indicate passed string is Palindrome or not
    */
  def isPalindrome(s: String): Boolean = {

    ( if(s==null)  true else (for (x <- 0 to s.length/2) yield (s(x) == s(s.length - x - 1)))
      .reduceLeft((acc,n)=> acc && n))
  }

  /**
    *  Given a string containing characters (a-z), implement the Scala function `runLengthEncode` that compresses
    *  repeated runs of the same character by storing the length of that run, and provide another
    *
    *  Example:
    *  runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx") // returns "a10b3a1x4y3z1y1x1"
    *
    * @param s string to get length encode
    * @return encoded string
    */
  def runLengthEncode(s: String): String = (1 until s.size).foldLeft((1, s(0), new StringBuilder)) {
    case ((len, c, sb), index) if c != s(index) =>  sb.append(c);sb.append(len); (1, s(index), sb)
    case ((len, c, sb), _) => (len + 1, c, sb)
  } match {
    case (len, c, sb) =>  sb.append(c);sb.append(len); sb.toString
  }

  /**
    * Scala function `runLengthDecode` to reverse the compression. The output can be anything,
    *  as long as you can recreate the input with it.
    *  Example:
    *  runLengthDecode("a10b3a1x4y3z1y1x1")        // returns "aaaaaaaaaabbbaxxxxyyyzyx"
    *
    * @param s string to get length decode
    * @return decoded string
    */
  def runLengthDecode(s: String): String = {
    val sb = new StringBuilder
    val Code = """([\w])(\d+)""".r
    for (Code( c,len) <- Code findAllIn s) sb.append(c * len.toInt)
    sb.toString
  }
  /**
    * Increment 1 to the passed param
    * @param n int to increase by 1
    * @return passed parameter incremented by 1
    */
  def increment(n: Int): Int =n+1


  /**
    * Get Square of the passed parameter
    * @param x param to get square value for
    * @return square of passed parameter
    */
  def square(x: Int): Int = x * x


  /**
    * Let `f` and `g` be two one-argument functions. The composition `f` and `g` is defined to be the function
    *`x => f(g(x))`. Define a function `compose` that implements composition.
    * For example, if `inc` is a function that adds 1 to its argument, and `square` is a function that
    * squares its argument, then:
    * val h = compose(square, inc)  // create a new function h by composing inc and square
    * h(6)                          // returns 49
    * @param f function 1
    * @param g function 2
    */
  def compose(f: (Int) => Int ,g: (Int)=> Int): (Int) => Int = (x:Int )=>
    // invoke the function we were given, giving it an Int parameter
    f(g(x))



}
