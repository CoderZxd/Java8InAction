package com.zxd.java8.test.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> result = transactions.stream().filter(e->e.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(result);

        //交易员都在哪些不同的城市工作过
        List<String> citys = transactions.stream().map(e->e.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(citys);

        //查找所有来自于剑桥的交易员，并按姓名排序
       List<Transaction> results = transactions.stream().filter(e->"Cambridge".equals(e.getTrader().getCity())).sorted((a,b)->a.getTrader().getName().compareTo(b.getTrader().getName())).collect(Collectors.toList());
        System.out.println(results);

        //返回所有交易员的姓名字符串，按字母顺序排序
        String names = transactions.stream().map(e->e.getTrader().getName()).distinct().sorted((a,b)->a.compareTo(b)).reduce("",(a,b)->a+b);
        System.out.println(names);

        //有没有交易员是在米兰工作的
        boolean is = transactions.stream().anyMatch(e->"Milan".equals(e.getTrader().getCity()));
        System.out.println(is);

        //打印生活在剑桥的交易员的所有交易额
        int sum = transactions.stream().filter(e->"Cambridge".equals(e.getTrader().getCity())).map(Transaction::getValue).reduce(0,(a,b)->a+b);
        System.out.println(sum);

        //所有交易中，最高的交易额是多少
        Optional<Integer> max = transactions.stream().map(e->e.getValue()).reduce((Integer::max));
        if(max.isPresent()){
            System.out.println(max.get());
        }

        // 找到交易额最小的交易
        Optional<Transaction> re = transactions.stream().reduce((a,b)->a.getValue()>b.getValue()?b:a);
        Optional<Transaction> re2 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        if(re.isPresent()){
            System.out.println(re);
        }
        System.out.println(re2);
    }
}
