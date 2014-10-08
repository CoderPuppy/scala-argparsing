package cpup.testing.argparsing.parsing

object Parser {
	def parse(args: Seq[String]) = {
		args.flatMap {
			case NamedArgument.pattern.r(name, value) => List(NamedArgument(name, value))
			case FlagArgument.NotLong.pattern.r(name: String) => List(FlagArgument(name, false))
			case FlagArgument.Long.pattern.r(name: String) => List(FlagArgument(name, true))
			case FlagArgument.Short.pattern.r(flagsStr: String) => {
				flagsStr
					.split("")
					.flatMap {
						case FlagArgument.Short.yesPattern.r(flag) => List(FlagArgument(flag, true))
						case FlagArgument.Short.noPattern.r(flag) => List(FlagArgument(flag.toLowerCase, false))
						case _ => List()
					}
					.toList
			}
			case arg => List(PositionalArgument(arg))
		}.toList
	}
}