package RMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class RMQFactory extends BasePooledObjectFactory<Channel> {

	private final Connection connection;
	private int count;

	public RMQFactory(Connection connection) {
		this.connection = connection;
		this.count = 0;
	}


	@Override
	public Channel create() throws Exception {
		count++;
		Channel channel = connection.createChannel();
		System.out.println("Channel " + count + " created");
		return channel;
	}

	@Override
	public PooledObject<Channel> wrap(Channel channel) {
		return new DefaultPooledObject<>(channel);
	}

	public int getChannelCount() {
		return count;
	}
}
