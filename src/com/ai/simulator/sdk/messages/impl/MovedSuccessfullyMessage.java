package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.EmptyMessage;
import com.ai.simulator.sdk.messages.SimulatorMessage;

/**
 * Moved successfully message class (type = 7)
 *
 * @author Smirnoff Y
 * @see SimulatorMessage
 * @see EmptyMessage
 * @since 10/17/12 11:03 AM
 */
@SimulatorMessage(type = 7)
public final class MovedSuccessfullyMessage extends EmptyMessage {

    public MovedSuccessfullyMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }
}
