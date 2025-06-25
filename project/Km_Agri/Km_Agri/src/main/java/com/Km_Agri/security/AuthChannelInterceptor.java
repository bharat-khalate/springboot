package com.Km_Agri.security;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;


@Component
public class AuthChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.SEND.equals(accessor.getCommand())) {
            String destination = accessor.getDestination();
            Authentication user = (Authentication) accessor.getUser();

            if ("/app/chat.sendMessage".equals(destination)) {
                if (!user.getAuthorities().stream().anyMatch(auth ->
                        auth.getAuthority().equals("ROLE_USER") ||
                                auth.getAuthority().equals("ROLE_ADMIN") ||
                                auth.getAuthority().equals("ROLE_EXPERT"))) {
                    throw new AccessDeniedException("Forbidden");
                }
            }
        }

        return message;
    }
}
