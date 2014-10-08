package cpup.testing.argparsing.interpreting

import cpup.testing.argparsing.parsing

case class RealRun(args: Seq[parsing.Argument]) extends Run {
	override def shouldRun = true

	override def run[R](fn: => R) { fn }
	override def runSubCommand(cmd: Command) {
		println(cmd)
	}

	override def apply[T](name: String, pos: Boolean, optional: Boolean, default: T)(implicit conversion: Conversion[String, T]) = super.apply(name, pos, optional, default)

	override def flag(name: String, short: String, default: Boolean) = super.flag(name, short, default)
}