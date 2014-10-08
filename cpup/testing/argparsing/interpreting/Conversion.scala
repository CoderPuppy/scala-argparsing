package cpup.testing.argparsing.interpreting

trait Conversion[S, T] {
	def convert(src: S): T
}

object Conversion {
	implicit def combineCoversions[S, I, T](a: Conversion[S, I], b: Conversion[I, T]): Conversion[S, T] = new Conversion[S, T] {
		def convert(src: S) = b.convert(a.convert(src))
	}

	implicit val str2str = new Conversion[String, String] {
		override def convert(src: String) = src
	}
}