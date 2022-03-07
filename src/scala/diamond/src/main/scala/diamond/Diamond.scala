package diamond

object Diamond {
  private val Start: Char = 'A'

  def print(endCharacter: Char): Option[String] =
    if (isLegalCharacter(endCharacter))
      Some(
        generateDiamond(endCharacter)
          .mkString(System.lineSeparator())
      )
    else None

  private def isLegalCharacter(endCharacter: Char): Boolean = endCharacter.isLetter

  private def generateDiamond(endCharacter: Char): Seq[String] =
    fullDiamond(generateHalfDiamond(endCharacter.toUpper))

  private def fullDiamond(halfDiamond: Seq[String]): Seq[String] =
    halfDiamond.concat(halfDiamond.reverse.drop(1))

  private def generateHalfDiamond(endCharacter: Char): Seq[String] = {
    (Start.toInt to Start + (endCharacter - Start))
      .map(_.toChar)
      .map(toLine(_, endCharacter))
  }

  private def toLine(character: Char, endCharacter: Char): String = {
    val out = outer(character, endCharacter)
    out + character + formatInner(character) + out
  }

  private def outer(character: Char, endCharacter: Char): String =
    generateEmptyCharacters(endCharacter - character)

  private def formatInner(character: Char): String = {
    def inner(character: Char): String = generateEmptyCharacters((character - Start) * 2 - 1)
    if (character != Start) inner(character) + character else ""
  }

  private def generateEmptyCharacters(count: Int): String =
    (0 until count)
      .foldLeft("") { (acc, _) =>
        acc + " "
      }
}
