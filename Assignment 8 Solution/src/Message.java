public class Message {
  private final String who;
  private final String message;

  public Message(String who, String message) {
    this.who = who;
    this.message = message;
  }

  public String getWho() {
    return who;
  }

  public String getMessage() {
    return message;
  }

  public String toString() {
    return this.who + " -> " + this.message;
  }
}
