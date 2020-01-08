import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandParser implements ICommandParser {
  private String restOfTheLine(Scanner lineScanner) {
    return lineScanner.hasNextLine() ? lineScanner.nextLine() : "";
  }

  public Command parse(String line) throws InvalidCommandException {
    Scanner in = new Scanner(line);

    try {
      switch (in.next().trim()) {
        case "create":
          return new Command("create", this.restOfTheLine(in));
        case "complete":
          return new Command("complete", this.restOfTheLine(in));
        case "list":
          return new Command("list", this.restOfTheLine(in));
        case "time":
          return new Command("time", this.restOfTheLine(in));
        case "exit":
          return new Command("exit", this.restOfTheLine(in));
        case "save":
        	return new Command("save",this.restOfTheLine(in));
        case "load":
        	return new Command("load",this.restOfTheLine(in));
        default:
          throw new InvalidCommandException("Invalid root command");
      }
    } catch (NoSuchElementException e) {
      throw new InvalidCommandException("Cannot find root command");
    }

  }
}
