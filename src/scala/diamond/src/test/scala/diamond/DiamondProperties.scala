package diamond

import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Prop.forAll
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.Checkers

class DiamondProperties extends AnyFlatSpec with Checkers with OptionValues {
  behavior of "Diamond"

  private val notALetterGenerator  = Arbitrary.arbitrary[Char] suchThat (!_.isLetter)
  private val upperLetterGenerator = Gen.choose('A', 'Z')

  "diamond" should "return a None for an invalid character" in {
    check(forAll(notALetterGenerator) { endCharacter: Char =>
      Diamond.print(endCharacter).isEmpty
    })
  }

  "diamond" should "be horizontally symmetric" in {
    check(forAll(upperLetterGenerator) { endCharacter: Char =>
      checkProperty(endCharacter, diamond => diamond == diamond.reverse)
    })
  }

  "diamond" should "be a square" in {
    check(forAll(upperLetterGenerator) { endCharacter: Char =>
      checkProperty(endCharacter, diamond => diamond.forall(line => line.length == diamond.length))
    })
  }

  "each line" should "contain 2 letters except first and last" in {
    check(forAll(upperLetterGenerator) { endCharacter: Char =>
      checkProperty(
        endCharacter,
        diamond =>
          diamond
            .drop(1)
            .dropRight(1)
            .map(_.filter(c => c != ' '))
            .map(_.length)
            .forall(_ == 2)
      )
    })
  }

  "diamond" should "have a decreasing number of lefts spaces until input char" in {
    check(forAll(upperLetterGenerator) { endCharacter: Char =>
      checkProperty(
        endCharacter,
        diamond => {
          val linesUntilInputChar = takeUntil(diamond, endCharacter)
          val spaces              = countSpacesBeforeFirstLetter(linesUntilInputChar)
          spaces == linesUntilInputChar.indices.reverse
        }
      )
    })
  }

  "diamond" should "have a decreasing number of right spaces until input char" in {
    check(forAll(upperLetterGenerator) { endCharacter: Char =>
      checkProperty(
        endCharacter,
        diamond => {
          val linesUntilInputChar = takeUntil(diamond, endCharacter)
          val spaces              = countSpacesAfterLastLetter(linesUntilInputChar)
          spaces == linesUntilInputChar.indices.reverse
        }
      )
    })
  }

  private def checkProperty(endCharacter: Char, property: Seq[String] => Boolean): Boolean = {
    property(
      Diamond
        .print(endCharacter)
        .value
        .split(System.lineSeparator())
    )
  }

  private def takeUntil(lines: Seq[String], c: Char): Seq[String] = lines.take(c - 'A' + 1)

  private def countSpacesBeforeFirstLetter(lines: Seq[String]): Seq[Int] =
    lines
      .map(_.takeWhile(c => c == ' '))
      .map(_.length)

  private def countSpacesAfterLastLetter(lines: Seq[String]): Seq[Int] =
    lines
      .map(_.reverse.takeWhile(c => c == ' '))
      .map(_.length)
}
