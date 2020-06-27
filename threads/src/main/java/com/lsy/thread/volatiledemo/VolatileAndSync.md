## volatile与synchronized的区别
 * 使用上的区别
Volatile只能修饰变量，synchronized只能修饰方法和语句块
 * 对原子性的保证
synchronized可以保证原子性，Volatile不能保证原子性
 * 对可见性的保证
都可以保证可见性，但实现原理不同
Volatile对变量加了lock，synchronized使用monitorEnter和monitorexit  monitor  JVM
 * 对有序性的保证
Volatile能保证有序，synchronized可以保证有序性，但是代价（重量级）并发退化到串行
 * 其他
synchronized引起阻塞、Volatile不会引起阻塞
