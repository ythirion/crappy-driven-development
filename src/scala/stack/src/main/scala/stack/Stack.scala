package stack

import java.util.EmptyStackException

class Stack[A] {
  private var internalStack: List[A] = Nil

  def push(element: A): Unit =
    internalStack = element :: internalStack

  def pop(): A = {
    if (internalStack.isEmpty) throw new EmptyStackException

    val lastElement = internalStack.head
    internalStack = internalStack.tail
    lastElement
  }
}
