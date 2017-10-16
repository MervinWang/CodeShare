package com.test.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by wanghaiyang on 2017/8/16.
 * 使用流
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        META, FISH, OTHER
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pook", false, 800, Type.META),
                new Dish("pook", true, 800, Type.META),
                new Dish("beef", false, 700, Type.META),
                new Dish("chicken", false, 400, Type.META),
                new Dish("french fires", true, 530, Type.OTHER),
                new Dish("rice", false, 350, Type.OTHER),
                new Dish("season fruit", false, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", true, 450, Type.FISH)
        );

        //filter map limit
        List<String> threeHighCaloriesDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println("filter map limit ->" + threeHighCaloriesDishNames);

        //filter map limit distinct
        threeHighCaloriesDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).distinct().collect(Collectors.toList());
        System.out.println("filter map limit distinct ->" + threeHighCaloriesDishNames);

        //filter map skip distinct
        threeHighCaloriesDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).skip(1).distinct().collect(Collectors.toList());
        System.out.println("filter map skip distinct ->" + threeHighCaloriesDishNames);

        //filter map count
        long count = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).count();
        System.out.println("filter map count ->" + count);

        //map映射
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLength = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(wordLength);

        //流的扁平化 flatMap distinct
        List<String> uniqueCharacters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(uniqueCharacters);

        //allMatch 所有都符合 类似&&操作
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        //noneMatch 有任何符合的返回false
        isHealthy = menu.stream().noneMatch(d -> d.getCalories() > 500);
        System.out.println(isHealthy);

        //anyMatch 任何一个符合条件返回true
        isHealthy = menu.stream().anyMatch(d -> d.getCalories() > 500);
        System.out.println(isHealthy);

        //Optional findAny 查找元素
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish.isPresent() ? dish : null);

        //查找元素
        List<Integer> someNumbers = Arrays.asList(1, 3, 6, 7);
        Optional<Integer> firstSQDivideByThree = someNumbers.stream().map(x -> x * x).filter(e -> e % 3 == 0).findAny();
        System.out.println(firstSQDivideByThree.isPresent() ? "findAny:" + firstSQDivideByThree.get() : "对象为空");

        //按照vegetarian为true 卡路里值进行排序正序  倒序排序
        List<Dish> dishesAsc = menu.stream().filter(e -> e.isVegetarian()).sorted(comparing(Dish::getCalories)).collect(Collectors.toList());
        List<Dish> dishesDesc = menu.stream().filter(e -> e.isVegetarian()).sorted(comparing(Dish::getCalories).reversed()).collect(Collectors.toList());
        System.out.println(dishesAsc);
        System.out.println(dishesDesc);

        //归纳
        int sum = someNumbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        sum = someNumbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce 重载方法 不接受初始值0
        Optional<Integer> sum2 = someNumbers.stream().reduce((a, b) -> a + b);
        System.out.println(sum2.get());
        //最大值 最小值
        Optional<Integer> maxsum = someNumbers.stream().reduce(Integer::max);
        Optional<Integer> minsum = someNumbers.stream().reduce(Integer::min);
        System.out.println(maxsum.get());
        System.out.println(minsum.get());

        //并行处理数据parallel之后是并行   sequential之后是串行
        Optional<Integer> moreThreadExecute = someNumbers.stream().parallel().map(x -> x * x).sequential().filter(e -> e % 2 == 0).reduce((a, b) -> a + b);
        System.out.println(moreThreadExecute.isPresent() ? moreThreadExecute.get() : "空");

        //启动线程
        Thread t = new Thread(() -> System.out.println("hello world"));
        t.start();
        System.out.println("人民币");
    }
}
