package com.personio.automation.ui;

public class AutomationError extends AssertionError {
    public AutomationError() {
        super();
    }

    /**
     * constructs an assertion error with an error message
     * the object will be converted to the string
     * if the object is an instance of throwable it becomes the cause of the assertion error
     * @param errorMessage
     */
    public AutomationError(Object errorMessage) {
        super(errorMessage);
    }
}
