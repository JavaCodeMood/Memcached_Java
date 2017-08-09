package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * Memcached append 命令用于向已存在 key(键) 的 value(数据值) 后面追加数据 。
 * 
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Prepend {

	public static void main(String[] args) {
		try {
			//连接本地Memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		    System.out.println("memcached服务连接成功！");
		    
		    //添加数据
		    Future fu = mcc.set("context", 900, ",虽远必诛");
		    //添加状态
		    System.out.println("set status: " + fu.get());
		    //取值
		    System.out.println("context value in cache: " + mcc.get("context"));
		    
		    //在添加的数据前面追加数据
		    fu = mcc.prepend("context", "犯我中华者");
		    //追加的状态
		    System.out.println("prepend status: " + fu.get());
		    //取值追加后的值
		    System.out.println("context value in cache: " + mcc.get("context"));
		    
		    //关闭连接
		    mcc.shutdown();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
