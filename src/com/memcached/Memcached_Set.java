package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * 使用set来向memcached中插入添加数据
 * set存储，get取值
 * 
 * Memcached set 命令用于将 value(数据值) 存储在指定的 key(键) 中。
 * 如果set的key已经存在，该命令可以更新该key所对应的原来的数据，也就是实现更新的作用。
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Set {

	public static void main(String[] args) {
		try{
	         // 连接本地的 Memcached 服务
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	         System.out.println("Connection to server sucessful.");
	      
	         // 存储数据
	         Future fo = mcc.set("username", 900, "刘豆豆");
	      
	         // 查看存储状态
	         System.out.println("set status:" + fo.get());
	         
	         // 输出值
	         System.out.println("username value in cache - " + mcc.get("username"));

	         // 关闭连接
	         mcc.shutdown();
	         
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }

	}

}
