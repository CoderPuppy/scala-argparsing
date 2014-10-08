package cpup.testing.argparsing.parsing

case class NamedArgument(name: String, value: String) extends Argument

object NamedArgument {
	final val pattern = "^--([^=]+)=([\\s\\S]*)$"
}