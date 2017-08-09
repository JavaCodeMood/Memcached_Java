package com.memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * Memcached delete 命令用于删除已存在的 key(键)。
 * 
 *
 * @author lhf
 * @createDate 2017年8月9日
 */
public class Memcached_Delete {

	public static void main(String[] args) {
		try {
			//连接本地memcached服务
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		    System.out.println("memcached服务连接成功！");
		    
		    //添加数据
		    Future fu = mcc.add("str", 900, "阿福，说好了要永远在一起！为何你又抛弃我？莫非....");
		    //添加状态
		    System.out.println("add status: " + fu.get());
		    //输出值
		    System.out.println("str value is : " + mcc.get("str"));
		    
		    //使用delete方法删除已有的key
		    fu = mcc.delete("key");
		    // 输出执行 delete 方法后的状态
	        System.out.println("delete status:" + fu.get());
	        //获取键对应的值
	        System.out.println("str value is : " + mcc.get("codingground"));
	        
	        //关闭连接
	        mcc.shutdown();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
