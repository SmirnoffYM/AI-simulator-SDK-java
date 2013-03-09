package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.AppException;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.impl.MoveMessage;
import com.ai.simulator.sdk.util.Constants;
import com.ai.simulator.sdk.util.ModellingState;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Network manager of the application. Receives messages and puts it into {@code received} queue.
 * Sends messages, that are int {@code outgoing queue}
 *
 * @author Smirnoff Y
 * @see SynchronousQueue
 * @see DatagramSocket
 * @see Message
 * @see DatagramPacket
 * @since 11/6/12 9:08 PM
 */
public class NetworkManager {

    private static final int packetSize = 4096;                     // Maximum size of the packet
    private final DatagramSocket socket;
    private Queue<Message> received = new LinkedBlockingQueue<>();

    /**
     * Constructor
     *
     * @param port port that will be listening
     * @throws SocketException
     */
    public NetworkManager(final int port) throws SocketException {
        socket = new DatagramSocket(port);
    }


    /**
     * Start receiver thread
     */
    public void start() {
        receiver.start();
    }

    public Message getReceived() {
        return received.poll();
    }

    /**
     * Send message to simulator
     *
     * @param message message object
     */
    // TODO: test sending!
    public void send(final Message message) {
        try {
            socket.send(message.pack());
        } catch (IOException e) {
            e.printStackTrace();            // debug mode on!
        }
    }

    /**
     * Convert received packet into {@code Message} and put it into corresponding queue
     *
     * @param packet datagram packet
     * @return false if packet cannot be converted into {@code Message}
     */
    private boolean putReceived(DatagramPacket packet) {
        try {
            Message message = Message.unpack(packet);
            System.out.println(message);
            received.add(message);
            return true;
        } catch (AppException | IllegalAccessException | NoSuchMethodException | InvocationTargetException
                | InstantiationException e) {
            e.printStackTrace();                    // debug mode on!
            return false;
        }
    }

    private Thread receiver = new Thread() {

        @Override
        public void run() {
            try {
                //TODO: use frequency?
                while (HubModule.getModellingState() != ModellingState.Stopped) {
                    synchronized (socket) {
                        DatagramPacket packet = new DatagramPacket(new byte[packetSize], packetSize);
                        socket.receive(packet);
                        if (!putReceived(packet))
                            System.out.println("Cannot perform transforming of the received packet.");
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();           // debug mode on!
                System.exit(-1);
            }
        }
    };
}
