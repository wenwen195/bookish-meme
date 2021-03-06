package server;

import io.netty.channel.embedded.EmbeddedMessageChannel;
import message.ChatContent;
import message.LoginContent;
import message.Message;
import message.MessageStatus;
import org.junit.Before;
import org.junit.Test;
import protocol.MessageType;

import static org.junit.Assert.*;

/**
 * Created by huanganna on 16/3/27.
 */
public class AuthorityHandlerTest {

    private EmbeddedMessageChannel channel;

    @Before
    public void setUp() throws Exception {

        channel = new EmbeddedMessageChannel(new AuthorityHandler());

    }


    //authority消息，且authority通过
    @Test
    public void authoritySucceedTest() {
        LoginContent loginContent = new LoginContent("100","123456");
        Message authoritySucceedMessage = new Message(loginContent, MessageStatus.NEEDHANDLED, MessageType.AUTHORITY);
        channel.writeInbound(authoritySucceedMessage);

        Message message = (Message)channel.readInbound();
        assertEquals(MessageStatus.NEEDHANDLED,message.getMessageStatus());
        assertEquals(MessageType.AUTHORITY,message.getType());

        //不会改变登录内容
        assertEquals("100",(message.getLoginContent()).getAccount());
        assertEquals("123456",(message.getLoginContent()).getPassword());

    }

    //authority消息，且authority未通过
    @Test
    public void authorityFailTest() {
        LoginContent loginContent = new LoginContent("123","123456");
        Message authoritySucceedMessage = new Message(loginContent, MessageStatus.NEEDHANDLED, MessageType.AUTHORITY);
        channel.writeInbound(authoritySucceedMessage);

        Message message = (Message)channel.readInbound();
        assertEquals(MessageStatus.LOGINFAIL,message.getMessageStatus());
        assertEquals(MessageType.AUTHORITY, message.getType());

        //不会改变登录内容
        assertEquals("123",(message.getLoginContent()).getAccount());
        assertEquals("123456",(message.getLoginContent()).getPassword());

    }

    //chatting消息
    @Test
    public void chattingMessageTest() {
        ChatContent chatContent = new ChatContent("hello");
        Message chattingMessage = new Message(chatContent, MessageStatus.NEEDHANDLED, MessageType.CHATTING);
        channel.writeInbound(chattingMessage);

        Message message = (Message)channel.readInbound();
        assertEquals(MessageStatus.NEEDHANDLED,message.getMessageStatus());
        assertEquals(MessageType.CHATTING,message.getType());

        //不会改变聊天内容
        assertEquals("hello",(message.getChatContent()).getMessage());

    }
}