package cpup.testing.argparsing.interpreting

case class Command(name: String, run: (Run) => _) {

}