package skid.nullable.vapetransformer.transformers;

import org.objectweb.asm.ClassReader;
import skid.nullable.vapetransformer.transformers.base.Transformer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class RenameTransformer extends Transformer {
    @Override
    public void execute() {

        // Credit: 0x150

        Path dir = Path.of("C:/Dump/");
        Path output = Path.of("C:/Vape/");
        try (Stream<Path> list = Files.list(dir)) {
            List<Path> valid = list.filter(f -> Files.isRegularFile(f) && f.getFileName().toString().endsWith(".class")).toList();
            for (Path clazz : valid) {
                // Read and parse class
                byte[] bytes = Files.readAllBytes(clazz);
                ClassReader reader = new ClassReader(bytes);

                String className = reader.getClassName();

                System.out.println("Found " + className);

                Path target = output.resolve(className+".class");
                Path dirToPlaceIn = target.toAbsolutePath().normalize().getParent();

                Files.createDirectories(dirToPlaceIn);
                if (!Files.exists(target))
                    Files.copy(clazz, target);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
