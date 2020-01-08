import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class BusinessLicenceStream {
  private final File file;

  public BusinessLicenceStream(String path) {
    this.file = new File(path);
  }

  public Stream<BusinessLicence> getBusinesses() throws IOException {
    return Files.lines(this.file.toPath()).skip(1).map(BusinessLicence::new);
  }
}
