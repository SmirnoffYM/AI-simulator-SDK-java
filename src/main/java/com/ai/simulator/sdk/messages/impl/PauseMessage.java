package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.EmptyMessage;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.net.DatagramPacket;
import java.net.UnknownHostException;

/**
 * Pause message class (type = 12)
 *
 * @author Smirnoff Y
 * @see EmptyMessage
 * @see SimulatorMessage
 * @since 10/18/12 11:32 AM
 */
@SimulatorMessage(type = 12)
public final class PauseMessage extends EmptyMessage {

    public PauseMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    public DatagramPacket pack() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
