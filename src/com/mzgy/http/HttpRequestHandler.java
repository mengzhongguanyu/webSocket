package com.mzgy.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

import javax.print.URIException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by mypc on 2017/8/23.
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String wsUril;
    private static File INDEX;

    static {
        URL location = HttpRequestHandler.class
                .getProtectionDomain().getCodeSource().getLocation();
        try {
            String path = location.toURI() + "index.html";
            path = !path.contains("file:") ? path : path.substring(5);
        } catch (URISyntaxException e){
            throw new IllegalStateException("Unable to index.html", e);
        }
    }

    public HttpRequestHandler (String wsUril){
        this.wsUril = wsUril;
    }
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

    }
}
