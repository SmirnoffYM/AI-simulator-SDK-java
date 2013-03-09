package com.ai.simulator.sdk.messages;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is used 4 setting type of the simulator message. All message classes must be annotated with it.
 *
 * @author Smirnoff Y
 * @since 10/12/12 11:24 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatorMessage {

    public int type();
}
