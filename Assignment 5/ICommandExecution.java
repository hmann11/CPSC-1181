public interface ICommandExecution {
  public String runCommand(Command command) throws InvalidCommandException;
}
