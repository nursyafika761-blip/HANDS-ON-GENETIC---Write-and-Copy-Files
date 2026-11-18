import java.io.IOException;
import java.nio.file.*;

public class FileCopyNew {

    public static void main(String[] args) {

        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");

        try {

            Files.write(
                source,
                java.util.List.of(
                    "Report Generated",
                    "Status: OK"
                )
            );

            if (Files.notExists(backup.getParent())) {
                Files.createDirectories(backup.getParent());
            }

            if (Files.exists(source)) {
                Files.copy(
                    source,
                    backup,
                    StandardCopyOption.REPLACE_EXISTING
                );
            }

            System.out.println("Backup berhasil dibuat.");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}