public interface ICommandParser {
  public Command parse(String line) throws InvalidCommandException;
}
