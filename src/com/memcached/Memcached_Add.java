package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * 使用add来向memcached中添加数据
 * 
 * Memcached add 命令用于将 value(数据值) 存储在指定的 key(键) 中。
 * 如果 add 的 key 已经存在，则不会更新数据，之前的值将仍然保持相同，并且您将获得响应 NOT_STORED。
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Add {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("memcached服务连接成功！");
			
			//添加数据
			Future fu = mcc.set("password", 900, 123456);
			//查看状态
			System.out.println("set status: "+fu.get());
			//输出值
			System.out.println("password value in cache:"+mcc.get("password"));
			
			//添加
			Future fo = mcc.add("age", 900, 23);
			//打印状态
			System.out.println("add status: "+fo.get());
			//添加新key
			fo = mcc.add("email", 900, "liudoudou@163.com");
			//打印状态
			System.out.println("add status: "+fo.get());
			//输出值
			System.out.println("email value in cache:"+mcc.get("email"));
			
			//取出memcached中的值
			System.out.println(mcc.get("username")+"--"+
			                   mcc.get("age")+"--"+
					           mcc.get("password")+"--"+
			                   mcc.get("email"));
			
			//关闭连接
			mcc.shutdown();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
