package ra.model.service.ServiceImpl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.model.service.FileStorageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final Path PATH_ROOT = Paths.get("upload");
    @Override
    public void init() {
        try {
            Files.createDirectories(PATH_ROOT);
        } catch (IOException e) {
            throw new RuntimeException("Could not initial folder upload");
        }
    }

    @Override
    public Path uploadFile(MultipartFile multipartFile) {
        try {
            /*PATH_ROOT: C:\Users\admin\Downloads\demo\SpringBoot_UploadMultiFile\\upload
            Path_ROOT.resolve(multipartFile.getOriginalFilename()):C:\Users\admin\Downloads\demo\SpringBoot_UploadMultiFile\\upload\filename.jpg*/
            Files.copy(multipartFile.getInputStream(), PATH_ROOT.resolve(multipartFile.getOriginalFilename()));
            return PATH_ROOT.resolve(multipartFile.getOriginalFilename());
        } catch (Exception e) {
            throw new RuntimeException("Could not store file, Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = PATH_ROOT.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException("Could not read file");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
