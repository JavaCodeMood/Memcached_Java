package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

/**
 * Memcached CAS（Check-And-Set 或 Compare-And-Swap） 命令用于执行一个"检查并设置"的操作
 * 它仅在当前客户端最后一次取值后，该key 对应的值没有被其他客户端修改的情况下， 才能够将值写入。
 * 检查是通过cas_token参数进行的， 这个参数是Memcach指定给已经存在的元素的一个唯一的64位值。
 * 
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_CAS {

	public static void main(String[] args) {
		try {
			//连接本地memcched服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		    System.out.println("memcached服务连接成功！");
		    
		    //添加数据
		    Future fu = mcc.set("number", 900, "1,2,3,4,5,6,7,8,9,10");
		    //添加状态
		    System.out.println("set status:" + fu.get());
		    //取值
		    System.out.println("number value: " + mcc.get("number"));
		    
		    //通过gets方法获取CAS token(令牌)
		    CASValue casValue = mcc.gets("number");
		    //输出CAS token(令牌)值
		    System.out.println("CAS token - " + casValue);
		    
		    //尝试使用cas方法来更新数据
		    CASResponse casresp = mcc.cas("number", casValue.getCas(), 900, "100,200,300,400,500,600");
		    //输出CAS响应信息
		    System.out.println("CAS response: " + casresp);
		    //输出值
		    System.out.println("number value in cache - " + mcc.get("number"));
		    
		    //关闭连接
		    mcc.shutdown();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
