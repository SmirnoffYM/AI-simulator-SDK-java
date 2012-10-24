package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.EmptyMessage;
import com.ai.simulator.sdk.messages.SimulatorMessage;

/**
 * Hit! message class (type = 6)
 *
 * @author Smirnoff Y
 * @see EmptyMessage
 * @see SimulatorMessage
 * @since 10/17/12 11:01 AM
 */
@SimulatorMessage(type = 6)
public final class HitMessage extends EmptyMessage {

    public HitMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }
}
