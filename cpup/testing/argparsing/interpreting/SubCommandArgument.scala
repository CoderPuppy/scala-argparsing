package cpup.testing.argparsing.interpreting

case class SubCommandArgument(default: String = null, subcmds: Seq[Command]) extends Argument