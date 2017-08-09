package com.memcached;

import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * 
 *Java连接memcached
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class MemcachedJava {

	public static void main(String[] args) {
		try {
			//本地连接memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
			System.out.println("memcached服务连接成功！");
			//关闭连接
			mcc.shutdown();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
