package jdk6;

import sun.security.jca.GetInstance;

public class Singleton {
	//这是饿汉式的，在类初始化的时候进行创建
	/*
	private static final Singleton singleton=new Singleton();
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		return singleton;
	}
	public static void main(String[] args)
	{
		Singleton singleton=new Singleton();
	}*/
	/*
	private static Singleton singleton;
	//这是懒汉式的，在类被创建实例的时候进行创建
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(singleton==null)
		{
			singleton=new Singleton();
		}
		return singleton;
	}
	public static void main(String[] args) throws InterruptedException
	{
		Singleton singleton=new Singleton();
	}*/
	
	//多线程情况	需要加锁
//	private static  volatile  Singleton singleton;
//	//这是懒汉式的，在类被创建实例的时候进行创建
//	private Singleton()
//	{
//		
//	}
	//可以整个加锁
//	public static synchronized Singleton getInstance()
//	{
//		if(singleton==null)
//		{
//			singleton=new Singleton();
//		}
//		return singleton;
//	}
	//缩小加锁范围提高性能 但还是存在可能多个线程同时进入 null判断
	/*
	public static  Singleton getInstance()
	{
		if(singleton==null)
		{
			synchronized(Singleton.class)//这样就可以对类进行加锁
			{
				singleton=new Singleton();
			}
		}
		return singleton;
	}
	//进行DCL检查 但创建一个新的实例不是一个原子操作 
	//new Singleton()分为先分配内存，再标记分配的内存并给出引用，对该引用进行创建实例
	//如果创建还未完成，下一个线程就进入拿取实例，则会取得一个未创建完成的实例
	public static Singleton getInstance()
	{
		if(singleton==null)
		{
			synchronized(Singleton.class)
			{
				if(singleton==null)
					singleton=new Singleton();
			}
		}
		return singleton;
	}*/
	//因为有的jvm对volatile的支持不够好，所以应该这么写
	//因为内部类的初始化在第一次被调用时
	/**/
    private Singleton() {}
    
    private static class SingletonLoader {
        private static final Singleton instance = new Singleton();
    }

    public static final Singleton getInstance() {
        return SingletonLoader.instance;
    }
    //使用getInstance方法获取单例实例
    public static void main(String[] args) throws InterruptedException
	{
    	Singleton singleton=Singleton.getInstance();
	}
}
