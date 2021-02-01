线程通讯
join():
    join()底层使用wait()方法，所以会释放锁。
    sleep()实现相同效果，但是不会释放锁。
    Demo 锁继承。