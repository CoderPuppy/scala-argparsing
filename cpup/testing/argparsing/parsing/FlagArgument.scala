package cpup.testing.argparsing.parsing

case class FlagArgument(name: String, value: Boolean) extends Argument

object FlagArgument {
	object NotLong {
		final val pattern = "^--(?:no|not)([\\w\\W]+)$"
	}

	object Long {
		final val pattern = "^--([\\w\\W]+)$"
	}

	object Short {
		final val pattern = "^-([a-zA-Z]+)"
		final val yesPattern = "([a-z])"
		final val noPattern = "([A-Z])"
	}
}