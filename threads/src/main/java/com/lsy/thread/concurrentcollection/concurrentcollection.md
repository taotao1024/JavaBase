## 并发集合
非阻塞式集合（Non-Blocking Collection）   
ConcurrentLinkedDeque
 * 这类集合也包括添加和移除数据的方法。如果方法不能立即被执行，则返回null或抛出异常，但是调用这个方法的线程不会被阻塞。

实例
添加大量的数据到一个列表中；
从同一个列表中移除大量的数据。

阻塞式集合（Blocking Collection）   
LinkedBlockingDeque
 * 阻塞式集合（Blocking Collection）：这类集合包括添加和移除数据的方法。当集合已满或为空时，被调用的添加或者移除方法就不能立即被执行，那么调用这个方法的线程将被阻塞，一直到该方法可以被成功执行。
