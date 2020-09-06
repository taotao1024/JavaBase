## AQS 同步发生器
 AbstractQueuedSynchronized 同步发生器 构建Lock JUC ReentrantLock
 
 通过内置得到FIFO同步队列来完成线程争夺资源管理的工作
 
  
##CLH同步队列
写锁的时候的一个帮助器，提供获取锁和是释放锁的功能.模板。
acquire(int arg) 以独占模式获取对象，忽略中断。 
acquireShared(int arg) 以共享模式获取对象，忽略中断。
tryAcquire(arg) 试图在独占模式下获取对象状态。
tryAcquireShared(int arg) 试图在共享模式下获取对象状态
release(int arg) 以独占模式释放对象。
releaseShared(int arg) 以共享模式释放对象
##lock
ReentrantLock  
    公平锁  
    非公平锁  
ReentrantReaderWriter  
    读取者优先或写入者优先强加给锁访问的排序，支持可选的公平策略。

