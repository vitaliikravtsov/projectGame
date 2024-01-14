package project;

public class Logger {
    private static Logger loggerInstance;
    private Logger() {
    }

    public static Logger getLoggerInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void log(String args) {
        System.out.println(args);
    }
}
