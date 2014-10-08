package cpup.testing.argparsing.interpreting

trait Argument

object Argument {
	class InvalidArgumentException(msg: String) extends RuntimeException(msg)
}