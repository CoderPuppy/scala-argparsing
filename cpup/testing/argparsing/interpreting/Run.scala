package cpup.testing.argparsing.interpreting

import cpup.testing.argparsing.interpreting.Argument.InvalidArgumentException
import cpup.testing.argparsing.interpreting.Run.CancelRunException

trait Run {
	def flag(name: String, short: String = null, default: Boolean = false) = {
		default
	}

	def apply[T](name: String, pos: Boolean = true, optional: Boolean = false, default: T = null.asInstanceOf[T])(implicit conversion: Conversion[String, T]) = {
		default
	}

	def shouldRun: Boolean
	def run[R](fn: => R)
	def run(subcmds: Command*) { run(null, subcmds: _*) }

	def run(default: String, subcmds: Command*) {
		if(!shouldRun)
			throw new CancelRunException

		val cmd = this("subcommand", optional = false)(new Conversion[String, Command] {
			override def convert(name: String) = subcmds.find(_.name == name) match {
				case Some(cmd) => cmd
				case None =>
					if(default == null)
						throw new InvalidArgumentException("cmd must be one of " + subcmds.map(_.name).mkString(", "))
					else
						subcmds.find(_.name == name).get
			}
		})
		run({
			runSubCommand(cmd)
		})
	}

	def runSubCommand(cmd: Command)
}

object Run {
	class CancelRunException(msg: String = "Cancel run") extends RuntimeException(msg)
}