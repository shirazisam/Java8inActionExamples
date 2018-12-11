package chapter5;

import data.Dish;
import data.Menu;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


/**
 * Created by shira on 05/11/2018.
 */
public class Pythagoras {

    public static void main(String[] args) throws IOException {

        Repository<MyDoc> repository = new Repository<>();

        boolean isPythag = isPythagoras(5, 12);

        System.out.println("isPythag = " + isPythag);

        Stream<int[]> triples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> isPythagoras(a, b))
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        triples.limit(10).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

        MyPrinter myPrinter = System.out::println;
        myPrinter.ponce("shiraz");

        Pythagoras main = new Pythagoras();

        main.initDesignFiles(repository);
        main.sumTheFiles();
        Map<String, Set<MyFileObject>> files = main.getFilesByExtension();
        System.out.println("files = " + files);

        List<Dish> dishList = Menu.getMenu().stream().collect(new MyShirazCollector<>());
        System.out.println("dishList = " + dishList);
        Menu.getMenu().stream().collect(ArrayList::new, List::add, List::addAll);

        int a1 = 10;
        Runnable r1 = () -> {
            // int a1 = 9; -- compiler error
            System.out.println("hello");
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a1 = 7;
                System.out.println("xxx");
            }
        };

        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger!");
            }
        });

        doSomething((Task)() -> System.out.println("blabla"));
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }


    private static boolean isPythagoras(int a, int b) {
        return Math.sqrt(a * a + b * b) % 1 == 0;
    }

    public void initDesignFiles(Repository<MyDoc> r) throws IOException {
        listMyFiles().forEach(r::save);
    }

    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return new Supplier<Map<Boolean, List<Integer>>>() {
            @Override
            public Map<Boolean, List<Integer>> get() {
                return new HashMap<Boolean, List<Integer>>() {{
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }};
            }
        };
    }

    private void sumTheFiles() throws IOException {
        int sum = listMyFiles().stream().mapToInt(f -> f.getFilename().length()).sum();
        System.out.println("sum of all filenames = " + sum);
    }


    private List<MyDoc> listMyFiles() throws IOException {
        Path dir = Paths.get("C:\\Users\\shira\\Downloads");
        return Files.list(dir)
                .filter(f -> !Files.isDirectory(f) && f.toString().endsWith(".exe"))
                .map(f -> f.getFileName().toString())
                .sorted((s, str) -> s.compareToIgnoreCase(str))
                .map(p -> new MyDoc(IdGenerator.get(), FilenameUtils.removeExtension(p)))
                .collect(Collectors.toList());
    }

    private Map<String, Set<MyFileObject>> getFilesByExtension() throws IOException {
        Path dir = Paths.get("C:\\Users\\shira\\Downloads");
        return Files.list(dir)
                .filter(f -> !Files.isDirectory(f))
                .collect(groupingBy(f -> FilenameUtils.getExtension(f.getFileName().toString()),
                        mapping(MyFileObjectFactory::newInstance, toCollection(HashSet::new))
                ));
    }

}
