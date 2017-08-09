package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

/**
 * memcached get 命令获取存储在 key(键) 中的 value(数据值) ，如果 key 不存在，则返回空。
 * 
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Gets {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		    System.out.println("memcached服务连接成功！");
		    
		    //添加数据
		    Future fu = mcc.set("number", 900, "12355678998655");
		    // 输出执行 set 方法后的状态
	        System.out.println("set status:" + fu.get());
	            
	        // 从缓存中获取键为 number 的值
	        System.out.println("runoob value in cache - " + mcc.get("number"));
	        
	        //通过gets方法获取CAS token(令牌)
            CASValue casValue = mcc.gets("number");
            //输出CAS token(令牌)值
            System.out.println("CAS value is: " + casValue);
            
            //关闭连接 
            mcc.shutdown();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
