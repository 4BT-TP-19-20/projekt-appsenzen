import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Logs String message to console with date and time 

public class Logger {

    private DateTimeFormatter dateTime;
    private LocalDateTime now;
    private String localLog;

    public Logger() {
        dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    }

    public String logToConsole(String toLog){
        now = LocalDateTime.now();
	String logString = dateTime.format(now) + " : " + toLog;
        System.out.println(logString);
	return logString;
    }
}
