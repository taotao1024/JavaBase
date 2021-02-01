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
###ReentrantLock  
    new FairSync() / new NonfairSync(); 公平锁/非公平锁  
####常用API: 
   * 1、int getHoldCount() 获取当前线程保持此锁定的个数，也就是调用lock()方法的次数
   * 2、int getQueueLength() 获取正等待获取此锁定的线程估计数
   * 3、int getWaitQueueLength() 获取等待与此锁定相关的给定条件COndition的线程估计数
   
   * 4、boolean hasQueuedThreads() 查询是否又线程正待等待获取此锁定
   * 5、boolean hasQueuedThread(Thread thread) 查询指定的线程是否在等待获取此锁定
   * 6、boolean hasWaiters(Condition condition) 查询时候有线程正待等待与此锁定有关的Condition条件
   
   * 7、boolean isFair() 判断是不是公平锁
   * 8、boolean isHeldByCurrentThread() 判断当前线程时候保持此锁定
   * 9、boolean isLocked() 判断此锁定是否由任意线程保持
   
   * 10、void lockInterruptibly() 如果当前线程未被中断，则获取锁定。如果已经被中断则出现异常
   * 11、boolean tryLock() 仅在调用时锁定未被另一个线程保持的的情况下，菜获取该锁定。
   * 12、boolean tryLock(long timeout, TimeUnit unit)
###ReentrantReaderWriter  
    读写锁分为: 读操作相关的锁，也称为共享锁；写操作相关的锁，也叫排他锁。多个读锁之间不互斥，读锁与写锁互斥，写锁写锁互斥。
    
    读取者优先或写入者优先强加给锁访问的排序，支持可选的公平策略。

