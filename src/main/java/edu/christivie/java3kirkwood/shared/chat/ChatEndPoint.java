package edu.christivie.java3kirkwood.shared.chat;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(
        value="/chat/endpoint",
        encoders={MessageEncoder.class},
        decoders={MessageDecoder.class}
)
public class ChatEndPoint {
    private static final Set<Session> subscribers = Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void onOpen(Session session){
        subscribers.add(session);
        System.out.println("There are " + subscribers.size() + "subscribers");

    }
    @OnClose
    public void onClose(Session session){
        subscribers.add(session);
        System.out.println("There are " + subscribers.size() + "subscribers");
    }
    @OnMessage
    public void onMessage(Message message, Session session) throws EncodeException, IOException {
        for(Session subscriber : subscribers){
            if(!subscriber.equals(session)){
                subscriber.getBasicRemote().sendObject(message);
            }
        }
    }
    @OnError
    public void onError(Throwable throwable){

    }
}
