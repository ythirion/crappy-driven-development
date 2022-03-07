package marine;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@UtilityClass
public class FileUtils {
    @SneakyThrows
    public static String getInputAsString(String input) {
        return Files.readString(Path.of(Objects.requireNonNull(FileUtils.class.getClassLoader().getResource(input)).toURI()));
    }

    @SneakyThrows
    public static String[] getInputAsSeparatedLines(String input) {
        return getInputAsString(input).split("\n");
    }
}
