package com.ai.simulator.sdk.messages;

import com.ai.simulator.sdk.AppException;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

/**
 * This class contains set of all message classes. Message class is defined by extending Message
 * and annotating with SimulatorMessage. Also all message classes must be located in {@code messagesPackage} package.
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @see Reflections
 * @since 10/16/12 12:55 PM
 */
public class MessagesContainer {

    private static Set<Class<?>> messages;
    protected static final String messagesPackage = "com/ai/simulator/sdk/messages/impl";

    static {
        try {
            ConfigurationBuilder configuration = new ConfigurationBuilder();
            Enumeration<URL> urlEnumeration = ClassLoader.getSystemClassLoader().getResources(messagesPackage);
            List<URL> urls = new ArrayList<>();
            while (urlEnumeration.hasMoreElements())
                urls.add(urlEnumeration.nextElement());
            configuration.setUrls(urls);
            messages = new Reflections(configuration).getTypesAnnotatedWith(SimulatorMessage.class);
        } catch (IOException e) {
            System.out.println("Cannot find message classes...");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Message> Class<T> getMessage(int type) throws AppException {
        for (Class<?> message : messages)
            if (message.getAnnotation(SimulatorMessage.class).type() == type
                    && isClassInheritedFrom(message, Message.class))
                return (Class<T>) message;
        throw new AppException("No message classes with that type");
    }

    private static boolean isClassInheritedFrom(Class clazz, Class superClass) {
        return clazz.getSuperclass().equals(superClass)
                || !clazz.getSuperclass().equals(Object.class)
                && isClassInheritedFrom(clazz.getSuperclass(), superClass);
    }

    protected MessagesContainer() {
    }
}
