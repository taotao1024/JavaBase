## HashSet
* 向HashSet中添加可变对象时，一定要特别小心。如果修改了集合中的对象，
有可能导致该对象于集合中其他对象相等，从而导致HashSet无法准确访问该对象。
## LinkHashSet
* LinkHashSet也是使用HashCode值来确定元素的存储位置，但是同时使用链表维护元素的次序。
* LinkHashSet因为要维护元素的插入顺序，所以性能略低于HashSet。
## TreeSet
* TreeSet中的元素是有序的，相比于HashSet添加了获取第一个、前一个、后一个、最后一个、截取子TreeSet的方法。
* TreeSet采用红黑树的结构来存储集合，TreeSet支持两种排序，自然排序和定制排序，默认采用自然排序。
* 自然排序中TreeSet会调用集合元素的compareTo()方法进行比较元素之间的大小关系，
所以试图把一个对象添加到TreeSet中，必须实现comparable接口。
* 于HashSet相同，如果TreeSet包含了可变对象，当可变对象的实例变量被修改时，TreeSet的处理非常复杂且容易出错。
## EnumSet
* EnumSet是专门为枚举设计的集合类，其元素必须是指定枚举类型的枚举值。
* EnumSet内部采用位向量的型式存储，这种存储非常紧凑，高效。批量操作执行速度很快。