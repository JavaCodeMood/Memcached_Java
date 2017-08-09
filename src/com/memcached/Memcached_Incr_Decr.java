package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * Memcached incr 与 decr 命令用于对已存在的 key(键) 的数字值进行自增或自减操作。
 * incr 与 decr 命令操作的数据必须是十进制的32位无符号整数。
 * 如果 key 不存在返回 NOT_FOUND，如果键的值不为数字，则返回 CLIENT_ERROR，其他错误返回 ERROR。
 * 
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Incr_Decr {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("memcached服务连接成功！");
			
			//添加数值数据
			Future fu = mcc.set("num", 900, "90000");
			//添加状态
			System.out.println("set status: " + fu.get());
			//取出值
			System.out.println("num value is: " + mcc.get("num"));
			
			//自增并输出
			long sincr = mcc.incr("num", 333);
			System.out.println("自增之后的值为：" + sincr);
			
			//自减并输出
			long sdecr = mcc.decr("num", 1000);
			System.out.println("自减之后的值为：" + sdecr);
			
			//关闭连接
			mcc.shutdown();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
