package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.chain;

import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.Logger;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.impl.DebugLogger;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.impl.ErrorLogger;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.impl.InfoLogger;
import lombok.Getter;

@Getter
public class LoggerChain {
    private final Logger loggerChain;

    public LoggerChain() {
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();

        debugLogger.setNext(infoLogger);
        infoLogger.setNext(errorLogger);

        this.loggerChain = debugLogger; // Start of the chain
    }
}
