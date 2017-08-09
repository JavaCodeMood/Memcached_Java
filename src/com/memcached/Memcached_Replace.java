package com.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * Memcached replace 命令用于替换已存在的 key(键) 的 value(数据值)。
 * 如果 key 不存在，则替换失败，并且您将获得响应 NOT_STORED。
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Replace {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("memcached服务连接成功！");
			
			//添加第一个key->value对
			Future fu = mcc.set("city", 900, "北京，上海，深圳");
			//输出状态
			System.out.println("set status: "+ fu.get());
			//获取键对应的值
			System.out.println("city value is cache: "+ mcc.get("city"));
			
			//添加新的key
			fu = mcc.replace("city", 900, "昆明,成都");
			//输出状态
			System.out.println("set status: "+ fu.get());
			//输出值
			System.out.println("city value in cache: " + mcc.get("city"));
			
			//关闭连接
			mcc.shutdown();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
