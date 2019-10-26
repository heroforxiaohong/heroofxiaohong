package com.sts.blue.app_m.server;

import com.sts.blue.app_m.server.handler.IdleServerHandler;
import com.sts.blue.base_module.base.msg_v2.MessageDecode;
import com.sts.blue.base_module.base.msg_v2.MessageEncoder;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Qualifier("serverChannelInitializer")
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    public Logger log = Logger.getLogger(this.getClass());

	private final static int READER_IDLE_TIME_SECONDS = 20;//读操作空闲20秒
	private final static int WRITER_IDLE_TIME_SECONDS = 20;//写操作空闲20秒
	private final static int ALL_IDLE_TIME_SECONDS = 40;//读写全部空闲40秒
	
//    @Autowired
//    @Qualifier("authServerHandler")
//    private ChannelInboundHandlerAdapter authServerHandler;
    
    @Autowired
    @Qualifier("logicServerHandler")
    private ChannelInboundHandlerAdapter logicServerHandler;
    
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
    	ChannelPipeline p = socketChannel.pipeline();
        log.info(this.getClass().getSimpleName()+"   initChannel()");

//        p.addLast(new PacketDecoder());

//        p.addLast(new MsgDecoder());
//        p.addLast(MsgEncoder.INSTANCE);

        p.addLast("decoder",new MessageDecode());
        p.addLast("encoder",new MessageEncoder());

    	p.addLast("idleStateHandler", new IdleStateHandler(READER_IDLE_TIME_SECONDS
    			, WRITER_IDLE_TIME_SECONDS, ALL_IDLE_TIME_SECONDS, TimeUnit.SECONDS));
	    p.addLast("idleTimeoutHandler", new IdleServerHandler());
	    
//        p.addLast(new ProtobufVarint32FrameDecoder());
//        p.addLast(new ProtobufDecoder(MessageBase.getDefaultInstance()));
//
//        p.addLast(new ProtobufVarint32LengthFieldPrepender());
//        p.addLast(new ProtobufEncoder());
	    
//        p.addLast("authServerHandler", authServerHandler);
        p.addLast("hearableServerHandler", logicServerHandler);
    }
}
