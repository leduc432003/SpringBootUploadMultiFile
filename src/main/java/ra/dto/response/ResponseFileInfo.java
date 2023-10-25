package ra.dto.response;

public class ResponseFileInfo {
    private String fileName;
    private String fileURL;

    public ResponseFileInfo(String fileName, String fileURL) {
        this.fileName = fileName;
        this.fileURL = fileURL;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
}
