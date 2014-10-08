package cpup.testing.argparsing.interpreting

case class NamedArgument[T](name: String, pos: Boolean = true, optional: Boolean = false, default: T) extends Argument