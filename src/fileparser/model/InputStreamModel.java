package fileparser.model;

import java.time.LocalDate;

public class InputStreamModel {
    private String file;
    private int width;
    private int height;
    private String format;
    private int fps;
    private LocalDate timestamp;

    public InputStreamModel(String file, int width, int height, String format, int fps, LocalDate timestamp) {
        this.file = file;
        this.width = width;
        this.height = height;
        this.format = format;
        this.fps = fps;
        this.timestamp = timestamp;
    }

    // getter and setter
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    // toString
    @Override
    public String toString() {
        return "InputStreamModel{" +
                "file='" + file + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", format='" + format + '\'' +
                ", fps=" + fps +
                ", timestamp=" + timestamp +
                '}';
    }
}
