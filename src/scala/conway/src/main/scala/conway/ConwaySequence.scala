package conway

object ConwaySequence {
  def printAt(originalNumber: Int, line: Int): String = {
    var result = s"$originalNumber"
    (1 until line).foreach(_ => result = nextLine(result))
    result
  }

  private def nextLine(line: String): String = {
    val numbers = splitLine(line)
    var count = 0
    var currentNumber: String = numbers.head
    var nextLine = ""

    def resetCurrentNumber(number: String): Unit = {
      count = 1
      currentNumber = number
    }

    numbers
      .foreach(number => {
        if (number == currentNumber) count += 1
        else {
          nextLine += lookAndSay(count, currentNumber)
          resetCurrentNumber(number)
        }
      })

    nextLine += lookAndSay(count, currentNumber)
    cleanResult(nextLine)
  }

  private def cleanResult(result: String) = {
    result.substring(1)
  }

  private def lookAndSay(numberCount: Int, currentNumber: String) =
    s" $numberCount $currentNumber"

  private def splitLine(line: String): Array[String] =
    line.split(' ').map(c => c)
}
