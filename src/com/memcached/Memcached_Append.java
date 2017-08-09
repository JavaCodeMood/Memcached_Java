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
public class Memcached_Append {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("memcached服务连接成功！");
			
			//添加数据
			Future fu = mcc.add("content", 900, "说好了");
			//添加状态
			System.out.println("add status: "+fu.get());
			//取值
			System.out.println("content value in cache:" + mcc.get("content"));
			
			//追加至
			fu = mcc.append("content", "要永远在一起！");
			//追加值后的状态
			System.out.println("append status: " + fu.get());
			//取值追加后的值
			System.out.println("content value is : " + mcc.get("content"));
			
			//关闭连接
			mcc.shutdown();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
