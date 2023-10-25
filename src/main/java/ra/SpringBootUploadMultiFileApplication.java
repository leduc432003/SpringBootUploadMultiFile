package ra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ra.model.service.FileStorageService;

@SpringBootApplication
public class SpringBootUploadMultiFileApplication implements CommandLineRunner {
    @Autowired
    private FileStorageService fileStorageService;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadMultiFileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileStorageService.init();
    }
}
