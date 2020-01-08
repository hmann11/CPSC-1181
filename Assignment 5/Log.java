public class Log {
  public static final int DEBUG = 0;
  public static final int WARN = 1;
  public static final int ERROR = 2;

  private int logLevel;

  public Log(int logLevel) {
    this.logLevel = logLevel;
  }

  public void debug(String m) {
    if (this.logLevel <= DEBUG) {
      System.out.printf("[DEBUG] %s\n", m);
    }
  }

  public void warn(String m) {
    if (this.logLevel <= WARN) {
      System.out.printf("[WARN] %s\n", m);
    }
  }

  public void error(String m) {
    if (this.logLevel <= ERROR) {
      System.out.printf("[ERROR] %s\n", m);
    }
  }
}
