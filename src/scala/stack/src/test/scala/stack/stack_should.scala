package stack

import org.scalatest.funsuite.AnyFunSuite
import java.util.EmptyStackException

class stack_should extends AnyFunSuite {
  val object1 = new Object()
  val object2 = new Object()

  val stack = new Stack[Object]()

  test("raise an exception when popped an empty stack") {
    assertThrows[EmptyStackException](stack.pop())
  }

  test("pop the last object pushed") {
    stack.push(object1)
    assert(object1 == stack.pop())
  }

  test("pop objects in the reverse order they were pushed") {
    stack.push(object1)
    stack.push(object2)

    assert(object2 == stack.pop())
    assert(object1 == stack.pop())
  }
}
