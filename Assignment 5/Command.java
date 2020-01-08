public class Command {
  private final String rest;
  private String command;

  public Command(String command, String rest) {
    this.command = command;
    this.rest = rest;
  }

  public String getRest() {
    return rest;
  }

  public String getCommand() {
    return command;
  }
}