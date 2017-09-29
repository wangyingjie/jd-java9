package com.jd.card;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-09-07 14:05
 */
public class SequenceTest {

    private static long lastTimeStamp = -1L;
    private static long begin = 1483200000000L; //2017-01-01 00:00:00

    /**
     * 12位时间戳+6位机器id+6位hashId，高位补0
     */
    public synchronized static long genId(int serverId, long hashId) {
        if (serverId > 63 || serverId < 0) {
            throw new RuntimeException("serverId must between 0 and 63");
        }

        long timestamp = System.currentTimeMillis();
        if (timestamp < begin) {
            throw new RuntimeException("clock error!");
        }

        if (timestamp == lastTimeStamp) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        timestamp = System.currentTimeMillis();
        long seq = timestamp - begin;
        long id = (seq << 12) | (serverId << 6) | getLast(hashId, 6);
        lastTimeStamp = timestamp;
        return id;
    }

    /**
     * 12位时间戳+6位机器id，高位补0
     */
    public synchronized static long genId(int serverId) {
        if (serverId > 63 || serverId < 0) {
            throw new RuntimeException("serverId must between 0 and 63");
        }

        long timestamp = System.currentTimeMillis();
        if (timestamp < begin) {
            throw new RuntimeException("clock error!");
        }

        if (timestamp == lastTimeStamp) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        timestamp = System.currentTimeMillis();
        long seq = timestamp - begin;

        long id = (seq << 6) | serverId;
        lastTimeStamp = timestamp;

        return id;
    }


    /**
     * 获取最后N位整数
     */
    private static int getLast(long hashId, int last) {
        return (int) (hashId & (~(-1L << last)));
    }


    public static void main(String[] args) {

        System.out.println(-1L << 6);
        System.out.println(~(-1L << 6));
        System.out.println(getLast(1234567890L, 6));

        System.out.println(getHashcode("123123123"));

        long userid = 32593588895500L;
        int machineNo = 1;
        long id = genId(machineNo, userid);
        System.out.println(id);

        Integer totalPrice = 0;
        Integer price = null;// 待确认 价格
        totalPrice += price;

    }


    public static int getHashcode(String str) {
        int hash1 = 5381;
        int hash2 = hash1;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int c = str.charAt(i);
            hash1 = (hash1 << 5) + hash1 ^ c;
            i++;
            if (i >= len) {
                break;
            }
            c = str.charAt(i);
            hash2 = (hash2 << 5) + hash2 ^ c;
        }
        return hash1 + hash2 * 1566083941;
    }
}