package skid.nullable.vapetransformer;

import skid.nullable.vapetransformer.transformers.base.Transformer;

import java.io.File;
import java.util.Objects;

public class VapeTransformer {

    public void run(String[] args, Transformer[] transformers) {
        File filePath = new File("C:\\Dump\\");
        try {
            for (File file : Objects.requireNonNull(filePath.listFiles())) {
                if (file.isFile() && file.getName().endsWith(".class")) {
                    for (Transformer transformer : transformers) {
                        transformer.execute(file);
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
