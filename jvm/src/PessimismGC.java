
import java.util.ArrayList;
import java.util.List;

/*
    悲观gc ——parallel scavenge
    https://blog.csdn.net/liuxiao723846/article/details/72808495/
    1、在YGC执行前，min(目前新生代已使用的大小,之前平均晋升到old的大小中的较小值) > 旧生代剩余空间大小 ? 不执行YGC，直接执行Full GC : 执行YGC；
    2、在YGC执行后，平均晋升到old的大小 > 旧生代剩余空间大小 ? 触发Full GC ： 什么都不做。

    Sun JDK之所以要有悲观策略，我猜想理由是程序最终是会以一个较为稳态的状况执行的，此时每次YGC后晋升到old的对象大小应该是差不多的，在YGC时做好检查，避免等YGC后晋升到Old的对象导致old空间不足，因此还不如干脆就直接执行FGC，正因为悲观策略的存在，大家有些时候可能会看到old空间没满但full gc执行的状况。

    Xmx和Xms不一致的时候，会导致gc次数增多

    G1GC退化

    GCeasy.io
 */
public class PessimismGC {

    public static void main(String[] args) {
        //-Xms30m -Xmx30m -Xmn10m -XX:+UseParallelGC
        List<byte[]> arrayList  = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            byte[] bytes = new byte[1024*1024*3];//3M
            arrayList.add(bytes);
        }

        arrayList.clear();
        for (int i = 0; i < 2; i++) {
            byte[] bytes = new byte[1024*1024*3];//3M
            arrayList.add(bytes);
        }
    }
}
