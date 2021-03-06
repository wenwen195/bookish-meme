package channel;

import io.netty.channel.Channel;

import java.util.List;

/**
 * Created by huanganna on 16/4/27.
 */
public class ClientChannel {

    private Channel channel;
    private String account;
    private String currentGroupId;

    public ClientChannel(Channel channel) {
        this.channel = channel;
    }

    public ClientChannel(Channel channel,String account, String currentGroupId) {
        this.channel = channel;
        this.account = account;
        this.currentGroupId = currentGroupId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrentGroupId() {
        return currentGroupId;
    }

    public void setCurrentGroupId(String currentGroupId) {
        this.currentGroupId = currentGroupId;
    }
}
