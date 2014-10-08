package cpup.testing.argparsing

import cpup.testing.argparsing.interpreting.{Run, Command, Argument}
import cpup.testing.argparsing.parsing.Parser

object StartTest {
	def main(args: Array[String]) {
		println(Parser.parse(args))

		Command("test", (args: Run) => {
			val newline = args.flag("newline", short = "n", default = true)
			val msg = args[String]("msg")

			args.run({
				if(newline)
					println(msg)
				else
					print(msg)
			})
		})
	}
}