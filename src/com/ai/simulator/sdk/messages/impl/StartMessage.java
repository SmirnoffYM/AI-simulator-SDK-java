package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.EmptyMessage;
import com.ai.simulator.sdk.messages.SimulatorMessage;

/**
 * Start message class(type=11)
 *
 * @author Smirnoff Y
 * @see EmptyMessage
 * @see SimulatorMessage
 * @since 9/23/12 6:10 PM
 */
@SimulatorMessage(type = 11)
public final class StartMessage extends EmptyMessage {

    public StartMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }
}
