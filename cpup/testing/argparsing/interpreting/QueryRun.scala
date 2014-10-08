package cpup.testing.argparsing.interpreting

import cpup.testing.argparsing.interpreting.Run.CancelRunException

class QueryRun extends Run {
	private var _args = List[Argument]()
	def args = _args

	override def shouldRun = false

	override def run(default: String, subcmds: Command*) {
		_args ++= List(SubCommandArgument(default, subcmds))
		throw new CancelRunException
	}
	override def runSubCommand(cmd: Command) { throw new CancelRunException }

	override def run[R](fn: => R) {
		throw new CancelRunException
	}

	override def flag(name: String, short: String, default: Boolean) = {
		_args ++= List(FlagArgument(name, short, default))
		super.flag(name, short, default)
	}

	override def apply[T](name: String, pos: Boolean, optional: Boolean, default: T)(implicit conversion: Conversion[String, T]) = {
		_args ++= List(NamedArgument[T](name, pos, optional, default))
		super.apply(name, pos, optional, default)
	}
}