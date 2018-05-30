package com.yanming.test.jobtest;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yanming
 * @version 1.0.0
 * @description 测试job用例
 **/

/**
 * 不要用@service,在spring-job.xml中已经使用<job:simple />注册bean， 如果再次使用@service,会有2个任务。可以自测
 */
public class MySimpleJob implements SimpleJob {


    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("------%s   Thread ID: %s, 任务总片数: %s, 当前分片项: %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()),
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
        /**
         * elastic-job平均分片算法,会把片数会均匀的分布在各个实例（机器）中，从0 计数
         * 如果有3个Job实例, 分成9片, 则每个Job实例分到的分片是: 1=[0,1,2], 2=[3,4,5], 3=[6,7,8].
         * 如果有3个Job实例, 分成8片, 则每个Job实例分到的分片是: 1=[0,1,6], 2=[2,3,7], 3=[4,5].
         * 如果有3个Job实例, 分成10片, 则个Job实例分到的分片是: 1=[0,1,2,9], 2=[3,4,5], 3=[6,7,8].
         */

        //假设有任务list
        List<String> list = new ArrayList();
        list.add("aaaa415626298980");
        list.add("bbbb415626264751");
        list.add("cccc415626263552");
        list.add("dddd415626267963");
        list.add("vvvv415626269404");

        int shardingTotalCount = shardingContext.getShardingTotalCount();

        String param = shardingContext.getJobParameter();

        int shardingItem = shardingContext.getShardingItem();

        for (String s : list) {
            int lastchar = Integer.parseInt(s.substring(s.length() - 1));
            //取余，设定规则余数与当前片数相等则执行
            if (lastchar % shardingTotalCount == shardingItem) {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()) + "     " + Thread.currentThread().getId() + "  > > > >处理订单中:   " + s + "  参数：" + param);
            }
        }

        /**
         *   我们这里配置的分2片，如果是2个服务器 A B ，则假设系统分配A -->第0片   ，B -->第1 片
         *   比如上面aaaa415626298980 尾数对2取余， 得到0 ，就是在第0片时才会执行此任务。即在机器A上会执行
         *   bbbb415626264751 尾数对2取余，得到 1，在第1片数执行任务.,即在机器B上执行
         *   cccc415626263552 取余得到0   则会在机器A
         *   ......
         *   由此将上去list中的各个任务隔离。同步执行，不重复
         */

    }

//
//    @Scheduled(cron = "*/2 * * * * ?")
//    public void zhixing(){
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()) + "= = = = 自身定时任务处理:   " );
//    }
}