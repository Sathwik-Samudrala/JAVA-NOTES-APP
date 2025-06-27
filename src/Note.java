package JavaNotesApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single note with title, content and timestamp.
 * Handles conversion to/from file storage format.
 */
public class Note {
    private String title;
    private String content;
    private String timestamp;
    
    // Timestamp format for display
    private static final DateTimeFormatter TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Constructor for new notes (auto-generates timestamp)
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }

    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getTimestamp() { return timestamp; }

    /**
     * Converts note to storage format (title::timestamp::content)
     * Replaces newlines with \n for single-line storage
     */
    public String toFileString() {
        return title + "::" + timestamp + "::" + content.replace("\n", "\\n");
    }

    /**
     * Creates Note object from file line
     * @param line A line from the notes file in format title::timestamp::content
     * @return Note object or null if invalid format
     */
    public static Note fromFileString(String line) {
        String[] parts = line.split("::", 3); // Split into max 3 parts
        if (parts.length < 3) return null; // Invalid format
        
        Note note = new Note(parts[0], parts[2].replace("\\n", "\n"));
        note.timestamp = parts[1]; // Preserve original timestamp
        return note;
    }
}
