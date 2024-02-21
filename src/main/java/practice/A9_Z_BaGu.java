/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A9_Z_八股文.java, v 0.1 2024年01月01日 12:14  Baojiang Yang Exp $
 */
public class A9_Z_BaGu {

    /**
     * MySQL
     * 一.存储引擎
     *  1.InnoDB和MyISAM
     *  2.MySQL InnoDB v5.5.5 之后是默认,
     *  3.MySQL 存储引擎采用的是 插件式架构 ，支持多种存储引擎，可以为不同的数据库表设置不同的存储引擎以适应不同场景的需要。
     *  4.存储引擎是基于表的，而不是数据库
     *  5.区别
     *      #是否支持行级锁
     *          InnoDB支持,MyISAM不支持,只有表级
     *      #是否支持事务
     *          InnoDB支持,MyISAM不支持,实现了SQL标准定义了四个隔离级别(读未提交,读已提交,可重复读和串行化)，具有提交(commit)和回滚(rollback)事务的能力。
     *          并且，InnoDB 默认使用的 REPEATABLE-READ（可重读）隔离级别是可以解决幻读问题发生
     *      #是否支持外键
     *          InnoDB 支持,MyISAM不支持
     *      #是否支持数据库异常崩溃后的安全恢复
     *          InnoDB 支持,MyISAM不支持
     *      #是否支持MVCC
     *          InnoDB 支持,MyISAM不支持
     *      #索引实现不一样
     *          虽然 MyISAM 引擎和 InnoDB 引擎都是使用 B+Tree 作为索引结构，但是两者的实现方式不太一样。InnoDB 引擎中，其数据文件本身就是索引文件。相比 MyISAM，索引文件和数据文件是分离的，其表数据文件本身就是按 B+Tree 组织的一个索引结构，树的叶节点 data 域保存了完整的数据记录。
     *      此外,InnoDB还以页为单位来管理存储空间
     *
     * 二.索引
     *  1.BST: 不平衡,查询复杂度在O(n)~O(lgn)之间,分别是BST和链表
     *  2.AVL: 平衡,高度差不超1,查找,插入和删除复杂度平均都是O(lgn),但是旋转耗时,删除时效率低下,复杂度是O(lgn)
     *  3.RBT: 红黑树,解决了旋转问题,复杂度降到O(1),但是树太高,被HashMap和TreeMap等使用,但是并不适合MySQL等有磁盘IO的场景
     *  4.B树: 解决了磁盘IO问题
     *      首先定义了B树最重要的概念,阶数(Order)
     *      1.矮胖子,树高低,所以适合磁盘IO
     *      2.每个非叶子节点可以有多个子树
     *      3.有局部性原理: 一个数据被访问时候,附近的数据有较大概率被使用,会被加载到缓存中待用,无需IO,MongoDB使用了B树
     *      4.每个节点都存储真实是数据,且key不重复存储
     *      5.非叶子节点,记录树比子节点少1
     *  和B+树的区别
     *      1.前者都存储真实数据,后者只有叶子节点存储真实数据
     *      2.前者记录不会重复出现,后者可以重复出现,一定会出现在叶子节点也可能出现在非叶子节点
     *      3.后者叶子节点通过双向链表链接,方便检索
     *      4.前者非叶子节点,记录数比子节点少1,而后者相同
     *  从而相比之下,B+树具有以下优势
     *  5.B+树:
     *      1.更少的磁盘IO:B+树的非叶子节点不存数据而存储key,所以每个节点记录数比B树大很多,即阶数更大,树高更低,更适合磁盘IO
     *          此外,由于每个节点的存储的key更多,局部性原理也更好,缓存命中率也更高
     *      2.跟适合范围查找,因为只需要对链表进行遍历即可,而B树需要先找到下限,再对对数进行遍历找上限
     *      3.更稳定的查询效率:B的查询复杂度在1到书高之间,而B+树则稳定为数高,因为所有数据都在叶子节点
     *
     *
     * 三.事务
     *  如果没有特别指明,这里说的不是分布式事务,而设施数据库事务或者叫做本地事务
     *  关系型数据的事务都要满足ACID特性
     *      原子性(Atomicity): 执行的最小单位,不允许分割,要么全部做,要么全不做
     *      一致性(Consistency):执行事务的前后,数据保持一致性,比如转账前后,总额保持不变
     *      隔离性(Isolation):并发访问数据库时,一个用户的事务不能被其他事务干扰,各并发事务之间是数据库是独立的
     *      永久性(Durability):一旦事务被提交,那么对数据库的中的数据印象是持久的,即使服务发生故障也不会受到影响
     *   其中: AID是手段,C是目的
     *
     *   并发事务会带来的问题:
     *      脏读(Dirty read):A事务读取数据进行修改,这修改对其他事务来说是可见的,即使当前事务没有提交,B事务也读取这个已修改没有提交
     *          的数据,当A事务回滚时,B事务读到的数据就是脏数据
     *      丢失修改(Lost of modify): A事务读取数据,B事务也访问了该数据,A事务修改数据后,B事务也修改了数据,对于A实物而言,就丢失了修改
     *      不可重复读(Unrepeatable read): A事务多次读取数据,B事务也读取数据并且修改,在A的多次读取之间,读到的数据就可能不一样
     *          重点在数据修改或者减少
     *      幻读(Phantom read):和不可重复读类似,A事务读取了几行数据,此时B事务插入了一些数据,在A随后的查询中,发现多了一些原本不存在的记录,就好像幻觉一样
     *          重点在于记录的新增
     *
     *    事务的隔离级别:
     *      读未提交(read uncommitted): 最低的级别,允许读取尚未提交的数据变更,可能会导致脏读,幻读和不可重复读
     *      读已提交(read committed): 允许对并发事务读取数据,可以组织脏读,但幻读和不可重复读仍然可能发生
     *      可重复读(repeatable read):对于同一字段多次读取的结果都一样,除非数据被事务本身修改,可阻止脏读和不可重复读,但是幻读仍然可能发生
     *      可串行化(serializable):最高隔离级别,完全服从ACID的隔离级别,可以方式脏读,幻读和不重刻重复读
     *
     *   并发控制的方式:
     *      锁和MVCC
     *
     *      锁:
     *          共享锁S: 允许多个事务同事获取,兼容型
     *          排他锁X: 写锁/独占锁,不允许多个事务同时获取
     *       根据锁的颗粒度不同,又可以分为表锁和行锁
     *
     *      MVCC:多版本并发控制,对一份数据会存多个版本,通过事务的可见性来看到自己应该看到的版本,还会有一个全局版本分配器
     *      来为每一行数据设置版本号,版本号是唯一的
     *
     *
     * 四.日志
     *    针对InnoDB存储引擎,有以下几种常见日志
     *    1.slow query log 慢查询日志
     *      模式是10s,通常设置1s的所有查询语句,在解决慢SQL查询你时候会用
     *    2.binlog 二进制日志
     *      定义:记录是所有对MySQL的变更操作(比如DDL和DML等,不包括SELECT和SHOW等非变更操作)日志
     *      大小:通过追加的方式写入,大小没有限制,可以设置每个文件的最大容量,到达指定值的时候会形成新的文件
     *      方式:有3种类型的二进制记录方式:
     *          Statement模式:每一条修改的数据都会记录
     *          Row模式(推荐): 每一行的具体变更事件都会被记录
     *          Mixed模式:上述两种方式混合模式
     *      作用:binlog主要用于主从复制,过程如下:
     *          1.主库将数据库变化写到binlog
     *          2.从库创建一个IO线程向主库请求更新binlog
     *          3.主库创建一个binlog dump线程来发送binlog,从库IO线程负责接受
     *          4.从库IO线程将接受的binlog写入到relay log中
     *          5.从库的SQL线程读取 relay log同步到本地,也就是再执行一遍
     *      此外: MySQSL的一些同步数据到其他数据源的工具比如Canal等也是依赖binlog,把自己伪装成一个Slave节点进行数据同步
     *          除了主从复制外,binlog还用于实现数据恢复
     *     3.redo log 重做日志
     *        保证事务的持久性:在提交事务时, 存储引擎按照刷盘策略将变更刷到磁盘上去,即使MySQL宕机了,重启后也能回复未能写入磁盘的数据,从而保证事务的持久性
     *        也就是说,redo log具备了崩溃恢复的能力
     *
     *     binlog和redo log的区别
     *      1.binlog主要用于数据还原,数据级别的的回复,比如主从复制
     *          redo log主要用于保证事务持久性,属于事务级别的数据恢复
     *       2.redo log是InnoDB特有的,binlog是所有引擎都有的,因为并log是MySQL的Server层实现的
     *        3.redo log是物理日志,主要记录某个页的秀应该,binlog属于逻辑日志,主要记录数据库执行的所有DML和DDL修改
     *       4.binlog通过追加的方式写入,没有大小限制,redog通过循环方式写入,大小固定,写到末尾时会回到开头循环日志
     *
     *    4.undo log 撤销日志
     *      1.保证事务的原子性,每一个事务对是数据的修改都会记录到undo log中,当事务需要回滚的时候,就利用undo log将数据恢复大盘事务开始前的状态
     *      2.undo log属于逻辑日志,记录的是SQL语句,比如一个事务执行一个DELETE语句时,undo log就会记录一个对应的INSERT 语句
     *      3.帮助InnoDB实现 MVCC
     *
     *
     * 五.优化
     *
     *
     *
     * Redis
     * 一.为什么这么快
     *    1.基于内存
     *    2.基于Reactor模式设计开发的高效的时间处理模型,主要是单线程事件循环和IO多路复用
     *    3.内置多种优化过的数据类型/结构
     *
     * 二.数据类型
     *    1.五种基础类型:String,List,Set,Hash,Zset
     *    2.三种特殊类型:HyperLogLog(基数统计),Bitmao(位图),Bitfield(位域)
     *
     * 三.持久化机制
     *    持久机制有RDB持久,AOF持久,两种混合三种方式,
     *
     * 四.线程模型
     *    基于Reactor模式设计开发的高效的时间处理模型(Netty现成模型也是基于Reactor模式)
     *    Socket    IO Multiplex
     *
     *    Socket1    Socket2
     *    Socket2 -> Socket3    ->      Event Loop    -> Task Queue -> Event Dispatcher  -> Event Processors
     *    Socket3    Socket1
     *
     *              Multi-threaded     Single-threaded
     *
     *
     * 五.Redis Sentinel: 自动故障转移
     *  Sentinel哨兵,不提供读写服务,依赖于Redis工作,Redis2.8版本之后发布
     *  Sentinel实现了Redis集群的高可用,在出从复制实现的集群下,多了一个Sentinel的角色来帮助监控Redis节点的运行状态和故障转移(FailOver)
     *  当Master节点出现故障啥时候,Sentinel会自动选出一个Slave升级为Master,确保集群可用,整个过程完全自动
     *  主要有4个功能:
     *      监控: 监控节点是否正常
     *      故障转移: 当Master节点出现故障啥时候,Sentinel会自动选出一个Slave升级为Master,确保集群可用,整个过程完全自动
     *      通知: 通知Slave新的master信息,让他们链接新的Master,成为他的Slave
     *      配置提供: 客户端连接Sentinel新的master地址,如果发生故障转移,sentinel会通知master链接信息给客户端
     *   如果要保证高可用,哨兵配置成单数而且要保证数量大于等于3
     *
     *  Sentinel如何选出新的Master
     *      1.slave优先级,值越小分越高,越有机会成为Master
     *      2.复制进度:Sentinel选出数据最完整的,也就是复制进度最快的成为Master
     *      3.运行id:一般经过前边两轮就选出Master了,如果多个slave的优先级和复制进度一样的话,选择运行id最小的成为Master
     *  Sentinel中如何选出集群中的Leader
     *      使用公识算法
     *
     * 六.Redis Cluster: 切片集群,满足高并发和大数据量
     *      Redis切片集群就是部署多态redis主节点master,在这些节点之间平等,并没有主从之说,同时对外提供读写服务
     *      缓存的数据相对均匀的分布在这些redis实例上,客户端的请求通过路由规则转发到master上
     *    Redis在3.0之后退出了自己的分片集群方案,之前都是使用codis之类的第三方方案
     *
     *   Cluster如何分片
     *   没有采用一致性哈希,而是采用哈希槽的方式,每一个键值对都属于一个hash slot
     *   Redis Cluster通常有16384哥哈希槽,一个key对应的那个槽,对key计算CRC16校验码,再对16384取模,得到对应hash槽
     *
     *   为什么是16384?
     *   CRC-16的校验码有16为,理论上可以产生,2的16次方=65536,而redis选择了2的14次方=16384
     *   1.心跳包16k占用内存
     *   2.Cluster一般扩展不会超过1000个,16384完全够用
     *
     *
     *
     *
     *
     * kafuka
     *
     * 一.Kafka是什么
     *      kafuka是一个分布式流式处理平台
     *  有如下两大应用场景
     *      消息队列:建立实时流数据管道,可靠的在系统或者应用程序之间获取数据
     *      数据处理:构建实时流数据处理程序来转换或处理数据流
     *   和其他队列相比,优势是
     *      极致的性能:大量使用了批处理和异步的思想,最高可以支持每秒处理千万级的消息
     *      生态系统兼容性无可匹敌:
     *
     * 二.核心概念
     * Producer
     * Consumer
     * Broker
     * Topic
     * Partition
     *
     *
     *
     *
     * scheduler
     *
     *
     * ElasticSearch
     *
     *
     *
     * 得物八股文:
     *
     * 一.开放平台鉴权问题:
     *  (App ID）和密钥（App Secret）颁发AccessToken,并且每次都要进行鉴权
     *
     *  往细上了说,JWT,传输中的安全加密问题,对称加密和非对称加密,技术有哪些
     *  https安全问题: https://hailiang.feishu.cn/wiki/ZGJXwXY3aifucbkzamqctOegnKT
     *
     *
     * 二.快速排序
     *  基于分治法。快速排序的基本思想是选取一个基准元素（通常是数组中的一个元素），通过一趟排序将数组分成两个部分，其中一部分的所有元素小于基准元素，另一部分的所有元素大于基准元素。然后递归地对这两部分进行排序，直到整个数组有序。
     *  总的时间复杂度为 O(nlogn), 其中 n 是数组的长度。在平均情况下，快速排序的性能很好，并且常常被用作排序算法的首选
     *
     * 三.Java锁升级机制(jdk的锁升级机制)
     *  Java 锁升级机制指的是在多线程环境下，Java 中的锁会根据竞争程度和持有时间等因素自动升级为更重量级的锁，以提高性能和减少资源消耗,Java中的锁升级机制通常涉及到从无锁状态到偏向锁、再到轻量级锁、最后到重量级锁的转变。
     *  1.无锁状态（Unlocked）：
     *      初始状态，没有被线程持有。当一个线程尝试获取锁时，如果锁处于无锁状态，那么该线程将成功获取锁，并且锁的状态将升级为偏向锁。
     *  2.偏向锁（Biased Locking）：
     *      当一个线程首次访问一个同步代码块时，会将锁升级为偏向锁，并且该线程会成为锁的拥有者。此时，如果其他线程尝试获取同一个锁，JVM会判断是否可以取消偏向锁，并且进行相应的处理。偏向锁适用于只有一个线程访问同步块的情况，适用于线程间竞争不激烈的场景。
     *  2.轻量级锁：
     *      轻量级锁（Lightweight Locking）：当有多个线程访问同一个锁时，偏向锁将升级为轻量级锁。轻量级锁通过CAS（比较并交换）操作来实现，它会在持有锁的线程的栈帧中建立一个锁记录（Lock Record）来存储锁对象的指针。其他线程在尝试获取该锁时，会通过CAS来竞争锁。如果竞争成功，即获取到了锁，那么该线程可以继续执行；
     *      否则，将尝试自旋等待，避免真正地进入阻塞状态。当自旋等待达到一定次数或者竞争失败时，轻量级锁将升级为重量级锁
     *  4.重量级锁（Heavyweight Locking）：
     *      当自旋等待达到一定次数或者竞争失败时，轻量级锁会升级为重量级锁。重量级锁会使其他线程阻塞，直到持有锁的线程释放锁。重量级锁是一种悲观锁，会导致线程频繁地进入阻塞状态，因此在高并发情况下性能可能会受到影响。
     *
     *
     *
     * 四.Spring问题归类
     *
     *   #Spring中bean生命周期
     *   1.实例化（Instantiation）：
     *      在这个阶段，Spring容器会根据Bean的定义创建Bean的实例。通常情况下，可以通过构造函数或者工厂方法来实例化Bean。
     *   2.属性设置（Population）：
     *      在实例化之后，Spring容器会将配置文件中或者通过注解设置的属性值，以及依赖注入到Bean实例中。
     *   3.初始化（Initialization）：
     *      在属性设置之后，Spring容器会调用Bean的初始化方法。这些方法可以是实现了InitializingBean接口的afterPropertiesSet()方法，或者通过配置文件中指定的自定义初始化方法。
     *   4.使用（In Use）：
     *      在初始化之后，Bean就可以被应用程序使用了。在这个阶段，Bean提供了它所代表的功能和服务。
     *   5.销毁（Destruction）：
     *      在Bean不再需要的时候，Spring容器会调用Bean的销毁方法。这些方法可以是实现了DisposableBean接口的destroy()方法，或者通过配置文件中指定的自定义销毁方法。
     *
     *   #Spring 循环依赖
     *      Spring循环依赖问题是指当两个或多个Bean之间相互依赖时，可能会导致Spring容器无法正确地初始化这些Bean的情况。这种情况下，Spring容器无法确定哪个Bean应该先被实例化，从而导致循环依赖的问题
     *   比如:
     *   public class A {
     *     private B b;
     *     public A(B b) {
     *         this.b = b;
     *     }
     * }
     * public class B {
     *     private A a;
     *     public B(A a) {
     *         this.a = a;
     *     }
     * }
     * 在这种情况下，当Spring容器尝试初始化A和B时，会发现A需要B的实例，而B又需要A的实例，从而导致循环依赖的问题
     *      Spring框架提供了几种解决循环依赖问题的方式：
     *      (1)构造函数注入：
     *          使用构造函数注入可以避免循环依赖问题，因为构造函数在Bean的实例化阶段被调用，可以确保所有的依赖关系在Bean被初始化之前已经设置好。
     *      (2)Setter注入：
     *          如果无法使用构造函数注入，可以使用Setter方法进行依赖注入。Spring容器会在创建Bean之后，调用Setter方法来设置依赖关系。
     *      (3)使用@Lazy注解：
     *          在循环依赖比较复杂或者无法避免的情况下，可以考虑使用@Lazy注解延迟初始化Bean，以避免循环依赖问题。这样可以让Spring容器先完成Bean的实例化，然后再处理依赖关系。
     *      (4)使用代理对象：
     *          Spring容器可以使用代理对象来解决循环依赖问题。当A和B之间存在循环依赖时，Spring容器会先创建A的代理对象，并将其注入到B中，然后再创建A的实际对象。这样可以绕过循环依赖问题。
     *
     *   #Spring boot spi
     *   定义: SPI（Service Provider Interface）是一种服务发现机制,针对接口和实现进行解耦,原理是基于查找和装载机制的动态加载方式,用于实现组件的扩展和插件化。
     *         SPI机制允许开发者定义接口，然后通过配置文件或者其他方式来注册实现该接口的具体类，从而实现松耦合的组件扩展。
     *   以下是SPI在Spring Boot中的详解：
     *
     *   (1)定义接口：
     *   public interface MyService {
     *     void doSomething();
     *  }
     *
     *  (2)编写实现类
     * public class MyServiceImpl1 implements MyService {
     *     @Override
     *     public void doSomething() {
     *         System.out.println("MyServiceImpl1 is doing something.");
     *     }
     * }
     * public class MyServiceImpl2 implements MyService {
     *     @Override
     *     public void doSomething() {
     *         System.out.println("MyServiceImpl2 is doing something.");
     *     }
     * }
     *
     *  (3)配置文件
     *      开发者可以通过在META-INF/services目录下创建以接口全限定名为名称的文件，并在该文件中列出实现类的全限定名。
     * 在Spring Boot中，通常不需要手动创建这些配置文件，因为Spring Boot会自动扫描并加载META-INF/services目录下的配置文件。开发者只需要确保实现类位于classpath下，并且在配置文件中正确列出即可。
     *
     *
     * (4)使用：
     *  最后，开发者可以在应用程序中通过Spring框架来获取实现了该接口的具体类，从而实现扩展功能。
     * @Autowired
     * private List<MyService> myServices;
     * Spring Boot会自动将所有实现了MyService接口的类注入到myServices列表中，开发者可以直接使用这些实现类
     *
     * 五.Java创建一个对象的过程
     *      1. 类加载：
     *          在Java程序中，首先需要加载对象所属的类。当Java虚拟机（JVM）加载类时，它会检查类路径，找到类文件并加载到内存中。如果类还没有被加载，JVM就会通过类加载器加载类的字节码文件，并在方法区中创建一个表示该类的Class对象。
     *      2. 内存分配：
     *          一旦类被加载到内存中，接下来就需要为对象分配内存空间。在Java中，对象的内存分配是在堆内存中完成的。当程序使用`new`关键字创建一个对象时，JVM会在堆内存中为对象分配一块连续的内存空间。
     *      3. 实例化：
     *          内存分配完成后，JVM会调用类的构造方法来初始化对象。构造方法负责初始化对象的状态和属性。如果没有显式定义构造方法，Java会提供一个默认的无参构造方法来初始化对象。
     *      4. 对象初始化：
     *          在对象被实例化后，JVM会对对象进行初始化。这包括对对象的属性进行默认初始化（如果有的话），以及执行构造方法中的代码来初始化对象的状态。
     *      5. 对象引用：
     *          最后，Java程序中的某个变量会引用新创建的对象。这个变量可以是一个类成员变量、方法局部变量或者数组元素等。通过这个变量，程序可以操作和访问对象的属性和方法。
     *      总的来说，Java创建一个对象的过程包括类加载、内存分配、实例化、对象初始化和对象引用等步骤。这个过程是Java程序中常见的操作，理解这个过程有助于理解Java程序的运行机制。
     *
     *
     *
     * 六.volatile的原理
     *  volatile 的原理是通过内存屏障来实现变量的可见性和禁止指令重排序。它保证了当一个线程修改了变量的值后，其他线程可以立即看到最新的值，并且禁止了编译器和处理器对指令进行重排序，从而提供了一种简单而有效的线程安全机制
     *
     *   1. 可见性（Visibility）：
     *      当一个变量被 volatile 修饰时，线程在读取该变量的值时，会直接从主内存中读取，而不是从线程的工作内存中读取。
     *      同样，在修改该变量的值后，会立即将修改后的值刷新到主内存中。这样可以保证当一个线程修改了变量的值后，其他线程可以立即看到最新的值，从而保证了变量的可见性。
     *
     *   2.禁止指令重排序（Prevent Reordering）：
     *      volatile 关键字还可以禁止编译器和处理器对指令重排序。在 Java 内存模型中，编译器和处理器会对指令进行优化重排，这可能会导致在多线程环境下出现问题。
     *      例如，对于一个普通的变量，编译器可能会将写操作和后续的写操作进行重排序，这可能会导致其他线程看到不一致的状态。而使用 volatile 关键字修饰的变量，在其之前的写操作都会在其之后执行，从而避免了这种问题。
     *
     *   3.内存屏障（Memory Barriers）：
     *      在 JVM 中，volatile 的实现通常会使用内存屏障来实现可见性和禁止指令重排序。内存屏障是一种硬件或者软件机制，用于强制处理器和编译器在指令执行过程中遵守一定的顺序。
     *      在 volatile 变量的读写操作前后，会插入对应的内存屏障，以确保变量的可见性和禁止指令重排序。
     *
     *
     * 七.内存模型
     * JVM（Java虚拟机）内存模型描述了Java应用程序在JVM中的内存分配、使用和管理方式。JVM内存模型包括了以下几个主要的内存区域：
     *
     * 1. **程序计数器（Program Counter Register）**：
     *    程序计数器是一块较小的内存区域，它可以看作是当前线程所执行的字节码的行号指示器。在多线程环境下，每个线程都有自己独立的程序计数器，它们互不干扰。当线程执行Java方法时，程序计数器记录了当前线程正在执行的字节码指令的地址。
     *
     * 2. **Java虚拟机栈（JVM Stacks）**：
     *    Java虚拟机栈用于存储方法的局部变量、方法参数、部分方法结果和返回值。每个线程都有自己独立的Java虚拟机栈，它们用于存储线程私有的数据。在方法调用时，JVM栈会创建一个栈帧，用于存储方法的局部变量表、操作数栈、动态链接和方法返回地址等信息。当方法调用结束时，对应的栈帧会被销毁。
     *
     * 3. **本地方法栈（Native Method Stacks）**：
     *    本地方法栈与Java虚拟机栈类似，但它用于执行本地（Native）方法的线程私有数据。每个线程都有自己独立的本地方法栈，用于执行本地方法调用。
     *
     * 4. **Java堆（Java Heap）**：
     *    Java堆是Java虚拟机中最大的一块内存区域，用于存储对象实例和数组对象。所有的对象实例都在堆上分配内存，堆是所有线程共享的内存区域。
     *    Java堆被分为新生代和老年代，每个代又分为Eden区、Survivor区（From和To区）。
     *
     *    新生代(占比堆的1/3~1/4之间)
     *      Eden区(占比整个新生代的70%至80%)
     *      Survivor区
     *          From Survivor区 (占比整个新生代的10%至15%)
     *          To Survivor区 (占比整个新生代的10%至15%)
     *    老年代: Old Generation (占比堆的1/2或者以上)
     *    永久代: Perm Generation, 永久代是方法区的一部分，用于存储类的元数据、静态变量、常量池等信息。永久代的大小通常比较固定，由 -XX:MaxPermSize 参数指定，默认值为64MB。然而，由于永久代的大小是固定的，可能会导致内存溢出问题，因此在Java 8及之后的版本中，永久代被移除，取而代之的是元空间（Metaspace）
     *    元空间（Metaspace）（Java 8及更新版本）：
     *      元空间是方法区的替代方案，用于存储类的元数据、静态变量、常量池等信息。与永久代不同，元空间是通过本地内存来实现的，因此它的大小不受限于JVM的最大堆大小，而是受限于物理内存和操作系统的限制。
     *
     *    大部分的Java对象会被分配在新生代的Eden区，经过几次垃圾回收后，存活的对象会被移到Survivor区，最后被移到老年代。
     *
     *
     * 5. **方法区（Method Area）**：
     *    方法区用于存储类的元数据、静态变量、常量池等信息。在HotSpot虚拟机中，方法区也称为永久代（Permanent Generation）。在Java 8 及更新版本中，方法区被移除，被称为元空间（Metaspace）。元空间是通过本地内存来实现的，因此它的大小不受限于JVM的最大堆大小，而是受限于物理内存和操作系统的限制。
     *
     * 6. **运行时常量池（Runtime Constant Pool）**：
     *    运行时常量池是方法区的一部分，用于存储编译期间生成的字面量和符号引用。与Class文件中的常量池不同，运行时常量池是在类加载时动态生成的，并且可以在运行时动态添加新的常量。
     *
     * 7. **直接内存（Direct Memory）**：
     *    直接内存不是JVM规范中的一部分，但它是Java虚拟机内存模型的补充。直接内存是通过NIO（New I/O）库中的ByteBuffer来分配的，它使用了操作系统的本地内存来存储数据，而不是JVM的堆内存。直接内存的分配和释放不受Java堆的管理，因此可以减少Java堆的压力，提高内存的使用效率。
     *
     * 总的来说，JVM内存模型描述了Java应用程序在JVM中的内存分配、使用和管理方式，它包括了程序计数器、Java虚拟机栈、本地方法栈、Java堆、方法区、运行时常量池和直接内存等多个内存区域。这些内存区域共同组成了Java虚拟机的内存结构，为Java程序的运行提供了支持。
     *
     *
     * Java虚拟机的垃圾回收（Garbage Collection）是一种自动化的内存管理机制，用于在运行时自动回收不再使用的内存，从而释放内存资源，减少内存泄漏和内存溢出的风险。垃圾回收机制的实现通常包括以下几个主要步骤：
     *
     * 1. **标记（Marking）**：
     *    垃圾回收器首先会对内存中的对象进行标记，标记所有仍然存活的对象。这一过程从根对象开始，递归遍历对象图，标记所有能够被访问到的对象。
     *
     * 2. **清除（Sweeping）**：
     *    在标记阶段完成后，垃圾回收器会扫描堆中的所有对象，并清除所有未被标记的对象。这些未被标记的对象被认为是不再使用的，可以安全地回收其占用的内存空间。
     *
     * 3. **压缩（Compacting）**：
     *    在清除阶段完成后，可能会产生内存碎片。为了更好地利用内存空间，某些垃圾回收器会对内存空间进行压缩，将存活的对象移动到堆的一端，从而使内存空间变得连续。
     *
     * Java虚拟机的垃圾回收机制有多种实现，包括了不同的垃圾回收算法和垃圾回收器。以下是常见的垃圾回收算法和垃圾回收器：
     *
     * 1. **垃圾回收算法**：
     *
     *    - **标记-清除算法（Mark-Sweep）**：
     *      标记-清除算法是最基本的垃圾回收算法，它通过标记对象然后清除未被标记的对象来进行垃圾回收。但是标记-清除算法可能会产生内存碎片，影响内存的利用率。
     *
     *    - **复制算法（Copying）**：
     *      复制算法将内存空间分为两块，每次只使用其中一块。当一块内存空间用完后，垃圾回收器会将存活的对象复制到另一块内存空间中，然后清除未被复制的对象。复制算法可以解决内存碎片问题，但会造成内存利用率下降。
     *
     *    - **标记-整理算法（Mark-Compact）**：
     *      标记-整理算法先标记对象，然后将存活的对象移动到内存的一端，最后清除未被移动的对象。标记-整理算法可以解决内存碎片问题，并且不会造成内存利用率下降。
     *
     * 2. **垃圾回收器**：
     *
     *    - **Serial收集器**：串行收集器是一种单线程的垃圾回收器，适用于小型应用和客户端应用。它使用复制算法和标记-整理算法来进行垃圾回收。
     *
     *    - **Parallel收集器**：并行收集器是一种多线程的垃圾回收器，适用于多核服务器应用。它使用复制算法和标记-清除算法来进行垃圾回收，以提高垃圾回收的效率。
     *
     *    - **CMS收集器**：CMS（Concurrent Mark-Sweep）收集器是一种以最短停顿时间为目标的垃圾回收器，适用于对响应时间有较高要求的应用。它使用标记-清除算法来进行垃圾回收，同时尽可能减少停顿时间。
     *
     *    - **G1收集器**：G1（Garbage-First）收集器是一种面向服务端应用的垃圾回收器，适用于大内存、高并发的应用。它使用标记-整理算法来进行垃圾回收，同时通过分区的方式来降低停顿时间。
     *
     * 总的来说，Java虚拟机的垃圾回收机制通过标记、清除和压缩等步骤来自动回收不再使用的内存，以释放内存资源并降低内存泄漏和内存溢出的风险。通过选择合适的垃圾回收算法和垃圾回收器，可以更好地满足不同应用场景的需求。
     *
     *
     *
     * 八.Hashmap的原理
     *  HashMap是Java中最常用的一种集合实现，它基于哈希表实现了Map接口，提供了键值对的存储和检索功能。下面是HashMap的原理详解：
     *
     * 1. **数据结构**：
     *    HashMap内部使用了一个数组（称为哈希表）来存储键值对。每个数组元素称为一个桶（bucket），每个桶存储了一个链表或红黑树（在JDK8中引入了红黑树）的头节点，这些节点存储了具有相同哈希值的键值对。
     *
     * 2. **哈希算法**：
     *    当我们向HashMap中添加一个键值对时，HashMap会通过键的hashCode()方法计算出哈希值（hash），然后通过哈希值的高位运算（位运算）来确定该键值对在数组中的位置。具体来说，HashMap会使用哈希值的高位几位作为索引，来定位到数组的具体位置。这个索引值可以通过 `(hashCode ^ (hashCode >>> 16)) & (length-1)` 来计算得到。
     *
     * 3. **解决哈希冲突**：
     *    由于不同的键可能会有相同的哈希值，这会导致哈希冲突。为了解决哈希冲突，HashMap使用了链表或红黑树来存储具有相同哈希值的键值对。当冲突发生时，新添加的键值对会被插入到链表或红黑树中。在JDK8之后，当链表长度达到一定阈值（默认为8）时，链表会转换为红黑树，以提高检索效率。
     *
     * 4. **扩容机制**：
     *    当HashMap中的键值对数量达到了数组容量的75%（加载因子，默认值为0.75）时，HashMap会进行扩容操作。扩容操作会创建一个新的更大的数组，并将原数组中的键值对重新分配到新数组中。扩容操作需要重新计算所有键的哈希值，并重新确定它们在新数组中的位置。
     *
     * 5. **性能分析**：
     *    HashMap的检索、插入和删除操作的时间复杂度均为O(1)，在大多数情况下能够提供非常高效的性能。然而，如果哈希冲突发生较为严重，可能会导致链表长度过长，从而使得检索效率下降。因此，在设计HashMap时，需要合理选择加载因子，以及对于键对象需要实现合适的hashCode()方法来尽量减少哈希冲突的发生。
     *
     * 总的来说，HashMap是一种基于哈希表实现的高效的键值对集合，通过合理的哈希算法、解决哈希冲突的机制、扩容机制等来提供高效的存储和检索功能。
     *
     *
     * 九.线程交替输出
     * 详情看 {@link A9_Thread_交替输出 }
     *
     *
     * 十.MySQL
     *
     * #缓存淘汰原理
     *  MySQL中的缓存淘汰机制通常指的是InnoDB存储引擎中的缓冲池（Buffer Pool）的管理。Buffer Pool是InnoDB存储引擎用于缓存数据页的内存区域，用于提高数据库的读取性能。当Buffer Pool中的内存空间不足时，需要淘汰部分缓存的数据页以腾出空间给新的数据页。
     *
     *  1. LRU（Least Recently Used）最近最少使用原理：根据数据的最近访问时间来淘汰，最久未被访问的数据会被淘汰。
     *  2. LFU（Least Frequently Used）最不经常使用原理：根据数据的访问次数来淘汰，访问频率最低的数据会被淘汰。
     *  3. FIFO（First In, First Out）先进先出原理：按照数据进入缓存的顺序来淘汰，最先进入缓存的数据会被最先淘汰。
     *  4. Random 随机替换原理：随机选择一个数据进行淘汰。
     *
     * MySQL 使用这些原理来决定缓存中哪些数据应该被淘汰，以保持缓存中的数据始终是最新且最有用的。同时，MySQL 也提供了一些参数和配置选项来优化缓存的淘汰策略，以满足不同应用场景的需求
     *
     * #插入/删除数据页怎么变动的
     *
     * 在MySQL中，数据页的插入和删除是通过存储引擎来管理的，不同的存储引擎可能有不同的实现方式。以下是一般情况下的说明：
     *
     * 1. **数据页的插入**：
     *    当执行插入操作时，MySQL首先将数据写入到内存中的临时缓冲区（称为redo log），然后根据存储引擎的实现将数据页写入到磁盘上的数据文件中。
     *    如果数据页已满，则可能需要分配一个新的数据页来存储新插入的数据。数据页的分配和管理通常由存储引擎负责，不同的存储引擎可能采用不同的策略来管理数据页。
     *
     * 2. **数据页的删除**：
     *    当执行删除操作时，MySQL首先将删除操作写入到内存中的redo log中，然后在数据文件中标记要删除的数据页中对应数据行的删除标记。
     *    删除标记通常会在后续的清理操作中被实际清除。MySQL中的清理操作由后台线程负责执行，它会定期扫描数据文件，将已标记为删除的数据行从数据页中清除，从而释放存储空间。
     *
     * 需要注意的是，在某些情况下，MySQL可能会使用一种称为“延迟写入”（Delayed Write）的机制，延迟将数据页写入磁盘，而是先将数据写入到内存中的redo log中，
     * 然后在后台线程执行的时候才将数据页写入到磁盘。这种机制可以提高数据库的性能，但可能会增加数据丢失的风险。因此，在数据的持久性和性能之间需要权衡选择。
     *
     *
     *
     * 十一.系统稳定性
     *
     *
     *
     */


}