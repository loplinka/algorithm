/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A9_Z_�˹���.java, v 0.1 2024��01��01�� 12:14  Baojiang Yang Exp $
 */
public class A9_Z_BaGu {

    /**
     * MySQL
     * һ.�洢����
     *  1.InnoDB��MyISAM
     *  2.MySQL InnoDB v5.5.5 ֮����Ĭ��,
     *  3.MySQL �洢������õ��� ���ʽ�ܹ� ��֧�ֶ��ִ洢���棬����Ϊ��ͬ�����ݿ�����ò�ͬ�Ĵ洢��������Ӧ��ͬ��������Ҫ��
     *  4.�洢�����ǻ��ڱ��ģ����������ݿ�
     *  5.����
     *      #�Ƿ�֧���м���
     *          InnoDB֧��,MyISAM��֧��,ֻ�б���
     *      #�Ƿ�֧������
     *          InnoDB֧��,MyISAM��֧��,ʵ����SQL��׼�������ĸ����뼶��(��δ�ύ,�����ύ,���ظ����ʹ��л�)�������ύ(commit)�ͻع�(rollback)�����������
     *          ���ң�InnoDB Ĭ��ʹ�õ� REPEATABLE-READ�����ض������뼶���ǿ��Խ���ö����ⷢ��
     *      #�Ƿ�֧�����
     *          InnoDB ֧��,MyISAM��֧��
     *      #�Ƿ�֧�����ݿ��쳣������İ�ȫ�ָ�
     *          InnoDB ֧��,MyISAM��֧��
     *      #�Ƿ�֧��MVCC
     *          InnoDB ֧��,MyISAM��֧��
     *      #����ʵ�ֲ�һ��
     *          ��Ȼ MyISAM ����� InnoDB ���涼��ʹ�� B+Tree ��Ϊ�����ṹ���������ߵ�ʵ�ַ�ʽ��̫һ����InnoDB �����У��������ļ��������������ļ������ MyISAM�������ļ��������ļ��Ƿ���ģ���������ļ��������ǰ� B+Tree ��֯��һ�������ṹ������Ҷ�ڵ� data �򱣴������������ݼ�¼��
     *      ����,InnoDB����ҳΪ��λ�������洢�ռ�
     *
     * ��.����
     *  1.BST: ��ƽ��,��ѯ���Ӷ���O(n)~O(lgn)֮��,�ֱ���BST������
     *  2.AVL: ƽ��,�߶Ȳ��1,����,�����ɾ�����Ӷ�ƽ������O(lgn),������ת��ʱ,ɾ��ʱЧ�ʵ���,���Ӷ���O(lgn)
     *  3.RBT: �����,�������ת����,���ӶȽ���O(1),������̫��,��HashMap��TreeMap��ʹ��,���ǲ����ʺ�MySQL���д���IO�ĳ���
     *  4.B��: ����˴���IO����
     *      ���ȶ�����B������Ҫ�ĸ���,����(Order)
     *      1.������,���ߵ�,�����ʺϴ���IO
     *      2.ÿ����Ҷ�ӽڵ�����ж������
     *      3.�оֲ���ԭ��: һ�����ݱ�����ʱ��,�����������нϴ���ʱ�ʹ��,�ᱻ���ص������д���,����IO,MongoDBʹ����B��
     *      4.ÿ���ڵ㶼�洢��ʵ������,��key���ظ��洢
     *      5.��Ҷ�ӽڵ�,��¼�����ӽڵ���1
     *  ��B+��������
     *      1.ǰ�߶��洢��ʵ����,����ֻ��Ҷ�ӽڵ�洢��ʵ����
     *      2.ǰ�߼�¼�����ظ�����,���߿����ظ�����,һ���������Ҷ�ӽڵ�Ҳ���ܳ����ڷ�Ҷ�ӽڵ�
     *      3.����Ҷ�ӽڵ�ͨ��˫����������,�������
     *      4.ǰ�߷�Ҷ�ӽڵ�,��¼�����ӽڵ���1,��������ͬ
     *  �Ӷ����֮��,B+��������������
     *  5.B+��:
     *      1.���ٵĴ���IO:B+���ķ�Ҷ�ӽڵ㲻�����ݶ��洢key,����ÿ���ڵ��¼����B����ܶ�,����������,���߸���,���ʺϴ���IO
     *          ����,����ÿ���ڵ�Ĵ洢��key����,�ֲ���ԭ��Ҳ����,����������Ҳ����
     *      2.���ʺϷ�Χ����,��Ϊֻ��Ҫ���������б�������,��B����Ҫ���ҵ�����,�ٶԶ������б���������
     *      3.���ȶ��Ĳ�ѯЧ��:B�Ĳ�ѯ���Ӷ���1�����֮��,��B+�����ȶ�Ϊ����,��Ϊ�������ݶ���Ҷ�ӽڵ�
     *
     *
     * ��.����
     *  ���û���ر�ָ��,����˵�Ĳ��Ƿֲ�ʽ����,����ʩ���ݿ�������߽�����������
     *  ��ϵ�����ݵ�����Ҫ����ACID����
     *      ԭ����(Atomicity): ִ�е���С��λ,�������ָ�,Ҫôȫ����,Ҫôȫ����
     *      һ����(Consistency):ִ�������ǰ��,���ݱ���һ����,����ת��ǰ��,�ܶ�ֲ���
     *      ������(Isolation):�����������ݿ�ʱ,һ���û��������ܱ������������,����������֮�������ݿ��Ƕ�����
     *      ������(Durability):һ�������ύ,��ô�����ݿ���е�����ӡ���ǳ־õ�,��ʹ����������Ҳ�����ܵ�Ӱ��
     *   ����: AID���ֶ�,C��Ŀ��
     *
     *   ������������������:
     *      ���(Dirty read):A�����ȡ���ݽ����޸�,���޸Ķ�����������˵�ǿɼ���,��ʱ��ǰ����û���ύ,B����Ҳ����������޸�û���ύ
     *          ������,��A����ع�ʱ,B������������ݾ���������
     *      ��ʧ�޸�(Lost of modify): A�����ȡ����,B����Ҳ�����˸�����,A�����޸����ݺ�,B����Ҳ�޸�������,����Aʵ�����,�Ͷ�ʧ���޸�
     *      �����ظ���(Unrepeatable read): A�����ζ�ȡ����,B��ʮ��Ҳ��ȡ���ݲ����޸�,��A�Ķ�ζ�ȡ֮��,���������ݾͿ��ܲ�һ��
     *          �ص��������޸Ļ��߼���
     *      �ö�(Phantom read):�Ͳ����ظ�������,A�����ȡ�˼�������,��ʱB���������һЩ����,��A���Ĳ�ѯ��,���ֶ���һЩԭ�������ڵļ�¼,�ͺ���þ�һ��
     *          �ص����ڼ�¼������
     *   �������Ƶķ�ʽ:
     *      ����MVCC
     *
     *      ��:
     *          ������S: �����������ͬ�»�ȡ,������
     *          ������X: д��/��ռ��,�������������ͬʱ��ȡ
     *       �������Ŀ����Ȳ�ͬ,�ֿ��Է�Ϊ����������
     *
     *      MVCC:��汾��������,��һ�����ݻ�����汾,ͨ������Ŀɼ����������Լ�Ӧ�ÿ����İ汾,������һ��ȫ�ְ汾������
     *      ��Ϊÿһ���������ð汾��,�汾����Ψһ��
     *
     *    ����ĸ��뼶��:
     *      ��δ�ύ(read uncommitted): ��͵ļ���,������ȡ��δ�ύ�����ݱ��,���ܻᵼ�����,�ö��Ͳ����ظ���
     *      �����ύ(read committed): �����Բ��������ȡ����,������֯���,���ö��Ͳ����ظ�����Ȼ���ܷ���
     *      ���ظ���(repeatable read):����ͬһ�ֶζ�ζ�ȡ�Ľ����һ��,�������ݱ��������޸�,����ֹ����Ͳ����ظ���,���ǻö���Ȼ���ܷ���
     *      �ɴ��л�(serializable):��߸��뼶��,��ȫ����ACID�ĸ��뼶��,���Է�ʽ���,�ö��Ͳ��ؿ��ظ���
     *
     *
     * ��.��־
     *    ���InnoDB�洢����,�����¼��ֳ�����־
     *    1.slow query log ����ѯ��־
     *      ģʽ��10s,ͨ������1s�����в�ѯ���,�ڽ����SQL��ѯ��ʱ�����
     *    2.binlog ��������־
     *      ����:��¼�����ж�MySQL�ı������(����DDL��DML��,������SELECT��SHOW�ȷǱ������)��־
     *      ��С:ͨ��׷�ӵķ�ʽд��,��Сû������,��������ÿ���ļ����������,����ָ��ֵ��ʱ����γ��µ��ļ�
     *      ��ʽ:��3�����͵Ķ����Ƽ�¼��ʽ:
     *          Statementģʽ:ÿһ���޸ĵ����ݶ����¼
     *          Rowģʽ(�Ƽ�): ÿһ�еľ������¼����ᱻ��¼
     *          Mixedģʽ:�������ַ�ʽ���ģʽ
     *      ����:binlog��Ҫ�������Ӹ���,��������:
     *          1.���⽫���ݿ�仯д��binlog
     *          2.�ӿⴴ��һ��IO�߳��������������binlog
     *          3.���ⴴ��һ��binlog dump�߳�������binlog,�ӿ�IO�̸߳������
     *          4.�ӿ�IO�߳̽����ܵ�binlogд�뵽relay log��
     *          5.�ӿ��SQL�̶߳�ȡ relay logͬ��������,Ҳ������ִ��һ��
     *      ����: MySQSL��һЩͬ�����ݵ���������Դ�Ĺ��߱���Canal��Ҳ������binlog,���Լ�αװ��һ��Slave�ڵ��������ͬ��
     *          �������Ӹ�����,binlog������ʵ�����ݻָ�
     *     3.redo log ������־
     *        ��֤����ĳ־���:���ύ����ʱ, �洢���水��ˢ�̲��Խ����ˢ��������ȥ,��ʱMySQL崻���,������Ҳ�ܻظ�δ��д����̵�����,�Ӷ���֤����ĳ־���
     *        Ҳ����˵,redo log�߱��˱����ָ�������
     *
     *     binlog��redo log������
     *      1.binlog��Ҫ�������ݻ�ԭ,���ݼ���ĵĻظ�,�������Ӹ���
     *          redo log��Ҫ���ڱ�֤����־���,�������񼶱�����ݻָ�
     *       2.redo log��InnoDB���е�,binlog���������涼�е�,��Ϊ��log��MySQL��Server��ʵ�ֵ�
     *        3.redo log��������־,��Ҫ��¼ĳ��ҳ����Ӧ��,binlog�����߼���־,��Ҫ��¼���ݿ�ִ�е�����DML��DDL�޸�
     *       4.binlogͨ��׷�ӵķ�ʽд��,û�д�С����,redogͨ��ѭ����ʽд��,��С�̶�,д��ĩβʱ��ص���ͷѭ����־
     *
     *    4.undo log ������־
     *      1.��֤�����ԭ����,ÿһ������������ݵ��޸Ķ����¼��undo log��,��������Ҫ�ع���ʱ��,������undo log�����ݻָ���������ʼǰ��״̬
     *      2.undo log�����߼���־,��¼����SQL���,����һ������ִ��һ��DELETE���ʱ,undo log�ͻ��¼һ����Ӧ��INSERT ���
     *      3.����InnoDBʵ�� MVCC
     *
     *
     * ��.�Ż�
     *
     *
     *
     * Redis
     * һ.Ϊʲô��ô��
     *    1.�����ڴ�
     *    2.����Reactorģʽ��ƿ����ĸ�Ч��ʱ�䴦��ģ��,��Ҫ�ǵ��߳��¼�ѭ����IO��·����
     *    3.���ö����Ż�������������/�ṹ
     *
     * ��.��������
     *    1.���ֻ�������:String,List,Set,Hash,Zset
     *    2.������������:HyperLogLog(����ͳ��),Bitmao(λͼ),Bitfield(λ��)
     *
     * ��.�־û�����
     *    �־û�����RDB�־�,AOF�־�,���ֻ�����ַ�ʽ,
     *
     * ��.�߳�ģ��
     *    ����Reactorģʽ��ƿ����ĸ�Ч��ʱ�䴦��ģ��(Netty�ֳ�ģ��Ҳ�ǻ���Reactorģʽ)
     *    Socket    IO Multiplex
     *
     *    Socket1    Socket2
     *    Socket2 -> Socket3    ->      Event Loop    -> Task Queue -> Event Dispatcher  -> Event Processors
     *    Socket3    Socket1
     *
     *              Multi-threaded     Single-threaded
     *
     *
     * ��.Redis Sentinel: �Զ�����ת��
     *  Sentinel�ڱ�,���ṩ��д����,������Redis����,Redis2.8�汾֮�󷢲�
     *  Sentinelʵ����Redis��Ⱥ�ĸ߿���,�ڳ��Ӹ���ʵ�ֵļ�Ⱥ��,����һ��Sentinel�Ľ�ɫ���������Redis�ڵ������״̬�͹���ת��(FailOver)
     *  ��Master�ڵ���ֹ���ɶʱ��,Sentinel���Զ�ѡ��һ��Slave����ΪMaster,ȷ����Ⱥ����,����������ȫ�Զ�
     *  ��Ҫ��4������:
     *      ���: ��ؽڵ��Ƿ�����
     *      ����ת��: ��Master�ڵ���ֹ���ɶʱ��,Sentinel���Զ�ѡ��һ��Slave����ΪMaster,ȷ����Ⱥ����,����������ȫ�Զ�
     *      ֪ͨ: ֪ͨSlave�µ�master��Ϣ,�����������µ�Master,��Ϊ����Slave
     *      �����ṩ: �ͻ�������Sentinel�µ�master��ַ,�����������ת��,sentinel��֪ͨmaster������Ϣ���ͻ���
     *   ���Ҫ��֤�߿���,�ڱ����óɵ�������Ҫ��֤�������ڵ���3
     *
     *  Sentinel���ѡ���µ�Master
     *      1.slave���ȼ�,ֵԽС��Խ��,Խ�л����ΪMaster
     *      2.���ƽ���:Sentinelѡ��������������,Ҳ���Ǹ��ƽ������ĳ�ΪMaster
     *      3.����id:һ�㾭��ǰ�����־�ѡ��Master��,������slave�����ȼ��͸��ƽ���һ���Ļ�,ѡ������id��С�ĳ�ΪMaster
     *  Sentinel�����ѡ����Ⱥ�е�Leader
     *      ʹ�ù�ʶ�㷨
     *
     * ��.Redis Cluster: ��Ƭ��Ⱥ,����߲����ʹ�������
     *      Redis��Ƭ��Ⱥ���ǲ����̬redis���ڵ�master,����Щ�ڵ�֮��ƽ��,��û������֮˵,ͬʱ�����ṩ��д����
     *      �����������Ծ��ȵķֲ�����Щredisʵ����,�ͻ��˵�����ͨ��·�ɹ���ת����master��
     *    Redis��3.0֮���˳����Լ��ķ�Ƭ��Ⱥ����,֮ǰ����ʹ��codis֮��ĵ���������
     *
     *   Cluster��η�Ƭ
     *   û�в���һ���Թ�ϣ,���ǲ��ù�ϣ�۵ķ�ʽ,ÿһ����ֵ�Զ�����һ��hash slot
     *   Redis Clusterͨ����16384���ϣ��,һ��key��Ӧ���Ǹ���,��key����CRC16У����,�ٶ�16384ȡģ,�õ���Ӧhash��
     *
     *   Ϊʲô��16384?
     *   CRC-16��У������16Ϊ,�����Ͽ��Բ���,2��16�η�=65536,��redisѡ����2��14�η�=16384
     *   1.������16kռ���ڴ�
     *   2.Clusterһ����չ���ᳬ��1000��,16384��ȫ����
     *
     *
     *
     *
     *
     * kafuka
     *
     * һ.Kafka��ʲô
     *      kafuka��һ���ֲ�ʽ��ʽ����ƽ̨
     *  ����������Ӧ�ó���
     *      ��Ϣ����:����ʵʱ�����ݹܵ�,�ɿ�����ϵͳ����Ӧ�ó���֮���ȡ����
     *      ���ݴ���:����ʵʱ�����ݴ���������ת������������
     *   �������������,������
     *      ���µ�����:����ʹ�������������첽��˼��,��߿���֧��ÿ�봦��ǧ�򼶵���Ϣ
     *      ��̬ϵͳ�������޿�ƥ��:
     *
     * ��.���ĸ���
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
     * ����˹���:
     *
     * һ.����ƽ̨��Ȩ����:
     *  (App ID������Կ��App Secret���䷢AccessToken,����ÿ�ζ�Ҫ���м�Ȩ
     *
     *  ��ϸ����˵,JWT,�����еİ�ȫ��������,�ԳƼ��ܺͷǶԳƼ���,��������Щ
     *  https��ȫ����: https://hailiang.feishu.cn/wiki/ZGJXwXY3aifucbkzamqctOegnKT
     *
     *
     * ��.��������
     *  ���ڷ��η�����������Ļ���˼����ѡȡһ����׼Ԫ�أ�ͨ���������е�һ��Ԫ�أ���ͨ��һ����������ֳ��������֣�����һ���ֵ�����Ԫ��С�ڻ�׼Ԫ�أ���һ���ֵ�����Ԫ�ش��ڻ�׼Ԫ�ء�Ȼ��ݹ�ض��������ֽ�������ֱ��������������
     *  �ܵ�ʱ�临�Ӷ�Ϊ O(nlogn), ���� n ������ĳ��ȡ���ƽ������£�������������ܺܺã����ҳ��������������㷨����ѡ
     *
     * ��.Java����������(jdk������������)
     *  Java ����������ָ�����ڶ��̻߳����£�Java �е�������ݾ����̶Ⱥͳ���ʱ��������Զ�����Ϊ����������������������ܺͼ�����Դ����,Java�е�����������ͨ���漰��������״̬��ƫ�������ٵ������������������������ת�䡣
     *  1.����״̬��Unlocked����
     *      ��ʼ״̬��û�б��̳߳��С���һ���̳߳��Ի�ȡ��ʱ���������������״̬����ô���߳̽��ɹ���ȡ������������״̬������Ϊƫ������
     *  2.ƫ������Biased Locking����
     *      ��һ���߳��״η���һ��ͬ�������ʱ���Ὣ������Ϊƫ���������Ҹ��̻߳��Ϊ����ӵ���ߡ���ʱ����������̳߳��Ի�ȡͬһ������JVM���ж��Ƿ����ȡ��ƫ���������ҽ�����Ӧ�Ĵ�����ƫ����������ֻ��һ���̷߳���ͬ�����������������̼߳侺�������ҵĳ�����
     *  2.����������
     *      ����������Lightweight Locking�������ж���̷߳���ͬһ����ʱ��ƫ����������Ϊ������������������ͨ��CAS���Ƚϲ�������������ʵ�֣������ڳ��������̵߳�ջ֡�н���һ������¼��Lock Record�����洢�������ָ�롣�����߳��ڳ��Ի�ȡ����ʱ����ͨ��CAS������������������ɹ�������ȡ����������ô���߳̿��Լ���ִ�У�
     *      ���򣬽����������ȴ������������ؽ�������״̬���������ȴ��ﵽһ���������߾���ʧ��ʱ����������������Ϊ��������
     *  4.����������Heavyweight Locking����
     *      �������ȴ��ﵽһ���������߾���ʧ��ʱ����������������Ϊ��������������������ʹ�����߳�������ֱ�����������߳��ͷ���������������һ�ֱ��������ᵼ���߳�Ƶ���ؽ�������״̬������ڸ߲�����������ܿ��ܻ��ܵ�Ӱ�졣
     *
     *
     *
     * ��.Spring�������
     *
     *   #Spring��bean��������
     *   1.ʵ������Instantiation����
     *      ������׶Σ�Spring���������Bean�Ķ��崴��Bean��ʵ����ͨ������£�����ͨ�����캯�����߹���������ʵ����Bean��
     *   2.�������ã�Population����
     *      ��ʵ����֮��Spring�����Ὣ�����ļ��л���ͨ��ע�����õ�����ֵ���Լ�����ע�뵽Beanʵ���С�
     *   3.��ʼ����Initialization����
     *      ����������֮��Spring���������Bean�ĳ�ʼ����������Щ����������ʵ����InitializingBean�ӿڵ�afterPropertiesSet()����������ͨ�������ļ���ָ�����Զ����ʼ��������
     *   4.ʹ�ã�In Use����
     *      �ڳ�ʼ��֮��Bean�Ϳ��Ա�Ӧ�ó���ʹ���ˡ�������׶Σ�Bean�ṩ�����������Ĺ��ܺͷ���
     *   5.���٣�Destruction����
     *      ��Bean������Ҫ��ʱ��Spring���������Bean�����ٷ�������Щ����������ʵ����DisposableBean�ӿڵ�destroy()����������ͨ�������ļ���ָ�����Զ������ٷ�����
     *
     *   #Spring ѭ������
     *      Springѭ������������ָ����������Bean֮���໥����ʱ�����ܻᵼ��Spring�����޷���ȷ�س�ʼ����ЩBean���������������£�Spring�����޷�ȷ���ĸ�BeanӦ���ȱ�ʵ�������Ӷ�����ѭ������������
     *   ����:
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
     * ����������£���Spring�������Գ�ʼ��A��Bʱ���ᷢ��A��ҪB��ʵ������B����ҪA��ʵ�����Ӷ�����ѭ������������
     *      Spring����ṩ�˼��ֽ��ѭ����������ķ�ʽ��
     *      (1)���캯��ע�룺
     *          ʹ�ù��캯��ע����Ա���ѭ���������⣬��Ϊ���캯����Bean��ʵ�����׶α����ã�����ȷ�����е�������ϵ��Bean����ʼ��֮ǰ�Ѿ����úá�
     *      (2)Setterע�룺
     *          ����޷�ʹ�ù��캯��ע�룬����ʹ��Setter������������ע�롣Spring�������ڴ���Bean֮�󣬵���Setter����������������ϵ��
     *      (3)ʹ��@Lazyע�⣺
     *          ��ѭ�������Ƚϸ��ӻ����޷����������£����Կ���ʹ��@Lazyע���ӳٳ�ʼ��Bean���Ա���ѭ���������⡣����������Spring���������Bean��ʵ������Ȼ���ٴ���������ϵ��
     *      (4)ʹ�ô�������
     *          Spring��������ʹ�ô������������ѭ���������⡣��A��B֮�����ѭ������ʱ��Spring�������ȴ���A�Ĵ������󣬲�����ע�뵽B�У�Ȼ���ٴ���A��ʵ�ʶ������������ƹ�ѭ���������⡣
     *
     *   #Spring boot spi
     *   ����: SPI��Service Provider Interface����һ�ַ����ֻ���,��Խӿں�ʵ�ֽ��н���,ԭ���ǻ��ڲ��Һ�װ�ػ��ƵĶ�̬���ط�ʽ,����ʵ���������չ�Ͳ������
     *         SPI�������������߶���ӿڣ�Ȼ��ͨ�������ļ�����������ʽ��ע��ʵ�ָýӿڵľ����࣬�Ӷ�ʵ������ϵ������չ��
     *   ������SPI��Spring Boot�е���⣺
     *
     *   (1)����ӿڣ�
     *   public interface MyService {
     *     void doSomething();
     *  }
     *
     *  (2)��дʵ����
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
     *  (3)�����ļ�
     *      �����߿���ͨ����META-INF/servicesĿ¼�´����Խӿ�ȫ�޶���Ϊ���Ƶ��ļ������ڸ��ļ����г�ʵ�����ȫ�޶�����
     * ��Spring Boot�У�ͨ������Ҫ�ֶ�������Щ�����ļ�����ΪSpring Boot���Զ�ɨ�貢����META-INF/servicesĿ¼�µ������ļ���������ֻ��Ҫȷ��ʵ����λ��classpath�£������������ļ�����ȷ�г����ɡ�
     *
     *
     * (4)ʹ�ã�
     *  ��󣬿����߿�����Ӧ�ó�����ͨ��Spring�������ȡʵ���˸ýӿڵľ����࣬�Ӷ�ʵ����չ���ܡ�
     * @Autowired
     * private List<MyService> myServices;
     * Spring Boot���Զ�������ʵ����MyService�ӿڵ���ע�뵽myServices�б��У������߿���ֱ��ʹ����Щʵ����
     *
     * ��.Java����һ������Ĺ���
     *      1. ����أ�
     *          ��Java�����У�������Ҫ���ض����������ࡣ��Java�������JVM��������ʱ����������·�����ҵ����ļ������ص��ڴ��С�����໹û�б����أ�JVM�ͻ�ͨ�����������������ֽ����ļ������ڷ������д���һ����ʾ�����Class����
     *      2. �ڴ���䣺
     *          һ���౻���ص��ڴ��У�����������ҪΪ��������ڴ�ռ䡣��Java�У�������ڴ�������ڶ��ڴ�����ɵġ�������ʹ��`new`�ؼ��ִ���һ������ʱ��JVM���ڶ��ڴ���Ϊ�������һ���������ڴ�ռ䡣
     *      3. ʵ������
     *          �ڴ������ɺ�JVM�������Ĺ��췽������ʼ�����󡣹��췽�������ʼ�������״̬�����ԡ����û����ʽ���幹�췽����Java���ṩһ��Ĭ�ϵ��޲ι��췽������ʼ������
     *      4. �����ʼ����
     *          �ڶ���ʵ������JVM��Զ�����г�ʼ����������Զ�������Խ���Ĭ�ϳ�ʼ��������еĻ������Լ�ִ�й��췽���еĴ�������ʼ�������״̬��
     *      5. �������ã�
     *          ���Java�����е�ĳ�������������´����Ķ����������������һ�����Ա�����������ֲ�������������Ԫ�صȡ�ͨ�����������������Բ����ͷ��ʶ�������Ժͷ�����
     *      �ܵ���˵��Java����һ������Ĺ��̰�������ء��ڴ���䡢ʵ�����������ʼ���Ͷ������õȲ��衣���������Java�����г����Ĳ��������������������������Java��������л��ơ�
     *
     *
     *
     * ��.volatile��ԭ��
     *  volatile ��ԭ����ͨ���ڴ�������ʵ�ֱ����Ŀɼ��Ժͽ�ָֹ������������֤�˵�һ���߳��޸��˱�����ֵ�������߳̿��������������µ�ֵ�����ҽ�ֹ�˱������ʹ�������ָ����������򣬴Ӷ��ṩ��һ�ּ򵥶���Ч���̰߳�ȫ����
     *
     *   1. �ɼ��ԣ�Visibility����
     *      ��һ�������� volatile ����ʱ���߳��ڶ�ȡ�ñ�����ֵʱ����ֱ�Ӵ����ڴ��ж�ȡ�������Ǵ��̵߳Ĺ����ڴ��ж�ȡ��
     *      ͬ�������޸ĸñ�����ֵ�󣬻��������޸ĺ��ֵˢ�µ����ڴ��С��������Ա�֤��һ���߳��޸��˱�����ֵ�������߳̿��������������µ�ֵ���Ӷ���֤�˱����Ŀɼ��ԡ�
     *
     *   2.��ָֹ��������Prevent Reordering����
     *      volatile �ؼ��ֻ����Խ�ֹ�������ʹ�������ָ���������� Java �ڴ�ģ���У��������ʹ��������ָ������Ż����ţ�����ܻᵼ���ڶ��̻߳����³������⡣
     *      ���磬����һ����ͨ�ı��������������ܻὫд�����ͺ�����д������������������ܻᵼ�������߳̿�����һ�µ�״̬����ʹ�� volatile �ؼ������εı���������֮ǰ��д������������֮��ִ�У��Ӷ��������������⡣
     *
     *   3.�ڴ����ϣ�Memory Barriers����
     *      �� JVM �У�volatile ��ʵ��ͨ����ʹ���ڴ�������ʵ�ֿɼ��Ժͽ�ָֹ���������ڴ�������һ��Ӳ�������������ƣ�����ǿ�ƴ������ͱ�������ָ��ִ�й���������һ����˳��
     *      �� volatile �����Ķ�д����ǰ�󣬻�����Ӧ���ڴ����ϣ���ȷ�������Ŀɼ��Ժͽ�ָֹ��������
     *
     *
     * ��.�ڴ�ģ��
     * JVM��Java��������ڴ�ģ��������JavaӦ�ó�����JVM�е��ڴ���䡢ʹ�ú͹�����ʽ��JVM�ڴ�ģ�Ͱ��������¼�����Ҫ���ڴ�����
     *
     * 1. **�����������Program Counter Register��**��
     *    �����������һ���С���ڴ����������Կ����ǵ�ǰ�߳���ִ�е��ֽ�����к�ָʾ�����ڶ��̻߳����£�ÿ���̶߳����Լ������ĳ�������������ǻ������š����߳�ִ��Java����ʱ�������������¼�˵�ǰ�߳�����ִ�е��ֽ���ָ��ĵ�ַ��
     *
     * 2. **Java�����ջ��JVM Stacks��**��
     *    Java�����ջ���ڴ洢�����ľֲ��������������������ַ�������ͷ���ֵ��ÿ���̶߳����Լ�������Java�����ջ���������ڴ洢�߳�˽�е����ݡ��ڷ�������ʱ��JVMջ�ᴴ��һ��ջ֡�����ڴ洢�����ľֲ���������������ջ����̬���Ӻͷ������ص�ַ����Ϣ�����������ý���ʱ����Ӧ��ջ֡�ᱻ���١�
     *
     * 3. **���ط���ջ��Native Method Stacks��**��
     *    ���ط���ջ��Java�����ջ���ƣ���������ִ�б��أ�Native���������߳�˽�����ݡ�ÿ���̶߳����Լ������ı��ط���ջ������ִ�б��ط������á�
     *
     * 4. **Java�ѣ�Java Heap��**��
     *    Java����Java�����������һ���ڴ��������ڴ洢����ʵ��������������еĶ���ʵ�����ڶ��Ϸ����ڴ棬���������̹߳������ڴ�����
     *    Java�ѱ���Ϊ���������������ÿ�����ַ�ΪEden����Survivor����From��To������
     *
     *    ������(ռ�ȶѵ�1/3~1/4֮��)
     *      Eden��(ռ��������������70%��80%)
     *      Survivor��
     *          From Survivor�� (ռ��������������10%��15%)
     *          To Survivor�� (ռ��������������10%��15%)
     *    �����: Old Generation (ռ�ȶѵ�1/2��������)
     *    ���ô�: Perm Generation, ���ô��Ƿ�������һ���֣����ڴ洢���Ԫ���ݡ���̬�����������ص���Ϣ�����ô��Ĵ�Сͨ���ȽϹ̶����� -XX:MaxPermSize ����ָ����Ĭ��ֵΪ64MB��Ȼ�����������ô��Ĵ�С�ǹ̶��ģ����ܻᵼ���ڴ�������⣬�����Java 8��֮��İ汾�У����ô����Ƴ���ȡ����֮����Ԫ�ռ䣨Metaspace��
     *    Ԫ�ռ䣨Metaspace����Java 8�����°汾����
     *      Ԫ�ռ��Ƿ�������������������ڴ洢���Ԫ���ݡ���̬�����������ص���Ϣ�������ô���ͬ��Ԫ�ռ���ͨ�������ڴ���ʵ�ֵģ�������Ĵ�С��������JVM�����Ѵ�С�����������������ڴ�Ͳ���ϵͳ�����ơ�
     *
     *    �󲿷ֵ�Java����ᱻ��������������Eden�������������������պ󣬴��Ķ���ᱻ�Ƶ�Survivor��������Ƶ��������
     *
     *
     * 5. **��������Method Area��**��
     *    ���������ڴ洢���Ԫ���ݡ���̬�����������ص���Ϣ����HotSpot������У�������Ҳ��Ϊ���ô���Permanent Generation������Java 8 �����°汾�У����������Ƴ�������ΪԪ�ռ䣨Metaspace����Ԫ�ռ���ͨ�������ڴ���ʵ�ֵģ�������Ĵ�С��������JVM�����Ѵ�С�����������������ڴ�Ͳ���ϵͳ�����ơ�
     *
     * 6. **����ʱ�����أ�Runtime Constant Pool��**��
     *    ����ʱ�������Ƿ�������һ���֣����ڴ洢�����ڼ����ɵ��������ͷ������á���Class�ļ��еĳ����ز�ͬ������ʱ���������������ʱ��̬���ɵģ����ҿ���������ʱ��̬�����µĳ�����
     *
     * 7. **ֱ���ڴ棨Direct Memory��**��
     *    ֱ���ڴ治��JVM�淶�е�һ���֣�������Java������ڴ�ģ�͵Ĳ��䡣ֱ���ڴ���ͨ��NIO��New I/O�����е�ByteBuffer������ģ���ʹ���˲���ϵͳ�ı����ڴ����洢���ݣ�������JVM�Ķ��ڴ档ֱ���ڴ�ķ�����ͷŲ���Java�ѵĹ�������˿��Լ���Java�ѵ�ѹ��������ڴ��ʹ��Ч�ʡ�
     *
     * �ܵ���˵��JVM�ڴ�ģ��������JavaӦ�ó�����JVM�е��ڴ���䡢ʹ�ú͹�����ʽ���������˳����������Java�����ջ�����ط���ջ��Java�ѡ�������������ʱ�����غ�ֱ���ڴ�ȶ���ڴ�������Щ�ڴ�����ͬ�����Java��������ڴ�ṹ��ΪJava����������ṩ��֧�֡�
     *
     *
     * Java��������������գ�Garbage Collection����һ���Զ������ڴ�������ƣ�����������ʱ�Զ����ղ���ʹ�õ��ڴ棬�Ӷ��ͷ��ڴ���Դ�������ڴ�й©���ڴ�����ķ��ա��������ջ��Ƶ�ʵ��ͨ���������¼�����Ҫ���裺
     *
     * 1. **��ǣ�Marking��**��
     *    �������������Ȼ���ڴ��еĶ�����б�ǣ����������Ȼ���Ķ�����һ���̴Ӹ�����ʼ���ݹ��������ͼ����������ܹ������ʵ��Ķ���
     *
     * 2. **�����Sweeping��**��
     *    �ڱ�ǽ׶���ɺ�������������ɨ����е����ж��󣬲��������δ����ǵĶ�����Щδ����ǵĶ�����Ϊ�ǲ���ʹ�õģ����԰�ȫ�ػ�����ռ�õ��ڴ�ռ䡣
     *
     * 3. **ѹ����Compacting��**��
     *    ������׶���ɺ󣬿��ܻ�����ڴ���Ƭ��Ϊ�˸��õ������ڴ�ռ䣬ĳЩ��������������ڴ�ռ����ѹ���������Ķ����ƶ����ѵ�һ�ˣ��Ӷ�ʹ�ڴ�ռ���������
     *
     * Java��������������ջ����ж���ʵ�֣������˲�ͬ�����������㷨�������������������ǳ��������������㷨��������������
     *
     * 1. **���������㷨**��
     *
     *    - **���-����㷨��Mark-Sweep��**��
     *      ���-����㷨������������������㷨����ͨ����Ƕ���Ȼ�����δ����ǵĶ����������������ա����Ǳ��-����㷨���ܻ�����ڴ���Ƭ��Ӱ���ڴ�������ʡ�
     *
     *    - **�����㷨��Copying��**��
     *      �����㷨���ڴ�ռ��Ϊ���飬ÿ��ֻʹ������һ�顣��һ���ڴ�ռ�����������������Ὣ���Ķ����Ƶ���һ���ڴ�ռ��У�Ȼ�����δ�����ƵĶ��󡣸����㷨���Խ���ڴ���Ƭ���⣬��������ڴ��������½���
     *
     *    - **���-�����㷨��Mark-Compact��**��
     *      ���-�����㷨�ȱ�Ƕ���Ȼ�󽫴��Ķ����ƶ����ڴ��һ�ˣ�������δ���ƶ��Ķ��󡣱��-�����㷨���Խ���ڴ���Ƭ���⣬���Ҳ�������ڴ��������½���
     *
     * 2. **����������**��
     *
     *    - **Serial�ռ���**�������ռ�����һ�ֵ��̵߳�������������������С��Ӧ�úͿͻ���Ӧ�á���ʹ�ø����㷨�ͱ��-�����㷨�������������ա�
     *
     *    - **Parallel�ռ���**�������ռ�����һ�ֶ��̵߳������������������ڶ�˷�����Ӧ�á���ʹ�ø����㷨�ͱ��-����㷨�������������գ�������������յ�Ч�ʡ�
     *
     *    - **CMS�ռ���**��CMS��Concurrent Mark-Sweep���ռ�����һ�������ͣ��ʱ��ΪĿ��������������������ڶ���Ӧʱ���нϸ�Ҫ���Ӧ�á���ʹ�ñ��-����㷨�������������գ�ͬʱ�����ܼ���ͣ��ʱ�䡣
     *
     *    - **G1�ռ���**��G1��Garbage-First���ռ�����һ����������Ӧ�õ������������������ڴ��ڴ桢�߲�����Ӧ�á���ʹ�ñ��-�����㷨�������������գ�ͬʱͨ�������ķ�ʽ������ͣ��ʱ�䡣
     *
     * �ܵ���˵��Java��������������ջ���ͨ����ǡ������ѹ���Ȳ������Զ����ղ���ʹ�õ��ڴ棬���ͷ��ڴ���Դ�������ڴ�й©���ڴ�����ķ��ա�ͨ��ѡ����ʵ����������㷨�����������������Ը��õ����㲻ͬӦ�ó���������
     *
     *
     *
     * ��.Hashmap��ԭ��
     *  HashMap��Java����õ�һ�ּ���ʵ�֣������ڹ�ϣ��ʵ����Map�ӿڣ��ṩ�˼�ֵ�ԵĴ洢�ͼ������ܡ�������HashMap��ԭ����⣺
     *
     * 1. **���ݽṹ**��
     *    HashMap�ڲ�ʹ����һ�����飨��Ϊ��ϣ�������洢��ֵ�ԡ�ÿ������Ԫ�س�Ϊһ��Ͱ��bucket����ÿ��Ͱ�洢��һ����������������JDK8�������˺��������ͷ�ڵ㣬��Щ�ڵ�洢�˾�����ͬ��ϣֵ�ļ�ֵ�ԡ�
     *
     * 2. **��ϣ�㷨**��
     *    ��������HashMap������һ����ֵ��ʱ��HashMap��ͨ������hashCode()�����������ϣֵ��hash����Ȼ��ͨ����ϣֵ�ĸ�λ���㣨λ���㣩��ȷ���ü�ֵ���������е�λ�á�������˵��HashMap��ʹ�ù�ϣֵ�ĸ�λ��λ��Ϊ����������λ������ľ���λ�á��������ֵ����ͨ�� `(hashCode ^ (hashCode >>> 16)) & (length-1)` ������õ���
     *
     * 3. **�����ϣ��ͻ**��
     *    ���ڲ�ͬ�ļ����ܻ�����ͬ�Ĺ�ϣֵ����ᵼ�¹�ϣ��ͻ��Ϊ�˽����ϣ��ͻ��HashMapʹ�����������������洢������ͬ��ϣֵ�ļ�ֵ�ԡ�����ͻ����ʱ�������ӵļ�ֵ�Իᱻ���뵽�����������С���JDK8֮�󣬵��������ȴﵽһ����ֵ��Ĭ��Ϊ8��ʱ��������ת��Ϊ�����������߼���Ч�ʡ�
     *
     * 4. **���ݻ���**��
     *    ��HashMap�еļ�ֵ�������ﵽ������������75%���������ӣ�Ĭ��ֵΪ0.75��ʱ��HashMap��������ݲ��������ݲ����ᴴ��һ���µĸ�������飬����ԭ�����еļ�ֵ�����·��䵽�������С����ݲ�����Ҫ���¼������м��Ĺ�ϣֵ��������ȷ���������������е�λ�á�
     *
     * 5. **���ܷ���**��
     *    HashMap�ļ����������ɾ��������ʱ�临�ӶȾ�ΪO(1)���ڴ����������ܹ��ṩ�ǳ���Ч�����ܡ�Ȼ���������ϣ��ͻ������Ϊ���أ����ܻᵼ���������ȹ������Ӷ�ʹ�ü���Ч���½�����ˣ������HashMapʱ����Ҫ����ѡ��������ӣ��Լ����ڼ�������Ҫʵ�ֺ��ʵ�hashCode()�������������ٹ�ϣ��ͻ�ķ�����
     *
     * �ܵ���˵��HashMap��һ�ֻ��ڹ�ϣ��ʵ�ֵĸ�Ч�ļ�ֵ�Լ��ϣ�ͨ�������Ĺ�ϣ�㷨�������ϣ��ͻ�Ļ��ơ����ݻ��Ƶ����ṩ��Ч�Ĵ洢�ͼ������ܡ�
     *
     *
     * ��.�߳̽������
     * ���鿴 {@link A9_Thread_������� }
     *
     *
     * ʮ.MySQL
     *
     * #������̭ԭ��
     *  1. MySQL ������̭ԭ����ָ���ڴ��еĻ���ռ�ﵽһ������ʱ����Ҫ��̭һЩ�������ͷſռ���µ����ݡ�MySQL ʹ����һЩ��̭������ȷ����Щ����Ӧ�ñ���̭����Ҫ�������¼���ԭ����
     *
     *  2. LRU��Least Recently Used���������ʹ��ԭ�����������ݵ��������ʱ������̭�����δ�����ʵ����ݻᱻ��̭��
     *
     *  3. LFU��Least Frequently Used�������ʹ��ԭ�����������ݵķ��ʴ�������̭������Ƶ����͵����ݻᱻ��̭��
     *
     *  4. FIFO��First In, First Out���Ƚ��ȳ�ԭ�����������ݽ��뻺���˳������̭�����Ƚ��뻺������ݻᱻ������̭��
     *
     *  5. Random ����滻ԭ�������ѡ��һ�����ݽ�����̭��
     *
     * MySQL ʹ����Щԭ����������������Щ����Ӧ�ñ���̭���Ա��ֻ����е�����ʼ���������������õġ�ͬʱ��MySQL Ҳ�ṩ��һЩ����������ѡ�����Ż��������̭���ԣ������㲻ͬӦ�ó���������
     *
     * #����/ɾ������ҳ��ô�䶯��
     *
     * ��MySQL�У��������ɾ������ʱ���������ҳ���б䶯�������Ƕ��ڲ����ɾ������ҳ�ı䶯�����˵����
     *
     * ��������ҳ�䶯��
     * 1. ���ȣ�MySQL�����ʵ���λ���ҵ�һ�����õĿ���ҳ��Ϊ�������ݵ�λ�á�
     * 2. ��������MySQL�Ὣ����������ݰ���ָ����ҳ��ʽ������֯����д�뵽����ҳ�С�
     * 3. ������������ҳ��������MySQL�����һ���µ�����ҳ������ʣ�������д�����ҳ�С�
     * 4. �ڲ�������У�MySQL���������ص�������Ϣ���Ա�֤��������ȷ�Ժ�һ���ԡ�
     *
     * ɾ������ҳ�䶯��
     * 1. ��ִ��ɾ������ʱ��MySQL���Ǵ�ɾ���������ڵ�����ҳΪ��ɾ����ǡ�����ʾ��ҳ�е������Ѿ���Ч��
     * 2. �ں�����һЩ�����У�MySQL���⵽��Щ�����Ϊɾ��������ҳ����������ڴ��еĻ������Ƴ����ͷ��ڴ�ռ䡣
     * 3. ������һ������ʱ��MySQL�ĺ�̨���̻Ὣ��Щ�����Ϊɾ��������ҳ�Ӵ���������ɾ���������ͷŴ��̿ռ䡣
     * 4.��Ҫע����ǣ������ɾ������ҳ�ľ���ʵ�ַ�ʽ���ܻ���MySQL�İ汾�;���Ĵ洢�����������ͬ����ͬ�Ĵ洢����������Լ����ص�����ҳ�������ƣ��������ϲ����ɾ������ҳ��ԭ�������Ƶġ�
     *
     *
     * ʮһ.ϵͳ�ȶ���
     *
     *
     *
     */


}